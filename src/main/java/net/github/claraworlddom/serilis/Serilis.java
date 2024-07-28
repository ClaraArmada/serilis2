package net.github.claraworlddom.serilis;

import net.github.claraworlddom.serilis.common.ModSounds;
import net.github.claraworlddom.serilis.common.blocks.SerilisBlocks;
import net.github.claraworlddom.serilis.common.items.SerilisItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.fml.common.Mod;

@Mod(Serilis.MODID)
public class Serilis
{
    public static final String MODID = "serilis";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Serilis(IEventBus bus, ModContainer container) {
        SerilisBlocks.BLOCKS.register(bus);

        SerilisItems.ITEMS.register(bus);

        bus.addListener(this::addCreative);

        ModSounds.register(bus);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(SerilisItems.ROCK.get());
            event.accept(SerilisItems.TWIG.get());
            event.accept(SerilisItems.DRIFTWOOD.get());
            event.accept(SerilisItems.OAK_BOARD.get());
            event.accept(SerilisItems.SPRUCE_BOARD.get());
            event.accept(SerilisItems.BIRCH_BOARD.get());
            event.accept(SerilisItems.JUNGLE_BOARD.get());
            event.accept(SerilisItems.ACACIA_BOARD.get());
            event.accept(SerilisItems.DARK_OAK_BOARD.get());
            event.accept(SerilisItems.MANGROVE_BOARD.get());
            event.accept(SerilisItems.CRIMSON_BOARD.get());
            event.accept(SerilisItems.WARPED_BOARD.get());
            event.accept(SerilisItems.CHERRY_BOARD.get());
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(SerilisItems.SHARP_BONE.get());
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(SerilisItems.SWITCHGRASS.get());
        }
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
