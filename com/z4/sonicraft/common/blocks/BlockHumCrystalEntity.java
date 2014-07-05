package com.z4.sonicraft.common.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class BlockHumCrystalEntity extends TileEntity {
	public short orientation = 1;
	
    public void readFromNBT(NBTTagCompound var1)
    {
        super.readFromNBT(var1);
        this.orientation = var1.getShort("orientation");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound var1)
    {
        super.writeToNBT(var1);
        var1.setShort("orientation", this.orientation);
    }
}
