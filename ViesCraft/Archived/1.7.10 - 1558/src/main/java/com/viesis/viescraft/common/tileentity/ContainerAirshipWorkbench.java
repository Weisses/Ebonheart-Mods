package com.viesis.viescraft.common.tileentity;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.common.items.crafting.SlotCraftingVC;

public class ContainerAirshipWorkbench extends Container {

	/** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    
    private final World worldObj;
    /** Position of the workbench */
    //private final BlockPos pos;
    
    private TileEntityAirshipWorkbench airship;
    
    /*
	 * SLOTS:
	 *
	 * Crafting Output  1 ....... 0
	 * Crafting Matrix  9 ......  1 - 9
	 * Player Inventory 27 ... 10 - 36
	 * Player Inventory 9 .... 37 - 45
	 */
    public ContainerAirshipWorkbench(InventoryPlayer playerInventory, World worldIn, TileEntityAirshipWorkbench airship)
    {
        this.worldObj = worldIn;
        this.airship = airship;
        updateCraftingMatrix();
        // Index 0
        this.addSlotToContainer(new SlotCraftingVC(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        
        // Index 1 - 9
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 26 + j * 18, 17 + i * 18));
            }
        }
        
        // Index 10 - 36
        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        
        // Index 37 - 45
        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
        
        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
    private void updateCraftingMatrix() 
    {
    	for (int i = 0; i < craftMatrix.getSizeInventory(); i++) 
    	{
    		craftMatrix.setInventorySlotContents(i, airship.craftMatrixInventory[i]);
    	}
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManagerVC.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        
        saveCraftingMatrix();
        
    }
    
    private void saveCraftingMatrix() 
    {
    	for (int i = 0; i < craftMatrix.getSizeInventory(); i++) 
    	{
    		airship.craftMatrixInventory[i] = craftMatrix.getStackInSlot(i);
    	}
    }
    
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.airship.isUseableByPlayer(playerIn);//this.worldObj.getBlockState(this.pos).getBlock() != Blocks.CRAFTING_TABLE ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    /**
     * Take a stack from the specified inventory slot.
     */
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
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
    public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}
