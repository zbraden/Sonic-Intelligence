package com.zbraden.sonicraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class Crafting {

	public static void loadRecipes() 
	{
		//Furnace Recipes
		GameRegistry.addSmelting(Sonicraft.oreNickel, new ItemStack(Sonicraft.ingotNickel), 0.8F);
	}

}
