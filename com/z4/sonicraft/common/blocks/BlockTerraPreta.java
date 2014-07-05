package com.z4.sonicraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class BlockTerraPreta extends Block
{
	public BlockTerraPreta()
	{
		super(Material.ground);
		setBlockName("terraPreta");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypeGravel);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("shovel", 0);
	}
}
