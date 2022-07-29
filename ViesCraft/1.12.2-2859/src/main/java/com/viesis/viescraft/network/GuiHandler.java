package com.viesis.viescraft.network;

import com.viesis.viescraft.client.gui.GuiTileEntityAirshipWorkbench;
import com.viesis.viescraft.client.gui.GuiTileEntityBatteryCharger;
import com.viesis.viescraft.client.gui.airship.customize.GuiCustomizeMenu;
import com.viesis.viescraft.client.gui.airship.customize.GuiCustomizeMenuChangeName;
import com.viesis.viescraft.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonMain;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier1Pg1;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier1Pg2;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier2Pg1;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier3Pg1;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier4Pg1;
import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier5Pg1;
import com.viesis.viescraft.client.gui.airship.customize.core.GuiCustomizeMenuCoreMain;
import com.viesis.viescraft.client.gui.airship.customize.core.sub.GuiCustomizeMenuCoreModelBalloonPg1;
import com.viesis.viescraft.client.gui.airship.customize.core.sub.GuiCustomizeMenuCoreModelEnginePg1;
import com.viesis.viescraft.client.gui.airship.customize.core.sub.GuiCustomizeMenuCoreModelFramePg1;
import com.viesis.viescraft.client.gui.airship.customize.engine.GuiCustomizeMenuEngineMain;
import com.viesis.viescraft.client.gui.airship.customize.engine.sub.GuiCustomizeMenuEngineDisplayBlockItemPg1;
import com.viesis.viescraft.client.gui.airship.customize.engine.sub.GuiCustomizeMenuEngineDisplayHeadPg1;
import com.viesis.viescraft.client.gui.airship.customize.engine.sub.GuiCustomizeMenuEngineDisplaySupporterHeadPg1;
import com.viesis.viescraft.client.gui.airship.customize.engine.sub.GuiCustomizeMenuEngineDisplaySymbolPg1;
import com.viesis.viescraft.client.gui.airship.customize.engine.sub.GuiCustomizeMenuEngineParticlePg1;
import com.viesis.viescraft.client.gui.airship.customize.frame.GuiCustomizeMenuFrameColor;
import com.viesis.viescraft.client.gui.airship.customize.frame.GuiCustomizeMenuFrameMain;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier1Pg2;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier2Pg1;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier3Pg1;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier4Pg1;
import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier5Pg1;
import com.viesis.viescraft.client.gui.airship.main.GuiMainMenu;
import com.viesis.viescraft.client.gui.airship.module.GuiModuleMenu;
import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg1;
import com.viesis.viescraft.client.gui.airship.redstone.GuiCustomizeMenuRedstone;
import com.viesis.viescraft.client.gui.airship.upgrade.GuiUpgradeMenu;
import com.viesis.viescraft.client.gui.pouch.GuiPouchAll;
import com.viesis.viescraft.client.gui.pouch.GuiPouchModule;
import com.viesis.viescraft.client.gui.pouch.InventoryPouch;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeEngineBlock;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMainModule;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMenuMain;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMenuRedstone;
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
	
	public static final int GUI_MAIN_MENU = 11;
	public static final int GUI_UPGRADE_MENU = 16;
	public static final int GUI_CUSTOMIZE_MENU = 17;
	public static final int GUI_MODULE_MENU = 18;
	
	
	public static final int GUI_CUSTOMIZE_MENU_CHANGE_NAME = 171;
	public static final int GUI_CUSTOMIZE_MENU_REDSTONE = 172;
	
	public static final int GUI_APPEARANCE_MENU_CORE_MAIN = 402;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1 = 403;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1 = 404;
	public static final int GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1 = 405;
	
	public static final int GUI_APPEARANCE_MENU_FRAME_MAIN = 102;
	public static final int GUI_APPEARANCE_MENU_FRAME_COLOR = 109;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG1 = 103;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER1_PG2 = 104;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER2_PG1 = 105;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER3_PG1 = 106;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER4_PG1 = 107;
	public static final int GUI_APPEARANCE_MENU_FRAME_TIER5_PG1 = 108;
	
	public static final int GUI_APPEARANCE_MENU_ENGINE_MAIN = 302;
	public static final int GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1 = 303;
	public static final int GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM = 304;
	public static final int GUI_APPEARANCE_MENU_ENGINE_HEADS = 306;
	public static final int GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS = 307;
	public static final int GUI_APPEARANCE_MENU_ENGINE_PARTICLE = 308;
	
	public static final int GUI_APPEARANCE_MENU_BALLOON_MAIN = 202;
	public static final int GUI_APPEARANCE_MENU_BALLOON_COLOR = 209;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1 = 203;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2 = 204;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1 = 205;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1 = 206;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1 = 207;
	public static final int GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1 = 208;
	
	
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
		if (ID == GUI_MAIN_MENU)
		{
			return new ContainerMenuMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Upgrade Container
		if (ID == GUI_UPGRADE_MENU)
		{
			return new ContainerUpgradeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Appearance Containers
		if (ID == GUI_CUSTOMIZE_MENU)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name Containers
		if(ID == GUI_CUSTOMIZE_MENU_CHANGE_NAME)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name Containers
		if(ID == GUI_CUSTOMIZE_MENU_REDSTONE)
		{
			return new ContainerMenuRedstone(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_CORE_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_ENGINE_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM)
		{
			return new ContainerCustomizeEngineBlock(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_HEADS)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_PARTICLE)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_BALLOON_MAIN)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Module Container
		if (ID == GUI_MODULE_MENU)
		{
			return new ContainerMainModule(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Music Containers
		if (ID == GUI_MUSIC_PG1)
		{
			return new ContainerCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
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
		if (ID == GUI_MAIN_MENU)
		{
			return new GuiMainMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Module GUI
		if (ID == GUI_MODULE_MENU)
		{
			return new GuiModuleMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Upgrade GUI
		if (ID == GUI_UPGRADE_MENU)
		{
			return new GuiUpgradeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		//Airship Appearance GUI
		if (ID == GUI_CUSTOMIZE_MENU)
		{
			return new GuiCustomizeMenu(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name GUI
		if (ID == GUI_CUSTOMIZE_MENU_CHANGE_NAME)
		{
			return new GuiCustomizeMenuChangeName(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		//Airship Appearance Change Name GUI
		if (ID == GUI_CUSTOMIZE_MENU_REDSTONE)
		{
			return new GuiCustomizeMenuRedstone(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_CORE_MAIN)
		{
			return new GuiCustomizeMenuCoreMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_FRAME_PG1)
		{
			return new GuiCustomizeMenuCoreModelFramePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_ENGINE_PG1)
		{
			return new GuiCustomizeMenuCoreModelEnginePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_CORE_MODEL_BALLOON_PG1)
		{
			return new GuiCustomizeMenuCoreModelBalloonPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		if (ID == GUI_APPEARANCE_MENU_FRAME_MAIN)
		{
			return new GuiCustomizeMenuFrameMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_COLOR)
		{
			return new GuiCustomizeMenuFrameColor(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG1)
		{
			return new GuiCustomizeMenuFrameTier1Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER1_PG2)
		{
			return new GuiCustomizeMenuFrameTier1Pg2(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER2_PG1)
		{
			return new GuiCustomizeMenuFrameTier2Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER3_PG1)
		{
			return new GuiCustomizeMenuFrameTier3Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER4_PG1)
		{
			return new GuiCustomizeMenuFrameTier4Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_FRAME_TIER5_PG1)
		{
			return new GuiCustomizeMenuFrameTier5Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		if (ID == GUI_APPEARANCE_MENU_ENGINE_MAIN)
		{
			return new GuiCustomizeMenuEngineMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SYMBOLS_PG1)
		{
			return new GuiCustomizeMenuEngineDisplaySymbolPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_BLOCKITEM)
		{
			return new GuiCustomizeMenuEngineDisplayBlockItemPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_HEADS)
		{
			return new GuiCustomizeMenuEngineDisplayHeadPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS)
		{
			return new GuiCustomizeMenuEngineDisplaySupporterHeadPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_ENGINE_PARTICLE)
		{
			return new GuiCustomizeMenuEngineParticlePg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		if (ID == GUI_APPEARANCE_MENU_BALLOON_MAIN)
		{
			return new GuiCustomizeMenuBalloonMain(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_COLOR)
		{
			return new GuiCustomizeMenuBalloonColor(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG1)
		{
			return new GuiCustomizeMenuBalloonTier1Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER1_PG2)
		{
			return new GuiCustomizeMenuBalloonTier1Pg2(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER2_PG1)
		{
			return new GuiCustomizeMenuBalloonTier2Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER3_PG1)
		{
			return new GuiCustomizeMenuBalloonTier3Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER4_PG1)
		{
			return new GuiCustomizeMenuBalloonTier4Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		if (ID == GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1)
		{
			return new GuiCustomizeMenuBalloonTier5Pg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		
		
		//Airship Music GUI
		if (ID == GUI_MUSIC_PG1)
		{
			return new GuiAirshipMusicPg1(player.inventory, (EntityAirshipCore)player.getRidingEntity());
		}
		
		return null;
	}
}
