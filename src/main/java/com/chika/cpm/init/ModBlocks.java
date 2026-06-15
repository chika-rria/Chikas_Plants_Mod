package com.chika.cpm.init;

import com.chika.cpm.CPMod;
import com.chika.cpm.block.custom.*;
import com.chika.cpm.block.custom.edging.*;
import com.chika.cpm.block.custom.flower_pot.*;
import com.chika.cpm.entity.ModStandingSignBlock;
import com.chika.cpm.entity.ModWallSignBlock;
import com.chika.cpm.entity.ModWoodTypes;
import com.chika.cpm.item.ModCreativeModeTab;
import com.chika.cpm.world.feature.tree.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CPMod.MOD_ID);

    public static final RegistryObject<Block> BUNDLE_OF_CHARCOAL = registerBlockWithoutBlockItem("bundle_of_charcoal",
            () -> new RotateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

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
    public static final RegistryObject<Block> MEDIUM_POT_BLUE = registerBlock("medium_pot_blue",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_GREEN = registerBlock("medium_pot_green",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_LIGHT_GRAY = registerBlock("medium_pot_light_gray",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_MAGENTA = registerBlock("medium_pot_magenta",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);
    public static final RegistryObject<Block> MEDIUM_POT_WHITE = registerBlock("medium_pot_white",
            () -> new MediumPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)), ModCreativeModeTab.CPM_TAB2);


    public static final RegistryObject<Block> LARGE_POT_BLUE = registerBlockWithoutBlockItem("large_pot_blue",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> LARGE_POT_ORANGE = registerBlockWithoutBlockItem("large_pot_orange",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> LARGE_POT_LIME = registerBlockWithoutBlockItem("large_pot_lime",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> LARGE_POT_HERRINGBONE_OAK = registerBlockWithoutBlockItem("large_pot_herringbone_oak",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> LARGE_POT_HERRINGBONE_DARK_OAK = registerBlockWithoutBlockItem("large_pot_herringbone_dark_oak",
            () -> new ArrangementPotBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));



    public static final RegistryObject<Block> WATER_LILY_BOWL_BLUE = registerBlockWithoutBlockItem("water_lily_bowl_blue",
            () -> new WaterLilyBowlBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> WATER_LILY_BOWL_GREEN = registerBlockWithoutBlockItem("water_lily_bowl_green",
            () -> new WaterLilyBowlBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));

    public static final RegistryObject<Block> FLOWER_BED_DIRT = registerBlockWithoutBlockItem("flower_bed_dirt",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_GRASS = registerBlockWithoutBlockItem("flower_bed_grass",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_PODZOL = registerBlockWithoutBlockItem("flower_bed_podzol",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_SAND = registerBlockWithoutBlockItem("flower_bed_sand",
            () -> new FlowerBedBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_DIRT_HALF = registerBlockWithoutBlockItem("flower_bed_dirt_half",
            () -> new FlowerBedHalfBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_GRASS_HALF = registerBlockWithoutBlockItem("flower_bed_grass_half",
            () -> new FlowerBedHalfBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> FLOWER_BED_PODZOL_HALF = registerBlockWithoutBlockItem("flower_bed_podzol_half",
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

    public static final RegistryObject<Block> CRATE = registerBlock("crate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()), ModCreativeModeTab.CPM_TAB2);



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

    public static final RegistryObject<Block> PLANTER_CHESTNUT = registerBlockWithoutBlockItem("planter_chestnut",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_PAULOWNIA = registerBlockWithoutBlockItem("planter_paulownia",
            () -> new WoodPlanterTallBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_UME = registerBlockWithoutBlockItem("planter_ume",
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

    public static final RegistryObject<Block> PLANTER_CHESTNUT_WOOD = registerBlockWithoutBlockItem("planter_chestnut_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_PAULOWNIA_WOOD = registerBlockWithoutBlockItem("planter_paulownia_wood",
            () -> new WoodPlanterLowBlock(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().lightLevel(state -> 0)));
    public static final RegistryObject<Block> PLANTER_UME_WOOD = registerBlockWithoutBlockItem("planter_ume_wood",
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
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), ModCreativeModeTab.CPM_TAB);

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
            () -> new ModWaterLilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> PICKERELWEED = BLOCKS.register("pickerelweed",
            () -> new ModWaterLilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));
    public static final RegistryObject<Block> LOTUS = BLOCKS.register("lotus",
            () -> new ModWaterLilyBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD)));

    //Hedge
    public static final RegistryObject<Block> UKOGI_HEDGE = registerBlock("ukogi_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FRAGRANT_OLIVE_HEDGE = registerBlock("fragrant_olive_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CAMELLIA_HEDGE = registerBlock("camellia_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> JAPANESE_PHOTINIA_HEDGE = registerBlock("japanese_photinia_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> JAPANESE_SPINDLE_HEDGE = registerBlock("japanese_spindle_hedge",
            () -> new HedgeBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.CPM_TAB);


    //Trees
    public static final RegistryObject<Block> CAMELLIA_LEAVES = registerBlock("camellia_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> CHESTNUT_LEAVES = registerBlock("chestnut_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> FRAGRANT_OLIVE_LEAVES = registerBlock("fragrant_olive_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> GINKGO_LEAVES = registerBlock("ginkgo_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> LEMON_LEAVES = registerBlock("lemon_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> PAULOWNIA_LEAVES = registerBlock("paulownia_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);
    public static final RegistryObject<Block> UME_LEAVES = registerBlock("ume_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.2F).noOcclusion()), ModCreativeModeTab.CPM_TAB);


    //Sapling
    public static final RegistryObject<Block> CAMELLIA_SAPLING = registerBlockWithoutBlockItem("camellia_sapling",
            () -> new SaplingBlock(new CamelliaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CHESTNUT_SAPLING = registerBlockWithoutBlockItem("chestnut_sapling",
            () -> new SaplingBlock(new ChestnutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> FRAGRANT_OLIVE_SAPLING = registerBlockWithoutBlockItem("fragrant_olive_sapling",
            () -> new SaplingBlock(new FragrantOliveTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GINKGO_SAPLING = registerBlockWithoutBlockItem("ginkgo_sapling",
            () -> new SaplingBlock(new GinkgoTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> LEMON_SAPLING = registerBlockWithoutBlockItem("lemon_sapling",
            () -> new SaplingBlock(new LemonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlockWithoutBlockItem("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> PAULOWNIA_SAPLING = registerBlockWithoutBlockItem("paulownia_sapling",
            () -> new SaplingBlock(new PaulowniaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> UME_SAPLING = registerBlockWithoutBlockItem("ume_sapling",
            () -> new SaplingBlock(new UmeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> TEA_TREE_CROP = BLOCKS.register("tea_tree_crop",
            () -> new ModTeaTreeBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    //Log and Wood
    public static final RegistryObject<Block> UME_LOG = registerBlockWithoutBlockItem("ume_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> UME_WOOD = registerBlockWithoutBlockItem("ume_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_UME_LOG = registerBlockWithoutBlockItem("stripped_ume_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_UME_WOOD = registerBlockWithoutBlockItem("stripped_ume_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PAULOWNIA_LOG = registerBlockWithoutBlockItem("paulownia_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PAULOWNIA_WOOD = registerBlockWithoutBlockItem("paulownia_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PAULOWNIA_LOG = registerBlockWithoutBlockItem("stripped_paulownia_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PAULOWNIA_WOOD = registerBlockWithoutBlockItem("stripped_paulownia_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CHESTNUT_LOG = registerBlockWithoutBlockItem("chestnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CHESTNUT_WOOD = registerBlockWithoutBlockItem("chestnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CHESTNUT_LOG = registerBlockWithoutBlockItem("stripped_chestnut_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CHESTNUT_WOOD = registerBlockWithoutBlockItem("stripped_chestnut_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    //Building Blocks
    public static final RegistryObject<Block> UME_PLANKS = registerBlockWithoutBlockItem("ume_planks",
            () -> new ModFlammablePlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> UME_STAIRS = registerBlockWithoutBlockItem("ume_stairs",
            () -> new StairBlock(() -> ModBlocks.UME_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> UME_SLAB = registerBlockWithoutBlockItem("ume_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> UME_FENCE = registerBlockWithoutBlockItem("ume_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> UME_FENCE_GATE = registerBlockWithoutBlockItem("ume_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryObject<Block> UME_BUTTON = registerBlockWithoutBlockItem("ume_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> UME_PRESSURE_PLATE = registerBlockWithoutBlockItem("ume_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> UME_DOOR = registerBlockWithoutBlockItem("ume_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> UME_TRAPDOOR = registerBlockWithoutBlockItem("ume_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> UME_WALL_SIGN = registerBlockWithoutBlockItem("ume_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.UME));
    public static final RegistryObject<Block> UME_SIGN = registerBlockWithoutBlockItem("ume_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.UME));
    public static final RegistryObject<Block> PAULOWNIA_PLANKS = registerBlockWithoutBlockItem("paulownia_planks",
            () -> new ModFlammablePlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> PAULOWNIA_STAIRS = registerBlockWithoutBlockItem("paulownia_stairs",
            () -> new StairBlock(() -> ModBlocks.PAULOWNIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> PAULOWNIA_SLAB = registerBlockWithoutBlockItem("paulownia_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> PAULOWNIA_FENCE = registerBlockWithoutBlockItem("paulownia_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> PAULOWNIA_FENCE_GATE = registerBlockWithoutBlockItem("paulownia_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryObject<Block> PAULOWNIA_BUTTON = registerBlockWithoutBlockItem("paulownia_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> PAULOWNIA_PRESSURE_PLATE = registerBlockWithoutBlockItem("paulownia_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> PAULOWNIA_DOOR = registerBlockWithoutBlockItem("paulownia_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> PAULOWNIA_TRAPDOOR = registerBlockWithoutBlockItem("paulownia_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> PAULOWNIA_WALL_SIGN = registerBlockWithoutBlockItem("paulownia_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PAULOWNIA));
    public static final RegistryObject<Block> PAULOWNIA_SIGN = registerBlockWithoutBlockItem("paulownia_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PAULOWNIA));
    public static final RegistryObject<Block> CHESTNUT_PLANKS = registerBlockWithoutBlockItem("chestnut_planks",
            () -> new ModFlammablePlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CHESTNUT_STAIRS = registerBlockWithoutBlockItem("chestnut_stairs",
            () -> new StairBlock(() -> ModBlocks.CHESTNUT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> CHESTNUT_SLAB = registerBlockWithoutBlockItem("chestnut_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> CHESTNUT_FENCE = registerBlockWithoutBlockItem("chestnut_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> CHESTNUT_FENCE_GATE = registerBlockWithoutBlockItem("chestnut_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
    public static final RegistryObject<Block> CHESTNUT_BUTTON = registerBlockWithoutBlockItem("chestnut_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> CHESTNUT_PRESSURE_PLATE = registerBlockWithoutBlockItem("chestnut_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> CHESTNUT_DOOR = registerBlockWithoutBlockItem("chestnut_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> CHESTNUT_TRAPDOOR = registerBlockWithoutBlockItem("chestnut_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F).noOcclusion()));
    public static final RegistryObject<Block> CHESTNUT_WALL_SIGN = registerBlockWithoutBlockItem("chestnut_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHESTNUT));
    public static final RegistryObject<Block> CHESTNUT_SIGN = registerBlockWithoutBlockItem("chestnut_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHESTNUT));


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
    public static final RegistryObject<Block> COMPAT_BARREL_CACTUS = registerBlockWithoutBlockItem("compat_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> COMPAT_ALOE_VERA = registerBlockWithoutBlockItem("compat_aloe_vera",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_FLOWERING_BARREL_CACTUS = registerBlockWithoutBlockItem("compat_flowering_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_BYG_BARREL_CACTUS = registerBlockWithoutBlockItem("compat_byg_barrel_cactus",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_HYDRANGEA_HEDGE = registerBlockWithoutBlockItem("compat_hydrangea_hedge",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> COMPAT_CATTAIL = registerBlockWithoutBlockItem("compat_cattail",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_DWARF_SPRUCE = registerBlockWithoutBlockItem("compat_dwarf_spruce",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> COMPAT_BAMBOO_GOLDEN = registerBlockWithoutBlockItem("compat_bamboo_golden",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_BAMBOO_BLACK = registerBlockWithoutBlockItem("compat_bamboo_black",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_BAMBOO_GROOVE = registerBlockWithoutBlockItem("compat_bamboo_groove",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> COMPAT_AGAVE_NDM = registerBlockWithoutBlockItem("compat_agave_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_BUTTERFLY_FLOWER_BUSH_NDM = registerBlockWithoutBlockItem("compat_butterfly_flower_bush_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_FROST_FLOWER_NDM = registerBlockWithoutBlockItem("compat_frost_flower_ndm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_GIANT_HORSE_TAIL_TALL = registerBlockWithoutBlockItem("compat_giant_horse_tail_tall",
            () -> new TriplePlantBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_SAGUARO_CACTUS_ARM = registerBlockWithoutBlockItem("compat_saguaro_cactus_arm",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_SUGARO_CACTUS_HAND = registerBlockWithoutBlockItem("compat_sugaro_cactus_hand",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_SAGUARO_CACTUS_SEGMENT = registerBlockWithoutBlockItem("compat_saguaro_cactus_segment",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_SUNDEW_FIXED = registerBlockWithoutBlockItem("compat_sundew_fixed",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_CHORUS_TWIST = registerBlockWithoutBlockItem("compat_chorus_twist",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));
    public static final RegistryObject<Block> COMPAT_CHORUS_WEEDS = registerBlockWithoutBlockItem("compat_chorus_weeds",
            () -> new DummyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

    public static final RegistryObject<Block> COMPAT_JAPANESE_TIMBER_BAMBOO = registerBlockWithoutBlockItem("compat_japanese_timber_bamboo",
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
