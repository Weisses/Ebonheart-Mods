package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.ModuleSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMainModule extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
	
	public ContainerMainModule(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
		
		//Slot 11 - Module Slot1
		for (int y = 0; y < 1; ++y) 
		{
			for (int x = 0; x < 1; ++x) 
			{
				this.addSlotToContainer(new ModuleSlotVC(this.airship.inventory, 11, 109, 93));
			}
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 120 + y * 18));
			}
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 178));
		}
	}
}
