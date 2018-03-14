package com.viesis.viescraft.network;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.GuiTileEntityBatteryCharger;
import com.viesis.viescraft.client.gui.airship.main.GuiAirshipMenu;
import com.viesis.viescraft.client.gui.airship.main.GuiAirshipMenuMusic;
import com.viesis.viescraft.client.gui.airship.main.GuiAirshipMenuStorageGreater;
import com.viesis.viescraft.client.gui.airship.main.GuiAirshipMenuStorageLesser;
import com.viesis.viescraft.client.gui.airship.main.GuiAirshipMenuStorageNormal;
import com.viesis.viescraft.client.gui.airship.main.GuiModuleMenu;
import com.viesis.viescraft.client.gui.airship.main.GuiUpgradeMenu;
import com.viesis.viescraft.client.gui.airship.main.GuiVisualMenu;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg1;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloon;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonColor;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier1Pg1;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier2Pg1;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier3Pg1;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier4Pg1;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier5Pg1;
import com.viesis.viescraft.client.gui.airship.visual.core.GuiVisualMenuCore;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrame;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameColor;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier1Pg1;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier1Pg2;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier2Pg1;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier3Pg1;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier4Pg1;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier5Pg1;
import com.viesis.viescraft.client.gui.pouch.GuiPouchAll;
import com.viesis.viescraft.client.gui.pouch.GuiPouchModule;
import com.viesis.viescraft.client.gui.pouch.InventoryPouch;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipMenu;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipMenuStorageGreater;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipMenuStorageLesser;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipMenuStorageNormal;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerAirshipModule;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerUpgradeMenu;
import com.viesis.viescraft.common.items.parts.pouch.ContainerPouchAll;
import com.viesis.viescraft.common.items.parts.pouch.ContainerPouchModule;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.ContainerBatteryCharger;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityBatteryCharger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_AIRSHIP_WORKBENCH = 50;
	public static final int GUI_BATTERY_CHARGER = 51;

	public static final int GUI_ITEM_POUCH_MODULE = 52;
	public static final int GUI_ITEM_POUCH_ALL = 53;
	
	public static final int GUI_AIRSHIP_MENU = 11;
	public static final int GUI_AIRSHIP_MENU_STORAGE_LESSER = 12;
	public static final int GUI_AIRSHIP_MENU_STORAGE_NORMAL = 13;
	public static final int GUI_AIRSHIP_MENU_STORAGE_GREATER = 14;
	public static final int GUI_AIRSHIP_MENU_MUSIC = 15;
	public static final int GUI_UPGRADE_MENU = 16;
	public static final int GUI_APPEARANCE_MENU = 17;
	public static final int GUI_MODULE_MENU = 18;
	
	public static final int GUI_APPEARANCE_MENU_FRAME = 102;
	public static final int GUI_APPEARANCE_MENU_FRAME_COLOR = 109;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG1 = 103;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG2 = 104;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER2_PG1 = 105;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER3_PG1 = 106;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER4_PG1 = 107;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER5_PG1 = 108;
	
	public static final int GUI_APPEARANCE_MENU_BALLOON = 202;
	public static final int GUI_APPEARANCE_MENU_BALLOON_COLOR = 209;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1 = 203;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1 = 205;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1 = 206;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1 = 207;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1 = 208;
	
	public static final int GUI_APPEARANCE_MENU_CORE = 302;
	
	public static final int GUI_MUSIC_PG1 = 31;
	
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
		
		//Module Pouch
		if (ID == GUI_ITEM_POUCH_MODULE)
		{
			return new ContainerPouchModule(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		}
		if (ID == GUI_ITEM_POUCH_ALL)
		{
			return new ContainerPouchAll(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		}
		
		
		//Airship Container with no module
		if (ID == GUI_AIRSHIP_MENU)
		{
			return new ContainerAirshipMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Module Container
		if (ID == GUI_MODULE_MENU)
		{
			return new ContainerAirshipModule(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Lesser Storage Container
		if (ID == GUI_AIRSHIP_MENU_STORAGE_LESSER)
		{
			return new ContainerAirshipMenuStorageLesser(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Normal Storage Container
		if (ID == GUI_AIRSHIP_MENU_STORAGE_NORMAL)
		{
			return new ContainerAirshipMenuStorageNormal(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Greater Storage Container
		if (ID == GUI_AIRSHIP_MENU_STORAGE_GREATER)
		{
			return new ContainerAirshipMenuStorageGreater(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Music Container
		if (ID == GUI_AIRSHIP_MENU_MUSIC)
		{
			return new ContainerAirshipMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Upgrade Container
		if (ID == GUI_UPGRADE_MENU)
		{
			return new ContainerUpgradeMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Appearance Containers
		if (ID == GUI_APPEARANCE_MENU)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_CORE)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_BALLOON)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new ContainerAirshipAppearance(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Music Containers
		if (ID == GUI_MUSIC_PG1)
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

		//Module Pouch
		if (ID == GUI_ITEM_POUCH_MODULE)
		{
			return new GuiPouchModule(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		}
		if (ID == GUI_ITEM_POUCH_ALL)
		{
			return new GuiPouchAll(player, new InventoryPouch(player.getHeldItem(EnumHand.MAIN_HAND)));
		}
		
		
		//Airship GUI with no module
		if (ID == GUI_AIRSHIP_MENU)
		{
			return new GuiAirshipMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_MODULE_MENU)
		{
			return new GuiModuleMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Lesser Storage Module
		if (ID == GUI_AIRSHIP_MENU_STORAGE_LESSER)
		{
			return new GuiAirshipMenuStorageLesser(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Normal Storage Module
		if (ID == GUI_AIRSHIP_MENU_STORAGE_NORMAL)
		{
			return new GuiAirshipMenuStorageNormal(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Greater Storage Module
		if (ID == GUI_AIRSHIP_MENU_STORAGE_GREATER)
		{
			return new GuiAirshipMenuStorageGreater(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship GUI with Music Module
		if (ID == GUI_AIRSHIP_MENU_MUSIC)
		{
			return new GuiAirshipMenuMusic(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Upgrade GUI
		if (ID == GUI_UPGRADE_MENU)
		{
			return new GuiUpgradeMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Appearance GUI
		if (ID == GUI_APPEARANCE_MENU)
		{
			return new GuiVisualMenu(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_CORE)
		{
			return new GuiVisualMenuCore(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME)
		{
			return new GuiVisualMenuFrame(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new GuiVisualMenuFrameColor(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new GuiVisualMenuFrameTier1Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new GuiVisualMenuFrameTier1Pg2(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new GuiVisualMenuFrameTier2Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new GuiVisualMenuFrameTier3Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new GuiVisualMenuFrameTier4Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new GuiVisualMenuFrameTier5Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}

		if (ID == GUI_APPEARANCE_MENU_BALLOON)
		{
			return new GuiVisualMenuBalloon(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new GuiVisualMenuBalloonColor(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new GuiVisualMenuBalloonTier1Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new GuiVisualMenuBalloonTier2Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new GuiVisualMenuBalloonTier3Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new GuiVisualMenuBalloonTier4Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new GuiVisualMenuBalloonTier5Pg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		//Airship Music GUI
		if (ID == GUI_MUSIC_PG1)
		{
			return new GuiAirshipMusicPg1(player.inventory, (EntityAirshipBaseVC)player.getRidingEntity());
		}
		
		return null;
	}
}
