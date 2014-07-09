package com.z4.sonicraft.common.world.generation;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.z4.sonicraft.common.world.SonicraftWorldGenerator;

public class WorldGenFieldAssociation {
	  public static HashMap<String, WorldFeature> featureMap = new HashMap<String, WorldFeature>();

	    public static void init()
	    {
	        associateFeatures();
	        associateFeaturesForced();
	    }

	    private static void associateFeatures()
	    {
	        
	    }

	    private static void associateFeaturesForced()
	    {
	        associateFeatureForced("waterSpringsPerChunk", new WorldGenLiquids(Blocks.flowing_water), SpringGen.class);
	    }
	    
	    public static void associateFeature(String name, WorldFeature feature)
	    {
	        featureMap.put(name, feature);
	    }

	    public static void associateFeature(String name, WorldGenerator generator)
	    {
	        featureMap.put(name, new WorldFeature(generator));
	    }
	    
	    public static void associateFeatureForced(String name, WorldGenerator generator, Class<? extends ForcedFeature> forcedFeature)
	    {
	        associateFeature(name, new WorldFeature(generator, forcedFeature));
	    }

	    public static WorldFeature getAssociatedFeature(String name)
	    {
	        return featureMap.get(name);
	    }

	    public static class WorldFeature
	    {
	        private WorldGenerator worldGenerator;
	        private Class<? extends ForcedFeature> forcedFeature;
	        
	        protected WorldFeature(WorldGenerator worldGenerator, Class<? extends ForcedFeature> forcedFeature)
	        {
	            this.worldGenerator = worldGenerator;
	            this.forcedFeature = forcedFeature;
	        }

	        protected WorldFeature(WorldGenerator worldGenerator)
	        {
	            this.worldGenerator = worldGenerator;
	            this.forcedFeature = forcedFeature;
	        }
	        public SonicraftWorldGenerator getWorldGenerator()
	        {
	            if (this.worldGenerator instanceof SonicraftWorldGenerator)
	            {
	                return (SonicraftWorldGenerator)this.worldGenerator;
	            }

	            return null;
	        }
	    }
}
