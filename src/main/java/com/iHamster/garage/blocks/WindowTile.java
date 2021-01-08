package com.iHamster.garage.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class WindowTile extends Block {
    private static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final BooleanProperty POWERED = BlockStateProperties.POWERED;



    public static final VoxelShape SHAPE_N = Stream.of(
            net.minecraft.block.Block.makeCuboidShape(0, 0, 4, 16, 16, 5),
            net.minecraft.block.Block.makeCuboidShape(2, 2, 3, 14, 14, 4),
            net.minecraft.block.Block.makeCuboidShape(0, 0, 3, 16, 1, 4),
            net.minecraft.block.Block.makeCuboidShape(0, 15, 3, 16, 16, 4),
            net.minecraft.block.Block.makeCuboidShape(0, 0, 3, 1, 16, 4),
            net.minecraft.block.Block.makeCuboidShape(15, 0, 3, 16, 16, 4)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_E = Stream.of(
            net.minecraft.block.Block.makeCuboidShape(11, 0, 0, 12, 16, 16),
            net.minecraft.block.Block.makeCuboidShape(12, 2, 2, 13, 14, 14),
            net.minecraft.block.Block.makeCuboidShape(12, 0, 0, 13, 1, 16),
            net.minecraft.block.Block.makeCuboidShape(12, 15, 0, 13, 16, 16),
            net.minecraft.block.Block.makeCuboidShape(12, 0, 0, 13, 16, 1),
            net.minecraft.block.Block.makeCuboidShape(12, 0, 15, 13, 16, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_S = Stream.of(
            net.minecraft.block.Block.makeCuboidShape(0, 0, 11, 16, 16, 12),
            net.minecraft.block.Block.makeCuboidShape(2, 2, 12, 14, 14, 13),
            net.minecraft.block.Block.makeCuboidShape(0, 0, 12, 16, 1, 13),
            net.minecraft.block.Block.makeCuboidShape(0, 15, 12, 16, 16, 13),
            net.minecraft.block.Block.makeCuboidShape(15, 0, 12, 16, 16, 13),
            net.minecraft.block.Block.makeCuboidShape(0, 0, 12, 1, 16, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_W = Stream.of(
            net.minecraft.block.Block.makeCuboidShape(4, 0, 0, 5, 16, 16),
            net.minecraft.block.Block.makeCuboidShape(3, 2, 2, 4, 14, 14),
            net.minecraft.block.Block.makeCuboidShape(3, 0, 0, 4, 1, 16),
            net.minecraft.block.Block.makeCuboidShape(3, 15, 0, 4, 16, 16),
            net.minecraft.block.Block.makeCuboidShape(3, 0, 15, 4, 16, 16),
            net.minecraft.block.Block.makeCuboidShape(3, 0, 0, 4, 16, 1)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public static final VoxelShape SHAPE_UP = Stream.of(
            net.minecraft.block.Block.makeCuboidShape(0, 13, 0, 16, 14, 2),
            net.minecraft.block.Block.makeCuboidShape(0, 13, 14, 16, 14, 16),
            net.minecraft.block.Block.makeCuboidShape(0, 13, 2, 2, 14, 14),
            net.minecraft.block.Block.makeCuboidShape(14, 13, 2, 16, 14, 14),
            net.minecraft.block.Block.makeCuboidShape(2, 13, 2, 14, 15, 14),
            net.minecraft.block.Block.makeCuboidShape(0, 14, 0, 16, 15, 1),
            net.minecraft.block.Block.makeCuboidShape(0, 14, 15, 16, 15, 16),
            net.minecraft.block.Block.makeCuboidShape(0, 14, 0, 1, 15, 16),
            net.minecraft.block.Block.makeCuboidShape(15, 14, 0, 16, 15, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public WindowTile (){
        super(net.minecraft.block.Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f, 15.0f)
                .sound(SoundType.METAL)
                .harvestLevel(-1));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            case UP:
                return SHAPE_UP;
            case DOWN:
                return SHAPE_UP;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        System.out.println("TE CREATED");
        return  new WindowTileEntity();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public boolean canDropFromExplosion (Explosion explosion) {return true;};

    @Override
    protected void fillStateContainer(StateContainer.Builder<net.minecraft.block.Block, BlockState> builder) {
        builder.add(FACING, POWERED);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.98F;
    }
}
