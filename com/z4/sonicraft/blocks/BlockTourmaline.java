package com.z4.sonicraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.renderers.RenderTourmaline;

public class BlockTourmaline extends BlockContainer
{
	public BlockTourmaline() {		
		super(Material.portal);
		this.setBlockName("blockTourmaline");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
		setLightLevel(1.0F);
		setStepSound(soundTypeGlass);
		setHardness(1.0F);
		setResistance(2.5F);
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
            return new BlockTourmalineEntity();
    }
    
    @Override
    public int getRenderType() {
    	return RenderTourmaline.renderTourmalineID;
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