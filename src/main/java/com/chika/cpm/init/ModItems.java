package com.chika.cpm.init;

import com.chika.cpm.CPMod;
import com.chika.cpm.item.ModCreativeModeTab;
import com.chika.cpm.item.custom.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
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
            () -> new HorseDungWoodenBucketItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> RAKE = ITEMS.register("rake",
            () -> new RakeItem(Tiers.IRON, -2, -1.0F, new Item.Properties().durability(250).tab(ModCreativeModeTab.CPM_TAB)));


    public static final RegistryObject<Item> FLOATINGHEART_ITEM = ITEMS.register("floatingheart",
            () -> new PlaceOnWaterBlockItem(ModBlocks.FLOATINGHEART.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PICKERELWEED_ITEM = ITEMS.register("pickerelweed",
            () -> new PlaceOnWaterBlockItem(ModBlocks.PICKERELWEED.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> LOTUS_ITEM = ITEMS.register("lotus",
            () -> new PlaceOnWaterBlockItem(ModBlocks.LOTUS.get(), new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));

    //Trees
    public static final RegistryObject<Item> CAMELLIA_SAPLING_ITEM = ITEMS.register("camellia_sapling_item",
            () -> new FuelItem(ModBlocks.CAMELLIA_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_SAPLING_ITEM = ITEMS.register("chestnut_sapling_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> FRAGRANT_OLIVE_SAPLING_ITEM = ITEMS.register("fragrant_olive_sapling_item",
            () -> new FuelItem(ModBlocks.FRAGRANT_OLIVE_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> GINKGO_SAPLING_ITEM = ITEMS.register("ginkgo_sapling_item",
            () -> new FuelItem(ModBlocks.GINKGO_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> LEMON_SAPLING_ITEM = ITEMS.register("lemon_sapling_item",
            () -> new FuelItem(ModBlocks.LEMON_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> MAPLE_SAPLING_ITEM = ITEMS.register("maple_sapling_item",
            () -> new FuelItem(ModBlocks.MAPLE_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_SAPLING_ITEM = ITEMS.register("paulownia_sapling_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_SAPLING_ITEM = ITEMS.register("ume_sapling_item",
            () -> new FuelItem(ModBlocks.UME_SAPLING.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> TEA_SAPLING = ITEMS.register("tea_sapling",
            () -> new ItemNameBlockItem(ModBlocks.TEA_TREE_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));

    public static final RegistryObject<Item> UME_LOG_ITEM = ITEMS.register("ume_log_item",
            () -> new FuelItem(ModBlocks.UME_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_WOOD_ITEM = ITEMS.register("ume_wood_item",
            () -> new FuelItem(ModBlocks.UME_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_UME_LOG_ITEM = ITEMS.register("stripped_ume_log_item",
            () -> new FuelItem(ModBlocks.STRIPPED_UME_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_UME_WOOD_ITEM = ITEMS.register("stripped_ume_wood_item",
            () -> new FuelItem(ModBlocks.STRIPPED_UME_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_PLANKS_ITEM = ITEMS.register("ume_planks_item",
            () -> new FuelItem(ModBlocks.UME_PLANKS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_STAIRS_ITEM = ITEMS.register("ume_stairs_item",
            () -> new FuelItem(ModBlocks.UME_STAIRS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_SLAB_ITEM = ITEMS.register("ume_slab_item",
            () -> new FuelItem(ModBlocks.UME_SLAB.get(), 150, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_FENCE_ITEM = ITEMS.register("ume_fence_item",
            () -> new FuelItem(ModBlocks.UME_FENCE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_FENCE_GATE_ITEM = ITEMS.register("ume_fence_gate_item",
            () -> new FuelItem(ModBlocks.UME_FENCE_GATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_BUTTON_ITEM = ITEMS.register("ume_button_item",
            () -> new FuelItem(ModBlocks.UME_BUTTON.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_PRESSURE_PLATE_ITEM = ITEMS.register("ume_pressure_plate_item",
            () -> new FuelItem(ModBlocks.UME_PRESSURE_PLATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_DOOR_ITEM = ITEMS.register("ume_door_item",
            () -> new FuelItem(ModBlocks.UME_DOOR.get(), 200, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> UME_TRAPDOOR_ITEM = ITEMS.register("ume_trapdoor_item",
            () -> new FuelItem(ModBlocks.UME_TRAPDOOR.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));

    public static final RegistryObject<Item> PAULOWNIA_LOG_ITEM = ITEMS.register("paulownia_log_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_WOOD_ITEM = ITEMS.register("paulownia_wood_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_PAULOWNIA_LOG_ITEM = ITEMS.register("stripped_paulownia_log_item",
            () -> new FuelItem(ModBlocks.STRIPPED_PAULOWNIA_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_PAULOWNIA_WOOD_ITEM = ITEMS.register("stripped_paulownia_wood_item",
            () -> new FuelItem(ModBlocks.STRIPPED_PAULOWNIA_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_PLANKS_ITEM = ITEMS.register("paulownia_planks_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_PLANKS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_STAIRS_ITEM = ITEMS.register("paulownia_stairs_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_STAIRS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_SLAB_ITEM = ITEMS.register("paulownia_slab_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_SLAB.get(), 150, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_FENCE_ITEM = ITEMS.register("paulownia_fence_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_FENCE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_FENCE_GATE_ITEM = ITEMS.register("paulownia_fence_gate_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_FENCE_GATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_BUTTON_ITEM = ITEMS.register("paulownia_button_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_BUTTON.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_PRESSURE_PLATE_ITEM = ITEMS.register("paulownia_pressure_plate_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_PRESSURE_PLATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_DOOR_ITEM = ITEMS.register("paulownia_door_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_DOOR.get(), 200, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> PAULOWNIA_TRAPDOOR_ITEM = ITEMS.register("paulownia_trapdoor_item",
            () -> new FuelItem(ModBlocks.PAULOWNIA_TRAPDOOR.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));

    public static final RegistryObject<Item> CHESTNUT_LOG_ITEM = ITEMS.register("chestnut_log_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_WOOD_ITEM = ITEMS.register("chestnut_wood_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_CHESTNUT_LOG_ITEM = ITEMS.register("stripped_chestnut_log_item",
            () -> new FuelItem(ModBlocks.STRIPPED_CHESTNUT_LOG.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> STRIPPED_CHESTNUT_WOOD_ITEM = ITEMS.register("stripped_chestnut_wood_item",
            () -> new FuelItem(ModBlocks.STRIPPED_CHESTNUT_WOOD.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_PLANKS_ITEM = ITEMS.register("chestnut_planks_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_PLANKS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_STAIRS_ITEM = ITEMS.register("chestnut_stairs_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_STAIRS.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_SLAB_ITEM = ITEMS.register("chestnut_slab_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_SLAB.get(), 150, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_FENCE_ITEM = ITEMS.register("chestnut_fence_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_FENCE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_FENCE_GATE_ITEM = ITEMS.register("chestnut_fence_gate_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_FENCE_GATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_BUTTON_ITEM = ITEMS.register("chestnut_button_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_BUTTON.get(), 100, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_PRESSURE_PLATE_ITEM = ITEMS.register("chestnut_pressure_plate_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_PRESSURE_PLATE.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_DOOR_ITEM = ITEMS.register("chestnut_door_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_DOOR.get(), 200, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> CHESTNUT_TRAPDOOR_ITEM = ITEMS.register("chestnut_trapdoor_item",
            () -> new FuelItem(ModBlocks.CHESTNUT_TRAPDOOR.get(), 300, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));

    //Signs
    public static final RegistryObject<Item> CHESTNUT_SIGN = ITEMS.register("chestnut_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.CPM_TAB),
                    ModBlocks.CHESTNUT_SIGN.get(), ModBlocks.CHESTNUT_WALL_SIGN.get(), 200));
    public static final RegistryObject<Item> PAULOWNIA_SIGN = ITEMS.register("paulownia_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.CPM_TAB),
                    ModBlocks.PAULOWNIA_SIGN.get(), ModBlocks.PAULOWNIA_WALL_SIGN.get(), 200));
    public static final RegistryObject<Item> UME_SIGN = ITEMS.register("ume_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.CPM_TAB),
                    ModBlocks.UME_SIGN.get(), ModBlocks.UME_WALL_SIGN.get(), 200));


    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).alwaysEat().build())));
    public static final RegistryObject<Item> FRESH_TEA_LEAVES = ITEMS.register("fresh_tea_leaves",
            () -> new FermentingTeaLeavesItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), ModItems.SEMI_FERMENTED_TEA_LEAVES,1200));
    public static final RegistryObject<Item> SEMI_FERMENTED_TEA_LEAVES = ITEMS.register("semi_fermented_tea_leaves",
            () -> new FermentingTeaLeavesItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), ModItems.FERMENTED_TEA_LEAVES,1200));
    public static final RegistryObject<Item> FERMENTED_TEA_LEAVES = ITEMS.register("fermented_tea_leaves",
            () -> new ModTooltipItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> GREEN_TEA_LEAVES = ITEMS.register("green_tea_leaves",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> BLACK_TEA_LEAVES = ITEMS.register("black_tea_leaves",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> OOLONG_TEA_LEAVES = ITEMS.register("oolong_tea_leaves",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 22, 1800)); //absorption
    public static final RegistryObject<Item> LEMONADE = ITEMS.register("lemonade",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 3, 4200)); //haste
    public static final RegistryObject<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 1, 3000)); //speed
    public static final RegistryObject<Item> VEGETABLE_JUICE = ITEMS.register("vegetable_juice",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 10, 2400)); //regeneration
    public static final RegistryObject<Item> GREEN_TEA = ITEMS.register("green_tea",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 10, 1600)); //regeneration
    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 3, 3000)); //haste
    public static final RegistryObject<Item> OOLONG_TEA = ITEMS.register("oolong_tea",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 23, 7)); //saturation
    public static final RegistryObject<Item> CHAMOMILE_TEA = ITEMS.register("chamomile_tea",
            () -> new ModDrinkItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB), 11, 1600)); //resistance


    //ツールチップ追加用スペース↓
    // Mapで登録情報をまとめて持つ
    private static final Map<String, Supplier<Block>> BLOCK_ITEMS = new LinkedHashMap<>();
    static {
        BLOCK_ITEMS.put("large_pot_blue", () -> ModBlocks.LARGE_POT_BLUE.get());
        BLOCK_ITEMS.put("large_pot_orange", () -> ModBlocks.LARGE_POT_ORANGE.get());
        BLOCK_ITEMS.put("large_pot_lime", () -> ModBlocks.LARGE_POT_LIME.get());
        BLOCK_ITEMS.put("large_pot_herringbone_oak", () -> ModBlocks.LARGE_POT_HERRINGBONE_OAK.get());
        BLOCK_ITEMS.put("large_pot_herringbone_dark_oak", () -> ModBlocks.LARGE_POT_HERRINGBONE_DARK_OAK.get());
        BLOCK_ITEMS.put("flower_bed_dirt", () -> ModBlocks.FLOWER_BED_DIRT.get());
        BLOCK_ITEMS.put("flower_bed_grass", () -> ModBlocks.FLOWER_BED_GRASS.get());
        BLOCK_ITEMS.put("flower_bed_podzol", () -> ModBlocks.FLOWER_BED_PODZOL.get());
        BLOCK_ITEMS.put("flower_bed_sand", () -> ModBlocks.FLOWER_BED_SAND.get());
        BLOCK_ITEMS.put("flower_bed_dirt_half", () -> ModBlocks.FLOWER_BED_DIRT_HALF.get());
        BLOCK_ITEMS.put("flower_bed_grass_half", () -> ModBlocks.FLOWER_BED_GRASS_HALF.get());
        BLOCK_ITEMS.put("flower_bed_podzol_half", () -> ModBlocks.FLOWER_BED_PODZOL_HALF.get());
        BLOCK_ITEMS.put("flower_bed_sand_half", () -> ModBlocks.FLOWER_BED_SAND_HALF.get());
        BLOCK_ITEMS.put("water_lily_bowl_blue", () -> ModBlocks.WATER_LILY_BOWL_BLUE.get());
        BLOCK_ITEMS.put("water_lily_bowl_green", () -> ModBlocks.WATER_LILY_BOWL_GREEN.get());
        BLOCK_ITEMS.put("planter_oak", () -> ModBlocks.PLANTER_OAK.get());
        BLOCK_ITEMS.put("planter_spruce", () -> ModBlocks.PLANTER_SPRUCE.get());
        BLOCK_ITEMS.put("planter_birch", () -> ModBlocks.PLANTER_BIRCH.get());
        BLOCK_ITEMS.put("planter_jungle", () -> ModBlocks.PLANTER_JUNGLE.get());
        BLOCK_ITEMS.put("planter_acacia", () -> ModBlocks.PLANTER_ACACIA.get());
        BLOCK_ITEMS.put("planter_dark_oak", () -> ModBlocks.PLANTER_DARK_OAK.get());
        BLOCK_ITEMS.put("planter_mangrove", () -> ModBlocks.PLANTER_MANGROVE.get());
        BLOCK_ITEMS.put("planter_warped", () -> ModBlocks.PLANTER_WARPED.get());
        BLOCK_ITEMS.put("planter_crimson", () -> ModBlocks.PLANTER_CRIMSON.get());
        BLOCK_ITEMS.put("planter_chestnut", () -> ModBlocks.PLANTER_CHESTNUT.get());
        BLOCK_ITEMS.put("planter_paulownia", () -> ModBlocks.PLANTER_PAULOWNIA.get());
        BLOCK_ITEMS.put("planter_ume", () -> ModBlocks.PLANTER_UME.get());
        BLOCK_ITEMS.put("planter_oak_wood", () -> ModBlocks.PLANTER_OAK_WOOD.get());
        BLOCK_ITEMS.put("planter_spruce_wood", () -> ModBlocks.PLANTER_SPRUCE_WOOD.get());
        BLOCK_ITEMS.put("planter_birch_wood", () -> ModBlocks.PLANTER_BIRCH_WOOD.get());
        BLOCK_ITEMS.put("planter_jungle_wood", () -> ModBlocks.PLANTER_JUNGLE_WOOD.get());
        BLOCK_ITEMS.put("planter_acacia_wood", () -> ModBlocks.PLANTER_ACACIA_WOOD.get());
        BLOCK_ITEMS.put("planter_dark_oak_wood", () -> ModBlocks.PLANTER_DARK_OAK_WOOD.get());
        BLOCK_ITEMS.put("planter_mangrove_wood", () -> ModBlocks.PLANTER_MANGROVE_WOOD.get());
        BLOCK_ITEMS.put("planter_warped_wood", () -> ModBlocks.PLANTER_WARPED_WOOD.get());
        BLOCK_ITEMS.put("planter_crimson_wood", () -> ModBlocks.PLANTER_CRIMSON_WOOD.get());
        BLOCK_ITEMS.put("planter_chestnut_wood", () -> ModBlocks.PLANTER_CHESTNUT_WOOD.get());
        BLOCK_ITEMS.put("planter_paulownia_wood", () -> ModBlocks.PLANTER_PAULOWNIA_WOOD.get());
        BLOCK_ITEMS.put("planter_ume_wood", () -> ModBlocks.PLANTER_UME_WOOD.get());

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
