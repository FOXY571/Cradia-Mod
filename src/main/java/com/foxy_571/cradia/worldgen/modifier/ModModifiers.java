package com.foxy_571.cradia.worldgen.modifier;

import com.foxy_571.cradia.Cradia;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModModifiers {
    private static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Cradia.MOD_ID);

    public static final Supplier<MapCodec<EntityScaledSpawnModifier>> ENTITY_SCALED_SPAWN =
            BIOME_MODIFIERS.register("entity_scaled_spawn", () -> RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("original").forGetter(EntityScaledSpawnModifier::original),
                            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entity").forGetter(EntityScaledSpawnModifier::entity),
                            Codec.FLOAT.fieldOf("scale").forGetter(EntityScaledSpawnModifier::scale),
                            Codec.INT.fieldOf("min_count").forGetter(EntityScaledSpawnModifier::minCount),
                            Codec.INT.fieldOf("max_count").forGetter(EntityScaledSpawnModifier::maxCount)
                    ).apply(instance, EntityScaledSpawnModifier::new)));

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIERS.register(eventBus);
    }
}
