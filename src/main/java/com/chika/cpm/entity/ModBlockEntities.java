package com.chika.cpm.entity;

import com.chika.cpm.CPMod;
import com.chika.cpm.block.blockentity.CPM_FlowerPotBlockEntity;
import com.chika.cpm.init.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CPMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CPM_FlowerPotBlockEntity>> CPM_FLOWER_POT_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("cpm_flower_pot_block_entity",
                    () -> BlockEntityType.Builder.of(
                            CPM_FlowerPotBlockEntity::new,
                            ModBlocks.FLOWER_POT_BLUE.get(),
                            ModBlocks.FLOWER_POT_GREEN.get(),
                            ModBlocks.FLOWER_POT_BROWN.get(),
                            ModBlocks.FLOWER_POT_WHITE.get(),
                            ModBlocks.FLOWER_POT_YELLOW.get(),
                            ModBlocks.FLOWER_POT_GRAY.get(),
                            ModBlocks.FLOWER_POT_RED.get(),
                            ModBlocks.FLOWER_POT_CYAN.get(),
                            ModBlocks.FLOWER_POT_LIGHT_BLUE.get(),
                            ModBlocks.FLOWER_POT_GLASS.get(),
                            ModBlocks.FLOWER_POT_MOSS_BALL.get()

                    ).build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

