package com.foxy_571.cradia.datagen;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.block.ModBlocks;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ingotBlockNuggetSet(recipeOutput, ModItems.NAUADIAN_INGOT, ModBlocks.NAUADIAN_BLOCK, ModItems.NAUADIAN_NUGGET);
        ingotBlockNuggetSet(recipeOutput, ModItems.ADRENA_INGOT, ModBlocks.ADRENA_BLOCK, ModItems.ADRENA_NUGGET);
        ingotBlockNuggetSet(recipeOutput, ModItems.CRADIUM_INGOT, ModBlocks.CRADIUM_BLOCK, ModItems.CRADIUM_NUGGET);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NAUADIAN_SHARD_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NAUADIAN_SHARD)
                .unlockedBy("has_nauadian_shard", has(ModItems.NAUADIAN_SHARD))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ADRENA_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_ADRENA)
                .unlockedBy("has_raw_adrena", has(ModItems.RAW_ADRENA))
                .save(recipeOutput);

        longSword(recipeOutput, ModItems.NAUADIAN_INGOT, ModItems.NAUADIAN_LONG_SWORD);
        longSword(recipeOutput, ModItems.ADRENA_INGOT, ModItems.ADRENA_LONG_SWORD);
        longSword(recipeOutput, ModItems.CRADIUM_INGOT, ModItems.CRADIUM_LONG_SWORD);

        scythe(recipeOutput, ModItems.NAUADIAN_INGOT, ModItems.NAUADIAN_SCYTHE);
        scythe(recipeOutput, ModItems.ADRENA_INGOT, ModItems.ADRENA_SCYTHE);
        scythe(recipeOutput, ModItems.CRADIUM_INGOT, ModItems.CRADIUM_SCYTHE);

        battleAxe(recipeOutput, ModItems.NAUADIAN_INGOT, ModItems.NAUADIAN_BATTLE_AXE);
        battleAxe(recipeOutput, ModItems.ADRENA_INGOT, ModItems.ADRENA_BATTLE_AXE);
        battleAxe(recipeOutput, ModItems.CRADIUM_INGOT, ModItems.CRADIUM_BATTLE_AXE);

        dagger(recipeOutput, ModItems.NAUADIAN_INGOT, ModItems.NAUADIAN_DAGGER);
        dagger(recipeOutput, ModItems.ADRENA_INGOT, ModItems.ADRENA_DAGGER);
        dagger(recipeOutput, ModItems.CRADIUM_INGOT, ModItems.CRADIUM_DAGGER);

        arrow(recipeOutput, ModItems.NAUADIAN_NUGGET, ModItems.NAUADIAN_ARROW);
        arrow(recipeOutput, ModItems.ADRENA_NUGGET, ModItems.ADRENA_ARROW);
        arrow(recipeOutput, ModItems.CRADIUM_NUGGET, ModItems.CRADIUM_ARROW);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NAUADIAN_SHARD, 9)
                .requires(ModBlocks.NAUADIAN_SHARD_BLOCK)
                .unlockedBy("has_nauadian_shard_block", has(ModBlocks.NAUADIAN_SHARD_BLOCK))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ADRENA, 9)
                .requires(ModBlocks.RAW_ADRENA_BLOCK)
                .unlockedBy("has_raw_adrena_block", has(ModBlocks.RAW_ADRENA_BLOCK))
                .save(recipeOutput);

        List<ItemLike> cradiumScrapSmeltables = List.of(ModBlocks.CRADIUM_ORE);
        oreSmelting(recipeOutput, cradiumScrapSmeltables, RecipeCategory.MISC, ModItems.CRADIUM_SCRAP,2.0F, 600, "cradium_scrap");
        oreBlasting(recipeOutput, cradiumScrapSmeltables, RecipeCategory.MISC, ModItems.CRADIUM_SCRAP,2.0F, 300, "cradium_scrap");

        List<ItemLike> nauadianIngotSmeltables = List.of(ModItems.NAUADIAN_SHARD);
        oreSmelting(recipeOutput, nauadianIngotSmeltables, RecipeCategory.MISC, ModItems.NAUADIAN_INGOT,1.0F, 200, "nauadian_ingot");
        oreBlasting(recipeOutput, nauadianIngotSmeltables, RecipeCategory.MISC, ModItems.NAUADIAN_INGOT,1.0F, 100, "nauadian_ingot");

        List<ItemLike> adrenaIngotSmeltables = List.of(ModBlocks.ADRENA_ORE, ModBlocks.DEEPSLATE_ADRENA_ORE, ModItems.RAW_ADRENA);
        oreSmelting(recipeOutput, adrenaIngotSmeltables, RecipeCategory.MISC, ModItems.ADRENA_INGOT,1.0F, 200, "adrena_ingot");
        oreBlasting(recipeOutput, adrenaIngotSmeltables, RecipeCategory.MISC, ModItems.ADRENA_INGOT,1.0F, 100, "adrena_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CRADIUM_INGOT)
                .group("cradium_ingot")
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.CRADIUM_SCRAP)
                .unlockedBy("has_cradium_scrap", has(ModItems.CRADIUM_SCRAP)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REINFORCED_STICK, 4)
                .group("reinforced_stick")
                .pattern(" # ")
                .pattern("#X#")
                .pattern(" # ")
                .define('#', Items.STICK)
                .define('X', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);
    }

    protected static void longSword(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("X#X")
                .define('#', ModItems.REINFORCED_STICK)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void scythe(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("XXX")
                .pattern(" #X")
                .pattern(" # ")
                .define('#', ModItems.REINFORCED_STICK)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void battleAxe(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("XXX")
                .pattern("X#X")
                .pattern(" # ")
                .define('#', ModItems.REINFORCED_STICK)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void dagger(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern(" X ")
                .pattern(" # ")
                .define('#', ModItems.REINFORCED_STICK)
                .define('X', material)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void arrow(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike material, @NotNull ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result, 4)
                .pattern("X")
                .pattern("#")
                .pattern("Y")
                .define('#', Items.STICK)
                .define('X', material)
                .define('Y', Items.FEATHER)
                .unlockedBy("has_feather", has(Items.FEATHER))
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput);
    }

    protected static void ingotBlockNuggetSet(@NotNull RecipeOutput recipeOutput, @NotNull ItemLike ingot, @NotNull ItemLike block, @NotNull ItemLike nugget) {
        // Ingot from block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
                .group(getItemName(ingot))
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(recipeOutput, Cradia.MOD_ID + ":" + getItemName(ingot) + "_from_" + getItemName(block));
        // Ingot from nugget
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
                .group(getItemName(ingot))
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', nugget)
                .unlockedBy(getHasName(nugget), has(nugget))
                .save(recipeOutput, Cradia.MOD_ID + ":" + getItemName(ingot) + "_from_nuggets");
        // Block from ingots
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
        // Nugget from ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
                .requires(ingot)
                .unlockedBy(getHasName(ingot), has(ingot))
                .save(recipeOutput);
    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group, String recipeName) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Cradia.MOD_ID + ":" + getItemName(result) + recipeName + "_" + getItemName(itemlike));
        }
    }
}
