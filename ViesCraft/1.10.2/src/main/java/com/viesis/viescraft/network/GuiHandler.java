package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.v1containers.ContainerAirshipBlack;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	public static final int GUI_AIRSHIP_BLACK = 0;
	
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_BLACK)
		{
			return new ContainerAirshipBlack(player.inventory, (EntityAirshipBlack)player.getRidingEntity());
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_BLACK)
		{
			return new GuiEntityAirshipBlack(player.inventory, (EntityAirshipBlack)player.getRidingEntity());
		}
		return null;
	}
}
