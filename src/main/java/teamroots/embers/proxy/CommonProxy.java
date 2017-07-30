package teamroots.embers.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import teamroots.embers.Embers;
import teamroots.embers.gui.GuiHandler;
import teamroots.embers.network.PacketHandler;
import teamroots.embers.recipe.RecipeRegistry;
import teamroots.embers.reflection.Fields;
import teamroots.embers.registry.RegistrarEmbers;
import teamroots.embers.research.ResearchManager;
import teamroots.embers.util.EmberGenUtil;
import teamroots.embers.util.ItemModUtil;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Fields.init();
        PacketHandler.registerMessages();
        RegistrarEmbers.registerOthers();
    }

    public void init(FMLInitializationEvent event) {
        EmberGenUtil.init();
        ItemModUtil.init();
        ResearchManager.initResearches();
        RecipeRegistry.initOreDict();
    }

    public void postInit(FMLPostInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(Embers.instance, new GuiHandler());
    }
}
