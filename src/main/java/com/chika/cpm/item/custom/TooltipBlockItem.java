package com.chika.cpm.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class TooltipBlockItem extends BlockItem {

    private final String tooltipKey;
    private final Supplier<Block> blockSupplier;

    public TooltipBlockItem(Supplier<Block> blockSupplier, Item.Properties properties, String tooltipKey) {
        super(null, properties); // Block は null で一旦登録、実際には supplier から取得
        this.blockSupplier = blockSupplier;
        this.tooltipKey = tooltipKey;
    }

    @Override
    public Block getBlock() {
        return blockSupplier.get();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(tooltipKey).withStyle(net.minecraft.ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable("tooltip.details").withStyle(net.minecraft.ChatFormatting.WHITE));
        }
    }
}
