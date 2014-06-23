package com.zbraden.sonicraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.zbraden.help.Reference;
import com.zbraden.help.RegisterHelper;
import com.zbraden.sonicraft.blocks.BlockCenoteStone;
import com.zbraden.sonicraft.blocks.BlockLodestone;
import com.zbraden.sonicraft.blocks.BlockOreCobaltBlue;
import com.zbraden.sonicraft.blocks.BlockOreNickel;
import com.zbraden.sonicraft.blocks.BlockTerraPreta;
import com.zbraden.sonicraft.items.ItemCobaltBlue;
import com.zbraden.sonicraft.items.ItemMagnetite;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Sonicraft
{
	//Blocks
    public static Block oreLodestone;
    public static Block cenoteStone;
    public static Block terraPreta;
    public static Block oreNickel;
    public static Block oreCobaltBlue;
    
    //Items
    public static Item magnetite;
    public static Item cobaltBlue;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//Startup Call out
    	System.out.println("Did you hear that?");
    	//Load blocks
		oreLodestone = new BlockLodestone();
		cenoteStone = new BlockCenoteStone();
		terraPreta = new BlockTerraPreta();
		oreNickel = new BlockOreNickel();
		oreCobaltBlue = new BlockOreCobaltBlue();
		//Register blocks
		RegisterHelper.registerBlock(oreLodestone);
		RegisterHelper.registerBlock(terraPreta);
		RegisterHelper.registerBlock(cenoteStone);
		RegisterHelper.registerBlock(oreNickel);
		RegisterHelper.registerBlock(oreCobaltBlue);
		//Load Items
		magnetite = new ItemMagnetite();
		cobaltBlue = new ItemCobaltBlue();
		//Register Items
		RegisterHelper.registerItem(magnetite);
		RegisterHelper.registerItem(cobaltBlue);
    }
}
