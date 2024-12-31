package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput Output) {
        super(Output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.egoldblock.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A',ModItems.EnchantedGoldIngot.get())
                .unlockedBy("has_egoldingot",has(ModItems.EnchantedGoldIngot.get()))
                .save(consumer);

    }
}
