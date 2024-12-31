package com.Kakyoin17.cherrytinker.world.feature;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModBiomeModifiers {
    //注册key
    public static final ResourceKey<BiomeModifier> ADD_CHERRYGEM_ORE = registerKey("add_cherrygem_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        //注册
        context.register(ADD_CHERRYGEM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),//生成群系
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeature.CHERRYGEM_ORE_PLACED_KEY)),//所有feature
                GenerationStep.Decoration.UNDERGROUND_ORES));//世界生成阶段
    }















    //方法
    private static ResourceKey<BiomeModifier> registerKey(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,new ResourceLocation(MODID,name));
    }
}
