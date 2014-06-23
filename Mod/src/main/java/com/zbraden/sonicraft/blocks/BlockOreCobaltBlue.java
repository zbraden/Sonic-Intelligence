package com.zbraden.sonicraft.blocks;

import com.zbraden.help.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOreCobaltBlue extends BlockOre
{
	public BlockOreCobaltBlue()
	{
		setBlockName("oreCobaltBlue");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}

}
