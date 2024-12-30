package com.Kakyoin17.cherrytinker;

import com.Kakyoin17.cherrytinker.datagen.GlobalLootModifier;
import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import com.Kakyoin17.cherrytinker.registry.ModCreativeModeTabs;
import com.Kakyoin17.cherrytinker.registry.ModItems;
import com.Kakyoin17.cherrytinker.registry.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(CherryTinker.MODID)
public class CherryTinker
{
    public static final String MODID = "cherrytinker";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CherryTinker()
    {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(bus);
        ModBlocks.register(bus);
        ModCreativeModeTabs.register(bus);
        ModLootModifiers.register(bus);
    }

}
