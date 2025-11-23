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

import java.util.LinkedHashMap;
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
    private static final Map<String, Supplier<Block>> BLOCK_ITEMS = new LinkedHashMap<>();
    static {
        BLOCK_ITEMS.put("flower_pot_orange", () -> ModBlocks.FLOWER_POT_ORANGE.get());
        BLOCK_ITEMS.put("flower_pot_lime", () -> ModBlocks.FLOWER_POT_LIME.get());
        BLOCK_ITEMS.put("flower_bed_dirt", () -> ModBlocks.FLOWER_BED_DIRT.get());
        BLOCK_ITEMS.put("flower_bed_grass", () -> ModBlocks.FLOWER_BED_GRASS.get());
        BLOCK_ITEMS.put("flower_bed_sand", () -> ModBlocks.FLOWER_BED_SAND.get());
        BLOCK_ITEMS.put("flower_bed_dirt_half", () -> ModBlocks.FLOWER_BED_DIRT_HALF.get());
        BLOCK_ITEMS.put("flower_bed_grass_half", () -> ModBlocks.FLOWER_BED_GRASS_HALF.get());
        BLOCK_ITEMS.put("flower_bed_sand_half", () -> ModBlocks.FLOWER_BED_SAND_HALF.get());
        BLOCK_ITEMS.put("water_lily_bowl", () -> ModBlocks.WATER_LILY_BOWL.get());
        BLOCK_ITEMS.put("planter_oak", () -> ModBlocks.PLANTER_OAK.get());
        BLOCK_ITEMS.put("planter_spruce", () -> ModBlocks.PLANTER_SPRUCE.get());
        BLOCK_ITEMS.put("planter_birch", () -> ModBlocks.PLANTER_BIRCH.get());
        BLOCK_ITEMS.put("planter_jungle", () -> ModBlocks.PLANTER_JUNGLE.get());
        BLOCK_ITEMS.put("planter_acacia", () -> ModBlocks.PLANTER_ACACIA.get());
        BLOCK_ITEMS.put("planter_dark_oak", () -> ModBlocks.PLANTER_DARK_OAK.get());
        BLOCK_ITEMS.put("planter_mangrove", () -> ModBlocks.PLANTER_MANGROVE.get());
        BLOCK_ITEMS.put("planter_warped", () -> ModBlocks.PLANTER_WARPED.get());
        BLOCK_ITEMS.put("planter_crimson", () -> ModBlocks.PLANTER_CRIMSON.get());
        BLOCK_ITEMS.put("planter_oak_wood", () -> ModBlocks.PLANTER_OAK_WOOD.get());
        BLOCK_ITEMS.put("planter_spruce_wood", () -> ModBlocks.PLANTER_SPRUCE_WOOD.get());
        BLOCK_ITEMS.put("planter_birch_wood", () -> ModBlocks.PLANTER_BIRCH_WOOD.get());
        BLOCK_ITEMS.put("planter_jungle_wood", () -> ModBlocks.PLANTER_JUNGLE_WOOD.get());
        BLOCK_ITEMS.put("planter_acacia_wood", () -> ModBlocks.PLANTER_ACACIA_WOOD.get());
        BLOCK_ITEMS.put("planter_dark_oak_wood", () -> ModBlocks.PLANTER_DARK_OAK_WOOD.get());
        BLOCK_ITEMS.put("planter_mangrove_wood", () -> ModBlocks.PLANTER_MANGROVE_WOOD.get());
        BLOCK_ITEMS.put("planter_warped_wood", () -> ModBlocks.PLANTER_WARPED_WOOD.get());
        BLOCK_ITEMS.put("planter_crimson_wood", () -> ModBlocks.PLANTER_CRIMSON_WOOD.get());
        // 他の鉢・花壇ブロックもここに追加可能
        // メソッド参照NG
    }

    // RegistryObject をまとめて作る
    public static final Map<String, RegistryObject<Item>> ITEM_REGISTRY = new LinkedHashMap<>();

    public static void registerAll() {
        BLOCK_ITEMS.entrySet().stream().toList().forEach(entry -> {
            String name = entry.getKey();
            Supplier<Block> supplier = entry.getValue();
            RegistryObject<Item> item = ITEMS.register(name,
                    () -> new TooltipBlockItem(supplier, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB2), "tooltip." + name));
            ITEM_REGISTRY.put(name, item);
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
