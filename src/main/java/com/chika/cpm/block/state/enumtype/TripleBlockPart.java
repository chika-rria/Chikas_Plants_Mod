package com.chika.cpm.block.state.enumtype;

import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

public enum TripleBlockPart implements StringRepresentable {
    ROOT("root"),
    MIDDLE("middle"),
    TOP("top");

    private final String name;

    TripleBlockPart(String name) { this.name = name; }

    @Override
    @Nonnull
    public String getSerializedName() { return this.name; }

    @Override
    public String toString(){ return this.name; }
}