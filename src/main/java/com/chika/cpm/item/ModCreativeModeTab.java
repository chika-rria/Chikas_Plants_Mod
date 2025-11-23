package com.chika.cpm.item;

import com.chika.cpm.init.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CPM_TAB = new CreativeModeTab("cpmtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CORN_POPPY.get());
        }
    };

    public static final CreativeModeTab CPM_TAB2 = new CreativeModeTab("cpmtab2") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.FLOWER_POT_BLUE.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items); // まず自動で全部追加

            // 自動追加分を削除
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_POT_ORANGE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_POT_LIME.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.WATER_LILY_BOWL.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_DIRT.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_GRASS.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_SAND.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_DIRT_HALF.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_GRASS_HALF.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_SAND_HALF.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_OAK.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_SPRUCE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_BIRCH.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_JUNGLE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_ACACIA.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_DARK_OAK.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_MANGROVE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_WARPED.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_CRIMSON.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_OAK_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_SPRUCE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_BIRCH_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_JUNGLE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_ACACIA_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_DARK_OAK_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_MANGROVE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_WARPED_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_CRIMSON_WOOD.get().asItem()));


            // 好きな位置に挿入
            int flowerIndex = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItem() == ModBlocks.MEDIUM_POT_WHITE.get().asItem()) {
                    flowerIndex = i;
                    break;
                }
            }
            if (flowerIndex >= 0) {
                items.add(flowerIndex + 1, new ItemStack(ModBlocks.FLOWER_POT_ORANGE.get())); // 花の次に置く
                items.add(flowerIndex + 2, new ItemStack(ModBlocks.FLOWER_POT_LIME.get()));
                items.add(flowerIndex + 3, new ItemStack(ModBlocks.WATER_LILY_BOWL.get()));
                items.add(flowerIndex + 4, new ItemStack(ModBlocks.FLOWER_BED_DIRT.get()));
                items.add(flowerIndex + 5, new ItemStack(ModBlocks.FLOWER_BED_GRASS.get()));
                items.add(flowerIndex + 6, new ItemStack(ModBlocks.FLOWER_BED_SAND.get()));
                items.add(flowerIndex + 7, new ItemStack(ModBlocks.FLOWER_BED_DIRT_HALF.get()));
                items.add(flowerIndex + 8, new ItemStack(ModBlocks.FLOWER_BED_GRASS_HALF.get()));
                items.add(flowerIndex + 9, new ItemStack(ModBlocks.FLOWER_BED_SAND_HALF.get()));
                items.add(flowerIndex + 10, new ItemStack(ModBlocks.PLANTER_OAK.get()));
                items.add(flowerIndex + 11, new ItemStack(ModBlocks.PLANTER_SPRUCE.get()));
                items.add(flowerIndex + 12, new ItemStack(ModBlocks.PLANTER_BIRCH.get()));
                items.add(flowerIndex + 13, new ItemStack(ModBlocks.PLANTER_JUNGLE.get()));
                items.add(flowerIndex + 14, new ItemStack(ModBlocks.PLANTER_ACACIA.get()));
                items.add(flowerIndex + 15, new ItemStack(ModBlocks.PLANTER_DARK_OAK.get()));
                items.add(flowerIndex + 16, new ItemStack(ModBlocks.PLANTER_MANGROVE.get()));
                items.add(flowerIndex + 17, new ItemStack(ModBlocks.PLANTER_WARPED.get()));
                items.add(flowerIndex + 18, new ItemStack(ModBlocks.PLANTER_CRIMSON.get()));
                items.add(flowerIndex + 19, new ItemStack(ModBlocks.PLANTER_OAK_WOOD.get()));
                items.add(flowerIndex + 20, new ItemStack(ModBlocks.PLANTER_SPRUCE_WOOD.get()));
                items.add(flowerIndex + 21, new ItemStack(ModBlocks.PLANTER_BIRCH_WOOD.get()));
                items.add(flowerIndex + 22, new ItemStack(ModBlocks.PLANTER_JUNGLE_WOOD.get()));
                items.add(flowerIndex + 23, new ItemStack(ModBlocks.PLANTER_ACACIA_WOOD.get()));
                items.add(flowerIndex + 24, new ItemStack(ModBlocks.PLANTER_DARK_OAK_WOOD.get()));
                items.add(flowerIndex + 25, new ItemStack(ModBlocks.PLANTER_MANGROVE_WOOD.get()));
                items.add(flowerIndex + 26, new ItemStack(ModBlocks.PLANTER_WARPED_WOOD.get()));
                items.add(flowerIndex + 27, new ItemStack(ModBlocks.PLANTER_CRIMSON_WOOD.get()));
            } else {
                // 見つからなければ最後に置く
                items.add(new ItemStack(ModBlocks.FLOWER_POT_ORANGE.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_POT_LIME.get()));
                items.add(new ItemStack(ModBlocks.WATER_LILY_BOWL.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_DIRT.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_GRASS.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_SAND.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_DIRT_HALF.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_GRASS_HALF.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_SAND_HALF.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_OAK.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_SPRUCE.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_BIRCH.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_JUNGLE.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_ACACIA.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_DARK_OAK.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_MANGROVE.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_WARPED.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_CRIMSON.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_OAK_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_SPRUCE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_BIRCH_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_JUNGLE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_ACACIA_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_DARK_OAK_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_MANGROVE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_WARPED_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_CRIMSON_WOOD.get()));

            }
        }
    };
}

