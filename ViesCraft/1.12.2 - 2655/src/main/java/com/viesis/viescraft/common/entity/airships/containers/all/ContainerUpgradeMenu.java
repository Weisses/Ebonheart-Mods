package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.UpgradeBalloonSlotVC;
import com.viesis.viescraft.common.entity.airships.slots.UpgradeCoreSlotVC;
import com.viesis.viescraft.common.entity.airships.slots.UpgradeEngineSlotVC;
import com.viesis.viescraft.common.entity.airships.slots.UpgradeFrameSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerUpgradeMenu extends ContainerVC {
	
	private EntityAirshipCore airship;
    
	public ContainerUpgradeMenu(IInventory playerInv, EntityAirshipCore airshipIn) 
	{
		this.airship = airshipIn;
        
		if(this.airship.getMainTierCore() < 5)
		{
			//Slot 1 - Upgrade Core
			this.addSlotToContainer(new UpgradeCoreSlotVC(this.airship.inventory, 1, 23, 57));
		}
		if(this.airship.getMainTierFrame() < 5)
		{
			//Slot 2 - Upgrade Frame
			this.addSlotToContainer(new UpgradeFrameSlotVC(this.airship.inventory, 2, 61, 57));
		}
		if(this.airship.getMainTierEngine() < 5)
		{
			//Slot 3 - Upgrade Engine
			this.addSlotToContainer(new UpgradeEngineSlotVC(this.airship.inventory, 3, 99, 57));
		}
		if(this.airship.getMainTierBalloon() < 5)
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
