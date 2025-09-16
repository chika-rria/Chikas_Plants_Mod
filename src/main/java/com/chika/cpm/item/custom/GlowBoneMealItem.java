package com.chika.cpm.item.custom;

import com.chika.cpm.init.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class GlowBoneMealItem extends Item {

    public GlowBoneMealItem(Properties properties) {
        super(properties);
    }

    private static final List<Block> DEFAULT_GRASS = List.of(
            Blocks.GRASS, Blocks.FERN, Blocks.TALL_GRASS, Blocks.LARGE_FERN
    );

    private List<Block> getRandomPlantList() {
        List<Block> plantCandidates = new ArrayList<>(DEFAULT_GRASS);
        plantCandidates.addAll(
                ForgeRegistries.BLOCKS.getValues().stream()
                        .filter(block -> block.defaultBlockState().is(ModTags.Blocks.CPM_PLANTS))
                        .toList()
        );
        return plantCandidates;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction clickedFace = context.getClickedFace();
        BlockState clickedBlockState = level.getBlockState(pos);
        Block blockClicked = clickedBlockState.getBlock();
        RandomSource random = level instanceof ServerLevel sl ? sl.getRandom() : RandomSource.create();

        if (level.isClientSide) {
            return InteractionResult.PASS;
        }

        //草ブロックの上面を右クリックした場合
        if (clickedBlockState.is(Blocks.GRASS_BLOCK) && clickedFace == Direction.UP) {
            List<Block> plantCandidates = getRandomPlantList();

            for (int dx = -2; dx <= 2; dx++) {
                for (int dz = -2; dz <= 2; dz++) {
                    if (random.nextDouble() < 0.6) {
                        BlockPos target = pos.offset(dx, 0, dz);
                        BlockPos placePos = target.above();

                        if (level.getBlockState(target).is(Blocks.GRASS_BLOCK) && level.getBlockState(placePos).isAir()) {
                            Block plant = plantCandidates.get(random.nextInt(plantCandidates.size()));

                            if (plant instanceof DoublePlantBlock) {
                                BlockPos upperPos = placePos.above();
                                if (level.getBlockState(upperPos).isAir()) {
                                    // 下半分
                                    BlockState lowerState = plant.defaultBlockState()
                                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
                                    // 上半分
                                    BlockState upperState = plant.defaultBlockState()
                                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                                    level.setBlock(placePos, lowerState, 3);
                                    level.setBlock(upperPos, upperState, 3);
                                }
                            } else {
                                // シングルブロックなら普通に設置
                                level.setBlock(placePos, plant.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
            if (!context.getPlayer().isCreative()) {
                context.getItemInHand().shrink(1);
            }

            return InteractionResult.CONSUME;
        }

        // タグ内の植物を右クリックした場合（同種の植物を周囲に増やす）
        if (clickedBlockState.is(ModTags.Blocks.CPM_PLANTS)) {
            for (int dx = -2; dx <= 2; dx++) {
                for (int dz = -2; dz <= 2; dz++) {
                    if (random.nextDouble() < 0.6) {
                        BlockPos target = pos.offset(dx, -1, dz);
                        BlockPos placePos = target.above();

                        BlockState targetState = level.getBlockState(target);
                        BlockState aboveState = level.getBlockState(placePos);

                        if (targetState.is(Blocks.GRASS_BLOCK) && aboveState.isAir()) {
                            if (blockClicked instanceof DoublePlantBlock) {
                                BlockPos upperPos = placePos.above();
                                if (level.getBlockState(upperPos).isAir()) {
                                    BlockState lowerState = blockClicked.defaultBlockState()
                                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
                                    BlockState upperState = blockClicked.defaultBlockState()
                                            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER);

                                    level.setBlock(placePos, lowerState, 3);
                                    level.setBlock(upperPos, upperState, 3);
                                }
                            } else {
                                level.setBlock(placePos, blockClicked.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
            if (!context.getPlayer().isCreative()) {
                context.getItemInHand().shrink(1);
            }

            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.glow_bone_meal").withStyle(ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable("tooltip.details").withStyle(ChatFormatting.WHITE));
        }
    }
}
