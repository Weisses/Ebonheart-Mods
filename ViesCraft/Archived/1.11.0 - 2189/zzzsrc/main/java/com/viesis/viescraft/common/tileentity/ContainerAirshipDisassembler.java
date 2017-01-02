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

import com.viesis.viescraft.api.UncraftRecipesVC;
import com.viesis.viescraft.common.items.decrafting.InventoryUncraftResult;
import com.viesis.viescraft.common.items.decrafting.SlotDecraftingVC;
import com.viesis.viescraft.init.InitBlocksVC;

public class ContainerAirshipDisassembler extends Container {
	
	/** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 1, 1);
    
    public IInventory craftResult = new InventoryCraftResult();
    
    private final World worldObj;
    
    /** Position of the disassembler */
    private final TileEntityAirshipDisassembler airship;
    
    public ContainerAirshipDisassembler(InventoryPlayer playerInventory, World worldIn, TileEntityAirshipDisassembler tileEntityAirshipDisassembler)
    {
        this.worldObj = worldIn;
        this.airship = tileEntityAirshipDisassembler;
        
        loadCraftingMatrix();
        
        //CraftMartix Slot, Slot 0, Slot ID 0
        /////this.addSlotToContainer(new SlotDecraftingVC(playerInventory.player, this.craftMatrix, this.craftResult, 0, 36, 35));
        this.addSlotToContainer(new Slot(this.craftMatrix, 0, 36, 35));
        
        
        //Craft Result, Slot 1-9, Slot ID 0
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
            	this.addSlotToContainer(new SlotDecraftingVC(playerInventory.player, this.craftMatrix, this.craftResult, 1 + (j + i * 3), 98 + j * 18, 17 + i * 18));
            	//////this.addSlotToContainer(new Slot(this.craftMatrix, 1 + (j + i * 3), 98 + j * 18, 17 + i * 18));
                
            	
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
    	
    	ItemStack[] aitemstack = UncraftRecipesVC.AIRSHIPV1BASE;
    	
    	this.craftResult.setInventorySlotContents(1, aitemstack[1]);
    	this.craftResult.setInventorySlotContents(2, aitemstack[2]);
    	this.craftResult.setInventorySlotContents(3, aitemstack[3]);
    	this.craftResult.setInventorySlotContents(4, aitemstack[4]);
    	this.craftResult.setInventorySlotContents(5, aitemstack[5]);
    	this.craftResult.setInventorySlotContents(6, aitemstack[6]);
    	this.craftResult.setInventorySlotContents(7, aitemstack[7]);
    	this.craftResult.setInventorySlotContents(8, aitemstack[8]);
    	//this.craftResult.setInventorySlotContents(9, aitemstack[9]);
    	
    			//CraftingManagerVC.getInstance().findMatchingRecipe(craftMatrix, worldIn).func_180303_b(this.craftMatrix, this.worldObj);
    	
    	//ItemStack[] aitemstack = CraftingManagerVC.getInstance().func_180303_b(this.craftMatrix, playerIn.worldObj);
    	//for (int i = 0; i < this.craftMatrix.getSizeInventory(); i++) 
    	//{//
    		//this.craftResult.setInventorySlotContents(1, 
    		//		aitemstack[1]
    				//DeCraftingManagerVC.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj)
    		//		);
    	//}
    	
    		
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
        return this.worldObj.getBlockState(this.airship.getPos()).getBlock() != InitBlocksVC.airship_disassembler ? false : playerIn.getDistanceSq((double)this.airship.getPos().getX() + 0.5D, (double)this.airship.getPos().getY() + 0.5D, (double)this.airship.getPos().getZ() + 0.5D) <= 64.0D;
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
                itemstack1.getItem().onCreated(itemstack1, this.worldObj, playerIn);

                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return ItemStack.field_190927_a;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return ItemStack.field_190927_a;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
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

            ItemStack itemstack2 = slot.func_190901_a(playerIn, itemstack1);

            if (index == 0)
            {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }
}
