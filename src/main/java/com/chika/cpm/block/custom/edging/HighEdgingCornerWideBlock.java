package com.chika.cpm.block.custom.edging;

import com.chika.cpm.block.custom.RotateBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HighEdgingCornerWideBlock extends RotateBlock {
    private static final VoxelShape EAST_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 4.0D, 10.0D, 4.0D);
    private static final VoxelShape WEST_SHAPE = Block.box(12.0D, 0.0D, 12.0D, 16.0D, 10.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(12.0D, 0.0D, 0.0D, 16.0D, 10.0D, 4.0D);
    private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 12.0D, 4.0D, 10.0D, 16.0D);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case SOUTH -> SOUTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    public HighEdgingCornerWideBlock(Properties properties) {
        super(properties.strength(0.25F));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.SOUTH));
    }
}
