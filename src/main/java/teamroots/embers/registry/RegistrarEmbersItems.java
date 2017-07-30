package teamroots.embers.registry;

import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamroots.embers.ConfigManager;
import teamroots.embers.Embers;
import teamroots.embers.block.IBlock;
import teamroots.embers.block.IModeledBlock;
import teamroots.embers.item.*;

import java.util.List;

@GameRegistry.ObjectHolder(Embers.MODID)
@Mod.EventBusSubscriber(modid = Embers.MODID)
@SuppressWarnings("unused")
public class RegistrarEmbersItems {

    public static final Item GEAR_IRON = Items.AIR;
    public static final Item GEAR_DAWNSTONE = Items.AIR;
    public static final Item MANTLE_BULB = Items.AIR;
    public static final Item RADIANT_CROWN = Items.AIR;
    public static final Item ROCKET_BOOSTER = Items.AIR;
    public static final Item ASHEN_AMULET = Items.AIR;
    public static final Item GLIMMER_CHARM = Items.AIR;
    public static final Item NONBELIEVER_AMULET = Items.AIR;
    public static final Item DAWNSTONE_MAIL = Items.AIR;
    public static final Item EXPLOSION_CHARM = Items.AIR;
    public static final Item CLIMBERS_BELT = Items.AIR;
    public static final Item CRYSTAL_LENSES = Items.AIR;
    public static final Item EMBER_AMULET = Items.AIR;
    public static final Item EMBER_BELT = Items.AIR;
    public static final Item EMBER_RING = Items.AIR;
    public static final Item ARCHAIC_CIRCUIT = Items.AIR;
    public static final Item FLAME_BARRIER = Items.AIR;
    public static final Item ELDRITCH_INSIGNIA = Items.AIR;
    public static final Item INTELLIGENT_APPARATUS = Items.AIR;
    public static final Item CASTER_ORB = Items.AIR;
    public static final Item RESONATING_BELL = Items.AIR;
    public static final Item SUPERHEATER = Items.AIR;
    public static final Item JET_AUGMENT = Items.AIR;
    public static final Item BLASTING_CORE = Items.AIR;
    public static final Item CODEX = Items.AIR;
    public static final Item WILDFIRE_CORE = Items.AIR;
    public static final Item EMBER_CLUSTER = Items.AIR;
    public static final Item ADHESIVE = Items.AIR;
    public static final Item TYRFING = Items.AIR;
    public static final Item ISOLATED_MATERIA = Items.AIR;
    public static final Item ARCHAIC_BRICK = Items.AIR;
    public static final Item ANCIENT_MOTIVE_CORE = Items.AIR;
    public static final Item ASHEN_CLOTH = Items.AIR;
    public static final Item GLIMMER_SHARD = Items.AIR;
    public static final Item GLIMMER_LAMP = Items.AIR;
    public static final Item INFLICTOR_GEM = Items.AIR;
    public static final Item ASHEN_CLOAK_HEAD = Items.AIR;
    public static final Item ASHEN_CLOAK_CHEST = Items.AIR;
    public static final Item ASHEN_CLOAK_LEGS = Items.AIR;
    public static final Item ASHEN_CLOAK_BOOTS = Items.AIR;
    public static final Item ASTER = Items.AIR;
    public static final Item SHARD_ASTER = Items.AIR;
    public static final Item ALCHEMIC_WASTE = Items.AIR;
    public static final Item ASPECTUS_IRON = Items.AIR;
    public static final Item ASPECTUS_COPPER = Items.AIR;
    public static final Item ASPECTUS_DAWNSTONE = Items.AIR;
    public static final Item ASPECTUS_LEAD = Items.AIR;
    public static final Item ASPECTUS_SILVER = Items.AIR;
    public static final Item GOLEMS_EYE = Items.AIR;
    public static final Item DUST_ASH = Items.AIR;
    public static final Item GRANDHAMMER = Items.AIR;
    public static final Item PICKAXE_CLOCKWORK = Items.AIR;
    public static final Item AXE_CLOCKWORK = Items.AIR;
    public static final Item STAFF_EMBER = Items.AIR;
    public static final Item IGNITION_CANNON = Items.AIR;
    public static final Item EMBER_JAR = Items.AIR;
    public static final Item EMBER_CARTRIDGE = Items.AIR;
    public static final Item PICKAXE_COPPER = Items.AIR;
    public static final Item AXE_COPPER = Items.AIR;
    public static final Item SHOVEL_COPPER = Items.AIR;
    public static final Item HOE_COPPER = Items.AIR;
    public static final Item SWORD_COPPER = Items.AIR;
    public static final Item PICKAXE_SILVER = Items.AIR;
    public static final Item AXE_SILVER = Items.AIR;
    public static final Item SHOVEL_SILVER = Items.AIR;
    public static final Item HOE_SILVER = Items.AIR;
    public static final Item SWORD_SILVER = Items.AIR;
    public static final Item PICKAXE_LEAD = Items.AIR;
    public static final Item AXE_LEAD = Items.AIR;
    public static final Item SHOVEL_LEAD = Items.AIR;
    public static final Item HOE_LEAD = Items.AIR;
    public static final Item SWORD_LEAD = Items.AIR;
    public static final Item PICKAXE_DAWNSTONE = Items.AIR;
    public static final Item AXE_DAWNSTONE = Items.AIR;
    public static final Item SHOVEL_DAWNSTONE = Items.AIR;
    public static final Item HOE_DAWNSTONE = Items.AIR;
    public static final Item SWORD_DAWNSTONE = Items.AIR;
    public static final Item DEBUG = Items.AIR;
    public static final Item PLATE_GOLD = Items.AIR;
    public static final Item PLATE_IRON = Items.AIR;
    public static final Item PLATE_CAMINITE_RAW = Items.AIR;
    public static final Item PLATE_MITHRIL = Items.AIR;
    public static final Item STAMP_BAR_RAW = Items.AIR;
    public static final Item STAMP_PLATE_RAW = Items.AIR;
    public static final Item STAMP_FLAT_RAW = Items.AIR;
    public static final Item NUGGET_DAWNSTONE = Items.AIR;
    public static final Item PLATE_COPPER = Items.AIR;
    public static final Item PLATE_LEAD = Items.AIR;
    public static final Item PLATE_SILVER = Items.AIR;
    public static final Item PLATE_DAWNSTONE = Items.AIR;
    public static final Item NUGGET_IRON = Items.AIR;
    public static final Item NUGGET_MITHRIL = Items.AIR;
    public static final Item INGOT_ASTRALITE = Items.AIR;
    public static final Item INGOT_DAWNSTONE = Items.AIR;
    public static final Item INGOT_UMBER_STEEL = Items.AIR;
    public static final Item INGOT_MITHRIL = Items.AIR;
    public static final Item CRYSTAL_EMBER = Items.AIR;
    public static final Item SHARD_EMBER = Items.AIR;
    public static final Item STAMP_BAR = Items.AIR;
    public static final Item STAMP_PLATE = Items.AIR;
    public static final Item STAMP_FLAT = Items.AIR;
    public static final Item TINKER_HAMMER = Items.AIR;
    public static final Item EMBER_DETECTOR = Items.AIR;
    public static final Item INGOT_COPPER = Items.AIR;
    public static final Item INGOT_SILVER = Items.AIR;
    public static final Item INGOT_LEAD = Items.AIR;
    public static final Item NUGGET_COPPER = Items.AIR;
    public static final Item NUGGET_SILVER = Items.AIR;
    public static final Item NUGGET_LEAD = Items.AIR;
    public static final Item BRICK_CAMINITE = Items.AIR;
    public static final Item BLEND_CAMINITE = Items.AIR;
    public static final Item PLATE_CAMINITE = Items.AIR;

