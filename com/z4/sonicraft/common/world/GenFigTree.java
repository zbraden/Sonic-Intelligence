package com.z4.sonicraft.common.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import com.z4.sonicraft.common.blocks.BlockMain;

public class GenFigTree extends WorldGenAbstractTree
{
	World world;
	Random rand = new Random();
	int branch = rand.nextInt(5);
	Random rand2 = new Random();
	int leaf = rand2.nextInt(4);
	int[] basePos = new int[] {0, 0, 0};
	int heightLimit;
	int height2;
	double heightAttenuation = 0.618D;
	double branchDensity = 1.0D;
	double branchSlope = 0.381D;
	double scaleWidth = 1.0D;
	double leafDensity = 1.0D;
	int height = 11;
	
	static final byte[] otherCoordPairs = new byte[] {(byte)2, (byte)0, (byte)0, (byte)1, (byte)2, (byte)1};
	
	int trunkSize = 1;

	int heightLimitLimit = rand.nextInt(8) + 16;

    int leafDistanceLimit = 4;
    
	int[][] leafNodes;
	
	private final Block wood = BlockMain.logFig;
	private final Block leaves = Blocks.leaves;

	private final int metaWood = 2;
	private final int metaLeaves = 4;
	
	
	
	public GenFigTree()
	{
		super(false);
	}
	
	void generateLeafNodeList()
	{
		this.height2 = (int)((double)this.heightLimit * this.heightAttenuation);

		if (this.height2 >= this.heightLimit)
		{
			this.height2 = this.heightLimit - 1;
		}

		int i = (int)(1.382D + Math.pow(this.leafDensity * (double)this.heightLimit / 13.0D, 2.0D));

		if (i < 1)
		{
			i = 1;
		}

		int[][] aint = new int[i * this.heightLimit][4];
		int j = this.basePos[1] + this.heightLimit - this.leafDistanceLimit;
		int k = 1;
		int l = this.basePos[1] + this.height2;
		int i1 = j - this.basePos[1];
		aint[0][0] = this.basePos[0];
		aint[0][1] = j;
		aint[0][2] = this.basePos[2];
		aint[0][3] = l;
		--j;

		while (i1 >= 0)
		{
			int j1 = 0;
			float f = this.layerSize(i1);

			if (f < 0.0F)
			{
				--j;
				--i1;
			}
			else
			{
				for (double d0 = 0.5D; j1 < i; ++j1)
				{
					double d1 = this.scaleWidth * (double)f * ((double)this.rand.nextFloat() + 0.328D);
					double d2 = (double)this.rand.nextFloat() * 2.0D * Math.PI;
					int k1 = MathHelper.floor_double(d1 * Math.sin(d2) + (double)this.basePos[0] + d0);
					int l1 = MathHelper.floor_double(d1 * Math.cos(d2) + (double)this.basePos[2] + d0);
					int[] aint1 = new int[] {k1, j, l1};
					int[] aint2 = new int[] {k1, j + this.leafDistanceLimit, l1};

					if (this.checkBlockLine(aint1, aint2) == -1)
					{
						int[] aint3 = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
						double d3 = Math.sqrt(Math.pow((double)Math.abs(this.basePos[0] - aint1[0]), 2.0D) + Math.pow((double)Math.abs(this.basePos[2] - aint1[2]), 2.0D));
						double d4 = d3 * this.branchSlope;

						if ((double)aint1[1] - d4 > (double)l)
						{
							aint3[1] = l;
						}
						else
						{
							aint3[1] = (int)((double)aint1[1] - d4);
						}

						if (this.checkBlockLine(aint3, aint1) == -1)
						{
							aint[k][0] = k1;
							aint[k][1] = j;
							aint[k][2] = l1;
							aint[k][3] = aint3[1];
							++k;
						}
					}
				}

				--j;
				--i1;
			}
		}

		this.leafNodes = new int[k][4];
		System.arraycopy(aint, 0, this.leafNodes, 0, k);
	}

