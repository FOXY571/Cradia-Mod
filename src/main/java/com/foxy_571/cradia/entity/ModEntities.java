package com.foxy_571.cradia.entity;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.AdrenaArrow;
import com.foxy_571.cradia.entity.custom.CradiumArrow;
import com.foxy_571.cradia.entity.custom.TieredArrow;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Cradia.MOD_ID);

    public static final Supplier<EntityType<AdrenaArrow>> ADRENA_ARROW =
            ENTITY_TYPES.register("adrena_arrow", () -> EntityType.Builder.<AdrenaArrow>of(AdrenaArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("adrena_arrow"));
    public static final Supplier<EntityType<CradiumArrow>> CRADIUM_ARROW =
            ENTITY_TYPES.register("cradium_arrow", () -> EntityType.Builder.<CradiumArrow>of(CradiumArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("cradium_arrow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
