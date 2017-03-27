package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.items.ItemAirshipDismounter;
import com.viesis.viescraft.common.items.ItemGuidebookControls;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.ItemGuidebookPaint;
import com.viesis.viescraft.common.items.ItemGuidebookSocket;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.achievements.ItemEntityAirship;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4;
import com.viesis.viescraft.common.items.modules.ItemFuelModuleInfinite;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleLarge;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleSmall;
import com.viesis.viescraft.common.items.modules.ItemModuleChip;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMajor;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMinor;
import com.viesis.viescraft.common.items.parts.ItemBalloon;
import com.viesis.viescraft.common.items.parts.ItemBalloonPattern;
import com.viesis.viescraft.common.items.parts.ItemColorizerBalloon;
import com.viesis.viescraft.common.items.parts.ItemEngine;
import com.viesis.viescraft.common.items.parts.ItemFrame;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemModule;
import com.viesis.viescraft.common.items.parts.ItemViesoline;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void registerItem()
	{
		guidebook_main = registerItem(new ItemGuidebookMain());
		guidebook_controls = registerItem(new ItemGuidebookControls());
		guidebook_paint = registerItem(new ItemGuidebookPaint());
		guidebook_socket = registerItem(new ItemGuidebookSocket());
		
		viesoline_pellets = registerItem(new ItemViesoline());
		//airship_battery = registerItem(new ItemAirshipBattery(1500, 100, 100));
		
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		airship_dismounter = registerItem(new ItemAirshipDismounter());
		
		airship_frame = registerItem(new ItemFrame());
		airship_balloon_pattern = registerItem(new ItemBalloonPattern());
		airship_module = registerItem(new ItemModule());
		
		item_balloon_colorizer = registerItem(new ItemColorizerBalloon());
		
		module_chip = registerItem(new ItemModuleChip());
		
		module_inventory_small = registerItem(new ItemInventoryModuleSmall());
		module_inventory_large = registerItem(new ItemInventoryModuleLarge());
		module_speed_increase_minor = registerItem(new ItemSpeedModuleMinor());
		module_speed_increase_major = registerItem(new ItemSpeedModuleMajor());
		module_fuel_infinite = registerItem(new ItemFuelModuleInfinite());
		
		//==============================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			item_airship_v1 = registerItem(new ItemAirshipV1("v1/item_airship_v1"));
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			item_airship_v2 = registerItem(new ItemAirshipV2("v2/item_airship_v2"));
		}
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			item_airship_v3 = registerItem(new ItemAirshipV3("v3/item_airship_v3"));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			item_airship_v4 = registerItem(new ItemAirshipV4("v4/item_airship_v4"));
		}
		
		//==============================================
		
		achievement_airship = registerItem(new ItemAchievement());
		
		item_entity_airship = registerItem(new ItemEntityAirship());
	}
	
	public static void registerItemTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
