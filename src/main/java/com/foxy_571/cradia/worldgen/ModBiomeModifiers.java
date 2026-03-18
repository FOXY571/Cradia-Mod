package com.foxy_571.cradia.worldgen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.ModEntityTypes;
import com.foxy_571.cradia.worldgen.modifier.EntityScaledSpawnModifier;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADRENA_ORE = registerKey("add_adrena_ore");
    public static final ResourceKey<BiomeModifier> CRADIUM_METEOR = registerKey("add_cradium_meteor");

    public static final ResourceKey<BiomeModifier> NAUADIAN_ZOMBIE = registerKey("spawn_nauadian_zombie");
    public static final ResourceKey<BiomeModifier> NAUADIAN_SKELETON = registerKey("spawn_nauadian_skeleton");

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

        context.register(NAUADIAN_ZOMBIE, new EntityScaledSpawnModifier(EntityType.ZOMBIE, ModEntityTypes.NAUADIAN_ZOMBIE.get(), 0.15F, 2, 2));
        context.register(NAUADIAN_SKELETON, new EntityScaledSpawnModifier(EntityType.SKELETON, ModEntityTypes.NAUADIAN_SKELETON.get(), 0.15F, 2, 2));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, name));
    }
}
