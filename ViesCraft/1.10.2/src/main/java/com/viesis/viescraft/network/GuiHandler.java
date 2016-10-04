package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Default;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Module;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1ModuleInventoryLarge;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1ModuleInventorySmall;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2Core;
import com.viesis.viescraft.client.gui.v3.GuiEntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipV1Default;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipV1Module;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipV1ModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipV1ModuleInvSmall;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_AIRSHIP_WORKBENCH = 0;
	
	public static final int GUI_V1_DEFAULT = 1;
	
	
	
	public static final int GUI_AIRSHIP_V2_INVENTORY = 2;
	public static final int GUI_AIRSHIP_V3_INVENTORY = 3;
	
	
	
	public static final int GUI_V1_MODULE = 4;
	public static final int GUI_AIRSHIP_V2_INVENTORY_MODULE = 5;
	public static final int GUI_AIRSHIP_V3_INVENTORY_MODULE = 6;
	
	
	
	public static final int GUI_V1_MODULE_INVENTORY_SMALL = 7;
	public static final int GUI_AIRSHIP_V2_INVENTORY_MODULE_INVENTORY_SMALL = 8;
	public static final int GUI_AIRSHIP_V3_INVENTORY_MODULE_INVENTORY_SMALL = 9;
	
	
	
	public static final int GUI_V1_MODULE_INVENTORY_LARGE = 10;
	public static final int GUI_AIRSHIP_V2_INVENTORY_MODULE_INVENTORY_LARGE = 11;
	public static final int GUI_AIRSHIP_V3_INVENTORY_MODULE_INVENTORY_LARGE = 12;
	
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//Airship Workbench Container
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new ContainerAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship Container with no module
		if (ID == GUI_V1_DEFAULT)
		{
			return new ContainerAirshipV1Default(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY)
		{
			return new ContainerAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY)
		{
			return new ContainerAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship Module Container
		if (ID == GUI_V1_MODULE)
		{
			return new ContainerAirshipV1Module(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY_MODULE)
		{
			return new ContainerAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY_MODULE)
		{
			return new ContainerAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship Small Inventory Container
		if (ID == GUI_V1_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV1ModuleInvSmall(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship Large Inventory Container
		if (ID == GUI_V1_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipV1ModuleInvLarge(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//Airship Workbench GUI
		if (ID == GUI_AIRSHIP_WORKBENCH)
		{
			return new GuiTileEntityAirshipWorkbench(player.inventory, world, (TileEntityAirshipWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship GUI with no module
		if (ID == GUI_V1_DEFAULT)
		{
			return new GuiEntityAirshipV1Default(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY)
		{
			return new GuiEntityAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY)
		{
			return new GuiEntityAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_V1_MODULE)
		{
			return new GuiEntityAirshipV1Module(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY_MODULE)
		{
			return new GuiEntityAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY_MODULE)
		{
			return new GuiEntityAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship GUI with Small Inventory Module
		if (ID == GUI_V1_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV1ModuleInventorySmall(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V2_INVENTORY_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV2Core(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_AIRSHIP_V3_INVENTORY_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV3Core(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		
		//Airship GUI with Large Inventory Module
		if (ID == GUI_V1_MODULE_INVENTORY_LARGE)
		{
			return new GuiEntityAirshipV1ModuleInventoryLarge(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		
		return null;
	}
}
