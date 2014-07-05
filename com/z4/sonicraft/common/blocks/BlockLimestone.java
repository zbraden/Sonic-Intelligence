package com.z4.sonicraft.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class BlockLimestone extends Block 
{
	public BlockLimestone()
	{
		super(Material.rock);
		setBlockName("limestone");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);
	}
	
	@Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
    	return Item.getItemFromBlock(BlockMain.limestoneCobble);
    }
}
