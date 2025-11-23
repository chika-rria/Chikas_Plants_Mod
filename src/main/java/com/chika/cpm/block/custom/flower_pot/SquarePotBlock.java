package com.chika.cpm.block.custom.flower_pot;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SquarePotBlock extends CPM_FlowerPotBlock {

    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.5D, 12.0D);

    public SquarePotBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {

    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
