package com.z4.sonicraft.common.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class ItemResAlloy extends Item 
{
	public ItemResAlloy() 
	{
		super();
		setUnlocalizedName("resAlloy");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
	}
}
