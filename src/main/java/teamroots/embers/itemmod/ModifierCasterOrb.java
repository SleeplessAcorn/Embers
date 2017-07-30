package teamroots.embers.itemmod;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.MessageRemovePlayerEmber;
import teamroots.embers.network.message.MessageSpawnEmberProj;
import teamroots.embers.registry.RegistrarEmbersItems;
import teamroots.embers.util.EmberInventoryUtil;
import teamroots.embers.util.ItemModUtil;

public class ModifierCasterOrb extends ModifierBase {

    public static float prevCooledStrength = 0;
    public static float cooldownTicks = 0;
    public ModifierCasterOrb() {
        super(EnumType.TOOL, "caster_orb", 2.0, true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (Minecraft.getMinecraft().player != null) {
                prevCooledStrength = Minecraft.getMinecraft().player.getCooledAttackStrength(0);
            }
            if (cooldownTicks > 0) {
                cooldownTicks--;
            }
        }
    }

    @SubscribeEvent
    public void onSwing(PlayerInteractEvent.LeftClickBlock event) {
        ItemStack s = event.getItemStack();
        if (prevCooledStrength == 1.0f) {
            if (ItemModUtil.hasHeat(s)) {
                int level = ItemModUtil.getModifierLevel(s, ItemModUtil.modifierRegistry.get(RegistrarEmbersItems.CASTER_ORB).name);
                if (event.getWorld().isRemote && level > 0 && EmberInventoryUtil.getEmberTotal(event.getEntityPlayer()) > cost && cooldownTicks == 0) {
                    float offX = 0.5f * (float) Math.sin(Math.toRadians(-event.getEntityPlayer().rotationYaw - 90));
                    float offZ = 0.5f * (float) Math.cos(Math.toRadians(-event.getEntityPlayer().rotationYaw - 90));
                    PacketHandler.INSTANCE.sendToServer(new MessageRemovePlayerEmber(event.getEntityPlayer().getUniqueID(), cost));
                    PacketHandler.INSTANCE.sendToServer(new MessageSpawnEmberProj(event.getEntityPlayer().posX + offX, event.getEntityPlayer().posY + event.getEntityPlayer().getEyeHeight(), event.getEntityPlayer().posZ + offZ,
                            0.5 * event.getEntityPlayer().getLookVec().x, 0.5 * event.getEntityPlayer().getLookVec().y, 0.5 * event.getEntityPlayer().getLookVec().z,
                            8.0 * (Math.atan(0.6 * (level)) / (1.25))));
                    cooldownTicks = 20;
                }
            }
        }
    }

    @SubscribeEvent
    public void onSwing(PlayerInteractEvent.LeftClickEmpty event) {
        ItemStack s = event.getItemStack();
        if (prevCooledStrength == 1.0f) {
            if (ItemModUtil.hasHeat(s)) {
                int level = ItemModUtil.getModifierLevel(s, ItemModUtil.modifierRegistry.get(RegistrarEmbersItems.CASTER_ORB).name);
                if (event.getWorld().isRemote && level > 0 && EmberInventoryUtil.getEmberTotal(event.getEntityPlayer()) > cost && cooldownTicks == 0) {
                    float offX = 0.5f * (float) Math.sin(Math.toRadians(-event.getEntityPlayer().rotationYaw - 90));
                    float offZ = 0.5f * (float) Math.cos(Math.toRadians(-event.getEntityPlayer().rotationYaw - 90));
                    PacketHandler.INSTANCE.sendToServer(new MessageRemovePlayerEmber(event.getEntityPlayer().getUniqueID(), cost));
                    PacketHandler.INSTANCE.sendToServer(new MessageSpawnEmberProj(event.getEntityPlayer().posX + offX, event.getEntityPlayer().posY + event.getEntityPlayer().getEyeHeight(), event.getEntityPlayer().posZ + offZ,
                            0.5 * event.getEntityPlayer().getLookVec().x, 0.5 * event.getEntityPlayer().getLookVec().y, 0.5 * event.getEntityPlayer().getLookVec().z,
                            8.0 * (Math.atan(0.6 * (level)) / (1.25))));
                    cooldownTicks = 20;
                }
            }
        }
    }
}
