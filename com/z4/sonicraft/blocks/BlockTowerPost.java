package com.z4.sonicraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.renderers.RenderTowerPost;

public class BlockTowerPost extends BlockContainer {
	public BlockTowerPost()
	{
		super(Material.iron);
		setBlockName("towerPost");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypeMetal);
		setHardness(3.0F);
		setResistance(5.0F);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 2.0F, 0.9F);
		setHarvestLevel("pickaxe", 2);
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
            return new BlockTowerPostEntity();
    }
    
    @Override
    public int getRenderType() {
    	return RenderTowerPost.renderTowerID;
    }
    
	public boolean isOpaqueCube()
    {
        return false;
    }
	
    public boolean renderAsNormalBlock()
    {
        return false;
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
