package com.chika.cpm.init;

import com.chika.cpm.CPMod;
import com.chika.cpm.block.custom.CPM_CottonRoseBlock;
import com.chika.cpm.block.custom.DummyBlock;
import com.chika.cpm.block.custom.RotateBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.custom.edging.*;
import com.chika.cpm.block.custom.flower_pot.*;
import com.chika.cpm.item.ModCreativeModeTab;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CPMod.MOD_ID);

    public static final RegistryObject<Block> BUNDLE_OF_CHARCOAL = registerBlockWithoutBlockItem("bundle_of_charcoal",
            () -> new RotateBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).noOcclusion()));

    //FlowerPots
    public static final RegistryObject<Block> CPM_VANILLA_POT = registerBlockWithoutBlockItem("cpm_vanilla_pot",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> FLOWER_POT_BLUE = registerBlock("flower_pot_blue",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_GRAY = registerBlock("flower_pot_gray",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_MAGENTA = registerBlock("flower_pot_magenta",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_GREEN = registerBlock("flower_pot_green",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_BROWN = registerBlock("flower_pot_brown",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_WHITE = registerBlock("flower_pot_white",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_YELLOW = registerBlock("flower_pot_yellow",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> RIBBON_POT_PINK = registerBlock("ribbon_pot_pink",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> RIBBON_POT_LIGHT_BLUE = registerBlock("ribbon_pot_light_blue",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> RIBBON_POT_LIME = registerBlock("ribbon_pot_lime",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);

    public static final RegistryObject<Block> FLOWER_POT_GLASS = registerBlock("flower_pot_glass",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> CUP_POT_RED = registerBlock("cup_pot_red",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> CUP_POT_ORANGE = registerBlock("cup_pot_orange",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> CUP_POT_PURPLE = registerBlock("cup_pot_purple",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> CUP_POT_LIGHT_GRAY = registerBlock("cup_pot_light_gray",
            () -> new CupPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);



    public static final RegistryObject<Block> SQUARE_POT_GRAY = registerBlock("square_pot_gray",
            () -> new SquarePotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> SQUARE_POT_RED = registerBlock("square_pot_red",
            () -> new SquarePotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WOODEN_CRATE_PLANTER_OAK = registerBlock("wooden_crate_planter_oak",
            () -> new SquarePotWoodBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WOODEN_CRATE_PLANTER_DARK_OAK = registerBlock("wooden_crate_planter_dark_oak",
            () -> new SquarePotWoodBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WOODEN_CRATE_PLANTER_MAGENTA = registerBlock("wooden_crate_planter_magenta",
            () -> new SquarePotWoodBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WOODEN_CRATE_PLANTER_LIGHT_BLUE = registerBlock("wooden_crate_planter_light_blue",
            () -> new SquarePotWoodBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WOODEN_CRATE_PLANTER_LIME = registerBlock("wooden_crate_planter_lime",
            () -> new SquarePotWoodBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);

    public static final RegistryObject<Block> FLOWER_POT_CYAN = registerBlock("flower_pot_cyan",
            () -> new RectangularPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_LIGHT_BLUE = registerBlock("flower_pot_light_blue",
            () -> new RectangularPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> FLOWER_POT_MOSS_BALL = registerBlock("flower_pot_moss_ball",
            () -> new StandardPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> DEEP_POT_GREEN = registerBlock("deep_pot_green",
            () -> new TallPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> DEEP_POT_PINK = registerBlock("deep_pot_pink",
            () -> new TallPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> DEEP_POT_PURPLE = registerBlock("deep_pot_purple",
            () -> new TallPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> DEEP_POT_YELLOW = registerBlock("deep_pot_yellow",
            () -> new TallPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WATERING_CAN_PLANTER_IRON = registerBlock("watering_can_planter_iron",
            () -> new WateringCanPlanterBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WATERING_CAN_PLANTER_COPPER = registerBlock("watering_can_planter_copper",
            () -> new WateringCanPlanterBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> WATERING_CAN_PLANTER_WEATHERED_COPPER = registerBlock("watering_can_planter_weathered_copper",
            () -> new WateringCanPlanterBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);

    public static final RegistryObject<Block> FLOWER_POT_ORANGE = registerBlockWithoutBlockItem("flower_pot_orange",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_POT_LIME = registerBlockWithoutBlockItem("flower_pot_lime",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> MEDIUM_POT_GREEN = registerBlock("medium_pot_green",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_LIGHT_GRAY = registerBlock("medium_pot_light_gray",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_MAGENTA = registerBlock("medium_pot_magenta",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_WHITE = registerBlock("medium_pot_white",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);


    public static final RegistryObject<Block> WATER_LILY_BOWL = registerBlockWithoutBlockItem("water_lily_bowl",
            () -> new WaterLilyBowlBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_DIRT = registerBlockWithoutBlockItem("flower_bed_dirt",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_GRASS = registerBlockWithoutBlockItem("flower_bed_grass",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_SAND = registerBlockWithoutBlockItem("flower_bed_sand",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_DIRT_HALF = registerBlockWithoutBlockItem("flower_bed_dirt_half",
            () -> new FlowerBedHalfBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_GRASS_HALF = registerBlockWithoutBlockItem("flower_bed_grass_half",
            () -> new FlowerBedHalfBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_SAND_HALF = registerBlockWithoutBlockItem("flower_bed_sand_half",
            () -> new FlowerBedHalfBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));

    public static final RegistryObject<Block> LOW_EDGING_BRICK = registerBlock("low_edging_brick",
            () -> new LowEdgingBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_BRICK = registerBlock("low_edging_corner_brick",
            () -> new LowEdgingCornerBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_NETHER_BRICK = registerBlock("low_edging_nether_brick",
            () -> new LowEdgingBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_NETHER_BRICK = registerBlock("low_edging_corner_nether_brick",
            () -> new LowEdgingCornerBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_STONE_BRICK = registerBlock("low_edging_stone_brick",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_STONE_BRICK = registerBlock("low_edging_corner_stone_brick",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_DEEPSLATE_BRICK = registerBlock("low_edging_deepslate_brick",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_DEEPSLATE_BRICK = registerBlock("low_edging_corner_deepslate_brick",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_BLACKSTONE_BRICK = registerBlock("low_edging_blackstone_brick",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_BLACKSTONE_BRICK = registerBlock("low_edging_corner_blackstone_brick",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_MUD_BRICK = registerBlock("low_edging_mud_brick",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_MUD_BRICK = registerBlock("low_edging_corner_mud_brick",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_OAK = registerBlock("low_edging_oak",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_OAK = registerBlock("low_edging_corner_oak",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_DARK_OAK = registerBlock("low_edging_dark_oak",
            () -> new LowEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> LOW_EDGING_CORNER_DARK_OAK = registerBlock("low_edging_corner_dark_oak",
            () -> new LowEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);

    public static final RegistryObject<Block> HIGH_EDGING_BRICK = registerBlock("high_edging_brick",
            () -> new HighEdgingBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_BRICK = registerBlock("high_edging_corner_brick",
            () -> new HighEdgingCornerBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_NETHER_BRICK = registerBlock("high_edging_nether_brick",
            () -> new HighEdgingBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_NETHER_BRICK = registerBlock("high_edging_corner_nether_brick",
            () -> new HighEdgingCornerBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_STONE_BRICK = registerBlock("high_edging_stone_brick",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_STONE_BRICK = registerBlock("high_edging_corner_stone_brick",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_DEEPSLATE_BRICK = registerBlock("high_edging_deepslate_brick",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_DEEPSLATE_BRICK = registerBlock("high_edging_corner_deepslate_brick",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_BLACKSTONE_BRICK = registerBlock("high_edging_blackstone_brick",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_BLACKSTONE_BRICK = registerBlock("high_edging_corner_blackstone_brick",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_MUD_BRICK = registerBlock("high_edging_mud_brick",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_MUD_BRICK = registerBlock("high_edging_corner_mud_brick",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_OAK = registerBlock("high_edging_oak",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_OAK = registerBlock("high_edging_corner_oak",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_DARK_OAK = registerBlock("high_edging_dark_oak",
            () -> new HighEdgingWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> HIGH_EDGING_CORNER_DARK_OAK = registerBlock("high_edging_corner_dark_oak",
            () -> new HighEdgingCornerWideBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), ModCreativeModeTab.CPM_TAB2);


    public static final RegistryObject<Block> PLANTER_OAK = registerBlockWithoutBlockItem("planter_oak",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_SPRUCE = registerBlockWithoutBlockItem("planter_spruce",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_BIRCH = registerBlockWithoutBlockItem("planter_birch",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_JUNGLE = registerBlockWithoutBlockItem("planter_jungle",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_ACACIA = registerBlockWithoutBlockItem("planter_acacia",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_DARK_OAK = registerBlockWithoutBlockItem("planter_dark_oak",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_MANGROVE = registerBlockWithoutBlockItem("planter_mangrove",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_WARPED = registerBlockWithoutBlockItem("planter_warped",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_CRIMSON = registerBlockWithoutBlockItem("planter_crimson",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_OAK_WOOD = registerBlockWithoutBlockItem("planter_oak_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_SPRUCE_WOOD = registerBlockWithoutBlockItem("planter_spruce_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_BIRCH_WOOD = registerBlockWithoutBlockItem("planter_birch_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_JUNGLE_WOOD = registerBlockWithoutBlockItem("planter_jungle_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_ACACIA_WOOD = registerBlockWithoutBlockItem("planter_acacia_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_DARK_OAK_WOOD = registerBlockWithoutBlockItem("planter_dark_oak_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_MANGROVE_WOOD = registerBlockWithoutBlockItem("planter_mangrove_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_WARPED_WOOD = registerBlockWithoutBlockItem("planter_warped_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_CRIMSON_WOOD = registerBlockWithoutBlockItem("planter_crimson_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));


    //Plants
    public static final RegistryObject<Block> ALISMA_RHIZOME = registerBlock("alisma_rhizome",
            () -> new FlowerBlock(() -> MobEffects.FIRE_RESISTANCE, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> BALLOON_FLOWER = registerBlock("balloon_flower",
            () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> BURNET_BLOODWORT = registerBlock("burnet_bloodwort",
            () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> BUSH_CLOVER = registerBlock("bush_clover",
            () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHAMELEON_PLANT = registerBlock("chameleon_plant",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHAMOMILE = registerBlock("chamomile",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHINESE_MILK_VETCH = registerBlock("chinese_milk_vetch",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHRYSANTHEMUM = registerBlock("chrysanthemum",
            () -> new FlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHRYSANTHEMUM_YELLOW = registerBlock("chrysanthemum_yellow",
            () -> new FlowerBlock(() -> MobEffects.DAMAGE_RESISTANCE, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> COLUMBINE = registerBlock("columbine",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> COOKS_COMB = registerBlock("cooks_comb",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CORAL_BUSH = registerBlock("coral_bush",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CORN_POPPY = registerBlock("corn_poppy",
            () -> new FlowerBlock(() -> MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> DAFFODIL = registerBlock("daffodil",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> DAFFODIL_YELLOW = registerBlock("daffodil_yellow",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> DAYFLOWER = registerBlock("dayflower",
            () -> new FlowerBlock(() -> MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> DOGTOOTH_VIOLET = registerBlock("dogtooth_violet",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> EVENING_PRIMROSE = registerBlock("evening_primrose",
            () -> new FlowerBlock(() -> MobEffects.GLOWING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion().lightLevel((pLightEmission) -> 5)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FIG_MARIGOLD = registerBlock("fig_marigold",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FOUR_O_CLOCK = registerBlock("four_o_clock",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FRINGED_IRIS = registerBlock("fringed_iris",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FRINGED_PINK = registerBlock("fringed_pink",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GENTIAN = registerBlock("gentian",
            () -> new FlowerBlock(() -> MobEffects.DAMAGE_BOOST, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GOLDEN_LACE = registerBlock("golden_lace",
            () -> new FlowerBlock(() -> MobEffects.DAMAGE_BOOST, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GLOBE_AMARANTH = registerBlock("globe_amaranth",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GREEN_BRISTLEGRASS = registerBlock("green_bristlegrass",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GROUND_CHERRY = registerBlock("ground_cherry",
            () -> new FlowerBlock(() -> MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion().lightLevel((pLightEmission) -> 5)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HORSETAIL = registerBlock("horsetail",
            () -> new FlowerBlock(() -> MobEffects.WATER_BREATHING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HYACINTH_ORCHID = registerBlock("hyacinth_orchid",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HENBIT = registerBlock("henbit",
            () -> new FlowerBlock(() -> MobEffects.WATER_BREATHING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HYDRANGEA = registerBlock("hydrangea",
            () -> new FlowerBlock(() -> MobEffects.WATER_BREATHING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HYDRANGEA_PINK = registerBlock("hydrangea_pink",
            () -> new FlowerBlock(() -> MobEffects.WATER_BREATHING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> ICE_ADONIS = registerBlock("ice_adonis",
            () -> new FlowerBlock(() -> MobEffects.INVISIBILITY, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> IRIS = registerBlock("iris",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> IRIS_BLUE = registerBlock("iris_blue",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> JAPANESE_SKUNK_CABBAGE = registerBlock("japanese_skunk_cabbage",
            () -> new FlowerBlock(() -> MobEffects.WATER_BREATHING, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> JAPANESE_SWERTIA = registerBlock("japanese_swertia",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LADYS_TRESSES = registerBlock("ladys_tresses",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LEOPARD_PLANT = registerBlock("leopard_plant",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LYCORIS_RADIATA = registerBlock("lycoris_radiata",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LYCORIS_RADIATA_PINK = registerBlock("lycoris_radiata_pink",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LYCORIS_RADIATA_WHITE = registerBlock("lycoris_radiata_white",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MARSH_MARIGOLD = registerBlock("marsh_marigold",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MINT = registerBlock("mint",
            () -> new FlowerBlock(() -> MobEffects.FIRE_RESISTANCE, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MONKSHOOD = registerBlock("monkshood",
            () -> new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MUGWORT = registerBlock("mugwort",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MUSTARD = registerBlock("mustard",
            () -> new FlowerBlock(() -> MobEffects.SATURATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> NANDINA = registerBlock("nandina",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> PLANTAIN = registerBlock("plantain",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> PRIMROSE = registerBlock("primrose",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> ROSE_BALSAM = registerBlock("rose_balsam",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SAFFLOWER = registerBlock("safflower",
            () -> new FlowerBlock(() -> MobEffects.FIRE_RESISTANCE, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SASA = registerBlock("sasa",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SKULLCAP = registerBlock("skullcap",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SNAPDRAGON = registerBlock("snapdragon",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SPOTTED_BELLFLOWER = registerBlock("spotted_bellflower",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TATARIAN_ASTER = registerBlock("tatarian_aster",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> THOROUGHWORT = registerBlock("thoroughwort",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TIGER_LILY = registerBlock("tiger_lily",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> VERONICA_PERSICA = registerBlock("veronica_persica",
            () -> new FlowerBlock(() -> MobEffects.HEAL, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> VIOLET = registerBlock("violet",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> WHITE_EGRET_FLOWER = registerBlock("white_egret_flower",
            () -> new FlowerBlock(() -> MobEffects.SATURATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> WIND_FLOWER = registerBlock("wind_flower",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> WINTER_ACONITE = registerBlock("winter_aconite",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> WOODLAND_FORGET_ME_NOT = registerBlock("woodland_forget_me_not",
            () -> new FlowerBlock(() -> MobEffects.REGENERATION, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), ModCreativeModeTab.CPM_TAB);

    //Double_Plant
    public static final RegistryObject<Block> COSMOS = registerBlock("cosmos",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> COTTON_ROSE = registerBlock("cotton_rose",
            () -> new CPM_CottonRoseBlock(BlockBehaviour.Properties.copy(Blocks.LILAC).randomTicks()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> HOLLYHOCK = registerBlock("hollyhock",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> JAPANESE_ANEMONE = registerBlock("japanese_anemone",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> SILVER_GRASS = registerBlock("silver_grass",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);

    //TriplePlantBlock
    public static final RegistryObject<Block> TALL_SILVER_GRASS = registerBlock("tall_silver_grass",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> EASTER_LILY = registerBlock("easter_lily",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TALL_SUNFLOWER = registerBlock("tall_sunflower",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TALL_SUNFLOWER_CREAM = registerBlock("tall_sunflower_cream",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TALL_SUNFLOWER_ORANGE = registerBlock("tall_sunflower_orange",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> TREE_DAHLIA = registerBlock("tree_dahlia",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);



    //睡蓮の葉系植物
    public static final RegistryObject<Block> FLOATINGHEART = BLOCKS.register("floatingheart",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> PICKERELWEED = BLOCKS.register("pickerelweed",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> LOTUS = BLOCKS.register("lotus",
            () -> new WaterlilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));


    //Mod Vanilla Plants
    public static final RegistryObject<Block> CP_CACTUS = registerBlockWithoutBlockItem("cp_cactus",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_AZALEA = registerBlockWithoutBlockItem("cp_azalea",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_FLOWERING_AZALEA = registerBlockWithoutBlockItem("cp_flowering_azalea",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BAMBOO = registerBlockWithoutBlockItem("cp_bamboo",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_WARPED_ROOTS = registerBlockWithoutBlockItem("cp_warped_roots",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_CRIMSON_ROOTS = registerBlockWithoutBlockItem("cp_crimson_roots",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_DOMMY_STEM = registerBlockWithoutBlockItem("cp_dummy_stem",
            () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));


    //連携用ダミーBlock
    public static final RegistryObject<Block> CP_BARREL_CACTUS = registerBlockWithoutBlockItem("cp_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> CP_ALOE_VERA = registerBlockWithoutBlockItem("cp_aloe_vera",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_FLOWERING_BARREL_CACTUS = registerBlockWithoutBlockItem("cp_flowering_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BYG_BARREL_CACTUS = registerBlockWithoutBlockItem("cp_byg_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_HYDRANGEA_HEDGE = registerBlockWithoutBlockItem("cp_hydrangea_hedge",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> CP_CATTAIL = registerBlockWithoutBlockItem("cp_cattail",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_DWARF_SPRUCE = registerBlockWithoutBlockItem("cp_dwarf_spruce",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> CP_BAMBOO_GOLDEN = registerBlockWithoutBlockItem("cp_bamboo_golden",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BAMBOO_BLACK = registerBlockWithoutBlockItem("cp_bamboo_black",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BAMBOO_GROOVE = registerBlockWithoutBlockItem("cp_bamboo_groove",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> CP_ACACIA_BONZAI = registerBlockWithoutBlockItem("cp_acacia_bonzai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_AGAVE_NDM = registerBlockWithoutBlockItem("cp_agave_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BIRCH_BONSAI = registerBlockWithoutBlockItem("cp_birch_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_BUTTERFLY_FLOWER_BUSH_NDM = registerBlockWithoutBlockItem("cp_butterfly_flower_bush_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_DARK_OAK_BONSAI = registerBlockWithoutBlockItem("cp_dark_oak_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_FROST_FLOWER_NDM = registerBlockWithoutBlockItem("cp_frost_flower_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_GIANT_HORSE_TAIL_TALL = registerBlockWithoutBlockItem("cp_giant_horse_tail_tall",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_JUNGLE_BONSAI = registerBlockWithoutBlockItem("cp_jungle_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_MANGROVE_BONSAI = registerBlockWithoutBlockItem("cp_mangrove_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_OAK_BONSAI = registerBlockWithoutBlockItem("cp_oak_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_SAGUARO_CACTUS_ARM = registerBlockWithoutBlockItem("cp_saguaro_cactus_arm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_SUGARO_CACTUS_HAND = registerBlockWithoutBlockItem("cp_sugaro_cactus_hand",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_SAGUARO_CACTUS_SEGMENT = registerBlockWithoutBlockItem("cp_saguaro_cactus_segment",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_SPRUCE_BONSAI = registerBlockWithoutBlockItem("cp_spruce_bonsai",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_SUNDEW_FIXED = registerBlockWithoutBlockItem("cp_sundew_fixed",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_CHORUS_TWIST = registerBlockWithoutBlockItem("cp_chorus_twist",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> CP_CHORUS_WEEDS = registerBlockWithoutBlockItem("cp_chorus_weeds",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
