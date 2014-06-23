package com.zbraden.sonicraft.items;

import com.zbraden.help.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMagnetite extends Item 
{
	public ItemMagnetite()
	{
		super();
		setUnlocalizedName("magnetite");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
