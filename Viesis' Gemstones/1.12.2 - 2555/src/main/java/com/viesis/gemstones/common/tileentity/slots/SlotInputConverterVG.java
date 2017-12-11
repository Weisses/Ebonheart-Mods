package com.viesis.gemstones.common.tileentity.slots;

import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotInputConverterVG extends SlotItemHandler {
	
	public SlotInputConverterVG(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
		
		if(item == InitItemsVG.GEMSTONE_ITEM_BASIC_V1) return true;
		if(item == InitItemsVG.GEMSTONE_ITEM_ENCHANTED_V1) return true;
        
		return false;
    }
}
