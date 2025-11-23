package com.chika.cpm.block.renderer;

import com.chika.cpm.block.blockentity.CPM_WoodPlanterBlockEntity;
import com.chika.cpm.block.custom.CPM_CottonRoseBlock;
import com.chika.cpm.block.custom.flower_pot.CPM_WoodPlanterBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import com.chika.cpm.block.state.enumtype.PlantType;
import com.chika.cpm.init.ModBlocks;
import com.chika.cpm.init.ModTags;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;


public class CPM_WoodPlanterBlockEntityRenderer implements BlockEntityRenderer<CPM_WoodPlanterBlockEntity> {
    public CPM_WoodPlanterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    // 位置配列
    float[][] POS_NORTH_CROP = {{0f, 0f, 0.2f}, {0.4f, 0f, 0.2f}};
    float[][] POS_NORTH_FLOWER = {{0.025f, 0f, 0.15f}, {0.25f, 0f, 0.35f}, {0.475f, 0f, 0.15f}};
    float[][] POS_EAST_CROP = {{0.2f, 0f, 0f}, {0.2f, 0f, 0.4f}};
    float[][] POS_EAST_FLOWER = {{0.35f, 0f, 0.025f}, {0.15f, 0f, 0.25f}, {0.35f, 0f, 0.475f}};
    float[][] POS_SOUTH_CROP = {{0.4f, 0f, 0.2f}, {0f, 0f, 0.2f}};
    float[][] POS_SOUTH_FLOWER = {{0.475f, 0f, 0.35f}, {0.25f, 0f, 0.15f}, {0.025f, 0f, 0.35f}};
    float[][] POS_WEST_CROP = {{0.2f, 0f, 0.4f}, {0.2f, 0f, 0f}};
    float[][] POS_WEST_FLOWER = {{0.15f, 0f, 0.475f}, {0.35f, 0f, 0.25f}, {0.15f, 0f, 0.025f}};
    // 向きごとの果実位置（0 = 茎, 1 = 果実）
    private static final float[][] POS_NORTH = {
            {0.5f, 0.0f, 0.5f}, // 茎
            {0.475f, 0.0f, 0.115f}  // 果実
    };
    private static final float[][] POS_SOUTH = {
            {0.5f, 0.0f, 0.5f},
            {-0.25f, 0.0f, 0.115f}
    };
    private static final float[][] POS_EAST = {
            {0.5f, 0.0f, 0.5f},
            {0.115f, 0.0f, 0.475f}
    };
    private static final float[][] POS_WEST = {
            {0.5f, 0.0f, 0.5f},
            {0.115f, 0.0f, -0.25f}
    };
    float[][] positions;
    // 鉢タイプ別Y補正

    private static final float OFFSET_Y_NORMAL = 0.1f;
    private static final float OFFSET_Y_HIGH = 0f;  // 必要なら微調整可能

