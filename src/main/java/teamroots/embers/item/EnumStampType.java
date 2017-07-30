package teamroots.embers.item;

import net.minecraft.item.ItemStack;
import teamroots.embers.registry.RegistrarEmbersItems;


public enum EnumStampType {
    TYPE_FLAT, TYPE_BAR, TYPE_PLATE, TYPE_NULL;

    public static EnumStampType getType(ItemStack stack) {
        if (stack != ItemStack.EMPTY) {
            if (stack.getItem() == RegistrarEmbersItems.STAMP_BAR) {
                return TYPE_BAR;
            }
            if (stack.getItem() == RegistrarEmbersItems.STAMP_FLAT) {
                return TYPE_FLAT;
            }
            if (stack.getItem() == RegistrarEmbersItems.STAMP_PLATE) {
                return TYPE_PLATE;
            }
        }
        return TYPE_NULL;
    }
}
