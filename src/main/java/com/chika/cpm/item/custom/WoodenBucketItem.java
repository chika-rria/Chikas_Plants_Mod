package com.chika.cpm.item.custom;

import com.chika.cpm.init.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class WoodenBucketItem extends Item {
    public WoodenBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (entity.getType() == EntityType.HORSE) {
            // メイン手かオフ手かで取得
            ItemStack handStack = player.getItemInHand(hand);
            if (handStack.getItem() == ModItems.WOODEN_BUCKET.get()) {
                // 馬糞入りバケツ作成
                ItemStack dungBucket = ModItems.HORSE_DUNG_WOODEN_BUCKET.get().getDefaultInstance();
                // スタックが複数ある場合は1個だけ交換
                handStack.shrink(1);
                if (!player.addItem(dungBucket)) {
                    // インベントリに入らなければドロップ
                    player.drop(dungBucket, false);
                }
                return InteractionResult.sidedSuccess(player.level.isClientSide);
            }
        }
        return super.interactLivingEntity(stack, player, entity, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("tooltip.wooden_bucket").withStyle(ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable("tooltip.details").withStyle(ChatFormatting.WHITE));
        }
    }

}
