package com.chika.cpm.world.feature;

import com.chika.cpm.CPMod;
import com.chika.cpm.init.ModBlocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, CPMod.MOD_ID);

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> TRIPLE_PLANT =
            FEATURES.register("triple_plant",
                    () -> new TriplePlantFeature(SimpleBlockConfiguration.CODEC));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MIXED_SUNFLOWER =
            FEATURES.register("mixed_sunflower", () ->
                    new MixedPlantPatchFeature(NoneFeatureConfiguration.CODEC,
                            List.of(ModBlocks.TALL_SUNFLOWER.get(),
                                    ModBlocks.TALL_SUNFLOWER_CREAM.get(),
                                    ModBlocks.TALL_SUNFLOWER_ORANGE.get())));

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MIXED_SILVER_GRASS =
            FEATURES.register("mixed_silver_grass", () ->
                    new MixedPlantPatchFeature(NoneFeatureConfiguration.CODEC,
                            List.of(ModBlocks.SILVER_GRASS.get(),
                                    ModBlocks.TALL_SILVER_GRASS.get())));

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> WATER_SURFACE_PLANT_FEATURE =
            FEATURES.register("water_surface_plant", () -> new WaterSurfacePlantFeature(SimpleBlockConfiguration.CODEC));


    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}