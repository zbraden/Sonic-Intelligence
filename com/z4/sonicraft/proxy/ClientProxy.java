package com.z4.sonicraft.proxy;

import com.z4.sonicraft.blocks.BlockHumCrystal;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderers() {
	//MinecraftForgeClient.registerItemRenderer(BlockHumCrystal.class, RenderCrystalNode(model));
	
	}
}
