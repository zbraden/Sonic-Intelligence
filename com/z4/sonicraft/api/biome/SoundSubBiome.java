package com.z4.sonicraft.api.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class SoundSubBiome extends BiomeGenBase
{
	 /**Smaller numbers zoom in the noise field (biomes are less common)*/
	public double zoom;
	/**The strength the field must reach to replace the biome. Larger numbers result in smaller patches.*/
	public double threshold;

	public SoundSubBiome(int biomeID) 
	{
		super(biomeID);
	}
}
