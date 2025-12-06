package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.block.ModBlocks;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropOre(ModBlocks.ADRENA_ORE.get(), ModItems.RAW_ADRENA.get());
        dropOre(ModBlocks.DEEPSLATE_ADRENA_ORE.get(), ModItems.RAW_ADRENA.get());
        dropSelf(ModBlocks.CRADIUM_ORE.get());
        dropSelf(ModBlocks.NAUADIAN_SHARD_BLOCK.get());
        dropSelf(ModBlocks.RAW_ADRENA_BLOCK.get());
        dropSelf(ModBlocks.NAUADIAN_BLOCK.get());
        dropSelf(ModBlocks.ADRENA_BLOCK.get());
        dropSelf(ModBlocks.CRADIUM_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

    protected void dropOre(Block block, Item item) {
        add(block, b -> createOreDrop(block, item));
    }
}
