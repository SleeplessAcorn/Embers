package teamroots.embers.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.Embers;

public class ItemBase extends Item implements IModeledItem {
    public ItemBase(String name, boolean addToTab) {
        super();
        setUnlocalizedName(name);
        setRegistryName(Embers.MODID + ":" + name);
        if (addToTab) {
            setCreativeTab(Embers.TAB_EMBERS);
        }
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
