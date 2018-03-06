package com.viesis.viescraft.common.entity.airshipcolors.containers.all;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.InventorySlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipMenuStorageGreater extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
	private int airshipBurnTime;
    
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
	public ContainerAirshipMenuStorageGreater(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
		
		//Slot 0 - Fuel
		if(this.airship.getModuleVariantSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() != EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		}
		else
		{
			this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 147, 22));
		}
		
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
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 3; ++x) 
			{
				
			}
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
