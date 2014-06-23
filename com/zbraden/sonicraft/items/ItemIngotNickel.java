package com.zbraden.sonicraft.items;

import com.zbraden.sonicraft.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemIngotNickel extends Item
{
	public ItemIngotNickel()
	{
		super();
		setUnlocalizedName("ingotNickel");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
