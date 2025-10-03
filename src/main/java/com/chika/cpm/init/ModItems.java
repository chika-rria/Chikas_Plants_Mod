package com.chika.cpm.init;

import com.chika.cpm.CPMod;
import com.chika.cpm.item.ModCreativeModeTab;
import com.chika.cpm.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CPMod.MOD_ID);


    public static final RegistryObject<Item> GLOW_BONE_MEAL = ITEMS.register("glow_bone_meal",
            () -> new GlowBoneMealItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> BUNDLE_OF_CHARCOAL_ITEM = ITEMS.register("bundle_of_charcoal_item",
            () -> new FuelItem(ModBlocks.BUNDLE_OF_CHARCOAL.get(), 16000, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> WOODEN_BUCKET = ITEMS.register("wooden_bucket",
            () -> new WoodenBucketItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> HORSE_DUNG_WOODEN_BUCKET = ITEMS.register("horse_dung_wooden_bucket",
            () -> new HorseDungBucketItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> RAKE = ITEMS.register("rake",
            () -> new RakeItem(Tiers.IRON, -2, -1.0F, new Item.Properties().durability(250).tab(ModCreativeModeTab.CPM_TAB)));


    public static final RegistryObject<Item> FLOATINGHEART_ITEM = ITEMS.register("floatingheart",
            () -> new PlaceOnWaterBlockItem(ModBlocks.FLOATINGHEART.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PICKERELWEED_ITEM = ITEMS.register("pickerelweed",
            () -> new PlaceOnWaterBlockItem(ModBlocks.PICKERELWEED.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> LOTUS_ITEM = ITEMS.register("lotus",
            () -> new PlaceOnWaterBlockItem(ModBlocks.LOTUS.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));


    //ツールチップ追加用スペース↓
    // Mapで登録情報をまとめて持つ
    private static final Map<String, Supplier<Block>> BLOCK_ITEMS = new HashMap<>();

    static {
        BLOCK_ITEMS.put("flower_pot_orange", () -> ModBlocks.FLOWER_POT_ORANGE.get());
        BLOCK_ITEMS.put("flower_pot_lime", () -> ModBlocks.FLOWER_POT_LIME.get());
        BLOCK_ITEMS.put("flower_bed_dirt", () -> ModBlocks.FLOWER_BED_DIRT.get());
        BLOCK_ITEMS.put("flower_bed_grass", () -> ModBlocks.FLOWER_BED_GRASS.get());
        BLOCK_ITEMS.put("flower_bed_sand", () -> ModBlocks.FLOWER_BED_SAND.get());
        BLOCK_ITEMS.put("water_lily_bowl", () -> ModBlocks.WATER_LILY_BOWL.get());
        // 他の鉢・花壇ブロックもここに追加可能
    }

    // RegistryObject をまとめて作る
    public static final Map<String, RegistryObject<Item>> ITEM_REGISTRY = new HashMap<>();

    public static void registerAll() {
        BLOCK_ITEMS.forEach((name, blockSupplier) -> {
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new TooltipBlockItem(blockSupplier, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), "tooltip." + name));
            ITEM_REGISTRY.put(name, item);
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
