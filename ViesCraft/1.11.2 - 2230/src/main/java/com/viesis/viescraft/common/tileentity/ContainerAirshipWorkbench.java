package com.viesis.viescraft.common.tileentity;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.common.items.crafting.SlotCraftingVC;
import com.viesis.viescraft.init.InitBlocksVC;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerAirshipWorkbench extends Container {
	
	/** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    
    public IInventory craftResult = new InventoryCraftResult();
    
    private final World world;
    
    /** Position of the workbench */
    private final TileEntityAirshipWorkbench airship;
    
    public ContainerAirshipWorkbench(InventoryPlayer playerInventory, World worldIn, TileEntityAirshipWorkbench tileEntityAirshipWorkbench)
    {
        this.world = worldIn;
        this.airship = tileEntityAirshipWorkbench;
        
        loadCraftingMatrix();
        
        //CraftResult Slot, Slot 0, Slot ID 0
        this.addSlotToContainer(new SlotCraftingVC(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        
        //Craft Matrix, Slot 1-9, Slot ID 0
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
            	this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 26 + j * 18, 17 + i * 18));
            }
        }
        
        // Player Hotbar, Slot 0-8, Slot IDs 36-44
        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
        
        // Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        
        this.onCraftMatrixChanged(this.craftMatrix);
        
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
    	this.craftResult.setInventorySlotContents(0, CraftingManagerVC.getInstance().findMatchingRecipe(this.craftMatrix, this.world));
    }
    
    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        
        saveCraftingMatrix();
    }
    
    /**
     * Loads the workbench inventory to the crafting matrix.
     */
    private void loadCraftingMatrix() 
    {
    	for (int i = 0; i < this.craftMatrix.getSizeInventory(); i++) 
    	{
    		this.craftMatrix.setInventorySlotContents(i, this.airship.inventory.getStackInSlot(i));
    	}
    }
    
    /**
     * Saves the crafting matrix to the workbench inventory.
     */
    private void saveCraftingMatrix()
    {
	  	for (int i = 0; i < this.craftMatrix.getSizeInventory(); i++) 
    	{
    		this.airship.inventory.setStackInSlot(i, this.craftMatrix.getStackInSlot(i));
    	}
    }
    
    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.world.getBlockState(this.airship.getPos()).getBlock() != InitBlocksVC.airship_workbench ? false : playerIn.getDistanceSq((double)this.airship.getPos().getX() + 0.5D, (double)this.airship.getPos().getY() + 0.5D, (double)this.airship.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    /**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);

            if (index == 0)
            {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        saveCraftingMatrix();
    }
}
