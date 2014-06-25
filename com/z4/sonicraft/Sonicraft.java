package com.z4.sonicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.z4.sonicraft.blocks.BlockMain;
import com.z4.sonicraft.fluids.FluidMain;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.items.ItemsMain;
import com.z4.sonicraft.worldGen.WorldGen;

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
<<<<<<< HEAD
    	ItemsMain.loadItems();;
=======
    	ItemsMain.loadItems();
    	//Load and Register World Gen
    	WorldGen.init();

>>>>>>> 0ca513219bef5eca9531cfcda83b25105e316cba
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	//Recipes!!!
    	Crafting.loadRecipes();
    }
}
