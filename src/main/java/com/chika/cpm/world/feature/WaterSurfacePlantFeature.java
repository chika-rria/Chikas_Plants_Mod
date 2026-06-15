package com.chika.cpm.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class WaterSurfacePlantFeature extends Feature<SimpleBlockConfiguration> {
    public WaterSurfacePlantFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        BlockState toPlace = context.config().toPlace().getState(random, origin);

        boolean placed = false;

        // 群生感を出す：1回のplaceで複数回試行
        for (int i = 0; i < 12; i++) {  // 生成範囲を広めに
            int x = origin.getX() + random.nextInt(8) - random.nextInt(8);
            int z = origin.getZ() + random.nextInt(8) - random.nextInt(8);
            int y = origin.getY() + random.nextInt(2) - random.nextInt(2); // 水面近く
            BlockPos pos = new BlockPos(x, y, z);

            if (level.getBlockState(pos).is(Blocks.WATER) && level.getBlockState(pos.above()).isAir()) {
                level.setBlock(pos.above(), toPlace, 2);
                placed = true;
            }
        }

        return placed;
    }
}
