package com.Kakyoin17.cherrytinker.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModPlacedFeature {
    //注册key
    public static final ResourceKey<PlacedFeature> CHERRYGEM_ORE_PLACED_KEY = createKey("cherrygem_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
    //注册feature
    register(context, CHERRYGEM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfigureFeature.OVERWORLD_CHERRYGEM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(16, //每区块矿脉数量
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));//平均分布(高度范围：底，高)

    }

    //方法
    private static ResourceKey<PlacedFeature> createKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE,new ResourceLocation(MODID,name));
    }

    private static void register (BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration,
                                  List<PlacementModifier> modifiers){
        context.register(key,new PlacedFeature(configuration,List.copyOf(modifiers)));
    }

    private static void register (BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> configuration,
                                  PlacementModifier... modifiers){
        register(context,key,configuration,List.of(modifiers));
    }
}
