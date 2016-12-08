package com.viesis.viescraft.common.entity.airshipcolors.containers.v4;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.InventorySlotVC;

public class ContainerAirshipV4ModuleInvLarge extends Container {
	
	private EntityAirshipV4Core airship;
	
	private int airshipBurnTime;
    
	/*
	 * SLOTS:
	 *
	 * Airship Fuel ........... 0
	 * Airship Module ......... 1
	 * Airship Inv ............ 2 - 20
	 */
	public ContainerAirshipV4ModuleInvLarge(IInventory playerInv, EntityAirshipV4Core airship) 
	{
		this.airship = airship;
		
		// Fuel Slot, Slot 0, Slot ID 0
		for (int y = 0; y < 1; ++y) 
		{
			for (int x = 0; x < 1; ++x) 
			{
				this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 152, 17));
			}
		}
		
		// Airship Inventory, Slot 0-8, Slot IDs 0-8
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 3; ++x) 
			{
				this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 2, 8 + x * 18, 17 + y * 18));
			}
		}
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 3; ++x) 
			{
				this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 2) + 9, 62 + x * 18, 17 + y * 18));
			}
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
	
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }
    
    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.field_190927_a;
        Slot slot = (Slot)this.inventorySlots.get(index);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (index == 0)
            {
            	if (!this.mergeItemStack(itemstack1, 1, 37, true))
                {
                    return ItemStack.field_190927_a;
                }
            	
            	slot.onSlotChange(itemstack1, itemstack);
            }
            else
            {
            	if (!this.mergeItemStack(itemstack1, 0, 1, false))
				{
					return ItemStack.field_190927_a;
				}
            }
            
            if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.field_190927_a;
            }
            
            if (itemstack1.func_190926_b())
            {
                slot.putStack(ItemStack.field_190927_a);
            }
            else
            {
                slot.onSlotChanged();
            }
            
            if (itemstack1.func_190916_E() == itemstack.func_190916_E())
            {
                return ItemStack.field_190927_a;
            }
            
            slot.func_190901_a(playerIn, itemstack1);
        }
        
        return itemstack;
    }
}