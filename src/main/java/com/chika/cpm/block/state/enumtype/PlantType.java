package com.chika.cpm.block.state.enumtype;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

public enum PlantType implements StringRepresentable {
    CROP("crop"),
    FLOWER("flower"),
    EMPTY("empty");

    private final String name;

    PlantType(String name) { this.name = name; }

    @Override
    @Nonnull
    public String getSerializedName() { return this.name; }

    @Override
    public String toString(){ return this.name; }
}