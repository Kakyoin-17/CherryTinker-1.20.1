package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.lootmodifier.CherryGemOreLootModifier;
import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class GlobalLootModifier extends GlobalLootModifierProvider {
    public GlobalLootModifier(PackOutput output, String modid) {
        super(output, modid);
    }

    @Override
    protected void start() {
        add("cherrygem_by_cherrygemore",new CherryGemOreLootModifier(
                new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.cherrygemore.get()).build(),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment
                                (new EnchantmentPredicate(Enchantments.BLOCK_FORTUNE, MinMaxBounds.Ints.atLeast(3)))).build()
                },3
        ));
    }
}
