package com.viesis.viescraft.common.entity.airshipcolors.slots;

import javax.annotation.Nullable;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.init.InitItemsVC;

public class ModuleSlotVC extends Slot {
	
	public ModuleSlotVC(IInventory inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		Item item = stack.getItem();
        
        if (item == InitItemsVC.module_inventory_small)
        {
        	return true;
        }
        
        if (item == InitItemsVC.module_inventory_large)
        {
        	return true;
        }
        
        if (item == InitItemsVC.module_speed_increase_minor)
        {
        	return true;
        }
        
        if (item == InitItemsVC.module_fuel_infinite)
        {
        	return true;
        }
        
        //if (item == InitItemsVC.module_stealth)
        //{
        //	return true;
        //}
        
        //if (item == InitItemsVC.module_dash)
        //{
        //	return true;
        //}
		
        return false;
    }
}
