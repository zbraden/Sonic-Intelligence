package com.zbraden.sonicraft.items;

import com.zbraden.sonicraft.help.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCrystalNode extends Item 
{
	public ItemCrystalNode() 
	{
		super();
		setUnlocalizedName("crystalNode");
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
