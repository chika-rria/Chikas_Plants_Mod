package com.chika.cpm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class ModWaterLilyBlock extends WaterlilyBlock {
    public ModWaterLilyBlock(Properties properties) {
        super(properties);
    }
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos below = pos.below();

        FluidState fluid = level.getFluidState(below);
        FluidState above = level.getFluidState(pos);

        return fluid.getType() == Fluids.WATER
                && fluid.getAmount() == 8
                && above.isEmpty();
    }
}
