package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Cradia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        customModelItem(ModItems.NAUADIAN_LONG_SWORD.get(), "handheld_long");
        customModelItem(ModItems.NAUADIAN_SCYTHE.get(), "handheld_long");
        customModelItem(ModItems.NAUADIAN_DAGGER.get(), "handheld_dagger");
        customModelItem(ModItems.ADRENA_LONG_SWORD.get(), "handheld_long");
        customModelItem(ModItems.ADRENA_SCYTHE.get(), "handheld_long");
        customModelItem(ModItems.ADRENA_DAGGER.get(), "handheld_dagger");
        customModelItem(ModItems.CRADIUM_LONG_SWORD.get(), "handheld_long");
        customModelItem(ModItems.CRADIUM_SCYTHE.get(), "handheld_long");
        customModelItem(ModItems.CRADIUM_DAGGER.get(), "handheld_dagger");
        basicItem(ModItems.NAUADIAN_ARROW.get());
        basicItem(ModItems.ADRENA_ARROW.get());
        customModelItem(ModItems.REINFORCED_STICK.get(), "handheld", "minecraft");
        basicItem(ModItems.CRADIUM_ARROW.get());
        basicItem(ModItems.NAUADIAN_SHARD.get());
        basicItem(ModItems.RAW_ADRENA.get());
        basicItem(ModItems.CRADIUM_SCRAP.get());
        basicItem(ModItems.NAUADIAN_NUGGET.get());
        basicItem(ModItems.ADRENA_NUGGET.get());
        basicItem(ModItems.CRADIUM_NUGGET.get());
        basicItem(ModItems.NAUADIAN_INGOT.get());
        basicItem(ModItems.ADRENA_INGOT.get());
        basicItem(ModItems.CRADIUM_INGOT.get());
    }

    protected void customModelItem(Item item, String modelName) {
        customModelItem(item, modelName, Cradia.MOD_ID);
    }

    protected void customModelItem(Item item, String modelName, String namespace) {
        ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(namespace, "item/" + modelName)))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
    }
}
