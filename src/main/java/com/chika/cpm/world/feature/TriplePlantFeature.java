package com.chika.cpm.world.feature;

import com.chika.cpm.block.custom.TriplePlantBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class TriplePlantFeature extends Feature<SimpleBlockConfiguration> {
    public TriplePlantFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        SimpleBlockConfiguration config = context.config();

        // Y座標を地面に補正
        int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ());
        BlockPos pos = new BlockPos(origin.getX(), y, origin.getZ());

        BlockState state = config.toPlace().getState(random, pos);

        if (state.getBlock() instanceof TriplePlantBlock triplePlant) {
            // 下段が置けるか確認（3段分空いているか）
            if (level.isEmptyBlock(pos) && level.isEmptyBlock(pos.above()) && level.isEmptyBlock(pos.above(2))) {
                // placeAt() を使って3段まとめて置く
                triplePlant.placeAt(level, pos, 2); // flags=2
                return true;
            }
        }

        return false;
    }
}
