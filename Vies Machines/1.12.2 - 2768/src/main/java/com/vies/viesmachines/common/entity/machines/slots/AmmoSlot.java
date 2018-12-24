package com.vies.viesmachines.common.entity.machines.slots;

import com.vies.viesmachines.api.ItemsVM;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AmmoSlot extends SlotItemHandler {
	
	public AmmoSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		//if (item == ItemsVM.MACHINE_AMMO) return true;
        
		return false;
    }
}
