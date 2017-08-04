package teamroots.embers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import teamroots.embers.block.IDial;
import teamroots.embers.gui.GuiCodex;
import teamroots.embers.item.IEmberChargedTool;
import teamroots.embers.item.ItemAshenCloak;
import teamroots.embers.item.ItemEmberGauge;
import teamroots.embers.item.ItemGrandhammer;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.client.MessageEmberBurstFX;
import teamroots.embers.network.message.client.MessageEmberGenOffset;
import teamroots.embers.network.message.client.MessageTEUpdate;
import teamroots.embers.network.message.client.MessageTyrfingBurstFX;
import teamroots.embers.proxy.ClientProxy;
import teamroots.embers.registry.RegistrarEmbers;
import teamroots.embers.registry.RegistrarEmbersItems;
import teamroots.embers.research.ResearchBase;
import teamroots.embers.util.*;
import teamroots.embers.world.EmberWorldData;

import java.util.*;
import java.util.Map.Entry;

public class EventManager {
    public static boolean hasRenderedParticles = false;
    public static float emberEyeView = 0;
    public static ResearchBase lastResearch = null;
    public static float frameTime = 0;
    public static float frameCounter = 0;
    public static long prevTime = 0;
    public static EnumHand lastHand = EnumHand.MAIN_HAND;
    public static float starlightRed = 255;
    public static float starlightGreen = 32;
    public static float starlightBlue = 255;
    public static float tickCounter = 0;
    public static double currentEmber = 0;
    public static boolean allowPlayerRenderEvent = true;
    public static int ticks = 0;
    public static float prevCooledStrength = 0;
    public static boolean acceptUpdates = true;
    public static Map<BlockPos, TileEntity> toUpdate = new HashMap<BlockPos, TileEntity>();
    public static Map<BlockPos, TileEntity> overflow = new HashMap<BlockPos, TileEntity>();
    static EntityPlayer clientPlayer = null;
    double gaugeAngle = 0;
    Random random = new Random();

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTextureStitchPre(TextureStitchEvent.Pre event) {
        FluidTextureUtil.initTextures(event.getMap());
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent event) {
        ResourceLocation particleGlow = new ResourceLocation("embers:entity/particle_mote");
        event.getMap().registerSprite(particleGlow);
        ResourceLocation particleSparkle = new ResourceLocation("embers:entity/particle_star");
        event.getMap().registerSprite(particleSparkle);
        ResourceLocation particleSmoke = new ResourceLocation("embers:entity/particle_smoke");
        event.getMap().registerSprite(particleSmoke);
    }

