package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.block.ModBlocks;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Cradia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.SWORDS).add(
                ModItems.NAUADIAN_LONG_SWORD.get(),
                ModItems.ADRENA_LONG_SWORD.get(),
                ModItems.CRADIUM_LONG_SWORD.get()
        );
        tag(ItemTags.ARROWS).add(
                ModItems.NAUADIAN_ARROW.get(),
                ModItems.ADRENA_ARROW.get(),
                ModItems.CRADIUM_ARROW.get()
        );
        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(
                ModItems.NAUADIAN_LONG_SWORD.get(),
                ModItems.NAUADIAN_SCYTHE.get(),
                ModItems.NAUADIAN_DAGGER.get(),
                ModItems.ADRENA_LONG_SWORD.get(),
                ModItems.ADRENA_SCYTHE.get(),
                ModItems.ADRENA_DAGGER.get(),
                ModItems.CRADIUM_LONG_SWORD.get(),
                ModItems.CRADIUM_SCYTHE.get(),
                ModItems.CRADIUM_DAGGER.get()
        );
        tag(Tags.Items.RANGED_WEAPON_TOOLS).add(
                ModItems.NAUADIAN_DAGGER.get(),
                ModItems.ADRENA_DAGGER.get(),
                ModItems.CRADIUM_DAGGER.get()
        );

        tag(Tags.Items.INGOTS).add(
                ModItems.NAUADIAN_INGOT.get(),
                ModItems.ADRENA_INGOT.get(),
                ModItems.CRADIUM_INGOT.get()
        );
        tag(Tags.Items.NUGGETS).add(
                ModItems.NAUADIAN_NUGGET.get(),
                ModItems.ADRENA_NUGGET.get(),
                ModItems.CRADIUM_NUGGET.get()
        );
        tag(Tags.Items.RAW_MATERIALS).add(
                ModItems.NAUADIAN_SHARD.get(),
                ModItems.RAW_ADRENA.get()
        );

        tag(Tags.Items.RODS).add(
                ModItems.REINFORCED_STICK.get()
        );

        tag(Tags.Items.ORES).add(
                ModBlocks.ADRENA_ORE.asItem(),
                ModBlocks.DEEPSLATE_ADRENA_ORE.asItem(),
                ModBlocks.CRADIUM_ORE.asItem()
        );
        tag(Tags.Items.ORES_IN_GROUND_STONE).add(
                ModBlocks.ADRENA_ORE.asItem()
        );
        tag(Tags.Items.ORES_IN_GROUND_DEEPSLATE).add(
                ModBlocks.DEEPSLATE_ADRENA_ORE.asItem()
        );

        tag(Tags.Items.STORAGE_BLOCKS).add(
                ModBlocks.NAUADIAN_SHARD_BLOCK.asItem(),
                ModBlocks.RAW_ADRENA_BLOCK.asItem(),
                ModBlocks.NAUADIAN_BLOCK.asItem(),
                ModBlocks.ADRENA_BLOCK.asItem(),
                ModBlocks.CRADIUM_BLOCK.asItem()
        );
    }
}
