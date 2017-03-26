package com.viesis.viescraft.common.entity.airshipcolors.containers.v3;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipV3AppearancePage4 extends ContainerVC {
	
	private EntityAirshipV3Core airship;
	private int airshipBurnTime;
    
	public ContainerAirshipV3AppearancePage4(IInventory playerInv, EntityAirshipV3Core entityAirshipV3Core) 
	{
		this.airship = entityAirshipV3Core;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
