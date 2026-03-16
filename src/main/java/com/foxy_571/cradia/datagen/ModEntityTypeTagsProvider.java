package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.ModEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagsProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Cradia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(EntityTypeTags.ARROWS).add(
                ModEntityTypes.TIERED_ARROW.get()
        );
        tag(EntityTypeTags.IMPACT_PROJECTILES).add(
                ModEntityTypes.THROWN_DAGGER.get()
        );

        tag(EntityTypeTags.ZOMBIES).add(
                ModEntityTypes.NAUADIAN_ZOMBIE.get()
        );
        tag(EntityTypeTags.SKELETONS).add(
                ModEntityTypes.NAUADIAN_SKELETON.get()
        );
    }
}
