package com.z4.sonicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import com.z4.sonicraft.blocks.BlockMain;
import com.z4.sonicraft.fluids.FluidMain;
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
    	//Load and Register Fluids
    	FluidMain.loadFluids();
    	//Load and Register blocks
    	BlockMain.loadBlocks();
    	//Load and Register Items
    	ItemsMain.loadItems();
<<<<<<< HEAD
    
    	
=======

>>>>>>> fbbe20b0a254976281958e1d6d68f7ee7d817fa3
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	//Recipes!!!
    	Crafting.loadRecipes();
    }
}
