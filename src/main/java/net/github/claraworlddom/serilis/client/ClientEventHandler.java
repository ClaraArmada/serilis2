package net.github.claraworlddom.serilis.client;

import net.github.claraworlddom.serilis.common.items.SerilisItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class ClientEventHandler {
    ItemBlockRenderTypes.setRenderLayer(SerilisItems.SWITCHGRASS.get(), RenderType.cutout());
}
