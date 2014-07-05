package com.z4.sonicraft.common.blocks;

import net.minecraft.block.BlockBush;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.utils.Reference;

public class BlockBromeliad extends BlockBush {

	public BlockBromeliad(int par1) {
		super();
		setBlockName("bromeliad");
		setStepSound(soundTypeGrass);
		setCreativeTab(Sonicraft.tabSonicraft);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
