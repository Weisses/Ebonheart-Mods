package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airships.slots.InventorySlotVC;
import com.viesis.viescraft.common.entity.airships.slots.ModuleBombSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerMenuMain extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerMenuMain(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
        
		//Slot 0 - Fuel
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 500, 500));
		}
		else
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		}
		
		//Storage Lesser
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
		{
			//Slot 20-29 - Inventory Small
			for (int y = 0; y < 3; ++y) 
			{
				for (int x = 0; x < 3; ++x) 
				{
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 62 + x * 18, 62 + y * 18));
				}
			}
		}
		
		//Storage Normal
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
		{
			//Slot 20-37 = Inventory Large
			for (int y = 0; y < 3; ++y) 
			{
				for (int x = 0; x < 3; ++x) 
				{
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 35 + x * 18, 62 + y * 18));
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 9, 89 + x * 18, 62 + y * 18));
				}
			}
		}
		
		//Storage Greater
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
		{
			//Slot 20-37 = Inventory Large
			for (int y = 0; y < 3; ++y) 
			{
				for (int x = 0; x < 3; ++x) 
				{
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, (x + y * 3) + 20, 8 + x * 18, 62 + y * 18));
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 9, 62 + x * 18, 62 + y * 18));
					this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, ((x + y * 3) + 20) + 18, 116 + x * 18, 62 + y * 18));
				}
			}
		}
		
		
		//Bombing
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			//Bomb Slots
			this.addSlotToContainer(new ModuleBombSlotVC(this.airship.inventory, 51, 53, 89));
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
}
