package com.z4.sonicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import com.z4.sonicraft.blocks.BlockMain;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.items.ItemsMain;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Sonicraft
{  
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//Startup Call out
    	System.out.println("Wait!... Did you hear that?");
    	//Load and Register blocks
    	BlockMain.loadBlocks();
    	//Load and Register Items
    	ItemsMain.loadItems();
    	//Ore Generations
    	OreGen ore_gen = new OreGen();
    	GameRegistry.registerWorldGenerator(ore_gen, 0);
    	
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	//Recipes!!!
    	Crafting.loadRecipes();
    }
}
