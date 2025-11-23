package com.chika.cpm.block.blockentity;

import com.chika.cpm.block.custom.DummyBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.renderer.PlantRenderMap;
import com.chika.cpm.block.state.enumtype.PlantType;
import com.chika.cpm.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import java.util.stream.IntStream;

public class CPM_WoodPlanterBlockEntity extends BlockEntity {

    private PlantType type = PlantType.EMPTY;
    private final ItemStack[] items;
    public int[] growthStages = new int[3]; // スロットごとに成長段階

    // StemBlock専用フラグ
    public boolean hasStem = false;


    public CPM_WoodPlanterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CPM_WOOD_PLANTER_BLOCK_ENTITY.get(), pos, state);
        this.items = new ItemStack[3]; // 最大スロット数は3
        IntStream.range(0, items.length).forEach(i -> items[i] = ItemStack.EMPTY);
    }

    public int getContainerSize() {
        if (hasStem) return 1;
        return (type == PlantType.CROP) ? 2 : 3; // 作物は2、花は3
    }

    public ItemStack getItem(int slot) {
        if (slot < 0 || slot >= items.length) return ItemStack.EMPTY;
        return items[slot];
    }

    public void setItem(int slot, @Nonnull ItemStack stack) {
        if (slot < 0 || slot >= items.length) return;

        if (stack.isEmpty()) {
            items[slot] = ItemStack.EMPTY;
            // 全スロット空なら type をリセット
            boolean allEmpty = true;
            for (ItemStack s : items) {
                if (!s.isEmpty()) {
                    allEmpty = false;
                    break;
                }
            }
            if (allEmpty) {
                type = PlantType.EMPTY;
                hasStem = false;

            }
            setChanged();
            return;
        }

        PlantType newType = getPlantTypeForItem(stack);

        if (type == PlantType.EMPTY) {
            type = newType;
        }

        if (newType != type) return; // タイプ違いは拒否

        items[slot] = stack.copy();

        // StemBlock判定
        Block block = Block.byItem(stack.getItem());
        hasStem = block instanceof StemBlock;
        setChanged();
    }


    public PlantType getPlantTypeForItem(ItemStack stack) {
        if (stack.isEmpty()) return PlantType.EMPTY;

        // 他Modの置換もここで拾えるようにする
        Block block = PlantRenderMap.MOD_OVERRIDES
                .getOrDefault(stack.getItem(), () -> Block.byItem(stack.getItem()))
                .get();

        // 作物クラス判定
        if (block instanceof CropBlock
                || block instanceof SweetBerryBushBlock
                || block instanceof NetherWartBlock
                || block instanceof StemBlock
        ) return PlantType.CROP;

        // 花判定
        if (block instanceof BushBlock
                || block instanceof DoublePlantBlock
                || block instanceof TriplePlantBlock
                || block instanceof CactusBlock
                || block instanceof BambooBlock
                || block instanceof DummyBlock
        ) return PlantType.FLOWER;

        return PlantType.EMPTY;
    }

    public PlantType getPlantType() {
        return type;
    }

    public void clearAll() {
        IntStream.range(0, items.length).forEach(i -> items[i] = ItemStack.EMPTY);
        type = PlantType.EMPTY;
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putBoolean("HasStem", this.hasStem);

        for (int i = 0; i < items.length; i++) {
            CompoundTag itemTag = new CompoundTag();
            if (!items[i].isEmpty()) {
                items[i].save(itemTag);
            }
            tag.put("Item" + i, itemTag);
        }

        tag.putString("PlantType", type.name());
        tag.putIntArray("GrowthStages", growthStages);

    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.hasStem = tag.getBoolean("HasStem");


        for (int i = 0; i < items.length; i++) {
            CompoundTag itemTag = tag.getCompound("Item" + i);
            items[i] = itemTag.isEmpty() ? ItemStack.EMPTY : ItemStack.of(itemTag);
        }

        type = PlantType.valueOf(tag.getString("PlantType"));
        if (tag.contains("GrowthStages")) {
            growthStages = tag.getIntArray("GrowthStages");
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CPM_WoodPlanterBlockEntity be) {
        if (level.isClientSide) return;

        for (int i = 0; i < be.getContainerSize(); i++) {
            ItemStack stack = be.getItem(i);
            if (stack.isEmpty()) continue;

            Block block = Block.byItem(stack.getItem());
            int currentAge = be.growthStages[i];
            int maxAge;
            int chance;

            if (block instanceof CropBlock crop) {
                maxAge = crop.getMaxAge();
                chance = 3600;
            } else if (block instanceof SweetBerryBushBlock) {
                maxAge = SweetBerryBushBlock.MAX_AGE; // 3
                chance = 3600;
            } else if (block instanceof NetherWartBlock) {
                maxAge = NetherWartBlock.MAX_AGE; // 3
                chance = 3600;
            } else if (block instanceof StemBlock) {
                maxAge = StemBlock.MAX_AGE; // 7
                chance = 3600;
            } else {
                continue;
            }

            // 安全化：currentAge を合法範囲に補正
            currentAge = Math.min(maxAge, Math.max(0, currentAge));

            if (currentAge < maxAge && level.random.nextInt(chance) == 0) {
                be.growthStages[i] = currentAge + 1;
                be.setChanged();
                level.sendBlockUpdated(pos, state, state, 3);
            }
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
