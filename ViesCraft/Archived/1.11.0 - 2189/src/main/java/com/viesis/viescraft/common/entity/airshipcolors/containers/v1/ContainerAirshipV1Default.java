package com.viesis.viescraft.common.entity.airshipcolors.containers.v1;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipV1Default extends ContainerVC {

	private EntityAirshipV1Core airship;
	private int airshipBurnTime;
    
	/*
	 * SLOTS:
	 *
	 * Airship Fuel ........... 0
	 * Airship Module ......... 1
	 * Airship Inv ............ 2 - 20
	 */
	public ContainerAirshipV1Default(IInventory playerInv, EntityAirshipV1Core entityAirshipV1Core) 
	{
		this.airship = entityAirshipV1Core;
        
		// Fuel Slot, Slot 0, Slot ID 0
		this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 152, 17));
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		for (int y = 0; y < 3; ++y) 
		{
			for (int x = 0; x < 9; ++x) 
			{
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
