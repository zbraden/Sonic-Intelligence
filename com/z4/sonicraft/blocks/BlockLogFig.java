package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	
	@SideOnly(Side.CLIENT)
	private IIcon woodTop;
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int woodMeta)
    {
    	return side == 1 || side == 0 ? this.woodTop : this.blockIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister woodSides1)
    {
    this.blockIcon = woodSides1.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    this.woodTop = woodSides1.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "Top");
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
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
	{
		int type = 0;
		byte orientation = 0;

		switch (side)
		{
		case 0:
		case 1:
			orientation = 0;
			break;

		case 2:
		case 3:
			orientation = 8;
			break;

		case 4:
		case 5:
			orientation = 4;
		}

		return type | orientation;
	}
	
    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return true;
    }
}


