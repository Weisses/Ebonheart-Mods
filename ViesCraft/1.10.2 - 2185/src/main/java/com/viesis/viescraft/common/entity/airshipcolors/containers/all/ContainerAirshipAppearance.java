package com.viesis.viescraft.common.entity.airshipcolors.containers.all;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerAirshipAppearance extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
	private int airshipBurnTime;
    
	public ContainerAirshipAppearance(IInventory playerInv, EntityAirshipBaseVC entityAirship) 
	{
		this.airship = entityAirship;
	}
}