	void func_150529_a(int p_150529_1_, int p_150529_2_, int p_150529_3_, float p_150529_4_, byte p_150529_5_, Block p_150529_6_)
	{
		int l = (int)((double)p_150529_4_ + 0.618D);
		byte b1 = otherCoordPairs[p_150529_5_];
		byte b2 = otherCoordPairs[p_150529_5_ + 3];
		int[] aint = new int[] {p_150529_1_, p_150529_2_, p_150529_3_};
		int[] aint1 = new int[] {0, 0, 0};
		int i1 = -l;
		int j1 = -l;

		for (aint1[p_150529_5_] = aint[p_150529_5_]; i1 <= l; ++i1)
		{
			aint1[b1] = aint[b1] + i1;
			j1 = -l;

			while (j1 <= l)
			{
				double d0 = Math.pow((double)Math.abs(i1) + 0.5D, 2.0D) + Math.pow((double)Math.abs(j1) + 0.5D, 2.0D);

				if (d0 > (double)(p_150529_4_ * p_150529_4_))
				{
					++j1;
				}
				else
				{
					aint1[b2] = aint[b2] + j1;
					Block block1 = this.world.getBlock(aint1[0], aint1[1], aint1[2]);

					if (!block1.isAir(world, aint1[0], aint1[1], aint1[2]) && !block1.isLeaves(world, aint1[0], aint1[1], aint1[2]))
					{
						++j1;
					}
					else
					{
						this.setBlockAndNotifyAdequately(this.world, aint1[0], aint1[1], aint1[2], p_150529_6_, metaLeaves);
						++j1;
					}
				}
			}
		}
	}

	// JAVADOC METHOD $$ layerSize
	float layerSize(int par1)
	{
		if ((double)par1 < (double)((float)this.heightLimit) * 0.3D)
		{
			return -1.618F;
		}
		else
		{
			float f = (float)this.heightLimit / 2.0F;
			float f1 = (float)this.heightLimit / 2.0F - (float)par1;
			float f2;

			if (f1 == 0.0F)
			{
				f2 = f;
			}
			else if (Math.abs(f1) >= f)
			{
				f2 = 0.0F;
			}
			else
			{
				f2 = (float)Math.sqrt(Math.pow((double)Math.abs(f), 2.0D) - Math.pow((double)Math.abs(f1), 2.0D));
			}

			f2 *= 0.5F;
			return f2;
		}
	}

	float leafSize(int par1)
	{
		return par1 >= 0 && par1 < this.leafDistanceLimit ? (par1 != 0 && par1 != this.leafDistanceLimit - 1 ? 3.0F : 2.0F) : -1.0F;
	}

	// JAVADOC METHOD $$ generateLeafNode
	void generateLeafNode(int par1, int par2, int par3)
	{
		int l = par2;

		for (int i1 = par2 + this.leafDistanceLimit; l < i1; ++l)
		{
			float f = this.leafSize(l - par2);
			this.func_150529_a(par1, l, par3, f, (byte)1, leaves);
		}
	}

	void func_150530_a(int[] p_150530_1_, int[] p_150530_2_, Block p_150530_3_)
	{
		int[] aint2 = new int[] {0, 0, 0};
		byte b0 = 0;
		byte b1;

		for (b1 = 0; b0 < 3; ++b0)
		{
			aint2[b0] = p_150530_2_[b0] - p_150530_1_[b0];

			if (Math.abs(aint2[b0]) > Math.abs(aint2[b1]))
			{
				b1 = b0;
			}
		}

		if (aint2[b1] != 0)
		{
			byte b2 = otherCoordPairs[b1];
			byte b3 = otherCoordPairs[b1 + 3];
			byte b4;

			if (aint2[b1] > 0)
			{
				b4 = 1;
			}
			else
			{
				b4 = -1;
			}

			double d0 = (double)aint2[b2] / (double)aint2[b1];
			double d1 = (double)aint2[b3] / (double)aint2[b1];
			int[] aint3 = new int[] {0, 0, 0};
			int i = 0;

			for (int j = aint2[b1] + b4; i != j; i += b4)
			{
				aint3[b1] = MathHelper.floor_double((double)(p_150530_1_[b1] + i) + 0.5D);
				aint3[b2] = MathHelper.floor_double((double)p_150530_1_[b2] + (double)i * d0 + 0.5D);
				aint3[b3] = MathHelper.floor_double((double)p_150530_1_[b3] + (double)i * d1 + 0.5D);
				byte b5 = (byte)metaWood;
				int k = Math.abs(aint3[0] - p_150530_1_[0]);
				int l = Math.abs(aint3[2] - p_150530_1_[2]);
				int i1 = Math.max(k, l);

				if (i1 > 0)
				{
					if (k == i1)
					{
						b5 += 4;
					}
					else if (l == i1)
					{
						b5 += 8;
					}
				}

				this.setBlockAndNotifyAdequately(this.world, aint3[0], aint3[1], aint3[2], p_150530_3_, b5);
			}
		}
	}

