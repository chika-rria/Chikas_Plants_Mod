package com.chika.cpm.block.custom;

import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class CPM_CottonRoseBlock extends TallFlowerBlock {
    public static final EnumProperty<CottonRoseColor> COLOR = EnumProperty.create("color", CottonRoseColor.class);

    public CPM_CottonRoseBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(COLOR, CottonRoseColor.DAY)); // 初期値
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(COLOR);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER; // 下ブロックだけTick
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // 下ブロックだけ処理
        if (state.getValue(HALF) != DoubleBlockHalf.LOWER) return;

        CottonRoseColor targetColor = getCurrentTimeColor(level);
        if (state.getValue(COLOR) == targetColor) return; // 変化なしなら処理しない

        // 下ブロック更新
        level.setBlock(pos, state.setValue(COLOR, targetColor), 2);

        // 上ブロックも同時に更新
        BlockPos above = pos.above();
        BlockState stateAbove = level.getBlockState(above);
        if (stateAbove.getBlock() instanceof CPM_CottonRoseBlock) {
            level.setBlock(above, stateAbove.setValue(COLOR, targetColor), 2);
        }
    }

    // 時間帯に応じた色取得
    private CottonRoseColor getCurrentTimeColor(Level world) {
        long time = world.getDayTime() % 24000;
        if (time < 12000) return CottonRoseColor.DAY;
        if (time < 18000) return CottonRoseColor.SUNSET;
        return CottonRoseColor.NIGHT;
    }
}
