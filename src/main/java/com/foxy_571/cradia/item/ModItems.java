package com.foxy_571.cradia.item;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.ModEntityTypes;
import com.foxy_571.cradia.item.custom.*;
import com.foxy_571.cradia.item.tier.ModTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cradia.MOD_ID);

    public static DeferredItem<Item> NAUADIAN_SHARD;
    public static DeferredItem<Item> NAUADIAN_INGOT;
    public static DeferredItem<Item> RAW_ADRENA;
    public static DeferredItem<Item> ADRENA_INGOT;
    public static DeferredItem<Item> CRADIUM_SCRAP;
    public static DeferredItem<Item> CRADIUM_INGOT;
    public static DeferredItem<Item> NAUADIAN_ARROW;
    public static DeferredItem<Item> ADRENA_ARROW;
    public static DeferredItem<Item> CRADIUM_ARROW;
    public static DeferredItem<Item> NAUADIAN_LONG_SWORD;
    public static DeferredItem<Item> NAUADIAN_SCYTHE;
    public static DeferredItem<Item> NAUADIAN_BATTLE_AXE;
    public static DeferredItem<Item> NAUADIAN_DAGGER;
    public static DeferredItem<Item> ADRENA_LONG_SWORD;
    public static DeferredItem<Item> ADRENA_SCYTHE;
    public static DeferredItem<Item> ADRENA_BATTLE_AXE;
    public static DeferredItem<Item> ADRENA_DAGGER;
    public static DeferredItem<Item> CRADIUM_LONG_SWORD;
    public static DeferredItem<Item> CRADIUM_SCYTHE;
    public static DeferredItem<Item> CRADIUM_BATTLE_AXE;
    public static DeferredItem<Item> CRADIUM_DAGGER;
    public static DeferredItem<Item> REINFORCED_STICK;
    public static DeferredItem<Item> NAUADIAN_NUGGET;
    public static DeferredItem<Item> ADRENA_NUGGET;
    public static DeferredItem<Item> CRADIUM_NUGGET;
    public static DeferredItem<Item> NAUADIAN_ZOMBIE_SPAWN_EGG;
    public static DeferredItem<Item> NAUADIAN_SKELETON_SPAWN_EGG;

    static {
        NAUADIAN_SHARD = ITEMS.registerSimpleItem("nauadian_shard");
        NAUADIAN_INGOT = ITEMS.registerSimpleItem("nauadian_ingot");
        RAW_ADRENA = ITEMS.registerSimpleItem("raw_adrena");
        ADRENA_INGOT = ITEMS.registerSimpleItem("adrena_ingot");
        CRADIUM_SCRAP = ITEMS.registerSimpleItem("cradium_scrap");
        CRADIUM_INGOT = ITEMS.registerSimpleItem("cradium_ingot");
        NAUADIAN_ARROW = ITEMS.register("nauadian_arrow", () -> new TieredArrowItem(ModTiers.NAUADIAN, new Item.Properties()));
        ADRENA_ARROW = ITEMS.register("adrena_arrow", () -> new TieredArrowItem(ModTiers.ADRENA, new Item.Properties()));
        CRADIUM_ARROW = ITEMS.register("cradium_arrow", () -> new TieredArrowItem(ModTiers.CRADIUM, new Item.Properties()));
        NAUADIAN_LONG_SWORD = ITEMS.register("nauadian_long_sword", () -> new LongSwordItem(ModTiers.NAUADIAN, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.NAUADIAN, 3, -2.7F))));
        NAUADIAN_SCYTHE = ITEMS.register("nauadian_scythe", () -> new ScytheItem(ModTiers.NAUADIAN, (new Item.Properties()).attributes(ScytheItem.createAttributes(ModTiers.NAUADIAN, 2, -2.4F))));
        NAUADIAN_BATTLE_AXE = ITEMS.register("nauadian_battle_axe", () -> new BattleAxeItem(ModTiers.NAUADIAN, (new Item.Properties()).attributes(BattleAxeItem.createAttributes(ModTiers.NAUADIAN, 6, -3.5F))));
        NAUADIAN_DAGGER = ITEMS.register("nauadian_dagger", () -> new DaggerItem(ModTiers.NAUADIAN, (new Item.Properties()).attributes(SwordItem.createAttributes(ModTiers.NAUADIAN, 0.5F, -0.5F))));
        ADRENA_LONG_SWORD = ITEMS.register("adrena_long_sword", () -> new LongSwordItem(ModTiers.ADRENA, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.ADRENA, 3, -2.7F))));
        ADRENA_SCYTHE = ITEMS.register("adrena_scythe", () -> new ScytheItem(ModTiers.ADRENA, (new Item.Properties()).attributes(ScytheItem.createAttributes(ModTiers.ADRENA, 2, -2.4F))));
        ADRENA_BATTLE_AXE = ITEMS.register("adrena_battle_axe", () -> new BattleAxeItem(ModTiers.ADRENA, (new Item.Properties()).attributes(BattleAxeItem.createAttributes(ModTiers.ADRENA, 6, -3.5F))));
        ADRENA_DAGGER = ITEMS.register("adrena_dagger", () -> new DaggerItem(ModTiers.ADRENA, (new Item.Properties()).attributes(SwordItem.createAttributes(ModTiers.ADRENA, 0.5F, -0.5F))));
        CRADIUM_LONG_SWORD = ITEMS.register("cradium_long_sword", () -> new LongSwordItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(LongSwordItem.createAttributes(ModTiers.CRADIUM, 3, -2.7F))));
        CRADIUM_SCYTHE = ITEMS.register("cradium_scythe", () -> new ScytheItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(ScytheItem.createAttributes(ModTiers.CRADIUM, 2, -2.4F))));
        CRADIUM_BATTLE_AXE = ITEMS.register("cradium_battle_axe", () -> new BattleAxeItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(BattleAxeItem.createAttributes(ModTiers.CRADIUM, 6, -3.5F))));
        CRADIUM_DAGGER = ITEMS.register("cradium_dagger", () -> new DaggerItem(ModTiers.CRADIUM, (new Item.Properties()).attributes(SwordItem.createAttributes(ModTiers.CRADIUM, 0.5F, -0.5F))));
        REINFORCED_STICK = ITEMS.register("reinforced_stick", () -> new SpecialItem(new Item.Properties()));
        NAUADIAN_NUGGET = ITEMS.registerSimpleItem("nauadian_nugget");
        ADRENA_NUGGET = ITEMS.registerSimpleItem("adrena_nugget");
        CRADIUM_NUGGET = ITEMS.registerSimpleItem("cradium_nugget");
        NAUADIAN_ZOMBIE_SPAWN_EGG = ITEMS.register("nauadian_zombie_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.NAUADIAN_ZOMBIE, 0x1baebc, 0x658b6a, new Item.Properties()));
        NAUADIAN_SKELETON_SPAWN_EGG = ITEMS.register("nauadian_skeleton_spawn_egg", () -> new DeferredSpawnEggItem(ModEntityTypes.NAUADIAN_SKELETON, 0xacbcca, 0x414d55, new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
