package com.chika.cpm.item;

import com.chika.cpm.init.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CPM_TAB = new CreativeModeTab("cpmtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CORN_POPPY.get());
        }
    };
}
