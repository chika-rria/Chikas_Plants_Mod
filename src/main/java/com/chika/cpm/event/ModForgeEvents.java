package com.chika.cpm.event;

import com.chika.cpm.block.custom.CPM_CottonRoseBlock;
import com.chika.cpm.block.state.enumtype.CottonRoseColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

import static com.chika.cpm.block.custom.CPM_CottonRoseBlock.COLOR;

@Mod.EventBusSubscriber(modid = "cpm", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModForgeEvents {

    private static CottonRoseColor lastColor = null;

    @SubscribeEvent
    public static void onWorldTick(TickEvent.LevelTickEvent event) {
        Level world = event.level;
        if (world.isClientSide || event.phase != TickEvent.Phase.START) return;

        // 現在の時間帯カラーを取得
        CottonRoseColor currentColor = getCurrentTimeColor(world);
        boolean colorChanged = currentColor != lastColor;
        lastColor = currentColor;

        for (Player player : world.players()) {
            BlockPos playerPos = player.blockPosition();
            int range = 32;
            List<BlockPos> activePositions = new ArrayList<>();

            // 登録済み花リストから範囲内の花だけ更新
            for (BlockPos pos : FlowerTickManager.getFlowers(world)) {
                if (pos.closerThan(playerPos, range)) {
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock() instanceof CPM_CottonRoseBlock) {
                        if (colorChanged || state.getValue(COLOR) != currentColor) {
                            world.setBlock(pos, state.setValue(COLOR, currentColor), 2);
                        }
                        activePositions.add(pos);
                    }
                }
            }

            // 範囲外の花をリストから削除
            FlowerTickManager.cleanup(world, activePositions);
        }
    }

    private static CottonRoseColor getCurrentTimeColor(Level world) {
        long time = world.getDayTime() % 24000;
        if (time < 14000) return CottonRoseColor.DAY;
        if (time < 18000) return CottonRoseColor.SUNSET;
        return CottonRoseColor.NIGHT;
    }
}
