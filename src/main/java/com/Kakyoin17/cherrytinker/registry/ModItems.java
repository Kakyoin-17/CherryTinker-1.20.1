package com.Kakyoin17.cherrytinker.registry;

import com.Kakyoin17.cherrytinker.custom.CherryGemItem;
import com.Kakyoin17.cherrytinker.custom.Egoldblockitem;
import com.Kakyoin17.cherrytinker.custom.EnchantedGoldIngot;
import com.Kakyoin17.cherrytinker.custom.EnchantedGoldenCarrotItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.fluids.item.ContainerFoodItem;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS,MODID);

    //Block item
    public static final RegistryObject<Item> egoldblockitem = ITEMS.register("egoldblockitem",()-> new Egoldblockitem(ModBlocks.egoldblock.get(),new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> cherrygemoreitem = ITEMS.register("cherrygemoreitem",()-> new BlockItem(ModBlocks.cherrygemore.get(),new Item.Properties()));
    public static final RegistryObject<Item> deepslatecherrygem_oreitem = ITEMS.register("deepslatecherrygemoreitem",()-> new BlockItem(ModBlocks.deepslatecherrygemore.get(),new Item.Properties()));
    //Food
    public static final RegistryObject<Item> Cherry = ITEMS.register("cherry",()-> new ItemNameBlockItem(ModBlocks.cherrybush.get(),
            new Item.Properties()
                    .food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(0.5f).alwaysEat().fast()
                    .build())));
    public static final RegistryObject<Item> CherryJuiceBottle = ITEMS.register("cherry_juice",()-> new ContainerFoodItem.FluidContainerFoodItem(
            new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(1.0f).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.HEAL,1,0),1.0F)
                    .build())
                    .craftRemainder(Items.GLASS_BOTTLE),()-> new FluidStack(ModFluids.cherryjuice.get(),250)));
    public static final RegistryObject<Item> EnchantedGoldenCarrot = ITEMS.register("enchanted_golden_carrot", ()->new EnchantedGoldenCarrotItem(
            new Item.Properties().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder()
                    .nutrition(10).saturationMod(2f).alwaysEat().fast()
                    .effect(new MobEffectInstance(MobEffects.NIGHT_VISION,18000,0),1.0F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,18000,0),1.0F)
                    .build())));
    //Material
    public static final RegistryObject<Item> CherryGem = ITEMS.register("cherrygem",()-> new CherryGemItem(new Item.Properties()));
    public static final RegistryObject<Item> EnchantedGoldIngot = ITEMS.register("enchantedgold_ingot", ()->new EnchantedGoldIngot(
                    new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> MlyPotato = ITEMS.register("mlypotato",()-> new Item(new Item.Properties()));













    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
