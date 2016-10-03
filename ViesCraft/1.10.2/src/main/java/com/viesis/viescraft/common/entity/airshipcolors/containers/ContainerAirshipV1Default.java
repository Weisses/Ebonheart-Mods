package com.viesis.viescraft.common.entity.airshipcolors.containers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.InventorySlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.ModuleSlotVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiV1Default;

public class ContainerAirshipV1Default extends Container {

	private EntityAirshipV1Core airship;
	
	private int airshipBurnTime;
    
	/*
	 * SLOTS:
	 *
	 * Tile Entity 0-8 ........ 0  - 8
	 * Player Inventory 9-35 .. 9  - 35
	 * Player Inventory 0-8 ... 36 - 44
	 */
	public ContainerAirshipV1Default(IInventory playerInv, EntityAirshipV1Core airship) 
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
		
		// Expansion Module, Slot 1, Slot ID 1
		//for (int y = 0; y < 1; ++y) 
		//{
		//	for (int x = 0; x < 1; ++x) 
		//	{
		//		this.addSlotToContainer(new ModuleSlotVC(airship, 1, 116, 17));
		//	}
		//}
		
		// Airship Inventory, Slot 0-8, Slot IDs 0-8
		//if (EntityAirshipV1Core.isInventorySmallModuleInstalled(this.airship))
        //{
			//Slot test = this.getSlot(1);
			//for (int y = 0; y < 3; ++y) 
			//{
			//	for (int x = 0; x < 3; ++x) 
			//	{
			//		this.addSlotToContainer(new InventorySlotVC(airship, (x + y * 3) + 2, 26 + x * 18, 17 + y * 18));
			//	}
			//}
		
        //}
		
		
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
		
		
		
		LogHelper.info("Default");
		
		
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
            
            //if (this.fuelTime != this.airship.getField(2))
            //{
            //    icontainerlistener.sendProgressBarUpdate(this, 2, this.airship.getField(2));
            //}
            
            if (this.airshipBurnTime != this.airship.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.airship.getField(0));
            }
            
            //if (this.currentItemBurnTime != this.airship.getField(1))
            //{
            //    icontainerlistener.sendProgressBarUpdate(this, 1, this.airship.getField(1));
            //}
            
            //if (this.totalFuelTime != this.airship.getField(3))
            //{
            //    icontainerlistener.sendProgressBarUpdate(this, 3, this.airship.getField(3));
            //}
            
            //if (this.isModuleInventorySmall != this.airship.getField(5))
            //{
            //    icontainerlistener.sendProgressBarUpdate(this, 5, this.airship.getField(5));
                
                
            	
            //}
        }
        
        //this.fuelTime = this.airship.getField(2);
        this.airshipBurnTime = this.airship.getField(0);
        //this.currentItemBurnTime = this.airship.getField(1);
        //this.totalFuelTime = this.airship.getField(3);
        //this.isModuleInventorySmall = this.airship.getField(5);
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
                if (!this.mergeItemStack(current, 1, 37, true))
                {
                    return null;
                }

                slot.onSlotChange(current, previous);
            }
			
			//if (fromSlot < 2) 
			//{
				// From TE Inventory to Player Inventory
			//	if (!this.mergeItemStack(current, 2, 37, true))
			//	{
			//		return null;
			//	}
			//} 
			else 
			{
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 1, false))
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
