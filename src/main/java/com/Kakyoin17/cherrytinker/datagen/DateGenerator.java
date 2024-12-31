package com.Kakyoin17.cherrytinker.datagen;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

@Mod.EventBusSubscriber(modid = MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DateGenerator {
    @SubscribeEvent
    public static void generate(GatherDataEvent event){
        var generator = event.getGenerator();
        var packoutput = generator.getPackOutput();
        var existingFileHelper = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(),new BlockTags(packoutput,lookupProvider,MODID,existingFileHelper));
        generator.addProvider(event.includeServer(),new LootTableProvider(packoutput,
                Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(
                        BlockLootTables::new,
                        LootContextParamSets.BLOCK))));
        generator.addProvider(event.includeServer(),new Recipes(packoutput));
        generator.addProvider(event.includeServer(),new GlobalLootModifier(packoutput,MODID));
        generator.addProvider(event.includeServer(),new FluidTags(packoutput,lookupProvider));

        generator.addProvider(event.includeClient(),new FluidBucketModelProvider(packoutput,MODID));
        generator.addProvider(event.includeClient(),new FluidTextureProvider(packoutput));
    }
}
