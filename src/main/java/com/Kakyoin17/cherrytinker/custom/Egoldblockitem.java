package com.Kakyoin17.cherrytinker.custom;

import com.Kakyoin17.cherrytinker.until.RainbowText;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Egoldblockitem extends BlockItem {
    public Egoldblockitem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack itemStack) {
        return true;
    }

    @Override
    public Component getName(ItemStack pStack) {
        var com = Component.translatable(this.getDescriptionId(pStack));
        return Component.literal(RainbowText.makeColour17(com.getString()));
    }
}
