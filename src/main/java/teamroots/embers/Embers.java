package teamroots.embers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import teamroots.embers.proxy.CommonProxy;
import teamroots.embers.recipe.RecipeRegistry;
import teamroots.embers.registry.RegistrarEmbersItems;

@Mod(modid = Embers.MODID, name = Embers.MODNAME, version = Embers.VERSION, dependencies = Embers.DEPENDENCIES)
public class Embers {
    public static final String MODID = "embers";
    public static final String MODNAME = "Embers";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDENCIES = "";

    @SidedProxy(clientSide = "teamroots.embers.proxy.ClientProxy", serverSide = "teamroots.embers.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs TAB_EMBERS = new CreativeTabs("embers") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER, 1);
        }
    };

    public static final CreativeTabs TAB_RESOURCE = new CreativeTabs("embers_resources") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE, 1);
        }
    };

    @Instance(MODID)
    public static Embers instance;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventManager());
        MinecraftForge.EVENT_BUS.register(new ConfigManager());
        MinecraftForge.EVENT_BUS.register(new RecipeRegistry());
        ConfigManager.init(event.getSuggestedConfigurationFile());
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        //event.registerServerCommand(new CommandEmberFill());
    }
}
