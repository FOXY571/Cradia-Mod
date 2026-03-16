package com.foxy_571.cradia.entity;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.NauadianSkeleton;
import com.foxy_571.cradia.entity.custom.NauadianZombie;
import com.foxy_571.cradia.entity.custom.ThrownDagger;
import com.foxy_571.cradia.entity.custom.TieredArrow;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Cradia.MOD_ID);

    public static final Supplier<EntityType<NauadianZombie>> NAUADIAN_ZOMBIE =
            ENTITY_TYPES.register("nauadian_zombie", () -> EntityType.Builder.of(NauadianZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).eyeHeight(1.74F).passengerAttachments(2.0125F).ridingOffset(-0.7F).clientTrackingRange(8).build("nauadian_zombie"));
    public static final Supplier<EntityType<NauadianSkeleton>> NAUADIAN_SKELETON =
            ENTITY_TYPES.register("nauadian_skeleton", () -> EntityType.Builder.of(NauadianSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).eyeHeight(1.74F).ridingOffset(-0.7F).clientTrackingRange(8).build("nauadian_skeleton"));

    public static final Supplier<EntityType<TieredArrow>> TIERED_ARROW =
            ENTITY_TYPES.register("tiered_arrow", () -> EntityType.Builder.<TieredArrow>of(TieredArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("tiered_arrow"));
    public static final Supplier<EntityType<ThrownDagger>> THROWN_DAGGER =
            ENTITY_TYPES.register("thrown_dagger", () -> EntityType.Builder.<ThrownDagger>of(ThrownDagger::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20).build("thrown_dagger"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
