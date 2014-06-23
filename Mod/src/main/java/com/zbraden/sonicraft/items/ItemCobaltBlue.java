package com.zbraden.sonicraft.items;

import com.zbraden.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCobaltBlue extends Item 
{
	public ItemCobaltBlue()
	{
		super();
		setUnlocalizedName("cobaltBlue");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}

}
