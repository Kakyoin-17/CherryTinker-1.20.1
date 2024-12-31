package com.Kakyoin17.cherrytinker.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    //1
    public static final RegistryObject<CreativeModeTab> CherryTinkerMainTab = CREATIVE_MODE_TABS.register("cherrytinkermaintab",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("CherryTinkerMain"))
                    .icon(()-> new ItemStack(ModItems.Cherry.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Cherry.get());
                        output.accept(ModItems.MlyPotato.get());
                        output.accept(ModItems.EnchantedGoldenCarrot.get());
                        output.accept(ModItems.EnchantedGoldIngot.get());
                        output.accept(ModItems.egoldblockitem.get());
                        output.accept(ModItems.CherryGem.get());
                        output.accept(ModItems.cherrygemoreitem.get());
                        output.accept(ModItems.deepslatecherrygem_oreitem.get());

                    })
                    .build());
    //2
    public static final RegistryObject<CreativeModeTab> CherryTinkerToolTab = CREATIVE_MODE_TABS.register("cherrytinkertooltab",
            ()-> CreativeModeTab.builder()
                    .title(Component.translatable("CherryTinkerTool"))
                    .icon(()->new ItemStack(ModItems.egoldblockitem.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.egoldblockitem.get());
                    })
                    .build());
    //Bus
    public static void register(IEventBus eventBus){CREATIVE_MODE_TABS.register(eventBus);}
}
