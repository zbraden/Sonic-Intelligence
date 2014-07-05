package com.z4.sonicraft.api;

import com.z4.sonicraft.common.blocks.BlockMain;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsSonicraft extends CreativeTabs 
{

	public CreativeTabsSonicraft(String tabLable) 
	{
		super(tabLable);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(BlockMain.crystalHum);
	}

}
