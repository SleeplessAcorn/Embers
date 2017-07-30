package teamroots.embers.item;

import com.google.common.collect.Sets;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.client.model.ModelLoader;
import teamroots.embers.Embers;

public class ItemAxeBase extends ItemTool implements IModeledItem {

    public ItemAxeBase(ToolMaterial material, String name, boolean addToTab) {
        super(material, Sets.newHashSet(Blocks.PLANKS));
        setUnlocalizedName(name);
        setRegistryName(Embers.MODID + ":" + name);
        if (addToTab) {
            setCreativeTab(Embers.TAB_EMBERS);
        }
        setHarvestLevel("axe", this.toolMaterial.getHarvestLevel());
        this.damageVsEntity = this.toolMaterial.getDamageVsEntity() + 6.0f;
        this.attackSpeed = -3.1f;
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }

    @Override
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
    }
}
