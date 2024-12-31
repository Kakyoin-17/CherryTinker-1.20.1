package com.Kakyoin17.cherrytinker.registry;

import com.Kakyoin17.cherrytinker.lootmodifier.CherryGemOreLootModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,MODID);
    //Block Loot
    public static final RegistryObject<Codec<CherryGemOreLootModifier>> cherrygemorelootmodifier = GLOBAL_LOOT_MODIFIER.register("cherry_by_cherrygemore",CherryGemOreLootModifier.CODEC);

    public static void register(IEventBus eventBus) {GLOBAL_LOOT_MODIFIER.register(eventBus);}
}
