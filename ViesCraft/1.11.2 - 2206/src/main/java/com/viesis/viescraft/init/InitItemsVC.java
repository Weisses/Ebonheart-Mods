package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
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
import com.viesis.viescraft.common.items.parts.ItemAirshipBattery;
import com.viesis.viescraft.common.items.parts.ItemBalloon;
import com.viesis.viescraft.common.items.parts.ItemEngine;
import com.viesis.viescraft.common.items.parts.ItemFrame;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemPaint;
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
		airship_battery = registerItem(new ItemAirshipBattery(1000, 1, 1));
		
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		airship_dismounter = registerItem(new ItemAirshipDismounter());
		
		item_paint = registerItem(new ItemPaint());
		
		airship_frame = registerItem(new ItemFrame());
		
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
			item_airship_v1_wood0 = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1", EntityAirshipBaseVC.Frame.WOOD0.ordinal()));
			item_airship_v1_iron = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1", EntityAirshipBaseVC.Frame.IRON.ordinal()));
			item_airship_v1_redstone = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1", EntityAirshipBaseVC.Frame.REDSTONE.ordinal()));
			item_airship_v1_gold = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1", EntityAirshipBaseVC.Frame.GOLD.ordinal()));
			item_airship_v1_lapislazuli = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal()));
			item_airship_v1_obsidian = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal()));
			item_airship_v1_diamond = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1", EntityAirshipBaseVC.Frame.DIAMOND.ordinal()));
			item_airship_v1_emerald = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1", EntityAirshipBaseVC.Frame.EMERALD.ordinal()));
			item_airship_v1_netherbrick = registerItem(new ItemAirshipV1("v1/netherbrick/item_airship_v1", EntityAirshipBaseVC.Frame.NETHERBRICK.ordinal()));
			item_airship_v1_purpur = registerItem(new ItemAirshipV1("v1/purpur/item_airship_v1", EntityAirshipBaseVC.Frame.PURPUR.ordinal()));
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			item_airship_v2_wood0 = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2", EntityAirshipBaseVC.Frame.WOOD0.ordinal()));
			item_airship_v2_iron = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2", EntityAirshipBaseVC.Frame.IRON.ordinal()));
			item_airship_v2_redstone = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2", EntityAirshipBaseVC.Frame.REDSTONE.ordinal()));
			item_airship_v2_gold = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2", EntityAirshipBaseVC.Frame.GOLD.ordinal()));
			item_airship_v2_lapislazuli = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal()));
			item_airship_v2_obsidian = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal()));
			item_airship_v2_diamond = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2", EntityAirshipBaseVC.Frame.DIAMOND.ordinal()));
			item_airship_v2_emerald = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2", EntityAirshipBaseVC.Frame.EMERALD.ordinal()));
			item_airship_v2_netherbrick = registerItem(new ItemAirshipV2("v2/netherbrick/item_airship_v2", EntityAirshipBaseVC.Frame.NETHERBRICK.ordinal()));
			item_airship_v2_purpur = registerItem(new ItemAirshipV2("v2/purpur/item_airship_v2", EntityAirshipBaseVC.Frame.PURPUR.ordinal()));
		}
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			item_airship_v3_wood0 = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3", EntityAirshipBaseVC.Frame.WOOD0.ordinal()));
			item_airship_v3_iron = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3", EntityAirshipBaseVC.Frame.IRON.ordinal()));
			item_airship_v3_redstone = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3", EntityAirshipBaseVC.Frame.REDSTONE.ordinal()));
			item_airship_v3_gold = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3", EntityAirshipBaseVC.Frame.GOLD.ordinal()));
			item_airship_v3_lapislazuli = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal()));
			item_airship_v3_obsidian = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal()));
			item_airship_v3_diamond = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3", EntityAirshipBaseVC.Frame.DIAMOND.ordinal()));
			item_airship_v3_emerald = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3", EntityAirshipBaseVC.Frame.EMERALD.ordinal()));
			item_airship_v3_netherbrick = registerItem(new ItemAirshipV3("v3/netherbrick/item_airship_v3", EntityAirshipBaseVC.Frame.NETHERBRICK.ordinal()));
			item_airship_v3_purpur = registerItem(new ItemAirshipV3("v3/purpur/item_airship_v3", EntityAirshipBaseVC.Frame.PURPUR.ordinal()));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			item_airship_v4_wood0 = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4", EntityAirshipBaseVC.Frame.WOOD0.ordinal()));
			item_airship_v4_iron = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4", EntityAirshipBaseVC.Frame.IRON.ordinal()));
			item_airship_v4_redstone = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4", EntityAirshipBaseVC.Frame.REDSTONE.ordinal()));
			item_airship_v4_gold = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4", EntityAirshipBaseVC.Frame.GOLD.ordinal()));
			item_airship_v4_lapislazuli = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal()));
			item_airship_v4_obsidian = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal()));
			item_airship_v4_diamond = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4", EntityAirshipBaseVC.Frame.DIAMOND.ordinal()));
			item_airship_v4_emerald = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4", EntityAirshipBaseVC.Frame.EMERALD.ordinal()));
			item_airship_v4_netherbrick = registerItem(new ItemAirshipV4("v4/netherbrick/item_airship_v4", EntityAirshipBaseVC.Frame.NETHERBRICK.ordinal()));
			item_airship_v4_purpur = registerItem(new ItemAirshipV4("v4/purpur/item_airship_v4", EntityAirshipBaseVC.Frame.PURPUR.ordinal()));
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
