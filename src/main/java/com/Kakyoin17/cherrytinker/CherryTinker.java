package com.Kakyoin17.cherrytinker;

import com.Kakyoin17.cherrytinker.datagen.GlobalLootModifier;
import com.Kakyoin17.cherrytinker.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(CherryTinker.MODID)
public class CherryTinker
{
    public static final String MODID = "cherrytinker";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CherryTinker(FMLJavaModLoadingContext context)
    {
        var bus = context.getModEventBus();
        ModItems.register(bus);
        ModBlocks.register(bus);
        ModFluids.register(bus);
        ModCreativeModeTabs.register(bus);
        ModLootModifiers.register(bus);

    }

    public static String makeDescriptionId(String type,String name){
        return type + ".cherrytinker" + name;
    }
}
