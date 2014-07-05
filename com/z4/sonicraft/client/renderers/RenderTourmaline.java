package com.z4.sonicraft.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.z4.sonicraft.common.utils.Reference;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderTourmaline extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private IModelCustom tourmalineModel;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/blocks/blockTourmaline.png");
	public static int renderTourmalineID;
	
	public RenderTourmaline(int ID) {
		RenderTourmaline.renderTourmalineID = ID;
		ResourceLocation loc =  new ResourceLocation(Reference.MODID, "tourmaline.obj");
		tourmalineModel = AdvancedModelLoader.loadModel(loc); 
	}
    
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x - 0.0F, (float) y + 0.0F, (float) z + 1.0F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_CULL_FACE);
		tourmalineModel.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
    private void adjustLightFixture(World world, int x, int y, int z, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getLightValue(world, x, y, z);
        int skyLight = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderTourmaline.renderTourmalineID;
	}
	
    @Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		
		GL11.glPushMatrix();
		GL11.glScalef(1F, 1F, 1F);
		GL11.glTranslatef(0F, 0.0F, 1.0F);
		
        GL11.glDisable(GL11.GL_CULL_FACE);
		
	    Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	    
	    GL11.glPushMatrix();
        GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		
		tourmalineModel.renderAll();
       
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
}
