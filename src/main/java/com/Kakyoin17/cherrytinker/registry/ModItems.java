package com.Kakyoin17.cherrytinker.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =DeferredRegister.create(ForgeRegistries.ITEMS,MODID);
    //Food
    public static final RegistryObject<Item> Cherry = ITEMS.register("cherry",()-> new ItemNameBlockItem(ModBlocks.cherrybush.get(),
            new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationMod(0.5f).alwaysEat().fast().build())));
    //Block item
    public static final RegistryObject<Item> egoldblockitem = ITEMS.register("egoldblockitem",()-> new BlockItem(ModBlocks.egoldblock.get(),new Item.Properties()));
    public static final RegistryObject<Item> cherrygemoreitem = ITEMS.register("cherrygemoreitem",()-> new BlockItem(ModBlocks.cherrygemore.get(),new Item.Properties()));
    public static final RegistryObject<Item> deepslatecherrygem_oreitem = ITEMS.register("deepslatecherrygemoreitem",()-> new BlockItem(ModBlocks.deepslatecherrygemore.get(),new Item.Properties()));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
