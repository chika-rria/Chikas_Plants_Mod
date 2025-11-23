package com.chika.cpm.block.blockentity;

import com.chika.cpm.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;


public class CPM_FlowerPotBlockEntity extends BlockEntity {

    private ItemStack item;

    public CPM_FlowerPotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CPM_FLOWER_POT_BLOCK_ENTITY.get(), pos, state);
        this.item = ItemStack.EMPTY; // ← これがないとnullになってたりする
    }

    public void setItem(ItemStack stack) {
        this.item = stack;
        setChanged();
        if (!level.isClientSide()) {
            // サーバー側なら同期用の更新マーク
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            level.getChunkSource().getLightEngine().checkBlock(worldPosition);
        }
    }

    public ItemStack getItem() {
        return item;
    }

    @Override
    @SuppressWarnings("removal")
    public void load(CompoundTag tag) {
        super.load(tag);

        if (tag.contains("Plant")) {
            String id = tag.getString("Plant");
            if (!id.equals("minecraft:empty")) {
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
                if (item != null) {
                    this.item = new ItemStack(item);
                } else {
                    this.item = ItemStack.EMPTY;
                }
            } else {
                this.item = ItemStack.EMPTY;
            }
        } else {
            this.item = ItemStack.EMPTY;
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (!item.isEmpty() && item.getItem() != Items.AIR) {
            tag.putString("Plant",ForgeRegistries.ITEMS.getKey(item.getItem()).toString());

        } else {
            tag.putString("Plant", "minecraft:empty");
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
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

}
