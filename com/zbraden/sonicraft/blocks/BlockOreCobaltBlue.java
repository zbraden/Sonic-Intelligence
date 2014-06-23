package com.zbraden.sonicraft.blocks;

import java.util.Random;

import com.zbraden.sonicraft.help.Reference;
import com.zbraden.sonicraft.Sonicraft;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockOreCobaltBlue extends BlockOre
{
	public BlockOreCobaltBlue()
	{
		setBlockName("oreCobaltBlue");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(soundTypePiston);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
    	return Sonicraft.cobaltBlue;
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
