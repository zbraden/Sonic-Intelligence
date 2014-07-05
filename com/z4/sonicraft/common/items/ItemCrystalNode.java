package com.z4.sonicraft.common.items;

import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class ItemCrystalNode extends Item 
{
	public ItemCrystalNode() 
	{
		super();
		setUnlocalizedName("crystalNode");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
	}
}
