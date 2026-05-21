package com.chika.cpm.block.custom.flower_pot;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StandardPotBlock extends CPM_FlowerPotBlock {
    public StandardPotBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {

    }

    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
