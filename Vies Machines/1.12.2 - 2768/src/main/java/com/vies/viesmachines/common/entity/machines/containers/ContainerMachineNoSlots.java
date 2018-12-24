package com.vies.viesmachines.common.entity.machines.containers;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;

import net.minecraft.inventory.IInventory;

public class ContainerMachineNoSlots extends ContainerVM {
	
	private EntityMachineBase machine;
    
	public ContainerMachineNoSlots(IInventory playerInv, EntityMachineBase machineIn) 
	{
		this.machine = machineIn;
	}
}
