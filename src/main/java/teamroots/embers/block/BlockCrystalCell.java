package teamroots.embers.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.registry.RegistrarEmbersBlocks;
import teamroots.embers.tileentity.TileEntityCrystalCell;

public class BlockCrystalCell extends BlockTEBase {

    public BlockCrystalCell(Material material, String name, boolean addToTab) {
        super(material, name, addToTab);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCrystalCell();
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return world.isAirBlock(pos.east())
                && world.isAirBlock(pos.west())
                && world.isAirBlock(pos.north())
                && world.isAirBlock(pos.south())
                && world.isAirBlock(pos.east().north())
                && world.isAirBlock(pos.east().south())
                && world.isAirBlock(pos.west().north())
                && world.isAirBlock(pos.west().south());
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.setBlockState(pos.north(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(9));
        world.setBlockState(pos.north().west(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(1));
        world.setBlockState(pos.west(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(2));
        world.setBlockState(pos.south().west(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(3));
        world.setBlockState(pos.south(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(4));
        world.setBlockState(pos.south().east(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(5));
        world.setBlockState(pos.east(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(6));
        world.setBlockState(pos.north().east(), RegistrarEmbersBlocks.ADVANCED_EDGE.getStateFromMeta(7));
    }
}
