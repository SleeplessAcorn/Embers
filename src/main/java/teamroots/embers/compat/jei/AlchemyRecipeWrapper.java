package teamroots.embers.compat.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import teamroots.embers.recipe.AlchemyRecipe;

import javax.annotation.Nonnull;
import java.util.List;

public class AlchemyRecipeWrapper implements IRecipeWrapper {

    public AlchemyRecipe recipe = null;

    public AlchemyRecipeWrapper(AlchemyRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(@Nonnull IIngredients ingredients) {
        List<ItemStack> inputs = Lists.newArrayList();
        inputs.add(recipe.centerInput);
        inputs.addAll(recipe.inputs);
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, recipe.result);
    }

}
