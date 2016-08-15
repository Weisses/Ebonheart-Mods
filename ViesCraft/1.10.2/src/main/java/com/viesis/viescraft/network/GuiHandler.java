package com.viesis.viescraft.network;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	public static final int GUI_AIRSHIP_INVENTORY = 0;
	
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_INVENTORY)
		{
			return new ContainerAirshipCore(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_INVENTORY)
		{
			return new GuiEntityAirshipCore(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		return null;
	}
}
