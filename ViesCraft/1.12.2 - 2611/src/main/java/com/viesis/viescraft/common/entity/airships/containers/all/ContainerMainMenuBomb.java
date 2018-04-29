package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airships.slots.InventorySlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerMainMenuBomb extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerMainMenuBomb(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
		
		//Slot 0 - Fuel
		if(this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		}
		else
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		}
		
		//Bomb Slots
		if(this.airship.selectedModuleBomb == 1)
		{
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 51, 62 + (18 * 1), 89));
			
		}
		if(this.airship.selectedModuleBomb == 2)
		{
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 51, 71 + (18 * 0), 89));
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 52, 71 + (18 * 1), 89));
		}
		if(this.airship.selectedModuleBomb == 3)
		{
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 51, 62 + (18 * 0), 89));
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 52, 62 + (18 * 1), 89));
			this.addSlotToContainer(new InventorySlotVC(this.airship.inventory, 53, 62 + (18 * 2), 89));
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
