package com.viesis.viescraft.common.entity.airshipcolors.containers.v2;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipV2AppearancePage3 extends ContainerVC {
	
	private EntityAirshipV2Core airship;
	private int airshipBurnTime;
    
	public ContainerAirshipV2AppearancePage3(IInventory playerInv, EntityAirshipV2Core entityAirshipV2Core) 
	{
		this.airship = entityAirshipV2Core;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
