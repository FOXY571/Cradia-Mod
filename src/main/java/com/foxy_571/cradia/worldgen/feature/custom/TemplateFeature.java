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
        BlockPos blockPos = context.origin();
        Rotation rotation = Rotation.getRandom(context.random());

        StructureTemplateManager stm = worldgenlevel.getLevel().getStructureManager();
        StructureTemplate template = stm.getOrCreate(getLocation(context.random()));

        boolean placed = template.placeInWorld(worldgenlevel, blockPos, new BlockPos(0, 0, 0), makeSettings(rotation), context.random(), 2);
        if (placed) {
            postProcessing(worldgenlevel, context.random(), template.getBoundingBox(makeSettings(rotation), blockPos), blockPos);
            return true;
        }

        return false;
    }

    protected abstract ResourceLocation getLocation(RandomSource random);

    protected abstract StructurePlaceSettings makeSettings(Rotation rotation);

    protected abstract void postProcessing(WorldGenLevel level, RandomSource random, BoundingBox box, BlockPos pos);
}
