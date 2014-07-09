package com.z4.sonicraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.z4.sonicraft.api.CreativeTabsSonicraft;
import com.z4.sonicraft.common.CommonProxy;
import com.z4.sonicraft.common.blocks.BlockHumCrystalEntity;
import com.z4.sonicraft.common.blocks.BlockMain;
import com.z4.sonicraft.common.blocks.BlockTourmalineEntity;
import com.z4.sonicraft.common.blocks.BlockTowerPostEntity;
import com.z4.sonicraft.common.fluids.FluidMain;
import com.z4.sonicraft.common.handlers.BiomeGenEventHandler;
import com.z4.sonicraft.common.handlers.BiomeSizeEventHandler;
import com.z4.sonicraft.common.handlers.DecorationModificationEventHandler;
import com.z4.sonicraft.common.items.ItemsMain;
import com.z4.sonicraft.common.utils.Reference;
import com.z4.sonicraft.common.world.WorldGen;
import com.z4.sonicraft.common.world.WorldTypeSound;
import com.z4.sonicraft.common.world.generation.WorldGenFieldAssociation;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Sonicraft
{  
	//Setup Proxy
	@SidedProxy(clientSide="com.z4.sonicraft.client.ClientProxy", serverSide="com.z4.sonicraft.common.CommonProxy")
	public static CommonProxy proxy;
    //Setting up creative tab
    public static CreativeTabs tabSonicraft = new CreativeTabsSonicraft("sonicraftMain");
    
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
    	WorldGenFieldAssociation.init();
    	WorldGen.init();
    	
    	//Register Proxy Renderers
    	proxy.registerRenderers();
    	GameRegistry.registerTileEntity(BlockHumCrystalEntity.class, "blockHumCrystal");
    	GameRegistry.registerTileEntity(BlockTourmalineEntity.class, "blockTourmaline");
    	GameRegistry.registerTileEntity(BlockTowerPostEntity.class, "blockTowerPost");
    	
    	//Call Handlers
    	MinecraftForge.TERRAIN_GEN_BUS.register(new DecorationModificationEventHandler());
    	MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeSizeEventHandler());
    	MinecraftForge.TERRAIN_GEN_BUS.register(new BiomeGenEventHandler());
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {

    	//Recipes!!!
    	Crafting.loadRecipes();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	 WorldGen.worldTypeSound = new WorldTypeSound();
    }
}
