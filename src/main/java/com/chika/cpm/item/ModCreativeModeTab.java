package com.chika.cpm.item;

import com.chika.cpm.init.ModBlocks;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ModCreativeModeTab {
    public static final CreativeModeTab CPM_TAB = new CreativeModeTab("cpmtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CORN_POPPY.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items); // まず自動で全部追加

            // 自動追加分を削除
            items.removeIf(stack -> stack.is(ModBlocks.CAMELLIA_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.CHESTNUT_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FRAGRANT_OLIVE_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.GINKGO_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.LEMON_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.MAPLE_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PAULOWNIA_SAPLING.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.UME_SAPLING.get().asItem()));


            // 好きな位置に挿入
            int flowerIndex = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItem() == ModBlocks.TREE_DAHLIA.get().asItem()) {
                    flowerIndex = i;
                    break;
                }
            }
            if (flowerIndex >= 0) {
                items.add(flowerIndex + 1, new ItemStack(ModBlocks.CAMELLIA_SAPLING.get()));
                items.add(flowerIndex + 2, new ItemStack(ModBlocks.CHESTNUT_SAPLING.get()));
                items.add(flowerIndex + 3, new ItemStack(ModBlocks.FRAGRANT_OLIVE_SAPLING.get()));
                items.add(flowerIndex + 4, new ItemStack(ModBlocks.GINKGO_SAPLING.get()));
                items.add(flowerIndex + 5, new ItemStack(ModBlocks.LEMON_SAPLING.get()));
                items.add(flowerIndex + 6, new ItemStack(ModBlocks.MAPLE_SAPLING.get()));
                items.add(flowerIndex + 7, new ItemStack(ModBlocks.PAULOWNIA_SAPLING.get()));
                items.add(flowerIndex + 8, new ItemStack(ModBlocks.UME_SAPLING.get()));

            } else {
                // 見つからなければ最後に置く
                items.add(new ItemStack(ModBlocks.CAMELLIA_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.CHESTNUT_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.FRAGRANT_OLIVE_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.GINKGO_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.LEMON_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.MAPLE_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.PAULOWNIA_SAPLING.get()));
                items.add(new ItemStack(ModBlocks.UME_SAPLING.get()));
            }
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
            items.removeIf(stack -> stack.is(ModBlocks.LARGE_POT_BLUE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.LARGE_POT_ORANGE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.LARGE_POT_LIME.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.WATER_LILY_BOWL_BLUE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.WATER_LILY_BOWL_GREEN.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_DIRT.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_GRASS.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_PODZOL.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_SAND.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_DIRT_HALF.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_GRASS_HALF.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_PODZOL_HALF.get().asItem()));
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
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_CHESTNUT.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_PAULOWNIA.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_UME.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_OAK_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_SPRUCE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_BIRCH_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_JUNGLE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_ACACIA_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_DARK_OAK_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_MANGROVE_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_WARPED_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_CRIMSON_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_CHESTNUT_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_PAULOWNIA_WOOD.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PLANTER_UME_WOOD.get().asItem()));


            // 好きな位置に挿入
            int flowerIndex = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItem() == ModBlocks.MEDIUM_POT_WHITE.get().asItem()) {
                    flowerIndex = i;
                    break;
                }
            }
            if (flowerIndex >= 0) {
                List<ItemStack> flowerItems = List.of( // 花の次に置く
                        new ItemStack(ModBlocks.LARGE_POT_BLUE.get()),
                        new ItemStack(ModBlocks.LARGE_POT_ORANGE.get()),
                        new ItemStack(ModBlocks.LARGE_POT_LIME.get()),
                        new ItemStack(ModBlocks.WATER_LILY_BOWL_BLUE.get()),
                        new ItemStack(ModBlocks.WATER_LILY_BOWL_GREEN.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_DIRT.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_GRASS.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_PODZOL.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_SAND.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_DIRT_HALF.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_GRASS_HALF.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_PODZOL_HALF.get()),
                        new ItemStack(ModBlocks.FLOWER_BED_SAND_HALF.get()),
                        new ItemStack(ModBlocks.PLANTER_OAK.get()),
                        new ItemStack(ModBlocks.PLANTER_SPRUCE.get()),
                        new ItemStack(ModBlocks.PLANTER_BIRCH.get()),
                        new ItemStack(ModBlocks.PLANTER_JUNGLE.get()),
                        new ItemStack(ModBlocks.PLANTER_ACACIA.get()),
                        new ItemStack(ModBlocks.PLANTER_DARK_OAK.get()),
                        new ItemStack(ModBlocks.PLANTER_MANGROVE.get()),
                        new ItemStack(ModBlocks.PLANTER_WARPED.get()),
                        new ItemStack(ModBlocks.PLANTER_CRIMSON.get()),
                        new ItemStack(ModBlocks.PLANTER_CHESTNUT.get()),
                        new ItemStack(ModBlocks.PLANTER_PAULOWNIA.get()),
                        new ItemStack(ModBlocks.PLANTER_UME.get()),
                        new ItemStack(ModBlocks.PLANTER_OAK_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_SPRUCE_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_BIRCH_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_JUNGLE_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_ACACIA_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_DARK_OAK_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_MANGROVE_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_WARPED_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_CRIMSON_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_CHESTNUT_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_PAULOWNIA_WOOD.get()),
                        new ItemStack(ModBlocks.PLANTER_UME_WOOD.get())
                );

                items.addAll(flowerIndex + 1, flowerItems);

            } else {
                // 見つからなければ最後に置く
                items.add(new ItemStack(ModBlocks.LARGE_POT_BLUE.get()));
                items.add(new ItemStack(ModBlocks.LARGE_POT_ORANGE.get()));
                items.add(new ItemStack(ModBlocks.LARGE_POT_LIME.get()));
                items.add(new ItemStack(ModBlocks.WATER_LILY_BOWL_BLUE.get()));
                items.add(new ItemStack(ModBlocks.WATER_LILY_BOWL_GREEN.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_DIRT.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_GRASS.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_PODZOL.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_SAND.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_DIRT_HALF.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_GRASS_HALF.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_PODZOL_HALF.get()));
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
                items.add(new ItemStack(ModBlocks.PLANTER_CHESTNUT.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_PAULOWNIA.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_UME.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_OAK_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_SPRUCE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_BIRCH_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_JUNGLE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_ACACIA_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_DARK_OAK_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_MANGROVE_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_WARPED_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_CRIMSON_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_CHESTNUT_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_PAULOWNIA_WOOD.get()));
                items.add(new ItemStack(ModBlocks.PLANTER_UME_WOOD.get()));
            }
        }
    };
}

