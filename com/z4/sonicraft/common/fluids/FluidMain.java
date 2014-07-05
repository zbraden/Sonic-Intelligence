package com.z4.sonicraft.common.fluids;

import com.z4.sonicraft.common.utils.RegisterHelper;

import net.minecraftforge.fluids.Fluid;

public class FluidMain 
{
	public static Fluid clearWater;
	
	public static void loadFluids() {
		//Load Fluids
		clearWater = new FluidClearWater("clearWater");
		//Register Fluids
		RegisterHelper.registerFluid(clearWater);
	}

}
