package com.chika.cpm;

import com.chika.cpm.block.renderer.PlantRenderMap;
import com.chika.cpm.entity.ModBlockEntities;
import com.chika.cpm.entity.ModWoodTypes;
import com.chika.cpm.event.ModComposterRecipes;
import com.chika.cpm.init.ModBlocks;
import com.chika.cpm.init.ModItems;
import com.chika.cpm.world.feature.ModConfiguredFeatures;
import com.chika.cpm.world.feature.ModFeatures;
import com.chika.cpm.world.feature.ModPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CPMod.MOD_ID)
public class CPMod {

    public static final String MOD_ID = "cpm";

    public CPMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.registerAll();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        ModBlockEntities.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);



        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings({"ConstantConditions", "removal"})
    private void commonSetup(final FMLCommonSetupEvent event) {
        ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.UME);
            Sheets.addWoodType(ModWoodTypes.PAULOWNIA);
            Sheets.addWoodType(ModWoodTypes.CHESTNUT);

            ModComposterRecipes.register();

        });


    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // 看板関係
            WoodType.register(ModWoodTypes.UME);
            WoodType.register(ModWoodTypes.PAULOWNIA);
            WoodType.register(ModWoodTypes.CHESTNUT);

            BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);


            Minecraft.getInstance().getBlockColors().register(
                    (state, world, pos, tintIndex) ->
                            Minecraft.getInstance().getBlockColors().getColor(Blocks.GRASS_BLOCK.defaultBlockState(), world, pos, tintIndex),
                    ModBlocks.FLOWER_BED_GRASS.get(),
                    ModBlocks.FLOWER_BED_GRASS_HALF.get());

            Minecraft.getInstance().getBlockColors().register(
                    (state, world, pos, tintIndex) ->
                            Minecraft.getInstance().getBlockColors().getColor(Blocks.ATTACHED_PUMPKIN_STEM.defaultBlockState(), world, pos, tintIndex),
                    ModBlocks.CP_DOMMY_STEM.get());

            // アイテムカラー登録
            Minecraft.getInstance().getItemColors().register(
                    (stack, tintIndex) -> {
                        // アイテム表示時は biome 情報が無いので、平均的な緑を返す
                        return Minecraft.getInstance().getBlockColors()
                                .getColor(Blocks.GRASS_BLOCK.defaultBlockState(), null, null, tintIndex);
                    },
                    ModBlocks.FLOWER_BED_GRASS.get(),
                    ModBlocks.FLOWER_BED_GRASS_HALF.get());

            // PlantRenderMap の初期化
            PlantRenderMap.initOverrides();
        }

    }
}
