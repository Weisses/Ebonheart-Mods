package com.viesis.viescraft.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAirshipWorkbench extends TileEntity {
    
    public ItemStackHandler inventory;
    private int size = 9;
    
    public TileEntityAirshipWorkbench() 
    {
    	inventory = new ItemStackHandler(size);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
        return super.getCapability(capability, facing);
    }
    
    /**
    @Nullable
    @Override
    public ITextComponent getDisplayName()
    {
        int stacks = 0;
        for (int i = 0; i < inventory.getSlots(); i++)
        {
            if(inventory.getStackInSlot(i) != null) stacks++;
        }
        return new TextComponentString(stacks+"/"+ inventory.getSlots());
    }
    */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	
    	compound.setTag("Slots", inventory.serializeNBT());
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    }
}
