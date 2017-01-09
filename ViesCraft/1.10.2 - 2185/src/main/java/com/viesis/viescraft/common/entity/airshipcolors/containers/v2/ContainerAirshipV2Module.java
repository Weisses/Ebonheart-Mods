package com.viesis.viescraft.common.entity.airshipcolors.containers.v2;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.ModuleSlotVC;

public class ContainerAirshipV2Module extends ContainerVC {
	
	private EntityAirshipV2Core airship;
	
	/*
	 * SLOTS:
	 *
	 * Airship Fuel ........... 0
	 * Airship Module ......... 1
	 * Airship Inv ............ 2 - 20
	 */
	public ContainerAirshipV2Module(IInventory playerInv, EntityAirshipV2Core airship) 
	{
		this.airship = airship;
		
		// Expansion Module, Slot 1, Slot ID 1
		for (int y = 0; y < 1; ++y) 
		{
			for (int x = 0; x < 1; ++x) 
			{
				this.addSlotToContainer(new ModuleSlotVC(this.airship.inventory, 1, 80, 30));
			}
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
	}
}
