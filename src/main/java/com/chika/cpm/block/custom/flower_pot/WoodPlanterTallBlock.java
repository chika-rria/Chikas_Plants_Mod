package com.chika.cpm.block.custom.flower_pot;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WoodPlanterTallBlock extends CPM_WoodPlanterBlock {

    private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 12.0D, 13.0D);
    private static final VoxelShape EAST_SHAPE = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 12.0D, 16.0D);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    public WoodPlanterTallBlock(Properties properties) {
        super(properties);
   }

    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {

    }
}
