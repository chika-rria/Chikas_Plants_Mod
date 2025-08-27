package com.chika.cpm.block.renderer;

import com.chika.cpm.block.blockentity.CPM_FlowerPotBlockEntity;
import com.chika.cpm.block.custom.CPM_CottonRoseBlock;
import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import com.chika.cpm.init.ModBlocks;
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

import java.util.Map;

public class CPM_FlowerPotBlockEntityRenderer implements BlockEntityRenderer<CPM_FlowerPotBlockEntity> {


    private static final Map<Item, Block> POTTED_OVERRIDES = Map.of(
            Items.AZALEA, ModBlocks.CP_AZALEA.get(),
            Items.FLOWERING_AZALEA, ModBlocks.CP_FLOWERING_AZALEA.get(),
            Items.CACTUS, ModBlocks.CP_CACTUS.get(),
            Items.BAMBOO, ModBlocks.CP_BAMBOO.get(),
            Items.WARPED_ROOTS, ModBlocks.CP_WARPED_ROOTS.get(),
            Items.CRIMSON_ROOTS, ModBlocks.CP_CRIMSON_ROOTS.get()
            // 後ろのBlockを鉢植え用に自作して対応
    );

    public CPM_FlowerPotBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        // 必要なら初期化
    }

    @Override
    public void render(CPM_FlowerPotBlockEntity entity, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        ItemStack plant = entity.getItem();
        if (plant.isEmpty()) return;

        Block displayBlock = POTTED_OVERRIDES.get(plant.getItem());
        if (displayBlock == null) {
            displayBlock = Block.byItem(plant.getItem());
        }

        BlockState baseState = displayBlock.defaultBlockState();
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();

        poseStack.pushPose();
        try {
            BlockPos pos = entity.getBlockPos();
            Level level = entity.getLevel();

            if (level == null) return;

            // 時間取得＆光量調整
            long time = level.getDayTime() % 24000;
            int adjustedLight;
            if (time >= 0 && time <= 12000) {
                // 昼間は最大光量
                adjustedLight = LightTexture.pack(15, 15);
            } else {
                // それ以外は周囲の光量
                int blockLight = level.getBrightness(LightLayer.BLOCK, pos);
                int skyLight = level.getBrightness(LightLayer.SKY, pos);
                adjustedLight = LightTexture.pack(blockLight, skyLight);
            }

            CottonRoseColor currentColor;
            if (time < 14000) currentColor = CottonRoseColor.DAY;
            else if (time < 18000) currentColor = CottonRoseColor.SUNSET;
            else currentColor = CottonRoseColor.NIGHT;
            if (baseState.getBlock() instanceof CPM_CottonRoseBlock) {
                baseState = baseState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
            }

            float scale = 0.8F;
            if (baseState.getBlock() instanceof DoublePlantBlock) {
                scale = 0.7F;
            }

            float offset = (1.0f - scale) / 2.0f;
            poseStack.translate(offset, 0.2625, offset);
            poseStack.scale(scale, scale, scale);

            int color = blockColors.getColor(baseState, level, pos, 0);
            float r = (color >> 16 & 255) / 255.0f;
            float g = (color >> 8 & 255) / 255.0f;
            float b = (color & 255) / 255.0f;

            // BakedModel取得
            BakedModel model = blockRenderer.getBlockModel(baseState);

            Minecraft.getInstance().getBlockRenderer()
                    .getModelRenderer()
                    .renderModel(poseStack.last(), buffer.getBuffer(RenderType.cutout()),
                            null, model, r, g, b, adjustedLight, packedOverlay);


            // DoublePlantBlockの場合、上半分も描画
            if (baseState.getBlock() instanceof DoublePlantBlock) {
                BlockState upperState = baseState.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                if (baseState.getBlock() instanceof CPM_CottonRoseBlock) {
                    upperState = upperState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
                }

                poseStack.translate(0.0, 1.0, 0.0);
                int colorUpper = blockColors.getColor(upperState, level, pos.above(), 0);
                float ur = (colorUpper >> 16 & 255) / 255f;
                float ug = (colorUpper >> 8 & 255) / 255f;
                float ub = (colorUpper & 255) / 255f;

                model = blockRenderer.getBlockModel(upperState);
                blockRenderer.getModelRenderer().renderModel(
                        poseStack.last(),
                        buffer.getBuffer(RenderType.cutout()),
                        null, model, ur, ug, ub, adjustedLight, packedOverlay
                );
            }

        } finally {
            poseStack.popPose();
        }
    }
}
