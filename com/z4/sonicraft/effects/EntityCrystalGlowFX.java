package com.z4.sonicraft.effects;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import static org.lwjgl.opengl.GL11.*;
import com.z4.sonicraft.help.Reference;

public class EntityCrystalGlowFX extends EntityFX{
	
	private static final ResourceLocation tex = new ResourceLocation(Reference.MODID, "textures/particles/crystalFX.png");
	
	public EntityCrystalGlowFX(World world, double x, double y, double z)
	{
		super(world, x, y, z);
		setMaxAge(20);
		setGravity((float)0.01);
		setScale((float)0.5);
	}
	
	public void renderParticle(Tessellator tess, float partialTicks, float par3, float par4, float par5, float par6, float par7){
		Minecraft.getMinecraft().renderEngine.bindTexture(tex);
		glDepthMask(false);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.003921569F);
		tess.startDrawingQuads();
		tess.setBrightness(getBrightnessForRender(partialTicks));
		float scale = 0.1F*particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		tess.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
		tess.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
		tess.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 1, 1);
		tess.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0, 1);
		tess.draw();
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);
	}
	
	public int getFXLayer(){
		return 3;
	}
	
	public EntityCrystalGlowFX setMaxAge(int maxAge){
		particleMaxAge = maxAge;
		return this;
	}
	
	public EntityCrystalGlowFX setGravity(float gravity){
		particleGravity = gravity;
		return this;
	}
	
	public EntityCrystalGlowFX setScale(float scale){
		particleScale = scale;
		return this;
	}
}
