package com.chika.cpm.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        @SuppressWarnings("removal")
        public static final TagKey<Block> PLANTABLE_IN_CPM_POT = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "plantable_in_cpm_pot"));
        @SuppressWarnings("removal")
        public static final TagKey<Block> CPM_PLANTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "cpm_plants"));
        @SuppressWarnings("removal")
        public static final TagKey<Block> LOW_POTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "low_pots"));
        @SuppressWarnings("removal")
        public static final TagKey<Block> HIGH_POTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "high_pots"));
        @SuppressWarnings("removal")
        public static final TagKey<Block> FLOWER_BED = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "flower_bed"));
    }

    public static class Items {
        // レーキでドロップ可能な種タグ
        @SuppressWarnings("removal")
        public static final TagKey<Item> CPM_SEEDS = TagKey.create(
                Registry.ITEM_REGISTRY,
                new ResourceLocation("cpm", "rake_droppable_seeds")
        );
    }
}