    // Nickel Gear
    public static final Item INGOT_NICKEL = Items.AIR;
    public static final Item NUGGET_NICKEL = Items.AIR;
    public static final Item PLATE_NICKEL = Items.AIR;
    public static final Item PICKAXE_NICKEL = Items.AIR;
    public static final Item AXE_NICKEL = Items.AIR;
    public static final Item SHOVEL_NICKEL = Items.AIR;
    public static final Item HOE_NICKEL = Items.AIR;
    public static final Item SWORD_NICKEL = Items.AIR;

    // Aluminum Gear
    public static final Item INGOT_ALUMINUM = Items.AIR;
    public static final Item NUGGET_ALUMINUM = Items.AIR;
    public static final Item PLATE_ALUMINUM = Items.AIR;
    public static final Item PICKAXE_ALUMINUM = Items.AIR;
    public static final Item AXE_ALUMINUM = Items.AIR;
    public static final Item SHOVEL_ALUMINUM = Items.AIR;
    public static final Item HOE_ALUMINUM = Items.AIR;
    public static final Item SWORD_ALUMINUM = Items.AIR;

    // Tin Gear
    public static final Item INGOT_TIN = Items.AIR;
    public static final Item NUGGET_TIN = Items.AIR;
    public static final Item PLATE_TIN = Items.AIR;
    public static final Item PICKAXE_TIN = Items.AIR;
    public static final Item AXE_TIN = Items.AIR;
    public static final Item SHOVEL_TIN = Items.AIR;
    public static final Item HOE_TIN = Items.AIR;
    public static final Item SWORD_TIN = Items.AIR;

