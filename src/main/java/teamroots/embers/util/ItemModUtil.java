package teamroots.embers.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import teamroots.embers.Embers;
import teamroots.embers.itemmod.*;
import teamroots.embers.itemmod.ModifierBase.EnumType;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.HashMap;
import java.util.Map;

public class ItemModUtil {
    public static final String HEAT_TAG = Embers.MODID + ":heat_tag";

    public static Map<Item, ModifierBase> modifierRegistry = new HashMap<Item, ModifierBase>();

    public static void init() {
        modifierRegistry.put(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE, new ModifierCore());
        modifierRegistry.put(RegistrarEmbersItems.SUPERHEATER, new ModifierSuperheater());
        modifierRegistry.put(RegistrarEmbersItems.JET_AUGMENT, new ModifierCinderJet());
        modifierRegistry.put(RegistrarEmbersItems.CASTER_ORB, new ModifierCasterOrb());
        modifierRegistry.put(RegistrarEmbersItems.RESONATING_BELL, new ModifierResonatingBell());
        modifierRegistry.put(RegistrarEmbersItems.BLASTING_CORE, new ModifierBlastingCore());
        modifierRegistry.put(RegistrarEmbersItems.FLAME_BARRIER, new ModifierFlameBarrier());
        modifierRegistry.put(RegistrarEmbersItems.ELDRITCH_INSIGNIA, new ModifierEldritchInsignia());
        modifierRegistry.put(RegistrarEmbersItems.INTELLIGENT_APPARATUS, new ModifierIntelligentApparatus());
    }

    public static void checkForTag(ItemStack stack) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (!stack.getTagCompound().hasKey(HEAT_TAG)) {
            stack.getTagCompound().setTag(HEAT_TAG, new NBTTagCompound());
            stack.getTagCompound().getCompoundTag(HEAT_TAG).setInteger("heat_level", 0);
            stack.getTagCompound().getCompoundTag(HEAT_TAG).setFloat("heat", 0);
            stack.getTagCompound().getCompoundTag(HEAT_TAG).setTag("modifiers", new NBTTagList());
        }
    }

    public static boolean isModValid(ItemStack stack, ItemStack mod) {
        ModifierBase b = modifierRegistry.get(mod.getItem());
        if (b.type == EnumType.ALL) {
            return true;
        } else if (b.type == EnumType.ARMOR) {
            return stack.getItem() instanceof ItemArmor;
        } else if (b.type == EnumType.TOOL) {
            return stack.getItem() instanceof ItemSword || stack.getItem() instanceof ItemTool;
        }
        return false;
    }

    public static boolean hasModifier(ItemStack stack, String name) {
        if (hasHeat(stack)) {
            NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (compound.hasKey("name")) {
                    if (compound.getString("name").compareTo(name) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void addModifier(ItemStack stack, ItemStack mod) {
        checkForTag(stack);
        NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
        if (getModifierLevel(stack, modifierRegistry.get(mod.getItem()).name) == 0) {
            NBTTagCompound modifier = new NBTTagCompound();
            modifier.setString("name", modifierRegistry.get(mod.getItem()).name);
            modifier.setTag("item", mod.writeToNBT(new NBTTagCompound()));
            modifier.setInteger("level", 1);
            list.appendTag(modifier);
        } else {
            incModifierLevel(stack, modifierRegistry.get(mod.getItem()).name);
        }
    }

    public static int incModifierLevel(ItemStack stack, String name) {
        if (hasHeat(stack)) {
            NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (compound.hasKey("name")) {
                    if (compound.getString("name").compareTo(name) == 0) {
                        compound.setInteger("level", compound.getInteger("level") + 1);
                    }
                }
            }
        }
        return 0;
    }

    public static int getTotalModLevel(ItemStack stack) {
        int total = 0;
        if (hasHeat(stack)) {
            NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                ItemStack s = new ItemStack(compound.getCompoundTag("item"));
                if (modifierRegistry.get(s.getItem()).countTowardsTotalLevel) {
                    total += compound.getInteger("level");
                }
            }
        }
        return total;
    }

    public static void setModifierLevel(ItemStack stack, String name, int level) {
        if (hasHeat(stack)) {
            NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (compound.hasKey("name")) {
                    if (compound.getString("name").compareTo(name) == 0) {
                        compound.setInteger("level", level);
                    }
                }
            }
        }
    }

    public static int getModifierLevel(ItemStack stack, String name) {
        if (hasHeat(stack)) {
            NBTTagList list = stack.getTagCompound().getCompoundTag(HEAT_TAG).getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < list.tagCount(); i++) {
                NBTTagCompound compound = list.getCompoundTagAt(i);
                if (compound.hasKey("name")) {
                    if (compound.getString("name").compareTo(name) == 0) {
                        return compound.getInteger("level");
                    }
                }
            }
        }
        return 0;
    }

    public static float getMaxHeat(ItemStack stack) {
        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().hasKey(HEAT_TAG)) {
                return 500f + 250f * stack.getTagCompound().getCompoundTag(HEAT_TAG).getFloat("heat_level");
            }
        }
        return 0.0f;
    }

    public static float getHeat(ItemStack stack) {
        if (stack.hasTagCompound()) {
            if (stack.getTagCompound().hasKey(HEAT_TAG)) {
                return stack.getTagCompound().getCompoundTag(HEAT_TAG).getFloat("heat");
            }
        }
        return 0.0f;
    }

    public static int getLevel(ItemStack stack) {
        checkForTag(stack);
        return stack.getTagCompound().getCompoundTag(HEAT_TAG).getInteger("heat_level");
    }

    public static void setLevel(ItemStack stack, int level) {
        checkForTag(stack);
        stack.getTagCompound().getCompoundTag(HEAT_TAG).setInteger("heat_level", level);
    }

    public static void addHeat(ItemStack stack, float heat) {
        checkForTag(stack);
        stack.getTagCompound().getCompoundTag(HEAT_TAG).setFloat("heat", Math.min(getMaxHeat(stack), getHeat(stack) + heat));
    }

    public static void setHeat(ItemStack stack, float heat) {
        checkForTag(stack);
        stack.getTagCompound().getCompoundTag(HEAT_TAG).setFloat("heat", heat);
    }

    public static boolean hasHeat(ItemStack stack) {
        if (!stack.isEmpty()) {
            if (stack.hasTagCompound()) {
                if (stack.getTagCompound().hasKey(HEAT_TAG)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getArmorMod(EntityPlayer p, String name) {
        int maxLevel = 0;
        if (hasHeat(p.getItemStackFromSlot(EntityEquipmentSlot.HEAD))) {
            int l = getModifierLevel(p.getItemStackFromSlot(EntityEquipmentSlot.HEAD), name);
            if (l > maxLevel) {
                maxLevel = l;
            }
        }
        if (hasHeat(p.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
            int l = getModifierLevel(p.getItemStackFromSlot(EntityEquipmentSlot.CHEST), name);
            if (l > maxLevel) {
                maxLevel = l;
            }
        }
        if (hasHeat(p.getItemStackFromSlot(EntityEquipmentSlot.LEGS))) {
            int l = getModifierLevel(p.getItemStackFromSlot(EntityEquipmentSlot.LEGS), name);
            if (l > maxLevel) {
                maxLevel = l;
            }
        }
        if (hasHeat(p.getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
            int l = getModifierLevel(p.getItemStackFromSlot(EntityEquipmentSlot.FEET), name);
            if (l > maxLevel) {
                maxLevel = l;
            }
        }
        return maxLevel;
    }
}
