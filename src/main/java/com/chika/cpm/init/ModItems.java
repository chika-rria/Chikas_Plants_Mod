package com.chika.cpm.init;

import com.chika.cpm.CPMod;
import com.chika.cpm.item.ModCreativeModeTab;
import com.chika.cpm.item.custom.FuelItem;
import com.chika.cpm.item.custom.GlowBoneMealItem;
import com.chika.cpm.item.custom.HorseDungBucketItem;
import com.chika.cpm.item.custom.WoodenBucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CPMod.MOD_ID);


    public static final RegistryObject<Item> GLOW_BONE_MEAL = ITEMS.register("glow_bone_meal",
            () -> new GlowBoneMealItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> BUNDLE_OF_CHARCOAL_ITEM = ITEMS.register("bundle_of_charcoal_item",
            () -> new FuelItem(ModBlocks.BUNDLE_OF_CHARCOAL.get(), 16000, new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> WOODEN_BUCKET = ITEMS.register("wooden_bucket",
            () -> new WoodenBucketItem(new Item.Properties().tab(ModCreativeModeTab.CPM_TAB)));
    public static final RegistryObject<Item> HORSE_DUNG_WOODEN_BUCKET = ITEMS.register("horse_dung_wooden_bucket",
            () -> new HorseDungBucketItem(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.CPM_TAB)));

    

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
