package net.github.claraworlddom.serilis.common.world;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.github.claraworlddom.serilis.common.blocks.SerilisBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SLChunkGenerator extends ChunkGenerator {

    public static final MapCodec<SLChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            BiomeSource.CODEC.fieldOf("biome_source").forGetter((c) -> c.biomeSource), // may need to change later
            NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(c -> c.noiseSettings)
    ).apply(instance, instance.stable(SLChunkGenerator::new)));

    private Holder<NoiseGeneratorSettings> noiseSettings;

    public SLChunkGenerator(BiomeSource biomeSource, Holder<NoiseGeneratorSettings> noiseSettings) {
        super(biomeSource);
        this.noiseSettings = noiseSettings;
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public int getBaseHeight(int i, int i1, Heightmap.Types type, LevelHeightAccessor level, RandomState random) {
        return level.getMinBuildHeight();
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor level, RandomState random) {
        // Create a basic array of block states for the column
        BlockState[] states = new BlockState[level.getHeight()];

        // Fill the array with basic blocks
        for (int y = level.getMinBuildHeight(); y < level.getMaxBuildHeight(); y++) {
            if (y < 0) {
                states[y - level.getMinBuildHeight()] = SerilisBlocks.LIMESTONE.get().defaultBlockState();
            } else if (y < 5) {
                states[y - level.getMinBuildHeight()] = Blocks.DIRT.defaultBlockState();
            } else {
                states[y - level.getMinBuildHeight()] = Blocks.AIR.defaultBlockState();
            }
        }

        return new NoiseColumn(level.getMinBuildHeight(), states);

    }

    @Override
    public void addDebugScreenInfo(List<String> list, RandomState random, BlockPos pos) {

    }

    @Override
    public void buildSurface(WorldGenRegion worldGenRegion, StructureManager structureManager, RandomState randomState, ChunkAccess chunkAccess) {

    }

    @Override
    public void applyCarvers(WorldGenRegion worldGenRegion, long l, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carving) {

    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender blender, RandomState random, StructureManager structure, ChunkAccess chunkAccess) {
        // Get the chunk coordinates
        ChunkPos chunkPos = chunkAccess.getPos();

        // Iterate through each x,z coordinate in the chunk
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                // Get absolute coordinates
                int absX = chunkPos.getMinBlockX() + x;
                int absZ = chunkPos.getMinBlockZ() + z;

                // Generate terrain for this column
                for (int y = chunkAccess.getMinBuildHeight(); y < chunkAccess.getMaxBuildHeight(); y++) {
                    BlockPos pos = new BlockPos(absX, y, absZ);

                    // Basic terrain generation
                    if (y < 0) {
                        chunkAccess.setBlockState(pos, SerilisBlocks.LIMESTONE.get().defaultBlockState(), false);
                    } else if (y < 5) {
                        chunkAccess.setBlockState(pos, Blocks.DIRT.defaultBlockState(), false);
                    }
                }
            }
        }

        return CompletableFuture.completedFuture(chunkAccess);
    }

    @Override
    public int getGenDepth() {
        return 384;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion worldGenRegion) {
    }

}