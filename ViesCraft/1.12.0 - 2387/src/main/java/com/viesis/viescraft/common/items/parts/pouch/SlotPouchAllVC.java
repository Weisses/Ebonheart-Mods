package com.viesis.viescraft.common.items.parts.pouch;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotPouchAllVC extends SlotItemHandler {
	
    public SlotPouchAllVC(IItemHandler itemHandler, int index, int xPosition, int yPosition)
    {
        super(itemHandler, index, xPosition, yPosition);
    }
    
    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack)
    {
    	if(stack.getItem() == InitItemsVC.ITEM_POUCH_MODULE
    	//|| stack.getItem() == InitItemsVC.ITEM_POUCH_ALL
    			)
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
}
