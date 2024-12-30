package com.Kakyoin17.cherrytinker.registry;

import com.Kakyoin17.cherrytinker.custom.CherryBush;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.Kakyoin17.cherrytinker.CherryTinker.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,MODID);
    //Block
    public static final RegistryObject<Block> egoldblock = BLOCKS.register("egold_block",()-> new Block(BlockBehaviour.Properties.of()
            .strength(6f,3600000F).requiresCorrectToolForDrops().lightLevel(value -> 15)));
    //Ore
    public static final RegistryObject<Block> cherrygemore =BLOCKS.register("cherrygem_ore",()-> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .strength(3.0F,3.0F).requiresCorrectToolForDrops(), UniformInt.of(3,17)));
    public static final RegistryObject<Block> deepslatecherrygemore =BLOCKS.register("deepslate_cherrygem_ore",()-> new DropExperienceBlock(BlockBehaviour.Properties.of()
            .strength(4.5F,3.0F).requiresCorrectToolForDrops(), UniformInt.of(3,17)));
    //Plant
    public static final RegistryObject<Block> cherrybush = BLOCKS.register("cherry_bush",()->new CherryBush(BlockBehaviour.Properties.of()
            .randomTicks().noCollission().sound(SoundType.SWEET_BERRY_BUSH)));

    public static void register(IEventBus eventBus){BLOCKS.register(eventBus);}
}
