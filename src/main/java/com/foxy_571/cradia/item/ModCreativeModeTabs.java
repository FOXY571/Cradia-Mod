package com.foxy_571.cradia.item;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cradia.MOD_ID);

    public static final Supplier<CreativeModeTab> CRADIA_TAB = CREATIVE_MODE_TABS.register("cradia_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CRADIUM_INGOT.get()))
            .title(Component.translatable("creativetab.cradia.cradia_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.NAUADIAN_BLOCK);
                output.accept(ModBlocks.ADRENA_BLOCK);
                output.accept(ModBlocks.CRADIUM_BLOCK);
                output.accept(ModBlocks.ADRENA_ORE);
                output.accept(ModBlocks.DEEPSLATE_ADRENA_ORE);
                output.accept(ModBlocks.CRADIUM_ORE);
                output.accept(ModBlocks.NAUADIAN_SHARD_BLOCK);
                output.accept(ModBlocks.RAW_ADRENA_BLOCK);
                output.accept(ModItems.NAUADIAN_LONG_SWORD);
                output.accept(ModItems.NAUADIAN_SCYTHE);
                output.accept(ModItems.NAUADIAN_BATTLE_AXE);
                output.accept(ModItems.NAUADIAN_DAGGER);
                output.accept(ModItems.ADRENA_LONG_SWORD);
                output.accept(ModItems.ADRENA_SCYTHE);
                output.accept(ModItems.ADRENA_BATTLE_AXE);
                output.accept(ModItems.ADRENA_DAGGER);
                output.accept(ModItems.CRADIUM_LONG_SWORD);
                output.accept(ModItems.CRADIUM_SCYTHE);
                output.accept(ModItems.CRADIUM_BATTLE_AXE);
                output.accept(ModItems.CRADIUM_DAGGER);
                output.accept(ModItems.NAUADIAN_ARROW);
                output.accept(ModItems.ADRENA_ARROW);
                output.accept(ModItems.CRADIUM_ARROW);
                output.accept(ModItems.NAUADIAN_SHARD);
                output.accept(ModItems.RAW_ADRENA);
                output.accept(ModItems.CRADIUM_SCRAP);
                output.accept(ModItems.NAUADIAN_NUGGET);
                output.accept(ModItems.ADRENA_NUGGET);
                output.accept(ModItems.CRADIUM_NUGGET);
                output.accept(ModItems.NAUADIAN_INGOT);
                output.accept(ModItems.ADRENA_INGOT);
                output.accept(ModItems.CRADIUM_INGOT);
                output.accept(ModItems.REINFORCED_STICK);
                output.accept(ModItems.NAUADIAN_ZOMBIE_SPAWN_EGG);
                output.accept(ModItems.NAUADIAN_SKELETON_SPAWN_EGG);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
