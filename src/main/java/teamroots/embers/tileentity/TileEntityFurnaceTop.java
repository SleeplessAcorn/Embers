package teamroots.embers.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.TileFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import teamroots.embers.EventManager;
import teamroots.embers.util.Misc;

import javax.annotation.Nullable;
import java.util.List;

public class TileEntityFurnaceTop extends TileFluidHandler implements ITileEntityBase, ITickable {
    public static int capacity = Fluid.BUCKET_VOLUME * 4;
    public double angle = 0;
    public ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            // We need to tell the tile entity that something has changed so
            // that the chest contents is persisted
            TileEntityFurnaceTop.this.markDirty();
        }
    };
    public boolean dirty = false;
    int ticksExisted = 0;

    public TileEntityFurnaceTop() {
        super();
        tank = new FluidTank(capacity);
        tank.setTileEntity(this);
        tank.setCanFill(true);
        tank.setCanDrain(true);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setTag("inventory", inventory.serializeNBT());
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if (tag.hasKey("inventory")) {
            inventory.deserializeNBT(tag.getCompoundTag("inventory"));
        }
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
    public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                            EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = player.getHeldItem(hand);
        if (!heldItem.isEmpty()) {
            if (heldItem.getItem() instanceof ItemBucket || heldItem.getItem() instanceof UniversalBucket) {
                boolean didFill = FluidUtil.interactWithFluidHandler(player, hand, this.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side));
                this.markDirty();
                return didFill;
            } else {
                player.setHeldItem(hand, this.inventory.insertItem(0, heldItem, false));
                markDirty();
                return true;
            }
        } else {
            if (!inventory.getStackInSlot(0).isEmpty() && !world.isRemote) {
                world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, inventory.getStackInSlot(0)));
                inventory.setStackInSlot(0, ItemStack.EMPTY);
                markDirty();
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return tank.getCapacity();
    }

    public int getAmount() {
        return tank.getFluidAmount();
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

    public Fluid getFluid() {
        if (tank.getFluid() != null) {
            return tank.getFluid().getFluid();
        }
        return null;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        this.invalidate();
        Misc.spawnInventoryInWorld(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory);
        world.setTileEntity(pos, null);
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
    public void update() {
        angle++;
        ticksExisted++;
        if (ticksExisted % 10 == 0) {
            List<EntityItem> items = getWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(getPos().getX(), getPos().getY(), getPos().getZ(), getPos().getX() + 1, getPos().getY() + 1.25, getPos().getZ() + 1));
            for (EntityItem item : items) {
                ItemStack stack = inventory.insertItem(0, item.getItem(), false);
                if (!stack.isEmpty()) {
                    item.setItem(stack);
                } else {
                    getWorld().removeEntity(item);
                }
            }
        }
    }
}
