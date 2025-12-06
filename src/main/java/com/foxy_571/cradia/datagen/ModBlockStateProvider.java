package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Cradia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.ADRENA_ORE);
        simpleBlockWithItem(ModBlocks.DEEPSLATE_ADRENA_ORE);
        simpleBlockWithItem(ModBlocks.CRADIUM_ORE);
        simpleBlockWithItem(ModBlocks.NAUADIAN_SHARD_BLOCK);
        simpleBlockWithItem(ModBlocks.RAW_ADRENA_BLOCK);
        simpleBlockWithItem(ModBlocks.NAUADIAN_BLOCK);
        simpleBlockWithItem(ModBlocks.ADRENA_BLOCK);
        simpleBlockWithItem(ModBlocks.CRADIUM_BLOCK);
    }

    protected void simpleBlockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
