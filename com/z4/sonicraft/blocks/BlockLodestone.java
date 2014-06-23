package com.z4.sonicraft.blocks;

import com.z4.sonicraft.help.Reference;

import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLodestone extends BlockOre
{
	public BlockLodestone()
	{
		setBlockName("oreLodestone");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
	}
}