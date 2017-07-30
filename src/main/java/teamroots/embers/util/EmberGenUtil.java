package teamroots.embers.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import teamroots.embers.ConfigHandler;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.HashMap;
import java.util.Map;

public class EmberGenUtil {
    public static int offX = 0;
    public static int offZ = 0;
    public static Map<Item, Double> emberAmounts = new HashMap<Item, Double>();
    public static Map<String, Float> metalCoefficients = new HashMap<String, Float>();
    public static Map<Item, Float> fuelCoefficients = new HashMap<Item, Float>();
    public static Map<Item, Float> catalysisCoefficients = new HashMap<Item, Float>();

    public static float getEmberDensity(long seed, int x, int z) {
        return getEmberStability(seed, x, z) * (float) Math.pow((
                80.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 112)
                        + 20.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 68)
                        + 6.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 34)
                        + 4.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 21)
                        + 2.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 11)
                        + 1.0f * NoiseGenUtil.getOctave(seed, x + offX, z + offZ, 4)
        ) / 93.0f, 1.6f);
    }

    public static float getEmberStability(long seed, int x, int z) {
        return 1.0f - (float) Math.pow((32.0f * NoiseGenUtil.getOctave(seed, x, z, 120)
                + 16.0f * NoiseGenUtil.getOctave(seed, x, z, 76)
                + 6.0f * NoiseGenUtil.getOctave(seed, x, z, 45)
                + 3.0f * NoiseGenUtil.getOctave(seed, x, z, 21)
                + 1.0f * NoiseGenUtil.getOctave(seed, x, z, 5)
        ) / 58.0f, 3.0f);
    }

    public static void registerEmberFuelItem(Item item, double ember) {
        emberAmounts.put(item, ember);
    }

    public static double getEmberForItem(Item item) {
        if (emberAmounts.containsKey(item)) {
            return emberAmounts.get(item);
        }
        return 0;
    }

    public static void registerMetalCoefficient(String key, float coeff) {
        metalCoefficients.put(key, coeff);
    }

    public static float getMetalCoefficient(IBlockState state) {
        Block b = state.getBlock();
        ItemStack s = new ItemStack(b);
        if (s.isEmpty()) {
            return 0;
        }
        int[] ids = OreDictionary.getOreIDs(s);
        for (int i : ids) {
            String key = OreDictionary.getOreName(i);
            if (metalCoefficients.containsKey(key)) {
                return metalCoefficients.get(key);
            }
        }
        return 0;
    }

    public static void registerFuelCoefficient(Item item, float coeff) {
        fuelCoefficients.put(item, coeff);
    }

    public static float getFuelCoefficient(Item item) {
        if (fuelCoefficients.containsKey(item)) {
            return fuelCoefficients.get(item);
        }
        return 0;
    }

    public static void registerCatalysisCoefficient(Item item, float coeff) {
        catalysisCoefficients.put(item, coeff);
    }

    public static float getCatalysisCoefficient(Item item) {
        if (catalysisCoefficients.containsKey(item)) {
            return catalysisCoefficients.get(item);
        }
        return 0;
    }

    public static void init() {
        registerEmberFuelItem(RegistrarEmbersItems.SHARD_EMBER, 400);
        registerEmberFuelItem(RegistrarEmbersItems.CRYSTAL_EMBER, 2400);
        registerEmberFuelItem(RegistrarEmbersItems.EMBER_AMULET, 3600);

        registerMetalCoefficient("blockGold", 1.0f);
        registerMetalCoefficient("blockSilver", 1.0f);
        registerMetalCoefficient("blockCopper", 1.0f);
        if (ConfigHandler.compat.enableElectrum) {
            registerMetalCoefficient("blockElectrum", 1.0f);
        }
        if (ConfigHandler.compat.enableAluminum) {
            registerMetalCoefficient("blockAluminum", 0.9f);
        }
        if (ConfigHandler.compat.enableNickel) {
            registerMetalCoefficient("blockNickel", 0.9f);
        }
        if (ConfigHandler.compat.enableTin) {
            registerMetalCoefficient("blockTin", 0.9f);
        }
        registerMetalCoefficient("blockIron", 0.75f);
        registerMetalCoefficient("blockLead", 0.75f);
        if (ConfigHandler.compat.enableBronze) {
            registerMetalCoefficient("blockBronze", 0.75f);
        }

        registerFuelCoefficient(Items.COAL, 2.0f);
        registerFuelCoefficient(Items.NETHERBRICK, 3.0f);
        registerFuelCoefficient(Items.BLAZE_POWDER, 4.0f);

        registerCatalysisCoefficient(Items.REDSTONE, 2.0f);
        registerCatalysisCoefficient(Items.GUNPOWDER, 3.0f);
        registerCatalysisCoefficient(Items.GLOWSTONE_DUST, 4.0f);
    }

}
