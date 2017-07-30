package teamroots.embers.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.apache.commons.lang3.ArrayUtils;
import teamroots.embers.ConfigHandler;
import teamroots.embers.registry.RegistrarEmbersBlocks;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        if (!contains(ConfigHandler.ores.oreBlacklist, world.provider.getDimension())) {
            WorldGenMinable ore_copper = new WorldGenMinable(RegistrarEmbersBlocks.ORE_COPPER.getDefaultState(), ConfigHandler.ores.copperVeinSize);
            for (int i = 0; i < ConfigHandler.ores.copperVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigHandler.ores.copperMaxY - ConfigHandler.ores.copperMinY) + ConfigHandler.ores.copperMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_copper.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_lead = new WorldGenMinable(RegistrarEmbersBlocks.ORE_LEAD.getDefaultState(), ConfigHandler.ores.leadVeinSize);
            for (int i = 0; i < ConfigHandler.ores.leadVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigHandler.ores.leadMaxY - ConfigHandler.ores.leadMinY) + ConfigHandler.ores.leadMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_lead.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_silver = new WorldGenMinable(RegistrarEmbersBlocks.ORE_SILVER.getDefaultState(), ConfigHandler.ores.silverVeinSize);
            for (int i = 0; i < ConfigHandler.ores.silverVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigHandler.ores.silverMaxY - ConfigHandler.ores.silverMinY) + ConfigHandler.ores.silverMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_silver.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_quartz = new WorldGenMinable(RegistrarEmbersBlocks.ORE_QUARTZ.getDefaultState(), ConfigHandler.ores.quartzVeinSize);
            for (int i = 0; i < ConfigHandler.ores.quartzVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigHandler.ores.quartzMaxY - ConfigHandler.ores.quartzMinY) + ConfigHandler.ores.quartzMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_quartz.generate(world, random, new BlockPos(x, y, z));
            }
            if (ConfigHandler.compat.enableAluminum) {
                WorldGenMinable ore_aluminum = new WorldGenMinable(RegistrarEmbersBlocks.ORE_ALUMINUM.getDefaultState(), ConfigHandler.compat.aluminumVeinSize);
                for (int i = 0; i < ConfigHandler.compat.aluminumVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigHandler.compat.aluminumMaxY - ConfigHandler.compat.aluminumMinY) + ConfigHandler.compat.aluminumMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_aluminum.generate(world, random, new BlockPos(x, y, z));
                }
            }
            if (ConfigHandler.compat.enableNickel) {
                WorldGenMinable ore_nickel = new WorldGenMinable(RegistrarEmbersBlocks.ORE_NICKEL.getDefaultState(), ConfigHandler.compat.nickelVeinSize);
                for (int i = 0; i < ConfigHandler.compat.nickelVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigHandler.compat.nickelMaxY - ConfigHandler.compat.nickelMinY) + ConfigHandler.compat.nickelMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_nickel.generate(world, random, new BlockPos(x, y, z));
                }
            }
            if (ConfigHandler.compat.enableTin) {
                WorldGenMinable ore_tin = new WorldGenMinable(RegistrarEmbersBlocks.ORE_TIN.getDefaultState(), ConfigHandler.compat.tinVeinSize);
                for (int i = 0; i < ConfigHandler.compat.tinVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigHandler.compat.tinMaxY - ConfigHandler.compat.tinMinY) + ConfigHandler.compat.tinMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_tin.generate(world, random, new BlockPos(x, y, z));
                }
            }
        }
    }

    private static boolean contains(int[] array, int num) {
        return ArrayUtils.contains(array, num);
    }
}
