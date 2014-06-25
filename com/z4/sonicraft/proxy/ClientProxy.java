package com.z4.sonicraft.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.z4.sonicraft.blocks.BlockHumCrystalEntity;
import com.z4.sonicraft.renderers.RenderCrystalNode;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{

	public void registerRenderers() {
		TileEntitySpecialRenderer render = new RenderCrystalNode();
		ClientRegistry.bindTileEntitySpecialRenderer(BlockHumCrystalEntity.class, render);
	
	}
}
