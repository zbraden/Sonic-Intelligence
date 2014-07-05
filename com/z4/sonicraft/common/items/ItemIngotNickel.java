package com.z4.sonicraft.common.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

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
