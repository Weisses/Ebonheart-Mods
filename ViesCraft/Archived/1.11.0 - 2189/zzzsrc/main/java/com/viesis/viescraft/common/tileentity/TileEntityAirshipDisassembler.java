package com.viesis.viescraft.common.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.api.UncraftRecipesVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAirshipDisassembler extends TileEntity
//implements ITickable 
{
    
    public ItemStackHandler inventory;
    private int size = 10;
    private int airshipInSlot;
    private boolean tests = false;
    
    public TileEntityAirshipDisassembler() 
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
    
    
    /**
	@Override
	public void update() 
	{
		this.isAirshipInSlot();
		
	}
	
	
	
	
	private void isAirshipInSlot()
	{
		
		ItemStack itemModule = this.inventory.getStackInSlot(0);
		int uncraftID = this.getUncraftID(itemModule);
		
		/**
		if(this.worldObj.isRemote)
		{
			if(this.getModuleInventorySmall())
				LogHelper.info("1");
			if(this.getModuleInventoryLarge())
				LogHelper.info("2");
			if(this.getModuleSpeedMinor())
				LogHelper.info("3");
			if(this.getModuleFuelInfinite())
				LogHelper.info("4");
			if(this.getModuleStealth())
				LogHelper.info("5");
			if(this.getModuleDash())
				LogHelper.info("6");
		}
		*
		
		//Syncs the module boolean client side
		//if(this.worldObj.isRemote)
		//{
    	//	this.moduleInventorySmall = this.getModuleInventorySmall();
    	///	this.moduleInventoryLarge = this.getModuleInventoryLarge();
    	//	this.moduleSpeedMinor = this.getModuleSpeedMinor();
    	//	this.moduleSpeedMajor = this.getModuleSpeedMajor();
    	//	this.moduleFuelInfinite = this.getModuleFuelInfinite();
		//}
		////////////////////ItemStack test;
		////////////////if(this.inventory.getStackInSlot(1).getItem() != null
		//&& this.inventory.getStackInSlot(2).getItem() == null
		//&& this.inventory.getStackInSlot(3).getItem() == null
		//&& this.inventory.getStackInSlot(4).getItem() == null
		//&& this.inventory.getStackInSlot(5).getItem() == null
		//&& this.inventory.getStackInSlot(6).getItem() == null
		//&& this.inventory.getStackInSlot(7).getItem() == null
		//&& this.inventory.getStackInSlot(8).getItem() == null
		//&& this.inventory.getStackInSlot(9).getItem() == null
		//)
		//{
		//	tests = true;
		//	LogHelper.info("Is True");
		//}
		//LogHelper.info(this.inventory.getStackInSlot(1).getItem());
		if(uncraftID == 1)
		{
			
			
			//if(tests)
			//{
				for (int x = 1; x < 10; ++x) 
				{
					this.inventory.setStackInSlot(x, UncraftRecipesVC.AIRSHIPV1BASE[x]);
				}
				
				this.inventory.getStackInSlot(0).func_190918_g(1);
			//}
		}
		
		else if(uncraftID == 2)
		{
			
			
			LogHelper.info("uncraftID = 2");
			
			LogHelper.info(this.inventory.getStackInSlot(0));
		}
		else if(uncraftID == 3)
		{
			
			LogHelper.info("uncraftID = 3");
			
			LogHelper.info(this.inventory.getStackInSlot(0));
		}
		else if(uncraftID == 4)
		{
			
			LogHelper.info("uncraftID = 4");
			
			LogHelper.info(this.inventory.getStackInSlot(0));
		}
		else if(uncraftID == 5)
		{
			
			LogHelper.info("uncraftID = 5");
			LogHelper.info(this.inventory.getStackInSlot(0));
		}
		else// if(moduleNumber == 0)
		{
			
		}
		
		
		
		
		
		//LogHelper.info(this.inventory.getStackInSlot(0));
	}
	
	**
     * Checks if a module is in the module slot.
     *
    public static boolean getItemUncraft(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }
        else
        {
            Item item = stack.getItem();
            
            //Passive
            if (item == InitItemsVC.item_airship_v1_wood0_normal) return true;
            if (item == InitItemsVC.item_airship_v1_iron_normal) return true;
            if (item == InitItemsVC.item_airship_v1_redstone_normal) return true;
            if (item == InitItemsVC.item_airship_v1_gold_normal) return true;
            if (item == InitItemsVC.item_airship_v1_lapislazuli_normal) return true;
            if (item == InitItemsVC.item_airship_v1_obsidian_normal) return true;
            if (item == InitItemsVC.item_airship_v1_diamond_normal) return true;
            if (item == InitItemsVC.item_airship_v1_emerald_normal) return true;
            
            return false;
        }
    }
    
    **
     * Set module ID for module in slot.
     *
    public static int getUncraftID(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            if (item == InitItemsVC.item_airship_v1_wood0_normal)
            {
            	return 1;
            }
            else if (item == InitItemsVC.item_airship_v1_iron_normal)
            {
            	return 2;
            }
            else if (item == InitItemsVC.item_airship_v1_redstone_normal)
            {
            	return 3;
            }
            else if (item == InitItemsVC.item_airship_v1_gold_normal)
            {
            	return 4;
            }
            else if (item == InitItemsVC.item_airship_v1_lapislazuli_normal)
            {
            	return 5;
            }
            else if (item == InitItemsVC.item_airship_v1_obsidian_normal)
            {
            	return 6;
            }
            else if (item == InitItemsVC.item_airship_v1_diamond_normal)
            {
            	return 7;
            }
            else if (item == InitItemsVC.item_airship_v1_emerald_normal)
            {
            	return 8;
            }
            else 
            {
            	return 0;
            }
        }
    }
    
    **
     * Set module ID for module in slot.
     *
    public void getV1Parts()
    {
    	ItemStackHandler slotItem = this.inventory;
    	
    	slotItem.setStackInSlot(1, new ItemStack(Items.LEAD));
    	slotItem.setStackInSlot(2, new ItemStack(InitItemsVC.airship_balloon));
    	slotItem.setStackInSlot(3, new ItemStack(Items.LEAD));
    	slotItem.setStackInSlot(4, new ItemStack(InitItemsVC.airship_engine));
    	//this.inventory.setStackInSlot(5, new ItemStack(----));
    	slotItem.setStackInSlot(6, new ItemStack(InitItemsVC.airship_engine));
    	slotItem.setStackInSlot(7, new ItemStack(Items.LEAD));
    	slotItem.setStackInSlot(8, new ItemStack(InitItemsVC.airship_ignition));
    	slotItem.setStackInSlot(9, new ItemStack(Items.LEAD));
    	
    	
    	//this.inventory.setStackInSlot(0, null);
    	
    }
    */
    
    
}