    // Bronze Gear
    public static final Item INGOT_BRONZE = Items.AIR;
    public static final Item NUGGET_BRONZE = Items.AIR;
    public static final Item PLATE_BRONZE = Items.AIR;
    public static final Item PICKAXE_BRONZE = Items.AIR;
    public static final Item AXE_BRONZE = Items.AIR;
    public static final Item SHOVEL_BRONZE = Items.AIR;
    public static final Item HOE_BRONZE = Items.AIR;
    public static final Item SWORD_BRONZE = Items.AIR;

    // Electrum Gear
    public static final Item INGOT_ELECTRUM = Items.AIR;
    public static final Item NUGGET_ELECTRUM = Items.AIR;
    public static final Item PLATE_ELECTRUM = Items.AIR;
    public static final Item PICKAXE_ELECTRUM = Items.AIR;
    public static final Item AXE_ELECTRUM = Items.AIR;
    public static final Item SHOVEL_ELECTRUM = Items.AIR;
    public static final Item HOE_ELECTRUM = Items.AIR;
    public static final Item SWORD_ELECTRUM = Items.AIR;

    public static Item.ToolMaterial toolMaterialCoppper;
    public static Item.ToolMaterial toolMaterialSilver;
    public static Item.ToolMaterial toolMaterialLead;
    public static Item.ToolMaterial toolMaterialDawnstone;
    public static Item.ToolMaterial toolMaterialTyrfing;
    public static Item.ToolMaterial toolMaterialAluminum;
    public static Item.ToolMaterial toolMaterialBronze;
    public static Item.ToolMaterial toolMaterialElectrum;
    public static Item.ToolMaterial toolMaterialNickel;
    public static Item.ToolMaterial toolMaterialTin;
    public static ItemArmor.ArmorMaterial armorMaterialAshen;

    static List<Item> items = Lists.newArrayList();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        toolMaterialCoppper = EnumHelper.addToolMaterial(Embers.MODID + ":copper", 2, 181, 5.4f, 1.5f, 16);
        toolMaterialSilver = EnumHelper.addToolMaterial(Embers.MODID + ":silver", 2, 202, 7.6f, 2.0f, 20);
        toolMaterialLead = EnumHelper.addToolMaterial(Embers.MODID + ":lead", 2, 168, 6.0f, 2.0f, 4);
        toolMaterialDawnstone = EnumHelper.addToolMaterial(Embers.MODID + ":dawnstone", 2, 644, 7.5f, 2.5f, 18);
        toolMaterialTyrfing = EnumHelper.addToolMaterial(Embers.MODID + ":tyrfing", 2, 512, 7.5f, 0.0f, 24);

