package com.viesis.viescraft.common.entity.airshipcolors.containers.v4;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerVC;

import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerAirshipV4AppearancePage1 extends ContainerVC {
	
	private EntityAirshipV4Core airship;
	private int airshipBurnTime;
    
	public ContainerAirshipV4AppearancePage1(IInventory playerInv, EntityAirshipV4Core entityAirshipV4Core) 
	{
		this.airship = entityAirshipV4Core;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.airship.setField(id, data);
    }
}
