package com.viesis.viescraft.common.entity.airshipcolors.containers.v1;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipV1AppearancePage4 extends ContainerVC {
	
	private EntityAirshipV1Core airship;
	private int airshipBurnTime;
    
	public ContainerAirshipV1AppearancePage4(IInventory playerInv, EntityAirshipV1Core entityAirshipV1Core) 
	{
		this.airship = entityAirshipV1Core;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
