package com.z4.sonicraft.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

public class ItemIngotNickel extends Item
{
	public ItemIngotNickel()
	{
		super();
		setUnlocalizedName("ingotNickel");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
	}
}
