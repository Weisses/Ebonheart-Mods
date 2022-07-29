package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;
import com.viesis.viescraft.common.entity.airships.slots.DisplayBlockItemSlotVC;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerCustomizeEngineBlock extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerCustomizeEngineBlock(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
        
		//Slot 18 - Block/Item to Display
		this.addSlotToContainer(new DisplayBlockItemSlotVC(this.airship.inventory, 18, 42, 56));
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		for (int x = 0; x < 9; ++x) 
		{
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 146));
		}
		
		// Player Inventory, Slot 9-35, Slot IDs 9-35
		//for (int y = 0; y < 3; ++y) 
		//{
		//	for (int x = 0; x < 9; ++x) 
		//	{
		//		this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
		//	}
		//}
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
