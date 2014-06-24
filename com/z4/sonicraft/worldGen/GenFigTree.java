package com.z4.sonicraft.worldGen;

import java.util.Random;

import com.z4.sonicraft.blocks.BlockMain;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class GenFigTree extends WorldGenAbstractTree
{
	public GenFigTree()
	{
		super(false);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		int height = random.nextInt(3) + 4;
		boolean generate = true;

		if (y >= 1 && y + height + 1 <= 256)
		{
			byte width;

			for (int yi = y; yi <= y + 1 + height; ++yi)
			{
				width = 1;

				if (yi == y)
				{
					width = 0;
				}

				if (yi >= y + 1 + height - 2)
				{
					width = 2;
				}

				for (int xi = x - width; xi <= x + width && generate; ++xi)
				{
					for (int zi = z - width; zi <= z + width && generate; ++zi)
					{
						if (yi >= 0 && yi < 256)
						{
							if (!this.isReplaceable(world, xi, yi, zi))
							{
								generate = false;
							}
						}
						else
						{
							generate = false;
						}
					}
				}
			}

			if (!generate)
			{
				return false;
			}
			else
			{
				Block soilBlock = world.getBlock(x, y - 1, z);

				if ((soilBlock == Blocks.dirt || soilBlock == Blocks.grass || soilBlock == Blocks.flowing_water) && y < 256 - height - 1)
				{
					byte leavesHeight = 1;
					byte var18 = 0;

					//Height = 7

					//y 7 - Loop End
					//y 6 - Loop Start
					//y 5
					//y 4
					//y 3
					//y 2
					//y 1
					//y 0 - Base
					//y -1

					//Starts from the beginning of the leaves
					for (int yi = y + height - leavesHeight; yi <= y + height; ++yi)
					{
						int delta = yi - (y + height);
						int l1 = var18 + 1 - delta;

						for (int xi = x - l1; xi <= x + l1; ++xi)
						{
							int j2 = xi - x;

							for (int zi = z - l1; zi <= z + l1; ++zi)
							{
								int l2 = zi - z;

								//																		  When yi == y + height
										if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(2) != 0 && delta != 0)
										{
											Block block = world.getBlock(xi, yi, zi);

											if (block.isAir(world, xi, yi, zi) || block.isLeaves(world, xi, yi, zi))
											{
												this.setBlockAndNotifyAdequately(world, xi, yi, zi, Blocks.leaves, 1);
												this.setBlockAndNotifyAdequately(world, xi, yi - 1, zi, Blocks.leaves, 1);

												this.setBlockAndNotifyAdequately(world, x + 1, (y + height) - 3, z, Blocks.leaves, 1);
												this.setBlockAndNotifyAdequately(world, x - 1, (y + height) - 3, z, Blocks.leaves, 1);
												this.setBlockAndNotifyAdequately(world, x, (y + height) - 3, z + 1, Blocks.leaves, 1);
												this.setBlockAndNotifyAdequately(world, x, (y + height) - 3, z - 1, Blocks.leaves, 1);
											}
										}
							}
						}
					}

					for (int yi = 0; yi < height; ++yi)
					{
						Block block = world.getBlock(x, y + yi, z);

						if (block.isAir(world, x, y + yi, z) || block.isLeaves(world, x, y + yi, z))
						{
							this.setBlockAndNotifyAdequately(world, x, y + yi, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 1, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 2, z, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 1, y, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y, z + 1, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 1, y - 1, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y - 1, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 1, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 1, z + 1, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 1, y - 2, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y - 2, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 2, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 2, z + 1, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 2, y - 3, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 2, y - 3, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 3, z - 2, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 3, z + 2, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 2, y - 4, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 2, y - 4, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 4, z - 2, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 4, z + 2, BlockMain.logFig, 2);

							this.setBlockAndNotifyAdequately(world, x - 3, y - 5, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 3, y - 5, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 5, z - 3, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y - 5, z + 3, BlockMain.logFig, 2);
						}
					}

					return true;
				}
			}
		}

		return false;
	}
}
