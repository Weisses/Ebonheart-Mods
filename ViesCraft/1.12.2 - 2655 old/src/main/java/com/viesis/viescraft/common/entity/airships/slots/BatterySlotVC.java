package com.viesis.viescraft.common.entity.airships.slots;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BatterySlotVC extends SlotItemHandler {
	
	public BatterySlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		//if (item == InitItemsVC.airship_battery) return true;
        
        return false;
    }
}
