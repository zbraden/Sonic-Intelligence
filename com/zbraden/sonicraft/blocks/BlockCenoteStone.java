package com.zbraden.sonicraft.blocks;

import com.zbraden.sonicraft.help.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCenoteStone extends Block {
	public BlockCenoteStone()
	{
		super(Material.rock);
		setBlockName("cenoteStone");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
	}
}
