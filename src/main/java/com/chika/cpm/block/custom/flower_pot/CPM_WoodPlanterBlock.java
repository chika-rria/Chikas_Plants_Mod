package com.chika.cpm.block.custom.flower_pot;

import com.chika.cpm.block.blockentity.CPM_WoodPlanterBlockEntity;
import com.chika.cpm.block.custom.DummyBlock;
import com.chika.cpm.block.custom.TriplePlantBlock;
import com.chika.cpm.block.renderer.PlantRenderMap;
import com.chika.cpm.block.state.enumtype.PlantType;
import com.chika.cpm.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class CPM_WoodPlanterBlock extends Block implements EntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty HAS_PLANT = BooleanProperty.create("has_plant");


    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static final IntegerProperty LIGHT_LEVEL = IntegerProperty.create("light_level", 0, 15);

    public CPM_WoodPlanterBlock(Properties properties) {
        super(properties.strength(0.25F));
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIGHT_LEVEL, 0)
                .setValue(HAS_PLANT, false)
                .setValue(FACING, Direction.SOUTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIGHT_LEVEL);
        builder.add(HAS_PLANT);
        builder.add(FACING);
        addAdditionalBlockStates(builder); // サブクラスで拡張
    }

    protected abstract void addAdditionalBlockStates(StateDefinition.Builder<Block, BlockState> builder);


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CPM_WoodPlanterBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof CPM_WoodPlanterBlockEntity planter)) return InteractionResult.PASS;

        // --- 植える場合 ---
        if (held.getItem() instanceof BlockItem && isPlantable(held, state)) {
            PlantType heldType = planter.getPlantTypeForItem(held);
            Block block = Block.byItem(held.getItem());

            // --- StemBlockはスロット0専用 ---
            if (block instanceof StemBlock) {
                if (planter.getItem(0).isEmpty()) {
                    ItemStack toPlant = player.getAbilities().instabuild ? held.copy() : held.split(1);
                    level.setBlock(pos, state.setValue(HAS_PLANT, true), 3);
                    planter.setItem(0, toPlant);
                    planter.growthStages[0] = 0;
                    planter.setChanged();
                    level.sendBlockUpdated(pos, state, state, 3);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.PASS; // 既に植わってる場合
                }
            }

            if (planter.getPlantType() == PlantType.EMPTY) {
                ItemStack toPlant = player.getAbilities().instabuild ? held.copy() : held.split(1);
                level.setBlock(pos, state.setValue(HAS_PLANT, true), 3);
                planter.setItem(0, toPlant);
                planter.growthStages[0] = 0; // 新規植え付け
                planter.setChanged();
                level.sendBlockUpdated(pos, state, state, 3);
                return InteractionResult.SUCCESS;
            }

            if (heldType != planter.getPlantType()) return InteractionResult.PASS;

            for (int i = 0; i < planter.getContainerSize(); i++) {
                if (planter.getItem(i).isEmpty()) {
                    ItemStack toPlant = player.getAbilities().instabuild ? held.copy() : held.split(1);
                    planter.setItem(i, toPlant);
                    planter.growthStages[i] = 0; // 新規植え付けスロットのAGEを0に
                    level.sendBlockUpdated(pos, state, state, 3);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        // --- 回収（逆順） ---
        if (held.isEmpty()) {
            if (!(level instanceof ServerLevel serverLevel)) {
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            for (int i = planter.getContainerSize() - 1; i >= 0; i--) {
                ItemStack plantStack = planter.getItem(i);
                if (!plantStack.isEmpty()) {
                    if (!level.isClientSide) {

                        Block block = Block.byItem(plantStack.getItem());
                        int age = planter.growthStages[i];

                        // LootContext を作る（BLOCK用パラメータセット）
                        LootContext.Builder lootBuilder = new LootContext.Builder(serverLevel)
                                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                                .withParameter(LootContextParams.TOOL, ItemStack.EMPTY)
                                .withOptionalParameter(LootContextParams.BLOCK_ENTITY, planter)
                                .withOptionalParameter(LootContextParams.THIS_ENTITY, player);

                        List<ItemStack> drops = new ArrayList<>();

                        if (block instanceof CropBlock crop) {
                            BlockState dropState = crop.getStateForAge(age);
                            drops.addAll(dropState.getDrops(lootBuilder));
                        } else if (block instanceof SweetBerryBushBlock bush) {
                            BlockState dropState = bush.defaultBlockState().setValue(SweetBerryBushBlock.AGE, age);
                            drops.addAll(dropState.getDrops(lootBuilder));
                            if (age < 2) {
                                // 若い株は本来ドロップなし → 手動で1個追加
                                drops.add(new ItemStack(Items.SWEET_BERRIES, 1));
                            }
                        } else if (block instanceof NetherWartBlock wort) {
                            BlockState dropState = wort.defaultBlockState().setValue(NetherWartBlock.AGE, age);
                            drops.addAll(dropState.getDrops(lootBuilder));
                        } else if (block instanceof StemBlock stem) {
                            ItemStack drop = plantStack.copy();
                            drop.setCount(1);  // 個数を 1 に固定
                            drops.add(drop);

                            // 成熟していたら果実も追加
                            if (age >= StemBlock.MAX_AGE) {
                                Block fruit = stem.getFruit();
                                drops.add(new ItemStack(fruit.asItem()));
                            }
                        } else {
                            ItemStack drop = plantStack.copy();
                            drop.setCount(1);  // 個数を 1 に固定
                            drops.add(drop);
                        }

                        // ドロップをプレイヤーに渡す
                        for (ItemStack drop : drops) {
                            if (!player.addItem(drop)) {
                                level.addFreshEntity(new ItemEntity(level,
                                        pos.getX() + 0.5,
                                        pos.getY() + 0.5,
                                        pos.getZ() + 0.5,
                                        drop));
                            }
                        }

                        // スロットクリア
                        planter.setItem(i, ItemStack.EMPTY);
                        planter.growthStages[i] = 0;
                        planter.setChanged();
                        level.sendBlockUpdated(pos, state, state, 3);

                    }
                    return InteractionResult.SUCCESS;
                }
            }

            // 全部空なら HAS_PLANT 更新
            if (IntStream.range(0, planter.getContainerSize()).allMatch(j -> planter.getItem(j).isEmpty())) {
                planter.clearAll();
                BlockState newState = state.setValue(HAS_PLANT, false);
                level.setBlock(pos, newState, 3);
                level.sendBlockUpdated(pos, state, newState, 3);
            }
        }
        return InteractionResult.PASS;
    }


    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof CPM_WoodPlanterBlockEntity pot) {
            for (int i = 0; i < 3; i++) {
                pot.setItem(i, ItemStack.EMPTY);
                pot.growthStages[i] = 0;
            }
        }
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.getValue(LIGHT_LEVEL);
    }

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
                || block instanceof DummyBlock
                || block instanceof CropBlock
                || block instanceof StemBlock;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) return null;

        if (type == ModBlockEntities.CPM_WOOD_PLANTER_BLOCK_ENTITY.get()) {
            @SuppressWarnings("unchecked")
            BlockEntityTicker<T> ticker = (lvl, pos, st, be) -> CPM_WoodPlanterBlockEntity.tick(lvl, pos, st, (CPM_WoodPlanterBlockEntity) be);
            return ticker;
        }
        return null;
    }


    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);

        BlockEntity be = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (be instanceof CPM_WoodPlanterBlockEntity planterBE) {

            for (int i = 0; i < planterBE.getContainerSize(); i++) {
                ItemStack planted = planterBE.getItem(i);
                if (planted.isEmpty()) continue;

                Block block = Block.byItem(planted.getItem());

                // 安全化：AGE を合法範囲に制限
                int maxAge = 0;
                if (block instanceof CropBlock crop) {
                    maxAge = crop.getMaxAge();
                } else if (block instanceof SweetBerryBushBlock) {
                    maxAge = SweetBerryBushBlock.MAX_AGE;
                } else if (block instanceof NetherWartBlock) {
                    maxAge = NetherWartBlock.MAX_AGE;
                } else if (block instanceof StemBlock) {
                    maxAge = StemBlock.MAX_AGE;
                }

                int safeAge = Math.min(maxAge, Math.max(0, planterBE.growthStages[i]));

                if (block instanceof CropBlock crop) {
                    BlockState dropState = crop.getStateForAge(safeAge);
                    drops.addAll(dropState.getDrops(builder));
                } else if (block instanceof SweetBerryBushBlock bush) {
                    BlockState dropState = bush.defaultBlockState().setValue(SweetBerryBushBlock.AGE, safeAge);
                    drops.addAll(dropState.getDrops(builder));
                } else if (block instanceof NetherWartBlock wort) {
                    BlockState dropState = wort.defaultBlockState().setValue(NetherWartBlock.AGE, safeAge);
                    drops.addAll(dropState.getDrops(builder));
                } else if (block instanceof StemBlock stem) {
                    BlockState dropState = stem.defaultBlockState().setValue(StemBlock.AGE, safeAge);
                    drops.addAll(dropState.getDrops(builder));
                    // 果実追加（成熟時のみ）
                    if (safeAge >= StemBlock.MAX_AGE) {
                        Item fruitBlock = stem.getFruit().defaultBlockState().getBlock().asItem();
                        drops.add(new ItemStack(fruitBlock));
                    }
                } else {
                    // 作物以外は元アイテムを返す
                    drops.add(planted.copy());
                }
            }
        }

        return drops;
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}
