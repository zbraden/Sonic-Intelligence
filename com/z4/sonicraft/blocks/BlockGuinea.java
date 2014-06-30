package com.z4.sonicraft.blocks;

import net.minecraft.block.BlockBush;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGuinea extends BlockBush {

	public BlockGuinea(int par1) {
		super();
		setBlockName("guinea");
		setStepSound(soundTypeGrass);
		setCreativeTab(Sonicraft.tabSonicraft);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
    {
        return world.getBiomeGenForCoords(x, z).getBiomeFoliageColor(x, y, z);
    }
	
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColorizerFoliage.getFoliageColorBasic();
    }
}
