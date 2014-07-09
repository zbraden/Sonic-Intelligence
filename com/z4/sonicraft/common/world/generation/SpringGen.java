package com.z4.sonicraft.common.world.generation;

import java.util.Random;

import com.z4.sonicraft.api.biome.BiomeGen;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SpringGen extends ForcedFeature
{
	  public SpringGen(WorldGenerator worldGenerator)
	    {
	        super(worldGenerator);
	    }

	    @Override
	    public void setupGeneration(World world, Random random, BiomeGen biome, String featureName, int x, int z)
	    {
	        if (biome.theBiomeDecorator.generateLakes)
	        {
	            for (int i = 0; i < (Integer)biome.theBiomeDecorator.soundFeatures.getFeature("waterSpringsPerChunk"); ++i)
	            {
	                int randX = x + random.nextInt(16) + 8;
	                int randY = random.nextInt(random.nextInt(120) + 8);
	                int randZ = z + random.nextInt(16) + 8;

	                this.generate(world, random, randX, randY, randZ);
	            }
	        }
	    }
}
