package teamroots.embers.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import teamroots.embers.recipe.*;
import teamroots.embers.registry.RegistrarEmbersBlocks;

import javax.annotation.Nonnull;

@JEIPlugin
public class EmbersJEIPlugin implements IModPlugin {

    @Override
    public void register(@Nonnull IModRegistry reg) {
        reg.handleRecipes(ItemStampingRecipe.class, StampingRecipeWrapper::new, "embers.stamp");
        reg.handleRecipes(ItemStampingOreRecipe.class, StampingRecipeWrapper::new, "embers.stamp");
        reg.addRecipes(RecipeRegistry.stampingRecipes, "embers.stamp");
        reg.addRecipes(RecipeRegistry.stampingOreRecipes, "embers.stamp");

        reg.handleRecipes(ItemMeltingRecipe.class, MeltingRecipeWrapper::new, "embers.melter");
        reg.handleRecipes(ItemMeltingOreRecipe.class, MeltingRecipeWrapper::new, "embers.melter");
        reg.addRecipes(RecipeRegistry.meltingRecipes, "embers.melter");
        reg.addRecipes(RecipeRegistry.meltingOreRecipes, "embers.melter");

        reg.handleRecipes(FluidMixingRecipe.class, MixingRecipeWrapper::new, "embers.mixer");
        reg.addRecipes(RecipeRegistry.mixingRecipes, "embers.mixer");

        reg.handleRecipes(AlchemyRecipe.class, AlchemyRecipeWrapper::new, "embers.alchemy");
        reg.addRecipes(RecipeRegistry.alchemyRecipes, "embers.alchemy");

        reg.addRecipeCatalyst(new ItemStack(RegistrarEmbersBlocks.STAMPER), "embers.stamp");
        reg.addRecipeCatalyst(new ItemStack(RegistrarEmbersBlocks.BLOCK_FURNACE), "embers.melter");
        reg.addRecipeCatalyst(new ItemStack(RegistrarEmbersBlocks.MIXER), "embers.mixer");
        reg.addRecipeCatalyst(new ItemStack(RegistrarEmbersBlocks.ALCHEMY_TABLET), "embers.alchemy");
    }

    @Override
    public void registerCategories(@Nonnull IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(
                new AlchemyRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
                new MelterRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
                new MixingRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
                new StampRecipeCategory(registry.getJeiHelpers().getGuiHelper())
        );
    }
}
