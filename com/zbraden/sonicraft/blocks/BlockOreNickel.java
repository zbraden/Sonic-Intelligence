package com.zbraden.sonicraft.blocks;

import com.zbraden.sonicraft.help.Reference;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreNickel extends BlockOre
{
	public BlockOreNickel()
	{
		setBlockName("oreNickel");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
}
