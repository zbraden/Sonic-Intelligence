package com.z4.sonicraft.common.world;

import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;

import com.z4.sonicraft.api.biome.layers.GenLayerSound;

import cpw.mods.fml.common.ObfuscationReflectionHelper;

public class WorldChunkManagerSound extends WorldChunkManager {
	public WorldChunkManagerSound(World world)
	{
		super();

        GenLayer[] agenlayer = GenLayerSound.initializeAllBiomeGenerators(world.getSeed(), world.getWorldInfo().getTerrainType());
        agenlayer = getModdedBiomeGenerators(world.getWorldInfo().getTerrainType(), world.getSeed(), agenlayer);
        ObfuscationReflectionHelper.setPrivateValue(WorldChunkManager.class, this, agenlayer[0], "genBiomes", "field_76944_d");
        ObfuscationReflectionHelper.setPrivateValue(WorldChunkManager.class, this, agenlayer[1], "biomeIndexLayer", "field_76945_e");
	}

    @Override
	public ChunkPosition findBiomePosition(int x, int z, int radius, List biomesToSpawnIn, Random random)
    {
    	int spawnSearchRadius = 10;
    	
    	return super.findBiomePosition(x, z, spawnSearchRadius, biomesToSpawnIn, random);
    }
}
