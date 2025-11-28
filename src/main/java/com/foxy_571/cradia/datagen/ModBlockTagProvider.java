package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Cradia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.ADRENA_ORE.get(),
                ModBlocks.DEEPSLATE_ADRENA_ORE.get(),
                ModBlocks.CRADIUM_ORE.get(),
                ModBlocks.RAW_ADRENA_BLOCK.get(),
                ModBlocks.ADRENA_BLOCK.get(),
                ModBlocks.CRADIUM_BLOCK.get()
        );
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.ADRENA_ORE.get(),
                ModBlocks.DEEPSLATE_ADRENA_ORE.get(),
                ModBlocks.ADRENA_BLOCK.get(),
                ModBlocks.RAW_ADRENA_BLOCK.get()
        );
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
                ModBlocks.CRADIUM_ORE.get(),
                ModBlocks.CRADIUM_BLOCK.get()
        );
    }
}
