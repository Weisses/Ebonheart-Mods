package com.vies.viesmachines.common.entity.machines.containers;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.slots.FuelSlot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMachineMenuMain extends ContainerVM {
	
	private EntityMachineBase machine;
    
	public ContainerMachineMenuMain(IInventory playerInv, EntityMachineBase machineIn) 
	{
		this.machine = machineIn;
        
		// Slot 0 - Fuel:
		this.addSlotToContainer(new FuelSlot(this.machine.inventory, 0, 141, 38));
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44:
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 198));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35:
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 140 + y * 18));
			}
		}
	}
}
