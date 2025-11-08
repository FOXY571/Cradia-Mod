package com.foxy_571.cradia.entity;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.TieredArrow;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Cradia.MOD_ID);

    public static final Supplier<EntityType<TieredArrow>> TIERED_ARROW =
            ENTITY_TYPES.register("tiered_arrow", () -> EntityType.Builder.<TieredArrow>of(TieredArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("tiered_arrow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
