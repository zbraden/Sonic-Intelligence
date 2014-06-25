package com.z4.sonicraft.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
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
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/blocks/blockHumCrystal.png");
	
	public RenderCrystalNode() {
		ResourceLocation loc =  new ResourceLocation(Reference.MODID, "crystal.obj");
		crystalModel = AdvancedModelLoader.loadModel(loc); 
	}
    
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x - 0.0F, (float) y + 0.0F, (float) z + 1.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		crystalModel.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
    private void adjustLightFixture(World world, int i, int j, int k, Block block) {
        Tessellator tess = Tessellator.instance;
        //float brightness = block.getBlockBrightness(world, i, j, k);
        //As of MC 1.7+ block.getBlockBrightness() has become block.getLightValue():
        float brightness = block.getLightValue(world, i, j, k);
        int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
}
}
