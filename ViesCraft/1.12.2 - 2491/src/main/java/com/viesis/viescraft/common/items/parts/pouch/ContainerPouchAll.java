package com.viesis.viescraft.common.items.parts.pouch;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.viesis.viescraft.client.gui.pouch.InventoryPouch;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerPouchAll extends Container {
	
	private final EntityPlayer player;
    private final InventoryPouch pouch;
    
    public ContainerPouchAll(EntityPlayer playerIn, InventoryPouch pouchIn)
    {
        int i;
		int j;
		this.player = playerIn;
		this.pouch = pouchIn;
		
        for(i = 0; i < 3; ++i)
        {
			for(j = 0; j < 8; ++j) 
			{
				this.addSlotToContainer(new SlotPouchAllVC(this.pouch, j + i * 8, 17 + j * 18, 17 + i * 18));
			}
        }
        
		for(i = 0; i < 3; ++i)
		{
			for(j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(this.player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; ++i) 
		{
			this.addSlotToContainer(new Slot(this.player.inventory, i, 8 + i * 18, 142));
		}
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return true;
	}
	
	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) 
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotIndex);
		
		if(slot != null && slot.getHasStack()) 
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			/**
			int boxStart = 0;
			int boxEnd = boxStart + 24;
			int invEnd = boxEnd + 36;
			
			if(slotIndex < boxEnd) 
			{
				if(!mergeItemStack(itemstack1, boxEnd, invEnd, true))
				{
					return null;
				}
				
            	slot.onSlotChange(itemstack1, itemstack);
			} 
			else 
			{
				if(!mergeItemStack(itemstack1, boxStart, boxEnd, false))
				{
					return null;
				}
			}
			*/
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else 
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
}
