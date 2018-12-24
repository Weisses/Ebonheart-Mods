package com.vies.viesmachines.common.entity.machines.containers;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.slots.AmmoSlot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMachineMenuMainSelectProjectile extends ContainerVM {
	
	private EntityMachineBase machine;
    
	public ContainerMachineMenuMainSelectProjectile(IInventory playerInv, EntityMachineBase machineIn) 
	{
		this.machine = machineIn;
        
		// Slot 1 - Ammo:
		this.addSlotToContainer(new AmmoSlot(this.machine.inventory, 1, 37, 89));
		
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
