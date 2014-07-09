package com.z4.sonicraft.api.biome.layers;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.IntCache;

import com.z4.sonicraft.common.world.SonicraftBiomeManager;
import com.z4.sonicraft.common.world.WorldGen;

public class GenLayerRiverMixSound extends GenLayerRiverMix{
	 private GenLayer biomePatternGeneratorChain;
	    private GenLayer riverPatternGeneratorChain;

	    public GenLayerRiverMixSound(long seed, GenLayer biomePatternGeneratorChain, GenLayer riverPatternGeneratorChain)
	    {
	        super(seed, biomePatternGeneratorChain, riverPatternGeneratorChain);
	        
	        this.biomePatternGeneratorChain = biomePatternGeneratorChain;
	        this.riverPatternGeneratorChain = riverPatternGeneratorChain;
	    }

	    @Override
		public void initWorldGenSeed(long seed)
	    {
	        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
	        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
	        super.initWorldGenSeed(seed);
	    }

	    @Override
		public int[] getInts(int x, int z, int width, int length)
	    {
	        int[] inputBiomeIds = this.biomePatternGeneratorChain.getInts(x, z, width, length);
	        int[] riverBiomeIds = this.riverPatternGeneratorChain.getInts(x, z, width, length);
	        int[] outputBiomeIds = IntCache.getIntCache(width * length);

	        for (int i1 = 0; i1 < width * length; ++i1)
	        {
	            if (inputBiomeIds[i1] != BiomeGenBase.ocean.biomeID && inputBiomeIds[i1] != BiomeGenBase.deepOcean.biomeID)
	            {
	                if (riverBiomeIds[i1] == BiomeGenBase.river.biomeID)
	                {
	                    /*if (inputBiomeIds[i1] == BiomeGenBase.icePlains.biomeID || inputBiomeIds[i1] == BOPCBiomes.alps.biomeID || inputBiomeIds[i1] == BOPCBiomes.alpsForest.biomeID || inputBiomeIds[i1] == BOPCBiomes.arctic.biomeID || inputBiomeIds[i1] == BOPCBiomes.glacier.biomeID || inputBiomeIds[i1] == BOPCBiomes.frostForest.biomeID || inputBiomeIds[i1] == BOPCBiomes.snowyConiferousForest.biomeID)
	                    {
	                        outputBiomeIds[i1] = BiomeGenBase.frozenRiver.biomeID;
	                    }*/
	                    if (SonicraftBiomeManager.overworldRiverBiomes[inputBiomeIds[i1]] != null)
	                    {
	                        outputBiomeIds[i1] = SonicraftBiomeManager.overworldRiverBiomes[inputBiomeIds[i1]].biomeID;
	                    }
	                    if (inputBiomeIds[i1] == WorldGen.biomeDiamond.biomeID)
	                    {
	                        outputBiomeIds[i1] = SonicraftBiomeManager.overworldRiverBiomes[inputBiomeIds[i1]].biomeID;
	                    }
	                    else if (inputBiomeIds[i1] != BiomeGenBase.mushroomIsland.biomeID && inputBiomeIds[i1] != BiomeGenBase.mushroomIslandShore.biomeID)
	                    {
	                        outputBiomeIds[i1] = riverBiomeIds[i1] & 255;
	                    }
	                    else
	                    {
	                        outputBiomeIds[i1] = BiomeGenBase.mushroomIslandShore.biomeID;
	                    }
	                }
	                else
	                {
	                    outputBiomeIds[i1] = inputBiomeIds[i1];
	                }
	            }
	            else
	            {
	                outputBiomeIds[i1] = inputBiomeIds[i1];
	            }
	        }

	        return outputBiomeIds;
	    }
}
