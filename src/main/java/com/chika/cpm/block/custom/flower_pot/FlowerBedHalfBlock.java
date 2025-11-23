package com.chika.cpm.block.custom.flower_pot;

import com.chika.cpm.block.blockentity.CPM_ArrangementPotBlockEntity;
import com.chika.cpm.block.custom.DummyBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.renderer.PlantRenderMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class FlowerBedHalfBlock extends Block implements EntityBlock {

    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);

    public FlowerBedHalfBlock(Properties properties) {
        super(properties.strength(0.25F));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIGHT_LEVEL, 0));

    }

    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {
    }


    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIGHT_LEVEL);
        addAdditionalBlockStates(builder); // サブクラスで拡張
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof CPM_ArrangementPotBlockEntity pot)) return InteractionResult.PASS;

        if (held.getItem() instanceof BlockItem && isPlantable(held, state)) {
            // 空いているスロットを探す
            for (int i = 0; i < pot.getSlots(); i++) {
                if (pot.getPlant(i).isEmpty()) {
                    ItemStack toPlant;
                    if (!player.getAbilities().instabuild) {
                        // サバイバル：手持ちを1個減らして鉢に入れる
                        toPlant = held.split(1);
                    } else {
                        // クリエイティブ：手持ちは減らさずコピーだけ
                        toPlant = held.copy();
                    }
                    pot.setPlant(i, toPlant);
                    return InteractionResult.SUCCESS;
                }
            }
        }
        if (held.isEmpty()) {
            // 手が空なら単品鉢モード
            for (int i = pot.getSlots() - 1; i >= 0; i--) {
                ItemStack plantStack = pot.getPlant(i);
                if (!plantStack.isEmpty()) { // 最後の1個を残す
                    if (!level.isClientSide) {
                        if (!player.addItem(plantStack.copy())) player.drop(plantStack.copy(), false);
                        pot.setPlant(i, ItemStack.EMPTY);
                        pot.setChanged();
                        level.sendBlockUpdated(pos, state, state, 3);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.PASS;
    }

    // バニラ草花や苗木など植えられるかどうかの判定
    protected boolean isPlantable(ItemStack stack, BlockState state) {
        if (stack.isEmpty()) return false;
        Block block = PlantRenderMap.MOD_OVERRIDES
                .getOrDefault(stack.getItem(), () -> Block.byItem(stack.getItem()))
                .get();

        // 非対応を弾く
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
        return new CPM_ArrangementPotBlockEntity(pos, state);
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getValue(LIGHT_LEVEL);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);

        BlockEntity be = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof CPM_ArrangementPotBlockEntity flowerPotBE) {
            for (int i = 0; i < flowerPotBE.getSlots(); i++) {
                ItemStack planted = flowerPotBE.getPlant(i);
                if (!planted.isEmpty()) {
                    drops.add(planted.copy());
                }
            }
        }
        return drops;
    }
}
