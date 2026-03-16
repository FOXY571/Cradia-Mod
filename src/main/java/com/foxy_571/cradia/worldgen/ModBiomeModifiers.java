package com.foxy_571.cradia.worldgen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.ModEntityTypes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADRENA_ORE = registerKey("add_adrena_ore");
    public static final ResourceKey<BiomeModifier> CRADIUM_METEOR = registerKey("add_cradium_meteor");

    public static final ResourceKey<BiomeModifier> NAUADIAN_ZOMBIE_COMMON = registerKey("spawn_nauadian_zombie_common");
    public static final ResourceKey<BiomeModifier> NAUADIAN_ZOMBIE_DESERT = registerKey("spawn_nauadian_zombie_desert");

    public static final ResourceKey<BiomeModifier> NAUADIAN_SKELETON_COMMON = registerKey("spawn_nauadian_skeleton_common");
    public static final ResourceKey<BiomeModifier> NAUADIAN_SKELETON_COLD = registerKey("spawn_nauadian_skeleton_cold");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADRENA_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ADRENA_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(CRADIUM_METEOR, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CRADIUM_METEOR)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS));

        List<ResourceKey<Biome>> nauadianZombieCommonBiomes = List.of(
                Biomes.PLAINS,
                Biomes.SUNFLOWER_PLAINS,
                Biomes.SNOWY_PLAINS,
                Biomes.ICE_SPIKES,
                Biomes.SWAMP,
                Biomes.MANGROVE_SWAMP,
                Biomes.FOREST,
                Biomes.FLOWER_FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.DARK_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.TAIGA,
                Biomes.SNOWY_TAIGA,
                Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_HILLS,
                Biomes.WINDSWEPT_GRAVELLY_HILLS,
                Biomes.WINDSWEPT_FOREST,
                Biomes.WINDSWEPT_SAVANNA,
                Biomes.JUNGLE,
                Biomes.SPARSE_JUNGLE,
                Biomes.BAMBOO_JUNGLE,
                Biomes.BADLANDS,
                Biomes.ERODED_BADLANDS,
                Biomes.WOODED_BADLANDS,
                Biomes.MEADOW,
                Biomes.CHERRY_GROVE,
                Biomes.GROVE,
                Biomes.SNOWY_SLOPES,
                Biomes.FROZEN_PEAKS,
                Biomes.JAGGED_PEAKS,
                Biomes.STONY_PEAKS,
                Biomes.RIVER,
                Biomes.FROZEN_RIVER,
                Biomes.BEACH,
                Biomes.SNOWY_BEACH,
                Biomes.STONY_SHORE,
                Biomes.WARM_OCEAN,
                Biomes.LUKEWARM_OCEAN,
                Biomes.DEEP_LUKEWARM_OCEAN,
                Biomes.OCEAN,
                Biomes.DEEP_OCEAN,
                Biomes.COLD_OCEAN,
                Biomes.DEEP_COLD_OCEAN,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.DRIPSTONE_CAVES,
                Biomes.LUSH_CAVES
        );
        HolderSet<Biome> nauadianZombieBiomesHolder = HolderSet.direct(nauadianZombieCommonBiomes.stream().map(biomes::getOrThrow).toList());
        context.register(NAUADIAN_ZOMBIE_COMMON, new BiomeModifiers.AddSpawnsBiomeModifier(
                nauadianZombieBiomesHolder, List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.NAUADIAN_ZOMBIE.get(), 15, 2, 2))));
        context.register(NAUADIAN_ZOMBIE_DESERT, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)), List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.NAUADIAN_ZOMBIE.get(), 3, 2, 2))));

        List<ResourceKey<Biome>> nauadianSkeletonCommonBiomes = List.of(
                Biomes.PLAINS,
                Biomes.SUNFLOWER_PLAINS,
                Biomes.DESERT,
                Biomes.SWAMP,
                Biomes.MANGROVE_SWAMP,
                Biomes.FOREST,
                Biomes.FLOWER_FOREST,
                Biomes.BIRCH_FOREST,
                Biomes.DARK_FOREST,
                Biomes.OLD_GROWTH_BIRCH_FOREST,
                Biomes.OLD_GROWTH_PINE_TAIGA,
                Biomes.OLD_GROWTH_SPRUCE_TAIGA,
                Biomes.TAIGA,
                Biomes.SNOWY_TAIGA,
                Biomes.SAVANNA,
                Biomes.SAVANNA_PLATEAU,
                Biomes.WINDSWEPT_HILLS,
                Biomes.WINDSWEPT_GRAVELLY_HILLS,
                Biomes.WINDSWEPT_FOREST,
                Biomes.WINDSWEPT_SAVANNA,
                Biomes.JUNGLE,
                Biomes.SPARSE_JUNGLE,
                Biomes.BAMBOO_JUNGLE,
                Biomes.BADLANDS,
                Biomes.ERODED_BADLANDS,
                Biomes.WOODED_BADLANDS,
                Biomes.MEADOW,
                Biomes.CHERRY_GROVE,
                Biomes.GROVE,
                Biomes.SNOWY_SLOPES,
                Biomes.FROZEN_PEAKS,
                Biomes.JAGGED_PEAKS,
                Biomes.STONY_PEAKS,
                Biomes.RIVER,
                Biomes.FROZEN_RIVER,
                Biomes.BEACH,
                Biomes.SNOWY_BEACH,
                Biomes.STONY_SHORE,
                Biomes.WARM_OCEAN,
                Biomes.LUKEWARM_OCEAN,
                Biomes.DEEP_LUKEWARM_OCEAN,
                Biomes.OCEAN,
                Biomes.DEEP_OCEAN,
                Biomes.COLD_OCEAN,
                Biomes.DEEP_COLD_OCEAN,
                Biomes.FROZEN_OCEAN,
                Biomes.DEEP_FROZEN_OCEAN,
                Biomes.DRIPSTONE_CAVES,
                Biomes.LUSH_CAVES
        );
        HolderSet<Biome> nauadianSkeletonBiomesHolder = HolderSet.direct(nauadianSkeletonCommonBiomes.stream().map(biomes::getOrThrow).toList());
        context.register(NAUADIAN_SKELETON_COMMON, new BiomeModifiers.AddSpawnsBiomeModifier(
                nauadianSkeletonBiomesHolder, List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.NAUADIAN_SKELETON.get(), 15, 2, 2))));
        context.register(NAUADIAN_SKELETON_COLD, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SNOWY_PLAINS), biomes.getOrThrow(Biomes.ICE_SPIKES)), List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.NAUADIAN_SKELETON.get(), 3, 2, 2))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, name));
    }
}
