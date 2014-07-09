package com.z4.sonicraft.api.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;

public class BiomeGenYucatan extends BiomeGenBase {

	boolean falseB = false;
	
	public BiomeGenYucatan(int id) {
		super(id);
		//setBiomeName("Yucatan");
		setColor(2211330);
		func_76733_a(5470985);
		this.setTemperatureRainfall(2.0F, 2.0F);
		//this.waterColorMultiplier = 0xCCFF55;
		
		//this.fillerBlock = BlockMain.limestone;
		
		this.theBiomeDecorator.treesPerChunk = 12;
        this.theBiomeDecorator.grassPerChunk = 7;
        this.theBiomeDecorator.flowersPerChunk = 4;
        //this.theBiomeDecorator.sandPerChunk = 50;
	}

	@Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
        WorldGenVines worldgenvines = new WorldGenVines();
        int k = chunkX + random.nextInt(16) + 8;
        int l = chunkZ + random.nextInt(16) + 8;
        int height = world.getHeightValue(k, l) * 2; //This was the original input for the nextInt below.  But it could == 0, which crashes nextInt
        if (height < 1) height = 1;
        int i1 = random.nextInt(height);

        for (l = 0; l < 50; ++l)
        {
            i1 = chunkX + random.nextInt(16) + 8;
            short short1 = 128;
            int j1 = chunkZ + random.nextInt(16) + 8;
            worldgenvines.generate(world, random, i1, short1, j1);
        }
    }
	
    @Override
    public int getSkyColorByTemp(float par1)
    {
        return 507391;
    }
    
    @Override
    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(10) == 0 ? this.worldGeneratorBigTree : (rand.nextInt(2) == 0 ? new WorldGenShrub(3, 0) : (!falseB && rand.nextInt(3) == 0 ? new WorldGenTrees(false, 4 + rand.nextInt(7), 3, 3, true) : new WorldGenTrees(false, 4 + rand.nextInt(7), 3, 3, true))));
    }
    
    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
		double d0 = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
		return d0 < -0.1D ? 3654683 : 5489436;
	}
    
    @Override
	public int getBiomeFoliageColor(int x, int y, int z)
	{
		double d0 = plantNoise.func_151601_a((double)x * 0.0225D, (double)z * 0.0225D);
		return d0 < -0.1D ? 2211330 : 4111619;
	}
}
