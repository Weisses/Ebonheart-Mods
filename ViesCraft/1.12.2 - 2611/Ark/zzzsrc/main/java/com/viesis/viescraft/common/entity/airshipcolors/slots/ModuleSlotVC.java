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
	
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		Item item = stack.getItem();
        
        if (item == InitItemsVC.AIRSHIP_MODULE)
        {
        	if(stack.getMetadata() != 0)
        	{
        		return true;
        	}
        }
        
        return false;
    }
}
