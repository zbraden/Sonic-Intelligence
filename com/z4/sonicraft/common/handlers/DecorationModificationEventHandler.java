package com.z4.sonicraft.common.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;

import com.z4.sonicraft.api.biome.BiomeGen;
import com.z4.sonicraft.api.biome.SonicraftOverworldBiomeDecorator;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DecorationModificationEventHandler {
	
	@SubscribeEvent
	public void modifyDecor(Decorate event)
	{
		World world = event.world;

		int chunkX = event.chunkX;
		int chunkZ = event.chunkZ;

		Random random = event.rand;

		BiomeGenBase biome = world.getBiomeGenForCoordsBody(chunkX + 16, chunkZ + 16);

		if (biome instanceof BiomeGen)
		{
			BiomeGen Biome = (BiomeGen)biome;

	        if (event.type == Decorate.EventType.LAKE)
	        {
	            event.setResult(Result.DENY);
	            return;
	        }

	        if (Biome.theBiomeDecorator instanceof SonicraftOverworldBiomeDecorator)
	        {
	        	if (event.type == Decorate.EventType.PUMPKIN)
	        	{
	        		if (!(Boolean)Biome.theBiomeDecorator.soundFeatures.getFeature("generatePumpkins"))
	        		{
	        			event.setResult(Result.DENY);
	        		}
	        	}
	        }
		}
	}
}
