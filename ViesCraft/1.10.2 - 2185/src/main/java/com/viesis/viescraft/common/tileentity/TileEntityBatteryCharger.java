package com.viesis.viescraft.common.tileentity;

import com.viesis.viescraft.common.caps.DualEnergyStorageVC;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBatteryCharger {
	/**
	extends TileEntity {
}
    
	private DualEnergyStorageVC energy;// = new DualEnergyStorageVC(1000, 1000, 2000);
	
    public ItemStackHandler inventory;
    private int size = 9;
    
    /** The number of ticks that the furnace will keep burning 
    private int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for *
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;
    
    public TileEntityBatteryCharger() 
    {
    	inventory = new ItemStackHandler(size);
    	
    	energy = new DualEnergyStorageVC(10000, 1000, 2000);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        if (capability == DualEnergyStorageVC.CAPABILITY_HOLDER) return true;
        
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
        if(capability == DualEnergyStorageVC.CAPABILITY_HOLDER) return (T) this.energy;
        
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
    
    /**
     * Furnace isBurning
     
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     
    public void update()
    {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (this.isBurning())
        {
            --this.furnaceBurnTime;
        }

        if (!this.world.isRemote)
        {
            ItemStack itemstack = (ItemStack)this.inventory.getStackInSlot(1);

            if (this.isBurning() || !itemstack.isEmpty() && !((ItemStack)this.inventory.getStackInSlot(1)).isEmpty())
            {
                if (!this.isBurning() && this.canSmelt())
                {
                    this.furnaceBurnTime = getItemBurnTime(itemstack);
                    this.currentItemBurnTime = this.furnaceBurnTime;

                    if (this.isBurning())
                    {
                        flag1 = true;

                        if (!itemstack.isEmpty())
                        {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);

                            if (itemstack.isEmpty())
                            {
                                ItemStack item1 = item.getContainerItem(itemstack);
                                //this.inventory.insertItem(1, stack, simulate).set(1, item1);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.totalCookTime)
                    {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime((ItemStack)this.inventory.getStackInSlot(0));
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
             */
    
}
