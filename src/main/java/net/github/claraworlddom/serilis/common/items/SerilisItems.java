package net.github.claraworlddom.serilis.common.items;

import net.github.claraworlddom.serilis.Serilis;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SerilisItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(
            Serilis.MODID);

    public static final Supplier<Item> SHARP_BONE = ITEMS.register("sharp_bone", () ->
            new SwordItem(ItemTiers.BONE, new Item.Properties().stacksTo(1)));
}
