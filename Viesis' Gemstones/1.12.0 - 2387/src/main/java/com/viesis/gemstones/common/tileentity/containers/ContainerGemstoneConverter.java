package com.viesis.gemstones.common.tileentity.containers;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.common.tileentity.slots.SlotInputConverterVG;
import com.viesis.gemstones.common.tileentity.slots.SlotInputCutterVG;
import com.viesis.gemstones.common.tileentity.slots.SlotOutputVG;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerGemstoneConverter extends ContainerVC {
	
	private final World world;
    private final TileEntityGemstoneConverter gemstoneConverter;
    
    private int cutTime;
    private int totalCutTime;
    private int procChance;
    private boolean isOn;
    
    public ContainerGemstoneConverter(InventoryPlayer playerInventory, World worldIn, TileEntityGemstoneConverter gemstoneConverterIn)
    {
        this.world = worldIn;
        this.gemstoneConverter = gemstoneConverterIn;
        
        //Stone Input slot
        this.addSlotToContainer(new SlotInputConverterVG(this.gemstoneConverter.inventory, 0, 56, 53));
        
        //Gemstone output slot
        this.addSlotToContainer(new SlotOutputVG(this.gemstoneConverter.inventory, 1, 116, 35));
        
        //Player Hotbar, Slot 0-8, Slot IDs 36-44
        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
        
        //Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int k = 0; k < 3; ++k)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
    }
    
    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        
        this.saveCraftingMatrix();
    }
    
    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
    	this.saveCraftingMatrix();
    	
        return this.world.getBlockState(this.gemstoneConverter.getPos()).getBlock() != InitBlocksVG.gemstone_converter ? false : playerIn.getDistanceSq((double)this.gemstoneConverter.getPos().getX() + 0.5D, (double)this.gemstoneConverter.getPos().getY() + 0.5D, (double)this.gemstoneConverter.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        
        this.saveCraftingMatrix();
        
        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);
            
            if (this.cutTime != this.gemstoneConverter.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.gemstoneConverter.getField(0));
            }
            
            if (this.totalCutTime != this.gemstoneConverter.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.gemstoneConverter.getField(1));
            }
            
            if (this.procChance != this.gemstoneConverter.getField(2))
            {
                icontainerlistener.sendWindowProperty(this, 2, this.gemstoneConverter.getField(2));
            }
        }

        this.cutTime = this.gemstoneConverter.getField(0);
        this.totalCutTime = this.gemstoneConverter.getField(1);
        this.procChance = this.gemstoneConverter.getField(2);
        this.isOn = this.gemstoneConverter.isOn;
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.gemstoneConverter.setField(id, data);
    }
    
    /**
     * Saves the crafting matrix to the workbench inventory.
     */
    private void saveCraftingMatrix()
    {
	  	for (int i = 0; i < this.gemstoneConverter.inventory.getSlots(); i++) 
    	{
    		this.gemstoneConverter.inventory.setStackInSlot(i, this.gemstoneConverter.inventory.getStackInSlot(i));
    	}
    }
}
