package com.z4.sonicraft.api.biome;

import net.minecraft.world.biome.BiomeGenBase;


public class BiomeGenYucRiver extends BiomeGenBase {

	private static final Height biomeHeight = new Height(-0.5F, 0.0F);
	
	public BiomeGenYucRiver(int id){
		super(id);
		
		this.setHeight(biomeHeight);
		
		//setBiomeName("Yucatan River");
		setColor(2211330);
		this.setTemperatureRainfall(2.0F, 2.0F);
		//this.waterColorMultiplier = 0xCCFF55;
		
		//this.fillerBlock = BlockMain.limestone;
		
		this.theBiomeDecorator.treesPerChunk = 15;
        this.theBiomeDecorator.grassPerChunk = 7;
        this.theBiomeDecorator.flowersPerChunk = -999;
        //this.theBiomeDecorator.sandPerChunk = 50;
	}
	
    @Override
    public int getSkyColorByTemp(float par1)
    {
        return 507391;
    }
}
