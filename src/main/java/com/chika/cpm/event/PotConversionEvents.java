package com.chika.cpm.event;

import com.chika.cpm.CPMod;
import com.chika.cpm.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PotConversionEvents {

    // ブロックが設置されたとき（EntityPlaceEvent）に置き換え
    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        BlockState placed = event.getState();
        // プレイヤー由来で、置かれたのが空のflower_potだったら差し替え
        if (!level.isClientSide() && placed.is(Blocks.FLOWER_POT)) {
            // 置換：CPMの鉢を設置（BE初期化も行う）
            level.setBlock(pos, ModBlocks.CPM_VANILLA_POT.get().defaultBlockState(), 3);
            level.sendBlockUpdated(pos, placed, ModBlocks.CPM_VANILLA_POT.get().defaultBlockState(), 3);
        }
    }

    //プレイヤーがブロックを右クリックしたとき（花を抜く操作など）
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return;

        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        event.getLevel().getServer().execute(() -> {
            BlockState now = level.getBlockState(pos);
            // もし now が空のバニラ flower_pot になっていたら、差し替える
            if (now.is(Blocks.FLOWER_POT)) {
                level.setBlock(pos, ModBlocks.CPM_VANILLA_POT.get().defaultBlockState(), 3);
            }
        });
    }
}

