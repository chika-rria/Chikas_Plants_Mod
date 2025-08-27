package com.chika.cpm.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PLANTABLE_IN_CPM_POT = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "plantable_in_cpm_pot"));
        public static final TagKey<Block> CPM_PLANTS = TagKey.create(
                Registry.BLOCK_REGISTRY,
                new ResourceLocation("cpm", "cpm_plants")
        );
    }
}
