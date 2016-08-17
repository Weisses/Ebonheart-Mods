package com.viesis.viescraft.common.entity.airshipcolors;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipCore extends Container {

	private EntityAirshipCore airship;
	
	//private final IInventory airship;
    private int fuelTime;
    private int totalFuelTime;
    private int airshipBurnTime;
    private int currentItemBurnTime;
	
	private int [] cachedFields;
	
	//private final int fuel_slots = 4;
	//private final int input_slots = 5;
	//private final int furnace_slots = fuel_slots + input_slots;
	
	//private final int first_fuel_index = 0000;
	//private final int first_fuel_slot = 0;
	
	//public final int FUEL_SLOTS_COUNT = 4;
	
	/*
	 * SLOTS:
	 *
	 * Tile Entity 0-8 ........ 0  - 8
	 * Player Inventory 9-35 .. 9  - 35
	 * Player Inventory 0-8 ... 36 - 44
	 */
	public ContainerAirshipCore(IInventory playerInv, EntityAirshipCore airship) {
			this.airship = airship;

		// Airship Inventory, Slot 0-8, Slot IDs 0-8
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 3; ++x) {
				this.addSlotToContainer(new Slot(airship, x + y * 3, 
						//62 
						26 + x * 18, 17 + y * 18));
			}
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
		
		// Fuel Slot, Slot 0, Slot ID 45
		
		for (int y = 0; y < 1; ++y) {
			for (int x = 0; x < 1; ++x) {
				this.addSlotToContainer(new Slot
						//Fuel
						(airship, 9//x + y * 3, 
						//62 
						//44
						,
						134, 35));
			}
		}
		//this.addSlotToContainer(new SlotFuel(airship, 0, 134, 35));
		
	}
	
	public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.airship);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

            if (this.fuelTime != this.airship.getField(2))
            {
                icontainerlistener.sendProgressBarUpdate(this, 2, this.airship.getField(2));
            }

            if (this.airshipBurnTime != this.airship.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.airship.getField(0));
            }

            if (this.currentItemBurnTime != this.airship.getField(1))
            {
                icontainerlistener.sendProgressBarUpdate(this, 1, this.airship.getField(1));
            }

            if (this.totalFuelTime != this.airship.getField(3))
            {
                icontainerlistener.sendProgressBarUpdate(this, 3, this.airship.getField(3));
            }
        }

        this.fuelTime = this.airship.getField(2);
        this.airshipBurnTime = this.airship.getField(0);
        this.currentItemBurnTime = this.airship.getField(1);
        this.totalFuelTime = this.airship.getField(3);
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
	
	//@Override
	//public boolean canInteractWith(EntityPlayer playerIn) {
	//	return this.airship.isUseableByPlayer(playerIn);
	//}

	/**
     * Take a stack from the specified inventory slot.
     
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index != 9)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            //else if (index != 1 && index != 0)
            //{
            //    if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null)
            //    {
            //        if (!this.mergeItemStack(itemstack1, 0, 1, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (TileEntityFurnace.isItemFuel(itemstack1))
            //    {
            //        if (!this.mergeItemStack(itemstack1, 1, 2, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (index >= 3 && index < 30)
            //    {
            //        if (!this.mergeItemStack(itemstack1, 30, 39, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
            //    {
            //        return null;
            //    }
            //}
            //else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            //{
            //    return null;
            //}

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }
	*/
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();

			if (fromSlot < 9) {
				// From TE Inventory to Player Inventory
				if (!this.mergeItemStack(current, 9, 45, true))
					return null;
			} else {
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 9, false))
					return null;
			}

			if (current.stackSize == 0)
				slot.putStack((ItemStack) null);
			else
				slot.onSlotChanged();

			if (current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(playerIn, current);
		}

		return previous;
	}
	
	
	
	// SlotFuel is a slot for fuel items
		public class SlotFuel extends Slot {
			public SlotFuel(IInventory inventoryIn, int index, int xPosition,
					int yPosition) {
				super(inventoryIn, index, xPosition, yPosition);
			}

			// if this function returns false, the player won't be able to insert
			// the given item into this slot
			@Override
			public boolean isItemValid(ItemStack stack) {
				return EntityAirshipCore.isItemValidForFuelSlot(stack);
			}
		}
}
		/**
		public void addListener(IContainerListener listener)
	    {
	        super.addListener(listener);
	        listener.sendAllWindowProperties(this, this.airship);
	    }

	    /**
	     * Looks for changes made in the container, sends them to every listener.
	     */
		/**  public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.listeners.size(); ++i)
	        {
	            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

	            if (this.cookTime != this.airship.getField(2))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 2, this.airship.getField(2));
	            }

	            if (this.furnaceBurnTime != this.airship.getField(0))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 0, this.airship.getField(0));
	            }

	            if (this.currentItemBurnTime != this.airship.getField(1))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 1, this.airship.getField(1));
	            }

	            if (this.totalCookTime != this.airship.getField(3))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 3, this.airship.getField(3));
	            }
	        }

	        this.cookTime = this.airship.getField(2);
	        this.furnaceBurnTime = this.airship.getField(0);
	        this.currentItemBurnTime = this.airship.getField(1);
	        this.totalCookTime = this.airship.getField(3);
	    }

	    //@SideOnly(Side.CLIENT)
	    //public void updateProgressBar(int id, int data)
	    //{
	    //    this.airship.setField(id, data);
	    //}
	
}
*/