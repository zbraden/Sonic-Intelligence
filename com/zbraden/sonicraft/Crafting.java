package com.zbraden.sonicraft;

import com.zbraden.sonicraft.blocks.BlockMain;
import com.zbraden.sonicraft.items.ItemsMain;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Crafting {

	public static void loadRecipes() 
	{
		//Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(ItemsMain.resAlloy, 4), new Object[]
				{
					"XYX",
					"YZY",
					"XYX",
					'X', Items.iron_ingot, 'Y', ItemsMain.ingotNickel, 'Z', ItemsMain.crystalNode
				});
		//Furnace Recipes
		GameRegistry.addSmelting(BlockMain.oreNickel, new ItemStack(ItemsMain.ingotNickel), 0.8F);
	}

}
