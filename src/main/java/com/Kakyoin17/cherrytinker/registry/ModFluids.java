package com.Kakyoin17.cherrytinker.registry;


import com.Kakyoin17.cherrytinker.CherryTinker;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.block.BurningLiquidBlock;
import slimeknights.tconstruct.fluids.block.MobEffectLiquidBlock;

import javax.annotation.Nullable;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(MODID);

    private static FluidType.Properties cool() {
        return FluidType.Properties.create().sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).motionScale(0.0023333333333333335).canExtinguish(true);
    }
    private static FluidType.Properties cool(String name) {
        return cool().descriptionId(CherryTinker.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY);
    }

    private static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .descriptionId(CherryTinker.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).motionScale(0.0023333333333333335).canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType((BlockPathTypes)null);
    }
    //Food
    public static final FlowingFluidObject<ForgeFlowingFluid> cherryjuice = FLUIDS.register("cherry_juice").type(cool("cherry_juice")
            .temperature(233)).block(MapColor.COLOR_PINK,0).bucket().flowing();
    //Molten
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenCherrygem = FLUIDS.register("molten_cherrygem").type(hot("molten_cherrygem")
            .temperature(999).lightLevel(7)).block(BurningLiquidBlock.createBurning(MapColor.COLOR_RED,13,10,7.0F)).bucket().flowing();
    public static final FlowingFluidObject<ForgeFlowingFluid> moltenEnchantedgold =FLUIDS.register("molten_enchantedgold").type(hot("molten_enchantedgold")
            .temperature(1777).lightLevel(15)).block(MobEffectLiquidBlock.createEffect(MapColor.COLOR_PURPLE,15,
            ()-> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,100,3))).bucket().flowing();
    //Fuel
    public static  FlowingFluidObject<ForgeFlowingFluid> mooncherryfuel = FLUIDS.register("moon_cherryfuel").type(cool("moon_cherryfuel")
            .temperature(1499).lightLevel(7)).block(MobEffectLiquidBlock.createEffect(MapColor.COLOR_BLUE,7,
            ()-> new MobEffectInstance(MobEffects.FIRE_RESISTANCE,12000))).bucket().flowing();
    public static  FlowingFluidObject<ForgeFlowingFluid> suncherryfuel = FLUIDS.register("sun_cherryfuel").type(hot("sun_cherryfuel")
            .temperature(2333).lightLevel(15)).block(MobEffectLiquidBlock.createEffect(MapColor.COLOR_ORANGE,15,
            ()-> new MobEffectInstance(MobEffects.SATURATION,20,0))).bucket().flowing();





























    public static void register(IEventBus eventBus){FLUIDS.register(eventBus);}
}
