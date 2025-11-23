package com.chika.cpm.world.feature;

import com.chika.cpm.CPMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, CPMod.MOD_ID);

    //沢瀉
    public static final RegistryObject<PlacedFeature> ALISMA_PATCH_PLACED = PLACED_FEATURES.register("alisma_patch_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ALISMA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("ALISMA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(10),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //桔梗
    public static final RegistryObject<PlacedFeature> BALLOON_FLOWER_PLACED = PLACED_FEATURES.register("balloon_flower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BALLOON_FLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("BALLOON_FLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //吾亦紅
    public static final RegistryObject<PlacedFeature> BURNET_BLOODWORT_PLACED = PLACED_FEATURES.register("burnet_bloodwort_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BURNET_BLOODWORT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("BURNET_BLOODWORT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //萩
    public static final RegistryObject<PlacedFeature> BUSH_CLOVER_PLACED = PLACED_FEATURES.register("bush_clover_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BUSH_CLOVER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("BUSH_CLOVER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //ドクダミ
    public static final RegistryObject<PlacedFeature> CHAMELEON_PLANT_PLACED = PLACED_FEATURES.register("chameleon_plant_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHAMELEON_PLANT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CHAMELEON_PLANT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //カミツレ
    public static final RegistryObject<PlacedFeature> CHAMOMILE_PLACED = PLACED_FEATURES.register("chamomile_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHAMOMILE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CHAMOMILE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //蓮華草
    public static final RegistryObject<PlacedFeature> CHINESE_MILK_VETCH_PLACED = PLACED_FEATURES.register("chinese_milk_vetch_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHINESE_MILK_VETCH_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CHINESE_MILK_VETCH_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(200),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //菊
    public static final RegistryObject<PlacedFeature> CHRYSANTHEMUM_PLACED = PLACED_FEATURES.register("chrysanthemum_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHRYSANTHEMUM_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CHRYSANTHEMUM_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(50),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //苧環
    public static final RegistryObject<PlacedFeature> COLUMBINE_PLACED = PLACED_FEATURES.register("columbine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COLUMBINE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("COLUMBINE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //鶏頭
    public static final RegistryObject<PlacedFeature> COOKS_COMB_PLACED = PLACED_FEATURES.register("cooks_comb_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COOKS_COMB_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("COOKS_COMB_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //万両
    public static final RegistryObject<PlacedFeature> CORAL_BUSH_PLACED = PLACED_FEATURES.register("coral_bush_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CORAL_BUSH_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CORAL_BUSH_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //雛芥子
    public static final RegistryObject<PlacedFeature> CORN_POPPY_PLACED = PLACED_FEATURES.register("corn_poppy_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CORN_POPPY_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("CORN_POPPY_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //水仙
    public static final RegistryObject<PlacedFeature> DAFFODIL_PLACED = PLACED_FEATURES.register("daffodil_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DAFFODIL_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("DAFFODIL_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //露草
    public static final RegistryObject<PlacedFeature> DAYFLOWER_PLACED = PLACED_FEATURES.register("dayflower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DAYFLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("DAYFLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //カタクリ
    public static final RegistryObject<PlacedFeature> DOGTOOTH_VIOLET_PLACED = PLACED_FEATURES.register("dogtooth_violet_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DOGTOOTH_VIOLET_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("DOGTOOTH_VIOLET_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //待宵草
    public static final RegistryObject<PlacedFeature> EVENING_PRIMROSE_PLACED = PLACED_FEATURES.register("evening_primrose_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.EVENING_PRIMROSE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("EVENING_PRIMROSE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //松葉菊
    public static final RegistryObject<PlacedFeature> FIG_MARIGOLD_PLACED = PLACED_FEATURES.register("fig_marigold_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FIG_MARIGOLD_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("FIG_MARIGOLD_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //白粉花
    public static final RegistryObject<PlacedFeature> FOUR_O_CLOCK_PLACED = PLACED_FEATURES.register("four_o_clock_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FOUR_O_CLOCK_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("FOUR_O_CLOCK_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //シャガ
    public static final RegistryObject<PlacedFeature>FRINGED_IRIS_PLACED = PLACED_FEATURES.register("fringed_iris_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FRINGED_IRIS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("FRINGED_IRIS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //撫子
    public static final RegistryObject<PlacedFeature>FRINGED_PINK_PLACED = PLACED_FEATURES.register("fringed_pink_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FRINGED_PINK_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("FRINGED_PINK_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //竜胆
    public static final RegistryObject<PlacedFeature>GENTIAN_PLACED = PLACED_FEATURES.register("gentian_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GENTIAN_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("GENTIAN_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //女郎花
    public static final RegistryObject<PlacedFeature>GOLDEN_LACE_PLACED = PLACED_FEATURES.register("golden_lace_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GOLDEN_LACE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("GOLDEN_LACE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //千日紅
    public static final RegistryObject<PlacedFeature>GLOBE_AMARANTH_PLACED = PLACED_FEATURES.register("globe_amaranth_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GLOBE_AMARANTH_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("GLOBE_AMARANTH_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //エノコログサ
    public static final RegistryObject<PlacedFeature>GREEN_BRISTLEGRASS_PLACED = PLACED_FEATURES.register("green_bristlegrass_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GREEN_BRISTLEGRASS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("GREEN_BRISTLEGRASS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //鬼灯
    public static final RegistryObject<PlacedFeature>GROUND_CHERRY_PLACED = PLACED_FEATURES.register("ground_cherry_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.GROUND_CHERRY_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("GROUND_CHERRY_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //仏の座
    public static final RegistryObject<PlacedFeature>HENBIT_PLACED = PLACED_FEATURES.register("henbit_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HENBIT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("HENBIT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //土筆
    public static final RegistryObject<PlacedFeature>HORSETAIL_PLACED = PLACED_FEATURES.register("horsetail_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HORSETAIL_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("HORSETAIL_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //紫蘭
    public static final RegistryObject<PlacedFeature>HYACINTH_ORCHID_PLACED = PLACED_FEATURES.register("hyacinth_orchid_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HYACINTH_ORCHID_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("HYACINTH_ORCHID_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //紫陽花
    public static final RegistryObject<PlacedFeature>HYDRANGEA_PLACED = PLACED_FEATURES.register("hydrangea_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HYDRANGEA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("HYDRANGEA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //福寿草
    public static final RegistryObject<PlacedFeature>ICE_ADONIS_PLACED = PLACED_FEATURES.register("ice_adonis_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ICE_ADONIS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("ICE_ADONIS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //菖蒲
    public static final RegistryObject<PlacedFeature>IRIS_PLACED = PLACED_FEATURES.register("iris_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.IRIS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("IRIS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //水芭蕉
    public static final RegistryObject<PlacedFeature>JAPANESE_SKUNK_CABBAGE_PLACED = PLACED_FEATURES.register("japanese_skunk_cabbage_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JAPANESE_SKUNK_CABBAGE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("JAPANESE_SKUNK_CABBAGE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(20),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //センブリ
    public static final RegistryObject<PlacedFeature>JAPANESE_SWERTIA_PLACED = PLACED_FEATURES.register("japanese_swertia_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JAPANESE_SWERTIA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("JAPANESE_SWERTIA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //捩花
    public static final RegistryObject<PlacedFeature>LADYS_TRESSES_PLACED = PLACED_FEATURES.register("ladys_tresses_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LADYS_TRESSES_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("LADYS_TRESSES_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //石蕗
    public static final RegistryObject<PlacedFeature>LEOPARD_PLANT_PLACED = PLACED_FEATURES.register("leopard_plant_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LEOPARD_PLANT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("LEOPARD_PLANT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //彼岸花
    public static final RegistryObject<PlacedFeature>LYCORIS_RADIATA_PLACED = PLACED_FEATURES.register("lycoris_radiata_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LYCORIS_RADIATA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("LYCORIS_RADIATA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(200),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //立金花
    public static final RegistryObject<PlacedFeature>MARSH_MARIGOLD_PLACED = PLACED_FEATURES.register("marsh_marigold_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MARSH_MARIGOLD_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("MARSH_MARIGOLD_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //薄荷
    public static final RegistryObject<PlacedFeature>MINT_PLACED = PLACED_FEATURES.register("mint_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MINT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("MINT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //トリカブト
    public static final RegistryObject<PlacedFeature>MONKSHOOD_PLACED = PLACED_FEATURES.register("monkshood_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MONKSHOOD_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("MONKSHOOD_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(100),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //蓬
    public static final RegistryObject<PlacedFeature>MUGWORT_PLACED = PLACED_FEATURES.register("mugwort_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MUGWORT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("MUGWORT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //菜の花
    public static final RegistryObject<PlacedFeature>MUSTARD_PLACED = PLACED_FEATURES.register("mustard_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MUSTARD_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("MUSTARD_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(100),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //南天
    public static final RegistryObject<PlacedFeature>NANDINA_PLACED = PLACED_FEATURES.register("nandina_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NANDINA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("NANDINA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //オオバコ
    public static final RegistryObject<PlacedFeature>PLANTAIN_PLACED = PLACED_FEATURES.register("plantain_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PLANTAIN_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("PLANTAIN_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //桜草
    public static final RegistryObject<PlacedFeature>PRIMROSE_PLACED = PLACED_FEATURES.register("primrose_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PRIMROSE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("PRIMROSE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //鳳仙花
    public static final RegistryObject<PlacedFeature>ROSE_BALSAM_PLACED = PLACED_FEATURES.register("rose_balsam_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSE_BALSAM_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("ROSE_BALSAM_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //紅花
    public static final RegistryObject<PlacedFeature>SAFFLOWER_PLACED = PLACED_FEATURES.register("safflower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAFFLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SAFFLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //笹
    public static final RegistryObject<PlacedFeature>SASA_PLACED = PLACED_FEATURES.register("sasa_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SASA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SASA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(10),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //立浪草
    public static final RegistryObject<PlacedFeature>SKULLCAP_PLACED = PLACED_FEATURES.register("skullcap_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SKULLCAP_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SKULLCAP_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //金魚草
    public static final RegistryObject<PlacedFeature>SNAPDRAGON_PLACED = PLACED_FEATURES.register("snapdragon_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SNAPDRAGON_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SNAPDRAGON_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //蛍袋
    public static final RegistryObject<PlacedFeature>SPOTTED_BELLFLOWER_PLACED = PLACED_FEATURES.register("spotted_bellflower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SPOTTED_BELLFLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SPOTTED_BELLFLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //紫苑
    public static final RegistryObject<PlacedFeature>TATARIAN_ASTER_PLACED = PLACED_FEATURES.register("tatarian_aster_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TATARIAN_ASTER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("TATARIAN_ASTER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //藤袴
    public static final RegistryObject<PlacedFeature>THOROUGHWORT_PLACED = PLACED_FEATURES.register("thoroughwort_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.THOROUGHWORT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("THOROUGHWORT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //鬼百合
    public static final RegistryObject<PlacedFeature>TIGER_LILY_PLACED = PLACED_FEATURES.register("tiger_lily_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TIGER_LILY_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("TIGER_LILY_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //オオイヌノフグリ
    public static final RegistryObject<PlacedFeature>VERONICA_PERSICA_PLACED = PLACED_FEATURES.register("veronica_persica_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.VERONICA_PERSICA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("VERONICA_PERSICA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //菫
    public static final RegistryObject<PlacedFeature>VIOLET_PLACED = PLACED_FEATURES.register("violet_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.VIOLET_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("VIOLET_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //さぎ草
    public static final RegistryObject<PlacedFeature>WHITE_EGRET_FLOWER_PLACED = PLACED_FEATURES.register("white_egret_flower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WHITE_EGRET_FLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("WHITE_EGRET_FLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //二輪草
    public static final RegistryObject<PlacedFeature>WIND_FLOWER_PLACED = PLACED_FEATURES.register("wind_flower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WIND_FLOWER_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("WIND_FLOWER_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //節分草
    public static final RegistryObject<PlacedFeature>WINTER_ACONITE_PLACED = PLACED_FEATURES.register("winter_aconite_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WINTER_ACONITE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("WINTER_ACONITE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //勿忘草
    public static final RegistryObject<PlacedFeature>WOODLAND_FORGET_ME_NOT_PLACED = PLACED_FEATURES.register("woodland_forget_me_not_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WOODLAND_FORGET_ME_NOT_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("WOODLAND_FORGET_ME_NOT_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(40),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));

    //DoublePlants
    //秋桜
    public static final RegistryObject<PlacedFeature>COSMOS_PLACED = PLACED_FEATURES.register("cosmos_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COSMOS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("COSMOS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(200),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //酔芙蓉
    public static final RegistryObject<PlacedFeature>COTTON_ROSE_PLACED = PLACED_FEATURES.register("cotton_rose_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.COTTON_ROSE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("COTTON_ROSE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //立葵
    public static final RegistryObject<PlacedFeature>HOLLYHOCK_PLACED = PLACED_FEATURES.register("hollyhock_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.HOLLYHOCK_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("HOLLYHOCK_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //秋明菊
    public static final RegistryObject<PlacedFeature>JAPANESE_ANEMONE_PLACED = PLACED_FEATURES.register("japanese_anemone_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JAPANESE_ANEMONE_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("JAPANESE_ANEMONE_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //芒
    public static final RegistryObject<PlacedFeature>SILVER_GRASS_PLACED = PLACED_FEATURES.register("silver_grass_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_GRASS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SILVER_GRASS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(200),
                            InSquarePlacement.spread(),
                            CountPlacement.of(1),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //背の高い向日葵
    public static final RegistryObject<PlacedFeature>SUNFLOWERS_PLACED = PLACED_FEATURES.register("sunflowers_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SUNFLOWERS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("SUNFLOWERS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(5),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //鉄砲百合
    public static final RegistryObject<PlacedFeature>EASTER_LILY_PLACED = PLACED_FEATURES.register("easter_lily_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.EASTER_LILY_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("EASTER_LILY_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));
    //皇帝ダリア
    public static final RegistryObject<PlacedFeature>TREE_DAHLIA_PLACED = PLACED_FEATURES.register("tree_dahlia_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TREE_DAHLIA_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("TREE_DAHLIA_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(80),
                            InSquarePlacement.spread(),
                            CountPlacement.of(2),
                            PlacementUtils.HEIGHTMAP,
                            BiomeFilter.biome()
                    )));

    //アサザ
    public static final RegistryObject<PlacedFeature>FLOATINGHEART_PLACED = PLACED_FEATURES.register("floatingheart_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FLOATINGHEART_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("FLOATINGHEART_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(6),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                            BiomeFilter.biome()
                    )));
    //水葵
    public static final RegistryObject<PlacedFeature>PICKERELWEED_PLACED = PLACED_FEATURES.register("pickerelweed_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PICKERELWEED_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("PICKERELWEED_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(6),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                            BiomeFilter.biome()
                    )));

    //蓮
    public static final RegistryObject<PlacedFeature>LOTUS_PLACED = PLACED_FEATURES.register("lotus_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LOTUS_PATCH.getHolder()
                    .orElseThrow(() -> new IllegalStateException("LOTUS_PATCH not registered")),
                    List.of(RarityFilter.onAverageOnceEvery(6),
                            InSquarePlacement.spread(),
                            CountPlacement.of(3),
                            PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                            BiomeFilter.biome()
                    )));


    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}