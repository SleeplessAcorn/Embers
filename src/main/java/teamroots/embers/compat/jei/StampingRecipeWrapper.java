package teamroots.embers.compat.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import teamroots.embers.item.EnumStampType;
import teamroots.embers.recipe.ItemStampingOreRecipe;
import teamroots.embers.recipe.ItemStampingRecipe;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.ArrayList;
import java.util.List;

public class StampingRecipeWrapper extends BlankRecipeWrapper {

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
    public void getIngredients(IIngredients ingredients) {
        if (!isOreRecipe) {
            ItemStack stampStack = new ItemStack(RegistrarEmbersItems.STAMP_FLAT, 1);
            if (recipe.getStamp() == EnumStampType.TYPE_BAR) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_BAR, 1);
            }
            if (recipe.getStamp() == EnumStampType.TYPE_PLATE) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_PLATE, 1);
            }
            ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
            stacks.add(recipe.getStack());
            stacks.add(stampStack);
            ingredients.setInputs(ItemStack.class, stacks);
            ingredients.setInput(FluidStack.class, recipe.getFluid());
            ingredients.setOutput(ItemStack.class, recipe.result);
        } else {
            ArrayList<ItemStack> validStacks = new ArrayList<ItemStack>(OreDictionary.getOres(oreRecipe.getOre()));
            ArrayList<ItemStack> stampStacks = new ArrayList<ItemStack>();
            ItemStack stampStack = new ItemStack(RegistrarEmbersItems.STAMP_FLAT, 1);
            if (recipe.getStamp() == EnumStampType.TYPE_BAR) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_BAR, 1);
            }
            if (recipe.getStamp() == EnumStampType.TYPE_PLATE) {
                stampStack = new ItemStack(RegistrarEmbersItems.STAMP_PLATE, 1);
            }
            stampStacks.add(stampStack);
            ArrayList<List<ItemStack>> recipeItems = new ArrayList<List<ItemStack>>();
            recipeItems.add(validStacks);
            recipeItems.add(stampStacks);
            ingredients.setInputLists(ItemStack.class, recipeItems);
            ingredients.setInput(FluidStack.class, oreRecipe.getFluid());
            ingredients.setOutput(ItemStack.class, oreRecipe.result);
        }
    }

}
