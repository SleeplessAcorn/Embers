package teamroots.embers.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamroots.embers.registry.RegistrarEmbersBlocks;
import teamroots.embers.tileentity.TileEntityInfernoForge;
import teamroots.embers.tileentity.TileEntityInfernoForgeOpening;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockInfernoForge extends BlockTEBase {
    public static final AxisAlignedBB AABB_BASE = new AxisAlignedBB(0, 0, 0, 1, 0.75, 1);
    public static final AxisAlignedBB AABB_TOP = new AxisAlignedBB(0, 0.5, 0, 1, 0.75, 1);
    public static final AxisAlignedBB AABB_TOP2 = new AxisAlignedBB(0, 0, 0, 1, 0.25, 1);
    public static final AxisAlignedBB AABB_NULL = new AxisAlignedBB(0, 0, 0, 0, 0, 0);
    public static final PropertyBool isTop = PropertyBool.create("top");

    public BlockInfernoForge(Material material, String name, boolean addToTab) {
        super(material, name, addToTab);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean b) {
        if (state.getValue(isTop)) {
            TileEntity t = worldIn.getTileEntity(pos);
            if (t instanceof TileEntityInfernoForgeOpening) {
                if (((TileEntityInfernoForgeOpening) t).openAmount > 0.0f) {
                    addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NULL);
                } else {
                    addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_TOP);
                    addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_TOP2);
                }
            }
        } else {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_BASE);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        if (meta == 0) {
            return new TileEntityInfernoForge();
        }
        if (meta == 1) {
            return new TileEntityInfernoForgeOpening();
        }
        return null;
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, isTop);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        boolean top = state.getValue(isTop);
        return top ? 1 : 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(isTop, meta == 1);
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
                && world.isAirBlock(pos.west().south())
                && world.isAirBlock(pos.east().up())
                && world.isAirBlock(pos.west().up())
                && world.isAirBlock(pos.north().up())
                && world.isAirBlock(pos.south().up())
                && world.isAirBlock(pos.east().north().up())
                && world.isAirBlock(pos.east().south().up())
                && world.isAirBlock(pos.west().north().up())
                && world.isAirBlock(pos.west().south().up());
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        if (!state.getValue(isTop)) {
            world.setBlockState(pos.up(), RegistrarEmbersBlocks.INFERNO_FORGE.getStateFromMeta(1));
            world.setBlockState(pos.north(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(0));
            world.setBlockState(pos.north().west(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(1));
            world.setBlockState(pos.west(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(2));
            world.setBlockState(pos.south().west(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(3));
            world.setBlockState(pos.south(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(4));
            world.setBlockState(pos.south().east(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(5));
            world.setBlockState(pos.east(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(6));
            world.setBlockState(pos.north().east(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(7));
            world.setBlockState(pos.north().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(8));
            world.setBlockState(pos.north().west().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(9));
            world.setBlockState(pos.west().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(10));
            world.setBlockState(pos.south().west().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(11));
            world.setBlockState(pos.south().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(12));
            world.setBlockState(pos.south().east().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(13));
            world.setBlockState(pos.east().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(14));
            world.setBlockState(pos.north().east().up(), RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getStateFromMeta(15));
        }
    }

    public void removeEdge(World world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock() == RegistrarEmbersBlocks.INFERNO_FORGE_EDGE) {
            world.setBlockToAir(pos);
            world.notifyBlockUpdate(pos, RegistrarEmbersBlocks.INFERNO_FORGE_EDGE.getDefaultState(), Blocks.AIR.getDefaultState(), 8);
        }
        if (world.getBlockState(pos).getBlock() == this) {
            world.setBlockToAir(pos);
            world.setTileEntity(pos, null);
            world.notifyBlockUpdate(pos, this.getDefaultState().withProperty(isTop, true), Blocks.AIR.getDefaultState(), 8);
        }
    }

    public void cleanEdges(World world, BlockPos pos) {
        removeEdge(world, pos.north());
        removeEdge(world, pos.north().west());
        removeEdge(world, pos.west());
        removeEdge(world, pos.south().west());
        removeEdge(world, pos.south());
        removeEdge(world, pos.south().east());
        removeEdge(world, pos.east());
        removeEdge(world, pos.north().east());
        removeEdge(world, pos.north().up());
        removeEdge(world, pos.north().west().up());
        removeEdge(world, pos.west().up());
        removeEdge(world, pos.south().west().up());
        removeEdge(world, pos.south().up());
        removeEdge(world, pos.south().east().up());
        removeEdge(world, pos.east().up());
        removeEdge(world, pos.north().east().up());
        removeEdge(world, pos.up());
    }

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        if (state.getBlock() == this) {
            if (!state.getValue(isTop)) {
                drops.add(new ItemStack(this, 1));
            }
        }
        return drops;
    }
}
