package com.chika.cpm.block.custom.flower_pot;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class SquarePotWoodBlock extends SquarePotBlock {
    public static final BooleanProperty HAS_PLANT = BooleanProperty.create("has_plant");

    public SquarePotWoodBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
          .setValue(HAS_PLANT, false));
    }

    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_PLANT);
    }
}
