package teamroots.embers.network.message.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.particle.ParticleUtil;
import teamroots.embers.power.IEmberPacketReceiver;
import teamroots.embers.tileentity.TileEntityBeamCannon;

public class MessageBeamCannonFX implements IMessage {
    public NBTTagCompound tag = new NBTTagCompound();

    public MessageBeamCannonFX() {
        //
    }

    public MessageBeamCannonFX(TileEntity tile) {
        this.tag = tile.getUpdateTag();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        tag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, tag);
    }

    public static class MessageHolder implements IMessageHandler<MessageBeamCannonFX, IMessage> {
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(final MessageBeamCannonFX message, final MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                BlockPos pos = new BlockPos(message.tag.getInteger("x"), message.tag.getInteger("y"), message.tag.getInteger("z"));
                World world = Minecraft.getMinecraft().world;

                TileEntity tile = world.getTileEntity(pos);
                if (tile instanceof TileEntityBeamCannon) {
                    TileEntityBeamCannon cannon = (TileEntityBeamCannon) tile;

                    Vec3d ray = (new Vec3d(cannon.target.getX() - cannon.getPos().getX(), cannon.target.getY() - cannon.getPos().getY(), cannon.target.getZ() - cannon.getPos().getZ())).normalize();
                    double posX = cannon.getPos().getX() + 0.5;
                    double posY = cannon.getPos().getY() + 0.5;
                    double posZ = cannon.getPos().getZ() + 0.5;
                    BlockPos targetPos = new BlockPos(posX, posY, posZ);

                    boolean doContinue = true;
                    for (int i = 0; i < 640 && doContinue; i++) {
                        posX += ray.x * 0.1;
                        posY += ray.y * 0.1;
                        posZ += ray.z * 0.1;
                        IBlockState targetState = cannon.getWorld().getBlockState(targetPos);
                        TileEntity targetTile = cannon.getWorld().getTileEntity(targetPos);
                        ParticleUtil.spawnParticleStar(cannon.getWorld(), (float) posX, (float) posY, (float) posZ, 0.0125f * (cannon.random.nextFloat() - 0.5f), 0.0125f * (cannon.random.nextFloat() - 0.5f), 0.0125f * (cannon.random.nextFloat() - 0.5f), 255, 64, 16, 5.0f, 60);
                        if (targetState.isFullCube() && targetState.isOpaqueCube() || targetTile instanceof IEmberPacketReceiver) {
                            doContinue = false;
                            for (int k = 0; k < 80; k++) {
                                ParticleUtil.spawnParticleGlow(cannon.getWorld(), (float) posX, (float) posY, (float) posZ, 0.125f * (cannon.random.nextFloat() - 0.5f), 0.125f * (cannon.random.nextFloat() - 0.5f), 0.125f * (cannon.random.nextFloat() - 0.5f), 255, 64, 16, 8.0f, 60);
                            }
                        }
                    }
                }
            });
            return null;
        }
    }
}
