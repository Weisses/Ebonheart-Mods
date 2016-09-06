package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Core;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	public static final int GUI_AIRSHIP_V1_INVENTORY = 0;
	public static final int GUI_AIRSHIP_WORKBENCH = 1;
	public static final int GUI_AIRSHIP_V2_INVENTORY = 2;
	
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_V1_INVENTORY)
		{
			return new ContainerAirshipV1Core(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY)
		{
			return new ContainerAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new ContainerAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == GUI_AIRSHIP_V1_INVENTORY)
		{
			return new GuiEntityAirshipV1Core(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY)
		{
			return new GuiEntityAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new GuiTileEntityAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
}
