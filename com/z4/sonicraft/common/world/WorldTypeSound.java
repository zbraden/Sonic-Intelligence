package com.z4.sonicraft.common.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.DimensionManager;

import com.z4.sonicraft.api.biome.layers.GenLayerBiomeSound;

public class WorldTypeSound extends WorldType
{
	public WorldTypeSound() 
	{
        super("SOUND");
        
        DimensionManager.unregisterProviderType(0);
        DimensionManager.registerProviderType(0, WorldProviderSurfaceSound.class, true);
	}

    @Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer)
    {
        GenLayer ret = new GenLayerBiomeSound(200L, parentLayer, this);

        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
    
    @Override
	public WorldChunkManager getChunkManager(World world)
    {
    	return new WorldChunkManagerSound(world);
    }

}
