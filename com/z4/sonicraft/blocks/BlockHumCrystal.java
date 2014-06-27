package com.z4.sonicraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.items.ItemsMain;
import com.z4.sonicraft.renderers.RenderCrystalNode;

public class BlockHumCrystal extends BlockContainer
{
	public BlockHumCrystal() {		
		super(Material.portal);
		this.setBlockName("blockHumCrystal");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setCreativeTab(Sonicraft.tabSonicraft);
		this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
		setLightLevel(1.0F);
		setStepSound(soundTypeGlass);
		setHardness(1.0F);
		setResistance(2.5F);
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
            return new BlockHumCrystalEntity();
    }
    
    @Override
    public int getRenderType() {
    	return RenderCrystalNode.renderID;
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
    
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.func_149930_e(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
	  private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
	    {
	        if (!p_149930_1_.isRemote)
	        {
            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
	            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
	            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
	            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
	                b0 = 3;
	            }

	            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

	            if (block2.func_149730_j() && !block3.func_149730_j())
	            {
	                b0 = 5;
	            }

            if (block3.func_149730_j() && !block2.func_149730_j())
           {
                b0 = 4;
            }

            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
	        }
    }
	  
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
	  int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		par1World.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
    
	@Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
    	return ItemsMain.crystalNode;
    }
	
	@Override
    public int quantityDropped(Random rand2)
    {
        return 3 + rand2.nextInt(3);
    }
    
    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
            return quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }
}
