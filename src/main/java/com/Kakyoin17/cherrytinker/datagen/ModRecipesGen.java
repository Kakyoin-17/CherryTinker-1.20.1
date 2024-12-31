package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import com.Kakyoin17.cherrytinker.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;

import java.util.List;
import java.util.function.Consumer;

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
}
