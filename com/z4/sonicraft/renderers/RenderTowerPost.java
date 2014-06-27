package com.z4.sonicraft.renderers;

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

import com.z4.sonicraft.blocks.BlockMain;
import com.z4.sonicraft.blocks.BlockTowerPostEntity;
import com.z4.sonicraft.help.Reference;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderTowerPost extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
	private IModelCustom towerModel;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/blocks/blockTowerPost.png");
	public static int renderTowerID;
	
	public RenderTowerPost(int ID) {
		RenderTowerPost.renderTowerID = ID;
		ResourceLocation loc =  new ResourceLocation(Reference.MODID, "towerPost.obj");
		towerModel = AdvancedModelLoader.loadModel(loc); 
	}
    
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		
    	GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		BlockTowerPostEntity towerTile = (BlockTowerPostEntity)tileEntity;		
		renderPost(towerTile.getWorldObj(), towerTile.xCoord, towerTile.yCoord, towerTile.zCoord, BlockMain.towerPost);		
		GL11.glPopMatrix();
	}
	
    private void renderPost(World world, int x, int y, int z, Block block) {
        Tessellator tess = Tessellator.instance;
        float brightness = block.getLightValue(world, x, y, z);
        int skyLight = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
        int modulousModifier = skyLight % 65536;
        int divModifier = skyLight / 65536;
        tess.setColorOpaque_F(brightness, brightness, brightness);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
        
        int dir = world.getBlockMetadata(x, y, z);
        
        int var1 = 0;
        int var2 = 0;

        if (dir == 2) {var2 = 1;}
        else if (dir == 1) {var1 = -1; var2 = 1;}
        else if (dir == 0) {var1 = -1;}
        
        GL11.glPushMatrix();
        GL11.glRotatef((dir * (-90.0F)) + 180F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef((float)var1, 0F, (float)var2);
		this.bindTexture(texture);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_CULL_FACE);
		towerModel.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_CULL_FACE);
		
        GL11.glPopMatrix();
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
		return RenderTowerPost.renderTowerID;
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
		
		towerModel.renderAll();
       
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}
}
