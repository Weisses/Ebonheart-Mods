package com.vies.viesmachines.common.entity.machines.slots;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineFuel;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FuelSlot extends SlotItemHandler {
	
	public FuelSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) 
	{
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
		Item item = stack.getItem();
        
		if (item == ItemsVM.MACHINE_PELLETS) return true;
        
		return EntityMachineFuel.isItemFuel(stack) || isBucket(stack);
    }
	
	public int getItemStackLimit(ItemStack stack)
    {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack)
    {
        return stack.getItem() == Items.BUCKET;
    }
}
