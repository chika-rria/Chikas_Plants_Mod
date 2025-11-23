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
        addOverride("atmospheric", "barrel_cactus", ModBlocks.CP_BARREL_CACTUS);
        addOverride("byg", "aloe_vera", ModBlocks.CP_ALOE_VERA);
        addOverride("byg", "barrel_cactus", ModBlocks.CP_BYG_BARREL_CACTUS);
        addOverride("byg", "flowering_barrel_cactus", ModBlocks.CP_FLOWERING_BARREL_CACTUS);
        addOverride("byg", "hydrangea_hedge", ModBlocks.CP_HYDRANGEA_HEDGE);
        addOverride("environmental", "cattail", ModBlocks.CP_CATTAIL);
        addOverride("environmental", "dwarf_spruce", ModBlocks.CP_DWARF_SPRUCE);
        addOverride("ferdinandsflowers", "bamboo_golden_item", ModBlocks.CP_BAMBOO_GOLDEN);
        addOverride("ferdinandsflowers", "bamboo_black_item", ModBlocks.CP_BAMBOO_BLACK);
        addOverride("ferdinandsflowers", "bamboo_groove_item", ModBlocks.CP_BAMBOO_GROOVE);
        addOverride("naturaldecormod", "acacia_bonzai", ModBlocks.CP_ACACIA_BONZAI);
        addOverride("naturaldecormod", "agave_ndm", ModBlocks.CP_AGAVE_NDM);
        addOverride("naturaldecormod", "birch_bonsai", ModBlocks.CP_BIRCH_BONSAI);
        addOverride("naturaldecormod", "butterfly_flower_bush_ndm", ModBlocks.CP_BUTTERFLY_FLOWER_BUSH_NDM);
        addOverride("naturaldecormod", "dark_oak_bonsai", ModBlocks.CP_DARK_OAK_BONSAI);
        addOverride("naturaldecormod", "frost_flower_ndm", ModBlocks.CP_FROST_FLOWER_NDM);
        addOverride("naturaldecormod", "giant_horse_tail_tall_ndm_base", ModBlocks.CP_GIANT_HORSE_TAIL_TALL);
        addOverride("naturaldecormod", "jungle_bonsai", ModBlocks.CP_JUNGLE_BONSAI);
        addOverride("naturaldecormod", "mangrove_bonsai", ModBlocks.CP_MANGROVE_BONSAI);
        addOverride("naturaldecormod", "oak_bonsai", ModBlocks.CP_OAK_BONSAI);
        addOverride("naturaldecormod", "saguaro_cactus_arm", ModBlocks.CP_SAGUARO_CACTUS_ARM);
        addOverride("naturaldecormod", "sugaro_cactus_hand", ModBlocks.CP_SUGARO_CACTUS_HAND);
        addOverride("naturaldecormod", "saguaro_cactus_segment", ModBlocks.CP_SAGUARO_CACTUS_SEGMENT);
        addOverride("naturaldecormod", "spruce_bonsai", ModBlocks.CP_SPRUCE_BONSAI);
        addOverride("naturaldecormod", "sundew_fixed", ModBlocks.CP_SUNDEW_FIXED);
        addOverride("quark", "chorus_twist", ModBlocks.CP_CHORUS_TWIST);
        addOverride("quark", "chorus_weeds", ModBlocks.CP_CHORUS_WEEDS);

    }
}
