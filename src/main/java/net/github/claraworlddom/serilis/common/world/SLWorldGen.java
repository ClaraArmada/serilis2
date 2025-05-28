package net.github.claraworlddom.serilis.common.world;

import com.mojang.serialization.MapCodec;
import net.github.claraworlddom.serilis.Serilis;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class SLWorldGen {
    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATOR = DeferredRegister.create(Registries.CHUNK_GENERATOR, Serilis.MODID);

    static
    {
        CHUNK_GENERATOR.register("terran", () -> SLChunkGenerator.CODEC);
    }
}
