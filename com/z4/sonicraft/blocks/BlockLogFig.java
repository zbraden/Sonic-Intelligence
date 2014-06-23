package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

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
		setCreativeTab(CreativeTabs.tabBlock);
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
}


