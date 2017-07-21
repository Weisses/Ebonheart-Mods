package com.viesis.viescraft.common.items.parts.pouch;

import java.util.List;

import javax.annotation.Nonnull;

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
    
    public ContainerPouchAll(EntityPlayer playerIn, InventoryPouch boxInv)
    {
        int i;
		int j;
		this.player = playerIn;
		this.pouch = boxInv;
		
        for(i = 0; i < 3; ++i)
        {
			for(j = 0; j < 8; ++j) 
			{
				addSlotToContainer(new SlotPouchAllVC(pouch, j + i * 8, 17 + j * 18, 17 + i * 18));
			}
        }
        
		for(i = 0; i < 3; ++i)
		{
			for(j = 0; j < 9; ++j)
			{
				addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; ++i) 
		{
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
    }
    
	@Override
	public boolean canInteractWith(@Nonnull EntityPlayer player) 
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void setAll(List<ItemStack> l) 
	{
    	super.setAll(l);
	}
	
	@Nonnull
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) 
	{
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(slotIndex);
		
		if(slot != null && slot.getHasStack()) 
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			int boxStart = 0;
			int boxEnd = boxStart + 24;
			int invEnd = boxEnd + 36;
			
			if(slotIndex < boxEnd) 
			{
				if(!mergeItemStack(itemstack1, boxEnd, invEnd, true))
				{
					return ItemStack.EMPTY;
				}
			} 
			else 
			{
				if(!itemstack1.isEmpty() 
				&& itemstack1.getItem() instanceof ItemPouchModule
				&& !mergeItemStack(itemstack1, boxStart, boxEnd, false))
				{
					return ItemStack.EMPTY;
				}
			}
			
			if(itemstack1.isEmpty())
			{
				slot.putStack(ItemStack.EMPTY);
			}
			else 
			{
				slot.onSlotChanged();
			}
			
			if(itemstack1.getCount() == itemstack.getCount())
			{
				return ItemStack.EMPTY;
			}
			
			slot.onTake(player, itemstack1);
		}
		
		return itemstack;
	}
}
