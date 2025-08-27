package com.chika.cpm.item.custom;

import com.chika.cpm.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class HorseDungBucketItem extends BoneMealItem {
    public HorseDungBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        boolean success = applyBonemeal(stack, level, pos, context.getPlayer());

        if (success) {
            if (!level.isClientSide) {
                level.levelEvent(1505, pos, 0); // 骨粉エフェクト
                // 使用済み馬糞バケツ→木のバケツ返却
                stack.shrink(1);
                ItemStack woodenBucket = ModItems.WOODEN_BUCKET.get().getDefaultInstance();
                if (!context.getPlayer().addItem(woodenBucket)) {
                    context.getPlayer().drop(woodenBucket, false);
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.horse_dung_bucket").withStyle(ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable("tooltip.details").withStyle(ChatFormatting.WHITE));
        }
    }
}
