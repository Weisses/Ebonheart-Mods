package com.viesis.viescraft.network;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.GuiTileEntityBatteryCharger;
import com.viesis.viescraft.client.gui.all.GuiEntityAirshipAppearancePage1;
import com.viesis.viescraft.client.gui.all.GuiEntityAirshipAppearancePage2;
import com.viesis.viescraft.client.gui.all.GuiEntityAirshipAppearancePage3;
import com.viesis.viescraft.client.gui.all.GuiEntityAirshipAppearancePage4;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Default;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Module;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1ModuleInventoryLarge;
import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1ModuleInventorySmall;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2Default;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2Module;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2ModuleInventoryLarge;
import com.viesis.viescraft.client.gui.v2.GuiEntityAirshipV2ModuleInventorySmall;
import com.viesis.viescraft.client.gui.v3.GuiEntityAirshipV3Default;
import com.viesis.viescraft.client.gui.v3.GuiEntityAirshipV3Module;
import com.viesis.viescraft.client.gui.v3.GuiEntityAirshipV3ModuleInventoryLarge;
import com.viesis.viescraft.client.gui.v3.GuiEntityAirshipV3ModuleInventorySmall;
import com.viesis.viescraft.client.gui.v4.GuiEntityAirshipV4Default;
import com.viesis.viescraft.client.gui.v4.GuiEntityAirshipV4Module;
import com.viesis.viescraft.client.gui.v4.GuiEntityAirshipV4ModuleInventoryLarge;
import com.viesis.viescraft.client.gui.v4.GuiEntityAirshipV4ModuleInventorySmall;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipAppearance;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1Default;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1Module;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1ModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1ModuleInvSmall;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2Default;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2Module;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2ModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2ModuleInvSmall;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3Default;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3Module;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3ModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3ModuleInvSmall;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v4.ContainerAirshipV4Default;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v4.ContainerAirshipV4Module;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v4.ContainerAirshipV4ModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v4.ContainerAirshipV4ModuleInvSmall;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.ContainerBatteryCharger;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityBatteryCharger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_AIRSHIP_WORKBENCH = 50;
	public static final int GUI_BATTERY_CHARGER = 51;
	
	public static final int GUI_V1_DEFAULT = 1;
	public static final int GUI_V2_DEFAULT = 2;
	public static final int GUI_V3_DEFAULT = 3;
	public static final int GUI_V4_DEFAULT = 4;
	
	public static final int GUI_V1_MODULE = 5;
	public static final int GUI_V2_MODULE = 6;
	public static final int GUI_V3_MODULE = 7;
	public static final int GUI_V4_MODULE = 8;
	
	public static final int GUI_V1_MODULE_INVENTORY_SMALL = 9;
	public static final int GUI_V2_MODULE_INVENTORY_SMALL = 10;
	public static final int GUI_V3_MODULE_INVENTORY_SMALL = 11;
	public static final int GUI_V4_MODULE_INVENTORY_SMALL = 12;
	
	public static final int GUI_V1_MODULE_INVENTORY_LARGE = 13;
	public static final int GUI_V2_MODULE_INVENTORY_LARGE = 14;
	public static final int GUI_V3_MODULE_INVENTORY_LARGE = 15;
	public static final int GUI_V4_MODULE_INVENTORY_LARGE = 16;
	
	public static final int GUI_APPEARANCE_PAGE1 = 17;
	public static final int GUI_APPEARANCE_PAGE2 = 18;
	public static final int GUI_APPEARANCE_PAGE3 = 19;
	public static final int GUI_APPEARANCE_PAGE4 = 20;
	
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
		
		//Airship Workbench Container
		if (ID == GUI_BATTERY_CHARGER)
		{
			return new ContainerBatteryCharger(player.inventory, world, (TileEntityBatteryCharger)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship Container with no module
		if (ID == GUI_V1_DEFAULT)
		{
			return new ContainerAirshipV1Default(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_DEFAULT)
		{
			return new ContainerAirshipV2Default(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_DEFAULT)
		{
			return new ContainerAirshipV3Default(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_DEFAULT)
		{
			return new ContainerAirshipV4Default(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Module Container
		if (ID == GUI_V1_MODULE)
		{
			return new ContainerAirshipV1Module(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE)
		{
			return new ContainerAirshipV2Module(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE)
		{
			return new ContainerAirshipV3Module(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE)
		{
			return new ContainerAirshipV4Module(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Small Inventory Container
		if (ID == GUI_V1_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV1ModuleInvSmall(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV2ModuleInvSmall(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV3ModuleInvSmall(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipV4ModuleInvSmall(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Large Inventory Container
		if (ID == GUI_V1_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipV1ModuleInvLarge(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipV2ModuleInvLarge(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipV3ModuleInvLarge(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipV4ModuleInvLarge(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Appearance Containers
		if (ID == GUI_APPEARANCE_PAGE1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE2)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE3)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE4)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
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
		
		//Airship Workbench GUI
		if (ID == GUI_BATTERY_CHARGER)
		{
			return new GuiTileEntityBatteryCharger(player.inventory, world, (TileEntityBatteryCharger)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Airship GUI with no module
		if (ID == GUI_V1_DEFAULT)
		{
			return new GuiEntityAirshipV1Default(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_DEFAULT)
		{
			return new GuiEntityAirshipV2Default(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_DEFAULT)
		{
			return new GuiEntityAirshipV3Default(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_DEFAULT)
		{
			return new GuiEntityAirshipV4Default(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_V1_MODULE)
		{
			return new GuiEntityAirshipV1Module(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE)
		{
			return new GuiEntityAirshipV2Module(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE)
		{
			return new GuiEntityAirshipV3Module(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE)
		{
			return new GuiEntityAirshipV4Module(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship GUI with Small Inventory Module
		if (ID == GUI_V1_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV1ModuleInventorySmall(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV2ModuleInventorySmall(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV3ModuleInventorySmall(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE_INVENTORY_SMALL)
		{
			return new GuiEntityAirshipV4ModuleInventorySmall(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship GUI with Large Inventory Module
		if (ID == GUI_V1_MODULE_INVENTORY_LARGE)
		{
			return new GuiEntityAirshipV1ModuleInventoryLarge(player.inventory, (EntityAirshipV1Core)player.getRidingEntity());
		}
		if (ID == GUI_V2_MODULE_INVENTORY_LARGE)
		{
			return new GuiEntityAirshipV2ModuleInventoryLarge(player.inventory, (EntityAirshipV2Core)player.getRidingEntity());
		}
		if (ID == GUI_V3_MODULE_INVENTORY_LARGE)
		{
			return new GuiEntityAirshipV3ModuleInventoryLarge(player.inventory, (EntityAirshipV3Core)player.getRidingEntity());
		}
		if (ID == GUI_V4_MODULE_INVENTORY_LARGE)
		{
			return new GuiEntityAirshipV4ModuleInventoryLarge(player.inventory, (EntityAirshipV4Core)player.getRidingEntity());
		}
		
		//Airship Appearance GUI
		if (ID == GUI_APPEARANCE_PAGE1)
		{
			return new GuiEntityAirshipAppearancePage1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE2)
		{
			return new GuiEntityAirshipAppearancePage2(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE3)
		{
			return new GuiEntityAirshipAppearancePage3(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE4)
		{
			return new GuiEntityAirshipAppearancePage4(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		return null;
	}
}
