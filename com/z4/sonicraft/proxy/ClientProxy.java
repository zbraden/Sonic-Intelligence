package com.z4.sonicraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.world.World;

import com.z4.sonicraft.blocks.BlockHumCrystalEntity;
import com.z4.sonicraft.blocks.BlockTourmalineEntity;
import com.z4.sonicraft.blocks.BlockTowerPostEntity;
import com.z4.sonicraft.effects.FXGlowSpark;
import com.z4.sonicraft.effects.FXHum;
import com.z4.sonicraft.renderers.RenderCrystalNode;
import com.z4.sonicraft.renderers.RenderTourmaline;
import com.z4.sonicraft.renderers.RenderTowerPost;

import cpw.mods.fml.client.FMLClientHandler;
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
	
	public void sparkle(float var1, float var2, float var3, float var4, int var5, float var6)
    {
	    FXGlowSpark newSpark = new FXGlowSpark(this.getClientWorld(), (double)var1, (double)var2, (double)var3, var4, var5, 6);
	    newSpark.noClip = true;
	    newSpark.setGravity(var6);
	    Minecraft.getMinecraft().effectRenderer.addEffect(newSpark);
    }
	
	public void hum(float var1, float var2, float var3, float var4, int var5, float var6)
    {
	    FXHum newHum = new FXHum(this.getClientWorld(), (double)var1, (double)var2, (double)var3, var4, var5, 6);
	    newHum.noClip = true;
	    newHum.setGravity(var6);
	    Minecraft.getMinecraft().effectRenderer.addEffect(newHum);
    }
  
	public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
}
