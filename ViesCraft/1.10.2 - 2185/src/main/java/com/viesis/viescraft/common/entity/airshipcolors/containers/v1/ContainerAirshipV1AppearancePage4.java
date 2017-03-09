package com.viesis.viescraft.common.entity.airshipcolors.containers.v1;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;

public class ContainerAirshipV1AppearancePage4 extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
	private int airshipBurnTime;
    
	public ContainerAirshipV1AppearancePage4(IInventory playerInv, EntityAirshipBaseVC entityAirship) 
	{
		this.airship = entityAirship;
	}
}
