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

    public static final DeferredItem<LongSwordItem> CRADIUM_LONG_SWORD = ITEMS.register("cradium_long_sword",
            () -> new LongSwordItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.CRADIUM, 3, -2.7F))));
    public static final DeferredItem<Item> ADRENA_LONG_SWORD = ITEMS.register("adrena_long_sword",
            () -> new LongSwordItem(ModTiers.ADRENA, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.ADRENA, 3, -2.7F))));
    public static final DeferredItem<TieredArrowItem> ADRENA_ARROW = ITEMS.register("adrena_arrow",
            () -> new TieredArrowItem(ModTiers.ADRENA, new Item.Properties()));
    public static final DeferredItem<TieredArrowItem> CRADIUM_ARROW = ITEMS.register("cradium_arrow",
            () -> new TieredArrowItem(ModTiers.CRADIUM, new Item.Properties()));

    public static final DeferredItem<Item> RAW_ADRENA = ITEMS.registerSimpleItem("raw_adrena");
    public static final DeferredItem<Item> CRADIUM_SCRAP = ITEMS.registerSimpleItem("cradium_scrap");
    public static final DeferredItem<Item> ADRENA_NUGGET = ITEMS.registerSimpleItem("adrena_nugget");
    public static final DeferredItem<Item> CRADIUM_NUGGET = ITEMS.registerSimpleItem("cradium_nugget");
    public static final DeferredItem<Item> ADRENA_INGOT = ITEMS.registerSimpleItem("adrena_ingot");
    public static final DeferredItem<Item> CRADIUM_INGOT = ITEMS.registerSimpleItem("cradium_ingot");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
