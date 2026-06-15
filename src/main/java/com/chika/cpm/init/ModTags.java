package com.chika.cpm.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CPM_PLANTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "cpm_plants"));
        public static final TagKey<Block> LOW_POTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "low_pots"));
        public static final TagKey<Block> HIGH_POTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "high_pots"));
        public static final TagKey<Block> FLOWER_BED = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "flower_bed"));
        public static final TagKey<Block> FLOWER_BED_HALF = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "flower_bed_half"));
        public static final TagKey<Block> SCALE_DOWN = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "scale_down"));
        public static final TagKey<Block> OFFSET_UP = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "offset_up"));
        public static final TagKey<Block> HIGH_PLANTER = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "high_planter"));
        public static final TagKey<Block> COMPATIBLE_PLANTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "compatible_plants"));
        public static final TagKey<Block> COMPATIBLE_WATER_PLANTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "compatible_water_plants"));
        public static final TagKey<Block> CHESTNUT_LOGS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "chestnut_logs"));
        public static final TagKey<Block> PAULOWNIA_LOGS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "paulownia_logs"));
        public static final TagKey<Block> UME_LOGS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "ume_logs"));
    }

    public static class Items {
        // レーキでドロップ可能な種タグ
        public static final TagKey<Item> CPM_SEEDS = TagKey.create(
                Registry.ITEM_REGISTRY,
                ResourceLocation.fromNamespaceAndPath("cpm", "rake_droppable_seeds"));
        public static final TagKey<Item> CHESTNUT_LOGS = TagKey.create(
                Registry.ITEM_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "chestnut_logs"));
        public static final TagKey<Item> PAULOWNIA_LOGS = TagKey.create(
                Registry.ITEM_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "paulownia_logs"));
        public static final TagKey<Item> UME_LOGS = TagKey.create(
                Registry.ITEM_REGISTRY,
                 ResourceLocation.fromNamespaceAndPath("cpm", "ume_logs"));
    }
}
