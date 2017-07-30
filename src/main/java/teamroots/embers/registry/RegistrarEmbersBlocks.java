package teamroots.embers.registry;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teamroots.embers.ConfigManager;
import teamroots.embers.Embers;
import teamroots.embers.block.*;
import teamroots.embers.fluid.FluidMoltenIron;
import teamroots.embers.fluid.FluidMoltenMetal;
import teamroots.embers.item.block.ItemBlockSlab;
import teamroots.embers.tileentity.*;

import java.util.List;

@GameRegistry.ObjectHolder(Embers.MODID)
@Mod.EventBusSubscriber(modid = Embers.MODID)
@SuppressWarnings("unused")
public class RegistrarEmbersBlocks {

    // Machine
    public static final Block MECHANICAL_PUMP = Blocks.AIR;
    public static final Block STEAM_ENGINE = Blocks.AIR;
    public static final Block GEARBOX_FRAME = Blocks.AIR;
    public static final Block CREATIVE_EMBER_SOURCE = Blocks.AIR;
    public static final Block CREATIVE_MECH_SOURCE = Blocks.AIR;
    public static final Block AXLE_IRON = Blocks.AIR;
    public static final Block CAMINITE_LEVER = Blocks.AIR;
    public static final Block INFERNO_FORGE = Blocks.AIR;
    public static final Block INFERNO_FORGE_EDGE = Blocks.AIR;
    public static final Block EMBER_PULSER = Blocks.AIR;
    public static final Block FIELD_CHART = Blocks.AIR;
    public static final Block CATALYZER = Blocks.AIR;
    public static final Block COMBUSTOR = Blocks.AIR;
    public static final Block REACTOR = Blocks.AIR;
    public static final Block ARCHAIC_TILE = Blocks.AIR;
    public static final Block ARCHAIC_EDGE = Blocks.AIR;
    public static final Block WRAPPED_SEALED_PLANKS = Blocks.AIR;
    public static final Block STRUCTURE_MARKER = Blocks.AIR;
    public static final Block BOILER = Blocks.AIR;
    public static final Block EMBER_INJECTOR = Blocks.AIR;
    public static final Block SEED = Blocks.AIR;
    public static final Block BREAKER = Blocks.AIR;
    public static final Block VACUUM = Blocks.AIR;
    public static final Block SEALED_PLANKS = Blocks.AIR;
    public static final Block ORE_QUARTZ = Blocks.AIR;
    public static final Block AUTO_HAMMER = Blocks.AIR;
    public static final Block DAWNSTONE_ANVIL = Blocks.AIR;
    public static final Block ARCHAIC_LIGHT = Blocks.AIR;
    public static final Block ARCHAIC_BRICKS = Blocks.AIR;
    public static final Block GLOW = Blocks.AIR;
    public static final Block BEAM_CANNON = Blocks.AIR;
    public static final Block ITEM_TRANSFER = Blocks.AIR;
    public static final Block ALCHEMY_TABLET = Blocks.AIR;
    public static final Block ALCHEMY_PEDESTAL = Blocks.AIR;
    public static final Block KNOWLEDGE_TABLE = Blocks.AIR;
    public static final Block CINDER_PLINTH = Blocks.AIR;
    public static final Block ASHEN_TILE = Blocks.AIR;
    public static final Block STAIRS_ASHEN_TILE = Blocks.AIR;
    public static final Block WALL_ASHEN_TILE = Blocks.AIR;
    public static final Block ASHEN_TILE_SLAB = Blocks.AIR;
    public static final Block ASHEN_TILE_SLAB_DOUBLE = Blocks.AIR;
    public static final Block ASHEN_STONE = Blocks.AIR;
    public static final Block ASHEN_BRICK = Blocks.AIR;
    public static final Block STAIRS_ASHEN_STONE = Blocks.AIR;
    public static final Block WALL_ASHEN_STONE = Blocks.AIR;
    public static final Block ASHEN_STONE_SLAB = Blocks.AIR;
    public static final Block ASHEN_STONE_SLAB_DOUBLE = Blocks.AIR;
    public static final Block STAIRS_ASHEN_BRICK = Blocks.AIR;
    public static final Block WALL_ASHEN_BRICK = Blocks.AIR;
    public static final Block ASHEN_BRICK_SLAB = Blocks.AIR;
    public static final Block ASHEN_BRICK_SLAB_DOUBLE = Blocks.AIR;
    public static final Block BLOCK_CAMINITE_BRICK_SLAB = Blocks.AIR;
    public static final Block BLOCK_CAMINITE_BRICK_SLAB_DOUBLE = Blocks.AIR;
    public static final Block CHARGER = Blocks.AIR;
    public static final Block CRYSTAL_CELL = Blocks.AIR;
    public static final Block ADVANCED_EDGE = Blocks.AIR;
    public static final Block EMBER_RELAY = Blocks.AIR;
    public static final Block BEAM_SPLITTER = Blocks.AIR;
    public static final Block BLOCK_LANTERN = Blocks.AIR;
    public static final Block EMBER_GAUGE = Blocks.AIR;
    public static final Block ITEM_GAUGE = Blocks.AIR;
    public static final Block FLUID_GAUGE = Blocks.AIR;
    public static final Block LARGE_TANK = Blocks.AIR;
    public static final Block ITEM_DROPPER = Blocks.AIR;
    public static final Block HEAT_COIL = Blocks.AIR;
    public static final Block WALL_CAMINITE_BRICK = Blocks.AIR;
    public static final Block BLOCK_DAWNSTONE = Blocks.AIR;
    public static final Block MIXER = Blocks.AIR;
    public static final Block STONE_EDGE = Blocks.AIR;
    public static final Block EMBER_ACTIVATOR = Blocks.AIR;
    public static final Block MECH_CORE = Blocks.AIR;
    public static final Block STAIRS_CAMINITE_BRICK = Blocks.AIR;
    public static final Block MECH_ACCESSOR = Blocks.AIR;
    public static final Block EMBER_BORE = Blocks.AIR;
    public static final Block MECH_EDGE = Blocks.AIR;
    public static final Block ITEM_PUMP = Blocks.AIR;
    public static final Block ITEM_PIPE = Blocks.AIR;
    public static final Block BLOCK_OVEN = Blocks.AIR;
    public static final Block STAMP_BASE = Blocks.AIR;
    public static final Block STAMPER = Blocks.AIR;
    public static final Block BLOCK_CAMINITE_LARGE_BRICK = Blocks.AIR;
    public static final Block BIN = Blocks.AIR;
    public static final Block COPPER_CELL = Blocks.AIR;
    public static final Block DEEP_LINE = Blocks.AIR;
    public static final Block EMBER_EMITTER = Blocks.AIR;
    public static final Block EMBER_RECEIVER = Blocks.AIR;
    public static final Block BLOCK_FURNACE = Blocks.AIR;
    public static final Block PUMP = Blocks.AIR;
    public static final Block BLOCK_COPPER = Blocks.AIR;
    public static final Block BLOCK_LEAD = Blocks.AIR;
    public static final Block BLOCK_SILVER = Blocks.AIR;
    public static final Block BLOCK_MITHRIL = Blocks.AIR;
    public static final Block ORE_COPPER = Blocks.AIR;
    public static final Block ORE_LEAD = Blocks.AIR;
    public static final Block ORE_SILVER = Blocks.AIR;
    public static final Block BLOCK_CAMINITE_BRICK = Blocks.AIR;
    public static final Block BLOCK_TANK = Blocks.AIR;
    public static final Block PIPE = Blocks.AIR;
    
