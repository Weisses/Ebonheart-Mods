package com.viesis.viescraft.common.entity.airshipcolors.slots;

import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class VGSlotVC extends SlotItemHandler {
	
	public VGSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		if (item == InitItemsVG.GEMSTONE_ITEM_BASIC_V1) return true;
		
        return false;
    }
}
