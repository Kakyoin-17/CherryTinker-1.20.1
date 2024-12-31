package com.Kakyoin17.cherrytinker.datagen;

import com.Kakyoin17.cherrytinker.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModItemModelGen extends net.minecraftforge.client.model.generators.ItemModelProvider {
    //字段
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public ModItemModelGen(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }
    //添加
    @Override
    protected void registerModels() {
        itemGenerateModel(ModItems.MlyPotato.get(),resourceItem(itemName(ModItems.MlyPotato.get())));
        itemGenerateModel(ModItems.CherryJuiceBottle.get(),resourceItem(itemName(ModItems.CherryJuiceBottle.get())));
    }
    //方法
    public void itemGenerateModel(Item item, ResourceLocation texture){
        withExistingParent(itemName(item),GENERATED).texture("layer0",texture);
    }
    private String itemName (Item item){return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
    public ResourceLocation resourceBlock(String path){
        return new ResourceLocation(MODID,"block/" + path);
    }
    public ResourceLocation resourceItem(String path){
        return new ResourceLocation(MODID,"item/" + path);
    }

}
