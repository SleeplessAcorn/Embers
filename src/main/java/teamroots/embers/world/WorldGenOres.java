package teamroots.embers.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import teamroots.embers.ConfigManager;
import teamroots.embers.registry.RegistrarEmbersBlocks;

import java.util.Random;

public class WorldGenOres implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        if (!ConfigManager.orespawnBlacklist.contains(world.provider.getDimension())) {
            WorldGenMinable ore_copper = new WorldGenMinable(RegistrarEmbersBlocks.ORE_COPPER.getDefaultState(), ConfigManager.copperVeinSize);
            for (int i = 0; i < ConfigManager.copperVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigManager.copperMaxY - ConfigManager.copperMinY) + ConfigManager.copperMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_copper.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_lead = new WorldGenMinable(RegistrarEmbersBlocks.ORE_LEAD.getDefaultState(), ConfigManager.leadVeinSize);
            for (int i = 0; i < ConfigManager.leadVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigManager.leadMaxY - ConfigManager.leadMinY) + ConfigManager.leadMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_lead.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_silver = new WorldGenMinable(RegistrarEmbersBlocks.ORE_SILVER.getDefaultState(), ConfigManager.silverVeinSize);
            for (int i = 0; i < ConfigManager.silverVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigManager.silverMaxY - ConfigManager.silverMinY) + ConfigManager.silverMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_silver.generate(world, random, new BlockPos(x, y, z));
            }
            WorldGenMinable ore_quartz = new WorldGenMinable(RegistrarEmbersBlocks.ORE_QUARTZ.getDefaultState(), ConfigManager.quartzVeinSize);
            for (int i = 0; i < ConfigManager.quartzVeinsPerChunk; i++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = random.nextInt(ConfigManager.quartzMaxY - ConfigManager.quartzMinY) + ConfigManager.quartzMinY;
                int z = chunkZ * 16 + random.nextInt(16);
                ore_quartz.generate(world, random, new BlockPos(x, y, z));
            }
            if (ConfigManager.enableAluminum) {
                WorldGenMinable ore_aluminum = new WorldGenMinable(RegistrarEmbersBlocks.ORE_ALUMINUM.getDefaultState(), ConfigManager.aluminumVeinSize);
                for (int i = 0; i < ConfigManager.aluminumVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigManager.aluminumMaxY - ConfigManager.aluminumMinY) + ConfigManager.aluminumMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_aluminum.generate(world, random, new BlockPos(x, y, z));
                }
            }
            if (ConfigManager.enableNickel) {
                WorldGenMinable ore_nickel = new WorldGenMinable(RegistrarEmbersBlocks.ORE_NICKEL.getDefaultState(), ConfigManager.nickelVeinSize);
                for (int i = 0; i < ConfigManager.nickelVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigManager.nickelMaxY - ConfigManager.nickelMinY) + ConfigManager.nickelMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_nickel.generate(world, random, new BlockPos(x, y, z));
                }
            }
            if (ConfigManager.enableTin) {
                WorldGenMinable ore_tin = new WorldGenMinable(RegistrarEmbersBlocks.ORE_TIN.getDefaultState(), ConfigManager.tinVeinSize);
                for (int i = 0; i < ConfigManager.tinVeinsPerChunk; i++) {
                    int x = chunkX * 16 + random.nextInt(16);
                    int y = random.nextInt(ConfigManager.tinMaxY - ConfigManager.tinMinY) + ConfigManager.tinMinY;
                    int z = chunkZ * 16 + random.nextInt(16);
                    ore_tin.generate(world, random, new BlockPos(x, y, z));
                }
            }
        }
    }
}
