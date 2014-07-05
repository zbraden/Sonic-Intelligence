package com.z4.sonicraft.common.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidClearWater extends Fluid {
	public FluidClearWater(String fluidName){
		super("FluidClearWater");
		setLuminosity(0);
		setDensity(1000);
		setTemperature(295);
		setViscosity(900);
	}
}
