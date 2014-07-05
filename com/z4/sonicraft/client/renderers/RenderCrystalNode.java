package com.z4.sonicraft.client.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

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

import com.z4.sonicraft.common.utils.Reference;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCrystalNode extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private IModelCustom crystalModel;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/blocks/blockHumCrystal.png");
	public static int renderID;
	
	public RenderCrystalNode(int ID) {
		RenderCrystalNode.renderID = ID;
		ResourceLocation loc =  new ResourceLocation(Reference.MODID, "crystal.obj");
		crystalModel = AdvancedModelLoader.loadModel(loc); 
	}
    
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		int direction = tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
    	if (direction == 3) direction = 1;
    	else if (direction == 1) direction = 3;
    	else if (direction == 0) direction = 2;
    	else if (direction == 2) direction = 0;
		GL11.glPushMatrix();
		
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef((float) x + 1.0F, (float) y + 0.0F, (float) z + 1.0F);
		if(direction == 1)
		{
			GL11.glRotatef(360F, 0, 1F, 0F);
		}
		else if(direction == 2)
		{
		GL11.glRotatef(90F, 0F, 1F, 0F);
		}
		else if(direction == 3)
		{
			GL11.glRotatef(180F, 0, 1F, 0F);
		}
		else if(direction == 0)
		{
			GL11.glRotatef(270F, 0, 1F, 0F);
		}
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_CULL_FACE);
		crystalModel.renderAll();
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
		return RenderCrystalNode.renderID;
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
		
		crystalModel.renderAll();
       
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
}
