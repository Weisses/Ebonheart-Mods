package com.viesis.viescraft.common.entity.airshipcolors.slots;

import javax.annotation.Nullable;

import com.viesis.viescraft.api.FuelVC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class FuelSlotVC extends Slot {
	
	public FuelSlotVC(IInventory inventoryIn, int index, int xPosition, int yPosition) 
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
        
		if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(item);
            
            if (block == Blocks.WOODEN_SLAB)
            {
                return true;
            }
            
            if (block.getDefaultState().getMaterial() == Material.WOOD)
            {
                return true;
            }
            
            if (block == Blocks.COAL_BLOCK)
            {
                return true;
            }
        }
        
        if (item == Items.STICK) return true;
        if (item == Item.getItemFromBlock(Blocks.SAPLING)) return true;
        if (item == Items.COAL) return true;
        if (item == Items.BLAZE_ROD) return true;
		
        return false;
    }
}
