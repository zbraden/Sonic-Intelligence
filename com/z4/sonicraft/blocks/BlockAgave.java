package com.z4.sonicraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.help.Reference;

public class BlockAgave extends BlockBush {

	public BlockAgave(int par1) {
		super();
		setBlockName("agave");
		setStepSound(soundTypeGrass);
		setCreativeTab(Sonicraft.tabSonicraft);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
    protected boolean canPlaceBlockOn(Block p_149854_1_)
    {
        return p_149854_1_ == Blocks.sand || p_149854_1_ == Blocks.hardened_clay || p_149854_1_ == Blocks.stained_hardened_clay || p_149854_1_ == Blocks.dirt;
    }
}