    @Override
    public void render(CPM_WoodPlanterBlockEntity entity, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        if (entity.getLevel() == null) return;

        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        Level level = entity.getLevel();
        BlockState potState = entity.getBlockState();
        PlantType plantType = entity.getPlantType();
        int slots = entity.getContainerSize();
        Direction facing = potState.getValue(CPM_WoodPlanterBlock.FACING);

        // 配置位置を決定
        positions = (plantType == PlantType.CROP) ? switch (facing) {
            case EAST -> POS_EAST_CROP;
            case SOUTH -> POS_SOUTH_CROP;
            case WEST -> POS_WEST_CROP;
            default -> POS_NORTH_CROP;
        } : switch (facing) {
            case EAST -> POS_EAST_FLOWER;
            case SOUTH -> POS_SOUTH_FLOWER;
            case WEST -> POS_WEST_FLOWER;
            default -> POS_NORTH_FLOWER;
        };

        float potOffsetY = potState.is(ModTags.Blocks.HIGH_PLANTER) ? 0.65f : 0.35f;

        for (int i = 0; i < slots; i++) {
            var stackItem = entity.getItem(i);
            if (stackItem.isEmpty()) continue;

            BlockState baseState = PlantRenderMap.getBlockStateFor(stackItem);
            if (baseState == null) continue;

            poseStack.pushPose(); // plantごとの push

            float x = positions[i][0] + (potState.is(ModTags.Blocks.HIGH_PLANTER) ? 0f : 0.045f);
            float y = positions[i][1] + potOffsetY + 0.05f;
            float z = positions[i][2] + (potState.is(ModTags.Blocks.HIGH_PLANTER) ? 0f : 0.03f);

            poseStack.translate(x, y, z);

            Block block = Block.byItem(stackItem.getItem());
            int age = entity.growthStages[i];

            if (block instanceof CropBlock crop) baseState = crop.getStateForAge(age);
            else if (block instanceof SweetBerryBushBlock bush)
                baseState = bush.defaultBlockState().setValue(SweetBerryBushBlock.AGE, age);
            else if (block instanceof NetherWartBlock wart)
                baseState = wart.defaultBlockState().setValue(NetherWartBlock.AGE, age);
            else if (block instanceof StemBlock stem) baseState = stem.defaultBlockState().setValue(StemBlock.AGE, age);

            // 光量
            long time = level.getDayTime() % 24000;
            int adjustedLight = (time >= 0 && time <= 11000)
                    ? LightTexture.pack(15, 15)
                    : LightTexture.pack(level.getBrightness(LightLayer.BLOCK, entity.getBlockPos()),
                    level.getBrightness(LightLayer.SKY, entity.getBlockPos()));

            // CottonRose 色補正
            CottonRoseColor currentColor;
            if (time < 14000) currentColor = CottonRoseColor.DAY;
            else if (time < 18000) currentColor = CottonRoseColor.SUNSET;
            else currentColor = CottonRoseColor.NIGHT;

            if (baseState.getBlock() instanceof CPM_CottonRoseBlock) {
                baseState = baseState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
            }

            float scale = (potState.is(ModTags.Blocks.HIGH_PLANTER))
                    ? (plantType == PlantType.CROP ? 0.6f : 0.5f)
                    : (plantType == PlantType.CROP ? 0.5f : 0.45f);

            poseStack.pushPose();
            poseStack.scale(scale, scale, scale);

            int color = blockColors.getColor(baseState, level, entity.getBlockPos(), 0);
            float r = (color >> 16 & 255) / 255f;
            float g = (color >> 8 & 255) / 255f;
            float b = (color & 255) / 255f;

            BakedModel model = blockRenderer.getBlockModel(baseState);
            blockRenderer.getModelRenderer().renderModel(poseStack.last(),
                    buffer.getBuffer(RenderType.cutout()), null, model, r, g, b, adjustedLight, packedOverlay);



            // DoublePlant 上半分描画
            if (baseState.getBlock() instanceof DoublePlantBlock) {

                poseStack.translate(0, 1, 0);

                BlockState upperState = baseState.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);
                if (baseState.getBlock() instanceof CPM_CottonRoseBlock) {
                    baseState = baseState.setValue(CPM_CottonRoseBlock.COLOR, currentColor);
                }

                int colorUpper = blockColors.getColor(upperState, level, entity.getBlockPos().above(), 0);
                float ur = (colorUpper >> 16 & 255) / 255f;
                float ug = (colorUpper >> 8 & 255) / 255f;
                float ub = (colorUpper & 255) / 255f;

                BakedModel upperModel = blockRenderer.getBlockModel(upperState);
                blockRenderer.getModelRenderer().renderModel(poseStack.last(),
                        buffer.getBuffer(RenderType.cutout()), null, upperModel, ur, ug, ub, adjustedLight, packedOverlay);

            }

            // TriplePlant 上段描画
            if (baseState.getBlock() instanceof TriplePlantBlock) {
                for (int part = 1; part <= 2; part++) {

                    poseStack.translate(0, 1, 0);
                    BlockState upperState = baseState.setValue(TriplePlantBlock.PART,
                            part == 1 ? com.chika.cpm.block.state.enumtype.TripleBlockPart.MIDDLE
                                    : com.chika.cpm.block.state.enumtype.TripleBlockPart.TOP);

                    int upperColor = blockColors.getColor(upperState, level, entity.getBlockPos().above(), 0);
                    float ur = (upperColor >> 16 & 255) / 255f;
                    float ug = (upperColor >> 8 & 255) / 255f;
                    float ub = (upperColor & 255) / 255f;

                    BakedModel upperModel = blockRenderer.getBlockModel(upperState);
                    blockRenderer.getModelRenderer().renderModel(poseStack.last(),
                            buffer.getBuffer(RenderType.cutout()), null, upperModel, ur, ug, ub, adjustedLight, packedOverlay);

                }
            }
            poseStack.popPose();
            // 果実描画
            if (block instanceof StemBlock stem && entity.hasStem) {
                if (age >= 7) { // 成熟時のみ描画
                    boolean isHighPot = potState.is(ModTags.Blocks.HIGH_PLANTER);

                    poseStack.pushPose();

                    record StemTransform(float x, float z, float rotation) {}

                    StemTransform t = switch (facing) {
                        case SOUTH -> new StemTransform(-0.4f, -0.225f, 180f);
                        case WEST  -> new StemTransform(-0.225f, -0.4f, 90f);
                        case EAST  -> new StemTransform(-0.225f, -0.025f, -90f);
                        default    -> new StemTransform(-0.025f, -0.225f, 0f);
                    };

                    float stemX = t.x();
                    float stemZ = t.z();
                    float rotation = t.rotation();

                    float stemY = isHighPot ? OFFSET_Y_NORMAL : OFFSET_Y_HIGH;
                    poseStack.translate(stemX, stemY, stemZ);

                    poseStack.translate(0.5, 0, 0.5);
                    poseStack.mulPose(Vector3f.YP.rotationDegrees(rotation));
                    poseStack.translate(-0.5, 0, -0.5);
                    BakedModel stemModel = blockRenderer.getBlockModel(ModBlocks.CP_DOMMY_STEM.get().defaultBlockState());
                    blockRenderer.getModelRenderer().renderModel(
                            poseStack.last(),
                            buffer.getBuffer(RenderType.cutout()),
                            null, stemModel, r, g, b,
                            adjustedLight, packedOverlay
                    );
                    poseStack.popPose();

                    poseStack.pushPose();

                    // 向きごとの果実座標配列を選択
                    Direction dir = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
                    float[][] positions = switch (dir) {
                        case SOUTH -> POS_SOUTH;
                        case EAST -> POS_EAST;
                        case WEST -> POS_WEST;
                        default -> POS_NORTH;
                    };

                    // スロット1（果実）の位置取得
                    float fx = positions[1][0] + (isHighPot ? 0f : 0.045f);
                    float fy = 0f;
                    float fz = positions[1][2] + (isHighPot ? 0f : 0.03f);

                    poseStack.translate(fx, fy, fz);

                    // 果実のスケール設定
                    float fruitScale = (isHighPot)
                            ? (plantType == PlantType.CROP ? 0.38f : 0.30f)
                            : (plantType == PlantType.CROP ? 0.30f : 0.27f);
                    poseStack.scale(fruitScale, fruitScale, fruitScale);


                    // --- 果実描画 ---
                    BlockState fruitState = stem.getFruit().defaultBlockState();
                    int fruitColor = blockColors.getColor(fruitState, level, entity.getBlockPos(), 0);
                    float fr = (fruitColor >> 16 & 255) / 255f;
                    float fg = (fruitColor >> 8 & 255) / 255f;
                    float fb = (fruitColor & 255) / 255f;
                    BakedModel fruitModel = blockRenderer.getBlockModel(fruitState);
                    blockRenderer.getModelRenderer().renderModel(
                            poseStack.last(),
                            buffer.getBuffer(RenderType.cutout()),
                            null, fruitModel, fr, fg, fb,
                            adjustedLight, packedOverlay
                    );

                    poseStack.popPose();
                }
            }

            poseStack.popPose();
        }
    }
}
