package com.viesis.viescraft.common.entity.airships.containers.all;

import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerAirshipAppearance extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerAirshipAppearance(IInventory playerInv, EntityAirshipBaseVC entityAirship) 
	{
		this.airship = entityAirship;
	}
}