    // Fluids
    public static final Block BLOCK_MOLTEN_DAWNSTONE = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_DAWNSTONE = new FluidMoltenMetal("dawnstone");
    public static final Block BLOCK_MOLTEN_GOLD = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_GOLD = new FluidMoltenMetal("gold");
    public static final Block BLOCK_MOLTEN_COPPER = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_COPPER = new FluidMoltenMetal("copper");
    public static final Block BLOCK_MOLTEN_LEAD = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_LEAD = new FluidMoltenMetal("lead");
    public static final Block BLOCK_MOLTEN_SILVER = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_SILVER = new FluidMoltenMetal("silver");
    public static final Block BLOCK_MOLTEN_IRON = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_IRON = new FluidMoltenIron();
    public static final Block BLOCK_MOLTEN_ALUMINUM = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_ALUMINUM = new FluidMoltenMetal("aluminum");
    public static final Block BLOCK_MOLTEN_TIN = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_TIN = new FluidMoltenMetal("tin");
    public static final Block BLOCK_MOLTEN_BRONZE = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_BRONZE = new FluidMoltenMetal("bronze");
    public static final Block BLOCK_MOLTEN_ELECTRUM = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_ELECTRUM = new FluidMoltenMetal("electrum");
    public static final Block BLOCK_MOLTEN_NICKEL = Blocks.AIR;
    public static Fluid FLUID_MOLTEN_NICKEL = new FluidMoltenMetal("nickel");

