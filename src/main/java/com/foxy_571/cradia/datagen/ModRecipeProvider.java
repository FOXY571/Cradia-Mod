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
        // adrena_block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADRENA_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ADRENA_INGOT)
                .unlockedBy("has_adrena_ingot", has(ModItems.ADRENA_INGOT))
                .save(recipeOutput);

        // cradium_block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRADIUM_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CRADIUM_INGOT)
                .unlockedBy("has_cradium_ingot", has(ModItems.CRADIUM_INGOT))
                .save(recipeOutput);

        // adrena_long_sword
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ADRENA_LONG_SWORD)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("X#X")
                .define('#', Items.STICK)
                .define('X', ModItems.ADRENA_INGOT)
                .unlockedBy("has_adrena_ingot", has(ModItems.ADRENA_INGOT))
                .save(recipeOutput);

        // cradium_long_sword
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRADIUM_LONG_SWORD)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("X#X")
                .define('#', Items.STICK)
                .define('X', ModItems.CRADIUM_INGOT)
                .unlockedBy("has_cradium_ingot", has(ModItems.CRADIUM_INGOT))
                .save(recipeOutput);

        // adrena_arrow
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ADRENA_ARROW, 4)
                .pattern("X")
                .pattern("#")
                .pattern("Y")
                .define('#', Items.STICK)
                .define('X', ModItems.ADRENA_NUGGET)
                .define('Y', Items.FEATHER)
                .unlockedBy("has_adrena_nugget", has(ModItems.ADRENA_NUGGET))
                .save(recipeOutput);

        // cradium_arrow
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CRADIUM_ARROW, 4)
                .pattern("X")
                .pattern("#")
                .pattern("Y")
                .define('#', Items.STICK)
                .define('X', ModItems.CRADIUM_NUGGET)
                .define('Y', Items.FEATHER)
                .unlockedBy("has_cradium_nugget", has(ModItems.CRADIUM_NUGGET))
                .save(recipeOutput);

        // adrena_nugget
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADRENA_NUGGET, 9)
                .requires(ModItems.ADRENA_INGOT)
                .unlockedBy("has_adrena_ingot", has(ModItems.ADRENA_INGOT))
                .save(recipeOutput);

        // cradium_nugget
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRADIUM_NUGGET, 9)
                .requires(ModItems.CRADIUM_INGOT)
                .unlockedBy("has_cradium_ingot", has(ModItems.CRADIUM_INGOT))
                .save(recipeOutput);

        // adrena_ingot_from_nuggets
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ADRENA_INGOT)
                .group("adrena_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.ADRENA_NUGGET)
                .unlockedBy("has_adrena_nugget", has(ModItems.ADRENA_NUGGET))
                .save(recipeOutput, "cradia:adrena_ingot_from_nuggets");

        // adrena_ingot_from_adrena_block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADRENA_INGOT, 9)
                .group("adrena_ingot")
                .requires(ModBlocks.ADRENA_BLOCK)
                .unlockedBy("has_adrena_block", has(ModBlocks.ADRENA_BLOCK))
                .save(recipeOutput, "cradia:adrena_ingot_from_adrena_block");

        // cradim_scrap_from_smelting_cradium_ore & cradium_scrap_from_blasting_cradium_ore
        List<ItemLike> cradium_scrap_smeltables = List.of(ModBlocks.CRADIUM_ORE);
        oreSmelting(recipeOutput, cradium_scrap_smeltables, RecipeCategory.MISC, ModItems.CRADIUM_SCRAP,2.0f, 600, "cradium_scrap");
        oreBlasting(recipeOutput, cradium_scrap_smeltables, RecipeCategory.MISC, ModItems.CRADIUM_SCRAP,2.0f, 300, "cradium_scrap");

        // cradium_ingot
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CRADIUM_INGOT)
                .group("cradium_ingot")
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.CRADIUM_SCRAP)
                .unlockedBy("has_cradium_scrap", has(ModItems.CRADIUM_SCRAP)).save(recipeOutput);

        // cradium_ingot_from_nuggets
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CRADIUM_INGOT)
                .group("cradium_ingot")
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CRADIUM_NUGGET)
                .unlockedBy("has_cradium_nugget", has(ModItems.CRADIUM_NUGGET))
                .save(recipeOutput, "cradia:cradium_ingot_from_nuggets");

        // cradium_ingot_from_cradium_block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CRADIUM_INGOT, 9)
                .group("cradium_ingot")
                .requires(ModBlocks.CRADIUM_BLOCK)
                .unlockedBy("has_cradium_block", has(ModBlocks.CRADIUM_BLOCK))
                .save(recipeOutput, "cradia:cradium_ingot_from_cradium_block");
    }

    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(@NotNull RecipeOutput recipeOutput, RecipeSerializer<T> cookingSerializer, AbstractCookingRecipe.@NotNull Factory<T> factory,
                                                                       List<ItemLike> ingredients, @NotNull RecipeCategory category, @NotNull ItemLike result, float experience, int cookingTime, @NotNull String group, String recipeName) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Cradia.MOD_ID + ":" + getItemName(result) + recipeName + "_" + getItemName(itemlike));
        }
    }
}
