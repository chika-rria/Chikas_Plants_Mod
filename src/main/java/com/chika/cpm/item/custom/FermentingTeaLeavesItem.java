package com.chika.cpm.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FermentingTeaLeavesItem extends ModTooltipItem {

    private static final String FERMENT_START_TIME = "FermentStartTime";

    private final Supplier<Item> nextItem;
    private final int fermentTime;

    public FermentingTeaLeavesItem(Properties properties,
                                   Supplier<Item> nextItem,
                                   int fermentTime) {
        super(properties);
        this.nextItem = nextItem;
        this.fermentTime = fermentTime;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity,
                              int slot, boolean selected) {

        if (level.isClientSide) return;

        if (!(entity instanceof Player player)) return;

        // 完成判定は1秒ごと
        if (level.getGameTime() % 20 != 0) return;

        CompoundTag tag = stack.getOrCreateTag();

        // 初回のみ発酵開始時刻を保存
        if (!tag.contains(FERMENT_START_TIME)) {

            // 60秒単位に丸める
            long batchTime = (level.getGameTime() / 1200) * 1200;

            tag.putLong(FERMENT_START_TIME, batchTime);
        }

        long startTime = tag.getLong(FERMENT_START_TIME);

        long elapsedSeconds =
                (level.getGameTime() - startTime) / 20;

        if (elapsedSeconds >= fermentTime) {

            ItemStack newStack =
                    new ItemStack(nextItem.get(), stack.getCount());

            if (stack.hasTag()) {
                newStack.setTag(stack.getTag().copy());
            }

            if (newStack.hasTag()) {
                newStack.getTag().remove(FERMENT_START_TIME);
            }

            player.getInventory().setItem(slot, newStack);
        }
    }
}