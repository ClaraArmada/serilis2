package net.github.claraworlddom.serilis.common.events;

import net.github.claraworlddom.serilis.Serilis;
import net.github.claraworlddom.serilis.common.ModSounds;
import net.github.claraworlddom.serilis.common.items.SerilisItems;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;

@EventBusSubscriber(modid = Serilis.MODID, bus = EventBusSubscriber.Bus.GAME)
public final class ItemEventHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemstack = event.getItemStack();
        Item item = itemstack.getItem();

        if (item == Items.RAW_COPPER || item == Items.RAW_COPPER_BLOCK || item == Items.COPPER_BLOCK) {
            event.getToolTip().add(Component.translatable("item.serilis.atomicsymbol.copper"));
        } else if (item == Items.RAW_IRON || item == Items.RAW_IRON_BLOCK || item == Items.IRON_BLOCK) {
            event.getToolTip().add(Component.translatable("item.serilis.atomicsymbol.iron"));
        } else if (item == Items.RAW_GOLD || item == Items.RAW_GOLD_BLOCK || item == Items.GOLD_BLOCK) {
            event.getToolTip().add(Component.translatable("item.serilis.atomicsymbol.gold"));
        }

    }

    //////////////////////////////////////

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return;

        // WATTLE AND DAUB
        /*
        if (blockState.getBlock() == SerilisItems.WATTLE.get()) {
            Item heldItem = event.getItemStack().getItem();
            Level world = event.getLevel();

            if (heldItem == ItemInit.DAUB.get()) {
                BlockState newBlockState = BlockInit.WATTLE_AND_DAUB.get().defaultBlockState();
                world.setBlockAndUpdate(event.getPos(), newBlockState);
                ItemStack stack = event.getItemStack();
                stack.shrink(1);

                world.playSound(null, blockPos, SoundEvents.MUD_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }

        */
    }

    //////////////////////////////////////

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if (event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        ItemStack mainHandStack = player.getMainHandItem();
        ItemStack offHandStack = player.getOffhandItem();
        Item mainHandItem = mainHandStack.getItem();
        Item offHandItem = offHandStack.getItem();

        boolean mainHandBoneOffHandRock = mainHandItem == Items.BONE && offHandItem == SerilisItems.ROCK.get();
        boolean offHandBoneMainHandRock = offHandItem == Items.BONE && mainHandItem == SerilisItems.ROCK.get();

        // SHARPEN BONE

        if (mainHandBoneOffHandRock || offHandBoneMainHandRock) {
            player.getInventory().add(new ItemStack(SerilisItems.SHARP_BONE.get()));

            if (mainHandBoneOffHandRock) {
                mainHandStack.shrink(1);
                if (mainHandStack.isEmpty()) {
                    player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                }
            } else {
                offHandStack.shrink(1);
                if (offHandStack.isEmpty()) {
                    player.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
                }
            }

            // Play the sound effect
            event.getLevel().playSound(null, player.blockPosition(), ModSounds.ROCKS_HITTING.get(), SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }
}
