package com.viesis.viescraft.common.entity.airshipcolors.containers.all;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.UpgradeBalloonSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.UpgradeCoreSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.UpgradeEngineSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.UpgradeFrameSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerUpgradeMenu extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel <br>
	 * Slot  1 = Upgrade Frame <br>
	 * Slot  2 = Upgrade Core <br>
	 * Slot  3 = Upgrade Engine <br>
	 * Slot  4 = Upgrade Balloon <br>
	 * Slot 11 = Module Slot1 <br>
	 * Slot 12 = Module Slot2 <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 */
	public ContainerUpgradeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
        
		if(this.airship.getMetaTierFrame() < 5)
		{
			//Slot 1 - Upgrade Frame
			this.addSlotToContainer(new UpgradeFrameSlotVC(this.airship.inventory, 1, 23, 57));
		}
		if(this.airship.getMetaTierCore() < 5)
		{
			//Slot 2 - Upgrade Core
			this.addSlotToContainer(new UpgradeCoreSlotVC(this.airship.inventory, 2, 61, 57));
		}
		if(this.airship.getMetaTierEngine() < 5)
		{
			//Slot 3 - Upgrade Engine
			this.addSlotToContainer(new UpgradeEngineSlotVC(this.airship.inventory, 3, 99, 57));
		}
		if(this.airship.getMetaTierBalloon() < 5)
		{
			//Slot 4 - Upgrade Balloon
			this.addSlotToContainer(new UpgradeBalloonSlotVC(this.airship.inventory, 4, 137, 57));
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 178));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 120 + y * 18));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
