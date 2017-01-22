package com.viesis.viescraft.common.items.parts;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerColorizer extends Container {

	private ItemColorizerBalloon airship;
	private int airshipBurnTime;
	
	private EntityPlayer player;
	
	/*
	 * SLOTS:
	 *
	 * Airship Fuel ........... 0
	 * Airship Module ......... 1
	 * Airship Inv ............ 2 - 20
	 */
	public ContainerColorizer(IInventory playerInv, EntityPlayer player, ItemColorizerBalloon entityAirshipV1Core) 
	{
		this.airship = entityAirshipV1Core;
        this.player = player;
        
		// Fuel Slot, Slot 0, Slot ID 0
		//this.addSlotToContainer(new FuelSlotVC(this.airship.inventory, 0, 152, 17));
		
		// Player Hotbar, Slot 0-8, Slot IDs 36-44
		//for (int x = 0; x < 9; ++x) 
		//{
		//	this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
		//}
		
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
        //this.airship.setField(id, data);
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
}
