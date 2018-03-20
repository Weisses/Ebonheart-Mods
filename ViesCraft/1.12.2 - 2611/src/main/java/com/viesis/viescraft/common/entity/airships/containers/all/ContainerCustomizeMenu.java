package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerCustomizeMenu extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerCustomizeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn) 
	{
		this.airship = airshipIn;
	}
}
