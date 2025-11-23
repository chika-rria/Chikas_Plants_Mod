package com.chika.cpm.block.custom;

import com.chika.cpm.block.state.enumtype.TripleBlockPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import javax.annotation.Nullable;

public class TriplePlantBlock extends BushBlock {
    public static final EnumProperty<TripleBlockPart> PART = EnumProperty.create("part", TripleBlockPart.class);

    public TriplePlantBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TripleBlockPart.ROOT));
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        TripleBlockPart part = state.getValue(PART);

        // 横方向なら通常の処理
        if (direction.getAxis() != Direction.Axis.Y) {
            return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        }

        if (part == TripleBlockPart.ROOT && direction == Direction.UP) {
            // ROOT の上が MIDDLE じゃなければ消滅
            if (!(neighborState.is(this) && neighborState.getValue(PART) == TripleBlockPart.MIDDLE)) {
                return Blocks.AIR.defaultBlockState();
            }
        }

        if (part == TripleBlockPart.MIDDLE) {
            if (direction == Direction.DOWN) {
                // 下が ROOT じゃなければ消滅
                if (!(neighborState.is(this) && neighborState.getValue(PART) == TripleBlockPart.ROOT)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            if (direction == Direction.UP) {
                // 上が TOP じゃなければ消滅
                if (!(neighborState.is(this) && neighborState.getValue(PART) == TripleBlockPart.TOP)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }

        if (part == TripleBlockPart.TOP && direction == Direction.DOWN) {
            // TOP の下が MIDDLE じゃなければ消滅
            if (!(neighborState.is(this) && neighborState.getValue(PART) == TripleBlockPart.MIDDLE)) {
                return Blocks.AIR.defaultBlockState();
            }
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 2 && level.getBlockState(blockpos.above()).canBeReplaced(context) ? super.getStateForPlacement(context) : null;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
        BlockPos blockpos = pos.above();
        BlockPos blockpos2 = blockpos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(PART, TripleBlockPart.MIDDLE)), 3);
        level.setBlock(blockpos2, copyWaterloggedFrom(level, pos, this.defaultBlockState().setValue(PART, TripleBlockPart.TOP)), 3);
    }

    public void placeAt(LevelAccessor world, BlockPos pos, int flags) {
        BlockState base = this.defaultBlockState();

        world.setBlock(pos, base.setValue(PART, TripleBlockPart.ROOT), flags);
        world.setBlock(pos.above(), base.setValue(PART, TripleBlockPart.MIDDLE), flags);
        world.setBlock(pos.above(2), base.setValue(PART, TripleBlockPart.TOP), flags);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        TripleBlockPart part = state.getValue(PART);

        if (part == TripleBlockPart.ROOT) {
            return super.canSurvive(state, level, pos);
        } else if (part == TripleBlockPart.MIDDLE) {
            BlockState below = level.getBlockState(pos.below());
            return below.is(this) && below.getValue(PART) == TripleBlockPart.ROOT;
        } else if (part == TripleBlockPart.TOP) {
            BlockState below = level.getBlockState(pos.below());
            return below.is(this) && below.getValue(PART) == TripleBlockPart.MIDDLE;
        }

        return false;
    }

    public static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos pos, BlockState blockstate) {
        return blockstate.hasProperty(BlockStateProperties.WATERLOGGED) ? blockstate.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(levelReader.isWaterAt(pos))) : blockstate;
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState blockstate, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(level, pos, blockstate, player);
            } else {
                dropResources(blockstate, level, pos, (BlockEntity) null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(level, pos, blockstate, player);
    }

    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockstate, @Nullable BlockEntity entity, ItemStack stack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), entity, stack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState blockstate, Player player) {
        TripleBlockPart part = blockstate.getValue(PART);
        if (part == TripleBlockPart.MIDDLE) {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);

            // ROOT ブロックが自分のクラスか確認
            if (belowState.is(blockstate.getBlock()) && belowState.getValue(PART) == TripleBlockPart.ROOT) {
                // ROOT を消す（クリエイティブ用）
                BlockState replacement = belowState.hasProperty(BlockStateProperties.WATERLOGGED) && belowState.getValue(BlockStateProperties.WATERLOGGED)
                        ? Blocks.WATER.defaultBlockState()
                        : Blocks.AIR.defaultBlockState();

                level.setBlock(belowPos, replacement, 35);
                level.levelEvent(player, 2001, belowPos, Block.getId(belowState));
            }
        }
        if (part == TripleBlockPart.TOP) {
            BlockPos belowPos2 = pos.below();
            BlockState belowState = level.getBlockState(belowPos2);

            // MIDDLE ブロックが自分のクラスか確認
            if (belowState.is(blockstate.getBlock()) && belowState.getValue(PART) == TripleBlockPart.MIDDLE) {
                // MIDDLE を消す（クリエイティブ用）
                BlockState replacement = belowState.hasProperty(BlockStateProperties.WATERLOGGED) && belowState.getValue(BlockStateProperties.WATERLOGGED)
                        ? Blocks.WATER.defaultBlockState()
                        : Blocks.AIR.defaultBlockState();

                level.setBlock(belowPos2, replacement, 35);
                level.levelEvent(player, 2001, belowPos2, Block.getId(belowState));
            }
        }
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    public long getSeed(BlockState blockstate, BlockPos pos) {
        int offsetY;

        switch (blockstate.getValue(PART)) {
            case ROOT:
                offsetY = 0;
                break;
            case MIDDLE:
                offsetY = 1;
                break;
            case TOP:
                offsetY = 2;
                break;
            default:
                offsetY = 0; // 念のため
        }

        BlockPos rootPos = pos.below(offsetY);
        return Mth.getSeed(rootPos.getX(), rootPos.getY(), rootPos.getZ());
    }
}
