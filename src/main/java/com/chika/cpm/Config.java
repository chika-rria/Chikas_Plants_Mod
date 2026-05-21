package com.chika.cpm;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = CPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // 先に宣言追加
    private static final ForgeConfigSpec.BooleanValue ENABLE_TAG_TOOLTIP = BUILDER
            .comment("Whether to show item tags in tooltip when Shift is held")
            .define("enableTagTooltip", false); // デフォルト値は false(OFF)

    // publicで使えるようにする
    public static boolean enableTagTooltip;

    static final ForgeConfigSpec SPEC = BUILDER.build();


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enableTagTooltip = ENABLE_TAG_TOOLTIP.get();
    }
}
