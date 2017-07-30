package teamroots.embers;

import net.minecraftforge.common.config.*;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Embers.MODID, category = "")
@Mod.EventBusSubscriber(modid = Embers.MODID)
public class ConfigHandler {

    @Config.Comment({ "Settings related to ore generation" })
    public static ConfigOres ores = new ConfigOres();
    @Config.Comment({ "Settings related to entities" })
    public static ConfigMobs mobs = new ConfigMobs();
    @Config.Comment({ "Settings related to structure generation" })
    public static ConfigStructures structures = new ConfigStructures();
    @Config.Comment({ "Settings related to compatibility with other mods" })
    public static ConfigCompat compat = new ConfigCompat();

    public static class ConfigOres {
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a copper ore vein (in blocks)" })
        public int copperVeinSize = 12;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which copper ore will spawn." })
        public int copperMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which copper ore will spawn." })
        public int copperMaxY = 64;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn copper ore the world generator will make for each chunk." })
        public int copperVeinsPerChunk = 6;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a lead ore vein (in blocks)" })
        public int leadVeinSize = 8;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which lead ore will spawn." })
        public int leadMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which lead ore will spawn." })
        public int leadMaxY = 28;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn lead ore the world generator will make for each chunk." })
        public int leadVeinsPerChunk = 4;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a silver ore vein (in blocks)" })
        public int silverVeinSize = 6;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which silver ore will spawn." })
        public int silverMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which silver ore will spawn." })
        public int silverMaxY = 28;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn silver ore the world generator will make for each chunk." })
        public int silverVeinsPerChunk = 4;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a quartz ore vein (in blocks)" })
        public int quartzVeinSize = 8;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which quartz ore will spawn." })
        public int quartzMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which quartz ore will spawn." })
        public int quartzMaxY = 18;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn quartz ore the world generator will make for each chunk." })
        public int quartzVeinsPerChunk = 4;

        @Config.Comment({ "A list of all dimension IDs in which Embers orespawn is prohibited", "Embers ores will spawn in any dimension not on this list, but only in vanilla stone." })
        public int[] oreBlacklist = new int[] { -1, 1 };
    }

    public static class ConfigMobs {
        @Config.RangeInt(min = 0, max = 42767)
        @Config.Comment({ "Spawning weight of the Ancient Golem mob. Higher values make golems spawn more frequently." })
        public int ancientGolemSpawnWeight = 25;
    }

    public static class ConfigStructures {
        @Config.RangeInt(min = 0, max = 32767)
        @Config.Comment({ "Spawning frequency of the small ruin structure. A value of 0 will prevent spawning altogether." })
        public int smallRuinChance = 5;
    }

    public static class ConfigCompat {
        @Config.Comment({ "If true, Embers will register items, blocks, and recipes providing support for other mods' nickel." })
        public boolean enableNickel = true;
        @Config.Comment({ "If true, Embers will register items, blocks, and recipes providing support for other mods' tin." })
        public boolean enableTin = true;
        @Config.Comment({ "If true, Embers will register items, blocks, and recipes providing support for other mods' aluminum." })
        public boolean enableAluminum = true;
        @Config.Comment({ "If true, Embers will register items, blocks, and recipes providing support for other mods' bronze." })
        public boolean enableBronze = true;
        @Config.Comment({ "If true, Embers will register items, blocks, and recipes providing support for other mods' electrum." })
        public boolean enableElectrum = true;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a nickel ore vein (in blocks)" })
        public int nickelVeinSize = 6;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which nickel ore will spawn" })
        public int nickelMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which nickel ore will spawn" })
        public int nickelMaxY = 24;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn nickel ore the world generator will make for each chunk." })
        public int nickelVeinsPerChunk = 4;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a tin ore vein (in blocks)" })
        public int tinVeinSize = 6;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which tin ore will spawn" })
        public int tinMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which tin ore will spawn" })
        public int tinMaxY = 48;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn tin ore the world generator will make for each chunk." })
        public int tinVeinsPerChunk = 6;

        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum size of a aluminum ore vein (in blocks)" })
        public int aluminumVeinSize = 6;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Minimum height over which aluminum ore will spawn" })
        public int aluminumMinY = 0;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Maximum height under which aluminum ore will spawn" })
        public int aluminumMaxY = 58;
        @Config.RangeInt(min = 0, max = 255)
        @Config.Comment({ "Number of attempts to spawn aluminum ore the world generator will make for each chunk." })
        public int aluminumVeinsPerChunk = 4;
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Embers.MODID))
            net.minecraftforge.common.config.ConfigManager.sync(Embers.MODID, Config.Type.INSTANCE);
    }
}