        armorMaterialAshen = EnumHelper.addArmorMaterial(Embers.MODID + ":ashen_cloak", Embers.MODID + ":ashen_cloak", 19, new int[]{3, 5, 7, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);

        items.add(new ItemBase("ingot_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("ingot_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("ingot_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("ingot_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        // Gloomshroud - Add Mithril Ingot
        items.add(new ItemBase("ingot_mithril", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("nugget_iron", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("nugget_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("nugget_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("nugget_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("nugget_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        // Gloomshroud - Add Mithril Nugget
        items.add(new ItemBase("nugget_mithril", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_iron", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("plate_gold", true).setCreativeTab(Embers.TAB_RESOURCE));
        // Gloomshroud - Add Mithril Plate
        items.add(new ItemBase("plate_mithril", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemBase("brick_caminite", true));
        items.add(new ItemBase("blend_caminite", true));
        items.add(new ItemBase("plate_caminite", true));
        items.add(new ItemBase("plate_caminite_raw", true));
        items.add(new ItemTinkerHammer());
        items.add(new ItemBase("stamp_bar", true));
        items.add(new ItemBase("stamp_flat", true));
        items.add(new ItemBase("stamp_plate", true));
        items.add(new ItemBase("stamp_bar_raw", true));
        items.add(new ItemBase("stamp_flat_raw", true));
        items.add(new ItemBase("stamp_plate_raw", true));
        items.add(new ItemEmberGauge());
        items.add(new ItemBase("shard_ember", true));
        items.add(new ItemBase("crystal_ember", true));
        items.add(new ItemPickaxeBase(toolMaterialCoppper, "pickaxe_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemAxeBase2(toolMaterialCoppper, "axe_copper", true, 8.5f, 0.9f).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemShovelBase(toolMaterialCoppper, "shovel_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemHoeBase(toolMaterialCoppper, "hoe_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemSwordBase(toolMaterialCoppper, "sword_copper", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemPickaxeBase(toolMaterialSilver, "pickaxe_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemAxeBase2(toolMaterialSilver, "axe_silver", true, 9f, 1.0f).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemShovelBase(toolMaterialSilver, "shovel_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemHoeBase(toolMaterialSilver, "hoe_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemSwordBase(toolMaterialSilver, "sword_silver", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemPickaxeBase(toolMaterialLead, "pickaxe_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemAxeBase2(toolMaterialLead, "axe_lead", true, 9f, 0.9f).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemShovelBase(toolMaterialLead, "shovel_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemHoeBase(toolMaterialLead, "hoe_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemSwordBase(toolMaterialLead, "sword_lead", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemPickaxeBase(toolMaterialDawnstone, "pickaxe_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemAxeBase2(toolMaterialDawnstone, "axe_dawnstone", true, 9.5f, 1f).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemShovelBase(toolMaterialDawnstone, "shovel_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemHoeBase(toolMaterialDawnstone, "hoe_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemSwordBase(toolMaterialDawnstone, "sword_dawnstone", true).setCreativeTab(Embers.TAB_RESOURCE));
        items.add(new ItemEmberJar());
        items.add(new ItemEmberCartridge());
        items.add(new ItemIgnitionCannon());
        items.add(new ItemCinderStaff());
        items.add(new ItemClockworkAxe("axe_clockwork", true));
        items.add(new ItemClockworkPickaxe("pickaxe_clockwork", true));
        items.add(new ItemGrandhammer("grandhammer", true));
        items.add(new ItemBase("dust_ash", true));
        items.add(new ItemBase("aspectus_iron", true));
        items.add(new ItemBase("aspectus_copper", true));
        items.add(new ItemBase("aspectus_lead", true));
        items.add(new ItemBase("aspectus_silver", true));
        items.add(new ItemBase("aspectus_dawnstone", true));
        items.add(new ItemAlchemicWaste());
        items.add(new ItemAshenCloak(armorMaterialAshen, 3, EntityEquipmentSlot.HEAD));
        items.add(new ItemAshenCloak(armorMaterialAshen, 7, EntityEquipmentSlot.CHEST));
        items.add(new ItemAshenCloak(armorMaterialAshen, 5, EntityEquipmentSlot.LEGS));
        items.add(new ItemAshenCloak(armorMaterialAshen, 3, EntityEquipmentSlot.FEET));
        items.add(new ItemInflictorGem());
        items.add(new ItemGlimmerShard());
        items.add(new ItemBase("ashen_cloth", true));
        items.add(new ItemBase("archaic_brick", true));
        items.add(new ItemBase("ancient_motive_core", true));
        items.add(new ItemBase("isolated_materia", true));
        items.add(new ItemTyrfing(toolMaterialTyrfing, "tyrfing", true));
        items.add(new ItemBase("adhesive", true));
        items.add(new ItemBase("ember_cluster", true));
        items.add(new ItemBase("wildfire_core", true));
        items.add(new ItemCodex());
        items.add(new ItemBase("superheater", true));
        items.add(new ItemBase("jet_augment", true));
        items.add(new ItemBase("blasting_core", true));
        items.add(new ItemBase("caster_orb", true));
        items.add(new ItemBase("resonating_bell", true));
        items.add(new ItemBase("flame_barrier", true));
        items.add(new ItemBase("eldritch_insignia", true));
        items.add(new ItemBase("intelligent_apparatus", true));
        items.add(new ItemBase("archaic_circuit", true));

        if (ConfigManager.enableAluminum) {
            toolMaterialAluminum = EnumHelper.addToolMaterial(Embers.MODID + ":aluminum", 2, 220, 5.2f, 1.5f, 14);
            items.add(new ItemBase("ingot_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("plate_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("nugget_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemPickaxeBase(toolMaterialAluminum, "pickaxe_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemAxeBase(toolMaterialAluminum, "axe_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemShovelBase(toolMaterialAluminum, "shovel_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemSwordBase(toolMaterialAluminum, "sword_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemHoeBase(toolMaterialAluminum, "hoe_aluminum", true).setCreativeTab(Embers.TAB_RESOURCE));
            toolMaterialAluminum.setRepairItem(new ItemStack(INGOT_ALUMINUM));
        }

        if (ConfigManager.enableBronze) {
            toolMaterialBronze = EnumHelper.addToolMaterial(Embers.MODID + ":bronze", 2, 510, 6.5f, 2.0f, 20);
            items.add(new ItemBase("ingot_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("plate_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("nugget_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemPickaxeBase(toolMaterialBronze, "pickaxe_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemAxeBase(toolMaterialBronze, "axe_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemShovelBase(toolMaterialBronze, "shovel_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemSwordBase(toolMaterialBronze, "sword_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemHoeBase(toolMaterialBronze, "hoe_bronze", true).setCreativeTab(Embers.TAB_RESOURCE));
            toolMaterialBronze.setRepairItem(new ItemStack(INGOT_BRONZE));
        }

        if (ConfigManager.enableElectrum) {
            toolMaterialElectrum = EnumHelper.addToolMaterial(Embers.MODID + ":electrum", 2, 71, 10.8f, 1.0f, 30);
            items.add(new ItemBase("ingot_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("plate_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("nugget_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemPickaxeBase(toolMaterialElectrum, "pickaxe_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemAxeBase(toolMaterialElectrum, "axe_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemShovelBase(toolMaterialElectrum, "shovel_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemSwordBase(toolMaterialElectrum, "sword_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemHoeBase(toolMaterialElectrum, "hoe_electrum", true).setCreativeTab(Embers.TAB_RESOURCE));
            toolMaterialElectrum.setRepairItem(new ItemStack(INGOT_ELECTRUM));
        }

        if (ConfigManager.enableNickel) {
            toolMaterialNickel = EnumHelper.addToolMaterial(Embers.MODID + ":nickel", 2, 331, 6.4f, 2.0f, 18);
            items.add(new ItemBase("ingot_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("plate_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("nugget_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemPickaxeBase(toolMaterialNickel, "pickaxe_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemAxeBase(toolMaterialNickel, "axe_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemShovelBase(toolMaterialNickel, "shovel_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemSwordBase(toolMaterialNickel, "sword_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemHoeBase(toolMaterialNickel, "hoe_nickel", true).setCreativeTab(Embers.TAB_RESOURCE));
            toolMaterialNickel.setRepairItem(new ItemStack(INGOT_NICKEL));
        }

        if (ConfigManager.enableTin) {
            toolMaterialTin = EnumHelper.addToolMaterial(Embers.MODID + ":tin", 1, 145, 4.9f, 1.0f, 12);
            items.add(new ItemBase("ingot_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("plate_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemBase("nugget_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemPickaxeBase(toolMaterialTin, "pickaxe_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemAxeBase(toolMaterialTin, "axe_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemShovelBase(toolMaterialTin, "shovel_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemSwordBase(toolMaterialTin, "sword_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            items.add(new ItemHoeBase(toolMaterialTin, "hoe_tin", true).setCreativeTab(Embers.TAB_RESOURCE));
            toolMaterialTin.setRepairItem(new ItemStack(INGOT_TIN));
        }

        toolMaterialCoppper.setRepairItem(new ItemStack(INGOT_COPPER));
        toolMaterialSilver.setRepairItem(new ItemStack(INGOT_SILVER));
        toolMaterialLead.setRepairItem(new ItemStack(INGOT_LEAD));
        toolMaterialDawnstone.setRepairItem(new ItemStack(INGOT_DAWNSTONE));
        toolMaterialTyrfing.setRepairItem(new ItemStack(DUST_ASH));

        armorMaterialAshen.repairMaterial = new ItemStack(ASHEN_CLOTH, 1);

        event.getRegistry().registerAll(items.toArray(new Item[0]));
        RegistrarEmbersBlocks.blocks.stream().filter(block -> block instanceof IBlock).forEach(block -> event.getRegistry().register(((IBlock) block).getItemBlock()));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        items.stream().filter(item -> item instanceof IModeledItem).forEach(item -> ((IModeledItem) item).initModel());
        RegistrarEmbersBlocks.blocks.stream().filter(block -> block instanceof IModeledBlock).forEach(block -> ((IModeledBlock) block).initModel());
    }
}
