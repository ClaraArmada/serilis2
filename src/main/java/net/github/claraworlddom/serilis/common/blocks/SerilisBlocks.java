package net.github.claraworlddom.serilis.common.blocks;

import net.github.claraworlddom.serilis.Serilis;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SerilisBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Serilis.MODID);

    public static final Supplier<Block> ROCK = BLOCKS.register("rock",
            () -> new RockModel(BlockBehaviour.Properties.of().sound(SoundType.STONE).dynamicShape().noOcclusion()));

    public static final Supplier<Block> TWIG = BLOCKS.register("twig",
            () -> new TwigModel(BlockBehaviour.Properties.of().sound(SoundType.WOOD).dynamicShape().noOcclusion()));

    public static final Supplier<Block> DRIFTWOOD = BLOCKS.register("driftwood",
            () -> new DriftwoodModel(BlockBehaviour.Properties.of().sound(SoundType.WOOD).dynamicShape().noOcclusion()));

    public static final Supplier<Block> SWITCHGRASS = BLOCKS.register("switchgrass",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY)
            )
    );
}
