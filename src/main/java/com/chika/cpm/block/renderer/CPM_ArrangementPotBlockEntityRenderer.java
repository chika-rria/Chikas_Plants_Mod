package com.chika.cpm.block.renderer;

import com.chika.cpm.block.blockentity.CPM_ArrangementPotBlockEntity;
import com.chika.cpm.block.custom.CPM_CottonRoseBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import com.chika.cpm.block.state.enumtype.TripleBlockPart;
import com.chika.cpm.init.ModTags;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class CPM_ArrangementPotBlockEntityRenderer implements BlockEntityRenderer<CPM_ArrangementPotBlockEntity> {

    public CPM_ArrangementPotBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        // 必要なら初期化
    }

    @Override
    public void render(CPM_ArrangementPotBlockEntity entity, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        Level level = entity.getLevel();
        if (level == null) return;


        for (int i = 0; i < entity.getSlots(); i++) {
            ItemStack stackItem = entity.getPlant(i);
            if (stackItem.isEmpty()) continue;

            BlockState baseState = PlantRenderMap.getBlockStateFor(stackItem);
            BlockState potState = entity.getBlockState();
            boolean isFlowerBed = potState.is(ModTags.Blocks.FLOWER_BED);


            float[][] positions;
            if (isFlowerBed) {
                positions = new float[][]{
                        {0.2f, 0f, 0.3f},
                        {0.8f, 0f, 0.3f},
                        {0.5f, 0f, 0.8f}
                };
            } else {
                positions = new float[][]{
                        {0.3f, 0f, 0.4f},
                        {0.7f, 0f, 0.4f},
                        {0.5f, 0f, 0.7f}
                };
            }

            // ▼鉢の高さ補正
            float potOffsetY;
            if (isFlowerBed) {
                potOffsetY = 1F - 0.2625f;
            } else potOffsetY = 0.45F;

            if (baseState.is(ModTags.Blocks.OFFSET_UP)) {
                potOffsetY = potOffsetY + 0.2F;
            }


            // ▼時間と光量
            long time = level.getDayTime() % 24000;
            int adjustedLight;
            if (time >= 0 && time <= 11000) adjustedLight = LightTexture.pack(15, 15);
            else {
                int blockLight = level.getBrightness(LightLayer.BLOCK, entity.getBlockPos());
                int skyLight = level.getBrightness(LightLayer.SKY, entity.getBlockPos());
                adjustedLight = LightTexture.pack(blockLight, skyLight);
            }

            // ▼CottonRose のカラー補正
            if (baseState.getBlock() instanceof CPM_CottonRoseBlock) {
                CottonRoseColor currentColor;
                if (time < 14000) currentColor = CottonRoseColor.DAY;
                else if (time < 18000) currentColor = CottonRoseColor.SUNSET;
                else currentColor = CottonRoseColor.NIGHT;
                baseState = baseState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
            }

            // ▼モデルスケール
            float scale;
            if (baseState.getBlock() instanceof DoublePlantBlock) {
                scale = isFlowerBed ? 0.6F : 0.5F;  // 花壇用は少し大きめ
            } else if (baseState.getBlock() instanceof TriplePlantBlock) {
                scale = isFlowerBed ? 0.45F : 0.4F;
            } else if (baseState.is(ModTags.Blocks.SCALE_DOWN) || baseState.getBlock() instanceof CactusBlock) {
                scale = isFlowerBed ? 0.3F : 0.25F;
            } else {
                scale = isFlowerBed ? 0.8F : 0.6F;
            }


            // ▼花壇用に固定差を追加（左前・右前・後ろ）
            if (isFlowerBed) {
                float[] flowerBedScales = {scale + 0.05f, scale - 0.05f, scale};
                scale = flowerBedScales[i];
            }

            float offset = (1.0f - scale) / 2.0f;

            poseStack.pushPose();
            // 鉢上での位置
            poseStack.translate(positions[i][0] - 0.5f + offset, 0.2625f + potOffsetY, positions[i][2] - 0.5f + offset);
            poseStack.scale(scale, scale, scale);

            // ▼色取得
            int color = blockColors.getColor(baseState, level, entity.getBlockPos(), 0);
            float r = (color >> 16 & 255) / 255f;
            float g = (color >> 8 & 255) / 255f;
            float b = (color & 255) / 255f;

            // ▼BakedModel取得
            BakedModel model = blockRenderer.getBlockModel(baseState);
            blockRenderer.getModelRenderer().renderModel(
                    poseStack.last(),
                    buffer.getBuffer(RenderType.cutout()),
                    null, model, r, g, b, adjustedLight, packedOverlay
            );

            // ▼DoublePlantBlock の上半分描画
            if (baseState.getBlock() instanceof DoublePlantBlock) {
                BlockState upperState = baseState.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                // CottonRose は上半分もカラー補正
                if (upperState.getBlock() instanceof CPM_CottonRoseBlock) {
                    CottonRoseColor currentColor;
                    if (time < 14000) currentColor = CottonRoseColor.DAY;
                    else if (time < 18000) currentColor = CottonRoseColor.SUNSET;
                    else currentColor = CottonRoseColor.NIGHT;
                    upperState = upperState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
                }

                // Y 座標補正
                poseStack.translate(0.0, 1.0, 0.0);

                int colorUpper = blockColors.getColor(upperState, level, entity.getBlockPos().above(), 0);
                float ur = (colorUpper >> 16 & 255) / 255f;
                float ug = (colorUpper >> 8 & 255) / 255f;
                float ub = (colorUpper & 255) / 255f;

                BakedModel upperModel = blockRenderer.getBlockModel(upperState);
                blockRenderer.getModelRenderer().renderModel(
                        poseStack.last(),
                        buffer.getBuffer(RenderType.cutout()),
                        null, upperModel, ur, ug, ub, adjustedLight, packedOverlay
                );
            }
            // TriplePlantBlockの場合、上二段も描画
            if (baseState.getBlock() instanceof TriplePlantBlock) {
                BlockState upperState = baseState.setValue(TriplePlantBlock.PART, TripleBlockPart.MIDDLE);
                BlockState upperState2 = baseState.setValue(TriplePlantBlock.PART, TripleBlockPart.TOP);

                poseStack.translate(0.0, 1.0, 0.0);
                int colorUpper = blockColors.getColor(upperState, level, entity.getBlockPos().above(), 0);
                float ur = (colorUpper >> 16 & 255) / 255f;
                float ug = (colorUpper >> 8 & 255) / 255f;
                float ub = (colorUpper & 255) / 255f;

                model = blockRenderer.getBlockModel(upperState);

                blockRenderer.getModelRenderer().renderModel(
                        poseStack.last(),
                        buffer.getBuffer(RenderType.cutout()),
                        null, model, ur, ug, ub, adjustedLight, packedOverlay
                );

                poseStack.translate(0.0, 1.0, 0.0);
                model = blockRenderer.getBlockModel(upperState2);
                blockRenderer.getModelRenderer().renderModel(
                        poseStack.last(),
                        buffer.getBuffer(RenderType.cutout()),
                        null, model, ur, ug, ub, adjustedLight, packedOverlay
                );
            }

            poseStack.popPose();
        }
    }
}
