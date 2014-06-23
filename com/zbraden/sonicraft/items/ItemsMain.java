package com.zbraden.sonicraft.items;

import com.zbraden.sonicraft.help.RegisterHelper;
import net.minecraft.item.Item;

public class ItemsMain 
{
    public static Item magnetite;
    public static Item cobaltBlue;
    public static Item ingotNickel;
    
    public static void loadItems(){
		//Load Items
		magnetite = new ItemMagnetite();
		cobaltBlue = new ItemCobaltBlue();
		ingotNickel = new ItemIngotNickel();
		//Register Items
		RegisterHelper.registerItem(magnetite);
		RegisterHelper.registerItem(cobaltBlue);
		RegisterHelper.registerItem(ingotNickel);
    }
}
