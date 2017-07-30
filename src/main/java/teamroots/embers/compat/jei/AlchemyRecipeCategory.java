package teamroots.embers.compat.jei;

import com.google.common.collect.Lists;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import teamroots.embers.Embers;
import teamroots.embers.recipe.AlchemyRecipe;

import javax.annotation.Nonnull;
import java.util.List;

public class AlchemyRecipeCategory implements IRecipeCategory<AlchemyRecipeWrapper> {
    public static ResourceLocation texture = new ResourceLocation("embers:textures/gui/jei_alchemy.png");
    private final IDrawable background;
    private final String name;
    private IGuiHelper helper = null;
    private AlchemyRecipe lastRecipe = null;

    public AlchemyRecipeCategory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(texture, 0, 0, 108, 129);
        this.name = I18n.format("embers.jei.recipe.alchemy");
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
        return "embers.alchemy";
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayout layout, @Nonnull AlchemyRecipeWrapper recipeWrapper, @Nonnull IIngredients ingredients) {
        IGuiItemStackGroup stacks = layout.getItemStacks();

        stacks.init(0, true, 27, 18);
        stacks.init(1, true, 9, 18);
        stacks.init(2, true, 27, 0);
        stacks.init(3, true, 45, 18);
        stacks.init(4, true, 27, 36);
        stacks.init(5, true, 81, 18);

        for (int i = 0; i < 5; i++) {
            if (ingredients.getInputs(ItemStack.class).size() > i) {
                if (ingredients.getInputs(ItemStack.class).get(i) != null) {
                    stacks.set(i, ingredients.getInputs(ItemStack.class).get(i));
                }
            }
        }
        if (ingredients.getOutputs(ItemStack.class).size() > 0) {
            stacks.set(5, ingredients.getOutputs(ItemStack.class).get(0));
        }

        lastRecipe = recipeWrapper.recipe;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft) {
        int aspectTotal = lastRecipe.ironAspectMin + lastRecipe.ironAspectRange
                + lastRecipe.copperAspectMin + lastRecipe.copperAspectRange
                + lastRecipe.silverAspectMin + lastRecipe.silverAspectRange
                + lastRecipe.leadAspectMin + lastRecipe.leadAspectRange
                + lastRecipe.dawnstoneAspectMin + lastRecipe.dawnstoneAspectRange;

        if (this.lastRecipe.ironAspectMin + this.lastRecipe.ironAspectRange > 0) {
            IDrawable ashBar = helper.createDrawable(texture, 109, 0, 8, ((52 * lastRecipe.ironAspectMin) / aspectTotal));
            IDrawable ashPartialBar = helper.createDrawable(texture, 119, 8, 8, ((52 * (lastRecipe.ironAspectMin + lastRecipe.ironAspectRange)) / aspectTotal));
            ashPartialBar.draw(minecraft, 20, 73);
            ashBar.draw(minecraft, 20, 73);
        }
        if (this.lastRecipe.copperAspectMin + this.lastRecipe.copperAspectRange > 0) {
            IDrawable ashBar = helper.createDrawable(texture, 109, 0, 8, ((52 * lastRecipe.copperAspectMin) / aspectTotal));
            IDrawable ashPartialBar = helper.createDrawable(texture, 119, 8, 8, ((52 * (lastRecipe.copperAspectMin + lastRecipe.copperAspectRange)) / aspectTotal));
            ashPartialBar.draw(minecraft, 35, 73);
            ashBar.draw(minecraft, 35, 73);
        }
        if (this.lastRecipe.dawnstoneAspectMin + this.lastRecipe.dawnstoneAspectRange > 0) {
            IDrawable ashBar = helper.createDrawable(texture, 109, 0, 8, ((52 * lastRecipe.dawnstoneAspectMin) / aspectTotal));
            IDrawable ashPartialBar = helper.createDrawable(texture, 119, 8, 8, ((52 * (lastRecipe.dawnstoneAspectMin + lastRecipe.dawnstoneAspectRange)) / aspectTotal));
            ashPartialBar.draw(minecraft, 50, 73);
            ashBar.draw(minecraft, 50, 73);
        }
        if (this.lastRecipe.leadAspectMin + this.lastRecipe.leadAspectRange > 0) {
            IDrawable ashBar = helper.createDrawable(texture, 109, 0, 8, ((52 * lastRecipe.leadAspectMin) / aspectTotal));
            IDrawable ashPartialBar = helper.createDrawable(texture, 119, 8, 8, ((52 * (lastRecipe.leadAspectMin + lastRecipe.leadAspectRange)) / aspectTotal));
            ashPartialBar.draw(minecraft, 65, 73);
            ashBar.draw(minecraft, 65, 73);
        }
        if (this.lastRecipe.silverAspectMin + this.lastRecipe.silverAspectRange > 0) {
            IDrawable ashBar = helper.createDrawable(texture, 109, 0, 8, ((52 * lastRecipe.silverAspectMin) / aspectTotal));
            IDrawable ashPartialBar = helper.createDrawable(texture, 119, 8, 8, ((52 * (lastRecipe.silverAspectMin + lastRecipe.silverAspectRange)) / aspectTotal));
            ashPartialBar.draw(minecraft, 80, 73);
            ashBar.draw(minecraft, 80, 73);
        }
    }

    @Nonnull
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        List<String> tooltip = Lists.newArrayList();

        if (mouseY >= 74 && mouseY <= 127) {
            if (mouseX > 18 && mouseX < 28)
                tooltip.add(lastRecipe.ironAspectMin + " - " + (lastRecipe.ironAspectMin + lastRecipe.ironAspectRange));
            else if (mouseX > 33 && mouseX < 44)
                tooltip.add(lastRecipe.copperAspectMin + " - " + (lastRecipe.copperAspectMin + lastRecipe.copperAspectRange));
            else if (mouseX > 48 && mouseX < 59)
                tooltip.add(lastRecipe.dawnstoneAspectMin + " - " + (lastRecipe.dawnstoneAspectMin + lastRecipe.dawnstoneAspectRange));
            else if (mouseX > 63 && mouseX < 74)
                tooltip.add(lastRecipe.leadAspectMin + " - " + (lastRecipe.leadAspectMin + lastRecipe.leadAspectRange));
            else if (mouseX > 78 && mouseX < 89)
                tooltip.add(lastRecipe.silverAspectMin + " - " + (lastRecipe.silverAspectMin + lastRecipe.silverAspectRange));
        }

        return tooltip;
    }

    @Nonnull
    @Override
    public String getModName() {
        return Embers.MODID;
    }
}
