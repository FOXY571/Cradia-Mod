package com.foxy_571.cradia.worldgen.feature.custom;

import com.foxy_571.cradia.Cradia;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;
import java.util.function.Consumer;

public class CradiumMeteorFeature extends TemplateFeature {
    private static final float TUFF_REPLACE_CHANCE = 0.25F;
    private static final List<ResourceLocation> METEOR_LOCATIONS = List.of(
            ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "cradium_meteor/big_meteor"),
            ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "cradium_meteor/medium_meteor"),
            ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "cradium_meteor/small_meteor")
    );

    public CradiumMeteorFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected ResourceLocation getLocation(RandomSource random) {
        return METEOR_LOCATIONS.get(random.nextInt(METEOR_LOCATIONS.size()));
    }

    @Override
    protected BlockPos getOffsetPosition(ResourceLocation location) {
        if (location.getPath().equals("cradium_meteor/big_meteor")) {
            return new BlockPos(-0, -5, -0);
        }
        return new BlockPos(0, -4, 0);
    }

    @Override
    protected StructurePlaceSettings makeSettings(WorldGenLevel level, BlockPos originalPos, BlockPos posWithOffset, Rotation rotation) {
        boolean isInWater = level.getBlockState(originalPos).getFluidState().isSource();

        return new StructurePlaceSettings()
                .setRotation(rotation)
                .setMirror(Mirror.NONE)
                .addProcessor(isInWater ? BlockIgnoreProcessor.AIR : BlockIgnoreProcessor.STRUCTURE_BLOCK);
    }

    @Override
    protected void postProcessing(WorldGenLevel level, RandomSource random, BoundingBox box, BlockPos pos) {
        foreachBlockInBox(box, blockPos -> {
            if (level.getBlockState(blockPos).is(Blocks.SMOOTH_BASALT) && random.nextFloat() < TUFF_REPLACE_CHANCE) {
                level.setBlock(blockPos, Blocks.TUFF.defaultBlockState(), 2);
            }
        });
    }

    private void foreachBlockInBox(BoundingBox box, Consumer<BlockPos> consumer) {
        for (int x = box.minX(); x <= box.maxX(); x++) {
            for (int y = box.minY(); y <= box.maxY(); y++) {
                for (int z = box.minZ(); z <= box.maxZ(); z++) {
                    consumer.accept(new BlockPos(x, y, z));
                }
            }
        }
    }
}
