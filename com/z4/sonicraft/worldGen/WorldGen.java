package com.z4.sonicraft.worldGen;

import com.z4.sonicraft.help.RegisterHelper;

public class WorldGen {
	
	public static void init() {
		// Load World Generators
		//Register World Generators
		RegisterHelper.registerGen(new WorldGenBase(), 1);
	}

}
