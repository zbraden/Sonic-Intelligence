package com.z4.sonicraft.common.blocks;

import net.minecraft.block.BlockOre;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class BlockOreNickel extends BlockOre
{
	public BlockOreNickel()
	{
		setBlockName("oreNickel");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
}
