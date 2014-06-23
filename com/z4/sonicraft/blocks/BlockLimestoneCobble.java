package com.z4.sonicraft.blocks;

import com.z4.sonicraft.help.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLimestoneCobble extends Block 
{
	public BlockLimestoneCobble()
	{
		super(Material.rock);
		setBlockName("limestoneCobble");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
	}
}
