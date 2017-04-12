package com.viesis.viescraft.common.entity.airshipcolors.slots;

import javax.annotation.Nullable;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModuleSlotVC extends SlotItemHandler {
	
	public ModuleSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
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
        
        if (item == InitItemsVC.module_inventory_small
         || item == InitItemsVC.module_inventory_large
		 || item == InitItemsVC.module_speed_increase_minor
		 || item == InitItemsVC.module_speed_increase_major
		 || item == InitItemsVC.module_fuel_infinite)
        {
        	return true;
        }
        
        return false;
    }
}
