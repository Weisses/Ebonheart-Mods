package com.viesis.gemstones.common.tileentity.containers;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.slots.CutterSlotInputVG;
import com.viesis.gemstones.common.tileentity.slots.CutterSlotOutputVG;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerGemstoneWorkbench extends ContainerVC {
	
	private final World world;
    private final TileEntityGemstoneWorkbench gemstoneWorkbench;
    
    private int cutTime;
    private int totalCutTime;
    
    public ContainerGemstoneWorkbench(InventoryPlayer playerInventory, World worldIn, TileEntityGemstoneWorkbench gemstoneWorkbenchIn)
    {
        this.world = worldIn;
        this.gemstoneWorkbench = gemstoneWorkbenchIn;
        
        //Stone Input slot
        this.addSlotToContainer(new CutterSlotInputVG(this.gemstoneWorkbench.inventory, 0, 56, 53));
        
        //Gemstone output slot
        this.addSlotToContainer(new CutterSlotOutputVG(this.gemstoneWorkbench.inventory, 1, 116, 35));
        
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
    }
    
    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.world.getBlockState(this.gemstoneWorkbench.getPos()).getBlock() != InitBlocksVG.gemstone_workbench ? false : playerIn.getDistanceSq((double)this.gemstoneWorkbench.getPos().getX() + 0.5D, (double)this.gemstoneWorkbench.getPos().getY() + 0.5D, (double)this.gemstoneWorkbench.getPos().getZ() + 0.5D) <= 64.0D;
    }
    
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

            if (this.cutTime != this.gemstoneWorkbench.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.gemstoneWorkbench.getField(0));
            }

            if (this.totalCutTime != this.gemstoneWorkbench.getField(1))
            {
                icontainerlistener.sendProgressBarUpdate(this, 1, this.gemstoneWorkbench.getField(1));
            }
/**
            if (this.furnaceBurnTime != this.tileFurnace.getField(0))
            {
                icontainerlistener.sendProgressBarUpdate(this, 0, this.tileFurnace.getField(0));
            }

            if (this.currentItemBurnTime != this.tileFurnace.getField(1))
            {
                icontainerlistener.sendProgressBarUpdate(this, 1, this.tileFurnace.getField(1));
            }

            if (this.totalCookTime != this.tileFurnace.getField(3))
            {
                icontainerlistener.sendProgressBarUpdate(this, 3, this.tileFurnace.getField(3));
            }
            */
        }

        this.cutTime = this.gemstoneWorkbench.getField(2);
        //this.furnaceBurnTime = this.tileFurnace.getField(0);
        //this.currentItemBurnTime = this.tileFurnace.getField(1);
        //this.totalCookTime = this.tileFurnace.getField(3);
    }
    
    
    

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.gemstoneWorkbench.setField(id, data);
    }
    
}
