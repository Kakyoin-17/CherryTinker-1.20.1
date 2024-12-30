package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;
import static net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(NEEDS_IRON_TOOL).add(ModBlocks.egoldblock.get());
        tag(NEEDS_IRON_TOOL).add(ModBlocks.cherrygemore.get());
        tag(NEEDS_IRON_TOOL).add(ModBlocks.deepslatecherrygemore.get());
        tag(MINEABLE_WITH_PICKAXE).add(ModBlocks.egoldblock.get());
        tag(MINEABLE_WITH_PICKAXE).add(ModBlocks.cherrygemore.get());
        tag(MINEABLE_WITH_PICKAXE).add(ModBlocks.deepslatecherrygemore.get());
    }
}
