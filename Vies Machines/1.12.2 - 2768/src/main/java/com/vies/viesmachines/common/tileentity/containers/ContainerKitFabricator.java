package com.vies.viesmachines.common.tileentity.containers;

import com.vies.viesmachines.api.BlocksVM;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.slots.SlotInputKitFabricator;
import com.vies.viesmachines.common.tileentity.slots.SlotOutputVM;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerKitFabricator extends ContainerTileEntityVM {
	
	private final World world;
    private final TileEntityKitFabricator appliance;
    
    private int cutTime;
    private int totalCutTime;
    private int procChance;
    private boolean isOn;
    
    public ContainerKitFabricator(InventoryPlayer playerInventory, World worldIn, TileEntityKitFabricator applianceIn)
    {
    	this.world = worldIn;
        this.appliance = applianceIn;

        // Item Input slot:
        this.addSlotToContainer(new SlotInputKitFabricator(this.appliance.inventory, 0, 80+12, 53+9));
        
        // Shard output slot:
        this.addSlotToContainer(new SlotOutputVM(this.appliance.inventory, 1, 134, 35));
        
        // Player Hotbar, Slot 0-8, Slot IDs 36-44:
        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
        
        // Player Inventory, Slot 9-35, Slot IDs 9-35:
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }
    
    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        
        this.saveCraftingMatrix();
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
    	this.saveCraftingMatrix();
    	
        return this.world.getBlockState(this.appliance.getPos()).getBlock() != BlocksVM.KIT_FABRICATOR ? false : playerIn.getDistanceSq((double)this.appliance.getPos().getX() + 0.5D, (double)this.appliance.getPos().getY() + 0.5D, (double)this.appliance.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        this.saveCraftingMatrix();
        
        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);
            
            if (this.cutTime != this.appliance.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.appliance.getField(0));
            }
            
            if (this.totalCutTime != this.appliance.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.appliance.getField(1));
            }
            
            if (this.procChance != this.appliance.getField(2))
            {
                icontainerlistener.sendWindowProperty(this, 2, this.appliance.getField(2));
            }
        }

        this.cutTime = this.appliance.getField(0);
        this.totalCutTime = this.appliance.getField(1);
        this.procChance = this.appliance.getField(2);
        this.isOn = this.appliance.isOn;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.appliance.setField(id, data);
    }
    
    /** Saves the items to the appliance inventory. */
    private void saveCraftingMatrix()
    {
	  	for (int i = 0; i < this.appliance.inventory.getSlots(); i++) 
    	{
    		this.appliance.inventory.setStackInSlot(i, this.appliance.inventory.getStackInSlot(i));
    	}
    }
}
