package com.chika.cpm.world.feature;

import com.chika.cpm.block.custom.TriplePlantBlock;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.List;

public class MixedPlantPatchFeature extends Feature<NoneFeatureConfiguration> {

    private final List<Block> plants;

    public MixedPlantPatchFeature(Codec<NoneFeatureConfiguration> codec, List<Block> plants) {
        super(codec);
        this.plants = plants;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int attempts = 10; // 試行回数。必要に応じて調整

        boolean placedAny = false;

        for (int i = 0; i < attempts; i++) {
            int dx = random.nextInt(4) - random.nextInt(4);
            int dz = random.nextInt(4) - random.nextInt(4);
            BlockPos pos = origin.offset(dx, 0, dz);

            // ① Y座標を地面の高さに補正
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ());
            BlockPos groundPos = new BlockPos(pos.getX(), y, pos.getZ());

            // ② 地面チェック（固体の上のみ生成）
            BlockState below = level.getBlockState(groundPos.below());
            if (!below.getMaterial().isSolid()) continue;

            // ③ ランダムで植物を選ぶ
            Block chosen = plants.get(random.nextInt(plants.size()));

            // ④ 植物の段数に応じて配置
            if (chosen instanceof TriplePlantBlock triple) {
                triple.placeAt(level, groundPos, 2);
            } else if (chosen instanceof DoublePlantBlock doublePlant) {
                BlockState state = doublePlant.defaultBlockState();
                doublePlant.placeAt(level, state, groundPos,2);
            } else {
                // 単体ブロックの場合
                level.setBlock(groundPos, chosen.defaultBlockState(), 2);
            }

            placedAny = true;
        }

        return placedAny;
    }
}
