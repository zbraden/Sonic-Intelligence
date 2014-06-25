package com.z4.sonicraft.proxy;

import net.minecraft.client.audio.SoundHandler;

import com.z4.sonicraft.blocks.BlockHumCrystalEntity;
import com.z4.sonicraft.renderers.RenderCrystalNode;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	public void initSounds() {
		new SoundHandler(null, null);
	}
	
	@Override
	public void registerRenderers() {
		int renderCrystalID = RenderingRegistry.getNextAvailableRenderId();
		RenderCrystalNode renderCrystal = new RenderCrystalNode(renderCrystalID);
		ClientRegistry.bindTileEntitySpecialRenderer(BlockHumCrystalEntity.class, renderCrystal);
		RenderingRegistry.registerBlockHandler(renderCrystal);
	}
}
