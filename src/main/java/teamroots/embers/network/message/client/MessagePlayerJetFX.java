package teamroots.embers.network.message.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.particle.ParticleUtil;

import java.util.Random;

public class MessagePlayerJetFX implements IMessage {
    public static Random random = new Random();
    public int id = -1;

    public MessagePlayerJetFX() {
        super();
    }

    public MessagePlayerJetFX(int id) {
        this.id = id;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(id);
    }

    public static class MessageHolder implements IMessageHandler<MessagePlayerJetFX, IMessage> {
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(final MessagePlayerJetFX message, final MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                World world = Minecraft.getMinecraft().world;
                Entity entity = world.getEntityByID(message.id);
                if (!(entity instanceof EntityPlayer))
                    return;

                EntityPlayer player = (EntityPlayer) entity;
                for (int i = 0; i < 40; i++) {
                    ParticleUtil.spawnParticleSmoke(world, (float) player.posX - (float) player.motionX - (float) player.getLookVec().x * 0.5f, (float) player.posY + player.height / 4.0f, (float) player.posZ - (float) player.motionZ - (float) player.getLookVec().z * 0.5f, -(float) player.motionX + 0.25f * (random.nextFloat() - 0.5f), -(float) player.motionY + 0.25f * (random.nextFloat() - 0.5f), -(float) player.motionZ + 0.25f * (random.nextFloat() - 0.5f), 80, 80, 80, 0.25f + 0.25f * random.nextFloat(), 4.0f + random.nextFloat() * 20.0f, 80);
                }
            });
            return null;
        }
    }

}
