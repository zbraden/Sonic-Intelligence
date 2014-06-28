package com.z4.sonicraft.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;

import com.z4.sonicraft.help.Reference;

public class FXGlowSpark extends EntityFX
{
    public boolean leyLineEffect;
    public int multiplier;
    public boolean shrink;
    public int particle;
    public int blendmode;
    public boolean slowdown;
    public int currentColor;
    private static final ResourceLocation tex = new ResourceLocation(Reference.MODID, "textures/particles/crystalFX.png");

    public FXGlowSpark(World world, double x, double y, double z, float var8, float red, float green, float blue, int mult)
    {
        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.leyLineEffect = false;
        this.multiplier = 2;
        this.shrink = true;
        this.particle = 16;
        this.blendmode = 1;
        this.slowdown = true;
        this.currentColor = 0;

        if (red == 0.0F)
        {
            red = 1.0F;
        }

        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
        this.particleGravity = 0.0F;
        this.motionX = this.motionY = this.motionZ = 0.0D;
        this.particleScale *= var8;
        this.particleMaxAge = 3 * mult;
        this.multiplier = mult;
        this.noClip = false;
        this.setSize(0.01F, 0.01F);
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
    }

    public FXGlowSpark(World world, double x, double y, double z, float var8, int color, int var10)
    {
        this(world, x, y, z, var8, 0.0F, 0.0F, 0.0F, var10);
        this.currentColor = color;

        switch (color)
        {
            case 0:
                this.particleRed = 0.75F + world.rand.nextFloat() * 0.25F;
                this.particleGreen = 0.25F + world.rand.nextFloat() * 0.25F;
                this.particleBlue = 0.75F + world.rand.nextFloat() * 0.25F;
                break;

            case 1:
                this.particleRed = 0.5F + world.rand.nextFloat() * 0.3F;
                this.particleGreen = 0.5F + world.rand.nextFloat() * 0.3F;
                this.particleBlue = 0.2F;
                break;

            case 2:
                this.particleRed = 0.35F;
                this.particleGreen = 0.5F;
                this.particleBlue = 0.5F + world.rand.nextFloat() * 0.3F;
                break;

            case 3:
                this.particleRed = 0.4F;
                this.particleGreen = 0.8F + world.rand.nextFloat() * 0.3F;
                this.particleBlue = 0.7F;
                break;

            case 4:
                this.particleRed = 0.7F + world.rand.nextFloat() * 0.3F;
                this.particleGreen = 0.2F;
                this.particleBlue = 0.2F;
                break;

            case 5:
                this.blendmode = 771;
                this.particleRed = world.rand.nextFloat() * 0.1F;
                this.particleGreen = world.rand.nextFloat() * 0.1F;
                this.particleBlue = world.rand.nextFloat() * 0.1F;
                break;

            case 6:
                this.particleRed = 0.8F + world.rand.nextFloat() * 0.2F;
                this.particleGreen = 0.8F + world.rand.nextFloat() * 0.2F;
                this.particleBlue = 0.8F + world.rand.nextFloat() * 0.2F;
                break;

            case 7:
                this.particleRed = 0.2F;
                this.particleGreen = 0.5F + world.rand.nextFloat() * 0.3F;
                this.particleBlue = 0.6F + world.rand.nextFloat() * 0.3F;
        }
    }

    public FXGlowSpark(World var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14, int var15, int var16)
    {
        this(var1, var2, var4, var6, var14, var15, var16);
        double var17 = var8 - this.posX;
        double var19 = var10 - this.posY;
        double var21 = var12 - this.posZ;
        this.motionX = var17 / (double)this.particleMaxAge;
        this.motionY = var19 / (double)this.particleMaxAge;
        this.motionZ = var21 / (double)this.particleMaxAge;
    }

    public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        var1.draw();
        GL11.glPushMatrix();
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, this.blendmode);
        Minecraft.getMinecraft().renderEngine.bindTexture(tex);
        float var13 = 0.1F * this.particleScale;

        if (this.shrink)
        {
            var13 *= (float)(this.particleMaxAge - this.particleAge + 1) / (float)this.particleMaxAge;
        }

        float var14 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)var2 - interpPosX);
        float var15 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)var2 - interpPosY);
        float var16 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)var2 - interpPosZ);
        float var17 = 1.0F;
        var1.startDrawingQuads();
        var1.setBrightness(240);
        var1.setColorRGBA_F(this.particleRed * var17, this.particleGreen * var17, this.particleBlue * var17, 1.0F);
        var1.addVertexWithUV((double)(var14 - var3 * var13 - var6 * var13), (double)(var15 - var4 * var13), (double)(var16 - var5 * var13 - var7 * var13), 0, 0);
        var1.addVertexWithUV((double)(var14 - var3 * var13 + var6 * var13), (double)(var15 + var4 * var13), (double)(var16 - var5 * var13 + var7 * var13), 1, 0);
        var1.addVertexWithUV((double)(var14 + var3 * var13 + var6 * var13), (double)(var15 + var4 * var13), (double)(var16 + var5 * var13 + var7 * var13), 1, 1);
        var1.addVertexWithUV((double)(var14 + var3 * var13 - var6 * var13), (double)(var15 - var4 * var13), (double)(var16 + var5 * var13 - var7 * var13), 0, 1);
        var1.draw();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glPopMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(tex);
        var1.startDrawingQuads();
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.motionY -= 0.04D * (double)this.particleGravity;

        this.moveEntity(this.motionX, this.motionY, this.motionZ);

        if (this.slowdown)
        {
            this.motionX *= 0.9080000019073486D;
            this.motionY *= 0.9080000019073486D;
            this.motionZ *= 0.9080000019073486D;

            if (this.onGround)
            {
                this.motionX *= 0.699999988079071D;
                this.motionZ *= 0.699999988079071D;
            }
        }

        if (this.leyLineEffect)
        {
            FXGlowSpark name = new FXGlowSpark(this.worldObj, this.prevPosX + (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F), this.prevPosY + (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F), this.prevPosZ + (double)((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1F), 1.0F, this.currentColor, 3 + this.worldObj.rand.nextInt(3));
            name.noClip = true;
            Minecraft.getMinecraft().effectRenderer.addEffect(name);
        }
    }

    public void setGravity(float var1)
    {
        this.particleGravity = var1;
    }
}   