package com.z4.sonicraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;
import com.z4.sonicraft.items.ItemsMain;
import com.z4.sonicraft.renderers.RenderCrystalNode;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		//this.func_149930_e(par1World, par2, par3, par4);
	}

	/**
	 * set a blocks direction
	 */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, Block var5)
    {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);

        if (this.checkIfAttachedToBlock(var1, var2, var3, var4))
        {
            BlockHumCrystalEntity var6 = (BlockHumCrystalEntity)var1.getTileEntity(var2, var3, var4);
            short var7 = var6.orientation;
            boolean var8 = false;

            if (!var1.isSideSolid(var2 - 1, var3, var4, ForgeDirection.getOrientation(5)) && var7 == 5)
            {
                var8 = true;
            }

            if (!var1.isSideSolid(var2 + 1, var3, var4, ForgeDirection.getOrientation(4)) && var7 == 4)
            {
                var8 = true;
            }

            if (!var1.isSideSolid(var2, var3, var4 - 1, ForgeDirection.getOrientation(3)) && var7 == 3)
            {
                var8 = true;
            }

            if (!var1.isSideSolid(var2, var3, var4 + 1, ForgeDirection.getOrientation(2)) && var7 == 2)
            {
                var8 = true;
            }

            if (!var1.isSideSolid(var2, var3 - 1, var4, ForgeDirection.getOrientation(1)) && var7 == 1)
            {
                var8 = true;
            }

            if (!var1.isSideSolid(var2, var3 + 1, var4, ForgeDirection.getOrientation(0)) && var7 == 0)
            {
                var8 = true;
            }

            if (var8)
            {
                this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
                var1.setBlockMetadataWithNotify(var2, var3, var4, 0, 2);
            }
        }
    }

    private boolean checkIfAttachedToBlock(World var1, int var2, int var3, int var4)
    {
        if (!this.canPlaceBlockAt(var1, var2, var3, var4))
        {
            this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
            var1.setBlockMetadataWithNotify(var2, var3, var4, 0, 2);
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */
    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5)
    {
        return var5 == 0 && var1.isSideSolid(var2, var3 + 1, var4, ForgeDirection.getOrientation(0)) ? true : (var5 == 1 && var1.isSideSolid(var2, var3 - 1, var4, ForgeDirection.getOrientation(1)) ? true : (var5 == 2 && var1.isSideSolid(var2, var3, var4 + 1, ForgeDirection.getOrientation(2)) ? true : (var5 == 3 && var1.isSideSolid(var2, var3, var4 - 1, ForgeDirection.getOrientation(3)) ? true : (var5 == 4 && var1.isSideSolid(var2 + 1, var3, var4, ForgeDirection.getOrientation(4)) ? true : var5 == 5 && var1.isSideSolid(var2 - 1, var3, var4, ForgeDirection.getOrientation(5))))));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.isSideSolid(x - 1, y, z, ForgeDirection.getOrientation(5)) ? true : (world.isSideSolid(x + 1, y, z, ForgeDirection.getOrientation(4)) ? true : (world.isSideSolid(x, y, z - 1, ForgeDirection.getOrientation(3)) ? true : (world.isSideSolid(x, y, z + 1, ForgeDirection.getOrientation(2)) ? true : (world.isSideSolid(x, y - 1, z, ForgeDirection.getOrientation(1)) ? true : world.isSideSolid(x, y + 1, z, ForgeDirection.getOrientation(0))))));
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
    
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random par5Random) {
		if (par5Random.nextFloat() < 0.1F){
			Sonicraft.proxy.sparkle(((float)x + 0.2F + world.rand.nextFloat() * 0.6F), ((float)y + 0.2F + world.rand.nextFloat() * 0.6F), ((float)z + 0.2F + world.rand.nextFloat() * 0.6F), 1F, 2, par5Random.nextFloat() / 20);
		}
		if (par5Random.nextFloat() < 0.6F){
			Sonicraft.proxy.hum(((float)x + 0.5F), ((float)y + 0.5F), ((float)z + 0.5F), 8F, 2, par5Random.nextFloat() / 20);
	}
	}

	public void placeParticle(World world, int par2, int par3, int par4) {
		Sonicraft.proxy.sparkle(par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, 1, 0, 0);
	}
}
