package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.world.feature.ModBiomeModifiers;
import com.Kakyoin17.cherrytinker.world.feature.ModConfigureFeature;
import com.Kakyoin17.cherrytinker.world.feature.ModPlacedFeature;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

//世界生成信息
public class ModWorldGen extends DatapackBuiltinEntriesProvider {
    public ModWorldGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER,Set.of(MODID));
    }

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder ()
            .add(Registries.CONFIGURED_FEATURE, ModConfigureFeature::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeature::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

}
