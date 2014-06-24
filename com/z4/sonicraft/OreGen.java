package com.z4.sonicraft;

import java.util.Random;

import com.z4.sonicraft.blocks.BlockMain;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
			case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
			default:
		}
	}
	
	private void generateSurface(World world, Random random, int x, int z)
	{
		this.generateOre(BlockMain.oreNickel, world, random, x, z, 6, 100, 10, 60, BlockMain.oreNickel);
	}
	
	public void generateOre(Block block, World world, Random random, int chunk_x, int chunk_z, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn)
	{
		int heightRange = maxY - minY;
		WorldGenMinable worldgenminable = new WorldGenMinable(block, maxVeinSize, generateIn);
		for (int k1 = 0; k1 < chancesToSpawn; ++k1)
		{
			int xrand = random.nextInt(16);
			int yrand = random.nextInt(heightRange) + minY;
			int zrand = random.nextInt(16);
			worldgenminable.generate(world, random, chunk_x+xrand, yrand, chunk_z+zrand);
		}
	}
}

