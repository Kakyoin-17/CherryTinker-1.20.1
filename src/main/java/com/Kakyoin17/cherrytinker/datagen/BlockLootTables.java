package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.custom.CherryBush;
import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import com.Kakyoin17.cherrytinker.registry.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class BlockLootTables extends VanillaBlockLoot {
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream()
                .flatMap(RegistryObject::stream)
                ::iterator;
    }
    public void generate(){
        dropSelf(ModBlocks.egoldblock.get());

        add(ModBlocks.cherrygemore.get(),(block -> createOreDrop(block,ModItems.CherryGem.get())));
        add(ModBlocks.deepslatecherrygemore.get(),(block -> createOreDrop(block,ModItems.CherryGem.get())));
        add(ModBlocks.cherrybush.get(),(block -> applyExplosionDecay(ModBlocks.cherrybush.get(),LootTable.lootTable()
                .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.cherrybush.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBush.AGE,3))).add(LootItem.lootTableItem(ModItems.Cherry.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F,3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                .withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.cherrybush.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CherryBush.AGE,2))).add(LootItem.lootTableItem(ModItems.Cherry.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F,2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))))));

    }

}
