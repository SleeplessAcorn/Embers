package teamroots.embers.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import teamroots.embers.EventManager;
import teamroots.embers.registry.RegistrarEmbersItems;
import teamroots.embers.util.Misc;

import javax.annotation.Nullable;
import java.util.Random;

public class TileEntityAlchemyPedestal extends TileEntity implements ITileEntityBase, ITickable {
    public boolean dirty = false;
    int angle = 0;
    int turnRate = 0;
    int progress = 0;
    int ash = 0;
    int stackAsh = 0;
    public ItemStackHandler inventory = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            // We need to tell the tile entity that something has changed so
            // that the chest contents is persisted
            TileEntityAlchemyPedestal.this.markDirty();
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (slot == stackAsh && stack.getItem() != RegistrarEmbersItems.DUST_ASH) {
                return insertItem(slot + 1, stack, simulate);
            }
            return super.insertItem(slot, stack, simulate);
        }
    };
    int stackItem = 1;
    Random random = new Random();

    public TileEntityAlchemyPedestal() {
        super();
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("progress", 0);
        tag.setTag("inventory", inventory.serializeNBT());
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        ash = tag.getInteger("ash");
        progress = tag.getInteger("progress");
        inventory.deserializeNBT(tag.getCompoundTag("inventory"));
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
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) this.inventory;
        }
        return super.getCapability(capability, facing);
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
        ItemStack heldItem = player.getHeldItem(hand);
        if (!heldItem.isEmpty()) {
            if (heldItem.getItem() == RegistrarEmbersItems.DUST_ASH) {
                player.setHeldItem(hand, this.inventory.insertItem(0, heldItem, false));
                markDirty();
            } else {
                player.setHeldItem(hand, this.inventory.insertItem(1, heldItem, false));
                markDirty();
            }
            return true;
        } else {
            if (!inventory.getStackInSlot(1).isEmpty()) {
                if (!getWorld().isRemote) {
                    player.setHeldItem(hand, inventory.extractItem(1, inventory.getStackInSlot(1).getCount(), false));
                    markDirty();
                }
                return true;
            } else if (!inventory.getStackInSlot(0).isEmpty()) {
                if (!getWorld().isRemote) {
                    player.setHeldItem(hand, inventory.extractItem(0, inventory.getStackInSlot(0).getCount(), false));
                    markDirty();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        this.invalidate();
        Misc.spawnInventoryInWorld(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory);
        world.setTileEntity(pos, null);
    }

    @Override
    public void update() {
        turnRate = 1;
        angle += turnRate;
    }
}
