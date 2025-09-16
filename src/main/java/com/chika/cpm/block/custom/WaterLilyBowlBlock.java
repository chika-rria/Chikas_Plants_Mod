package com.chika.cpm.block.custom;

import com.chika.cpm.block.blockentity.CPM_FlowerPotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WaterLilyBowlBlock extends CPM_FlowerPotBlock {

    public static final BooleanProperty HAS_WATER = BooleanProperty.create("has_water");

    public WaterLilyBowlBlock(Properties properties) {
        super(properties);
        // デフォルト状態を設定。水なしにする
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_WATER, false));
    }


    @Override
    protected void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_WATER);
    }

    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.getItem() == Items.WATER_BUCKET && !state.getValue(HAS_WATER)) {
            // 水を入れる
            if (!level.isClientSide) {
                level.setBlock(pos, state.setValue(HAS_WATER, true), 3);
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, new ItemStack(Items.BUCKET));
            }
            return InteractionResult.SUCCESS;
        }

        if (heldItem.getItem() == Items.BUCKET && state.getValue(HAS_WATER)) {
            // 水を汲む
            if (!level.isClientSide) {
                collectWater(level, pos, player);
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, new ItemStack(Items.WATER_BUCKET));
            }
            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    public void collectWater(Level level, BlockPos pos, Player player) {
        CPM_FlowerPotBlockEntity pot = (CPM_FlowerPotBlockEntity) level.getBlockEntity(pos);
        if (pot == null) return;

        ItemStack plantStack = pot.getItem();
        if (!plantStack.isEmpty()) {
            ItemStack drop = plantStack.copy();
            drop.setCount(1); // 葉1枚
            if (!player.getInventory().add(drop)) {
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), drop));
            }
        }

        // 水を取り除く
        level.setBlock(pos, pot.getBlockState().setValue(HAS_WATER, false), 3);
    }


    @Override
    public boolean isPlantable(ItemStack stack, BlockState state) {
        if (stack.isEmpty()) return false;
        Block block = Block.byItem(stack.getItem());


        // HAS_WATER が false のときは植えられない
        if (!state.getValue(HAS_WATER)) return false;

        // 水が入っている場合のみ睡蓮を植えられる
        if (block instanceof WaterlilyBlock) {
            return true;
        }

        // それ以外は植えられない
        return false;
    }
}
