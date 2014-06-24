package com.z4.sonicraft.help;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterHelper {

	public static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, Reference.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, Reference.MODID + "_" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
	}
	
	public static void registerGen(IWorldGenerator worldGenClass, int weightedProb){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProb);
	}
}
