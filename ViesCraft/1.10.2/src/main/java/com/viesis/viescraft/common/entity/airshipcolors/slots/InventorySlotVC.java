package com.viesis.viescraft.common.entity.airshipcolors.slots;

import javax.annotation.Nullable;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventorySlotVC extends Slot {
	
	public InventorySlotVC(IInventory inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		//Item item = stack.getItem();
        
        //if (item == InitItemsVC.module_inventory_small)
        //{
        //	return true;
        //}
        
        return true;
    }
}
