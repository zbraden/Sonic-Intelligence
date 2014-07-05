package com.z4.sonicraft.api.biome;

public class SonicraftOverworldBiome extends BiomeGen<SonicraftBiomeDecorator>{
	public SonicraftOverworldBiome(int biomeID) 
	{
		super(biomeID, SonicraftBiomeDecorator.class);
	}
}
