package com.zbraden.sonicraft;

import com.zbraden.sonicraft.blocks.BlockMain;
import com.zbraden.sonicraft.items.ItemsMain;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class Crafting {

	public static void loadRecipes() 
	{
		//Furnace Recipes
		GameRegistry.addSmelting(BlockMain.oreNickel, new ItemStack(ItemsMain.ingotNickel), 0.8F);
	}

}
