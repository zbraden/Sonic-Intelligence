package com.zbraden.sonicraft.items;

import com.zbraden.sonicraft.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemResAlloy extends Item 
{
	public ItemResAlloy() 
	{
		super();
		setUnlocalizedName("resAlloy");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
