package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import com.Kakyoin17.cherrytinker.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModRecipesGen extends RecipeProvider {
    public ModRecipesGen(PackOutput Output) {
        super(Output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //有序合成
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.egoldblock.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#',ModItems.EnchantedGoldIngot.get())
                .unlockedBy("has_egoldingot",has(ModItems.EnchantedGoldIngot.get()))
                .save(consumer);
        //无序合成(输入，产物数量，产物)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EnchantedGoldIngot.get(),9)
                .requires(ModBlocks.egoldblock.get())
                .unlockedBy("has_egoldblock",has(ModBlocks.egoldblock.get()))
                .save(consumer);
        //熔炉(输入，产物，获得经验，时间）
        oreSmelting(consumer, List.of(ModBlocks.cherrygemore.get(),ModBlocks.deepslatecherrygemore.get()),RecipeCategory.MISC,
                ModItems.CherryGem.get(),0.7f,200,"cherrytinker");
        //高炉(输入，产物，获得经验，时间）
        oreBlasting(consumer, List.of(ModBlocks.cherrygemore.get(),ModBlocks.deepslatecherrygemore.get()),RecipeCategory.MISC,
                ModItems.CherryGem.get(),0.7f,100,"cherrytinker");
    }
    //方法
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, new ResourceLocation(MODID,getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike)));
        }

    }
}
