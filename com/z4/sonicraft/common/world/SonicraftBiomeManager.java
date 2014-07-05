package com.z4.sonicraft.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

public class SonicraftBiomeManager {
	private static int nextBiomeId = 40;

	public static List<BiomeEntry>[] overworldBiomes = new ArrayList[4];

	public static BiomeGenBase createAndRegisterBiome(Class<? extends BiomeGenBase> biomeClass, String biomeType, String biomeName, List<BiomeEntry> biomeList, int weight)
	{
		BiomeGenBase biome = createBiome(biomeClass, biomeName);

		if (biome != null)
		{
			BiomeEntry entry = new BiomeEntry(biome, getConfiguredWeight(biome, biomeType, weight));
			biomeList.add(entry);
			return biome;
		}

		return null;
	}

	public static BiomeGenBase createBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName, int biomeId)
	{
		if (biomeId == -1) biomeId = getNextFreeBiomeId();

		if (biomeId != -1)
		{ 
			try
			{
				BiomeGenBase biome;
				biome = biomeClass.getConstructor(int.class).newInstance(biomeId).setBiomeName(biomeName);
				return biome;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return null;
	}

	public static BiomeGenBase createBiome(Class<? extends BiomeGenBase> biomeClass, String biomeName)
	{
		return createBiome(biomeClass, biomeName, -1);
	}

	public static int getNextFreeBiomeId()
	{
		for (int i = nextBiomeId; i < 256; i++)
		{
			if (BiomeGenBase.getBiomeGenArray()[i] != null) 
			{
				if (i == 255) throw new IllegalArgumentException("There are no more biome ids avaliable!");
				continue;
			}
			else
			{
				nextBiomeId = i + 1;
				return i;
			}
		}

		return -1;
	}

	private static int getConfiguredWeight(BiomeGenBase biome, String biomeType, int weight)
	{
		return 1;
	}

	public class TemperatureType
	{
		public static final int HOT = 0;
		public static final int WARM = 1;
		public static final int COOL = 2;
		public static final int ICY = 3;
	}
}
