package net.github.claraworlddom.serilis.client.handler;

import net.github.claraworlddom.serilis.common.blocks.SerilisBlocks;
import net.github.claraworlddom.serilis.common.items.SerilisItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber (modid = "serilis", value = {Dist.CLIENT}, bus = EventBusSubscriber.Bus.MOD)
public class ColorHandler {
    public ColorHandler() {
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, tintIndex) -> {
            BlockState state = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, (BlockAndTintGetter)null, (BlockPos)null, tintIndex);
        }, SerilisItems.SWITCHGRASS.get());
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((state, blockAndTintGetter, pos, i) -> blockAndTintGetter != null && pos != null ? BiomeColors.getAverageGrassColor(blockAndTintGetter, state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos) : GrassColor.getDefaultColor(), (Block) SerilisBlocks.SWITCHGRASS.get());
    }
}
