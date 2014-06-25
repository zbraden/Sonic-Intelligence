package com.z4.sonicraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
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
