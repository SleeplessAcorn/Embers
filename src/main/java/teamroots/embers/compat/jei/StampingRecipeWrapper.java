package teamroots.embers.compat.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import teamroots.embers.item.EnumStampType;
import teamroots.embers.recipe.ItemStampingOreRecipe;
import teamroots.embers.recipe.ItemStampingRecipe;
import teamroots.embers.registry.RegistrarEmbersItems;

import javax.annotation.Nonnull;
import java.util.List;

public class StampingRecipeWrapper implements IRecipeWrapper {

    public ItemStampingRecipe recipe = null;
    public ItemStampingOreRecipe oreRecipe = null;
    boolean isOreRecipe = false;

    public StampingRecipeWrapper(ItemStampingRecipe recipe) {
        this.recipe = recipe;
        isOreRecipe = false;
    }

    public StampingRecipeWrapper(ItemStampingOreRecipe recipe) {
        this.oreRecipe = recipe;
        isOreRecipe = true;
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        if (!isOreRecipe) {
            ItemStack stampStack = new ItemStack(RegistrarEmbersItems.STAMP_FLAT, 1);
            if (recipe.getStamp() == EnumStampType.TYPE_BAR) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_BAR, 1);
            }
            if (recipe.getStamp() == EnumStampType.TYPE_PLATE) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_PLATE, 1);
            }
            List<ItemStack> stacks = Lists.newArrayList();
            stacks.add(recipe.getStack());
            stacks.add(stampStack);
            ingredients.setInputs(ItemStack.class, stacks);
            ingredients.setInput(FluidStack.class, recipe.getFluid());
            ingredients.setOutput(ItemStack.class, recipe.result);
        } else {
            List<ItemStack> validStacks = Lists.newArrayList(OreDictionary.getOres(oreRecipe.getOre()));
            List<ItemStack> stampStacks = Lists.newArrayList();
            ItemStack stampStack = new ItemStack(RegistrarEmbersItems.STAMP_FLAT, 1);
            if (recipe.getStamp() == EnumStampType.TYPE_BAR) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_BAR, 1);
            }
            if (recipe.getStamp() == EnumStampType.TYPE_PLATE) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_PLATE, 1);
            }
            stampStacks.add(stampStack);
            List<List<ItemStack>> recipeItems = Lists.newArrayList();
            recipeItems.add(validStacks);
            recipeItems.add(stampStacks);
            ingredients.setInputLists(ItemStack.class, recipeItems);
            ingredients.setInput(FluidStack.class, oreRecipe.getFluid());
            ingredients.setOutput(ItemStack.class, oreRecipe.result);
        }
    }
}
