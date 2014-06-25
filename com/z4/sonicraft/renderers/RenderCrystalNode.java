package com.z4.sonicraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.z4.sonicraft.help.Reference;

public class RenderCrystalNode extends TileEntitySpecialRenderer
{
	private IModelCustom crystalModel;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/model/crystalHum.png");
	
	public RenderCrystalNode() {
		ResourceLocation loc =  new ResourceLocation(Reference.MODID, "crystal.obj");
		crystalModel = AdvancedModelLoader.loadModel(loc); 
	}
    
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x - 0.0F, (float) y + 0.0F, (float) z + 1.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		crystalModel.renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
