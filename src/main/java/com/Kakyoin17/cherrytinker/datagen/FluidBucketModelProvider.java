package com.Kakyoin17.cherrytinker.datagen;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import slimeknights.mantle.data.GenericDataProvider;

import java.util.concurrent.CompletableFuture;
//流体桶的model生成
public class FluidBucketModelProvider extends GenericDataProvider {
    private final String modId;

    public FluidBucketModelProvider(PackOutput output, String modId) {
        super(output, PackOutput.Target.RESOURCE_PACK, "models/item");
        this.modId = modId;
    }
    private static JsonObject makeJson(BucketItem bucket) {
        JsonObject json = new JsonObject();
        json.addProperty("parent", "forge:item/bucket_drip");
        json.addProperty("loader", "tconstruct:fluid_container");
        json.addProperty("flip_gas", bucket.getFluid().getFluidType().isLighterThanAir());
        json.addProperty("fluid", BuiltInRegistries.FLUID.getKey(bucket.getFluid()).toString());
        return json;
    }

    public CompletableFuture<?> run(CachedOutput cache) {
        return allOf(BuiltInRegistries.ITEM.entrySet().stream().filter((entry) -> {
            return ((ResourceKey)entry.getKey()).location().getNamespace().equals(this.modId) && entry.getValue() instanceof BucketItem;
        }).map((entry) -> {
            return this.saveJson(cache, ((ResourceKey)entry.getKey()).location(), makeJson((BucketItem)entry.getValue()));
        }));
    }

    public String getName() {
        return this.modId + " Fluid Bucket Model Provider";
    }
}
