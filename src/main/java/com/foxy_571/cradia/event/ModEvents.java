package com.foxy_571.cradia.event;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.custom.LongSwordItem;
import com.foxy_571.cradia.util.PlayerReachHandler;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = Cradia.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void playerTickPost(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) return;

        if (player.getMainHandItem().getItem() instanceof LongSwordItem) {
            PlayerReachHandler.applyEntityReachModifier(player, 1.0);
        } else {
            PlayerReachHandler.removeEntityReachModifier(player);
        }
    }
}

