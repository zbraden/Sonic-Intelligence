package com.z4.sonicraft.common.world;

import java.util.ArrayList;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

import com.z4.sonicraft.api.biome.BiomeGenYucRidge;
import com.z4.sonicraft.api.biome.BiomeGenYucRiver;
import com.z4.sonicraft.api.biome.BiomeGenYucatan;
import com.z4.sonicraft.common.utils.RegisterHelper;

public class WorldGen {
	
	public static WorldTypeSound worldTypeSound;
	
	public static BiomeGenBase biomeDiamond;
	public static BiomeGenBase biomeYucRiver;
	public static BiomeGenBase biomeYucRidge;
	
	public static BiomeGenBase onlyBiome = null;
	
	public static void init() {
		// Load World Generators
		//Register World Generators
		RegisterHelper.registerGen(new WorldGenBase(), 1);
		
		//BiomeGen
		registerBiomes();
		addBiomesToDictionary();
		disableRivers();
		addSpawnBiomes();
	}
	
	private static void addSpawnBiomes()
	{
		addSpawnBiome(biomeDiamond);

	}
	
	private static void registerBiomes()
	{
		biomeDiamond = registerOverworldBiome(BiomeGenYucatan.class, "Yucatan", 0, 10);
		biomeYucRiver = registerOverworldRiverBiome(BiomeGenYucRiver.class, "Yucatan River", biomeDiamond);
		
		biomeYucRidge = registerOverworldSubBiome(BiomeGenYucRidge.class, "Yucatan Ridge", 10, biomeDiamond);
	}

	private static void addBiomesToDictionary()
	{
        BiomeDictionary.registerBiomeType(biomeDiamond, Type.FROZEN, Type.MOUNTAIN);
	}
	
	private static BiomeGenBase registerOverworldBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName, int temperatureType, int weight)
	{
		if (SonicraftBiomeManager.overworldBiomes[temperatureType] == null) SonicraftBiomeManager.overworldBiomes[temperatureType] = new ArrayList<BiomeEntry>();

		return SonicraftBiomeManager.createAndRegisterBiome(biomeClass, "Overworld", biomeName, SonicraftBiomeManager.overworldBiomes[temperatureType], weight);
	}
	
	private static BiomeGenBase registerOverworldSubBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName, int weight, BiomeGenBase...parents)
	{
		BiomeGenBase biome = SonicraftBiomeManager.createBiome(biomeClass, biomeName);

		if (biome != null)
		{
			BiomeEntry entry = new BiomeEntry(biome, weight);

			if (true)
			{
				for (BiomeGenBase parent : parents)
				{
					if (parent != null)
					{
						if (SonicraftBiomeManager.overworldSubBiomes[parent.biomeID] == null) SonicraftBiomeManager.overworldSubBiomes[parent.biomeID] = new ArrayList();

						SonicraftBiomeManager.overworldSubBiomes[parent.biomeID].add(entry);
					}
				}
			}

			return biome;
		}

		return null;
	}
	
	private static BiomeGenBase registerOverworldRiverBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName, BiomeGenBase...parents)
	{
		BiomeGenBase biome = SonicraftBiomeManager.createBiome(biomeClass, biomeName);

		if (biome != null)
		{
			if (true)
			{
				for (BiomeGenBase parent : parents)
				{
					if (parent != null)
					{
						SonicraftBiomeManager.overworldRiverBiomes[parent.biomeID] = biome;
					}
				}
			}
		}

		return null;
	}
	
	private static void disableRivers()
	{
		//disableRiver(biomeDiamond);
	}
	
	public static void addSpawnBiome(BiomeGenBase biome)
	{
		WorldChunkManager.allowedBiomes.clear();
	    BiomeManager.addSpawnBiome(biome);
	}
	
	private static void disableRiver(BiomeGenBase biome)
	{
		SonicraftBiomeManager.overworldRiverBiomes[biome.biomeID] = biome;
	}
	

}
