package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.RedstoneSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMenuRedstone extends ContainerVC {
	
	private EntityAirshipCore airship;
    
	public ContainerMenuRedstone(IInventory playerInv, EntityAirshipCore airshipIn) 
	{
		this.airship = airshipIn;
        
		//Slot 16 - Redstone Slow
		this.addSlotToContainer(new RedstoneSlotVC(this.airship.inventory, 16, 80, 63));
		
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
}
