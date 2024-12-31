package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModBlockModelGen extends BlockStateProvider {
    public ModBlockModelGen(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }
    //添加
    @Override
    protected void registerStatesAndModels() {
        this.registerBlockModelAndItem(ModBlocks.egoldblock.get());
        this.registerBlockModelAndItem(ModBlocks.cherrygemore.get());
        this.registerBlockModelAndItem(ModBlocks.deepslatecherrygemore.get());
    }
    //方法
    public void registerBlockModelAndItem(Block block){
        this.simpleBlockWithItem(block,this.cubeAll(block));
    }
}
