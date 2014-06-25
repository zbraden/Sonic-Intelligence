package com.z4.sonicraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import com.z4.sonicraft.blocks.BlockMain;
import com.z4.sonicraft.fluids.FluidMain;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.items.ItemsMain;
import com.z4.sonicraft.proxy.CommonProxy;
import com.z4.sonicraft.worldGen.WorldGen;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Sonicraft
{  
	//Setup Proxy
	//@SidedProxy(clientSide="mymod.proxy.ClientProxy", serverSide="mymod.proxy.CommonProxy")
	//public static CommonProxy proxy;
	
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
    	//Load and Register World Gen
    	WorldGen.init();
    	//Register Proxy Renderers
    	//proxy.registerRenderers();
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	//Recipes!!!
    	Crafting.loadRecipes();
    }
}
