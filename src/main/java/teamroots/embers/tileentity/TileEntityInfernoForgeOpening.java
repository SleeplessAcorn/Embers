package teamroots.embers.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.EventManager;
import teamroots.embers.block.BlockInfernoForgeEdge;

import javax.annotation.Nullable;

public class TileEntityInfernoForgeOpening extends TileEntity implements ITileEntityBase, ITickable {
    public boolean isOpen = false;
    public boolean prevState = false;
    public float openAmount = 0.0f;
    public boolean dirty = false;

    public TileEntityInfernoForgeOpening() {
        super();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setBoolean("isOpen", isOpen);
        tag.setBoolean("prevState", prevState);
        tag.setFloat("openAmount", openAmount);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        isOpen = tag.getBoolean("isOpen");
        prevState = tag.getBoolean("prevState");
        openAmount = tag.getFloat("openAmount");
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(getPos(), 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void markForUpdate() {
        EventManager.markTEForUpdate(getPos(), this);
    }

    @Override
    public void markDirty() {
        markForUpdate();
        super.markDirty();
    }

    @Override
    public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                            EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking()) {
            if (world.getTileEntity(pos.down()) instanceof TileEntityInfernoForge) {
                if (((TileEntityInfernoForge) world.getTileEntity(pos.down())).progress == 0) {
                    prevState = isOpen;
                    isOpen = !isOpen;
                    markDirty();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        this.invalidate();
        BlockInfernoForgeEdge.breakBlockSafe(world, pos.down(), player);
        world.setTileEntity(pos, null);
    }

    @Override
    public void update() {
        if (isOpen && !prevState && this.openAmount < 1.0f) {
            openAmount = 0.5f + 0.5f * openAmount;
            if (openAmount > 0.99f) {
                openAmount = 1.0f;
                prevState = isOpen;
                markDirty();
            }
        }
        if (!isOpen && prevState && this.openAmount > 0.0f) {
            openAmount = 0.5f * openAmount;
            if (openAmount < 0.01f) {
                openAmount = 0.0f;
                if (world.getTileEntity(pos.down()) instanceof TileEntityInfernoForge) {
                    ((TileEntityInfernoForge) world.getTileEntity(pos.down())).updateProgress();
                }
                prevState = isOpen;
                markDirty();
            }
        }
    }
}
