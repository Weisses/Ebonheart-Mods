package com.viesis.viescraft.common.entity.airships.slots;

import com.viesis.viescraft.api.ItemsVC;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModuleBombSlotVC extends SlotItemHandler {
	
	public ModuleBombSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		if (item == ItemsVC.BOMB)
        {
        	if(stack.getMetadata() != 0)
        	{
        		return true;
        	}
        }
        
		return false;
    }
}
