package com.Kakyoin17.cherrytinker.world.feature;

import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModConfigureFeature {
    //注册key
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_CHERRYGEM_ORE_KEY = registerKey("cherrygem_ore_key");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        //矿物生成替换规则
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);
        //矿物生成替换列表
        List<OreConfiguration.TargetBlockState> overworldCherryGemOres = List.of(
                OreConfiguration.target(stoneReplaceables,ModBlocks.cherrygemore.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables,ModBlocks.deepslatecherrygemore.get().defaultBlockState()));
        //注册
        register(context,OVERWORLD_CHERRYGEM_ORE_KEY,Feature.ORE,new OreConfiguration(overworldCherryGemOres,7));//每矿脉矿物数量

    }










    //方法
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MODID,name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature(feature, configuration));
    }
}
