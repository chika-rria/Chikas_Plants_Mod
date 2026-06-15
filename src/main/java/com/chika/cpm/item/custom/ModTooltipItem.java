package com.chika.cpm.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;


public class ModTooltipItem extends Item {

    public ModTooltipItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip,
                                TooltipFlag flag) {

        String key = stack.getDescriptionId();
        String tooltipKey = key.replace("item.", "tooltip.");
        String detailKey = tooltipKey + ".detail";

        boolean hasDetail = I18n.exists(detailKey + ".1");

        // 通常tooltipが存在する時だけ表示
        if (I18n.exists(tooltipKey)) {
            tooltip.add(Component.translatable(tooltipKey)
                    .withStyle(ChatFormatting.WHITE));
        }

        if (hasDetail) {

            if (Screen.hasShiftDown()) {

                int line = 1;

                while (I18n.exists(detailKey + "." + line)) {

                    tooltip.add(Component.translatable(detailKey + "." + line)
                            .withStyle(ChatFormatting.WHITE));

                    line++;
                }

            } else {

                tooltip.add(Component.translatable("tooltip.cpm.details")
                        .withStyle(ChatFormatting.WHITE));
            }
        }
    }
}
