package com.kitsune.witchcraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class MagicCircleBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = Stream.of(Block.makeCuboidShape(0, 0.1, 0, 16, 0.2, 16)).reduce((v1, v2) -> {
                return VoxelShapes.combine(v1, v2, IBooleanFunction.OR);
            }
    ).get();

    private static final VoxelShape SHAPE_EAST = Stream.of(Block.makeCuboidShape(0, 0.1, 0, 16, 0.2, 16)).reduce((v1, v2) -> {
                return VoxelShapes.combine(v1, v2, IBooleanFunction.OR);
            }
    ).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(Block.makeCuboidShape(0, 0.1, 0, 16, 0.2, 16)).reduce((v1, v2) -> {
                return VoxelShapes.combine(v1, v2, IBooleanFunction.OR);
            }
    ).get();

    private static final VoxelShape SHAPE_WEST = Stream.of(Block.makeCuboidShape(0, 0.1, 0, 16, 0.2, 16)).reduce((v1, v2) -> {
                return VoxelShapes.combine(v1, v2, IBooleanFunction.OR);
            }
    ).get();

    public MagicCircleBlock() {
        super(AbstractBlock.Properties.create(Material.CARPET)
                .hardnessAndResistance(0.5f, 0.5f)
                .sound(SoundType.FUNGUS)
                .harvestLevel(0));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.6f;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
