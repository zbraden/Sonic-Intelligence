package com.z4.sonicraft.common.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class ItemCobaltBlue extends Item 
{
	public ItemCobaltBlue()
	{
		super();
		setUnlocalizedName("cobaltBlue");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
	}

}
