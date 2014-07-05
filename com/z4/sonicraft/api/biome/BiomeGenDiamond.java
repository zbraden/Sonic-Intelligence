package com.z4.sonicraft.api.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDiamond extends BiomeGenBase {

	public BiomeGenDiamond(int id) {
		super(id);
		//setBiomeName("Diamond");
		setColor(5470985);
		func_76733_a(5470985);
		setTemperatureRainfall(0.95F, 0.9F);
	}

	@Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
    }
}
