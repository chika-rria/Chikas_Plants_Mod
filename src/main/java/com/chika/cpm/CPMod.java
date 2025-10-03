package com.chika.cpm;

import com.chika.cpm.block.renderer.PlantRenderMap;
import com.chika.cpm.entity.ModBlockEntities;
import com.chika.cpm.init.ModBlocks;
import com.chika.cpm.init.ModItems;
import com.chika.cpm.world.feature.ModConfiguredFeatures;
import com.chika.cpm.world.feature.ModFeatures;
import com.chika.cpm.world.feature.ModPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
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


        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModItems.registerAll();
        ModBlockEntities.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);



        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings({"ConstantConditions", "removal"})
    // Blocks.FLOWER_POT は必ず存在するので null チェック不要
    private void commonSetup(final FMLCommonSetupEvent event) {
        ModLoadingContext context = ModLoadingContext.get();
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        event.enqueueWork(() -> {

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ALISMA_RHIZOME.getId(), ModBlocks.POTTED_ALISMA_RHIZOME);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BALLOON_FLOWER.getId(), ModBlocks.POTTED_BALLOON_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BURNET_BLOODWORT.getId(), ModBlocks.POTTED_BURNET_BLOODWORT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BUSH_CLOVER.getId(), ModBlocks.POTTED_BUSH_CLOVER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHAMELEON_PLANT.getId(), ModBlocks.POTTED_CHAMELEON_PLANT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHAMOMILE.getId(), ModBlocks.POTTED_CHAMOMILE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHRYSANTHEMUM.getId(), ModBlocks.POTTED_CHRYSANTHEMUM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.COLUMBINE.getId(), ModBlocks.POTTED_COLUMBINE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.COOKS_COMB.getId(), ModBlocks.POTTED_COOKS_COMB);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CORAL_BUSH.getId(), ModBlocks.POTTED_CORAL_BUSH);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CORN_POPPY.getId(), ModBlocks.POTTED_CORN_POPPY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DAFFODIL.getId(), ModBlocks.POTTED_DAFFODIL);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DAFFODIL_YELLOW.getId(), ModBlocks.POTTED_DAFFODIL_YELLOW);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DAYFLOWER.getId(), ModBlocks.POTTED_DAYFLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.DOGTOOTH_VIOLET.getId(), ModBlocks.POTTED_DOGTOOTH_VIOLET);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.EVENING_PRIMROSE.getId(), ModBlocks.POTTED_EVENING_PRIMROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FIG_MARIGOLD.getId(), ModBlocks.POTTED_FIG_MARIGOLD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FOUR_O_CLOCK.getId(), ModBlocks.POTTED_FOUR_O_CLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FRINGED_IRIS.getId(), ModBlocks.POTTED_FRINGED_IRIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.FRINGED_PINK.getId(), ModBlocks.POTTED_FRINGED_PINK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GENTIAN.getId(), ModBlocks.POTTED_GENTIAN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GOLDEN_LACE.getId(), ModBlocks.POTTED_GOLDEN_LACE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GLOBE_AMARANTH.getId(), ModBlocks.POTTED_GLOBE_AMARANTH);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GREEN_BRISTLEGRASS.getId(), ModBlocks.POTTED_GREEN_BRISTLEGRASS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.GROUND_CHERRY.getId(), ModBlocks.POTTED_GROUND_CHERRY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HENBIT.getId(), ModBlocks.POTTED_HENBIT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HYACINTH_ORCHID.getId(), ModBlocks.POTTED_HYACINTH_ORCHID);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HYDRANGEA.getId(), ModBlocks.POTTED_HYDRANGEA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.HYDRANGEA_PINK.getId(), ModBlocks.POTTED_HYDRANGEA_PINK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ICE_ADONIS.getId(), ModBlocks.POTTED_ICE_ADONIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.IRIS.getId(), ModBlocks.POTTED_IRIS);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.IRIS_BLUE.getId(), ModBlocks.POTTED_IRIS_BLUE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LADYS_TRESSES.getId(), ModBlocks.POTTED_LADYS_TRESSES);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LEOPARD_PLANT.getId(), ModBlocks.POTTED_LEOPARD_PLANT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LYCORIS_RADIATA.getId(), ModBlocks.POTTED_LYCORIS_RADIATA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LYCORIS_RADIATA_PINK.getId(), ModBlocks.POTTED_LYCORIS_RADIATA_PINK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LYCORIS_RADIATA_WHITE.getId(), ModBlocks.POTTED_LYCORIS_RADIATA_WHITE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MARSH_MARIGOLD.getId(), ModBlocks.POTTED_MARSH_MARIGOLD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MINT.getId(), ModBlocks.POTTED_MINT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MUGWORT.getId(), ModBlocks.POTTED_MUGWORT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MUSTARD.getId(), ModBlocks.POTTED_MUSTARD);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.NANDINA.getId(), ModBlocks.POTTED_NANDINA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PRIMROSE.getId(), ModBlocks.POTTED_PRIMROSE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ROSE_BALSAM.getId(), ModBlocks.POTTED_ROSE_BALSAM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SAFFLOWER.getId(), ModBlocks.POTTED_SAFFLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SASA.getId(), ModBlocks.POTTED_SASA);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SKULLCAP.getId(), ModBlocks.POTTED_SKULLCAP);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SNAPDRAGON.getId(), ModBlocks.POTTED_SNAPDRAGON);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SPOTTED_BELLFLOWER.getId(), ModBlocks.POTTED_SPOTTED_BELLFLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TATARIAN_ASTER.getId(), ModBlocks.POTTED_TATARIAN_ASTER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.THOROUGHWORT.getId(), ModBlocks.POTTED_THOROUGHWORT);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TIGER_LILY.getId(), ModBlocks.POTTED_TIGER_LILY);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.VIOLET.getId(), ModBlocks.POTTED_VIOLET);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.WIND_FLOWER.getId(), ModBlocks.POTTED_WIND_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.WINTER_ACONITE.getId(), ModBlocks.POTTED_WINTER_ACONITE);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.WOODLAND_FORGET_ME_NOT.getId(), ModBlocks.POTTED_WOODLAND_FORGET_ME_NOT);
            //蓮華草とオオイヌノフグリはなし

        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Minecraft.getInstance().getBlockColors().register(
                    (state, world, pos, tintIndex) ->
                            Minecraft.getInstance().getBlockColors().getColor(Blocks.GRASS_BLOCK.defaultBlockState(), world, pos, tintIndex),
                    ModBlocks.FLOWER_BED_GRASS.get());

            // PlantRenderMap の初期化
            PlantRenderMap.initOverrides();
        }

    }
}
