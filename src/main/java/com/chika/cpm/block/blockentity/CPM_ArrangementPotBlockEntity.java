package com.chika.cpm.block.blockentity;

import com.chika.cpm.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class CPM_ArrangementPotBlockEntity extends BlockEntity {

    private final ItemStack[] plants = new ItemStack[3];

    public CPM_ArrangementPotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CPM_ARRANGEMENT_POT_BLOCK_ENTITY.get(), pos, state);
        for (int i = 0; i < plants.length; i++) {
            plants[i] = ItemStack.EMPTY;
        }
    }

    public ItemStack getPlant(int slot) {
        if (slot < 0 || slot >= plants.length) return ItemStack.EMPTY;
        return plants[slot];
    }

    public void setPlant(int slot, ItemStack stack) {
        if (slot < 0 || slot >= plants.length) return;
        plants[slot] = stack;
        setChanged(); // ブロック更新
    }

    public int getSlots() {
        return plants.length;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        for (int i = 0; i < plants.length; i++) {
            if (tag.contains("plant" + i)) {
                plants[i] = ItemStack.of(tag.getCompound("plant" + i));
            } else {
                plants[i] = ItemStack.EMPTY;
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        for (int i = 0; i < plants.length; i++) {
            tag.put("plant" + i, plants[i].save(new CompoundTag()));
        }
    }


    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

}
