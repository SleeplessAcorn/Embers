package teamroots.embers.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.Embers;

public class ItemAxeBase2 extends ItemAxe implements IModeledItem {

    public ItemAxeBase2(ToolMaterial material, String name, boolean addToTab, float damage, float speed) {
        super(material, damage - 1.0f, speed - 4.0f);
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
