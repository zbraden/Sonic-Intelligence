package com.z4.sonicraft.common.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.z4.sonicraft.common.blocks.BlockMain;

//import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenBase implements IWorldGenerator
{
	 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		 //@Override
		 //WorldGenAbstractTree func_150567_a(new GenFigTree());
		 switch(world.provider.dimensionId){
		 case 0:
			 generateNickelOverworld(world, random, chunkX*16, chunkZ*16);
			 generateCobaltOverworld(world, random, chunkX*16, chunkZ*16);
			 generateLimestoneOverworld(world, random, chunkX*16, chunkZ*16);
			 generateCrystalsOverworld(world, random, chunkX*16, chunkZ*16);
			 generateFig(world, random, chunkX*16, chunkZ*16);
		 }
	 }
	 
	 private void generateNickelOverworld(World world, Random random, int chunkX, int chunkZ){
		 for (int i = 0; i < 100; i++){
			 int randPosX = chunkX + random.nextInt(16);
			 int randPosY = random.nextInt(64);
			 int randPosZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(BlockMain.oreNickel, 6)).generate(world, random, randPosX, randPosY, randPosZ);
		 }
	 }
	 
	 private void generateCobaltOverworld(World world, Random random, int chunkX, int chunkZ){
		 for (int i = 0; i < 100; i++){
			 int randPosX = chunkX + random.nextInt(16);
			 int randPosY = random.nextInt(64);
			 int randPosZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(BlockMain.oreCobaltBlue, 6)).generate(world, random, randPosX, randPosY, randPosZ);
		 }
	 }
	 
	 private void generateLimestoneOverworld(World world, Random random, int chunkX, int chunkZ){
		 for (int i = 0; i < 100; i++){
			 int randPosX = chunkX + random.nextInt(16);
			 int randPosY = random.nextInt(64);
			 int randPosZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(BlockMain.limestone, 15)).generate(world, random, randPosX, randPosY, randPosZ);
		 }
	 }
	 
	 private void generateCrystalsOverworld(World world, Random random, int chunkX, int chunkZ){
		 for (int i = 0; i < 100; i++){
			 int randPosX = chunkX + random.nextInt(16);
			 int randPosY = random.nextInt(64);
			 int randPosZ = chunkZ + random.nextInt(16);
			 
			 (new WorldGenMinable(BlockMain.crystalHum, 1)).generate(world, random, randPosX, randPosY, randPosZ);
		 }
	 }
	 
	 private void generateFig(World world, Random random, int chunkX, int chunkZ) {
		 	int minHeight = 50;
			int treesPerChunk = 10;
		 for(int k = 0; k < treesPerChunk; k++){
			int chunkX1 = chunkX + random.nextInt(16);
			int chunkY1 = minHeight + random.nextInt(40);
			int chunkZ1 = chunkZ + random.nextInt(16);
			(new GenFigTree()).generate(world, random, chunkX1, chunkY1, chunkZ1);
	 }
}
}