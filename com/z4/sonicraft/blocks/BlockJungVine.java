package com.z4.sonicraft.blocks;

import net.minecraft.block.BlockVine;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockJungVine extends BlockVine {

	public BlockJungVine(int par1) {
		super();
		setBlockName("jungVine");
		setStepSound(soundTypeGrass);
		setCreativeTab(Sonicraft.tabSonicraft);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return 0;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return 0;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        return 0x806a49;//0xAF9A85;
    }

}
