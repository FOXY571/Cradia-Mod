package com.foxy_571.cradia.worldgen.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import org.jetbrains.annotations.NotNull;

public abstract class TemplateFeature extends Feature<NoneFeatureConfiguration> {
    public TemplateFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        RandomSource random = context.random();
        BlockPos blockPos = context.origin();
        Rotation rotation = Rotation.getRandom(random);

        ResourceLocation location = getLocation(random);

        StructureTemplateManager stm = worldgenlevel.getLevel().getStructureManager();
        StructureTemplate template = stm.getOrCreate(location);

        BlockPos offsetPos = getOffsetPosition(location);
        StructurePlaceSettings settings = makeSettings(worldgenlevel, blockPos, offsetPos, rotation);

        boolean placed = template.placeInWorld(worldgenlevel, blockPos.offset(offsetPos), BlockPos.ZERO, settings, context.random(), 2);
        if (placed) {
            postProcessing(worldgenlevel, random, template.getBoundingBox(settings, blockPos.offset(offsetPos)), blockPos);
            return true;
        }

        return false;
    }

    protected abstract ResourceLocation getLocation(RandomSource random);

    protected BlockPos getOffsetPosition(ResourceLocation location) {
        return BlockPos.ZERO;
    }

    protected abstract StructurePlaceSettings makeSettings(WorldGenLevel level, BlockPos originalPos, BlockPos posWithOffset, Rotation rotation);

    protected abstract void postProcessing(WorldGenLevel level, RandomSource random, BoundingBox box, BlockPos pos);
}