	void generateLeaves()
	{
		int i = 0;

		for (int j = this.leafNodes.length; i < j; ++i)
		{
			int k = this.leafNodes[i][0];
			int l = this.leafNodes[i][1];
			int i1 = this.leafNodes[i][2];
			this.generateLeafNode(k, l, i1);
		}
	}

	boolean leafNodeNeedsBase(int par1)
	{
		return (double)par1 >= (double)this.heightLimit * 0.2D;
	}

	void generateTrunk()
	{
		int i = this.basePos[0];
		int j = this.basePos[1];
		int k = this.basePos[1];
		int l = this.basePos[2];
		int[] aint = new int[] {i, j, l};
		int[] aint1 = new int[] {i, k, l};
		this.func_150530_a(aint, aint1, wood);

		if (this.trunkSize == 2)
		{
			++aint[0];
			++aint1[0];
			this.func_150530_a(aint, aint1, wood);
			++aint[2];
			++aint1[2];
			this.func_150530_a(aint, aint1, wood);
			aint[0] += -1;
			aint1[0] += -1;
			this.func_150530_a(aint, aint1, wood);
		}
	}

	// JAVADOC METHOD $$ generateLeafNodeBases
	void generateLeafNodeBases()
	{
		int i = 0;
		int j = this.leafNodes.length;

		for (int[] aint = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]}; i < j; ++i)
		{
			int[] aint1 = this.leafNodes[i];
			int[] aint2 = new int[] {aint1[0], aint1[1], aint1[2]};
			aint[1] = aint1[3];
			int k = aint[1] - this.basePos[1];

			if (this.leafNodeNeedsBase(k))
			{
				this.func_150530_a(aint, aint2, wood);
			}
		}
	}

	// JAVADOC METHOD $$ checkBlockLine
	int checkBlockLine(int[] par1ArrayOfInteger, int[] par2ArrayOfInteger)
	{
		int[] aint2 = new int[] {0, 0, 0};
		byte b0 = 0;
		byte b1;

		for (b1 = 0; b0 < 3; ++b0)
		{
			aint2[b0] = par2ArrayOfInteger[b0] - par1ArrayOfInteger[b0];

			if (Math.abs(aint2[b0]) > Math.abs(aint2[b1]))
			{
				b1 = b0;
			}
		}

		if (aint2[b1] == 0)
		{
			return -1;
		}
		else
		{
			byte b2 = otherCoordPairs[b1];
			byte b3 = otherCoordPairs[b1 + 3];
			byte b4;

			if (aint2[b1] > 0)
			{
				b4 = 1;
			}
			else
			{
				b4 = -1;
			}

			double d0 = (double)aint2[b2] / (double)aint2[b1];
			double d1 = (double)aint2[b3] / (double)aint2[b1];
			int[] aint3 = new int[] {0, 0, 0};
			int i = 0;
			int j;

			for (j = aint2[b1] + b4; i != j; i += b4)
			{
				aint3[b1] = par1ArrayOfInteger[b1] + i;
				aint3[b2] = MathHelper.floor_double((double)par1ArrayOfInteger[b2] + (double)i * d0);
				aint3[b3] = MathHelper.floor_double((double)par1ArrayOfInteger[b3] + (double)i * d1);
				//Block block = this.world.getBlock(aint3[0], aint3[1], aint3[2]);

				if (!this.isReplaceable(world, aint3[0], aint3[1], aint3[2]))
				{
					break;
				}
			}

			return i == j ? -1 : Math.abs(i);
		}
	}

	// JAVADOC METHOD $$ validTreeLocation
	boolean validTreeLocation()
	{
		int[] aint = new int[] {this.basePos[0], this.basePos[1], this.basePos[2]};
		int[] aint1 = new int[] {this.basePos[0], this.basePos[1] + this.heightLimit - 1, this.basePos[2]};
		Block block = this.world.getBlock(this.basePos[0], this.basePos[1] - 1, this.basePos[2]);

		boolean isSoil = block.canSustainPlant(world, basePos[0], basePos[1] - 1, basePos[2], ForgeDirection.UP, (BlockSapling)Blocks.sapling);
		if (!isSoil)
		{
			return false;
		}
		else
		{
			int i = this.checkBlockLine(aint, aint1);

			if (i == -1)
			{
				return true;
			}
			else if (i < 6)
			{
				return false;
			}
			else
			{
				this.heightLimit = i;
				return true;
			}
		}
	}

	@Override
	public void setScale(double par1, double par3, double par5)
	{
		this.heightLimitLimit = (int)(par1 * 12.0D);

		if (par1 > 0.5D)
		{
			this.leafDistanceLimit = 5;
		}

		this.scaleWidth = par3;
		this.leafDensity = par5;
	}

	public boolean generateTop(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		this.world = par1World;
		long l = par2Random.nextLong();
		this.rand.setSeed(l);
		this.basePos[0] = par3;
		this.basePos[1] = par4;
		this.basePos[2] = par5;

		if (this.heightLimit == 0)
		{
			this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
		}

		if (!this.validTreeLocation())
		{
			this.generateLeafNodeList();
			this.generateLeaves();
			this.generateTrunk();
			this.generateLeafNodeBases();
			return true;
		}
		else
		{
			this.generateLeafNodeList();
			this.generateLeaves();
			this.generateTrunk();
			this.generateLeafNodeBases();
			return true;
		}
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{

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

					generateTop(world, random, x, y + 4, z);

					for (int yi = 0; yi < height; ++yi)
					{
						Block block = world.getBlock(x, (y + yi + 5), z);

						if (block.isAir(world, x, y + yi + 5, z) || block.isLeaves(world, x, y + yi + 5, z) || ((world.getBlock(x, y + yi + 5, z) == BlockMain.logFig)))
						{
							this.setBlockAndNotifyAdequately(world, x, y + yi, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y + 5, z + 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 5, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y + 5, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 5, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y + 5, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 5, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 5, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 5, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y + 6, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 6, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 6, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 6, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y + 7, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 7, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 7, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 7, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y + 8, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 8, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 8, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 8, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y + 9, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y + 9, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 9, z - 1, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 9, z + 1, BlockMain.logFig, 2);
							
							this.setBlockAndNotifyAdequately(world, x, y + 5, z, BlockMain.logFig, 2);
							this.setBlockAndNotifyAdequately(world, x, y + 5, z, BlockMain.logFig, 2);

							if ((yi > 0) && (yi < 6)){
								this.setBlockAndNotifyAdequately(world, x + 1, y + yi, z + 2, BlockMain.jungVine, 4);
								this.setBlockAndNotifyAdequately(world, x - 1, y + yi, z + 2, BlockMain.jungVine, 4);
								this.setBlockAndNotifyAdequately(world, x, y + yi, z + 2, BlockMain.jungVine, 4);
								
								this.setBlockAndNotifyAdequately(world, x + 1, y + yi, z - 2, BlockMain.jungVine, 1);
								this.setBlockAndNotifyAdequately(world, x - 1, y + yi, z - 2, BlockMain.jungVine, 1);
								this.setBlockAndNotifyAdequately(world, x, y + yi, z - 2, BlockMain.jungVine, 1);
								
								this.setBlockAndNotifyAdequately(world, x + 2, y + yi, z + 1, BlockMain.jungVine, 2);
								this.setBlockAndNotifyAdequately(world, x + 2, y + yi, z - 1, BlockMain.jungVine, 2);
								this.setBlockAndNotifyAdequately(world, x + 2, y + yi, z, BlockMain.jungVine, 2);
								
								this.setBlockAndNotifyAdequately(world, x - 2, y + yi, z + 1, BlockMain.jungVine, 8);
								this.setBlockAndNotifyAdequately(world, x - 2, y + yi, z - 1, BlockMain.jungVine, 8);
								this.setBlockAndNotifyAdequately(world, x - 2, y + yi, z, BlockMain.jungVine, 8);
							}
							
							if ((branch == 3) || (branch == 4)){
							//Root System
								this.setBlockAndNotifyAdequately(world, x - 1, y + 4, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 1, y + 4, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 4, z - 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 4, z + 1, BlockMain.logFig, 2);
	
								this.setBlockAndNotifyAdequately(world, x - 1, y + 3, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 1, y + 3, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 3, z - 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 3, z + 1, BlockMain.logFig, 2);
	
								this.setBlockAndNotifyAdequately(world, x - 1, y + 2, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 1, y + 2, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 2, z - 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 2, z + 1, BlockMain.logFig, 2);
	
								this.setBlockAndNotifyAdequately(world, x - 2, y + 1, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 2, y + 1, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 1, z - 2, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 1, z + 2, BlockMain.logFig, 2);
	
								this.setBlockAndNotifyAdequately(world, x - 2, y, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 2, y, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y, z - 2, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y, z + 2, BlockMain.logFig, 2);
	
								this.setBlockAndNotifyAdequately(world, x - 3, y - 1, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 3, y - 1, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y - 1, z - 3, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y - 1, z + 3, BlockMain.logFig, 2);
							}
							
							if ((branch == 2) || (branch == 3)){
							//Branch 1
								this.setBlockAndNotifyAdequately(world, x + 4, y + 2, z - 1, BlockMain.logFig, 2);
								
								this.setBlockAndNotifyAdequately(world, x + 4, y + 3, z - 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 3, y + 3, z - 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 4, y + 3, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 3, y + 3, z, BlockMain.logFig, 2);
								
								this.setBlockAndNotifyAdequately(world, x + 3, y + 4, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x + 2, y + 4, z, BlockMain.logFig, 2);
								
								this.setBlockAndNotifyAdequately(world, x + 2, y + 5, z, BlockMain.logFig, 2);
								
								//Branch 1 vines
								if ((yi > 0) && (yi < 4)){
									this.setBlockAndNotifyAdequately(world, x + 4, y + yi, z + 1, BlockMain.jungVine, 4);
									this.setBlockAndNotifyAdequately(world, x + 4, y + yi, z - 2, BlockMain.jungVine, 1);
									this.setBlockAndNotifyAdequately(world, x + 3, y + yi, z + 1, BlockMain.jungVine, 4);
									this.setBlockAndNotifyAdequately(world, x + 3, y + yi, z - 2, BlockMain.jungVine, 1);
									this.setBlockAndNotifyAdequately(world, x + 5, y + yi, z + 0, BlockMain.jungVine, 2);
									this.setBlockAndNotifyAdequately(world, x + 5, y + yi, z - 1, BlockMain.jungVine, 2);
								}
							}
							
							if ((branch == 1) || (branch == 2)){
							//Branch 2
								this.setBlockAndNotifyAdequately(world, x, y + 6, z - 2, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 5, z - 2, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 4, z - 2, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 5, z - 3, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 4, z - 3, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x, y + 4, z - 4, BlockMain.logFig, 2);
								
								//Branch 2 vines
								if ((yi > 0) && (yi < 5)){
									this.setBlockAndNotifyAdequately(world, x + 1, y + yi, z - 2, BlockMain.jungVine, 2);
									this.setBlockAndNotifyAdequately(world, x - 1, y + yi, z - 2, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x + 1, y + yi, z - 3, BlockMain.jungVine, 2);
									this.setBlockAndNotifyAdequately(world, x - 1, y + yi, z - 3, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x + 1, y + yi, z - 4, BlockMain.jungVine, 2);
									this.setBlockAndNotifyAdequately(world, x - 1, y + yi, z - 4, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x, y + yi, z - 5, BlockMain.jungVine, 1);
								}
							}
							
							if ((branch == 1) || (branch == 4)){
							//Branch 3
								this.setBlockAndNotifyAdequately(world, x - 2, y + 5, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x - 3, y + 5, z, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x - 3, y + 5, z + 1, BlockMain.logFig, 2);
								this.setBlockAndNotifyAdequately(world, x - 3, y + 5, z + 2, BlockMain.logFig, 2);
								
								//Branch 3 vines
								if ((yi > 0) && (yi < 6)){
									this.setBlockAndNotifyAdequately(world, x - 2, y + yi, z - 1, BlockMain.jungVine, 1);
									this.setBlockAndNotifyAdequately(world, x - 3, y + yi, z - 1, BlockMain.jungVine, 1);
									this.setBlockAndNotifyAdequately(world, x - 4, y + yi, z, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x - 4, y + yi, z + 1, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x - 4, y + yi, z + 2, BlockMain.jungVine, 8);
									this.setBlockAndNotifyAdequately(world, x - 3, y + yi, z + 3, BlockMain.jungVine, 4);
								}
							}
							
							if ((branch == 1) || (branch == 2) || (branch == 4)){
							//Branch 4
								this.setBlockAndNotifyAdequately(world, x, y + 5, z + 2, BlockMain.logFig, 2);
								
								//Branch 4 vines
								if ((yi > 0) && (yi < 6)){
									this.setBlockAndNotifyAdequately(world, x, y + yi, z + 3, BlockMain.jungVine, 4);
								}
							}
							
							this.setBlockAndNotifyAdequately(world, x + 1, y, z + 1, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y, z - 1, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x + 1, y, z - 1, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y, z + 1, BlockMain.terraPreta, 2);
							
							this.setBlockAndNotifyAdequately(world, x + 1, y, z, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x - 1, y, z, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x, y, z - 1, BlockMain.terraPreta, 2);
							this.setBlockAndNotifyAdequately(world, x, y, z + 1, BlockMain.terraPreta, 2);
						}
						
						
					}

					return true;
				}
			}
		}

		return false;
	}
}
