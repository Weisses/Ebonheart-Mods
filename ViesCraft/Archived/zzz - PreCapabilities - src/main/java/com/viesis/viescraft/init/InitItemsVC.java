package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.items.ItemAirshipDismounter;
import com.viesis.viescraft.common.items.ItemGuidebookControls;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.ItemGuidebookPaint;
import com.viesis.viescraft.common.items.ItemGuidebookSocket;
import com.viesis.viescraft.common.items.achievements.ItemAchievementAirborn;
import com.viesis.viescraft.common.items.achievements.ItemAchievementCreate;
import com.viesis.viescraft.common.items.achievements.ItemAchievementCreateColor;
import com.viesis.viescraft.common.items.achievements.ItemAchievementCreateModule;
import com.viesis.viescraft.common.items.achievements.ItemAchievementEngine;
import com.viesis.viescraft.common.items.achievements.ItemAchievementIgnition;
import com.viesis.viescraft.common.items.achievements.ItemAchievementLava;
import com.viesis.viescraft.common.items.achievements.ItemAchievementWater;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Admin;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Black;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Blue;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Brown;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Cyan;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Gray;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Green;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1LightGray;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Lime;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Magenta;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Normal;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Orange;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Pink;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Purple;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Red;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1White;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Yellow;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Admin;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Black;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Blue;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Brown;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Cyan;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Gray;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Green;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2LightGray;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Lime;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Magenta;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Normal;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Orange;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Pink;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Purple;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Red;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2White;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Yellow;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Admin;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Black;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Blue;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Brown;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Cyan;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Gray;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Green;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3LightGray;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Lime;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Magenta;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Normal;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Orange;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Pink;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Purple;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Red;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3White;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Yellow;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Admin;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Black;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Blue;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Brown;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Cyan;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Gray;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Green;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4LightGray;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Lime;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Magenta;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Normal;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Orange;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Pink;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Purple;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Red;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4White;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Yellow;
import com.viesis.viescraft.common.items.modules.ItemFuelModuleInfinite;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleLarge;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleSmall;
import com.viesis.viescraft.common.items.modules.ItemModuleChip;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMajor;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMinor;
import com.viesis.viescraft.common.items.resources.ItemBalloon;
import com.viesis.viescraft.common.items.resources.ItemEngine;
import com.viesis.viescraft.common.items.resources.ItemIgnition;
import com.viesis.viescraft.common.items.resources.ItemPaint;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		guidebook_main = registerItem(new ItemGuidebookMain());
		guidebook_controls = registerItem(new ItemGuidebookControls());
		guidebook_paint = registerItem(new ItemGuidebookPaint());
		guidebook_socket = registerItem(new ItemGuidebookSocket());
		
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		airship_dismounter = registerItem(new ItemAirshipDismounter());
		
		module_chip = registerItem(new ItemModuleChip());
		module_inventory_small = registerItem(new ItemInventoryModuleSmall());
		module_inventory_large = registerItem(new ItemInventoryModuleLarge());
		module_speed_increase_minor = registerItem(new ItemSpeedModuleMinor());
		module_speed_increase_major = registerItem(new ItemSpeedModuleMajor());
		module_fuel_infinite = registerItem(new ItemFuelModuleInfinite());
		
		//module_stealth = registerItem(new ItemModuleStealth());
		//module_dash = registerItem(new ItemModuleDash());
		
		item_airship_normal = registerItem(new ItemAirshipV1Normal());
		item_airship_black = registerItem(new ItemAirshipV1Black());
		item_airship_blue = registerItem(new ItemAirshipV1Blue());
		item_airship_brown = registerItem(new ItemAirshipV1Brown());
		item_airship_cyan = registerItem(new ItemAirshipV1Cyan());
		item_airship_gray = registerItem(new ItemAirshipV1Gray());
		item_airship_green = registerItem(new ItemAirshipV1Green());
		item_airship_lightblue = registerItem(new ItemAirshipV1LightBlue());
		item_airship_lightgray = registerItem(new ItemAirshipV1LightGray());
		item_airship_lime = registerItem(new ItemAirshipV1Lime());
		item_airship_magenta = registerItem(new ItemAirshipV1Magenta());
		item_airship_orange = registerItem(new ItemAirshipV1Orange());
		item_airship_pink = registerItem(new ItemAirshipV1Pink());
		item_airship_purple = registerItem(new ItemAirshipV1Purple());
		item_airship_red = registerItem(new ItemAirshipV1Red());
		item_airship_white = registerItem(new ItemAirshipV1White());
		item_airship_yellow = registerItem(new ItemAirshipV1Yellow());
		item_airship_v1_admin = registerItem(new ItemAirshipV1Admin());
		
		item_airship_v2_normal = registerItem(new ItemAirshipV2Normal());
		item_airship_v2_black = registerItem(new ItemAirshipV2Black());
		item_airship_v2_blue = registerItem(new ItemAirshipV2Blue());
		item_airship_v2_brown = registerItem(new ItemAirshipV2Brown());
		item_airship_v2_cyan = registerItem(new ItemAirshipV2Cyan());
		item_airship_v2_gray = registerItem(new ItemAirshipV2Gray());
		item_airship_v2_green = registerItem(new ItemAirshipV2Green());
		item_airship_v2_lightblue = registerItem(new ItemAirshipV2LightBlue());
		item_airship_v2_lightgray = registerItem(new ItemAirshipV2LightGray());
		item_airship_v2_lime = registerItem(new ItemAirshipV2Lime());
		item_airship_v2_magenta = registerItem(new ItemAirshipV2Magenta());
		item_airship_v2_orange = registerItem(new ItemAirshipV2Orange());
		item_airship_v2_pink = registerItem(new ItemAirshipV2Pink());
		item_airship_v2_purple = registerItem(new ItemAirshipV2Purple());
		item_airship_v2_red = registerItem(new ItemAirshipV2Red());
		item_airship_v2_white = registerItem(new ItemAirshipV2White());
		item_airship_v2_yellow = registerItem(new ItemAirshipV2Yellow());
		item_airship_v2_admin = registerItem(new ItemAirshipV2Admin());
		
		item_airship_v3_normal = registerItem(new ItemAirshipV3Normal());
		item_airship_v3_black = registerItem(new ItemAirshipV3Black());
		item_airship_v3_blue = registerItem(new ItemAirshipV3Blue());
		item_airship_v3_brown = registerItem(new ItemAirshipV3Brown());
		item_airship_v3_cyan = registerItem(new ItemAirshipV3Cyan());
		item_airship_v3_gray = registerItem(new ItemAirshipV3Gray());
		item_airship_v3_green = registerItem(new ItemAirshipV3Green());
		item_airship_v3_lightblue = registerItem(new ItemAirshipV3LightBlue());
		item_airship_v3_lightgray = registerItem(new ItemAirshipV3LightGray());
		item_airship_v3_lime = registerItem(new ItemAirshipV3Lime());
		item_airship_v3_magenta = registerItem(new ItemAirshipV3Magenta());
		item_airship_v3_orange = registerItem(new ItemAirshipV3Orange());
		item_airship_v3_pink = registerItem(new ItemAirshipV3Pink());
		item_airship_v3_purple = registerItem(new ItemAirshipV3Purple());
		item_airship_v3_red = registerItem(new ItemAirshipV3Red());
		item_airship_v3_white = registerItem(new ItemAirshipV3White());
		item_airship_v3_yellow = registerItem(new ItemAirshipV3Yellow());
		item_airship_v3_admin = registerItem(new ItemAirshipV3Admin());
		
		item_airship_v4_normal = registerItem(new ItemAirshipV4Normal());
		item_airship_v4_black = registerItem(new ItemAirshipV4Black());
		item_airship_v4_blue = registerItem(new ItemAirshipV4Blue());
		item_airship_v4_brown = registerItem(new ItemAirshipV4Brown());
		item_airship_v4_cyan = registerItem(new ItemAirshipV4Cyan());
		item_airship_v4_gray = registerItem(new ItemAirshipV4Gray());
		item_airship_v4_green = registerItem(new ItemAirshipV4Green());
		item_airship_v4_lightblue = registerItem(new ItemAirshipV4LightBlue());
		item_airship_v4_lightgray = registerItem(new ItemAirshipV4LightGray());
		item_airship_v4_lime = registerItem(new ItemAirshipV4Lime());
		item_airship_v4_magenta = registerItem(new ItemAirshipV4Magenta());
		item_airship_v4_orange = registerItem(new ItemAirshipV4Orange());
		item_airship_v4_pink = registerItem(new ItemAirshipV4Pink());
		item_airship_v4_purple = registerItem(new ItemAirshipV4Purple());
		item_airship_v4_red = registerItem(new ItemAirshipV4Red());
		item_airship_v4_white = registerItem(new ItemAirshipV4White());
		item_airship_v4_yellow = registerItem(new ItemAirshipV4Yellow());
		item_airship_v4_admin = registerItem(new ItemAirshipV4Admin());
		
		item_paint_black = registerItem(new ItemPaint(EntityAirshipV1Core.Type.BLACK));
		item_paint_blue = registerItem(new ItemPaint(EntityAirshipV1Core.Type.BLUE));
		item_paint_brown = registerItem(new ItemPaint(EntityAirshipV1Core.Type.BROWN));
		item_paint_cyan = registerItem(new ItemPaint(EntityAirshipV1Core.Type.CYAN));
		item_paint_gray = registerItem(new ItemPaint(EntityAirshipV1Core.Type.GRAY));
		item_paint_green = registerItem(new ItemPaint(EntityAirshipV1Core.Type.GREEN));
		item_paint_lightblue = registerItem(new ItemPaint(EntityAirshipV1Core.Type.LIGHTBLUE));
		item_paint_lightgray = registerItem(new ItemPaint(EntityAirshipV1Core.Type.LIGHTGRAY));
		item_paint_lime = registerItem(new ItemPaint(EntityAirshipV1Core.Type.LIME));
		item_paint_magenta = registerItem(new ItemPaint(EntityAirshipV1Core.Type.MAGENTA));
		item_paint_orange = registerItem(new ItemPaint(EntityAirshipV1Core.Type.ORANGE));
		item_paint_pink = registerItem(new ItemPaint(EntityAirshipV1Core.Type.PINK));
		item_paint_purple = registerItem(new ItemPaint(EntityAirshipV1Core.Type.PURPLE));
		item_paint_red = registerItem(new ItemPaint(EntityAirshipV1Core.Type.RED));
		item_paint_white = registerItem(new ItemPaint(EntityAirshipV1Core.Type.WHITE));
		item_paint_yellow = registerItem(new ItemPaint(EntityAirshipV1Core.Type.YELLOW));
		
		achievement_airship_create_engine = registerItem(new ItemAchievementEngine());
		achievement_airship_create_ignition = registerItem(new ItemAchievementIgnition());
		achievement_airship_create = registerItem(new ItemAchievementCreate());
		achievement_airship_create_color = registerItem(new ItemAchievementCreateColor());
		achievement_airship_create_module = registerItem(new ItemAchievementCreateModule());
		
		achievement_airship_airborn = registerItem(new ItemAchievementAirborn());
		achievement_airship_water = registerItem(new ItemAchievementWater());
		achievement_airship_lava = registerItem(new ItemAchievementLava());
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
