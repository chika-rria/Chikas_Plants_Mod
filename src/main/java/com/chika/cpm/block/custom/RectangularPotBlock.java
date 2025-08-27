package com.chika.cpm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RectangularPotBlock extends CPM_FlowerPotBlock{

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final VoxelShape NORTH_SHAPE = Block.box(1.0D, 0.0D, 3.0D, 15.0D, 6.0D, 13.0D);
    private static final VoxelShape EAST_SHAPE = Block.box(3.0D, 0.0D, 1.0D, 13.0D, 6.0D, 15.0D);

    public VoxelShape getShape(BlockState blockState, BlockGetter level, BlockPos pos, CollisionContext p_152087_) {
        VoxelShape voxelshape = NORTH_SHAPE;
        Direction d = blockState.getValue(FACING);
        if (d == Direction.EAST) {
            voxelshape = EAST_SHAPE;
        }
        if (d == Direction.WEST) {
            voxelshape = EAST_SHAPE;
        }
        return voxelshape;
    }

    public RectangularPotBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIGHT_LEVEL, 0)
                .setValue(FACING, Direction.SOUTH));
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }
}
