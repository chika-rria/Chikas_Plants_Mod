package com.chika.cpm.block.renderer;

import com.chika.cpm.init.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class PlantRenderMap {

    private static final Map<Item, Block> POTTED_OVERRIDES = new HashMap<>(Map.ofEntries(
            Map.entry(Items.AZALEA, ModBlocks.CP_AZALEA.get()),
            Map.entry(Items.FLOWERING_AZALEA, ModBlocks.CP_FLOWERING_AZALEA.get()),
            Map.entry(Items.BAMBOO, ModBlocks.CP_BAMBOO.get()),
            Map.entry(Items.CACTUS, ModBlocks.CP_CACTUS.get()),
            Map.entry(Items.CRIMSON_ROOTS, ModBlocks.CP_CRIMSON_ROOTS.get()),
            Map.entry(Items.WARPED_ROOTS, ModBlocks.CP_WARPED_ROOTS.get())
    ));

    public static BlockState getBlockStateFor(ItemStack stack) {
        Item item = stack.getItem();
        Block block = POTTED_OVERRIDES.getOrDefault(item, Block.byItem(item));
        return block.defaultBlockState();
    }

    // 他Mod対応などで後から Map を追加するメソッドも作れる
    public static void addOverride(Item item, Block block) {
        POTTED_OVERRIDES.put(item, block);
    }
}
