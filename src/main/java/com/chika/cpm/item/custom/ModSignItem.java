package com.chika.cpm.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class ModSignItem extends SignItem {
    private final int burntime;
    public ModSignItem(Properties pProperties, Block pStandingBlock, Block pWallBlock, int burntime) {
        super(pProperties, pStandingBlock, pWallBlock);
        this.burntime = burntime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burntime;
    }

}
