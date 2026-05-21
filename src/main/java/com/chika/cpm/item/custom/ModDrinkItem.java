package com.chika.cpm.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ModDrinkItem extends ModTooltipItem {
    public ModDrinkItem(Properties pProperties, int id, int duration) {
        super(pProperties);
        this.id = id;
        this.duration = duration;
    }

    private final int id;
    private final int duration;

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {

        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            if (entity instanceof Player player) {

                // 効果付与
                player.addEffect(new MobEffectInstance(MobEffect.byId(id), duration, 1));
                player.addEffect(new MobEffectInstance(MobEffect.byId(23), 1, 0));

                // 空瓶返却
                if (!player.getAbilities().instabuild) {
                    ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);

                    if (!player.getInventory().add(bottle)) {
                        player.drop(bottle, false);
                    }
                }
            }
        }

        return super.finishUsingItem(stack, level, entity);
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
