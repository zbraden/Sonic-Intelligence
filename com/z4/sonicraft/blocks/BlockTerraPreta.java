package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;

import com.z4.sonicraft.help.Reference;

public class BlockTerraPreta extends Block
{
	public BlockTerraPreta()
	{
		super(Material.ground);
		setBlockName("terraPreta");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypeGravel);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("shovel", 0);
	}
}
