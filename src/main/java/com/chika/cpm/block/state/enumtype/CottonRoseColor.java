package com.chika.cpm.block.state.enumtype;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

public enum CottonRoseColor implements StringRepresentable {
    DAY("day"),
    SUNSET("sunset"),
    NIGHT("night");

    private final String name;

    CottonRoseColor(String name) { this.name = name; }

    @Override
    @Nonnull
    public String getSerializedName() { return this.name; }

    @Override
    public String toString(){ return this.name; }
}