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

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items); // まず自動で全部追加

            // 自動追加分を削除
            items.removeIf(stack -> stack.is(ModBlocks.FLOATINGHEART.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.PICKERELWEED.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.LOTUS.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_POT_ORANGE.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_POT_LIME.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.WATER_LILY_BOWL.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_DIRT.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_GRASS.get().asItem()));
            items.removeIf(stack -> stack.is(ModBlocks.FLOWER_BED_SAND.get().asItem()));


            // 好きな位置に挿入
            int flowerIndex = -1;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getItem() == ModBlocks.FLOWER_POT_LIGHT_GRAY.get().asItem()) {
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
            } else {
                // 見つからなければ最後に置く
                items.add(new ItemStack(ModBlocks.FLOWER_POT_ORANGE.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_POT_LIME.get()));
                items.add(new ItemStack(ModBlocks.WATER_LILY_BOWL.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_DIRT.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_GRASS.get()));
                items.add(new ItemStack(ModBlocks.FLOWER_BED_SAND.get()));

            }
            items.add(new ItemStack(ModBlocks.FLOATINGHEART.get()));
            items.add(new ItemStack(ModBlocks.PICKERELWEED.get()));
            items.add(new ItemStack(ModBlocks.LOTUS.get()));
        }
    };

  /*  public static final CreativeModeTab CPM_TAB2 = new CreativeModeTab("cpmtab2") {
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(ModItems.RAKE.get());
        }
    };
   */
}

