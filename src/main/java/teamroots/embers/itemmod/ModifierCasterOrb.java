package teamroots.embers.itemmod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import teamroots.embers.entity.EntityEmberProjectile;
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

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
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
        handleCast(event.getEntityPlayer(), event.getWorld(), event.getItemStack(), cost);
    }

    @SubscribeEvent
    public void onSwing(PlayerInteractEvent.LeftClickEmpty event) {
        handleCast(event.getEntityPlayer(), event.getWorld(), event.getItemStack(), cost);
    }

    public static void handleCast(EntityPlayer player, World world, ItemStack modStack, double cost) {
        if (world.isRemote)
            return;

        if (prevCooledStrength == 1.0f) {
            if (ItemModUtil.hasHeat(modStack)) {
                int level = ItemModUtil.getModifierLevel(modStack, ItemModUtil.modifierRegistry.get(RegistrarEmbersItems.CASTER_ORB).name);

                if (level > 0 && EmberInventoryUtil.getEmberTotal(player) > cost && cooldownTicks == 0) {
                    float offX = 0.5F * (float) Math.sin(Math.toRadians(-player.rotationYaw - 90));
                    float offZ = 0.5F * (float) Math.cos(Math.toRadians(-player.rotationYaw - 90));

                    double posX = player.posX + offX;
                    double posY = player.posY + player.getEyeHeight();
                    double posZ = player.posZ + offZ;
                    if (!world.isBlockLoaded(new BlockPos(posX, posY, posZ)))
                        return;

                    double motionX = player.getLookVec().x * 0.5F;
                    double motionY = player.getLookVec().y * 0.5F;
                    double motionZ = player.getLookVec().z * 0.5F;
                    double size = 8.0F * (Math.atan(0.6F * level) / 1.25F);
                    EntityEmberProjectile projectile = new EntityEmberProjectile(world);
                    projectile.initCustom(posX, posY, posZ, motionX, motionY, motionZ, size, player.getGameProfile().getId());
                    world.spawnEntity(projectile);

                    cooldownTicks = 20;
                }
            }
        }
    }
}
