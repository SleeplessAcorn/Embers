package teamroots.embers.itemmod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.network.message.MessageFlameShieldFX;
import teamroots.embers.registry.RegistrarEmbers;
import teamroots.embers.registry.RegistrarEmbersItems;
import teamroots.embers.util.EmberInventoryUtil;
import teamroots.embers.util.ItemModUtil;

public class ModifierFlameBarrier extends ModifierBase {

    public ModifierFlameBarrier() {
        super(EnumType.ARMOR, "flame_barrier", 2.0, true);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onHit(LivingHurtEvent event) {
        if (event.getEntity() instanceof EntityPlayer && event.getSource().getTrueSource() instanceof EntityLivingBase) {
            int blastingLevel = ItemModUtil.getArmorMod((EntityPlayer) event.getEntity(), ItemModUtil.modifierRegistry.get(RegistrarEmbersItems.FLAME_BARRIER).name);

            float strength = (float) (2.0 * (Math.atan(0.6 * (blastingLevel)) / (Math.PI)));
            if (blastingLevel > 0 && EmberInventoryUtil.getEmberTotal(((EntityPlayer) event.getEntity())) >= cost) {
                EmberInventoryUtil.removeEmber(((EntityPlayer) event.getEntity()), cost);
                event.getSource().getTrueSource().attackEntityFrom(RegistrarEmbers.DAMAGE_EMBER, strength * event.getAmount() * 0.5f);
                event.getSource().getTrueSource().setFire(blastingLevel + 1);
                if (!event.getEntity().world.isRemote) {
                    PacketHandler.INSTANCE.sendToAll(new MessageFlameShieldFX(event.getEntity().posX, event.getEntity().posY + event.getEntity().height / 2.0, event.getEntity().posZ));
                }
            }
        }
    }

}
