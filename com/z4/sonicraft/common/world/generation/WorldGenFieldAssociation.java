package com.z4.sonicraft.common.world.generation;

import java.util.HashMap;

import net.minecraft.world.gen.feature.WorldGenerator;

import com.z4.sonicraft.common.world.SonicraftWorldGenerator;
import com.z4.sonicraft.common.world.WorldGen;

public class WorldGenFieldAssociation {
	  public static HashMap<String, WorldFeature> featureMap = new HashMap<String, WorldFeature>();

	    public static void init()
	    {
	        associateFeatures();
	    }

	    private static void associateFeatures()
	    {
	        
	    }

	    public static void associateFeature(String name, WorldFeature feature)
	    {
	        featureMap.put(name, feature);
	    }

	    public static void associateFeature(String name, WorldGenerator generator)
	    {
	        featureMap.put(name, new WorldFeature(generator));
	    }

	    public static WorldFeature getAssociatedFeature(String name)
	    {
	        return featureMap.get(name);
	    }

	    public static class WorldFeature
	    {
	        private WorldGenerator worldGenerator;

	        protected WorldFeature(WorldGenerator worldGenerator)
	        {
	            this.worldGenerator = worldGenerator;
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
