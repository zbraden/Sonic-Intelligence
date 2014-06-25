package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

public class BlockLimestoneCobble extends Block 
{
	public BlockLimestoneCobble()
	{
		super(Material.rock);
		setBlockName("limestoneCobble");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
	}
}
