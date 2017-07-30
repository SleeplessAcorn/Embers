package teamroots.embers.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import teamroots.embers.registry.RegistrarEmbersBlocks;
import teamroots.embers.tileentity.TileEntityEmberBore;

public class BlockEmberBore extends BlockTEBase {

    public BlockEmberBore(Material material, String name, boolean addToTab) {
        super(material, name, addToTab);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityEmberBore();
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
        world.setBlockState(pos.north(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(0));
        world.setBlockState(pos.north().west(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(1));
        world.setBlockState(pos.west(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(2));
        world.setBlockState(pos.south().west(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(3));
        world.setBlockState(pos.south(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(4));
        world.setBlockState(pos.south().east(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(5));
        world.setBlockState(pos.east(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(6));
        world.setBlockState(pos.north().east(), RegistrarEmbersBlocks.MECH_EDGE.getStateFromMeta(7));
    }
}
