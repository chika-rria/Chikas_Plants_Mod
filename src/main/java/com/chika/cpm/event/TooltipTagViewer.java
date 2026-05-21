package com.chika.cpm.event;

import com.chika.cpm.CPMod;
import com.chika.cpm.Config;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = CPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TooltipTagViewer {

    public TooltipTagViewer() {}

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event){
        if (!Config.enableTagTooltip) return;
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        Set<TagKey<Item>> tagKeys = stack.getTags().collect(Collectors.toSet());


        if(tagKeys.isEmpty()) {
            return;
        }

        if(Screen.hasShiftDown()){
            tooltip.add(Component.literal("=== Tags ===").withStyle(ChatFormatting.GRAY));
            for(TagKey<Item> tagKey : tagKeys){
                ResourceLocation tagID = tagKey.location();
                tooltip.add(Component.literal("#" + tagID.toString()).withStyle(ChatFormatting.DARK_GREEN));
            }
        } else {
            tooltip.add(Component.literal("Shiftでタグ表示").withStyle(ChatFormatting.YELLOW));
        }
    }
}