    @SubscribeEvent
    public void onServerTick(WorldTickEvent event) {
        if (event.world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            if (Misc.random.nextInt(400) == 0) {
                EmberGenUtil.offX++;
                EmberWorldData.get(event.world).markDirty();
            }
            if (Misc.random.nextInt(400) == 0) {
                EmberGenUtil.offZ++;
                EmberWorldData.get(event.world).markDirty();
            }
            PacketHandler.INSTANCE.sendToAll(new MessageEmberGenOffset(EmberGenUtil.offX, EmberGenUtil.offZ));
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingHurtEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            String source = event.getSource().getDamageType();
            if (source.compareTo("mob") != 0 && source.compareTo("generic") != 0 && source.compareTo("player") != 0 && source.compareTo("arrow") != 0) {
                if (!player.getHeldItemMainhand().isEmpty()) {
                    if (player.getHeldItemMainhand().getItem() == RegistrarEmbersItems.INFLICTOR_GEM&& player.getHeldItemMainhand().hasTagCompound()) {
                        player.getHeldItemMainhand().setItemDamage(1);
                        player.getHeldItemMainhand().getTagCompound().setString("type", event.getSource().getDamageType());
                    }
                }
                if (!player.getHeldItemOffhand().isEmpty()) {
                    if (player.getHeldItemOffhand().getItem() == RegistrarEmbersItems.INFLICTOR_GEM&& player.getHeldItemOffhand().hasTagCompound()) {
                        player.getHeldItemOffhand().setItemDamage(1);
                        player.getHeldItemOffhand().getTagCompound().setString("type", event.getSource().getDamageType());
                    }
                }
            }
        }
        if (!event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() &&
                !event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() &&
                !event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() &&
                !event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty()) {
            if (event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemAshenCloak &&
                    event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemAshenCloak &&
                    event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemAshenCloak &&
                    event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemAshenCloak) {
                float mult = Math.max(0, 1.0f - ItemAshenCloak.getDamageMultiplier(event.getSource(), event.getEntityLiving().getItemStackFromSlot(EntityEquipmentSlot.CHEST)));
                if (mult == 0) {
                    event.setCanceled(true);
                }
                event.setAmount(event.getAmount() * mult);
            }
        }
        for (ItemStack s : event.getEntityLiving().getEquipmentAndArmor()) {
            if (s.getItem() instanceof ItemArmor) {
                if (ItemModUtil.hasHeat(s)) {
                    ItemModUtil.addHeat(s, 5.0f);
                }
            }
        }
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer damager = (EntityPlayer) event.getSource().getTrueSource();
            ItemStack s = damager.getHeldItemMainhand();
            if (!s.isEmpty()) {
                if (ItemModUtil.hasHeat(s)) {
                    ItemModUtil.addHeat(s, 1.0f);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onGameOverlayRender(RenderGameOverlayEvent.Post e) {
        if (e.getType() == ElementType.TEXT) {
            EventManager.frameCounter++;
            EventManager.frameTime = (System.nanoTime() - prevTime) / 1000000000.0f;
            EventManager.prevTime = System.nanoTime();
        }
        EntityPlayer player = Minecraft.getMinecraft().player;
        boolean showBar = false;

        int w = e.getResolution().getScaledWidth();
        int h = e.getResolution().getScaledHeight();

        int x = w / 2;
        int y = h / 2;
        if (!player.getHeldItemMainhand().isEmpty()) {
            if (player.getHeldItemMainhand().getItem() instanceof ItemEmberGauge) {
                showBar = true;
            }
        }
        if (!player.getHeldItemOffhand().isEmpty()) {
            if (player.getHeldItemOffhand().getItem() instanceof ItemEmberGauge) {
                showBar = true;
            }
        }

        Tessellator tess = Tessellator.getInstance();
        BufferBuilder b = tess.getBuffer();
        if (showBar) {
            World world = player.getEntityWorld();
            if (e.getType() == ElementType.TEXT) {
                GlStateManager.disableDepth();
                GlStateManager.disableCull();
                GlStateManager.pushMatrix();
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("embers:textures/gui/ember_meter_overlay.png"));
                GlStateManager.color(1f, 1f, 1f, 1f);

                int offsetX = 0;

                b.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                RenderUtil.drawQuadGui(b, 0, x - 16, y - 4, x + 16, y - 4, x + 16, y - 36, x - 16, y - 36, 0, 0, 1, 1);
                tess.draw();

                double angle = 195.0;
                EmberWorldData data = EmberWorldData.get(world);
                if (player != null) {
                    //if (data.emberData != null){
                    //if (data.emberData.containsKey(""+((int)player.posX) / 16 + " " + ((int)player.posZ) / 16)){
                    double ratio = EmberGenUtil.getEmberDensity(world.getSeed(), player.getPosition().getX(), player.getPosition().getZ());
                    if (gaugeAngle == 0) {
                        gaugeAngle = 165.0 + 210.0 * ratio;
                    } else {
                        gaugeAngle = gaugeAngle * 0.99 + 0.01 * (165.0 + 210.0 * ratio);
                    }
                    //}
                    //}
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("embers:textures/gui/ember_meter_pointer.png"));
                GlStateManager.translate(x, y - 20, 0);
                GlStateManager.rotate((float) gaugeAngle, 0, 0, 1);
                b.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                RenderUtil.drawQuadGui(b, 0.0, -2.5f, 13.5f, 13.5f, 13.5f, 13.5f, -2.5f, -2.5f, -2.5f, 0, 0, 1, 1);
                tess.draw();

                GlStateManager.popMatrix();
                GlStateManager.enableCull();
                GlStateManager.enableDepth();
            }
        }
        World world = player.getEntityWorld();
        RayTraceResult result = player.rayTrace(6.0, e.getPartialTicks());

        if (result != null) {
            if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
                IBlockState state = world.getBlockState(result.getBlockPos());
                if (state.getBlock() instanceof IDial) {
                    List<String> text = ((IDial) state.getBlock()).getDisplayInfo(world, result.getBlockPos(), state);
                    for (int i = 0; i < text.size(); i++) {
                        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text.get(i), x - Minecraft.getMinecraft().fontRenderer.getStringWidth(text.get(i)) / 2, y + 40 + 11 * i, 0xFFFFFF);
                    }
                }
            }
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("minecraft:textures/gui/icons.png"));
        GlStateManager.enableDepth();
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.side == Side.CLIENT && event.phase == TickEvent.Phase.START) {
            ticks++;
            ClientProxy.particleRenderer.updateParticles();

            EntityPlayer player = Minecraft.getMinecraft().player;
            if (player != null) {
                World world = player.getEntityWorld();
                RayTraceResult result = player.rayTrace(6.0, Minecraft.getMinecraft().getRenderPartialTicks());
                if (result != null) {
                    if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
                        IBlockState state = world.getBlockState(result.getBlockPos());
                        if (state.getBlock() instanceof IDial) {
                            ((IDial) state.getBlock()).updateTEData(world, state, result.getBlockPos());
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onPlayerRender(RenderPlayerEvent.Pre event) {
        if (event.getEntityPlayer() != null) {
            if (Minecraft.getMinecraft().inGameHasFocus || event.getEntityPlayer().getUniqueID().compareTo(Minecraft.getMinecraft().player.getUniqueID()) != 0) {
                event.setCanceled(!allowPlayerRenderEvent);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onEntityDamaged(LivingHurtEvent event) {
        if (event.getSource().damageType.equals(RegistrarEmbers.DAMAGE_EMBER.damageType)) {
            if (event.getEntityLiving().isPotionActive(MobEffects.FIRE_RESISTANCE)) {
                event.setAmount(event.getAmount() * 0.5f);
            }
        }
        if (event.getSource().getTrueSource() != null) {
            if (event.getSource().getTrueSource() instanceof EntityPlayer) {
                if (((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand().getItem() == RegistrarEmbersItems.TYRFING) {
                    if (!event.getEntity().world.isRemote) {
                        PacketHandler.INSTANCE.sendToAll(new MessageTyrfingBurstFX(event.getEntity().posX, event.getEntity().posY + event.getEntity().height / 2.0f, event.getEntity().posZ));
                    }
                    EntityPlayer p = ((EntityPlayer) event.getSource().getTrueSource());
                    event.setAmount((event.getAmount() / 4.0f) * (4.0f + (float) event.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue() * 1.0f));
                }
                if (!((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand().isEmpty()) {
                    if (((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand().getItem() instanceof IEmberChargedTool) {
                        if (((IEmberChargedTool) ((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand().getItem()).hasEmber(((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand()) || ((EntityPlayer) event.getSource().getTrueSource()).capabilities.isCreativeMode) {
                            event.getEntityLiving().setFire(1);
                            if (!event.getEntityLiving().getEntityWorld().isRemote) {
                                PacketHandler.INSTANCE.sendToAll(new MessageEmberBurstFX(event.getEntityLiving().posX, event.getEntityLiving().posY + event.getEntityLiving().getEyeHeight() / 1.5, event.getEntityLiving().posZ));
                                ((EntityPlayer) event.getSource().getTrueSource()).getHeldItemMainhand().getTagCompound().setBoolean("didUse", true);
                            }
                        } else {
                            event.setCanceled(true);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() != null) {
            if (!event.getPlayer().getHeldItemMainhand().isEmpty()) {
                ItemStack s = event.getPlayer().getHeldItemMainhand();
                if (!s.isEmpty() && event.getState().getBlockHardness(event.getWorld(), event.getPos()) > 0) {
                    if (ItemModUtil.hasHeat(s)) {
                        ItemModUtil.addHeat(s, 1.0f);
                    }
                }
                /*if (event.getPlayer().getHeldItemMainhand().getItem() instanceof IEmberChargedTool){
					PacketHandler.INSTANCE.sendToAll(new MessageEmberBurstFX(event.getPos().getX()+0.5,event.getPos().getY()+0.5,event.getPos().getZ()+0.5));
				}*/
                if (event.getPlayer().getHeldItemMainhand().getItem() instanceof ItemGrandhammer) {
                    event.setCanceled(true);
                    event.getWorld().setBlockToAir(event.getPos());
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event) {
        if (ItemModUtil.hasHeat(event.getItemStack())) {
            event.getToolTip().add("");
            if (ItemModUtil.hasHeat(event.getItemStack())) {
                if (ItemModUtil.getLevel(event.getItemStack()) > 0) {
                    event.getToolTip().add("");
                }
            }
            event.getToolTip().add("                        ");
            if (ItemModUtil.hasHeat(event.getItemStack())) {
                if (event.getItemStack().getTagCompound().getCompoundTag(ItemModUtil.HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND).tagCount() > 1) {
                    event.getToolTip().add(TextFormatting.GRAY + I18n.format("embers.tooltip.modifiers"));
                    int c = event.getItemStack().getTagCompound().getCompoundTag(ItemModUtil.HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND).tagCount();
                    for (int i = 0; i < c - 1; i++) {
                        event.getToolTip().add("");
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTooltipRender(RenderTooltipEvent.PostText event) {
        if (!event.getStack().isEmpty()) {
            if (ItemModUtil.hasHeat(event.getStack())) {
                for (int i = 0; i < event.getLines().size(); i++) {
                    if (event.getLines().get(i).compareTo(TextFormatting.GRAY + "" + TextFormatting.GRAY + I18n.format("embers.tooltip.modifiers")) == 0) {
                        List<String> modifiers = new ArrayList<String>();
                        NBTTagList l = event.getStack().getTagCompound().getCompoundTag(ItemModUtil.HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
                        for (int j = 0; j < l.tagCount(); j++) {
                            if (l.getCompoundTagAt(j).getString("name").compareTo(ItemModUtil.modifierRegistry.get(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE).name) != 0) {
                                modifiers.add(l.getCompoundTagAt(j).getString("name"));
                            }
                        }
                        GlStateManager.disableDepth();
                        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
                        if (ItemModUtil.getLevel(event.getStack()) > 0) {
                            GlStateManager.enableBlend();
                            GlStateManager.enableAlpha();
                            int func = GL11.glGetInteger(GL11.GL_ALPHA_TEST_FUNC);
                            float ref = GL11.glGetFloat(GL11.GL_ALPHA_TEST_REF);
                            GlStateManager.alphaFunc(GL11.GL_ALWAYS, 0);
                            for (int j = 0; j < modifiers.size(); j++) {
                                GuiCodex.drawTextGlowingAura(event.getFontRenderer(), I18n.format("embers.tooltip.modifier." + modifiers.get(j)) + " " + I18n.format("embers.tooltip.num" + ItemModUtil.getModifierLevel(event.getStack(), modifiers.get(j))), event.getX(), event.getY() + (event.getFontRenderer().FONT_HEIGHT + 1) * (i + j + 1) + 2);
                            }
                            GlStateManager.alphaFunc(func, ref);
                            GlStateManager.disableAlpha();
                            GlStateManager.disableBlend();
                        }
                    }
                    if (event.getLines().get(i).compareTo(TextFormatting.GRAY + "                        ") == 0) {
                        GlStateManager.disableDepth();
                        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
                        if (ItemModUtil.getLevel(event.getStack()) > 0) {
                            event.getFontRenderer().drawStringWithShadow(TextFormatting.GRAY + I18n.format("embers.tooltip.heat_level"), event.getX(), event.getY() + (event.getFontRenderer().FONT_HEIGHT + 1) * (i - 1) + 2, 0xFFFFFFFF);
                            int level_x = event.getFontRenderer().getStringWidth(I18n.format("embers.tooltip.heat_level")) + 2;
                            GlStateManager.enableBlend();
                            GlStateManager.enableAlpha();
                            int func = GL11.glGetInteger(GL11.GL_ALPHA_TEST_FUNC);
                            float ref = GL11.glGetFloat(GL11.GL_ALPHA_TEST_REF);
                            GlStateManager.alphaFunc(GL11.GL_ALWAYS, 0);
                            GuiCodex.drawTextGlowingAura(event.getFontRenderer(), "" + ItemModUtil.getLevel(event.getStack()), event.getX() + level_x, event.getY() + (event.getFontRenderer().FONT_HEIGHT + 1) * (i - 1) + 2);
                            GlStateManager.alphaFunc(func, ref);
                            GlStateManager.disableAlpha();
                            GlStateManager.disableBlend();
                        }
                        event.getFontRenderer().drawStringWithShadow(TextFormatting.GRAY + I18n.format("embers.tooltip.heat_amount"), event.getX(), event.getY() + (event.getFontRenderer().FONT_HEIGHT + 1) * i + 2, 0xFFFFFFFF);
                        double x = event.getFontRenderer().getStringWidth(I18n.format("embers.tooltip.heat_amount")) + 1.0;
                        double w = event.getFontRenderer().getStringWidth("                        ");
                        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("embers:textures/gui/heat_bar.png"));
                        Tessellator tess = Tessellator.getInstance();
                        BufferBuilder b = tess.getBuffer();
                        GlStateManager.disableTexture2D();
                        GlStateManager.enableAlpha();
                        int func = GL11.glGetInteger(GL11.GL_ALPHA_TEST_FUNC);
                        float ref = GL11.glGetFloat(GL11.GL_ALPHA_TEST_REF);
                        GlStateManager.alphaFunc(GL11.GL_ALWAYS, 0);
                        GlStateManager.enableBlend();
                        double baseX = event.getX();
                        double baseY = event.getY() + (event.getFontRenderer().FONT_HEIGHT + 1) * i + 2;
                        GlStateManager.shadeModel(GL11.GL_SMOOTH);
                        b.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
                        double x1 = baseX + x + 4;
                        double x2 = baseX + w - 3;
                        x2 = x1 + (x2 - x1) * (ItemModUtil.getHeat(event.getStack()) / ItemModUtil.getMaxHeat(event.getStack()));
                        for (double j = 0; j < 10; j++) {
                            double coeff = j / 10.0;
                            double coeff2 = (j + 1.0) / 10.0;
                            for (double k = 0; k < 4; k += 0.5) {
                                float thick = (float) (k / 4.0);
                                RenderUtil.drawColorRectBatched(b, x1 * (1.0 - coeff) + x2 * (coeff), baseY + k, 0, ((x2 - x1) / 10.0), 8.0 - 2.0 * k,
                                        1.0f, 0.25f, 0.0625f, Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff) + x2 * (coeff))), 4 * (int) (baseY + k))),
                                        1.0f, 0.25f, 0.0625f, Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff2) + x2 * (coeff2))), 4 * (int) (baseY + k))),
                                        1.0f, 0.25f, 0.0625f, Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff2) + x2 * (coeff2))), 4 * (int) (baseY + (8.0 - k)))),
                                        1.0f, 0.25f, 0.0625f, Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff) + x2 * (coeff))), 4 * (int) (baseY + (8.0 - k)))));
                            }
                        }
                        x1 = baseX + x + 4;
                        x2 = baseX + w - 3;
                        double point = x1 + (x2 - x1) * (ItemModUtil.getHeat(event.getStack()) / ItemModUtil.getMaxHeat(event.getStack()));

                        for (double k = 0; k < 4; k += 0.5) {
                            float thick = (float) (k / 4.0);
                            RenderUtil.drawColorRectBatched(b, point, baseY + k, 0, Math.min((x2 - point), ((x2 - x1) / 10.0)), 8.0 - 2.0 * k,
                                    1.0f, 0.25f, 0.0625f, 1.0f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (point)), 4 * (int) (baseY + k))),
                                    0.25f, 0.0625f, 0.015625f, 0.0f,
                                    0.25f, 0.0625f, 0.015625f, 0.0f,
                                    1.0f, 0.25f, 0.0625f, 1.0f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (point)), 4 * (int) (baseY + (8.0 - k)))));
                        }
                        tess.draw();
                        b.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
                        x1 = baseX + x + 4;
                        x2 = baseX + w - 3;
                        x1 = x2 - (x2 - x1) * (1.0f - (ItemModUtil.getHeat(event.getStack()) / ItemModUtil.getMaxHeat(event.getStack())));
                        for (double j = 0; j < 10; j++) {
                            double coeff = j / 10.0;
                            double coeff2 = (j + 1.0) / 10.0;
                            for (double k = 0; k < 4; k += 0.5) {
                                float thick = (float) (k / 4.0);
                                RenderUtil.drawColorRectBatched(b, x1 * (1.0 - coeff) + x2 * (coeff), baseY + k, 0, ((x2 - x1) / 10.0), 8.0 - 2.0 * k,
                                        0.25f, 0.0625f, 0.015625f, 0.75f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff) + x2 * (coeff))), 4 * (int) (baseY + k))),
                                        0.25f, 0.0625f, 0.015625f, 0.75f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff2) + x2 * (coeff2))), 4 * (int) (baseY + k))),
                                        0.25f, 0.0625f, 0.015625f, 0.75f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff2) + x2 * (coeff2))), 4 * (int) (baseY + (8.0 - k)))),
                                        0.25f, 0.0625f, 0.015625f, 0.75f * Math.min(1.0f, thick * 0.25f + thick * EmberGenUtil.getEmberDensity(6, (int) (ticks * 12 + 4 * (x1 * (1.0 - coeff) + x2 * (coeff))), 4 * (int) (baseY + (8.0 - k)))));
                            }
                        }
                        tess.draw();
                        GlStateManager.shadeModel(GL11.GL_FLAT);
                        GlStateManager.enableTexture2D();
                        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
                        GlStateManager.alphaFunc(func, ref);
                        b.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                        RenderUtil.drawTexturedModalRectBatched(b, (int) (baseX + x + 1), (int) baseY - 1, 0, 0, 0, 0.5, 0.625, 8, 10);
                        RenderUtil.drawTexturedModalRectBatched(b, (int) (baseX + w - 8), (int) baseY - 1, 0, 0.5, 0, 1.0, 0.625, 8, 10);
                        //Gui.drawRect(event.getX()+x+1, event.getY()+(event.getFontRenderer().FONT_HEIGHT+1)*i+2, event.getX()+w, event.getY()+(event.getFontRenderer().FONT_HEIGHT+1)*i+event.getFontRenderer().FONT_HEIGHT, (0xFF << 24)+Misc.intColor(255/2, 32+(int)(32*sine), 8));
                        //Gui.drawRect(event.getX()+x, event.getY()+(event.getFontRenderer().FONT_HEIGHT+1)*i+1, event.getX()+w-1, event.getY()+(event.getFontRenderer().FONT_HEIGHT+1)*i+event.getFontRenderer().FONT_HEIGHT-1, (0xFF << 24)+Misc.intColor(255, 64+(int)(64*sine), 16));
                        tess.draw();
                        GlStateManager.disableBlend();
                        GlStateManager.disableAlpha();
                        GlStateManager.enableDepth();
                    }
                }
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onRenderAfterWorld(RenderWorldLastEvent event) {
        tickCounter++;
        if (Embers.proxy instanceof ClientProxy) {
            GlStateManager.pushMatrix();
            ClientProxy.particleRenderer.renderParticles(clientPlayer, event.getPartialTicks());
            GlStateManager.popMatrix();
        }
    }

    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (!event.world.isRemote && event.phase == TickEvent.Phase.END) {
            NBTTagList list = new NBTTagList();
            acceptUpdates = false;
            TileEntity[] updateArray = toUpdate.values().toArray(new TileEntity[0]);
            acceptUpdates = true;
            for (Entry<BlockPos, TileEntity> e : overflow.entrySet()) {
                toUpdate.put(e.getKey(), e.getValue());
            }
            overflow.clear();
            for (TileEntity t : updateArray) {
                list.appendTag(t.getUpdateTag());
            }
            if (!list.hasNoTags()) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setTag("data", list);
                PacketHandler.INSTANCE.sendToAll(new MessageTEUpdate(tag));
            }
            toUpdate.clear();
        }
    }

    public static void markTEForUpdate(BlockPos pos, TileEntity tile) {
        if (!tile.getWorld().isRemote && acceptUpdates) {
            if (!toUpdate.containsKey(pos)) {
                toUpdate.put(pos, tile);
            } else {
                toUpdate.replace(pos, tile);
            }
        } else if (!tile.getWorld().isRemote) {
            if (!overflow.containsKey(pos)) {
                overflow.put(pos, tile);
            } else {
                overflow.replace(pos, tile);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void drawScaledCustomSizeModalRect(double x, double y, float u, float v, float uWidth, float vHeight, double width, double height, float tileWidth, float tileHeight) {
        float f = 1.0F / tileWidth;
        float f1 = 1.0F / tileHeight;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder BufferBuilder = tessellator.getBuffer();
        BufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        BufferBuilder.pos(x, y + height, 0.0D).tex((double) (u * f), (double) ((v + vHeight) * f1)).endVertex();
        BufferBuilder.pos(x + width, y + height, 0.0D).tex((double) ((u + uWidth) * f), (double) ((v + vHeight) * f1)).endVertex();
        BufferBuilder.pos(x + width, y, 0.0D).tex((double) ((u + uWidth) * f), (double) (v * f1)).endVertex();
        BufferBuilder.pos(x, y, 0.0D).tex((double) (u * f), (double) (v * f1)).endVertex();
        tessellator.draw();
    }
}
