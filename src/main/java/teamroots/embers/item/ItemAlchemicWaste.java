package teamroots.embers.item;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.List;

public class ItemAlchemicWaste extends ItemBase {

    public ItemAlchemicWaste() {
        super("alchemic_waste", true);
        this.setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        if (stack.hasTagCompound()) {
            tooltip.add(I18n.format("embers.tooltip.iron_accuracy") + TextFormatting.RED + stack.getTagCompound().getDouble("ironInaccuracy") + TextFormatting.RESET);
            tooltip.add(I18n.format("embers.tooltip.copper_accuracy") + TextFormatting.RED + stack.getTagCompound().getDouble("copperInaccuracy") + TextFormatting.RESET);
            tooltip.add(I18n.format("embers.tooltip.lead_accuracy") + TextFormatting.RED + stack.getTagCompound().getDouble("leadInaccuracy") + TextFormatting.RESET);
            tooltip.add(I18n.format("embers.tooltip.silver_accuracy") + TextFormatting.RED + stack.getTagCompound().getDouble("silverInaccuracy") + TextFormatting.RESET);
            tooltip.add(I18n.format("embers.tooltip.dawnstone_accuracy") + TextFormatting.RED + stack.getTagCompound().getDouble("dawnstoneInaccuracy") + TextFormatting.RESET);
        }
    }

    public static ItemStack create(int ironInaccuracy, int copperInaccuracy, int silverInaccuracy, int dawnstoneInaccuracy, int leadInaccuracy, int totalAsh) {
        ItemStack stack = new ItemStack(RegistrarEmbersItems.ALCHEMIC_WASTE, 1);
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger("ironInaccuracy", ironInaccuracy);
        stack.getTagCompound().setInteger("copperInaccuracy", copperInaccuracy);
        stack.getTagCompound().setInteger("silverInaccuracy", silverInaccuracy);
        stack.getTagCompound().setInteger("dawnstoneInaccuracy", dawnstoneInaccuracy);
        stack.getTagCompound().setInteger("leadInaccuracy", leadInaccuracy);
        stack.getTagCompound().setInteger("totalAsh", totalAsh);
        return stack;
    }
}
