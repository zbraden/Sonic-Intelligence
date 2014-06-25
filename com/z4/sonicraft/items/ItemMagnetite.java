package com.z4.sonicraft.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

public class ItemMagnetite extends Item 
{
	public ItemMagnetite()
	{
		super();
		setUnlocalizedName("magnetite");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
	}
}
