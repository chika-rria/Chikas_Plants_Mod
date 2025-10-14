package com.chika.cpm.world.feature;

import com.chika.cpm.CPMod;
import com.chika.cpm.init.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, CPMod.MOD_ID);

    //沢瀉
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALISMA_PATCH = CONFIGURED_FEATURES.register("alisma_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ALISMA_RHIZOME.get()))))));
    //桔梗
    public static final RegistryObject<ConfiguredFeature<?, ?>> BALLOON_FLOWER_PATCH = CONFIGURED_FEATURES.register("balloon_flower_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BALLOON_FLOWER.get()))))));
    //吾亦紅
    public static final RegistryObject<ConfiguredFeature<?, ?>> BURNET_BLOODWORT_PATCH = CONFIGURED_FEATURES.register("burnet_bloodwort_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            5, 3, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BURNET_BLOODWORT.get()))))));
    //萩
    public static final RegistryObject<ConfiguredFeature<?, ?>> BUSH_CLOVER_PATCH = CONFIGURED_FEATURES.register("bush_clover_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 6, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUSH_CLOVER.get()))))));
    //ドクダミ
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHAMELEON_PLANT_PATCH = CONFIGURED_FEATURES.register("chameleon_plant_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHAMELEON_PLANT.get()))))));
    //カミツレ
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHAMOMILE_PATCH = CONFIGURED_FEATURES.register("chamomile_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 3, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHAMOMILE.get()))))));
    //蓮華草
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHINESE_MILK_VETCH_PATCH = CONFIGURED_FEATURES.register("chinese_milk_vetch_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            40, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CHINESE_MILK_VETCH.get()))))));
    //菊
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHRYSANTHEMUM_PATCH = CONFIGURED_FEATURES.register("chrysanthemum_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(7, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(
                                            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                    .add(ModBlocks.CHRYSANTHEMUM.get().defaultBlockState(), 100)
                                                    .add(ModBlocks.CHRYSANTHEMUM_YELLOW.get().defaultBlockState(), 80)
                                                    .build()
                                            )
                                    )
                            )
                    )));
    //苧環
    public static final RegistryObject<ConfiguredFeature<?, ?>> COLUMBINE_PATCH = CONFIGURED_FEATURES.register("columbine_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.COLUMBINE.get()))))));
    //鶏頭
    public static final RegistryObject<ConfiguredFeature<?, ?>> COOKS_COMB_PATCH = CONFIGURED_FEATURES.register("cooks_comb_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.COOKS_COMB.get()))))));
    //万両
    public static final RegistryObject<ConfiguredFeature<?, ?>> CORAL_BUSH_PATCH = CONFIGURED_FEATURES.register("coral_bush_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CORAL_BUSH.get()))))));
    //雛芥子
    public static final RegistryObject<ConfiguredFeature<?, ?>> CORN_POPPY_PATCH = CONFIGURED_FEATURES.register("corn_poppy_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CORN_POPPY.get()))))));
    //水仙
    public static final RegistryObject<ConfiguredFeature<?, ?>> DAFFODIL_PATCH =
            CONFIGURED_FEATURES.register("daffodil_patch",
                    () -> new ConfiguredFeature<>(Feature.FLOWER,
                            new RandomPatchConfiguration(
                                    7, 5, 2,
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                            .add(ModBlocks.DAFFODIL.get().defaultBlockState(), 100)
                                                            .add(ModBlocks.DAFFODIL_YELLOW.get().defaultBlockState(), 50)
                                                            .build()
                                                    )
                                            )
                                    )
                            )
                    ));
    //露草
    public static final RegistryObject<ConfiguredFeature<?, ?>> DAYFLOWER_PATCH = CONFIGURED_FEATURES.register("dayflower_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DAYFLOWER.get()))))));
    //カタクリ
    public static final RegistryObject<ConfiguredFeature<?, ?>> DOGTOOTH_VIOLET_PATCH = CONFIGURED_FEATURES.register("dogtooth_violet_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 7, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DOGTOOTH_VIOLET.get()))))));
    //待宵草
    public static final RegistryObject<ConfiguredFeature<?, ?>> EVENING_PRIMROSE_PATCH = CONFIGURED_FEATURES.register("evening_primrose_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 6, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.EVENING_PRIMROSE.get()))))));
    //松葉菊
    public static final RegistryObject<ConfiguredFeature<?, ?>> FIG_MARIGOLD_PATCH = CONFIGURED_FEATURES.register("fig_marigold_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FIG_MARIGOLD.get()))))));
    //白粉花
    public static final RegistryObject<ConfiguredFeature<?, ?>> FOUR_O_CLOCK_PATCH = CONFIGURED_FEATURES.register("four_o_clock_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FOUR_O_CLOCK.get()))))));
    //シャガ
    public static final RegistryObject<ConfiguredFeature<?, ?>> FRINGED_IRIS_PATCH = CONFIGURED_FEATURES.register("fringed_iris_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FRINGED_IRIS.get()))))));
    //撫子
    public static final RegistryObject<ConfiguredFeature<?, ?>> FRINGED_PINK_PATCH = CONFIGURED_FEATURES.register("fringed_pink_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FRINGED_PINK.get()))))));
    //竜胆
    public static final RegistryObject<ConfiguredFeature<?, ?>> GENTIAN_PATCH = CONFIGURED_FEATURES.register("gentian_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GENTIAN.get()))))));
    //女郎花
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLDEN_LACE_PATCH = CONFIGURED_FEATURES.register("golden_lace_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GOLDEN_LACE.get()))))));
    //千日紅
    public static final RegistryObject<ConfiguredFeature<?, ?>> GLOBE_AMARANTH_PATCH = CONFIGURED_FEATURES.register("globe_amaranth_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GLOBE_AMARANTH.get()))))));
    //エノコログサ
    public static final RegistryObject<ConfiguredFeature<?, ?>> GREEN_BRISTLEGRASS_PATCH = CONFIGURED_FEATURES.register("green_bristlegrass_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 10, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_BRISTLEGRASS.get()))))));
    //鬼灯
    public static final RegistryObject<ConfiguredFeature<?, ?>> GROUND_CHERRY_PATCH = CONFIGURED_FEATURES.register("ground_cherry_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 5, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GROUND_CHERRY.get()))))));
    //仏の座
    public static final RegistryObject<ConfiguredFeature<?, ?>> HENBIT_PATCH = CONFIGURED_FEATURES.register("henbit_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HENBIT.get()))))));

    //土筆
    public static final RegistryObject<ConfiguredFeature<?, ?>> HORSETAIL_PATCH = CONFIGURED_FEATURES.register("horsetail_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HORSETAIL.get()))))));
    //紫蘭
    public static final RegistryObject<ConfiguredFeature<?, ?>> HYACINTH_ORCHID_PATCH = CONFIGURED_FEATURES.register("hyacinth_orchid_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HYACINTH_ORCHID.get()))))));
    //紫陽花
    public static final RegistryObject<ConfiguredFeature<?, ?>> HYDRANGEA_PATCH =
            CONFIGURED_FEATURES.register("hydrangea_patch",
                    () -> new ConfiguredFeature<>(Feature.FLOWER,
                            new RandomPatchConfiguration(
                                    6, 5, 2,
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                            .add(ModBlocks.HYDRANGEA.get().defaultBlockState(), 100)
                                                            .add(ModBlocks.HYDRANGEA_PINK.get().defaultBlockState(), 50)
                                                            .build()
                                                    )
                                            )
                                    )
                            )
                    ));
    //福寿草
    public static final RegistryObject<ConfiguredFeature<?, ?>> ICE_ADONIS_PATCH = CONFIGURED_FEATURES.register("ice_adonis_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 3, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ICE_ADONIS.get()))))));
    //菖蒲
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRIS_PATCH =
            CONFIGURED_FEATURES.register("iris_patch",
                    () -> new ConfiguredFeature<>(Feature.FLOWER,
                            new RandomPatchConfiguration(
                                    6, 6, 2,
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                            .add(ModBlocks.IRIS.get().defaultBlockState(), 100)
                                                            .add(ModBlocks.IRIS_BLUE.get().defaultBlockState(), 80)
                                                            .build()
                                                    )
                                            )
                                    )
                            )
                    ));
    //捩花
    public static final RegistryObject<ConfiguredFeature<?, ?>> LADYS_TRESSES_PATCH = CONFIGURED_FEATURES.register("ladys_tresses_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 3, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LADYS_TRESSES.get()))))));
    //石蕗
    public static final RegistryObject<ConfiguredFeature<?, ?>> LEOPARD_PLANT_PATCH = CONFIGURED_FEATURES.register("leopard_plant_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LEOPARD_PLANT.get()))))));
    // 彼岸花（赤・ピンク・白が混ざるパッチ）
    public static final RegistryObject<ConfiguredFeature<?, ?>> LYCORIS_RADIATA_PATCH =
            CONFIGURED_FEATURES.register("lycoris_radiata_patch",
                    () -> new ConfiguredFeature<>(Feature.FLOWER,
                            new RandomPatchConfiguration(
                                    100, 16, 4, // tries, xzSpread, ySpread
                                    PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                            new SimpleBlockConfiguration(
                                                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                                                            .add(ModBlocks.LYCORIS_RADIATA.get().defaultBlockState(), 100) // 赤メイン
                                                            .add(ModBlocks.LYCORIS_RADIATA_PINK.get().defaultBlockState(), 5)   // ピンク低確率
                                                            .add(ModBlocks.LYCORIS_RADIATA_WHITE.get().defaultBlockState(), 1)  // 白ごく稀
                                                            .build()
                                                    )
                                            )
                                    )
                            )
                    ));
    //立金花
    public static final RegistryObject<ConfiguredFeature<?, ?>> MARSH_MARIGOLD_PATCH = CONFIGURED_FEATURES.register("marsh_marigold_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MARSH_MARIGOLD.get()))))));
    //薄荷
    public static final RegistryObject<ConfiguredFeature<?, ?>> MINT_PATCH = CONFIGURED_FEATURES.register("mint_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MINT.get()))))));
    //蓬
    public static final RegistryObject<ConfiguredFeature<?, ?>> MUGWORT_PATCH = CONFIGURED_FEATURES.register("mugwort_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUGWORT.get()))))));
    //菜の花
    public static final RegistryObject<ConfiguredFeature<?, ?>> MUSTARD_PATCH = CONFIGURED_FEATURES.register("mustard_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            20, 5, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.MUSTARD.get()))))));
    //南天
    public static final RegistryObject<ConfiguredFeature<?, ?>> NANDINA_PATCH = CONFIGURED_FEATURES.register("nandina_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.NANDINA.get()))))));
    //桜草
    public static final RegistryObject<ConfiguredFeature<?, ?>> PRIMROSE_PATCH = CONFIGURED_FEATURES.register("primrose_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            4, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PRIMROSE.get()))))));
    //鳳仙花
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSE_BALSAM_PATCH = CONFIGURED_FEATURES.register("rose_balsam_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ROSE_BALSAM.get()))))));
    //紅花
    public static final RegistryObject<ConfiguredFeature<?, ?>> SAFFLOWER_PATCH = CONFIGURED_FEATURES.register("safflower_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SAFFLOWER.get()))))));
    //笹
    public static final RegistryObject<ConfiguredFeature<?, ?>> SASA_PATCH = CONFIGURED_FEATURES.register("sasa_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SASA.get()))))));

    //立浪草
    public static final RegistryObject<ConfiguredFeature<?, ?>> SKULLCAP_PATCH = CONFIGURED_FEATURES.register("skullcap_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SKULLCAP.get()))))));
    //金魚草
    public static final RegistryObject<ConfiguredFeature<?, ?>> SNAPDRAGON_PATCH = CONFIGURED_FEATURES.register("snapdragon_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAPDRAGON.get()))))));
    //蛍袋
    public static final RegistryObject<ConfiguredFeature<?, ?>> SPOTTED_BELLFLOWER_PATCH = CONFIGURED_FEATURES.register("spotted_bellflower_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAPDRAGON.get()))))));

    //紫苑
    public static final RegistryObject<ConfiguredFeature<?, ?>> TATARIAN_ASTER_PATCH = CONFIGURED_FEATURES.register("tatarian_aster_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TATARIAN_ASTER.get()))))));

    //藤袴
    public static final RegistryObject<ConfiguredFeature<?, ?>> THOROUGHWORT_PATCH = CONFIGURED_FEATURES.register("thoroughwort_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.THOROUGHWORT.get()))))));

    //鬼百合
    public static final RegistryObject<ConfiguredFeature<?, ?>> TIGER_LILY_PATCH = CONFIGURED_FEATURES.register("tiger_lily_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TIGER_LILY.get()))))));

    //オオイヌノフグリ
    public static final RegistryObject<ConfiguredFeature<?, ?>> VERONICA_PERSICA_PATCH = CONFIGURED_FEATURES.register("veronica_persica_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VERONICA_PERSICA.get()))))));

    //菫
    public static final RegistryObject<ConfiguredFeature<?, ?>> VIOLET_PATCH = CONFIGURED_FEATURES.register("violet_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIOLET.get()))))));

    //二輪草
    public static final RegistryObject<ConfiguredFeature<?, ?>> WIND_FLOWER_PATCH = CONFIGURED_FEATURES.register("wind_flower_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WIND_FLOWER.get()))))));

    //節分草
    public static final RegistryObject<ConfiguredFeature<?, ?>> WINTER_ACONITE_PATCH = CONFIGURED_FEATURES.register("winter_aconite_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WINTER_ACONITE.get()))))));
    //勿忘草
    public static final RegistryObject<ConfiguredFeature<?, ?>> WOODLAND_FORGET_ME_NOT_PATCH = CONFIGURED_FEATURES.register("woodland_fore_get_me_not_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 2,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WOODLAND_FORGET_ME_NOT.get()))))));

    //DoublePlants
    //秋桜
    public static final RegistryObject<ConfiguredFeature<?, ?>> COSMOS_PATCH = CONFIGURED_FEATURES.register("cosmos_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            80, 16, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.COSMOS.get()))))));
    //酔芙蓉
    public static final RegistryObject<ConfiguredFeature<?, ?>> COTTON_ROSE_PATCH = CONFIGURED_FEATURES.register("cotton_rose_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.COTTON_ROSE.get()))))));
    //立葵
    public static final RegistryObject<ConfiguredFeature<?, ?>> HOLLYHOCK_PATCH = CONFIGURED_FEATURES.register("hollyhock_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HOLLYHOCK.get()))))));
    //秋明菊
    public static final RegistryObject<ConfiguredFeature<?, ?>> JAPANESE_ANEMONE_PATCH = CONFIGURED_FEATURES.register("japanese_anemone_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 3,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.JAPANESE_ANEMONE.get()))))));

    //芒
    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_GRASS_PATCH = CONFIGURED_FEATURES.register("silver_grass_patch",
            () -> new ConfiguredFeature<>(ModFeatures.MIXED_SILVER_GRASS.get(), FeatureConfiguration.NONE));

    //背の高い向日葵
    public static final RegistryObject<ConfiguredFeature<?, ?>> SUNFLOWERS_PATCH = CONFIGURED_FEATURES.register("sunflowers_patch",
            () -> new ConfiguredFeature<>(ModFeatures.MIXED_SUNFLOWER.get(), FeatureConfiguration.NONE));

    //鉄砲百合
    public static final RegistryObject<ConfiguredFeature<?, ?>> EASTER_LILY_PATCH = CONFIGURED_FEATURES.register("easter_lily_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 5,
                            PlacementUtils.onlyWhenEmpty(ModFeatures.TRIPLE_PLANT.get(),
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.EASTER_LILY.get()))))));
    //皇帝ダリア
    public static final RegistryObject<ConfiguredFeature<?, ?>> TREE_DAHLIA_PATCH = CONFIGURED_FEATURES.register("tree_dahlia_patch",
            () -> new ConfiguredFeature<>(Feature.FLOWER,
                    new RandomPatchConfiguration(
                            6, 4, 5,
                            PlacementUtils.onlyWhenEmpty(ModFeatures.TRIPLE_PLANT.get(),
                                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TREE_DAHLIA.get()))))));


    //アサザ
    public static final RegistryObject<ConfiguredFeature<?, ?>> FLOATINGHEART_PATCH =
            CONFIGURED_FEATURES.register("floatingheart", () ->
                    new ConfiguredFeature<>(
                            ModFeatures.WATER_SURFACE_PLANT_FEATURE.get(),
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FLOATINGHEART.get()))));
    //水葵
    public static final RegistryObject<ConfiguredFeature<?, ?>> PICKERELWEED_PATCH =
            CONFIGURED_FEATURES.register("pickerelweed", () ->
                    new ConfiguredFeature<>(
                            ModFeatures.WATER_SURFACE_PLANT_FEATURE.get(),
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PICKERELWEED.get()))));
    //蓮
    public static final RegistryObject<ConfiguredFeature<?, ?>> LOTUS_PATCH =
            CONFIGURED_FEATURES.register("lotus", () ->
                    new ConfiguredFeature<>(
                            ModFeatures.WATER_SURFACE_PLANT_FEATURE.get(),
                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LOTUS.get()))));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
