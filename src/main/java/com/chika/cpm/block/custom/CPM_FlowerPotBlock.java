package com.chika.cpm.block.custom;

import com.chika.cpm.block.blockentity.CPM_FlowerPotBlockEntity;
import com.chika.cpm.block.renderer.PlantRenderMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public abstract class CPM_FlowerPotBlock extends Block implements EntityBlock {

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);

    public CPM_FlowerPotBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LIGHT_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIGHT_LEVEL);
        addAdditionalBlockStates(builder); // サブクラスで拡張
    }

    protected abstract void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder);

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof CPM_FlowerPotBlockEntity pot)) {
            return InteractionResult.PASS;
        }

        ItemStack heldItem = player.getItemInHand(hand);
        ItemStack currentPlant = pot.getItem();

        boolean hasPlant = !currentPlant.isEmpty() && !currentPlant.is(Items.AIR);

        if (hasPlant) {
            if (heldItem.isEmpty()) {
                player.setItemInHand(hand, currentPlant.copy());
                pot.setItem(ItemStack.EMPTY);
                BlockState newState = state.setValue(CPM_FlowerPotBlock.LIGHT_LEVEL, 0);
                level.setBlock(pos, newState, 3);
                pot.setChanged();
                level.sendBlockUpdated(pos, state, newState, 3);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        } else {
            if (!heldItem.isEmpty() && isPlantable(heldItem, state)) {
                // 光源レベル取得
                Block block = Block.byItem(heldItem.getItem());
                int lightLevel = block.defaultBlockState().getLightEmission(level, pos);

                // ブロックステート更新
                BlockState newState = state.setValue(CPM_FlowerPotBlock.LIGHT_LEVEL, lightLevel);
                level.setBlock(pos, newState, 3); // State変更でクライアントにも通知

                // BlockEntity更新
                ItemStack copy = heldItem.copy();
                copy.setCount(1);
                pot.setItem(copy);

                if (!player.isCreative()) {
                    heldItem.shrink(1);
                }

                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }


    // バニラ草花や苗木など植えられるかどうかの判定
    protected boolean isPlantable(ItemStack stack, BlockState state) {
        if (stack.isEmpty()) return false;
        //他Modのアイテムは自作Modのブロッククラスを使用
        Block block = PlantRenderMap.MOD_OVERRIDES
                .getOrDefault(stack.getItem(), () -> Block.byItem(stack.getItem()))
                .get();

        // クラスで対応（予備的な安全弁）
        if (block instanceof WaterlilyBlock) {
            return false; // 水生系は拒否
        }

        // クラスで対応（元のアイテムのブロッククラスまたは置き換えブロックのダミークラスで判定）
        return block instanceof BushBlock
                || block instanceof DoublePlantBlock
                || block instanceof TriplePlantBlock
                || block instanceof CactusBlock
                || block instanceof BambooBlock
                || block instanceof DummyBlock;
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CPM_FlowerPotBlockEntity(pos, state);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof CPM_FlowerPotBlockEntity pot) {
            pot.setItem(ItemStack.EMPTY); // 明示的に初期化
        }
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getValue(LIGHT_LEVEL);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);

        BlockEntity be = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof CPM_FlowerPotBlockEntity flowerPotBE) {
            ItemStack planted = flowerPotBE.getItem();
            if (!planted.isEmpty()) {
                drops.add(planted.copy());
            }
        }

        return drops;
    }
}
