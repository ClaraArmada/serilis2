package net.github.claraworlddom.serilis.common;

import net.github.claraworlddom.serilis.Serilis;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Serilis.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> ROCKS_HITTING = SOUND_EVENTS.register(
            "rocks_hitting",
            () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Serilis.MODID, "rocks_hitting"))
    );

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
