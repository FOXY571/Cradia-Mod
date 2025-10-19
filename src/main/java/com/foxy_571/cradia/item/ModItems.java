package com.foxy_571.cradia.item;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.custom.LongSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cradia.MOD_ID);

    public static final DeferredItem<LongSwordItem> IRON_LONG_SWORD = ITEMS.register("iron_long_sword",
            () -> new LongSwordItem(Tiers.IRON, (new Item.Properties()).attributes(LongSwordItem.createAttributes(Tiers.IRON, 3, -2.7F))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
