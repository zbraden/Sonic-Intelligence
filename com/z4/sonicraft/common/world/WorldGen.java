package com.z4.sonicraft.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

import com.z4.sonicraft.api.biome.BiomeGenDiamond;
import com.z4.sonicraft.common.utils.RegisterHelper;
import com.z4.sonicraft.common.world.SonicraftBiomeManager.TemperatureType;

public class WorldGen {
	
	public static BiomeGenBase biomeDiamond;
	
	public static BiomeGenBase onlyBiome = null;
	
	public static void init() {
		// Load World Generators
		//Register World Generators
		RegisterHelper.registerGen(new WorldGenBase(), 1);
		
		//BiomeGen
		registerBiomes();
		addBiomesToDictionary();
		addSpawnBiomes();
	}
	
	private static void addSpawnBiomes()
	{
		addSpawnBiome(biomeDiamond);

	}
	
	private static void registerBiomes()
	{
		biomeDiamond = registerOverworldBiome(BiomeGenDiamond.class, "Diamond", TemperatureType.ICY, 100);
	}

	private static void addBiomesToDictionary()
	{
        BiomeDictionary.registerBiomeType(biomeDiamond, Type.FROZEN, Type.MOUNTAIN);
	}
	
	private static BiomeGenBase registerOverworldBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName, int temperatureType, int weight)
	{
		if (SonicraftBiomeManager.overworldBiomes[temperatureType] == null) SonicraftBiomeManager.overworldBiomes[temperatureType] = new ArrayList();

		return SonicraftBiomeManager.createAndRegisterBiome(biomeClass, "Overworld", biomeName, SonicraftBiomeManager.overworldBiomes[temperatureType], weight);
	}
	
	public static void addSpawnBiome(BiomeGenBase biome)
	{
	    BiomeManager.addSpawnBiome(biome);
	}
}
