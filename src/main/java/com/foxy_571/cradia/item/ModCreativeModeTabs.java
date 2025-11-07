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
                output.accept(ModBlocks.CRADIUM_ORE);

                output.accept(ModItems.CRADIUM_INGOT);
                output.accept(ModItems.CRADIUM_NUGGET);
                output.accept(ModItems.CRADIUM_LONG_SWORD);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
