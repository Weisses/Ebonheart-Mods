package com.viesis.viescraft.common.tileentity;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipWorkbench extends Container {
	
	/**
	/** The crafting matrix inventory (3x3). */
	/**    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    private final World worldObj;
    /** Position of the workbench */
	/**    private final BlockPos pos;
	//private final InventoryPlayer p;
    private TileEntityAirshipWorkbench airship;
    
    public ContainerAirshipWorkbench(IInventory playerInv, TileEntityAirshipWorkbench airship)
    		//InventoryPlayer playerInventory, World worldIn, BlockPos posIn)
    {
    	this.airship = airship;
        //this.worldObj = worldIn;
        //this.pos = posIn;
        
        this.addSlotToContainer(new SlotCrafting(p.player, this.craftMatrix, this.craftResult, 0, 124, 35));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(airship, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(airship, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
	/**    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    /**
     * Called when the container is closed.
     */
	/**   public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 9; ++i)
            {
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);

                if (itemstack != null)
                {
                    playerIn.dropItem(itemstack, false);
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.worldObj.getBlockState(this.pos).getBlock() != Blocks.CRAFTING_TABLE ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
	/**   @Nullable
    /**    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

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

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
	/**    public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}
	*/
	
	private TileEntityAirshipWorkbench airship;
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	
	/*
	 * SLOTS:
	 *
	 * Tile Entity 0-8 ........ 0  - 8
	 * Player Inventory 9-35 .. 9  - 35
	 * Player Inventory 0-8 ... 36 - 44
	 */
	public ContainerAirshipWorkbench(IInventory playerInv, TileEntityAirshipWorkbench airship) 
	{
		this.airship = airship;
		
		//this.addSlotToContainer(new SlotCrafting(p.player, this.craftMatrix, this.craftResult, 0, 124, 35));

		// Airship Inventory, Slot 0-8, Slot IDs 0-8
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 3; ++x) 
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, x + y * 3, 26 + x * 18, 17 + y * 18));
			}
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
		
		// Fuel Slot, Slot 0, Slot ID 45
		for (int y = 0; y < 1; ++y) 
		{
			for (int x = 0; x < 1; ++x) 
			{
				this.addSlotToContainer(new Slot(airship, 9, 134, 35));
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
	*/
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
			
			if (fromSlot < 9) 
			{
				// From TE Inventory to Player Inventory
				if (!this.mergeItemStack(current, 9, 45, true))
				{
					return null;
				}
			} 
			else 
			{
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 9, false))
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
