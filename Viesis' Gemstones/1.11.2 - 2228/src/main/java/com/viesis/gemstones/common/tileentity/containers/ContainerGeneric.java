package com.viesis.gemstones.common.tileentity.containers;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class ContainerGeneric extends ContainerVC {
	
	private World world;
	private TileEntityGemstoneWorkbench gemstoneWorkbench;
    
	public ContainerGeneric(InventoryPlayer playerInv, World worldIn, TileEntityGemstoneWorkbench gemstoneWorkbenchIn) 
	{
		this.world = worldIn;
		this.gemstoneWorkbench = gemstoneWorkbenchIn;
	}
	/**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;//this.world.getBlockState(this.gemstoneWorkbench.getPos()).getBlock() != InitBlocksVG.gemstone_workbench ? false : playerIn.getDistanceSq((double)this.gemstoneWorkbench.getPos().getX() + 0.5D, (double)this.gemstoneWorkbench.getPos().getY() + 0.5D, (double)this.gemstoneWorkbench.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        //saveCraftingMatrix();
    }
    
    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        
        //saveCraftingMatrix();
    }
    
    
}
