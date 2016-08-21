package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipCore;
import com.viesis.viescraft.client.gui.v1.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	public static final int GUI_AIRSHIP_INVENTORY = 0;
	public static final int GUI_AIRSHIP_WORKBENCH = 1;
	EntityAirshipCore entity;
	
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
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new ContainerAirshipWorkbench(player.inventory, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
			//return new ContainerAirshipWorkbench(player.inventory, 
			//		world,
			//		new BlockPos(x, y, z)
					//);
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
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new GuiTileEntityAirshipWorkbench(player.inventory, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}
}
