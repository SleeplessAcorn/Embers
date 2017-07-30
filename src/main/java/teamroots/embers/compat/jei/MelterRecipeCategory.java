package teamroots.embers.compat.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import teamroots.embers.Embers;

import javax.annotation.Nonnull;

public class MelterRecipeCategory implements IRecipeCategory<MeltingRecipeWrapper> {
    public static ResourceLocation texture = new ResourceLocation("embers:textures/gui/jei_melter.png");
    private final IDrawable background;
    private final String name;

    public MelterRecipeCategory(IGuiHelper helper) {

        this.background = helper.createDrawable(texture, 0, 0, 107, 40);
        this.name = I18n.format("embers.jei.recipe.melter");
    }

    @Nonnull
    @Override
    public String getTitle() {
        return name;
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Nonnull
    @Override
    public String getUid() {
        return "embers.melter";
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayout layout, @Nonnull MeltingRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        IGuiItemStackGroup stacks = layout.getItemStacks();

        stacks.init(0, true, 6, 11);

        if (ingredients.getInputs(ItemStack.class).size() > 0) {
            stacks.set(0, ingredients.getInputs(ItemStack.class).get(0));
        }

        IGuiFluidStackGroup fluid = layout.getFluidStacks();
        fluid.init(1, true, 83, 4, 16, 32, 1500, true, null);
        fluid.set(1, ingredients.getOutputs(FluidStack.class).get(0));
    }

    @Nonnull
    @Override
    public String getModName() {
        return Embers.MODID;
    }
}
