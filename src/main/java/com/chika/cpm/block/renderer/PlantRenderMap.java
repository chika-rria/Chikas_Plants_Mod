package com.chika.cpm.block.renderer;

import com.chika.cpm.init.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class PlantRenderMap {

    // バニラ専用 Map（固定）
    private static final Map<Item, Block> VANILLA_OVERRIDES = Map.ofEntries(
            Map.entry(Items.AZALEA, ModBlocks.CP_AZALEA.get()),
            Map.entry(Items.FLOWERING_AZALEA, ModBlocks.CP_FLOWERING_AZALEA.get()),
            Map.entry(Items.BAMBOO, ModBlocks.CP_BAMBOO.get()),
            Map.entry(Items.CACTUS, ModBlocks.CP_CACTUS.get()),
            Map.entry(Items.CRIMSON_ROOTS, ModBlocks.CP_CRIMSON_ROOTS.get()),
            Map.entry(Items.WARPED_ROOTS, ModBlocks.CP_WARPED_ROOTS.get())
    );

    // 他Mod対応 Map（Supplier 型で遅延ロード可能）
    public static final Map<Item, Supplier<Block>> MOD_OVERRIDES = new HashMap<>();

    @SuppressWarnings("removal")
    public static void addOverride(String modid, String itemName, Supplier<Block> blockSupplier) {
        if (ModList.get().isLoaded(modid)) {
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(modid, itemName));
            if (item != null) {
                MOD_OVERRIDES.put(item, blockSupplier);
            }
        }
    }

    public static BlockState getBlockStateFor(ItemStack stack) {
        Item item = stack.getItem();

        // まずバニラ用 Map を確認
        if (VANILLA_OVERRIDES.containsKey(item)) {
            return VANILLA_OVERRIDES.get(item).defaultBlockState();
        }

        // 次に他Mod用 Map を確認
        Supplier<Block> supplier = MOD_OVERRIDES.get(item);
        if (supplier != null) {
            return supplier.get().defaultBlockState();
        }

        // デフォルト（Item から Block を取得）
        return Block.byItem(item).defaultBlockState();
    }

    public static void initOverrides() {

        //他Mod
        addOverride("atmospheric", "barrel_cactus", ModBlocks.COMPAT_BARREL_CACTUS);
        addOverride("byg", "aloe_vera", ModBlocks.COMPAT_ALOE_VERA);
        addOverride("byg", "barrel_cactus", ModBlocks.COMPAT_BYG_BARREL_CACTUS);
        addOverride("byg", "flowering_barrel_cactus", ModBlocks.COMPAT_FLOWERING_BARREL_CACTUS);
        addOverride("byg", "hydrangea_hedge", ModBlocks.COMPAT_HYDRANGEA_HEDGE);
        addOverride("environmental", "cattail", ModBlocks.COMPAT_CATTAIL);
        addOverride("environmental", "dwarf_spruce", ModBlocks.COMPAT_DWARF_SPRUCE);
        addOverride("ferdinandsflowers", "bamboo_golden_item", ModBlocks.COMPAT_BAMBOO_GOLDEN);
        addOverride("ferdinandsflowers", "bamboo_black_item", ModBlocks.COMPAT_BAMBOO_BLACK);
        addOverride("ferdinandsflowers", "bamboo_groove_item", ModBlocks.COMPAT_BAMBOO_GROOVE);
        addOverride("naturaldecormod", "agave_ndm", ModBlocks.COMPAT_AGAVE_NDM);
        addOverride("naturaldecormod", "butterfly_flower_bush_ndm", ModBlocks.COMPAT_BUTTERFLY_FLOWER_BUSH_NDM);
        addOverride("naturaldecormod", "frost_flower_ndm", ModBlocks.COMPAT_FROST_FLOWER_NDM);
        addOverride("naturaldecormod", "giant_horse_tail_tall_ndm_base", ModBlocks.COMPAT_GIANT_HORSE_TAIL_TALL);
        addOverride("naturaldecormod", "saguaro_cactus_arm", ModBlocks.COMPAT_SAGUARO_CACTUS_ARM);
        addOverride("naturaldecormod", "sugaro_cactus_hand", ModBlocks.COMPAT_SUGARO_CACTUS_HAND);
        addOverride("naturaldecormod", "saguaro_cactus_segment", ModBlocks.COMPAT_SAGUARO_CACTUS_SEGMENT);
        addOverride("naturaldecormod", "sundew_fixed", ModBlocks.COMPAT_SUNDEW_FIXED);
        addOverride("quark", "chorus_twist", ModBlocks.COMPAT_CHORUS_TWIST);
        addOverride("quark", "chorus_weeds", ModBlocks.COMPAT_CHORUS_WEEDS);
        addOverride("urushi", "japanese_timber_bamboo", ModBlocks.COMPAT_JAPANESE_TIMBER_BAMBOO);

    }
}
