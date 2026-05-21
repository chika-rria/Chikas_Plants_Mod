package com.chika.cpm.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FermentingTeaLeavesItem extends ModTooltipItem {
    private final Supplier<Item> nextItem;
    private final int fermentTime;

    public FermentingTeaLeavesItem(Properties properties, Supplier<Item> nextItem, int fermentTime) {
        super(properties);
        this.nextItem = nextItem;
        this.fermentTime = fermentTime;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity,
                              int slot, boolean selected) {

        if (level.isClientSide) return;

        if (!(entity instanceof Player player)) return;

        // 1秒ごと
        if (level.getGameTime() % 20 != 0) return;

        CompoundTag tag = stack.getOrCreateTag();

        int time = tag.getInt("FermentTime");
        time++;

        tag.putInt("FermentTime", time);

        if (time >= fermentTime) {

            ItemStack newStack = new ItemStack(nextItem.get(), stack.getCount());

            if (stack.hasTag()) {
                newStack.setTag(stack.getTag().copy());
            }

            newStack.getTag().remove("FermentTime");

            player.getInventory().setItem(slot, newStack);
        }
    }
}
