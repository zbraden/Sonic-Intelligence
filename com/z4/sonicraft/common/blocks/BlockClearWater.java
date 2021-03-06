package com.z4.sonicraft.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.fluids.FluidMain;
import com.z4.sonicraft.common.utils.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockClearWater extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    public BlockClearWater() {
            super(FluidMain.clearWater, Material.water);
            setCreativeTab(Sonicraft.tabSonicraft);
            //setUnlocalizedName("clearWater");
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
            this.stillIcon = icon.registerIcon(Reference.MODID + ":" + "clearWater");
            this.flowingIcon = icon.registerIcon(Reference.MODID + ":" + "clearWaterFlow");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }

}
