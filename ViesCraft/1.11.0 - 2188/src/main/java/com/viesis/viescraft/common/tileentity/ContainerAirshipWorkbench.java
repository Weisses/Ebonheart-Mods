package com.viesis.viescraft.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.common.items.crafting.SlotCraftingVC;
import com.viesis.viescraft.init.InitBlocksVC;

public class ContainerAirshipWorkbench extends Container {
	
	/** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    
    public IInventory craftResult = new InventoryCraftResult();
    
    private final World worldObj;
    
    /** Position of the workbench */
    private final TileEntityAirshipWorkbench airship;
    
    public ContainerAirshipWorkbench(InventoryPlayer playerInventory, World worldIn, TileEntityAirshipWorkbench tileEntityAirshipWorkbench)
    {
        this.worldObj = worldIn;
        this.airship = tileEntityAirshipWorkbench;
        
        //updateCraftingMatrix();
        
        //CraftResult Slot, Slot 0, Slot ID 0
        this.addSlotToContainer(new SlotCraftingVC(playerInventory.player, this.craftMatrix, this.airship.inventory, 0, 124, 35));
        
        //Craft Matrix, Slot 1-9, Slot ID 0
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
            	this.addSlotToContainer(new SlotItemHandler(this.airship.inventory, j + i * 3, 26 + j * 18, 17 + i * 18));
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
    
    //private void updateCraftingMatrix() 
    //{
    //	NBTTagCompound compound = new NBTTagCompound();
    	
    //	this.airship.inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    //}
    //	for (int i = 0; i < craftMatrix.getSizeInventory(); i++) 
    //	{
    		//if(airship.itemStackHandler.getStackInSlot(i) != null)
    //		craftMatrix.setInventorySlotContents(i, this.airship.inventory.getStackInSlot(i));//
    		//.craftMatrixInventory[i]);
    //	}
    //}
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IItemHandler inventoryIn)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManagerVC.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        //saveCraftingMatrix();
        
        //if (!this.worldObj.isRemote)
        //{
        //    for (int i = 0; i < 9; ++i)
        //    {
        //        ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);

        //        if (!itemstack.func_190926_b())
        //        {
        //            playerIn.dropItem(itemstack, false);
        //        }
        //    }
        //}
    }
    
    //private void saveCraftingMatrix() 
    //{
    	
    	//this.airship.inventory.serializeNBT();
    	//for (int i = 0; i < craftMatrix.getSizeInventory(); i++) 
    	//{
    	//	ItemStack test = airship.itemStackHandler.getStackInSlot(i);
    				
    	//	test = craftMatrix.getStackInSlot(i);
    		
    		//airship.craftMatrixInventory[i] = craftMatrix.getStackInSlot(i);
    		
    	//}
    //}

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.worldObj.getBlockState(this.airship.getPos()).getBlock() != InitBlocksVC.airship_workbench ? false : playerIn.getDistanceSq((double)this.airship.getPos().getX() + 0.5D, (double)this.airship.getPos().getY() + 0.5D, (double)this.airship.getPos().getZ() + 0.5D) <= 64.0D;
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

            if (index < 3 * 9)
            {
                if (!this.mergeItemStack(itemstack1, 3 * 9, this.inventorySlots.size(), true))
                {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 3 * 9, false))
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
