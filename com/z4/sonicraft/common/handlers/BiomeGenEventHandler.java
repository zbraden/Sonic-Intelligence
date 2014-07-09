package com.z4.sonicraft.common.handlers;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;

import com.z4.sonicraft.api.biome.layers.GenLayerBiomeSound;
import com.z4.sonicraft.api.biome.layers.GenLayerSound;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BiomeGenEventHandler {
	@SubscribeEvent
	public void registerBiomes(InitBiomeGens event){
		GenLayer layer1 = event.newBiomeGens[0];
		GenLayer layer2 = event.newBiomeGens[1];
		
		GenLayer ret = new GenLayerBiomeSound(200L, layer1, event.worldType);
		GenLayer ret2 = new GenLayerBiomeSound(200L, layer2, event.worldType);

        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        ret2 = GenLayerZoom.magnify(1000L, ret2, 2);
        ret2 = new GenLayerBiomeEdge(1000L, ret2);
        layer1 = ret;
        layer2 = ret2;
	}
}
