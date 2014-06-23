package com.z4.sonicraft.items;

import com.z4.sonicraft.help.Reference;

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
