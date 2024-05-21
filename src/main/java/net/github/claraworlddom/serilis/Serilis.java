package net.github.claraworlddom.serilis;

import net.github.claraworlddom.serilis.common.blocks.SerilisBlocks;
import net.github.claraworlddom.serilis.common.items.SerilisItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
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
    }
}
