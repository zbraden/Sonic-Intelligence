package com.z4.sonicraft.common.world.generation;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.z4.sonicraft.common.world.SonicraftWorldGenerator;

public abstract class ForcedFeature implements SonicraftWorldGenerator
{
    private WorldGenerator worldGenerator;

    public ForcedFeature(WorldGenerator worldGenerator)
    {
        this.worldGenerator = worldGenerator;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z)
    {
        return worldGenerator.generate(world, random, x, y, z);
    }
}
