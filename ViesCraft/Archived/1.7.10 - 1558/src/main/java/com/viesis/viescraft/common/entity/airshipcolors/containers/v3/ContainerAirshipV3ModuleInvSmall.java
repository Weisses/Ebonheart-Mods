package com.viesis.viescraft.common.entity.airshipcolors.containers.v3;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.InventorySlotVC;

//Small Inventory Module
public class ContainerAirshipV3ModuleInvSmall extends Container {
	
	private EntityAirshipV3Core airship;
	
	private int airshipBurnTime;
	
	/*
	 * SLOTS:
	 *
	 * Airship Fuel ........... 0
	 * Airship Module ......... 1
	 * Airship Inv ............ 2 - 20
	 */
	public ContainerAirshipV3ModuleInvSmall(IInventory playerInv, EntityAirshipV3Core airship) 
	{
		this.airship = airship;
		
		// Fuel Slot, Slot 0, Slot ID 0
		for (int y = 0; y < 1; ++y) 
		{
			for (int x = 0; x < 1; ++x) 
			{
				this.addSlotToContainer(new FuelSlotVC(airship, 0, 152, 17));
			}
		}
		
		//Slot test = this.getSlot(1);
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 3; ++x) 
			{
				this.addSlotToContainer(new InventorySlotVC(airship, (x + y * 3) + 2, 35 + x * 18, 17 + y * 18));
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
	
	public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.airship);
    }
	
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
	@Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);
            
            if (this.airshipBurnTime != this.airship.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.airship.getField(0));
            }
        }
        
        this.airshipBurnTime = this.airship.getField(0);
    }
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
	
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.airship.isUseableByPlayer(playerIn);
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) 
	{
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);
		
		if (slot != null && slot.getHasStack()) 
		{
			ItemStack current = slot.getStack();
			previous = current.copy();
			
			// From Airship Inventory to Player Inventory
			if (fromSlot == 0)
            {
                if (!this.mergeItemStack(current, 1, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(current, previous);
            }
			else 
			{
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 1, true))
				{
					return null;
				}
			}
			
			if (current.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (current.stackSize == previous.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(playerIn, current);
		}
		
		return previous;
	}
}
