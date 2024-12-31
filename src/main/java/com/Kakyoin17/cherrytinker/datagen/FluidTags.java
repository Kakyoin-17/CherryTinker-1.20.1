package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluid;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.concurrent.CompletableFuture;

public class FluidTags extends FluidTagsProvider {

    public FluidTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, pProvider);
    }
    //增加流体tag
    protected void addTags(HolderLookup.Provider pProvider){
        this.tagLocal(ModFluids.cherryjuice);

        this.tagLocal(ModFluids.moltenCherrygem);
        this.tagLocal(ModFluids.moltenEnchantedgold);

        this.tagLocal(ModFluids.mooncherryfuel);
        this.tagLocal(ModFluids.suncherryfuel);
    }

    private void tagLocal(FlowingFluidObject<?> fluid) {
        this.tag(fluid.getLocalTag()).add(new Fluid[]{fluid.getStill(), fluid.getFlowing()});
    }
    private void tagAll(FlowingFluidObject<?> fluid) {
        this.tagLocal(fluid);
        this.tag(fluid.getForgeTag()).addTag(fluid.getLocalTag());
    }
    private void tagForge(FluidObject<?> fluid) {
        this.tag(fluid.getForgeTag()).add(fluid.get());
    }
}
