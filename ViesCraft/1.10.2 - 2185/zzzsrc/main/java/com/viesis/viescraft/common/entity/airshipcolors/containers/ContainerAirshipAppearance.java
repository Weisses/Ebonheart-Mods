package com.viesis.viescraft.common.entity.airshipcolors.containers;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipAppearance extends ContainerVC {
	
	private EntityAirshipBaseVC airship;
	private int airshipBurnTime;
    
	public ContainerAirshipAppearance(IInventory playerInv, EntityAirshipBaseVC entityAirship) 
	{
		this.airship = entityAirship;
	}
}
