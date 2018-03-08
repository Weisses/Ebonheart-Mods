package com.viesis.viescraft.common.entity.airshipcolors.containers.all;

import net.minecraft.inventory.IInventory;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

public class ContainerAirshipAppearance extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
    
	public ContainerAirshipAppearance(IInventory playerInv, EntityAirshipBaseVC entityAirship) 
	{
		this.airship = entityAirship;
	}
}
