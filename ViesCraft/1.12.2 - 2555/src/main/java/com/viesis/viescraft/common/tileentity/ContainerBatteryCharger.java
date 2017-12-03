package com.viesis.viescraft.common.tileentity;

import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.BatterySlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.InventorySlotVC;
import com.viesis.viescraft.init.InitBlocksVC;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;

public class ContainerBatteryCharger extends ContainerVC {
	
	/** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    
    public IInventory craftResult = new InventoryCraftResult();
    
    private final World world;
    
    /** Position of the workbench */
    private final TileEntityBatteryCharger airship;
    
    public ContainerBatteryCharger(InventoryPlayer playerInventory, World worldIn, TileEntityBatteryCharger tileEntityBatteryCharger)
    {
        this.world = worldIn;
        this.airship = tileEntityBatteryCharger;
        
        //loadCraftingMatrix();
        
        //CraftResult Slot, Slot 0, Slot ID 0
        //this.addSlotToContainer(new SlotCraftingVC(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        
        //this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 152, 17));
		
        this.addSlotToContainer(new BatterySlotVC(this.airship.inventory, 0, 80, 58));
        
        this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 1, 57, 24));
        this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 2, 80, 17));
        this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 3, 103, 24));
        
        //Craft Matrix, Slot 1-9, Slot ID 0
        //for (int i = 0; i < 3; ++i)
        //{
        //    for (int j = 0; j < 3; ++j)
        //    {
        //    	this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 26 + j * 18, 17 + i * 18));
        //    }
        //}
        
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
        
        //this.onCraftMatrixChanged(this.craftMatrix);
        
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     
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
        
        //saveCraftingMatrix();
    }
    
    /**
     * Loads the workbench inventory to the crafting matrix.
     
    private void loadCraftingMatrix() 
    {
    	for (int i = 0; i < this.craftMatrix.getSizeInventory(); i++) 
    	{
    		this.craftMatrix.setInventorySlotContents(i, this.airship.inventory.getStackInSlot(i));
    	}
    }
    
    /**
     * Saves the crafting matrix to the workbench inventory.
     
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
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.world.getBlockState(this.airship.getPos()).getBlock() != InitBlocksVC.AIRSHIP_WORKBENCH ? false : playerIn.getDistanceSq((double)this.airship.getPos().getX() + 0.5D, (double)this.airship.getPos().getY() + 0.5D, (double)this.airship.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     
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
    */
}
