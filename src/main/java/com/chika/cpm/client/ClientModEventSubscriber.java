package com.chika.cpm.client;

import com.chika.cpm.block.renderer.CPM_ArrangementPotBlockEntityRenderer;
import com.chika.cpm.block.renderer.CPM_FlowerPotBlockEntityRenderer;
import com.chika.cpm.block.renderer.CPM_WoodPlanterBlockEntityRenderer;
import com.chika.cpm.entity.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.CPM_FLOWER_POT_BLOCK_ENTITY.get(),
                CPM_FlowerPotBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CPM_ARRANGEMENT_POT_BLOCK_ENTITY.get(),
                CPM_ArrangementPotBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CPM_WOOD_PLANTER_BLOCK_ENTITY.get(),
                CPM_WoodPlanterBlockEntityRenderer::new);
    }


}
