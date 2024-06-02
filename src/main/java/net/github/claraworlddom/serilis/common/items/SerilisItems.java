package net.github.claraworlddom.serilis.common.items;

import net.github.claraworlddom.serilis.Serilis;
import net.github.claraworlddom.serilis.common.blocks.SerilisBlocks;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SerilisItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Serilis.MODID);

    public static final Supplier<Item> SHARP_BONE = ITEMS.register("sharp_bone", () ->
            new SwordItem(ItemTiers.BONE, new Item.Properties().stacksTo(1)));

    public static final Supplier<Item> OAK_BOARD = ITEMS.register("boards/oak", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> SPRUCE_BOARD = ITEMS.register("boards/spruce", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> BIRCH_BOARD = ITEMS.register("boards/birch", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> JUNGLE_BOARD = ITEMS.register("boards/jungle", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> ACACIA_BOARD = ITEMS.register("boards/acacia", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_BOARD = ITEMS.register("boards/dark_oak", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> MANGROVE_BOARD = ITEMS.register("boards/mangrove", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> CRIMSON_BOARD = ITEMS.register("boards/crimson", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> WARPED_BOARD = ITEMS.register("boards/warped", () ->
            new Item(new Item.Properties()));
    public static final Supplier<Item> CHERRY_BOARD = ITEMS.register("boards/cherry", () ->
            new Item(new Item.Properties()));


    public static final Supplier<BlockItem> ROCK = ITEMS.registerSimpleBlockItem("rock", SerilisBlocks.ROCK);
    public static final Supplier<BlockItem> TWIG = ITEMS.registerSimpleBlockItem("twig", SerilisBlocks.TWIG);

}
