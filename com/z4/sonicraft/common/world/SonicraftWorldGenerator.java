package com.z4.sonicraft.common.world;

import java.util.Random;

import net.minecraft.world.World;

import com.z4.sonicraft.api.biome.BiomeGen;

public interface SonicraftWorldGenerator {
    public boolean generate(World world, Random random, int x, int y, int z);

    public void setupGeneration(World world, Random random, BiomeGen biome, String featureName, int x, int z);
}
