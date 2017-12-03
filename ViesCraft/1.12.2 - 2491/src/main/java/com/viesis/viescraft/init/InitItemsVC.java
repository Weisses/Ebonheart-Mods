package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.items.ItemDismounterNormal;
import com.viesis.viescraft.common.items.ItemDismounterPlayer;
import com.viesis.viescraft.common.items.OLDItemGuidebookControls;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.OLDItemGuidebookPaint;
import com.viesis.viescraft.common.items.OLDItemGuidebookSocket;
import com.viesis.viescraft.common.items.OLDItemAirshipDismounter;
import com.viesis.viescraft.common.items.OLDItemBalloonPattern;
import com.viesis.viescraft.common.items.OLDItemColorizerBalloon;
import com.viesis.viescraft.common.items.OLDItemFrame;
import com.viesis.viescraft.common.items.OLDItemModule;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.achievements.ItemEntityAirship;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipV4;
import com.viesis.viescraft.common.items.airshipitems.ItemCreativeAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.ItemCreativeAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.ItemCreativeAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.ItemCreativeAirshipV4;
import com.viesis.viescraft.common.items.airshipitems.v1.OLDItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.v2.OLDItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.v3.OLDItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.v4.OLDItemAirshipV4;
import com.viesis.viescraft.common.items.parts.ItemModuleCreative;
import com.viesis.viescraft.common.items.parts.ItemModuleType;
import com.viesis.viescraft.common.items.parts.ItemViesoline;
import com.viesis.viescraft.common.items.parts.main.ItemBalloon;
import com.viesis.viescraft.common.items.parts.main.ItemFrame;
import com.viesis.viescraft.common.items.parts.main.ItemEngine;
import com.viesis.viescraft.common.items.parts.main.ItemIgnition;
import com.viesis.viescraft.common.items.parts.main.ItemLogicChip;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeBalloon;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeCore;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeEngine;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeFrame;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void registerItem()
	{
		//airship_battery = registerItem(new ItemAirshipBattery(1500, 100, 100));
		
		guidebook_main = registerItem(new ItemGuidebookMain());
		
		dismounter_normal = registerItem(new ItemDismounterNormal());
		dismounter_player = registerItem(new ItemDismounterPlayer());
		
		viesoline_pellets = registerItem(new ItemViesoline());
		
		logic_chip = registerItem(new ItemLogicChip());
		
		airship_balloon = registerItem(new ItemBalloon());
		airship_frame = registerItem(new ItemFrame());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		upgrade_frame = registerItem(new ItemUpgradeFrame());
		upgrade_core = registerItem(new ItemUpgradeCore());
		upgrade_engine = registerItem(new ItemUpgradeEngine());
		upgrade_balloon = registerItem(new ItemUpgradeBalloon());
		
		module_type = registerItem(new ItemModuleType());
		module_creative = registerItem(new ItemModuleCreative());
		
		
		//==============================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			item_v1_airship = registerItem(new ItemAirshipV1("airships/item_airship_v1"));
			item_creative_v1_airship = registerItem(new ItemCreativeAirshipV1("airships/item_creative_airship_v1"));
		}
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			item_v2_airship = registerItem(new ItemAirshipV2("airships/item_airship_v2"));
			item_creative_v2_airship = registerItem(new ItemCreativeAirshipV2("airships/item_creative_airship_v2"));
		}
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			item_v3_airship = registerItem(new ItemAirshipV3("airships/item_airship_v3"));
			item_creative_v3_airship = registerItem(new ItemCreativeAirshipV3("airships/item_creative_airship_v3"));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			item_v4_airship = registerItem(new ItemAirshipV4("airships/item_airship_v4"));
			item_creative_v4_airship = registerItem(new ItemCreativeAirshipV4("airships/item_creative_airship_v4"));
		}
		//V5
		if(ViesCraftConfig.v5AirshipEnabled)
		{
			//item_v5_airship = registerItem(new ItemAirshipV5("airships/item_airship_v5"));
			//item_creative_v5_airship = registerItem(new ItemCreativeAirshipV5("airships/item_creative_airship_v5"));
		}
		//V6
		if(ViesCraftConfig.v6AirshipEnabled)
		{
			//item_v6_airship = registerItem(new ItemAirshipV6("airships/item_airship_v6"));
			//item_creative_v6_airship = registerItem(new ItemCreativeAirshipV6("airships/item_creative_airship_v6"));
		}
		
		//OLD
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			item_airship_v1 = registerItem(new OLDItemAirshipV1("v1/item_airship_v1"));
		}
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			item_airship_v2 = registerItem(new OLDItemAirshipV2("v2/item_airship_v2"));
		}
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			item_airship_v3 = registerItem(new OLDItemAirshipV3("v3/item_airship_v3"));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			item_airship_v4 = registerItem(new OLDItemAirshipV4("v4/item_airship_v4"));
		}
		//V5
		//if(ViesCraftConfig.v5AirshipEnabled)
		//{
		//	item_airship_v5 = registerItem(new OLDItemAirshipV5("v5/item_airship_v5"));
		//}
		//V6
		//if(ViesCraftConfig.v6AirshipEnabled)
		//{
		//	item_airship_v6 = registerItem(new OLDItemAirshipV6("v6/item_airship_v6"));
		//}
		
		//==============================================
		
		achievement_airship = registerItem(new ItemAchievement());
		
		item_entity_airship = registerItem(new ItemEntityAirship());
		
		//item_pouch_module = registerItem(new ItemPouchModule());
		//item_pouch_all = registerItem(new ItemPouchAll());
		
		//TODO REMOVE NEXT UPDATE
		guidebook_controls = registerItem(new OLDItemGuidebookControls());
		guidebook_paint = registerItem(new OLDItemGuidebookPaint());
		guidebook_socket = registerItem(new OLDItemGuidebookSocket());
		airship_dismounter = registerItem(new OLDItemAirshipDismounter());
		//To be deleted
				airship_baseframe = registerItem(new OLDItemFrame());
				airship_balloon_pattern = registerItem(new OLDItemBalloonPattern());
				item_balloon_colorizer = registerItem(new OLDItemColorizerBalloon());
				airship_module = registerItem(new OLDItemModule());
				
				
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
