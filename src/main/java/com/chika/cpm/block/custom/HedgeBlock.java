package com.chika.cpm.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolActions;

public class HedgeBlock extends RotateBlock {
    //アウトライン・選択形状
    private static final VoxelShape EAST_SHAPE = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 18.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 18.0D, 13.0D);
    //衝突判定
    private static final VoxelShape EAST_WEST_COLLISION =
            Block.box(4, 0, 0, 12, 24, 16);

    private static final VoxelShape NORTH_SOUTH_COLLISION =
            Block.box(0, 0, 4, 16, 24, 12);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> EAST_SHAPE;
            default -> SOUTH_SHAPE;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state,
                                        BlockGetter level,
                                        BlockPos pos,
                                        CollisionContext context) {

        return switch (state.getValue(FACING)) {
            case EAST, WEST -> EAST_WEST_COLLISION;
            default -> NORTH_SOUTH_COLLISION;
        };
    }

    public HedgeBlock(Properties properties) {
        super(properties
                .strength(1.2F, 3.0F)
                .sound(SoundType.AZALEA_LEAVES)
                .noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.SOUTH));
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player,
                                    BlockGetter level, BlockPos pos) {

        ItemStack stack = player.getMainHandItem();

        //斧と同じくらいの破壊速度
        if (stack.canPerformAction(ToolActions.SHEARS_DIG)) {
            return 0.2F;
        }

        return super.getDestroyProgress(state, player, level, pos);
    }


    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }

}
