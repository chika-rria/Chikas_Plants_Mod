package com.chika.cpm.item.custom;

import com.chika.cpm.init.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber
public class RakeItem extends HoeItem {
    private static final List<RakeTask> tasks = new ArrayList<>();

    public RakeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Block blockClicked = level.getBlockState(pos).getBlock();

        if (!level.isClientSide  && player != null &&
                (blockClicked == Blocks.GRASS_BLOCK || blockClicked == Blocks.DIRT || blockClicked == Blocks.DIRT_PATH)) {
            // クリック時に範囲タスクを登録
            tasks.add(new RakeTask(level, pos, player));
            player.swing(context.getHand(), true);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    // 毎tick処理
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (tasks.isEmpty()) return;

        List<RakeTask> finished = new ArrayList<>();
        for (RakeTask task : tasks) {
            if (!task.processNext()) {
                finished.add(task);
            }
        }
        tasks.removeAll(finished);
    }

    // 範囲ごとの処理を管理
    private static class RakeTask {
        private final Level level;
        private final BlockPos origin;
        private final Player player;
        private final List<BlockPos> positions = new ArrayList<>();
        private int index = 0;

        RakeTask(Level level, BlockPos origin, Player player) {
            this.level = level;
            this.origin = origin;
            this.player = player;

            int[] range = {-1, 0, 1};
            for (int i : range) {
                for (int j : range) {
                    positions.add(new BlockPos(origin.getX() + i, origin.getY(), origin.getZ() + j));
                }
            }
        }

        // true:まだ残ってる、false:完了
        boolean processNext() {
            if (index >= positions.size()) return false;

            BlockPos rP = positions.get(index);
            Block blockAbove = level.getBlockState(rP.above()).getBlock();
            boolean canRemove = blockAbove == Blocks.GRASS || blockAbove == Blocks.TALL_GRASS || blockAbove == Blocks.FERN;

            if (canRemove) {
                level.setBlock(rP.above(), Blocks.AIR.defaultBlockState(), 3);
            } else if (blockAbove.defaultBlockState().is(BlockTags.SMALL_FLOWERS) ||
                    blockAbove.defaultBlockState().is(ModTags.Blocks.CPM_PLANTS)) {
                Block.popResource(level, rP.above(), new ItemStack(blockAbove.asItem()));
                level.setBlock(rP.above(), Blocks.AIR.defaultBlockState(), 3);
            }

            Block blockBelow = level.getBlockState(rP).getBlock();
            boolean canTill = blockBelow == Blocks.GRASS_BLOCK || blockBelow == Blocks.DIRT || blockBelow == Blocks.DIRT_PATH;

            if ((canRemove || blockAbove == Blocks.AIR ||
                    blockAbove.defaultBlockState().is(BlockTags.SMALL_FLOWERS) ||
                    blockAbove.defaultBlockState().is(ModTags.Blocks.CPM_PLANTS)) && canTill) {

                level.setBlock(rP, Blocks.FARMLAND.defaultBlockState(), 2);
                if (index == 0) { // 音は最初だけ
                    level.playSound(null, rP, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                }

                // ランダムで種を落とす
                if (Math.random() < 0.02) {
                    dropRandomSeed(level, rP);
                }
            }

            index++;
            return index < positions.size();
        }

        private void dropRandomSeed(Level level, BlockPos pos) {
            var seedTag = ModTags.Items.CPM_SEEDS;
            var registry = level.registryAccess().registryOrThrow(Registry.ITEM_REGISTRY);

            List<Item> seeds = registry.getTag(seedTag)
                    .map(hs -> hs.stream().map(Holder::value).collect(Collectors.toList()))
                    .orElse(List.of());

            if (!seeds.isEmpty()) {
                int idx = (int) (Math.random() * seeds.size());
                Block.popResource(level, pos.above(), new ItemStack(seeds.get(idx)));
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.rake").withStyle(ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable("tooltip.details").withStyle(ChatFormatting.WHITE));
        }
    }
}
