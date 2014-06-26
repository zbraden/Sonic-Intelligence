package com.z4.sonicraft.proxy;

import net.minecraft.client.audio.SoundHandler;

import com.z4.sonicraft.blocks.BlockHumCrystalEntity;
import com.z4.sonicraft.blocks.BlockTourmalineEntity;
import com.z4.sonicraft.blocks.BlockTowerPostEntity;
import com.z4.sonicraft.renderers.RenderCrystalNode;
import com.z4.sonicraft.renderers.RenderTourmaline;
import com.z4.sonicraft.renderers.RenderTowerPost;

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
		int renderTourmalineID = RenderingRegistry.getNextAvailableRenderId();
		RenderTourmaline renderTourmaline = new RenderTourmaline(renderTourmalineID);
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTourmalineEntity.class, renderTourmaline);
		RenderingRegistry.registerBlockHandler(renderTourmaline);
		int renderTowerID = RenderingRegistry.getNextAvailableRenderId();
		RenderTowerPost renderTower = new RenderTowerPost(renderTowerID);
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTowerPostEntity.class, renderTower);
		RenderingRegistry.registerBlockHandler(renderTower);
	}
}
