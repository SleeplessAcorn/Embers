package teamroots.embers.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import teamroots.embers.ConfigHandler;
import teamroots.embers.Embers;
import teamroots.embers.item.EnumStampType;
import teamroots.embers.registry.RegistrarEmbersBlocks;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.ArrayList;
import java.util.List;

public class RecipeRegistry {
    public static ArrayList<ItemMeltingRecipe> meltingRecipes = new ArrayList<ItemMeltingRecipe>();
    public static ArrayList<ItemMeltingOreRecipe> meltingOreRecipes = new ArrayList<ItemMeltingOreRecipe>();

    public static ArrayList<ItemStampingRecipe> stampingRecipes = new ArrayList<ItemStampingRecipe>();
    public static ArrayList<ItemStampingOreRecipe> stampingOreRecipes = new ArrayList<ItemStampingOreRecipe>();

    public static ArrayList<FluidMixingRecipe> mixingRecipes = new ArrayList<FluidMixingRecipe>();

    public static ArrayList<AlchemyRecipe> alchemyRecipes = new ArrayList<AlchemyRecipe>();

    @SubscribeEvent
    public void init(RegistryEvent.Register<IRecipe> event) {

        event.getRegistry().register(new ShapedOreRecipe(getRL("crystal_ember"), new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER, 1), true, new Object[]{
                "XXX",
                "XXX",
                'X', RegistrarEmbersItems.SHARD_EMBER}).setRegistryName(getRL("crystal_ember")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL("shard_ember"), new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 6), new Object[]{
                RegistrarEmbersItems.CRYSTAL_EMBER}).setRegistryName(getRL("shard_ember")));

        event.getRegistry().register(new ShapelessOreRecipe(getRL("iron_nugget"), new ItemStack(RegistrarEmbersItems.NUGGET_IRON, 9), new Object[]{
                "ingotIron"}).setRegistryName(getRL("iron_nugget")));


        event.getRegistry().register(new ShapelessOreRecipe(getRL("plate_gold"), new ItemStack(RegistrarEmbersItems.PLATE_GOLD, 1), new Object[]{
                "ingotGold", "ingotGold", "ingotGold", "ingotGold", RegistrarEmbersItems.TINKER_HAMMER}).setRegistryName(getRL("plate_gold")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL("plate_iron"), new ItemStack(RegistrarEmbersItems.PLATE_IRON, 1), new Object[]{
                "ingotIron", "ingotIron", "ingotIron", "ingotIron", RegistrarEmbersItems.TINKER_HAMMER}).setRegistryName(getRL("plate_iron")));

        RecipeRegistry.registerMaterialSet(event, "ingotLead", "nuggetLead", "blockLead",
                RegistrarEmbersItems.INGOT_LEAD,
                RegistrarEmbersItems.NUGGET_LEAD,
                RegistrarEmbersItems.PLATE_LEAD,
                RegistrarEmbersBlocks.BLOCK_LEAD,
                RegistrarEmbersItems.PICKAXE_LEAD,
                RegistrarEmbersItems.AXE_LEAD,
                RegistrarEmbersItems.SHOVEL_LEAD,
                RegistrarEmbersItems.HOE_LEAD,
                RegistrarEmbersItems.SWORD_LEAD);

        RecipeRegistry.registerMaterialSet(event, "ingotCopper", "nuggetCopper", "blockCopper",
                RegistrarEmbersItems.INGOT_COPPER,
                RegistrarEmbersItems.NUGGET_COPPER,
                RegistrarEmbersItems.PLATE_COPPER,
                RegistrarEmbersBlocks.BLOCK_COPPER,
                RegistrarEmbersItems.PICKAXE_COPPER,
                RegistrarEmbersItems.AXE_COPPER,
                RegistrarEmbersItems.SHOVEL_COPPER,
                RegistrarEmbersItems.HOE_COPPER,
                RegistrarEmbersItems.SWORD_COPPER);

        RecipeRegistry.registerMaterialSet(event, "ingotSilver", "nuggetSilver", "blockSilver",
                RegistrarEmbersItems.INGOT_SILVER,
                RegistrarEmbersItems.NUGGET_SILVER,
                RegistrarEmbersItems.PLATE_SILVER,
                RegistrarEmbersBlocks.BLOCK_SILVER,
                RegistrarEmbersItems.PICKAXE_SILVER,
                RegistrarEmbersItems.AXE_SILVER,
                RegistrarEmbersItems.SHOVEL_SILVER,
                RegistrarEmbersItems.HOE_SILVER,
                RegistrarEmbersItems.SWORD_SILVER);

        RecipeRegistry.registerMaterialSet(event, "ingotDawnstone", "nuggetDawnstone", "blockDawnstone",
                RegistrarEmbersItems.INGOT_DAWNSTONE,
                RegistrarEmbersItems.NUGGET_DAWNSTONE,
                RegistrarEmbersItems.PLATE_DAWNSTONE,
                RegistrarEmbersBlocks.BLOCK_DAWNSTONE,
                RegistrarEmbersItems.PICKAXE_DAWNSTONE,
                RegistrarEmbersItems.AXE_DAWNSTONE,
                RegistrarEmbersItems.SHOVEL_DAWNSTONE,
                RegistrarEmbersItems.HOE_DAWNSTONE,
                RegistrarEmbersItems.SWORD_DAWNSTONE);

        if (ConfigHandler.compat.enableAluminum) {
            RecipeRegistry.registerMaterialSet(event, "ingotAluminum", "nuggetAluminum", "blockAluminum",
                    RegistrarEmbersItems.INGOT_ALUMINUM,
                    RegistrarEmbersItems.NUGGET_ALUMINUM,
                    RegistrarEmbersItems.PLATE_ALUMINUM,
                    RegistrarEmbersBlocks.BLOCK_ALUMINUM,
                    RegistrarEmbersItems.PICKAXE_ALUMINUM,
                    RegistrarEmbersItems.AXE_ALUMINUM,
                    RegistrarEmbersItems.SHOVEL_ALUMINUM,
                    RegistrarEmbersItems.HOE_ALUMINUM,
                    RegistrarEmbersItems.SWORD_ALUMINUM);
        }

        if (ConfigHandler.compat.enableBronze) {
            RecipeRegistry.registerMaterialSet(event, "ingotBronze", "nuggetBronze", "blockBronze",
                    RegistrarEmbersItems.INGOT_BRONZE,
                    RegistrarEmbersItems.NUGGET_BRONZE,
                    RegistrarEmbersItems.PLATE_BRONZE,
                    RegistrarEmbersBlocks.BLOCK_BRONZE,
                    RegistrarEmbersItems.PICKAXE_BRONZE,
                    RegistrarEmbersItems.AXE_BRONZE,
                    RegistrarEmbersItems.SHOVEL_BRONZE,
                    RegistrarEmbersItems.HOE_BRONZE,
                    RegistrarEmbersItems.SWORD_BRONZE);
        }

        if (ConfigHandler.compat.enableElectrum) {
            RecipeRegistry.registerMaterialSet(event, "ingotElectrum", "nuggetElectrum", "blockElectrum",
                    RegistrarEmbersItems.INGOT_ELECTRUM,
                    RegistrarEmbersItems.NUGGET_ELECTRUM,
                    RegistrarEmbersItems.PLATE_ELECTRUM,
                    RegistrarEmbersBlocks.BLOCK_ELECTRUM,
                    RegistrarEmbersItems.PICKAXE_ELECTRUM,
                    RegistrarEmbersItems.AXE_ELECTRUM,
                    RegistrarEmbersItems.SHOVEL_ELECTRUM,
                    RegistrarEmbersItems.HOE_ELECTRUM,
                    RegistrarEmbersItems.SWORD_ELECTRUM);
        }

        if (ConfigHandler.compat.enableNickel) {
            RecipeRegistry.registerMaterialSet(event, "ingotNickel", "nuggetNickel", "blockNickel",
                    RegistrarEmbersItems.INGOT_NICKEL,
                    RegistrarEmbersItems.NUGGET_NICKEL,
                    RegistrarEmbersItems.PLATE_NICKEL,
                    RegistrarEmbersBlocks.BLOCK_NICKEL,
                    RegistrarEmbersItems.PICKAXE_NICKEL,
                    RegistrarEmbersItems.AXE_NICKEL,
                    RegistrarEmbersItems.SHOVEL_NICKEL,
                    RegistrarEmbersItems.HOE_NICKEL,
                    RegistrarEmbersItems.SWORD_NICKEL);
        }

        if (ConfigHandler.compat.enableTin) {
            RecipeRegistry.registerMaterialSet(event, "ingotTin", "nuggetTin", "blockTin",
                    RegistrarEmbersItems.INGOT_TIN,
                    RegistrarEmbersItems.NUGGET_TIN,
                    RegistrarEmbersItems.PLATE_TIN,
                    RegistrarEmbersBlocks.BLOCK_TIN,
                    RegistrarEmbersItems.PICKAXE_TIN,
                    RegistrarEmbersItems.AXE_TIN,
                    RegistrarEmbersItems.SHOVEL_TIN,
                    RegistrarEmbersItems.HOE_TIN,
                    RegistrarEmbersItems.SWORD_TIN);
        }

        event.getRegistry().register(new ShapelessOreRecipe(getRL("blend_caminite"), new ItemStack(RegistrarEmbersItems.BLEND_CAMINITE, 8), new Object[]{
                Items.CLAY_BALL, Items.CLAY_BALL, Items.CLAY_BALL, Items.CLAY_BALL, "sand"}).setRegistryName(getRL("blend_caminite")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("plate_caminite_raw"), new ItemStack(RegistrarEmbersItems.PLATE_CAMINITE_RAW, 1), true, new Object[]{
                "XX",
                "XX",
                'X', RegistrarEmbersItems.BLEND_CAMINITE}).setRegistryName(getRL("plate_caminite_raw")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stamp_bar_raw"), new ItemStack(RegistrarEmbersItems.STAMP_BAR_RAW, 1), true, new Object[]{
                " X ",
                "X X",
                " X ",
                'X', RegistrarEmbersItems.BLEND_CAMINITE}).setRegistryName(getRL("stamp_bar_raw")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stamp_flat_raw"), new ItemStack(RegistrarEmbersItems.STAMP_FLAT_RAW, 1), true, new Object[]{
                "XXX",
                "X X",
                "XXX",
                'X', RegistrarEmbersItems.BLEND_CAMINITE}).setRegistryName(getRL("stamp_flat_raw")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stamp_plate_raw"), new ItemStack(RegistrarEmbersItems.STAMP_PLATE_RAW, 1), true, new Object[]{
                "X X",
                "   ",
                "X X",
                'X', RegistrarEmbersItems.BLEND_CAMINITE}).setRegistryName(getRL("stamp_plate_raw")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("block_caminite_brick"), new ItemStack(RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK, 1), true, new Object[]{
                "XX",
                "XX",
                'X', RegistrarEmbersItems.BRICK_CAMINITE}).setRegistryName(getRL("block_caminite_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("block_caminite_brick_slab"), new ItemStack(RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK_SLAB, 6), true, new Object[]{
                "XXX",
                'X', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("block_caminite_brick_slab")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stairs_caminite_brick"), new ItemStack(RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK, 4), true, new Object[]{
                "X  ",
                "XX ",
                "XXX",
                'X', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("stairs_caminite_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("wall_caminite_brick"), new ItemStack(RegistrarEmbersBlocks.WALL_CAMINITE_BRICK, 6), true, new Object[]{
                "XXX",
                "XXX",
                'X', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("wall_caminite_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_stone"), new ItemStack(RegistrarEmbersBlocks.ASHEN_STONE, 4), true, new Object[]{
                " S ",
                "SAS",
                " S ",
                'S', "stone",
                'A', "dustAsh"}).setRegistryName(getRL("ashen_stone")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_stone_slab"), new ItemStack(RegistrarEmbersBlocks.ASHEN_STONE_SLAB, 6), true, new Object[]{
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_STONE}).setRegistryName(getRL("ashen_stone_slab")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stairs_ashen_stone"), new ItemStack(RegistrarEmbersBlocks.STAIRS_ASHEN_STONE, 4), true, new Object[]{
                "X  ",
                "XX ",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_STONE}).setRegistryName(getRL("stairs_ashen_stone")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("wall_ashen_stone"), new ItemStack(RegistrarEmbersBlocks.WALL_ASHEN_STONE, 6), true, new Object[]{
                "XXX",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_STONE}).setRegistryName(getRL("wall_ashen_stone")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_brick"), new ItemStack(RegistrarEmbersBlocks.ASHEN_BRICK, 4), true, new Object[]{
                " S ",
                "SAS",
                " S ",
                'S', Blocks.STONEBRICK,
                'A', "dustAsh"}).setRegistryName(getRL("ashen_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_brick"), new ItemStack(RegistrarEmbersBlocks.ASHEN_BRICK, 4), true, new Object[]{
                "SS",
                "SS",
                'S', RegistrarEmbersBlocks.ASHEN_STONE}).setRegistryName(getRL("ashen_brick2")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_brick_slab"), new ItemStack(RegistrarEmbersBlocks.ASHEN_BRICK_SLAB, 6), true, new Object[]{
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_BRICK}).setRegistryName(getRL("ashen_brick_slab")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stairs_ashen_brick"), new ItemStack(RegistrarEmbersBlocks.STAIRS_ASHEN_BRICK, 4), true, new Object[]{
                "X  ",
                "XX ",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_BRICK}).setRegistryName(getRL("stairs_ashen_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("wall_ashen_brick"), new ItemStack(RegistrarEmbersBlocks.WALL_ASHEN_BRICK, 6), true, new Object[]{
                "XXX",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_BRICK}).setRegistryName(getRL("wall_ashen_brick")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_tile"), new ItemStack(RegistrarEmbersBlocks.ASHEN_TILE, 4), true, new Object[]{
                "SS",
                "SS",
                'S', RegistrarEmbersBlocks.ASHEN_BRICK}).setRegistryName(getRL("ashen_tile")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_tile_slab"), new ItemStack(RegistrarEmbersBlocks.ASHEN_TILE_SLAB, 6), true, new Object[]{
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_TILE}).setRegistryName(getRL("ashen_tile_slab")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stairs_ashen_tile"), new ItemStack(RegistrarEmbersBlocks.STAIRS_ASHEN_TILE, 4), true, new Object[]{
                "X  ",
                "XX ",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_TILE}).setRegistryName(getRL("stairs_ashen_tile")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("wall_ashen_tile"), new ItemStack(RegistrarEmbersBlocks.WALL_ASHEN_TILE, 6), true, new Object[]{
                "XXX",
                "XXX",
                'X', RegistrarEmbersBlocks.ASHEN_TILE}).setRegistryName(getRL("wall_ashen_tile")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_stone"), new ItemStack(RegistrarEmbersBlocks.ASHEN_STONE, 4), true, new Object[]{
                "SS",
                "SS",
                'S', RegistrarEmbersBlocks.ASHEN_TILE}).setRegistryName(getRL("ashen_stone2")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("block_tank"), new ItemStack(RegistrarEmbersBlocks.BLOCK_TANK, 1), true, new Object[]{
                "B B",
                "P P",
                "BIB",
                'I', "ingotIron",
                'P', "plateIron",
                'B', RegistrarEmbersItems.BRICK_CAMINITE}).setRegistryName(getRL("block_tank")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("pipe"), new ItemStack(RegistrarEmbersBlocks.PIPE, 8), true, new Object[]{
                "IPI",
                'P', "plateIron",
                'I', "ingotIron"}).setRegistryName(getRL("pipe")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("pump"), new ItemStack(RegistrarEmbersBlocks.PUMP, 1), true, new Object[]{
                " R ",
                "PBP",
                " R ",
                'P', RegistrarEmbersBlocks.PIPE,
                'B', RegistrarEmbersItems.PLATE_CAMINITE,
                'R', "dustRedstone"}).setRegistryName(getRL("pump")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("block_furnace"), new ItemStack(RegistrarEmbersBlocks.BLOCK_FURNACE, 1), true, new Object[]{
                "BPB",
                "BCB",
                "IFI",
                'P', RegistrarEmbersItems.PLATE_CAMINITE,
                'B', RegistrarEmbersItems.BRICK_CAMINITE,
                'F', Blocks.FURNACE,
                'I', "ingotIron",
                'C', "ingotCopper"}).setRegistryName(getRL("block_furnace")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_receiver"), new ItemStack(RegistrarEmbersBlocks.EMBER_RECEIVER, 4), true, new Object[]{
                "I I",
                "CPC",
                'I', "ingotIron",
                'C', "ingotCopper",
                'P', RegistrarEmbersItems.PLATE_CAMINITE}).setRegistryName(getRL("ember_receiver")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_emitter"), new ItemStack(RegistrarEmbersBlocks.EMBER_EMITTER, 4), true, new Object[]{
                " C ",
                " C ",
                "IPI",
                'I', "ingotIron",
                'C', "ingotCopper",
                'P', RegistrarEmbersItems.PLATE_CAMINITE}).setRegistryName(getRL("ember_emitter")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("copper_cell"), new ItemStack(RegistrarEmbersBlocks.COPPER_CELL, 1), true, new Object[]{
                "BIB",
                "ICI",
                "BIB",
                'I', "ingotIron",
                'C', "blockCopper",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("copper_cell")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("item_pipe"), new ItemStack(RegistrarEmbersBlocks.ITEM_PIPE, 8), true, new Object[]{
                "IPI",
                'P', "plateLead",
                'I', "ingotLead"}).setRegistryName(getRL("item_pipe")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("item_pump"), new ItemStack(RegistrarEmbersBlocks.ITEM_PUMP, 1), true, new Object[]{
                " R ",
                "PBP",
                " R ",
                'P', RegistrarEmbersBlocks.ITEM_PIPE,
                'B', RegistrarEmbersItems.PLATE_CAMINITE,
                'R', "dustRedstone"}).setRegistryName(getRL("item_pump")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("bin"), new ItemStack(RegistrarEmbersBlocks.BIN, 1), true, new Object[]{
                "I I",
                "I I",
                "IPI",
                'P', "plateIron",
                'I', "ingotIron"}).setRegistryName(getRL("bin")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stamper"), new ItemStack(RegistrarEmbersBlocks.STAMPER, 1), true, new Object[]{
                "XCX",
                "XBX",
                "X X",
                'B', "blockIron",
                'C', "ingotCopper",
                'X', RegistrarEmbersItems.BRICK_CAMINITE}).setRegistryName(getRL("stamper")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stamp_base"), new ItemStack(RegistrarEmbersBlocks.STAMP_BASE, 1), true, new Object[]{
                "I I",
                "XBX",
                'I', "ingotIron",
                'B', Items.BUCKET,
                'X', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("stamp_base")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_bore"), new ItemStack(RegistrarEmbersBlocks.EMBER_BORE, 1), true, new Object[]{
                "YCY",
                "YBY",
                "III",
                'I', "ingotIron",
                'B', RegistrarEmbersBlocks.MECH_CORE,
                'Y', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK,
                'C', "ingotCopper"}).setRegistryName(getRL("ember_bore")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("mech_core"), new ItemStack(RegistrarEmbersBlocks.MECH_CORE, 1), true, new Object[]{
                "IBI",
                " P ",
                "I I",
                'I', "ingotIron",
                'P', "plateLead",
                'B', Items.COMPASS}).setRegistryName(getRL("mech_core")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("mech_accessor"), new ItemStack(RegistrarEmbersBlocks.MECH_ACCESSOR, 1), true, new Object[]{
                "SPI",
                'P', "plateIron",
                'S', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK,
                'I', "ingotIron"}).setRegistryName(getRL("mech_accessor")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_activator"), new ItemStack(RegistrarEmbersBlocks.EMBER_ACTIVATOR, 1), true, new Object[]{
                "CCC",
                "CCC",
                "IFI",
                'C', "ingotCopper",
                'F', Blocks.FURNACE,
                'I', "plateIron"}).setRegistryName(getRL("ember_activator")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("stone_edge"), new ItemStack(RegistrarEmbersBlocks.STONE_EDGE, 1), true, new Object[]{
                "XXX",
                "Y Y",
                "XXX",
                'Y', RegistrarEmbersItems.BRICK_CAMINITE,
                'X', RegistrarEmbersBlocks.WALL_CAMINITE_BRICK}).setRegistryName(getRL("stone_edge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("mixer"), new ItemStack(RegistrarEmbersBlocks.MIXER, 1), true, new Object[]{
                "PPP",
                "PCP",
                "IMI",
                'P', "plateIron",
                'C', "ingotCopper",
                'M', RegistrarEmbersBlocks.MECH_CORE,
                'I', "ingotIron"}).setRegistryName(getRL("mixer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("heat_coil"), new ItemStack(RegistrarEmbersBlocks.HEAT_COIL, 1), true, new Object[]{
                "PPP",
                "IBI",
                " M ",
                'P', "plateCopper",
                'B', "blockCopper",
                'M', RegistrarEmbersBlocks.MECH_CORE,
                'I', "ingotIron"}).setRegistryName(getRL("heat_coil")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("item_dropper"), new ItemStack(RegistrarEmbersBlocks.ITEM_DROPPER, 1), true, new Object[]{
                " P ",
                "I I",
                'P', RegistrarEmbersBlocks.PIPE,
                'I', "ingotIron"}).setRegistryName(getRL("item_dropper")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("large_tank"), new ItemStack(RegistrarEmbersBlocks.LARGE_TANK, 1), true, new Object[]{
                "Y Y",
                "I I",
                "YTY",
                'Y', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK,
                'I', "ingotIron",
                'T', RegistrarEmbersBlocks.BLOCK_TANK}).setRegistryName(getRL("large_tank")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_gauge"), new ItemStack(RegistrarEmbersBlocks.EMBER_GAUGE, 1), true, new Object[]{
                "B",
                "P",
                "C",
                'P', Items.PAPER,
                'B', Items.COMPASS,
                'C', "ingotCopper"}).setRegistryName(getRL("ember_gauge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("fluid_gauge"), new ItemStack(RegistrarEmbersBlocks.FLUID_GAUGE, 1), true, new Object[]{
                "B",
                "P",
                "I",
                'P', Items.PAPER,
                'I', "ingotIron",
                'B', Items.COMPASS}).setRegistryName(getRL("fluid_gauge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("block_lantern"), new ItemStack(RegistrarEmbersBlocks.BLOCK_LANTERN, 4), true, new Object[]{
                "P",
                "E",
                "I",
                'E', RegistrarEmbersItems.SHARD_EMBER,
                'I', "ingotIron",
                'P', "plateIron"}).setRegistryName(getRL("block_lantern")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("tinker_hammer"), new ItemStack(RegistrarEmbersItems.TINKER_HAMMER, 1), true, new Object[]{
                "IBI",
                "ISI",
                " S ",
                'B', "ingotLead",
                'I', "ingotIron",
                'S', "stickWood"}).setRegistryName(getRL("tinker_hammer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_detector"), new ItemStack(RegistrarEmbersItems.EMBER_DETECTOR, 1), true, new Object[]{
                " I ",
                "CRC",
                "CIC",
                'C', "ingotCopper",
                'I', "ingotIron",
                'R', "dustRedstone"}).setRegistryName(getRL("ember_detector")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("beam_splitter"), new ItemStack(RegistrarEmbersBlocks.BEAM_SPLITTER, 1), true, new Object[]{
                " D ",
                "CPC",
                " I ",
                'C', "ingotCopper",
                'I', "ingotIron",
                'P', "plateIron",
                'D', "ingotDawnstone"}).setRegistryName(getRL("beam_splitter")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_relay"), new ItemStack(RegistrarEmbersBlocks.EMBER_RELAY, 4), true, new Object[]{
                " C ",
                "C C",
                " P ",
                'C', "ingotCopper",
                'P', "plateIron"}).setRegistryName(getRL("ember_relay")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("crystal_cell"), new ItemStack(RegistrarEmbersBlocks.CRYSTAL_CELL, 1), true, new Object[]{
                " E ",
                "DED",
                "CBC",
                'C', "blockCopper",
                'B', "blockDawnstone",
                'D', "plateDawnstone",
                'E', RegistrarEmbersItems.CRYSTAL_EMBER}).setRegistryName(getRL("crystal_cell")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_jar"), new ItemStack(RegistrarEmbersItems.EMBER_JAR, 1), true, new Object[]{
                " C ",
                "ISI",
                " G ",
                'I', "ingotIron",
                'S', RegistrarEmbersItems.SHARD_EMBER,
                'C', "ingotCopper",
                'G', "blockGlass"}).setRegistryName(getRL("ember_jar")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_cartridge"), new ItemStack(RegistrarEmbersItems.EMBER_CARTRIDGE, 1), true, new Object[]{
                "ICI",
                "GSG",
                " G ",
                'I', "ingotIron",
                'S', RegistrarEmbersItems.CRYSTAL_EMBER,
                'C', "plateCopper",
                'G', "blockGlass"}).setRegistryName(getRL("ember_cartridge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("charger"), new ItemStack(RegistrarEmbersBlocks.CHARGER, 1), true, new Object[]{
                " X ",
                "DCD",
                "IPI",
                'D', "ingotDawnstone",
                'P', "plateCopper",
                'C', "ingotCopper",
                'I', "ingotIron",
                'X', "plateIron"}).setRegistryName(getRL("charger")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("axe_clockwork"), new ItemStack(RegistrarEmbersItems.AXE_CLOCKWORK, 1), true, new Object[]{
                "PCP",
                "ISI",
                " W ",
                'C', "plateCopper",
                'P', "plateDawnstone",
                'I', "ingotDawnstone",
                'S', RegistrarEmbersItems.SHARD_EMBER,
                'W', "stickWood"}).setRegistryName(getRL("axe_clockwork")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("pickaxe_clockwork"), new ItemStack(RegistrarEmbersItems.PICKAXE_CLOCKWORK, 1), true, new Object[]{
                "ISI",
                " C ",
                " W ",
                'C', "ingotCopper",
                'I', "ingotDawnstone",
                'S', RegistrarEmbersItems.SHARD_EMBER,
                'W', "stickWood"}).setRegistryName(getRL("pickaxe_clockwork")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("grandhammer"), new ItemStack(RegistrarEmbersItems.GRANDHAMMER, 1), true, new Object[]{
                "BIB",
                " C ",
                " W ",
                'C', "ingotCopper",
                'I', "ingotDawnstone",
                'B', "blockDawnstone",
                'W', "stickWood"}).setRegistryName(getRL("grandhammer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("staff_ember"), new ItemStack(RegistrarEmbersItems.STAFF_EMBER, 1), true, new Object[]{
                "SES",
                "IWI",
                " W ",
                'S', "plateSilver",
                'I', "ingotDawnstone",
                'E', RegistrarEmbersItems.SHARD_EMBER,
                'W', "stickWood"}).setRegistryName(getRL("staff_ember")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ignition_cannon"), new ItemStack(RegistrarEmbersItems.IGNITION_CANNON, 1), true, new Object[]{
                " DP",
                "DPI",
                "SW ",
                'I', "ingotIron",
                'D', "ingotDawnstone",
                'P', "plateDawnstone",
                'S', RegistrarEmbersItems.SHARD_EMBER,
                'W', "stickWood"}).setRegistryName(getRL("ignition_cannon")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("cinder_plinth"), new ItemStack(RegistrarEmbersBlocks.CINDER_PLINTH, 1), true, new Object[]{
                " P ",
                "SFS",
                "PBP",
                'P', "plateLead",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK,
                'S', "ingotSilver",
                'F', Blocks.FURNACE}).setRegistryName(getRL("cinder_plinth")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("alchemy_pedestal"), new ItemStack(RegistrarEmbersBlocks.ALCHEMY_PEDESTAL, 1), true, new Object[]{
                "D D",
                "ICI",
                "SBS",
                'D', "plateDawnstone",
                'I', "ingotDawnstone",
                'B', "blockCopper",
                'S', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK,
                'C', RegistrarEmbersItems.CRYSTAL_EMBER}).setRegistryName(getRL("alchemy_pedestal")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("alchemy_tablet"), new ItemStack(RegistrarEmbersBlocks.ALCHEMY_TABLET, 1), true, new Object[]{
                " D ",
                "SXS",
                "BIB",
                'D', "plateDawnstone",
                'I', "ingotDawnstone",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK,
                'S', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK,
                'X', "plateCopper"}).setRegistryName(getRL("alchemy_tablet")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("item_transfer"), new ItemStack(RegistrarEmbersBlocks.ITEM_TRANSFER, 2), true, new Object[]{
                "PLP",
                "ILI",
                "I I",
                'P', "plateLead",
                'I', "ingotLead",
                'L', RegistrarEmbersBlocks.ITEM_PIPE}).setRegistryName(getRL("item_transfer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("beam_cannon"), new ItemStack(RegistrarEmbersBlocks.BEAM_CANNON, 1), true, new Object[]{
                "PSP",
                "PSP",
                "IBI",
                'S', RegistrarEmbersItems.CRYSTAL_EMBER,
                'P', "plateCopper",
                'I', "ingotDawnstone",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("beam_cannon")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_cloak_head"), new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_HEAD, 1), true, new Object[]{
                " S ",
                "C C",
                "DCD",
                'S', "string",
                'D', "ingotDawnstone",
                'C', RegistrarEmbersItems.ASHEN_CLOTH}).setRegistryName(getRL("ashen_cloak_head")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_cloak_chest"), new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_CHEST, 1), true, new Object[]{
                "P P",
                "CDC",
                "CDC",
                'D', "ingotDawnstone",
                'P', "plateDawnstone",
                'C', RegistrarEmbersItems.ASHEN_CLOTH}).setRegistryName(getRL("ashen_cloak_chest")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_cloak_legs"), new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_LEGS, 1), true, new Object[]{
                "CCC",
                "D D",
                "D D",
                'D', "ingotDawnstone",
                'C', RegistrarEmbersItems.ASHEN_CLOTH}).setRegistryName(getRL("ashen_cloak_legs")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ashen_cloak_boots"), new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_BOOTS, 1), true, new Object[]{
                "C C",
                "C C",
                "C C",
                'C', RegistrarEmbersItems.ASHEN_CLOTH}).setRegistryName(getRL("ashen_cloak_boots")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("sealed_planks"), new ItemStack(RegistrarEmbersBlocks.SEALED_PLANKS, 8), true, new Object[]{
                "PPP",
                "PSP",
                "PPP",
                'S', "slimeball",
                'P', "plankWood"}).setRegistryName(getRL("sealed_planks")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL("wrapped_sealed_planks"), new ItemStack(RegistrarEmbersBlocks.WRAPPED_SEALED_PLANKS, 1), new Object[]{
                Blocks.IRON_BARS, RegistrarEmbersBlocks.SEALED_PLANKS}).setRegistryName(getRL("wrapped_sealed_planks")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_bricks"), new ItemStack(RegistrarEmbersBlocks.ARCHAIC_BRICKS, 1), true, new Object[]{
                "BB",
                "BB",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK}).setRegistryName(getRL("archaic_bricks")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_light"), new ItemStack(RegistrarEmbersBlocks.ARCHAIC_LIGHT, 1), true, new Object[]{
                " B ",
                "BSB",
                " B ",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK,
                'S', RegistrarEmbersItems.SHARD_EMBER}).setRegistryName(getRL("archaic_light")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("dawnstone_anvil"), new ItemStack(RegistrarEmbersBlocks.DAWNSTONE_ANVIL, 1), true, new Object[]{
                "BBB",
                "cIc",
                "CCC",
                'B', "blockDawnstone",
                'I', "ingotDawnstone",
                'C', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK,
                'c', RegistrarEmbersItems.BRICK_CAMINITE}).setRegistryName(getRL("dawnstone_anvil")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("auto_hammer"), new ItemStack(RegistrarEmbersBlocks.AUTO_HAMMER, 1), true, new Object[]{
                "cc ",
                "CIB",
                "cc ",
                'B', "blockIron",
                'I', "ingotIron",
                'C', "blockCopper",
                'c', RegistrarEmbersBlocks.STAIRS_CAMINITE_BRICK}).setMirrored(true).setRegistryName(getRL("auto_hammer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("vacuum"), new ItemStack(RegistrarEmbersBlocks.VACUUM, 1), true, new Object[]{
                " LL",
                "P  ",
                " LL",
                'P', RegistrarEmbersBlocks.ITEM_PIPE,
                'L', "ingotLead"}).setMirrored(true).setRegistryName(getRL("vacuum")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_edge"), new ItemStack(RegistrarEmbersBlocks.ARCHAIC_EDGE, 2), true, new Object[]{
                "BBB",
                "BCB",
                "BBB",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK,
                'C', RegistrarEmbersItems.SHARD_EMBER}).setRegistryName(getRL("archaic_edge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_tile"), new ItemStack(RegistrarEmbersBlocks.ARCHAIC_TILE, 4), true, new Object[]{
                "BB",
                "BB",
                'B', RegistrarEmbersBlocks.ARCHAIC_BRICKS}).setRegistryName(getRL("archaic_tile")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_bricks"), new ItemStack(RegistrarEmbersBlocks.ARCHAIC_BRICKS, 4), true, new Object[]{
                "BB",
                "BB",
                'B', RegistrarEmbersBlocks.ARCHAIC_TILE}).setRegistryName(getRL("archaic_bricks")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("breaker"), new ItemStack(RegistrarEmbersBlocks.BREAKER, 1), true, new Object[]{
                "PIP",
                "LRL",
                "L L",
                'P', "plateIron",
                'I', Items.IRON_INGOT,
                'L', "ingotLead",
                'R', Items.REDSTONE}).setRegistryName(getRL("breaker")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_injector"), new ItemStack(RegistrarEmbersBlocks.EMBER_INJECTOR, 1), true, new Object[]{
                "S S",
                "DCD",
                "BPB",
                'P', "plateSilver",
                'S', "ingotSilver",
                'D', "plateDawnstone",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK,
                'C', RegistrarEmbersItems.WILDFIRE_CORE}).setRegistryName(getRL("ember_injector")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("boiler"), new ItemStack(RegistrarEmbersBlocks.BOILER, 1), true, new Object[]{
                "CCC",
                "IFI",
                "IBI",
                'B', "blockCopper",
                'I', Items.IRON_INGOT,
                'C', "ingotCopper",
                'F', Blocks.FURNACE}).setRegistryName(getRL("boiler")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("reactor"), new ItemStack(RegistrarEmbersBlocks.REACTOR, 1), true, new Object[]{
                "CCC",
                "CWC",
                "SBS",
                'B', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK,
                'W', RegistrarEmbersItems.WILDFIRE_CORE,
                'C', "ingotCopper",
                'S', "plateSilver"}).setRegistryName(getRL("reactor")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("combustor"), new ItemStack(RegistrarEmbersBlocks.COMBUSTOR, 1), true, new Object[]{
                " C ",
                "PEP",
                "CMC",
                'M', RegistrarEmbersBlocks.MECH_CORE,
                'P', "plateCopper",
                'C', "ingotCopper",
                'E', RegistrarEmbersItems.EMBER_CLUSTER}).setRegistryName(getRL("combustor")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("catalyzer"), new ItemStack(RegistrarEmbersBlocks.CATALYZER, 1), true, new Object[]{
                " C ",
                "PEP",
                "CMC",
                'M', RegistrarEmbersBlocks.MECH_CORE,
                'P', "plateSilver",
                'C', "ingotSilver",
                'E', RegistrarEmbersItems.EMBER_CLUSTER}).setRegistryName(getRL("catalyzer")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("codex"), new ItemStack(RegistrarEmbersItems.CODEX, 1), true, new Object[]{
                " B ",
                " E ",
                " B ",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK,
                'E', RegistrarEmbersItems.ANCIENT_MOTIVE_CORE}).setRegistryName(getRL("codex")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("field_chart"), new ItemStack(RegistrarEmbersBlocks.FIELD_CHART, 1), true, new Object[]{
                "BBB",
                "BCB",
                "BBB",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK,
                'C', RegistrarEmbersItems.EMBER_CLUSTER}).setRegistryName(getRL("field_chart")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("archaic_circuit"), new ItemStack(RegistrarEmbersItems.ARCHAIC_CIRCUIT, 1), true, new Object[]{
                " B ",
                "BCB",
                " B ",
                'B', RegistrarEmbersItems.ARCHAIC_BRICK,
                'C', "ingotCopper"}).setRegistryName(getRL("archaic_circuit")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("inferno_forge"), new ItemStack(RegistrarEmbersBlocks.INFERNO_FORGE, 1), true, new Object[]{
                "BPB",
                "DCD",
                "SWS",
                'B', RegistrarEmbersBlocks.BLOCK_DAWNSTONE,
                'D', "ingotDawnstone",
                'C', "blockCopper",
                'W', RegistrarEmbersItems.WILDFIRE_CORE,
                'P', "plateIron",
                'S', RegistrarEmbersBlocks.BLOCK_CAMINITE_BRICK}).setRegistryName(getRL("inferno_forge")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("superheater"), new ItemStack(RegistrarEmbersItems.SUPERHEATER, 1), true, new Object[]{
                " ID",
                "PPI",
                "PP ",
                'I', "ingotDawnstone",
                'D', "plateDawnstone",
                'P', "ingotCopper"}).setRegistryName(getRL("superheater")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("resonating_bell"), new ItemStack(RegistrarEmbersItems.RESONATING_BELL, 1), true, new Object[]{
                "IIP",
                " sI",
                "S I",
                'I', "ingotIron",
                's', "ingotSilver",
                'P', "plateIron",
                'S', "plateSilver"}).setRegistryName(getRL("resonating_bell")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("jet_augment"), new ItemStack(RegistrarEmbersItems.JET_AUGMENT, 1), true, new Object[]{
                "PP ",
                "IsD",
                "PP ",
                'I', "ingotIron",
                's', RegistrarEmbersItems.SHARD_EMBER,
                'P', "plateDawnstone",
                'D', "ingotDawnstone"}).setRegistryName(getRL("jet_augment")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("caster_orb"), new ItemStack(RegistrarEmbersItems.CASTER_ORB, 1), true, new Object[]{
                "DCD",
                "D D",
                " P ",
                'C', RegistrarEmbersItems.CRYSTAL_EMBER,
                'P', "plateDawnstone",
                'D', "ingotDawnstone"}).setRegistryName(getRL("caster_orb")));
        event.getRegistry().register(new ShapedOreRecipe(getRL("ember_pulser"), new ItemStack(RegistrarEmbersBlocks.EMBER_PULSER, 1), true, new Object[]{
                "D",
                "E",
                "I",
                'E', RegistrarEmbersBlocks.EMBER_EMITTER,
                'I', "ingotIron",
                'D', "plateDawnstone"}).setRegistryName(getRL("ember_pulser")));
        /*event.getRegistry().register(new ShapedOreRecipe(getRL("ember_ring"),new ItemStack(RegistrarEmbersItems.EMBER_RING,1),true,new Object[]{
				"CN ",
				"N N",
				" N ",
				'C', RegistrarEmbersItems.EMBER_CLUSTER,
				'N', "nuggetDawnstone"}).setMirrored(true).setRegistryName(getRL("ember_ring")));
		event.getRegistry().register(new ShapedOreRecipe(getRL("ember_amulet"),new ItemStack(RegistrarEmbersItems.EMBER_AMULET,1),true,new Object[]{
				" L ",
				"L L",
				"NCN",
				'C', RegistrarEmbersItems.EMBER_CLUSTER,
				'N', "nuggetDawnstone",
				'L', Items.LEATHER}).setMirrored(true).setRegistryName(getRL("ember_amulet")));
		event.getRegistry().register(new ShapedOreRecipe(getRL("ember_belt"),new ItemStack(RegistrarEmbersItems.EMBER_BELT,1),true,new Object[]{
				"LIL",
				"L L",
				"PCP",
				'C', RegistrarEmbersItems.EMBER_CLUSTER,
				'I', "ingotDawnstone",
				'P', "plateDawnstone",
				'L', Items.LEATHER}).setMirrored(true).setRegistryName(getRL("ember_belt")));*/
        event.getRegistry().register(new ShapedOreRecipe(getRL("caminite_lever"), new ItemStack(RegistrarEmbersBlocks.CAMINITE_LEVER, 4), true, new Object[]{
                "S",
                "P",
                'S', "stickWood",
                'P', new ItemStack(RegistrarEmbersItems.PLATE_CAMINITE)}).setRegistryName(getRL("caminite_lever")));
        event.getRegistry().register(new AshenCloakSocketRecipe().setRegistryName(getRL("cloak_socketing")));
        event.getRegistry().register(new AshenCloakUnsocketRecipe().setRegistryName(getRL("cloak_unsocketing")));

        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_COPPER), new ItemStack(RegistrarEmbersItems.INGOT_COPPER), 0.65f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_SILVER), new ItemStack(RegistrarEmbersItems.INGOT_SILVER), 0.35f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_LEAD), new ItemStack(RegistrarEmbersItems.INGOT_LEAD), 0.35f);
        if (ConfigHandler.compat.enableAluminum) {
            GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_ALUMINUM), new ItemStack(RegistrarEmbersItems.INGOT_ALUMINUM), 0.55f);
        }
        if (ConfigHandler.compat.enableTin) {
            GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_TIN), new ItemStack(RegistrarEmbersItems.INGOT_TIN), 0.55f);
        }
        if (ConfigHandler.compat.enableNickel) {
            GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_NICKEL), new ItemStack(RegistrarEmbersItems.INGOT_NICKEL), 0.55f);
        }
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersBlocks.ORE_QUARTZ), new ItemStack(Items.QUARTZ), 0.35f);

        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersItems.BLEND_CAMINITE), new ItemStack(RegistrarEmbersItems.BRICK_CAMINITE), 0.35f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersItems.PLATE_CAMINITE_RAW), new ItemStack(RegistrarEmbersItems.PLATE_CAMINITE), 0.35f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersItems.STAMP_BAR_RAW), new ItemStack(RegistrarEmbersItems.STAMP_BAR), 0.35f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersItems.STAMP_PLATE_RAW), new ItemStack(RegistrarEmbersItems.STAMP_PLATE), 0.35f);
        GameRegistry.addSmelting(new ItemStack(RegistrarEmbersItems.STAMP_FLAT_RAW), new ItemStack(RegistrarEmbersItems.STAMP_FLAT), 0.35f);

        meltingOreRecipes.add(new ItemMeltingOreRecipe("oreIron", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 288)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotIron", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetIron", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateIron", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 144)));

        meltingOreRecipes.add(new ItemMeltingOreRecipe("oreGold", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 288)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotGold", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetGold", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateGold", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 144)));

        meltingOreRecipes.add(new ItemMeltingOreRecipe("oreSilver", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 288)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotSilver", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetSilver", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateSilver", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 144)));

        meltingOreRecipes.add(new ItemMeltingOreRecipe("oreCopper", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 288)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotCopper", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetCopper", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateCopper", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 144)));

        meltingOreRecipes.add(new ItemMeltingOreRecipe("oreLead", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 288)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotLead", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetLead", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateLead", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 144)));

        if (ConfigHandler.compat.enableAluminum) {
            meltingOreRecipes.add(new ItemMeltingOreRecipe("oreAluminum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 288)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotAluminum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 144)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetAluminum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 16)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("plateAluminum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 144)));
        }

        if (ConfigHandler.compat.enableNickel) {
            meltingOreRecipes.add(new ItemMeltingOreRecipe("oreNickel", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 288)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotNickel", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 144)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetNickel", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 16)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("plateNickel", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 144)));
        }

        if (ConfigHandler.compat.enableTin) {
            meltingOreRecipes.add(new ItemMeltingOreRecipe("oreTin", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 288)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotTin", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 144)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetTin", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 16)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("plateTin", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 144)));
        }

        meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotDawnstone", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 144)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetDawnstone", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 16)));
        meltingOreRecipes.add(new ItemMeltingOreRecipe("plateDawnstone", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 144)));

        if (ConfigHandler.compat.enableBronze) {
            meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotBronze", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 144)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetBronze", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 16)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("plateBronze", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 144)));
        }

        if (ConfigHandler.compat.enableElectrum) {
            meltingOreRecipes.add(new ItemMeltingOreRecipe("ingotElectrum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 144)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("nuggetElectrum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 16)));
            meltingOreRecipes.add(new ItemMeltingOreRecipe("plateElectrum", new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 144)));
        }

        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 144), EnumStampType.TYPE_BAR, new ItemStack(Items.IRON_INGOT, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 144), EnumStampType.TYPE_BAR, new ItemStack(Items.GOLD_INGOT, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_LEAD, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_SILVER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_COPPER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE, 1), false, false));
        if (ConfigHandler.compat.enableAluminum) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_ALUMINUM, 1), false, false));
        }
        if (ConfigHandler.compat.enableBronze) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_BRONZE, 1), false, false));
        }
        if (ConfigHandler.compat.enableElectrum) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_ELECTRUM, 1), false, false));
        }
        if (ConfigHandler.compat.enableNickel) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_NICKEL, 1), false, false));
        }
        if (ConfigHandler.compat.enableTin) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 144), EnumStampType.TYPE_BAR, new ItemStack(RegistrarEmbersItems.INGOT_TIN, 1), false, false));
        }

        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_IRON, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_GOLD, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_LEAD, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_SILVER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_COPPER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_DAWNSTONE, 1), false, false));
        if (ConfigHandler.compat.enableAluminum) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ALUMINUM, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_ALUMINUM, 1), false, false));
        }
        if (ConfigHandler.compat.enableBronze) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_BRONZE, 1), false, false));
        }
        if (ConfigHandler.compat.enableElectrum) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_ELECTRUM, 1), false, false));
        }
        if (ConfigHandler.compat.enableNickel) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_NICKEL, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_NICKEL, 1), false, false));
        }
        if (ConfigHandler.compat.enableTin) {
            stampingRecipes.add(new ItemStampingRecipe(ItemStack.EMPTY, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.PLATE_TIN, 1), false, false));
        }
        stampingRecipes.add(new ItemWasteStampingRecipe());

        stampingRecipes.add(new ItemStampingRecipe(new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_IRON, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.ASPECTUS_IRON, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_LEAD, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.ASPECTUS_LEAD, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.ASPECTUS_SILVER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.ASPECTUS_COPPER, 1), false, false));
        stampingRecipes.add(new ItemStampingRecipe(new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 144), EnumStampType.TYPE_PLATE, new ItemStack(RegistrarEmbersItems.ASPECTUS_DAWNSTONE, 1), false, false));

        mixingRecipes.add(new FluidMixingRecipe(new FluidStack[]{new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 4), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 4)}, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_DAWNSTONE, 8)));
        if (ConfigHandler.compat.enableElectrum) {
            mixingRecipes.add(new FluidMixingRecipe(new FluidStack[]{new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_SILVER, 4), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_GOLD, 4)}, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_ELECTRUM, 8)));
        }
        if (ConfigHandler.compat.enableTin && ConfigHandler.compat.enableBronze) {
            mixingRecipes.add(new FluidMixingRecipe(new FluidStack[]{new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_COPPER, 6), new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_TIN, 2)}, new FluidStack(RegistrarEmbersBlocks.FLUID_MOLTEN_BRONZE, 8)));
        }

        alchemyRecipes.add(new AlchemyRecipe(48, 64, 0, 0, 48, 64, 0, 0, 0, 0, new ItemStack(Items.QUARTZ), new ItemStack(RegistrarEmbersItems.INGOT_COPPER), new ItemStack(RegistrarEmbersItems.INGOT_COPPER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersBlocks.SEED, 1, 2)));
        alchemyRecipes.add(new AlchemyRecipe(48, 64, 0, 0, 0, 0, 48, 64, 0, 0, new ItemStack(Items.QUARTZ), new ItemStack(RegistrarEmbersItems.INGOT_SILVER), new ItemStack(RegistrarEmbersItems.INGOT_SILVER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersBlocks.SEED, 1, 4)));
        alchemyRecipes.add(new AlchemyRecipe(48, 64, 0, 0, 0, 0, 0, 0, 48, 64, new ItemStack(Items.QUARTZ), new ItemStack(RegistrarEmbersItems.INGOT_LEAD), new ItemStack(RegistrarEmbersItems.INGOT_LEAD), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersBlocks.SEED, 1, 3)));
        alchemyRecipes.add(new AlchemyRecipe(48, 64, 48, 64, 0, 0, 0, 0, 0, 0, new ItemStack(Items.QUARTZ), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersBlocks.SEED, 1, 1)));
        alchemyRecipes.add(new AlchemyRecipe(96, 128, 0, 0, 0, 0, 0, 0, 0, 0, new ItemStack(Items.QUARTZ), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersBlocks.SEED, 1, 0)));
        alchemyRecipes.add(new AlchemyRecipe(12, 24, 0, 0, 0, 0, 0, 0, 12, 24, new ItemStack(Blocks.WOOL), new ItemStack(RegistrarEmbersItems.DUST_ASH), new ItemStack(RegistrarEmbersItems.DUST_ASH), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(RegistrarEmbersItems.ASHEN_CLOTH, 2)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 32, 48, 0, 0, 0, 0, 24, 40, new ItemStack(Items.DIAMOND), new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE), new ItemStack(Items.COAL), new ItemStack(Items.COAL), new ItemStack(Items.COAL), new ItemStack(RegistrarEmbersItems.INFLICTOR_GEM, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 64, 80, 0, 0, 0, 0, 0, 0, new ItemStack(Items.QUARTZ), new ItemStack(Items.GUNPOWDER), new ItemStack(Items.GUNPOWDER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.GLIMMER_SHARD, 1)));
        alchemyRecipes.add(new AlchemyRecipe(24, 36, 0, 0, 0, 0, 0, 0, 0, 0, new ItemStack(Items.IRON_INGOT), new ItemStack(Items.QUARTZ), new ItemStack(Items.CLAY_BALL), new ItemStack(Items.DYE, 1, 4), ItemStack.EMPTY, new ItemStack(RegistrarEmbersItems.ISOLATED_MATERIA, 4)));
        alchemyRecipes.add(new AlchemyRecipe(12, 18, 0, 0, 0, 0, 0, 0, 0, 0, new ItemStack(Items.CLAY_BALL), new ItemStack(Items.DYE, 1, 15), new ItemStack(Items.DYE, 1, 15), ItemStack.EMPTY, ItemStack.EMPTY, new ItemStack(RegistrarEmbersItems.ADHESIVE, 6)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 0, 0, 8, 16, 0, 0, 0, 0, new ItemStack(Items.REDSTONE), new ItemStack(RegistrarEmbersItems.DUST_ASH), new ItemStack(RegistrarEmbersItems.DUST_ASH), new ItemStack(Blocks.COBBLESTONE, 1), new ItemStack(Blocks.COBBLESTONE), new ItemStack(Blocks.NETHERRACK, 2)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 0, 0, 8, 16, 0, 0, 0, 0, new ItemStack(RegistrarEmbersItems.DUST_ASH), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SAND), new ItemStack(Blocks.SOUL_SAND, 4)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 0, 0, 0, 0, 64, 96, 64, 96, new ItemStack(RegistrarEmbersItems.SWORD_LEAD, 1), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Blocks.OBSIDIAN), new ItemStack(RegistrarEmbersItems.INGOT_LEAD), new ItemStack(RegistrarEmbersItems.INGOT_LEAD), new ItemStack(RegistrarEmbersItems.TYRFING, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 24, 48, 24, 48, 0, 0, 0, 0, new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER, 1), new ItemStack(Items.GUNPOWDER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.SHARD_EMBER), new ItemStack(RegistrarEmbersItems.EMBER_CLUSTER, 1)));
        alchemyRecipes.add(new AlchemyRecipe(32, 48, 0, 0, 0, 0, 24, 32, 0, 0, new ItemStack(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE, 1), new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE), new ItemStack(RegistrarEmbersItems.EMBER_CLUSTER), new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE), new ItemStack(RegistrarEmbersItems.PLATE_COPPER), new ItemStack(RegistrarEmbersItems.WILDFIRE_CORE, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 4, 8, 0, 0, 0, 0, 0, 0, new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK, 1), new ItemStack(Blocks.SOUL_SAND), new ItemStack(Blocks.SOUL_SAND), new ItemStack(Items.CLAY_BALL), new ItemStack(Items.CLAY_BALL), new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK, 5)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 24, 32, 0, 0, 0, 0, 0, 0, new ItemStack(RegistrarEmbersItems.SHARD_EMBER, 1), new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK), new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK), new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK), new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK), new ItemStack(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE, 1)));

        alchemyRecipes.add(new AlchemyRecipe(0, 0, 0, 0, 16, 24, 0, 0, 0, 0,
                new ItemStack(Items.GUNPOWDER, 1),
                new ItemStack(RegistrarEmbersItems.PLATE_IRON),
                new ItemStack(RegistrarEmbersItems.PLATE_IRON),
                new ItemStack(RegistrarEmbersItems.PLATE_IRON),
                new ItemStack(RegistrarEmbersItems.INGOT_COPPER),
                new ItemStack(RegistrarEmbersItems.BLASTING_CORE, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 16, 32, 0, 0, 0, 0, 48, 72,
                new ItemStack(RegistrarEmbersItems.ARCHAIC_CIRCUIT, 1),
                new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK),
                new ItemStack(Items.COAL),
                new ItemStack(RegistrarEmbersItems.ARCHAIC_BRICK),
                new ItemStack(Items.COAL),
                new ItemStack(RegistrarEmbersItems.ELDRITCH_INSIGNIA, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 0, 0, 24, 48, 0, 0, 40, 64,
                new ItemStack(RegistrarEmbersItems.PLATE_COPPER, 1),
                new ItemStack(RegistrarEmbersItems.ARCHAIC_CIRCUIT),
                new ItemStack(RegistrarEmbersItems.INGOT_COPPER),
                new ItemStack(RegistrarEmbersItems.ARCHAIC_CIRCUIT),
                new ItemStack(RegistrarEmbersItems.INGOT_COPPER),
                new ItemStack(RegistrarEmbersItems.INTELLIGENT_APPARATUS, 1)));
        alchemyRecipes.add(new AlchemyRecipe(0, 0, 16, 32, 0, 0, 16, 32, 0, 0,
                new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER, 1),
                new ItemStack(RegistrarEmbersItems.PLATE_DAWNSTONE),
                new ItemStack(RegistrarEmbersItems.PLATE_DAWNSTONE),
                new ItemStack(RegistrarEmbersItems.PLATE_DAWNSTONE),
                new ItemStack(RegistrarEmbersItems.INGOT_SILVER),
                new ItemStack(RegistrarEmbersItems.FLAME_BARRIER, 1)));
    }

    public static ResourceLocation getRL(String s) {
        return new ResourceLocation(Embers.MODID + ":" + s);
    }

    public static void registerMaterialSet(RegistryEvent.Register<IRecipe> event, String ingotKey, String nuggetKey, String blockKey,
                                           Item ingot, Item nugget, Item plate, Block block, Item pickaxe, Item axe, Item shovel, Item hoe, Item sword) {
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_block"), new ItemStack(block), true, new Object[]{
                "XXX",
                "XXX",
                "XXX",
                'X', ingotKey}).setRegistryName(getRL(ingotKey + "_block")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_ingot"), new ItemStack(ingot), true, new Object[]{
                "XXX",
                "XXX",
                "XXX",
                'X', nuggetKey}).setRegistryName(getRL(ingotKey + "_ingot")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL(ingotKey + "_block_decomp"), new ItemStack(ingot, 9), new Object[]{
                blockKey}).setRegistryName(getRL(ingotKey + "_block_decomp")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL(ingotKey + "_ingot_decomp"), new ItemStack(nugget, 9), new Object[]{
                ingotKey}).setRegistryName(getRL(ingotKey + "_ingot_decomp")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_sword"), new ItemStack(sword, 1), true, new Object[]{
                " C ",
                " C ",
                " S ",
                'C', ingotKey,
                'S', "stickWood"}).setRegistryName(getRL(ingotKey + "_sword")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_pickaxe"), new ItemStack(pickaxe, 1), true, new Object[]{
                "CCC",
                " S ",
                " S ",
                'C', ingotKey,
                'S', "stickWood"}).setRegistryName(getRL(ingotKey + "_pickaxe")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_shovel"), new ItemStack(shovel, 1), true, new Object[]{
                " C ",
                " S ",
                " S ",
                'C', ingotKey,
                'S', "stickWood"}).setRegistryName(getRL(ingotKey + "_shovel")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_axe"), new ItemStack(axe, 1), true, new Object[]{
                " CC",
                " SC",
                " S ",
                'C', ingotKey,
                'S', "stickWood"}).setMirrored(true).setRegistryName(getRL(ingotKey + "_axe")));
        event.getRegistry().register(new ShapedOreRecipe(getRL(ingotKey + "_hoe"), new ItemStack(hoe, 1), true, new Object[]{
                " CC",
                " S ",
                " S ",
                'C', ingotKey,
                'S', "stickWood"}).setMirrored(true).setRegistryName(getRL(ingotKey + "_hoe")));
        event.getRegistry().register(new ShapelessOreRecipe(getRL(ingotKey + "_plate"), new ItemStack(plate, 1), new Object[]{
                ingotKey, ingotKey, ingotKey, ingotKey, RegistrarEmbersItems.TINKER_HAMMER}).setRegistryName(getRL(ingotKey + "_plate")));
    }

    public static void initOreDict() {
        OreDictionary.registerOre("nuggetIron", RegistrarEmbersItems.NUGGET_IRON);
        OreDictionary.registerOre("ingotCopper", RegistrarEmbersItems.INGOT_COPPER);
        OreDictionary.registerOre("ingotLead", RegistrarEmbersItems.INGOT_LEAD);
        OreDictionary.registerOre("ingotSilver", RegistrarEmbersItems.INGOT_SILVER);
        OreDictionary.registerOre("ingotDawnstone", RegistrarEmbersItems.INGOT_DAWNSTONE);
        OreDictionary.registerOre("nuggetCopper", RegistrarEmbersItems.NUGGET_COPPER);
        OreDictionary.registerOre("nuggetLead", RegistrarEmbersItems.NUGGET_LEAD);
        OreDictionary.registerOre("nuggetSilver", RegistrarEmbersItems.NUGGET_SILVER);
        OreDictionary.registerOre("nuggetDawnstone", RegistrarEmbersItems.NUGGET_DAWNSTONE);
        OreDictionary.registerOre("plateGold", RegistrarEmbersItems.PLATE_GOLD);
        OreDictionary.registerOre("plateIron", RegistrarEmbersItems.PLATE_IRON);
        OreDictionary.registerOre("plateCopper", RegistrarEmbersItems.PLATE_COPPER);
        OreDictionary.registerOre("plateLead", RegistrarEmbersItems.PLATE_LEAD);
        OreDictionary.registerOre("plateSilver", RegistrarEmbersItems.PLATE_SILVER);
        OreDictionary.registerOre("plateDawnstone", RegistrarEmbersItems.PLATE_DAWNSTONE);
        OreDictionary.registerOre("blockCopper", RegistrarEmbersBlocks.BLOCK_COPPER);
        OreDictionary.registerOre("blockLead", RegistrarEmbersBlocks.BLOCK_LEAD);
        OreDictionary.registerOre("blockSilver", RegistrarEmbersBlocks.BLOCK_SILVER);
        OreDictionary.registerOre("blockDawnstone", RegistrarEmbersBlocks.BLOCK_DAWNSTONE);
        OreDictionary.registerOre("oreCopper", RegistrarEmbersBlocks.ORE_COPPER);
        OreDictionary.registerOre("oreLead", RegistrarEmbersBlocks.ORE_LEAD);
        OreDictionary.registerOre("oreSilver", RegistrarEmbersBlocks.ORE_SILVER);
        OreDictionary.registerOre("oreQuartz", RegistrarEmbersBlocks.ORE_QUARTZ);
        OreDictionary.registerOre("slimeball", RegistrarEmbersItems.ADHESIVE);
        OreDictionary.registerOre("nuggetIron", RegistrarEmbersItems.NUGGET_IRON);
        OreDictionary.registerOre("dustAsh", RegistrarEmbersItems.DUST_ASH);
        OreDictionary.registerOre("dustAshes", RegistrarEmbersItems.DUST_ASH);

        if (ConfigHandler.compat.enableAluminum) {
            OreDictionary.registerOre("blockAluminum", RegistrarEmbersBlocks.BLOCK_ALUMINUM);
            OreDictionary.registerOre("ingotAluminum", RegistrarEmbersItems.INGOT_ALUMINUM);
            OreDictionary.registerOre("nuggetAluminum", RegistrarEmbersItems.NUGGET_ALUMINUM);
            OreDictionary.registerOre("plateAluminum", RegistrarEmbersItems.PLATE_ALUMINUM);
            OreDictionary.registerOre("oreAluminum", RegistrarEmbersBlocks.ORE_ALUMINUM);
        }

        if (ConfigHandler.compat.enableTin) {
            OreDictionary.registerOre("blockTin", RegistrarEmbersBlocks.BLOCK_TIN);
            OreDictionary.registerOre("ingotTin", RegistrarEmbersItems.INGOT_TIN);
            OreDictionary.registerOre("nuggetTin", RegistrarEmbersItems.NUGGET_TIN);
            OreDictionary.registerOre("plateTin", RegistrarEmbersItems.PLATE_TIN);
            OreDictionary.registerOre("oreTin", RegistrarEmbersBlocks.ORE_TIN);
        }

        if (ConfigHandler.compat.enableNickel) {
            OreDictionary.registerOre("blockNickel", RegistrarEmbersBlocks.BLOCK_NICKEL);
            OreDictionary.registerOre("ingotNickel", RegistrarEmbersItems.INGOT_NICKEL);
            OreDictionary.registerOre("nuggetNickel", RegistrarEmbersItems.NUGGET_NICKEL);
            OreDictionary.registerOre("plateNickel", RegistrarEmbersItems.PLATE_NICKEL);
            OreDictionary.registerOre("oreNickel", RegistrarEmbersBlocks.ORE_NICKEL);
        }

        if (ConfigHandler.compat.enableBronze) {
            OreDictionary.registerOre("blockBronze", RegistrarEmbersBlocks.BLOCK_BRONZE);
            OreDictionary.registerOre("ingotBronze", RegistrarEmbersItems.INGOT_BRONZE);
            OreDictionary.registerOre("nuggetBronze", RegistrarEmbersItems.NUGGET_BRONZE);
            OreDictionary.registerOre("plateBronze", RegistrarEmbersItems.PLATE_BRONZE);
        }

        if (ConfigHandler.compat.enableElectrum) {
            OreDictionary.registerOre("blockElectrum", RegistrarEmbersBlocks.BLOCK_ELECTRUM);
            OreDictionary.registerOre("ingotElectrum", RegistrarEmbersItems.INGOT_ELECTRUM);
            OreDictionary.registerOre("nuggetElectrum", RegistrarEmbersItems.NUGGET_ELECTRUM);
            OreDictionary.registerOre("plateElectrum", RegistrarEmbersItems.PLATE_ELECTRUM);
        }
    }

    public static ItemStampingRecipe getStampingRecipe(ItemStack stack, FluidStack fluid, EnumStampType type) {
        for (ItemStampingRecipe stampingRecipe : stampingRecipes) {
            if (stampingRecipe.matches(stack, fluid, type)) {
                return stampingRecipe;
            }
        }
        return null;
    }

    public static ItemStampingOreRecipe getStampingOreRecipe(ItemStack stack, FluidStack fluid, EnumStampType type) {
        for (ItemStampingOreRecipe stampingOreRecipe : stampingOreRecipes) {
            if (stampingOreRecipe.matches(stack, fluid, type)) {
                return stampingOreRecipe;
            }
        }
        return null;
    }

    public static ItemMeltingRecipe getMeltingRecipe(ItemStack stack) {
        for (ItemMeltingRecipe meltingRecipe : meltingRecipes) {
            if (meltingRecipe.matches(stack)) {
                return meltingRecipe;
            }
        }
        return null;
    }

    public static ItemMeltingOreRecipe getMeltingOreRecipe(ItemStack stack) {
        for (ItemMeltingOreRecipe meltingOreRecipe : meltingOreRecipes) {
            if (meltingOreRecipe.matches(stack)) {
                return meltingOreRecipe;
            }
        }
        return null;
    }

    public static FluidMixingRecipe getMixingRecipe(ArrayList<FluidStack> fluids) {
        for (FluidMixingRecipe mixingRecipe : mixingRecipes) {
            if (mixingRecipe.matches(fluids)) {
                return mixingRecipe;
            }
        }
        return null;
    }

    public static AlchemyRecipe getAlchemyRecipe(ItemStack center, ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4) {
        List<ItemStack> list = new ArrayList<ItemStack>();
        if (stack1 != ItemStack.EMPTY) {
            list.add(stack1);
        }
        if (stack2 != ItemStack.EMPTY) {
            list.add(stack2);
        }
        if (stack3 != ItemStack.EMPTY) {
            list.add(stack3);
        }
        if (stack4 != ItemStack.EMPTY) {
            list.add(stack4);
        }
        for (AlchemyRecipe alchemyRecipe : alchemyRecipes) {
            if (alchemyRecipe.matches(center, list)) {
                return alchemyRecipe;
            }
        }
        return null;
    }
}
