package teamroots.embers.recipe;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;
import teamroots.embers.item.ItemInflictorGem;
import teamroots.embers.registry.RegistrarEmbersItems;

public class AshenCloakSocketRecipe extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean hasCloak = false;
        boolean moreThanOneCloak = false;
        boolean hasString = false;
        boolean moreThanOneString = false;
        boolean hasGem = false;
        if (inv.getSizeInventory() > 4) {
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                if (!inv.getStackInSlot(i).isEmpty()) {
                    if (inv.getStackInSlot(i).getItem() == RegistrarEmbersItems.ASHEN_CLOAK_CHEST) {
                        if (!inv.getStackInSlot(i).hasTagCompound() || !inv.getStackInSlot(i).getTagCompound().hasKey("gem1")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem2")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem3")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem4")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem5")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem6")
                                && !inv.getStackInSlot(i).getTagCompound().hasKey("gem7")) {
                            if (!hasCloak && !moreThanOneCloak) {
                                hasCloak = true;
                            } else if (hasCloak) {
                                hasCloak = false;
                                moreThanOneCloak = true;
                            }
                        }
                    } else if (inv.getStackInSlot(i).getItem() == Items.STRING) {
                        if (!hasString && !moreThanOneString) {
                            hasString = true;
                        } else if (hasString) {
                            hasString = false;
                            moreThanOneString = true;
                        }
                    } else if (inv.getStackInSlot(i).getItem() instanceof ItemInflictorGem) {
                        hasGem = true;
                    } else {
                        if (!inv.getStackInSlot(i).isEmpty()) {
                            return false;
                        }
                    }
                }
            }
        }
        return hasGem && hasString && hasCloak;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        ItemStack capeStack = ItemStack.EMPTY;
        for (int i = 0; i < inv.getSizeInventory(); i++) {
            if (!inv.getStackInSlot(i).isEmpty()) {
                if (inv.getStackInSlot(i).getItem() == RegistrarEmbersItems.ASHEN_CLOAK_CHEST) {
                    capeStack = inv.getStackInSlot(i).copy();
                }
            }
        }
        if (!capeStack.isEmpty()) {
            if (!capeStack.hasTagCompound()) {
                capeStack.setTagCompound(new NBTTagCompound());
            }
            int counter = 1;
            for (int i = 0; i < inv.getSizeInventory(); i++) {
                if (!inv.getStackInSlot(i).isEmpty()) {
                    if (inv.getStackInSlot(i).getItem() instanceof ItemInflictorGem) {
                        capeStack.getTagCompound().setTag("gem" + counter, inv.getStackInSlot(i).writeToNBT(new NBTTagCompound()));
                        counter++;
                    }
                }
            }
            return capeStack;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_CHEST, 1);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> remaining = NonNullList.create();
        inv.clear();
        return remaining;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width > 2 && height > 2;
    }

}
