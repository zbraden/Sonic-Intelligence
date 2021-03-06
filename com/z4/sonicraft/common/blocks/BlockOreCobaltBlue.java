package com.z4.sonicraft.common.blocks;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import com.z4.sonicraft.Sonicraft;
import com.z4.sonicraft.common.items.ItemsMain;
import com.z4.sonicraft.common.utils.Reference;

public class BlockOreCobaltBlue extends BlockOre
{
	public BlockOreCobaltBlue()
	{
		setBlockName("oreCobaltBlue");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(Sonicraft.tabSonicraft);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
    	return ItemsMain.cobaltBlue;
    }
	
	@Override
    public int quantityDropped(Random rand2)
    {
        return 2 + rand2.nextInt(3);
    }
    
    @Override
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
            return quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }

}
