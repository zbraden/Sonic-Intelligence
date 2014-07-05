package com.z4.sonicraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class BlockLogFig extends Block
{
	public BlockLogFig()
	{
		super(Material.wood);
		setBlockName("logFig");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypeWood);
		setHardness(2.0F);
		setResistance(4.0F);
		setHarvestLevel("axe", 0);
	}
	
    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
    
	public boolean isOpaqueCube()
    {
        return false;
    }

	@Override
	public void breakBlock(World world, int x, int y, int z, Block par5, int par6)
	{
		byte radius = 4;
		int bounds = radius + 1;

		if (world.checkChunksExist(x - bounds, y - bounds, z - bounds, x + bounds, y + bounds, z + bounds)) 
		{
			for (int i = -radius; i <= radius; ++i) 
			{
				for (int j = -radius; j <= radius; ++j) 
				{
					for (int k = -radius; k <= radius; ++k)
					{
						Block block = world.getBlock(x + i, y + j, z + k);

						if (block.isLeaves(world, x, y, z)) 
						{
							block.beginLeavesDecay(world, x + i, y + j, z + k);
						}
					}
				}
			}
		}
	}
	
    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}


