package teamroots.embers.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.Embers;
import teamroots.embers.EventManager;
import teamroots.embers.registry.RegistrarEmbersItems;
import teamroots.embers.util.Misc;

import java.util.List;

public class ItemTyrfing extends ItemSword implements IModeledItem {

    public ItemTyrfing(ToolMaterial material, String name, boolean addToTab) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(Embers.MODID + ":" + name);
        if (addToTab) {
            setCreativeTab(Embers.TAB_EMBERS);
        }
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(" " + TextFormatting.BLUE + I18n.format("embers.tooltip.tyrfing"));
    }

    @SideOnly(Side.CLIENT)
    public static class ColorHandler implements IItemColor {
        @Override
        public int getColorFromItemstack(ItemStack stack, int tintIndex) {
            if (tintIndex == 1) {
                if (stack.getItem() == RegistrarEmbersItems.TYRFING) {
                    float timerSine = ((float) Math.sin(8.0 * Math.toRadians(EventManager.ticks % 360)) + 1.0f) / 2.0f;
                    int r = (int) (64.0f * timerSine);
                    int g = (int) (16.0f);
                    int b = (int) (32.0f + 32.0f * timerSine);
                    return (r << 16) + (g << 8) + b;
                }
            }
            return Misc.intColor(255, 255, 255);
        }
    }
}
