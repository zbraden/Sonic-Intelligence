package com.z4.sonicraft.api.biome.layers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

import com.z4.sonicraft.common.world.SonicraftBiomeManager;
import com.z4.sonicraft.common.world.WorldGen;

public class GenLayerBiomeSound extends GenLayerBiome
{
	//Desert, Warm, Cool, Icy
	public List<BiomeEntry>[] biomeLists = new ArrayList[] { new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList() };

	public GenLayerBiomeSound(long seed, GenLayer parentLayer, WorldType worldType) 
	{
		super(seed, parentLayer, worldType);

		this.biomeLists[0].addAll(SonicraftBiomeManager.overworldBiomes[0]);
		//this.biomeLists[1].addAll(SonicraftBiomeManager.overworldBiomes[1]);
		//this.biomeLists[2].addAll(SonicraftBiomeManager.overworldBiomes[2]);
		//this.biomeLists[3].addAll(SonicraftBiomeManager.overworldBiomes[3]);

		//this.biomeLists[0].addAll(BiomeManager.desertBiomes);
		//this.biomeLists[1].addAll(BiomeManager.warmBiomes);
		//this.biomeLists[2].addAll(BiomeManager.coolBiomes);
		//this.biomeLists[3].addAll(BiomeManager.icyBiomes);

        //this.biomeLists[0].add(new BiomeEntry(BiomeGenBase.desert, 30));
        //this.biomeLists[0].add(new BiomeEntry(BiomeGenBase.savanna, 20));
        //this.biomeLists[0].add(new BiomeEntry(BiomeGenBase.plains, 10));
	}

    @Override
	public int[] getInts(int x, int z, int width, int length)
    {
        int[] inputBiomeIDs = this.parent.getInts(x, z, width, length);
        int[] outputBiomeIDs = IntCache.getIntCache(width * length);

        for (int i1 = 0; i1 < length; ++i1)
        {
            for (int j1 = 0; j1 < width; ++j1)
            {
                this.initChunkSeed((long)(j1 + x), (long)(i1 + z));
                int currentBiomeID = inputBiomeIDs[j1 + i1 * width];
                //   				111100000000
                int l1 = (currentBiomeID & 3840) >> 8;
                currentBiomeID &= -3841;
                
                if (WorldGen.onlyBiome != null)
                {
                	outputBiomeIDs[j1 + i1 * width] = WorldGen.onlyBiome.biomeID;
                	continue;
                }
                
                if (isBiomeOceanicAndEnabled(currentBiomeID))
                {
                    outputBiomeIDs[j1 + i1 * width] = currentBiomeID;
                }
                else if (currentBiomeID == BiomeGenBase.mushroomIsland.biomeID)
                {
                    outputBiomeIDs[j1 + i1 * width] = currentBiomeID;
                }
                else if (currentBiomeID == 1)
                {
                    if (l1 > 0)
                    {
                        outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromList(0);
                    }
                    else
                    {
                        outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromList(0);
                    }
                }
                else if (currentBiomeID == 2)
                {
                    if (l1 > 0)
                    {
                        outputBiomeIDs[j1 + i1 * width] = BiomeGenBase.jungle.biomeID;
                    }
                    else
                    {
                        outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromList(1);
                    }
                }
                else if (currentBiomeID == 3)
                {
                    if (l1 > 0)
                    {
                        outputBiomeIDs[j1 + i1 * width] = BiomeGenBase.megaTaiga.biomeID;
                    }
                    else
                    {
                        outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromList(2);
                    }
                }
                else if (currentBiomeID == 4)
                {
                    outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromList(3);
                }
                else
                {
                	outputBiomeIDs[j1 + i1 * width] = getBiomeIdFromMixedList();
                }
            }
        }

        return outputBiomeIDs;
    }
    
    private int getBiomeIdFromList(int listId)
    {
    	if (!this.biomeLists[listId].isEmpty())
    	{
    		return getWeightedBiomeFromList(this.biomeLists[listId]);
    	}
    	else
    	{
    		return getBiomeIdFromMixedList(listId);
    	}
    }
    
    private int getBiomeIdFromMixedList(int... listIdExclusions)
    {
    	List listIdExclusionList = Arrays.asList(listIdExclusions);
		List<BiomeEntry> mixedBiomeList = new ArrayList<BiomeEntry>();

		for (int i = 0; i < 4; i++)
		{
			if (!listIdExclusionList.contains(i) && !this.biomeLists[i].isEmpty()) mixedBiomeList.addAll(this.biomeLists[i]);
		}

		if (!mixedBiomeList.isEmpty())
		{
			return getWeightedBiomeFromList(mixedBiomeList);
		}
		else
		{
    		throw new RuntimeException("No biomes are enabled!");
		}
    }
    
    private int getWeightedBiomeFromList(List<BiomeEntry> biomeList)
    {
    	return ((BiomeEntry)WeightedRandom.getItem(biomeList, (int)this.nextLong(WeightedRandom.getTotalWeight(biomeList) / 10) * 10)).biome.biomeID;
    }
    
    private boolean isBiomeOceanicAndEnabled(int biomeId)
    {
        return (biomeId == BiomeGenBase.ocean.biomeID || (biomeId == BiomeGenBase.deepOcean.biomeID) || (biomeId == BiomeGenBase.frozenOcean.biomeID));
    }
}
