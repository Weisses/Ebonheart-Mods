package com.viesis.viescraft.network;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.GuiTileEntityBatteryCharger;
import com.viesis.viescraft.client.gui.airship.GuiAirshipDefaultInterface;
import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg1;
import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg2;
import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg3;
import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg4;
import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg5;
import com.viesis.viescraft.client.gui.airship.modules.GuiModuleInventoryLarge;
import com.viesis.viescraft.client.gui.airship.modules.GuiModuleInventorySmall;
import com.viesis.viescraft.client.gui.airship.modules.GuiModuleJukebox;
import com.viesis.viescraft.client.gui.airship.modules.GuiModuleSocket;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg1;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg2;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg3;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg4;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipDefault;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipModule;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipModuleInvLarge;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipModuleInvSmall;
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
	
	public static final int GUI_DEFAULT = 1;
	public static final int GUI_MODULE = 5;
	public static final int GUI_MODULE_INVENTORY_SMALL = 9;
	public static final int GUI_MODULE_INVENTORY_LARGE = 13;
	public static final int GUI_MODULE_JUKEBOX = 14;
	
	public static final int GUI_APPEARANCE_PAGE1 = 17;
	public static final int GUI_APPEARANCE_PAGE2 = 18;
	public static final int GUI_APPEARANCE_PAGE3 = 19;
	public static final int GUI_APPEARANCE_PAGE4 = 20;
	public static final int GUI_APPEARANCE_PAGE5 = 21;
	
	public static final int GUI_MUSIC_PAGE1 = 27;
	public static final int GUI_MUSIC_PAGE2 = 28;
	public static final int GUI_MUSIC_PAGE3 = 29;
	public static final int GUI_MUSIC_PAGE4 = 30;
	
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
		if (ID == GUI_DEFAULT)
		{
			return new ContainerAirshipDefault(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Module Container
		if (ID == GUI_MODULE)
		{
			return new ContainerAirshipModule(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Small Inventory Container
		if (ID == GUI_MODULE_INVENTORY_SMALL)
		{
			return new ContainerAirshipModuleInvSmall(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Large Inventory Container
		if (ID == GUI_MODULE_INVENTORY_LARGE)
		{
			return new ContainerAirshipModuleInvLarge(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Jukebox Container
		if (ID == GUI_MODULE_JUKEBOX)
		{
			return new ContainerAirshipDefault(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
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
		if (ID == GUI_APPEARANCE_PAGE5)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Music Containers
		if (ID == GUI_MUSIC_PAGE1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE2)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE3)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE4)
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
		if (ID == GUI_DEFAULT)
		{
			return new GuiAirshipDefaultInterface(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_MODULE)
		{
			return new GuiModuleSocket(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Small Inventory Module
		if (ID == GUI_MODULE_INVENTORY_SMALL)
		{
			return new GuiModuleInventorySmall(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Large Inventory Module
		if (ID == GUI_MODULE_INVENTORY_LARGE)
		{
			return new GuiModuleInventoryLarge(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Jukebox Module
		if (ID == GUI_MODULE_INVENTORY_SMALL)
		{
			return new GuiModuleInventorySmall(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Large Inventory Module
		if (ID == GUI_MODULE_INVENTORY_LARGE)
		{
			return new GuiModuleInventoryLarge(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Large Inventory Module
		if (ID == GUI_MODULE_JUKEBOX)
		{
			return new GuiModuleJukebox(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Appearance GUI
		if (ID == GUI_APPEARANCE_PAGE1)
		{
			return new GuiAirshipAppearancePg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE2)
		{
			return new GuiAirshipAppearancePg2(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE3)
		{
			return new GuiAirshipAppearancePg3(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE4)
		{
			return new GuiAirshipAppearancePg4(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_PAGE5)
		{
			return new GuiAirshipAppearancePg5(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Music GUI
		if (ID == GUI_MUSIC_PAGE1)
		{
			return new GuiAirshipMusicPg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE2)
		{
			return new GuiAirshipMusicPg2(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE3)
		{
			return new GuiAirshipMusicPg3(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_MUSIC_PAGE4)
		{
			return new GuiAirshipMusicPg4(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		return null;
	}
}
