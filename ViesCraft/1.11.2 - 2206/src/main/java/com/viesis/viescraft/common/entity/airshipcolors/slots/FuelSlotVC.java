package com.viesis.viescraft.common.entity.airshipcolors.slots;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FuelSlotVC extends SlotItemHandler {
	
	public FuelSlotVC(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		if (item == InitItemsVC.viesoline_pellets) return true;
        
		return EntityAirshipV1Core.isItemFuel(stack) || isBucket(stack);
    }
	
	public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack.getItem() == Items.BUCKET;
    }
    
	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     
	@Override
    public boolean isItemValid(@Nullable ItemStack stack)
    {
		Item item = stack.getItem();
        
		if(ViesCraftConfig.vanillaFuel)
		{
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
    	}
        
		if (item == InitItemsVC.viesoline_pellets) return true;
        
        return false;
    }
    */
    
}
