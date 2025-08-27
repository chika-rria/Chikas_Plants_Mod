package com.chika.cpm.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.*;

public class FlowerTickManager {
    private static final Map<Level, List<BlockPos>> flowers = new HashMap<>();

    public static void registerFlower(Level world, BlockPos pos) {
        flowers.computeIfAbsent(world, k -> new ArrayList<>()).add(pos);
    }

    public static List<BlockPos> getFlowers(Level world) {
        return flowers.getOrDefault(world, Collections.emptyList());
    }

    public static void cleanup(Level world, List<BlockPos> activePositions) {
        flowers.put(world, new ArrayList<>(activePositions));
    }
}