    // Nickel
    public static final Block ORE_NICKEL = Blocks.AIR;
    public static final Block BLOCK_NICKEL = Blocks.AIR;

    // Aluminum
    public static final Block ORE_ALUMINUM = Blocks.AIR;
    public static final Block BLOCK_ALUMINUM = Blocks.AIR;

    // Tin
    public static final Block ORE_TIN = Blocks.AIR;
    public static final Block BLOCK_TIN = Blocks.AIR;

    // Alloy
    public static final Block BLOCK_BRONZE = Blocks.AIR;
    public static final Block BLOCK_ELECTRUM = Blocks.AIR;

    public static Material unpushable = new MaterialUnpushable();

    static List<Block> blocks = Lists.newArrayList();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        blocks.add((new BlockBase(Material.ROCK, "block_copper", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(1.4f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "block_lead", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 2).setHardness(1.6f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "block_silver", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 2).setHardness(1.6f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "block_dawnstone", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 2).setHardness(1.6f).setLightLevel(0.0625f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        // Gloomshroud - Add Mithril Block. May need property adjustment.
        blocks.add((new BlockBase(Material.ROCK, "block_mithril", true)).setHarvestProperties("pickaxe", 2).setHardness(1.6f).setLightLevel(0.0625f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "ore_copper", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 1).setHardness(1.8f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "ore_lead", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 2).setHardness(2.5f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "ore_silver", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 2).setHardness(2.5f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        blocks.add((new BlockBase(Material.ROCK, "block_caminite_brick", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockDoubleSlabBase(Material.WOOD, "block_caminite_brick_slab_double", false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockSlabBase(BLOCK_CAMINITE_BRICK_SLAB_DOUBLE, "block_caminite_brick_slab", true).setHarvestProperties("pickaxe", 0).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(1));
//        ((BlockDoubleSlabBase) BLOCK_CAMINITE_BRICK_SLAB_DOUBLE).setSlab(BLOCK_CAMINITE_BRICK_SLAB);
//        RegistrarEmbersItems.items.add(new ItemBlockSlab(BLOCK_CAMINITE_BRICK_SLAB, BLOCK_CAMINITE_BRICK_SLAB_DOUBLE));
        blocks.add((new BlockStairsBase(BLOCK_CAMINITE_BRICK.getDefaultState(), "stairs_caminite_brick", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockWallBase(BLOCK_CAMINITE_BRICK, "wall_caminite_brick", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        //blocks.add((new BlockBase(Material.ROCK,"blockCaminiteLargeBrick",true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockTank(Material.ROCK, "block_tank", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockFluidPipe(Material.ROCK, "pipe", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockFluidExtractor(Material.ROCK, "pump", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockFurnace(Material.ROCK, "block_furnace", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockEmberReceiver(Material.ROCK, "ember_receiver", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(0.6f));
        blocks.add((new BlockEmberEmitter(Material.ROCK, "ember_emitter", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(0.6f));
        blocks.add((new BlockCopperCell(Material.ROCK, "copper_cell", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.4f));
        blocks.add((new BlockItemPipe(Material.ROCK, "item_pipe", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockItemExtractor(Material.ROCK, "item_pump", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockBin(Material.ROCK, "bin", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockStamper(Material.ROCK, "stamper", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockStampBase(Material.ROCK, "stamper_base", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockMechEdge(unpushable, "mech_edge", false)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockEmberBore(Material.ROCK, "ember_bore", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockMechAccessor(Material.ROCK, "mech_accessor", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockMechCore(Material.ROCK, "mech_core", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockActivator(Material.ROCK, "ember_activator", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockStoneEdge(unpushable, "stone_edge", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockMixer(Material.ROCK, "mixer", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockHeatCoil(Material.ROCK, "heat_coil", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockDropper(Material.ROCK, "item_dropper", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockLargeTank(Material.ROCK, "large_tank", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockEmberGauge(Material.ROCK, "ember_gauge", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        //blocks.add((new BlockItemGauge(Material.ROCK,"item_gauge",true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockFluidGauge(Material.ROCK, "fluid_gauge", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockLantern(Material.ROCK, "block_lantern", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f).setLightLevel(1.0f));
        blocks.add((new BlockBeamSplitter(Material.ROCK, "beam_splitter", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockRelay(Material.ROCK, "ember_relay", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockAdvancedEdge(unpushable, "advanced_edge", false)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockCrystalCell(Material.ROCK, "crystal_cell", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockCharger(Material.ROCK, "charger", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockBase(Material.ROCK, "ashen_stone", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockDoubleSlabBase(Material.WOOD, "ashen_stone_slab_double", false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockSlabBase(ASHEN_STONE_SLAB_DOUBLE, "ashen_stone_slab", true).setHarvestProperties("pickaxe", 0).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(1));
//        ((BlockDoubleSlabBase) ASHEN_STONE_SLAB_DOUBLE).setSlab(ASHEN_STONE_SLAB);
//        RegistrarEmbersItems.items.add(new ItemBlockSlab(ASHEN_STONE_SLAB, ASHEN_STONE_SLAB_DOUBLE));
        blocks.add((new BlockStairsBase(ASHEN_STONE.getDefaultState(), "stairs_ashen_stone", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockWallBase(ASHEN_STONE, "wall_ashen_stone", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockBase(Material.ROCK, "ashen_brick", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockDoubleSlabBase(Material.WOOD, "ashen_brick_slab_double", false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockSlabBase(ASHEN_BRICK_SLAB_DOUBLE, "ashen_brick_slab", true).setHarvestProperties("pickaxe", 0).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(1));
//        ((BlockDoubleSlabBase) ASHEN_BRICK_SLAB_DOUBLE).setSlab(ASHEN_BRICK_SLAB);
//        RegistrarEmbersItems.items.add(new ItemBlockSlab(ASHEN_BRICK_SLAB, ASHEN_BRICK_SLAB_DOUBLE));
        blocks.add((new BlockStairsBase(ASHEN_BRICK.getDefaultState(), "stairs_ashen_brick", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockWallBase(ASHEN_BRICK, "wall_ashen_brick", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockBase(Material.ROCK, "ashen_tile", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockDoubleSlabBase(Material.WOOD, "ashen_tile_slab_double", false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
//        blocks.add(new BlockSlabBase(ASHEN_TILE_SLAB_DOUBLE, "ashen_tile_slab", true).setHarvestProperties("pickaxe", 0).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(1));
//        ((BlockDoubleSlabBase) ASHEN_TILE_SLAB_DOUBLE).setSlab(ASHEN_TILE_SLAB);
//        RegistrarEmbersItems.items.add(new ItemBlockSlab(ASHEN_TILE_SLAB, ASHEN_TILE_SLAB_DOUBLE));
        blocks.add((new BlockStairsBase(ASHEN_TILE.getDefaultState(), "stairs_ashen_tile", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockWallBase(ASHEN_TILE, "wall_ashen_tile", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockCinderPlinth(Material.ROCK, "cinder_plinth", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockAlchemyPedestal(Material.ROCK, "alchemy_pedestal", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockAlchemyTablet(Material.ROCK, "alchemy_tablet", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockItemTransfer(Material.ROCK, "item_transfer", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockBeamCannon(Material.ROCK, "beam_cannon", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockGlow(Material.CIRCUITS, "glow", false)).setIsFullCube(false).setIsOpaqueCube(false).setHardness(0.0f).setLightLevel(1.0f));
        blocks.add((new BlockBase(Material.ROCK, "archaic_bricks", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockBase(Material.ROCK, "archaic_edge", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockBase(Material.ROCK, "archaic_tile", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(16));
        blocks.add((new BlockArchaicLight(Material.ROCK, "archaic_light", true)).setHarvestProperties("pickaxe", 0).setHardness(1.6f).setLightOpacity(0).setLightLevel(1.0f));
        blocks.add((new BlockDawnstoneAnvil(Material.ANVIL, "dawnstone_anvil", true)).setHarvestProperties("pickaxe", 1).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(0));
        blocks.add((new BlockAutoHammer(Material.ROCK, "auto_hammer", true)).setHarvestProperties("pickaxe", 0).setIsFullCube(false).setIsOpaqueCube(false).setHardness(1.6f).setLightOpacity(0));
        blocks.add((new BlockQuartzOre(Material.ROCK, "ore_quartz", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 2).setHardness(1.9f).setLightOpacity(16));
        blocks.add((new BlockBase(Material.WOOD, "sealed_planks", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("axe", -1).setHardness(2.5f).setLightOpacity(16));
        blocks.add((new BlockBase(Material.WOOD, "wrapped_sealed_planks", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("axe", -1).setHardness(3.1f).setLightOpacity(16));
        blocks.add((new BlockVacuum(Material.ROCK, "vacuum", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockBreaker(Material.ROCK, "breaker", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockSeed(Material.ROCK, "seed", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockEmberInjector(Material.ROCK, "ember_injector", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockBoiler(Material.ROCK, "boiler", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockStructureMarker()).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockReactor(Material.ROCK, "reactor", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockCombustor(Material.ROCK, "combustor", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockCatalyzer(Material.ROCK, "catalyzer", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockFieldChart(Material.ROCK, "field_chart", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockEmberPulser(Material.ROCK, "ember_pulser", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.6f));
        blocks.add((new BlockInfernoForgeEdge(unpushable, "inferno_forge_edge", false)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockInfernoForge(Material.ROCK, "inferno_forge", true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockCaminiteLever(Material.ROCK, "caminite_lever", true)).setHardness(0.75f));
        //blocks.add((new BlockAxle(Material.ROCK,"axle_iron",true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        //blocks.add((new BlockCreativeMechSource(Material.ROCK,"creative_mech_source",true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        blocks.add((new BlockCreativeEmberSource(Material.ROCK, "creative_ember_source", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        //blocks.add((new BlockGearbox(Material.ROCK,"gearbox_frame",true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        //blocks.add((new BlockSteamEngine(Material.ROCK,"steam_engine",true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));
        //blocks.add((new BlockPump(Material.ROCK,"mechanical_pump",true)).setIsFullCube(false).setIsOpaqueCube(false).setHarvestProperties("pickaxe", 0).setHardness(1.0f));

        if (ConfigManager.enableAluminum) {
            blocks.add((new BlockBase(Material.ROCK, "block_aluminum", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(1.6f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
            blocks.add((new BlockBase(Material.ROCK, "ore_aluminum", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 1).setHardness(1.6f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        }

        if (ConfigManager.enableBronze) {
            blocks.add((new BlockBase(Material.ROCK, "block_bronze", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(2.3f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        }

        if (ConfigManager.enableElectrum) {
            blocks.add((new BlockBase(Material.ROCK, "block_electrum", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(1.6f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        }

        if (ConfigManager.enableNickel) {
            blocks.add((new BlockBase(Material.ROCK, "block_nickel", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(2.2f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
            blocks.add((new BlockBase(Material.ROCK, "ore_nickel", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 1).setHardness(2.2f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        }

        if (ConfigManager.enableTin) {
            blocks.add((new BlockBase(Material.ROCK, "block_tin", true)).setBeaconBase(true).setHarvestProperties("pickaxe", 1).setHardness(1.3f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
            blocks.add((new BlockBase(Material.ROCK, "ore_tin", true)).setIsFullCube(true).setIsOpaqueCube(true).setHarvestProperties("pickaxe", 1).setHardness(1.3f).setLightOpacity(16).setCreativeTab(Embers.TAB_RESOURCE));
        }

        newFluid(FLUID_MOLTEN_DAWNSTONE);
        newFluid(FLUID_MOLTEN_GOLD);
        newFluid(FLUID_MOLTEN_COPPER);
        newFluid(FLUID_MOLTEN_LEAD);
        newFluid(FLUID_MOLTEN_SILVER);
        newFluid(FLUID_MOLTEN_IRON);
        newFluid(FLUID_MOLTEN_ALUMINUM);
        newFluid(FLUID_MOLTEN_TIN);
        newFluid(FLUID_MOLTEN_BRONZE);
        newFluid(FLUID_MOLTEN_ELECTRUM);
        newFluid(FLUID_MOLTEN_NICKEL);

        event.getRegistry().registerAll(blocks.toArray(new Block[0]));

        GameRegistry.registerTileEntity(TileEntityTank.class, Embers.MODID + ":tile_entity_tank");
        GameRegistry.registerTileEntity(TileEntityFluidPipe.class, Embers.MODID + ":tile_entity_pipe");
        GameRegistry.registerTileEntity(TileEntityFluidExtractor.class, Embers.MODID + ":tile_entity_pump");
        GameRegistry.registerTileEntity(TileEntityFurnaceTop.class, Embers.MODID + ":tile_entity_furnace_top");
        GameRegistry.registerTileEntity(TileEntityFurnaceBottom.class, Embers.MODID + ":tile_entity_furnace_bottom");
        GameRegistry.registerTileEntity(TileEntityEmitter.class, Embers.MODID + ":tile_entity_emitter");
        GameRegistry.registerTileEntity(TileEntityReceiver.class, Embers.MODID + ":tile_entity_receiver");
        GameRegistry.registerTileEntity(TileEntityCopperCell.class, Embers.MODID + ":tile_entity_copper_cell");
        GameRegistry.registerTileEntity(TileEntityItemPipe.class, Embers.MODID + ":tile_entity_item_pipe");
        GameRegistry.registerTileEntity(TileEntityItemExtractor.class, Embers.MODID + ":tile_entity_item_pump");
        GameRegistry.registerTileEntity(TileEntityBin.class, Embers.MODID + ":tile_entity_bin");
        GameRegistry.registerTileEntity(TileEntityStamper.class, Embers.MODID + ":tile_entity_stamper");
        GameRegistry.registerTileEntity(TileEntityStampBase.class, Embers.MODID + ":tile_entity_stamp_base");
        GameRegistry.registerTileEntity(TileEntityEmberBore.class, Embers.MODID + ":tile_entity_ember_bore");
        GameRegistry.registerTileEntity(TileEntityMechAccessor.class, Embers.MODID + ":tile_entity_mech_accessor");
        GameRegistry.registerTileEntity(TileEntityMechCore.class, Embers.MODID + ":tile_entity_mech_core");
        GameRegistry.registerTileEntity(TileEntityActivatorTop.class, Embers.MODID + ":tile_entity_activator_top");
        GameRegistry.registerTileEntity(TileEntityActivatorBottom.class, Embers.MODID + ":tile_entity_activator_bottom");
        GameRegistry.registerTileEntity(TileEntityMixerTop.class, Embers.MODID + ":tile_entity_mixer_top");
        GameRegistry.registerTileEntity(TileEntityMixerBottom.class, Embers.MODID + ":tile_entity_mixer_bottom");
        GameRegistry.registerTileEntity(TileEntityHeatCoil.class, Embers.MODID + ":tile_entity_heat_coil");
        GameRegistry.registerTileEntity(TileEntityDropper.class, Embers.MODID + ":tile_entity_dropper");
        GameRegistry.registerTileEntity(TileEntityLargeTank.class, Embers.MODID + ":tile_entity_large_tank");
        GameRegistry.registerTileEntity(TileEntityBeamSplitter.class, Embers.MODID + ":tile_entity_beam_splitter");
        GameRegistry.registerTileEntity(TileEntityRelay.class, Embers.MODID + ":tile_entity_relay");
        GameRegistry.registerTileEntity(TileEntityCrystalCell.class, Embers.MODID + ":tile_entity_crystal_cell");
        GameRegistry.registerTileEntity(TileEntityCharger.class, Embers.MODID + ":tile_entity_charger");
        GameRegistry.registerTileEntity(TileEntityCinderPlinth.class, Embers.MODID + ":tile_entity_cinder_plinth");
        GameRegistry.registerTileEntity(TileEntityKnowledgeTable.class, Embers.MODID + ":tile_entity_knowledge_table");
        GameRegistry.registerTileEntity(TileEntityAlchemyPedestal.class, Embers.MODID + ":tile_entity_alchemy_pedestal");
        GameRegistry.registerTileEntity(TileEntityAlchemyTablet.class, Embers.MODID + ":tile_entity_alchemy_tablet");
        GameRegistry.registerTileEntity(TileEntityItemTransfer.class, Embers.MODID + ":tile_entity_item_transfer");
        GameRegistry.registerTileEntity(TileEntityBeamCannon.class, Embers.MODID + ":tile_entity_beam_cannon");
        GameRegistry.registerTileEntity(TileEntityDawnstoneAnvil.class, Embers.MODID + ":tile_entity_dawnstone_anvil");
        GameRegistry.registerTileEntity(TileEntityAutoHammer.class, Embers.MODID + ":tile_entity_auto_hammer");
        GameRegistry.registerTileEntity(TileEntityItemVacuum.class, Embers.MODID + ":tile_entity_vacuum");
        GameRegistry.registerTileEntity(TileEntityBreaker.class, Embers.MODID + ":tile_entity_breaker");
        GameRegistry.registerTileEntity(TileEntitySeed.class, Embers.MODID + ":tile_entity_seed");
        GameRegistry.registerTileEntity(TileEntityEmberInjector.class, Embers.MODID + ":tile_entity_ember_injector");
        GameRegistry.registerTileEntity(TileEntityBoilerBottom.class, Embers.MODID + ":tile_entity_boiler_bottom");
        GameRegistry.registerTileEntity(TileEntityBoilerTop.class, Embers.MODID + ":tile_entity_boiler_top");
        GameRegistry.registerTileEntity(TileEntityReactor.class, Embers.MODID + ":tile_entity_reactor");
        GameRegistry.registerTileEntity(TileEntityCombustor.class, Embers.MODID + ":tile_entity_combustor");
        GameRegistry.registerTileEntity(TileEntityCatalyzer.class, Embers.MODID + ":tile_entity_catalyzer");
        GameRegistry.registerTileEntity(TileEntityFieldChart.class, Embers.MODID + ":tile_entity_field_chart");
        GameRegistry.registerTileEntity(TileEntityPulser.class, Embers.MODID + ":tile_entity_pulser");
        GameRegistry.registerTileEntity(TileEntityInfernoForge.class, Embers.MODID + ":tile_entity_inferno_forge");
        GameRegistry.registerTileEntity(TileEntityInfernoForgeOpening.class, Embers.MODID + ":tile_entity_inferno_forge_opening");
        GameRegistry.registerTileEntity(TileEntityAxle.class, Embers.MODID + ":tile_entity_axle");
        GameRegistry.registerTileEntity(TileEntityCreativeMechSource.class, Embers.MODID + ":tile_entity_creative_mech_source");
        GameRegistry.registerTileEntity(TileEntityCreativeEmberSource.class, Embers.MODID + ":tile_entity_creative_ember_source");
        GameRegistry.registerTileEntity(TileEntityGearbox.class, Embers.MODID + ":tile_entity_gearbox");
        GameRegistry.registerTileEntity(TileEntitySteamEngine.class, Embers.MODID + ":tile_entity_steam_engine");
        GameRegistry.registerTileEntity(TileEntityPumpBottom.class, Embers.MODID + ":tile_entity_pump_bottom");
        GameRegistry.registerTileEntity(TileEntityPumpTop.class, Embers.MODID + ":tile_entity_pump_top");
    }

    private static void newFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        blocks.add(new BlockMolten(fluid));
        FluidRegistry.addBucketForFluid(fluid);
    }
}
