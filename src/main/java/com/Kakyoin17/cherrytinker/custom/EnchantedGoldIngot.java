package com.Kakyoin17.cherrytinker.custom;

import com.Kakyoin17.cherrytinker.until.RainbowText;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class EnchantedGoldIngot extends Item {
    public EnchantedGoldIngot(Properties pProperties) {
        super(pProperties);
    }
    //具有附魔光效
    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack itemStack) {
        return true;
    }
    //为名字添加动态颜色效果
    @Override
    public Component getName(ItemStack pStack) {
        var com = Component.translatable(this.getDescriptionId(pStack));
        return Component.literal(RainbowText.makeColour17(com.getString()));
    }
}
