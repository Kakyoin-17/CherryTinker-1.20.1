package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModFluids;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.TinkerFluids;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;
//流体model生成
public class FluidTextureProvider extends AbstractFluidTextureProvider {
    public FluidTextureProvider(PackOutput packOutput) {
        super(packOutput, MODID);
    }


    public void addTextures() {
        this.tintedStew(ModFluids.cherryjuice).color(0xFFFF626C);

        this.tintedMolten(ModFluids.moltenCherrygem).color(0xFFE22F3A);
        this.tintedMolten(ModFluids.moltenEnchantedgold).color(0xFFC97AC9);

        this.folder(ModFluids.mooncherryfuel,"fuel");
        this.folder(ModFluids.suncherryfuel,"fuel");

    }

    private FluidTexture.Builder root(FluidObject<?> fluid) {
        return this.texture(fluid).wrapId("fluid/", "/", false, false);
    }

    private FluidTexture.Builder folder(FluidObject<?> fluid, String folder) {
        return this.texture(fluid).wrapId("fluid/" + folder + "/", "/", false, false);
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return this.texture(fluid).textures(TConstruct.getResource("fluid/" + name + "/"), false, false);
    }

    private FluidTexture.Builder molten(FluidObject<?> fluid) {
        return this.named(fluid, "molten/" + TinkerFluids.withoutMolten(fluid));
    }
    //颜色代码覆盖生成
    private FluidTexture.Builder tintedStew(FluidObject<?> fluid) {
        return this.named(fluid, "food/stew");
    }

    private FluidTexture.Builder tintedStone(FluidObject<?> fluid) {
        return this.named(fluid, "molten/stone");
    }

    private FluidTexture.Builder tintedMolten(FluidObject<?> fluid) {
        return this.named(fluid, "molten");
    }



    public String getName() {
        return "Tinkers' Construct Fluid Texture Providers";
    }
}
