package com.chika.cpm.block.custom;

import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import com.chika.cpm.event.FlowerTickManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import javax.annotation.Nullable;

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
        return true; // 必ずTickされるように
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        long time = level.getDayTime() % 24000;
       CottonRoseColor newColor;

        if (time < 12000) {
            newColor = CottonRoseColor.DAY;
        } else if (time < 18000) {
            newColor = CottonRoseColor.SUNSET;
        } else {
            newColor = CottonRoseColor.NIGHT;
        }

        if (state.getValue(COLOR) != newColor) {
            level.setBlock(pos, state.setValue(COLOR, newColor), 2);
        }
    }


    // 時間帯判定
    private CottonRoseColor getCurrentTimeColor(Level world) {
        long time = world.getDayTime() % 24000;
        if (time < 14000) return CottonRoseColor.DAY;       // 昼
        if (time < 18000) return CottonRoseColor.SUNSET;    // 夕方
        return CottonRoseColor.NIGHT;                        // 夜
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, pos, state, placer, stack);

        if (world.isClientSide) return;

        // 設置時の時間帯に応じてCOLOR設定
        CottonRoseColor currentColor = getCurrentTimeColor(world);
        world.setBlock(pos, state.setValue(COLOR, currentColor), 3);
        BlockPos above = pos.above();
        BlockState stateAbove = world.getBlockState(above);
        if (stateAbove.getBlock() instanceof CPM_CottonRoseBlock) {
            world.setBlock(above, stateAbove.setValue(COLOR, currentColor), 3);
        }

        FlowerTickManager.registerFlower(world, pos);
        FlowerTickManager.registerFlower(world, above);
    }
}

