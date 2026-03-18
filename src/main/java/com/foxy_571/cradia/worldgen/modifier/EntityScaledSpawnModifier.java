package com.foxy_571.cradia.worldgen.modifier;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record EntityScaledSpawnModifier(EntityType<?> original, EntityType<?> entity, float scale, int minCount, int maxCount) implements BiomeModifier {
    @Override
    public void modify(@NotNull Holder<Biome> holder, @NotNull Phase phase, ModifiableBiomeInfo.BiomeInfo.@NotNull Builder builder) {
        if (phase != Phase.ADD) return;

        List<MobSpawnSettings.SpawnerData> spawns = builder.getMobSpawnSettings().getSpawner(original.getCategory());

        int weight = spawns.stream()
                .filter(data -> data.type == original)
                .mapToInt(data -> data.getWeight().asInt())
                .sum();

        if (weight > 0) {
            int newWeight = Math.max(1, (int)(weight * scale));
            builder.getMobSpawnSettings().addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(entity, newWeight, minCount, maxCount));
        }
    }

    @Override
    public @NotNull MapCodec<? extends BiomeModifier> codec() {
        return ModModifiers.ENTITY_SCALED_SPAWN.get();
    }
}
