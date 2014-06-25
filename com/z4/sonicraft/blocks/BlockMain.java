package com.z4.sonicraft.blocks;

import com.z4.sonicraft.help.RegisterHelper;
import net.minecraft.block.Block;

public class BlockMain
{
    public static Block oreLodestone;
    public static Block cenoteStone;
    public static Block terraPreta;
    public static Block oreNickel;
    public static Block oreCobaltBlue;
    public static Block logFig;
    public static Block limestone;
    public static Block limestoneCobble;
    public static Block clearWater;
    public static Block towerPost;
    public static Block crystalHum;
    public static Block tourmaline;
    
	public static void loadBlocks(){
		//Load Blocks
		oreLodestone = new BlockLodestone();
		cenoteStone = new BlockCenoteStone();
		terraPreta = new BlockTerraPreta();
		oreNickel = new BlockOreNickel();
		oreCobaltBlue = new BlockOreCobaltBlue();
		logFig = new BlockLogFig();
		limestone = new BlockLimestone();
		limestoneCobble = new BlockLimestoneCobble();
		clearWater = new BlockClearWater();
		towerPost = new BlockTowerPost();
		crystalHum = new BlockHumCrystal();
		tourmaline = new BlockTourmaline();
		//Register Blocks
		RegisterHelper.registerBlock(oreLodestone);
		RegisterHelper.registerBlock(terraPreta);
		RegisterHelper.registerBlock(cenoteStone);
		RegisterHelper.registerBlock(oreNickel);
		RegisterHelper.registerBlock(oreCobaltBlue);
		RegisterHelper.registerBlock(logFig);
		RegisterHelper.registerBlock(limestone);
		RegisterHelper.registerBlock(limestoneCobble);
		RegisterHelper.registerBlock(clearWater);
		RegisterHelper.registerBlock(towerPost);
		RegisterHelper.registerBlock(crystalHum);
		RegisterHelper.registerBlock(tourmaline);
	}
}
