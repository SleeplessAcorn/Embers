package teamroots.embers.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.item.EnumStampType;

public class ItemStampingRecipe {
    public ItemStack result = ItemStack.EMPTY;
    protected ItemStack stack = ItemStack.EMPTY;
    protected FluidStack fluid = null;
    protected EnumStampType type = EnumStampType.TYPE_NULL;
    boolean matchMetadata = false;
    boolean matchNBT = false;

    public ItemStampingRecipe(ItemStack stack, FluidStack fluid, EnumStampType type, ItemStack result, boolean meta, boolean nbt) {
        this.stack = stack;
        this.fluid = fluid;
        this.type = type;
        this.result = result;
        this.matchMetadata = meta;
        this.matchNBT = nbt;
    }

    public EnumStampType getStamp() {
        return type;
    }

    public ItemStack getStack() {
        return stack;
    }

    public FluidStack getFluid() {
        return fluid;
    }

    public boolean matches(ItemStack stack, FluidStack fluid, EnumStampType type) {
        boolean matchesItem = false;
        if (stack.isEmpty() && this.stack.isEmpty()) {
            matchesItem = true;
        } else if (!this.stack.isEmpty() && !stack.isEmpty()) {
            if (this.matchNBT) {
                matchesItem = this.stack.getItem().equals(stack.getItem()) && this.stack.getMetadata() == stack.getMetadata() && ItemStack.areItemStackTagsEqual(this.stack, stack);
            } else if (this.matchMetadata) {
                matchesItem = this.stack.getItem().equals(stack.getItem()) && this.stack.getMetadata() == stack.getMetadata();
            } else {
                matchesItem = this.stack.getItem().equals(stack.getItem());
            }
        }
        boolean matchesFluid = false;
        if (fluid != null && this.fluid != null) {
            if (fluid.getFluid().getName().compareTo(this.fluid.getFluid().getName()) == 0 && fluid.amount >= this.fluid.amount) {
                matchesFluid = true;
            }
        }
        return matchesItem && matchesFluid && type == this.type;
    }

    public ItemStack getResult(ItemStack input, FluidStack fluid, EnumStampType type) {
        return result;
    }
}
