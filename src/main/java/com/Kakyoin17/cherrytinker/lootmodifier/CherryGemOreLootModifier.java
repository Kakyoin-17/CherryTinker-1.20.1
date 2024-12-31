package com.Kakyoin17.cherrytinker.lootmodifier;

import com.Kakyoin17.cherrytinker.registry.ModItems;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CherryGemOreLootModifier extends LootModifier {

    public CherryGemOreLootModifier(LootItemCondition[] conditionsIn, int num) {
        super(conditionsIn);
        this.num = num;
    }

    private final int num;

    public static final Supplier<Codec<CherryGemOreLootModifier>> CODEC = Suppliers.memoize(
            ()-> RecordCodecBuilder.create(
                    instance -> codecStart(instance).and(
                            Codec.INT.fieldOf("num").forGetter(
                                    m -> m.num
                            )
                    ).apply(instance, CherryGemOreLootModifier::new)
            )
    );

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> objectArrayList, LootContext lootContext) {
        objectArrayList.add(new ItemStack(ModItems.Cherry.get(),num));
        return objectArrayList;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
