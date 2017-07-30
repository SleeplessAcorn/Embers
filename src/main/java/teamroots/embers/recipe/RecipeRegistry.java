package teamroots.embers.recipe;

import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
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
        List<ItemStack> list = Lists.newArrayList();
        if (!stack1.isEmpty()) {
            list.add(stack1);
        }
        if (!stack2.isEmpty()) {
            list.add(stack2);
        }
        if (!stack3.isEmpty()) {
            list.add(stack3);
        }
        if (!stack4.isEmpty()) {
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
