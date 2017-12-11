package com.viesis.viescraft.common.tileentity;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAirshipWorkbench extends TileEntity {
    
    public ItemStackHandler inventory;
    private int size = 9;
    private String airshipWorkbenchCustomName;
    
    public TileEntityAirshipWorkbench() 
    {
    	this.inventory = new ItemStackHandler(size);
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
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	
    	compound.setTag("Slots", this.inventory.serializeNBT());
    	
    	if (this.hasCustomName())
        {
            compound.setString("CustomName", this.airshipWorkbenchCustomName);
        }
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    	
        if (compound.hasKey("CustomName", 8))
        {
            this.airshipWorkbenchCustomName = compound.getString("CustomName");
        }
    }
    
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		super.onDataPacket(net, pkt);
		
		this.handleUpdateTag(pkt.getNbtCompound());
	}
	
	/**
     * Get the name of this object. For players this returns their username
     */
	public String getName()
    {
        return this.hasCustomName() ? this.airshipWorkbenchCustomName : "airship_workbench";
    }
	
	/**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.airshipWorkbenchCustomName != null && !this.airshipWorkbenchCustomName.isEmpty();
    }
}
