package com.chika.cpm.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends BlockItem {
    private final int burntime;
    public FuelItem(Block block, int burntime, Properties pProperties) {
        super(block, pProperties);
        this.burntime = burntime;

    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burntime;
    }
}
