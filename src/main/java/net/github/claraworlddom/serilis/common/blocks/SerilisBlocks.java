package net.github.claraworlddom.serilis.common.blocks;

import net.github.claraworlddom.serilis.Serilis;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SerilisBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Serilis.MODID);

    public static final Supplier<Block> ROCK = BLOCKS.register("rock",
            () -> new RockModel(BlockBehaviour.Properties.of().sound(SoundType.STONE).dynamicShape().noOcclusion()));
}
