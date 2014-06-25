package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHumCrystal extends Block
{
	protected BlockHumCrystal(Material material) {
		super(Material.glass);
		// TODO Auto-generated constructor stub
	}

	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
		if (world.getBlockMetadata(x, y, z) % 2 == 0) {
			setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		} else {
			setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
		}
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
    	setBlockBoundsBasedOnState(world, x, y, z);
    	return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    	setBlockBoundsBasedOnState(world, x, y, z);
    	return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }
    
    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end) {
    	setBlockBoundsBasedOnState(world, x, y, z);
    	return super.collisionRayTrace(world, x, y, z, start, end);
    }

}
