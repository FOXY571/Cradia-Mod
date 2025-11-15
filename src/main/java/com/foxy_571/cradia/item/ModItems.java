package com.foxy_571.cradia.item;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.custom.LongSwordItem;
import com.foxy_571.cradia.item.custom.TieredArrowItem;
import com.foxy_571.cradia.item.tier.ModTiers;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cradia.MOD_ID);

    public static final DeferredItem<Item> ADRENA_INGOT = ITEMS.register("adrena_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ADRENA_NUGGET = ITEMS.register("adrena_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ADRENA_LONG_SWORD = ITEMS.register("adrena_long_sword",
            () -> new LongSwordItem(ModTiers.ADRENA, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.ADRENA, 3, -2.7F))));
    public static final DeferredItem<TieredArrowItem> ADRENA_ARROW = ITEMS.register("adrena_arrow",
            () -> new TieredArrowItem(ModTiers.ADRENA, new Item.Properties()));

    public static final DeferredItem<Item> CRADIUM_INGOT = ITEMS.register("cradium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CRADIUM_NUGGET = ITEMS.register("cradium_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<LongSwordItem> CRADIUM_LONG_SWORD = ITEMS.register("cradium_long_sword",
            () -> new LongSwordItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.CRADIUM, 3, -2.7F))));
    public static final DeferredItem<TieredArrowItem> CRADIUM_ARROW = ITEMS.register("cradium_arrow",
            () -> new TieredArrowItem(ModTiers.CRADIUM, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
