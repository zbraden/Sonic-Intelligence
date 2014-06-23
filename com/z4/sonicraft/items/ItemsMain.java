package com.z4.sonicraft.items;

import com.z4.sonicraft.help.RegisterHelper;

import net.minecraft.item.Item;

public class ItemsMain 
{
    public static Item magnetite;
    public static Item cobaltBlue;
    public static Item ingotNickel;
    public static Item crystalNode;
    public static Item resAlloy;
    
    public static void loadItems(){
		//Load Items
		magnetite = new ItemMagnetite();
		cobaltBlue = new ItemCobaltBlue();
		ingotNickel = new ItemIngotNickel();
		crystalNode = new ItemCrystalNode();
		resAlloy = new ItemResAlloy();
		//Register Items
		RegisterHelper.registerItem(magnetite);
		RegisterHelper.registerItem(cobaltBlue);
		RegisterHelper.registerItem(ingotNickel);
		RegisterHelper.registerItem(crystalNode);
		RegisterHelper.registerItem(resAlloy);
    }
}
