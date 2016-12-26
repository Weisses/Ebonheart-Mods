package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
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
import com.viesis.viescraft.common.items.achievements.ItemAchievementPortal;
import com.viesis.viescraft.common.items.achievements.ItemAchievementWater;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Diamond;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Emerald;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Gold;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Iron;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1LapisLazuli;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Obsidian;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Redstone;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemV1Wood0;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Admin;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Black;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Blue;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Brown;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Cyan;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Gray;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Green;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1LightGray;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Lime;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Magenta;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Orange;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Pink;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Purple;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Red;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1White;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1Yellow;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Yellow;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Admin;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Black;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Blue;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Brown;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Cyan;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Gray;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Green;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2LightGray;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Lime;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Magenta;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Normal;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Orange;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Pink;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Purple;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2Red;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2White;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Yellow;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Admin;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Black;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Blue;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Brown;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Cyan;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Gray;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Green;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3LightGray;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Lime;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Magenta;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Normal;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Orange;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Pink;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Purple;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3Red;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3White;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Yellow;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Admin;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Black;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Blue;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Brown;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Cyan;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Gray;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Green;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4LightBlue;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4LightGray;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Lime;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Magenta;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Normal;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Orange;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Pink;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Purple;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4Red;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4White;
import com.viesis.viescraft.common.items.modules.ItemFuelModuleInfinite;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleLarge;
import com.viesis.viescraft.common.items.modules.ItemInventoryModuleSmall;
import com.viesis.viescraft.common.items.modules.ItemModuleChip;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMajor;
import com.viesis.viescraft.common.items.modules.ItemSpeedModuleMinor;
import com.viesis.viescraft.common.items.parts.ItemBalloon;
import com.viesis.viescraft.common.items.parts.ItemEngine;
import com.viesis.viescraft.common.items.parts.ItemFrameDiamond;
import com.viesis.viescraft.common.items.parts.ItemFrameEmerald;
import com.viesis.viescraft.common.items.parts.ItemFrameGold;
import com.viesis.viescraft.common.items.parts.ItemFrameIron;
import com.viesis.viescraft.common.items.parts.ItemFrameLapisLazuli;
import com.viesis.viescraft.common.items.parts.ItemFrameRedstone;
import com.viesis.viescraft.common.items.parts.ItemFrameWood0;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemPaint;

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
		
		airship_frame_wood0 = registerItem(new ItemFrameWood0());
		airship_frame_iron = registerItem(new ItemFrameIron());
		airship_frame_redstone = registerItem(new ItemFrameRedstone());
		airship_frame_gold = registerItem(new ItemFrameGold());
		airship_frame_lapislazuli = registerItem(new ItemFrameLapisLazuli());
		airship_frame_diamond = registerItem(new ItemFrameDiamond());
		airship_frame_emerald = registerItem(new ItemFrameEmerald());
		
		airship_dismounter = registerItem(new ItemAirshipDismounter());
		
		module_chip = registerItem(new ItemModuleChip());
		module_inventory_small = registerItem(new ItemInventoryModuleSmall());
		module_inventory_large = registerItem(new ItemInventoryModuleLarge());
		module_speed_increase_minor = registerItem(new ItemSpeedModuleMinor());
		module_speed_increase_major = registerItem(new ItemSpeedModuleMajor());
		module_fuel_infinite = registerItem(new ItemFuelModuleInfinite());
		
		//module_stealth = registerItem(new ItemModuleStealth());
		//module_dash = registerItem(new ItemModuleDash());
		
		//==============================================
		
		//V1
		item_airship_v1_wood0_normal = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_wood0_black = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_wood0_blue = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_wood0_brown = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_wood0_cyan = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_wood0_gray = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_wood0_green = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_wood0_lightblue = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_wood0_lightgray = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_wood0_lime = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_wood0_magenta = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_wood0_orange = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_wood0_pink = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_wood0_purple = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_wood0_red = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_wood0_white = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_wood0_yellow = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_wood0_admin = registerItem(new ItemV1Wood0("v1/wood0/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_iron_normal = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_iron_black = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_iron_blue = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_iron_brown = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_iron_cyan = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_iron_gray = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_iron_green = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_iron_lightblue = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_iron_lightgray = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_iron_lime = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_iron_magenta = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_iron_orange = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_iron_pink = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_iron_purple = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_iron_red = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_iron_white = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_iron_yellow = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_iron_admin = registerItem(new ItemV1Iron("v1/iron/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_redstone_normal = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_redstone_black = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_redstone_blue = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_redstone_brown = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_redstone_cyan = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_redstone_gray = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_redstone_green = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_redstone_lightblue = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_redstone_lightgray = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_redstone_lime = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_redstone_magenta = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_redstone_orange = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_redstone_pink = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_redstone_purple = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_redstone_red = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_redstone_white = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_redstone_yellow = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_redstone_admin = registerItem(new ItemV1Redstone("v1/redstone/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_gold_normal = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_gold_black = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_gold_blue = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_gold_brown = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_gold_cyan = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_gold_gray = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_gold_green = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_gold_lightblue = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_gold_lightgray = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_gold_lime = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_gold_magenta = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_gold_orange = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_gold_pink = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_gold_purple = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_gold_red = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_gold_white = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_gold_yellow = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_gold_admin = registerItem(new ItemV1Gold("v1/gold/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_lapislazuli_normal = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_lapislazuli_black = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_lapislazuli_blue = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_lapislazuli_brown = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_lapislazuli_cyan = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_lapislazuli_gray = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_lapislazuli_green = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_lapislazuli_lightblue = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_lapislazuli_lightgray = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_lapislazuli_lime = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_lapislazuli_magenta = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_lapislazuli_orange = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_lapislazuli_pink = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_lapislazuli_purple = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_lapislazuli_red = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_lapislazuli_white = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_lapislazuli_yellow = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_lapislazuli_admin = registerItem(new ItemV1LapisLazuli("v1/lapislazuli/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_obsidian_normal = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_obsidian_black = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_obsidian_blue = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_obsidian_brown = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_obsidian_cyan = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_obsidian_gray = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_obsidian_green = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_obsidian_lightblue = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_obsidian_lightgray = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_obsidian_lime = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_obsidian_magenta = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_obsidian_orange = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_obsidian_pink = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_obsidian_purple = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_obsidian_red = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_obsidian_white = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_obsidian_yellow = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_obsidian_admin = registerItem(new ItemV1Obsidian("v1/obsidian/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_diamond_normal = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_diamond_black = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_diamond_blue = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_diamond_brown = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_diamond_cyan = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_diamond_gray = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_diamond_green = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_diamond_lightblue = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_diamond_lightgray = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_diamond_lime = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_diamond_magenta = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_diamond_orange = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_diamond_pink = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_diamond_purple = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_diamond_red = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_diamond_white = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_diamond_yellow = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_diamond_admin = registerItem(new ItemV1Diamond("v1/diamond/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		item_airship_v1_emerald_normal = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_normal", EntityAirshipBaseVC.Type.NORMAL.ordinal()));
		item_airship_v1_emerald_black = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_black", EntityAirshipBaseVC.Type.BLACK.ordinal()));
		item_airship_v1_emerald_blue = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_blue", EntityAirshipBaseVC.Type.BLUE.ordinal()));
		item_airship_v1_emerald_brown = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_brown", EntityAirshipBaseVC.Type.BROWN.ordinal()));
		item_airship_v1_emerald_cyan = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_cyan", EntityAirshipBaseVC.Type.CYAN.ordinal()));
		item_airship_v1_emerald_gray = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_gray", EntityAirshipBaseVC.Type.GRAY.ordinal()));
		item_airship_v1_emerald_green = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_green", EntityAirshipBaseVC.Type.GREEN.ordinal()));
		item_airship_v1_emerald_lightblue = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_lightblue", EntityAirshipBaseVC.Type.LIGHTBLUE.ordinal()));
		item_airship_v1_emerald_lightgray = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_lightgray", EntityAirshipBaseVC.Type.LIGHTGRAY.ordinal()));
		item_airship_v1_emerald_lime = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_lime", EntityAirshipBaseVC.Type.LIME.ordinal()));
		item_airship_v1_emerald_magenta = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_magenta", EntityAirshipBaseVC.Type.MAGENTA.ordinal()));
		item_airship_v1_emerald_orange = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_orange", EntityAirshipBaseVC.Type.ORANGE.ordinal()));
		item_airship_v1_emerald_pink = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_pink", EntityAirshipBaseVC.Type.PINK.ordinal()));
		item_airship_v1_emerald_purple = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_purple", EntityAirshipBaseVC.Type.PURPLE.ordinal()));
		item_airship_v1_emerald_red = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_red", EntityAirshipBaseVC.Type.RED.ordinal()));
		item_airship_v1_emerald_white = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_white", EntityAirshipBaseVC.Type.WHITE.ordinal()));
		item_airship_v1_emerald_yellow = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_yellow", EntityAirshipBaseVC.Type.YELLOW.ordinal()));
		item_airship_v1_emerald_admin = registerItem(new ItemV1Emerald("v1/emerald/item_airship_v1_admin", EntityAirshipBaseVC.Type.ADMIN.ordinal()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		//==============================================
		
		//V2
		item_airship_v2_wood0_normal = registerItem(new ItemAirshipV2Wood0Normal());
		item_airship_v2_wood0_black = registerItem(new ItemAirshipV2Wood0Black());
		item_airship_v2_wood0_blue = registerItem(new ItemAirshipV2Wood0Blue());
		item_airship_v2_wood0_brown = registerItem(new ItemAirshipV2Wood0Brown());
		item_airship_v2_wood0_cyan = registerItem(new ItemAirshipV2Wood0Cyan());
		item_airship_v2_wood0_gray = registerItem(new ItemAirshipV2Wood0Gray());
		item_airship_v2_wood0_green = registerItem(new ItemAirshipV2Wood0Green());
		item_airship_v2_wood0_lightblue = registerItem(new ItemAirshipV2Wood0LightBlue());
		item_airship_v2_wood0_lightgray = registerItem(new ItemAirshipV2Wood0LightGray());
		item_airship_v2_wood0_lime = registerItem(new ItemAirshipV2Wood0Lime());
		item_airship_v2_wood0_magenta = registerItem(new ItemAirshipV2Wood0Magenta());
		item_airship_v2_wood0_orange = registerItem(new ItemAirshipV2Wood0Orange());
		item_airship_v2_wood0_pink = registerItem(new ItemAirshipV2Wood0Pink());
		item_airship_v2_wood0_purple = registerItem(new ItemAirshipV2Wood0Purple());
		item_airship_v2_wood0_red = registerItem(new ItemAirshipV2Wood0Red());
		item_airship_v2_wood0_white = registerItem(new ItemAirshipV2Wood0White());
		item_airship_v2_wood0_yellow = registerItem(new ItemAirshipV2Wood0Yellow());
		item_airship_v2_wood0_admin = registerItem(new ItemAirshipV2Wood0Admin());
		
		item_airship_v2_iron_normal = registerItem(new ItemAirshipV2IronNormal());
		item_airship_v2_iron_black = registerItem(new ItemAirshipV2IronBlack());
		item_airship_v2_iron_blue = registerItem(new ItemAirshipV2IronBlue());
		item_airship_v2_iron_brown = registerItem(new ItemAirshipV2IronBrown());
		item_airship_v2_iron_cyan = registerItem(new ItemAirshipV2IronCyan());
		item_airship_v2_iron_gray = registerItem(new ItemAirshipV2IronGray());
		item_airship_v2_iron_green = registerItem(new ItemAirshipV2IronGreen());
		item_airship_v2_iron_lightblue = registerItem(new ItemAirshipV2IronLightBlue());
		item_airship_v2_iron_lightgray = registerItem(new ItemAirshipV2IronLightGray());
		item_airship_v2_iron_lime = registerItem(new ItemAirshipV2IronLime());
		item_airship_v2_iron_magenta = registerItem(new ItemAirshipV2IronMagenta());
		item_airship_v2_iron_orange = registerItem(new ItemAirshipV2IronOrange());
		item_airship_v2_iron_pink = registerItem(new ItemAirshipV2IronPink());
		item_airship_v2_iron_purple = registerItem(new ItemAirshipV2IronPurple());
		item_airship_v2_iron_red = registerItem(new ItemAirshipV2IronRed());
		item_airship_v2_iron_white = registerItem(new ItemAirshipV2IronWhite());
		item_airship_v2_iron_yellow = registerItem(new ItemAirshipV2IronYellow());
		item_airship_v2_iron_admin = registerItem(new ItemAirshipV2IronAdmin());
		
		item_airship_v2_redstone_normal = registerItem(new ItemAirshipV2RedstoneNormal());
		item_airship_v2_redstone_black = registerItem(new ItemAirshipV2RedstoneBlack());
		item_airship_v2_redstone_blue = registerItem(new ItemAirshipV2RedstoneBlue());
		item_airship_v2_redstone_brown = registerItem(new ItemAirshipV2RedstoneBrown());
		item_airship_v2_redstone_cyan = registerItem(new ItemAirshipV2RedstoneCyan());
		item_airship_v2_redstone_gray = registerItem(new ItemAirshipV2RedstoneGray());
		item_airship_v2_redstone_green = registerItem(new ItemAirshipV2RedstoneGreen());
		item_airship_v2_redstone_lightblue = registerItem(new ItemAirshipV2RedstoneLightBlue());
		item_airship_v2_redstone_lightgray = registerItem(new ItemAirshipV2RedstoneLightGray());
		item_airship_v2_redstone_lime = registerItem(new ItemAirshipV2RedstoneLime());
		item_airship_v2_redstone_magenta = registerItem(new ItemAirshipV2RedstoneMagenta());
		item_airship_v2_redstone_orange = registerItem(new ItemAirshipV2RedstoneOrange());
		item_airship_v2_redstone_pink = registerItem(new ItemAirshipV2RedstonePink());
		item_airship_v2_redstone_purple = registerItem(new ItemAirshipV2RedstonePurple());
		item_airship_v2_redstone_red = registerItem(new ItemAirshipV2RedstoneRed());
		item_airship_v2_redstone_white = registerItem(new ItemAirshipV2RedstoneWhite());
		item_airship_v2_redstone_yellow = registerItem(new ItemAirshipV2RedstoneYellow());
		item_airship_v2_redstone_admin = registerItem(new ItemAirshipV2RedstoneAdmin());
		
		item_airship_v2_gold_normal = registerItem(new ItemAirshipV2GoldNormal());
		item_airship_v2_gold_black = registerItem(new ItemAirshipV2GoldBlack());
		item_airship_v2_gold_blue = registerItem(new ItemAirshipV2GoldBlue());
		item_airship_v2_gold_brown = registerItem(new ItemAirshipV2GoldBrown());
		item_airship_v2_gold_cyan = registerItem(new ItemAirshipV2GoldCyan());
		item_airship_v2_gold_gray = registerItem(new ItemAirshipV2GoldGray());
		item_airship_v2_gold_green = registerItem(new ItemAirshipV2GoldGreen());
		item_airship_v2_gold_lightblue = registerItem(new ItemAirshipV2GoldLightBlue());
		item_airship_v2_gold_lightgray = registerItem(new ItemAirshipV2GoldLightGray());
		item_airship_v2_gold_lime = registerItem(new ItemAirshipV2GoldLime());
		item_airship_v2_gold_magenta = registerItem(new ItemAirshipV2GoldMagenta());
		item_airship_v2_gold_orange = registerItem(new ItemAirshipV2GoldOrange());
		item_airship_v2_gold_pink = registerItem(new ItemAirshipV2GoldPink());
		item_airship_v2_gold_purple = registerItem(new ItemAirshipV2GoldPurple());
		item_airship_v2_gold_red = registerItem(new ItemAirshipV2GoldRed());
		item_airship_v2_gold_white = registerItem(new ItemAirshipV2GoldWhite());
		item_airship_v2_gold_yellow = registerItem(new ItemAirshipV2GoldYellow());
		item_airship_v2_gold_admin = registerItem(new ItemAirshipV2GoldAdmin());
		
		item_airship_v2_lapislazuli_normal = registerItem(new ItemAirshipV2LapisLazuliNormal());
		item_airship_v2_lapislazuli_black = registerItem(new ItemAirshipV2LapisLazuliBlack());
		item_airship_v2_lapislazuli_blue = registerItem(new ItemAirshipV2LapisLazuliBlue());
		item_airship_v2_lapislazuli_brown = registerItem(new ItemAirshipV2LapisLazuliBrown());
		item_airship_v2_lapislazuli_cyan = registerItem(new ItemAirshipV2LapisLazuliCyan());
		item_airship_v2_lapislazuli_gray = registerItem(new ItemAirshipV2LapisLazuliGray());
		item_airship_v2_lapislazuli_green = registerItem(new ItemAirshipV2LapisLazuliGreen());
		item_airship_v2_lapislazuli_lightblue = registerItem(new ItemAirshipV2LapisLazuliLightBlue());
		item_airship_v2_lapislazuli_lightgray = registerItem(new ItemAirshipV2LapisLazuliLightGray());
		item_airship_v2_lapislazuli_lime = registerItem(new ItemAirshipV2LapisLazuliLime());
		item_airship_v2_lapislazuli_magenta = registerItem(new ItemAirshipV2LapisLazuliMagenta());
		item_airship_v2_lapislazuli_orange = registerItem(new ItemAirshipV2LapisLazuliOrange());
		item_airship_v2_lapislazuli_pink = registerItem(new ItemAirshipV2LapisLazuliPink());
		item_airship_v2_lapislazuli_purple = registerItem(new ItemAirshipV2LapisLazuliPurple());
		item_airship_v2_lapislazuli_red = registerItem(new ItemAirshipV2LapisLazuliRed());
		item_airship_v2_lapislazuli_white = registerItem(new ItemAirshipV2LapisLazuliWhite());
		item_airship_v2_lapislazuli_yellow = registerItem(new ItemAirshipV2LapisLazuliYellow());
		item_airship_v2_lapislazuli_admin = registerItem(new ItemAirshipV2LapisLazuliAdmin());
		
		item_airship_v2_obsidian_normal = registerItem(new ItemAirshipV2ObsidianNormal());
		item_airship_v2_obsidian_black = registerItem(new ItemAirshipV2ObsidianBlack());
		item_airship_v2_obsidian_blue = registerItem(new ItemAirshipV2ObsidianBlue());
		item_airship_v2_obsidian_brown = registerItem(new ItemAirshipV2ObsidianBrown());
		item_airship_v2_obsidian_cyan = registerItem(new ItemAirshipV2ObsidianCyan());
		item_airship_v2_obsidian_gray = registerItem(new ItemAirshipV2ObsidianGray());
		item_airship_v2_obsidian_green = registerItem(new ItemAirshipV2ObsidianGreen());
		item_airship_v2_obsidian_lightblue = registerItem(new ItemAirshipV2ObsidianLightBlue());
		item_airship_v2_obsidian_lightgray = registerItem(new ItemAirshipV2ObsidianLightGray());
		item_airship_v2_obsidian_lime = registerItem(new ItemAirshipV2ObsidianLime());
		item_airship_v2_obsidian_magenta = registerItem(new ItemAirshipV2ObsidianMagenta());
		item_airship_v2_obsidian_orange = registerItem(new ItemAirshipV2ObsidianOrange());
		item_airship_v2_obsidian_pink = registerItem(new ItemAirshipV2ObsidianPink());
		item_airship_v2_obsidian_purple = registerItem(new ItemAirshipV2ObsidianPurple());
		item_airship_v2_obsidian_red = registerItem(new ItemAirshipV2ObsidianRed());
		item_airship_v2_obsidian_white = registerItem(new ItemAirshipV2ObsidianWhite());
		item_airship_v2_obsidian_yellow = registerItem(new ItemAirshipV2ObsidianYellow());
		item_airship_v2_obsidian_admin = registerItem(new ItemAirshipV2ObsidianAdmin());
		
		item_airship_v2_diamond_normal = registerItem(new ItemAirshipV2DiamondNormal());
		item_airship_v2_diamond_black = registerItem(new ItemAirshipV2DiamondBlack());
		item_airship_v2_diamond_blue = registerItem(new ItemAirshipV2DiamondBlue());
		item_airship_v2_diamond_brown = registerItem(new ItemAirshipV2DiamondBrown());
		item_airship_v2_diamond_cyan = registerItem(new ItemAirshipV2DiamondCyan());
		item_airship_v2_diamond_gray = registerItem(new ItemAirshipV2DiamondGray());
		item_airship_v2_diamond_green = registerItem(new ItemAirshipV2DiamondGreen());
		item_airship_v2_diamond_lightblue = registerItem(new ItemAirshipV2DiamondLightBlue());
		item_airship_v2_diamond_lightgray = registerItem(new ItemAirshipV2DiamondLightGray());
		item_airship_v2_diamond_lime = registerItem(new ItemAirshipV2DiamondLime());
		item_airship_v2_diamond_magenta = registerItem(new ItemAirshipV2DiamondMagenta());
		item_airship_v2_diamond_orange = registerItem(new ItemAirshipV2DiamondOrange());
		item_airship_v2_diamond_pink = registerItem(new ItemAirshipV2DiamondPink());
		item_airship_v2_diamond_purple = registerItem(new ItemAirshipV2DiamondPurple());
		item_airship_v2_diamond_red = registerItem(new ItemAirshipV2DiamondRed());
		item_airship_v2_diamond_white = registerItem(new ItemAirshipV2DiamondWhite());
		item_airship_v2_diamond_yellow = registerItem(new ItemAirshipV2DiamondYellow());
		item_airship_v2_diamond_admin = registerItem(new ItemAirshipV2DiamondAdmin());
		
		item_airship_v2_emerald_normal = registerItem(new ItemAirshipV2EmeraldNormal());
		item_airship_v2_emerald_black = registerItem(new ItemAirshipV2EmeraldBlack());
		item_airship_v2_emerald_blue = registerItem(new ItemAirshipV2EmeraldBlue());
		item_airship_v2_emerald_brown = registerItem(new ItemAirshipV2EmeraldBrown());
		item_airship_v2_emerald_cyan = registerItem(new ItemAirshipV2EmeraldCyan());
		item_airship_v2_emerald_gray = registerItem(new ItemAirshipV2EmeraldGray());
		item_airship_v2_emerald_green = registerItem(new ItemAirshipV2EmeraldGreen());
		item_airship_v2_emerald_lightblue = registerItem(new ItemAirshipV2EmeraldLightBlue());
		item_airship_v2_emerald_lightgray = registerItem(new ItemAirshipV2EmeraldLightGray());
		item_airship_v2_emerald_lime = registerItem(new ItemAirshipV2EmeraldLime());
		item_airship_v2_emerald_magenta = registerItem(new ItemAirshipV2EmeraldMagenta());
		item_airship_v2_emerald_orange = registerItem(new ItemAirshipV2EmeraldOrange());
		item_airship_v2_emerald_pink = registerItem(new ItemAirshipV2EmeraldPink());
		item_airship_v2_emerald_purple = registerItem(new ItemAirshipV2EmeraldPurple());
		item_airship_v2_emerald_red = registerItem(new ItemAirshipV2EmeraldRed());
		item_airship_v2_emerald_white = registerItem(new ItemAirshipV2EmeraldWhite());
		item_airship_v2_emerald_yellow = registerItem(new ItemAirshipV2EmeraldYellow());
		item_airship_v2_emerald_admin = registerItem(new ItemAirshipV2EmeraldAdmin());
		
		//==============================================
		
		//V3
		item_airship_v3_wood0_normal = registerItem(new ItemAirshipV3Wood0Normal());
		item_airship_v3_wood0_black = registerItem(new ItemAirshipV3Wood0Black());
		item_airship_v3_wood0_blue = registerItem(new ItemAirshipV3Wood0Blue());
		item_airship_v3_wood0_brown = registerItem(new ItemAirshipV3Wood0Brown());
		item_airship_v3_wood0_cyan = registerItem(new ItemAirshipV3Wood0Cyan());
		item_airship_v3_wood0_gray = registerItem(new ItemAirshipV3Wood0Gray());
		item_airship_v3_wood0_green = registerItem(new ItemAirshipV3Wood0Green());
		item_airship_v3_wood0_lightblue = registerItem(new ItemAirshipV3Wood0LightBlue());
		item_airship_v3_wood0_lightgray = registerItem(new ItemAirshipV3Wood0LightGray());
		item_airship_v3_wood0_lime = registerItem(new ItemAirshipV3Wood0Lime());
		item_airship_v3_wood0_magenta = registerItem(new ItemAirshipV3Wood0Magenta());
		item_airship_v3_wood0_orange = registerItem(new ItemAirshipV3Wood0Orange());
		item_airship_v3_wood0_pink = registerItem(new ItemAirshipV3Wood0Pink());
		item_airship_v3_wood0_purple = registerItem(new ItemAirshipV3Wood0Purple());
		item_airship_v3_wood0_red = registerItem(new ItemAirshipV3Wood0Red());
		item_airship_v3_wood0_white = registerItem(new ItemAirshipV3Wood0White());
		item_airship_v3_wood0_yellow = registerItem(new ItemAirshipV3Wood0Yellow());
		item_airship_v3_wood0_admin = registerItem(new ItemAirshipV3Wood0Admin());
		
		item_airship_v3_iron_normal = registerItem(new ItemAirshipV3IronNormal());
		item_airship_v3_iron_black = registerItem(new ItemAirshipV3IronBlack());
		item_airship_v3_iron_blue = registerItem(new ItemAirshipV3IronBlue());
		item_airship_v3_iron_brown = registerItem(new ItemAirshipV3IronBrown());
		item_airship_v3_iron_cyan = registerItem(new ItemAirshipV3IronCyan());
		item_airship_v3_iron_gray = registerItem(new ItemAirshipV3IronGray());
		item_airship_v3_iron_green = registerItem(new ItemAirshipV3IronGreen());
		item_airship_v3_iron_lightblue = registerItem(new ItemAirshipV3IronLightBlue());
		item_airship_v3_iron_lightgray = registerItem(new ItemAirshipV3IronLightGray());
		item_airship_v3_iron_lime = registerItem(new ItemAirshipV3IronLime());
		item_airship_v3_iron_magenta = registerItem(new ItemAirshipV3IronMagenta());
		item_airship_v3_iron_orange = registerItem(new ItemAirshipV3IronOrange());
		item_airship_v3_iron_pink = registerItem(new ItemAirshipV3IronPink());
		item_airship_v3_iron_purple = registerItem(new ItemAirshipV3IronPurple());
		item_airship_v3_iron_red = registerItem(new ItemAirshipV3IronRed());
		item_airship_v3_iron_white = registerItem(new ItemAirshipV3IronWhite());
		item_airship_v3_iron_yellow = registerItem(new ItemAirshipV3IronYellow());
		item_airship_v3_iron_admin = registerItem(new ItemAirshipV3IronAdmin());
		
		item_airship_v3_redstone_normal = registerItem(new ItemAirshipV3RedstoneNormal());
		item_airship_v3_redstone_black = registerItem(new ItemAirshipV3RedstoneBlack());
		item_airship_v3_redstone_blue = registerItem(new ItemAirshipV3RedstoneBlue());
		item_airship_v3_redstone_brown = registerItem(new ItemAirshipV3RedstoneBrown());
		item_airship_v3_redstone_cyan = registerItem(new ItemAirshipV3RedstoneCyan());
		item_airship_v3_redstone_gray = registerItem(new ItemAirshipV3RedstoneGray());
		item_airship_v3_redstone_green = registerItem(new ItemAirshipV3RedstoneGreen());
		item_airship_v3_redstone_lightblue = registerItem(new ItemAirshipV3RedstoneLightBlue());
		item_airship_v3_redstone_lightgray = registerItem(new ItemAirshipV3RedstoneLightGray());
		item_airship_v3_redstone_lime = registerItem(new ItemAirshipV3RedstoneLime());
		item_airship_v3_redstone_magenta = registerItem(new ItemAirshipV3RedstoneMagenta());
		item_airship_v3_redstone_orange = registerItem(new ItemAirshipV3RedstoneOrange());
		item_airship_v3_redstone_pink = registerItem(new ItemAirshipV3RedstonePink());
		item_airship_v3_redstone_purple = registerItem(new ItemAirshipV3RedstonePurple());
		item_airship_v3_redstone_red = registerItem(new ItemAirshipV3RedstoneRed());
		item_airship_v3_redstone_white = registerItem(new ItemAirshipV3RedstoneWhite());
		item_airship_v3_redstone_yellow = registerItem(new ItemAirshipV3RedstoneYellow());
		item_airship_v3_redstone_admin = registerItem(new ItemAirshipV3RedstoneAdmin());
		
		item_airship_v3_gold_normal = registerItem(new ItemAirshipV3GoldNormal());
		item_airship_v3_gold_black = registerItem(new ItemAirshipV3GoldBlack());
		item_airship_v3_gold_blue = registerItem(new ItemAirshipV3GoldBlue());
		item_airship_v3_gold_brown = registerItem(new ItemAirshipV3GoldBrown());
		item_airship_v3_gold_cyan = registerItem(new ItemAirshipV3GoldCyan());
		item_airship_v3_gold_gray = registerItem(new ItemAirshipV3GoldGray());
		item_airship_v3_gold_green = registerItem(new ItemAirshipV3GoldGreen());
		item_airship_v3_gold_lightblue = registerItem(new ItemAirshipV3GoldLightBlue());
		item_airship_v3_gold_lightgray = registerItem(new ItemAirshipV3GoldLightGray());
		item_airship_v3_gold_lime = registerItem(new ItemAirshipV3GoldLime());
		item_airship_v3_gold_magenta = registerItem(new ItemAirshipV3GoldMagenta());
		item_airship_v3_gold_orange = registerItem(new ItemAirshipV3GoldOrange());
		item_airship_v3_gold_pink = registerItem(new ItemAirshipV3GoldPink());
		item_airship_v3_gold_purple = registerItem(new ItemAirshipV3GoldPurple());
		item_airship_v3_gold_red = registerItem(new ItemAirshipV3GoldRed());
		item_airship_v3_gold_white = registerItem(new ItemAirshipV3GoldWhite());
		item_airship_v3_gold_yellow = registerItem(new ItemAirshipV3GoldYellow());
		item_airship_v3_gold_admin = registerItem(new ItemAirshipV3GoldAdmin());
		
		item_airship_v3_lapislazuli_normal = registerItem(new ItemAirshipV3LapisLazuliNormal());
		item_airship_v3_lapislazuli_black = registerItem(new ItemAirshipV3LapisLazuliBlack());
		item_airship_v3_lapislazuli_blue = registerItem(new ItemAirshipV3LapisLazuliBlue());
		item_airship_v3_lapislazuli_brown = registerItem(new ItemAirshipV3LapisLazuliBrown());
		item_airship_v3_lapislazuli_cyan = registerItem(new ItemAirshipV3LapisLazuliCyan());
		item_airship_v3_lapislazuli_gray = registerItem(new ItemAirshipV3LapisLazuliGray());
		item_airship_v3_lapislazuli_green = registerItem(new ItemAirshipV3LapisLazuliGreen());
		item_airship_v3_lapislazuli_lightblue = registerItem(new ItemAirshipV3LapisLazuliLightBlue());
		item_airship_v3_lapislazuli_lightgray = registerItem(new ItemAirshipV3LapisLazuliLightGray());
		item_airship_v3_lapislazuli_lime = registerItem(new ItemAirshipV3LapisLazuliLime());
		item_airship_v3_lapislazuli_magenta = registerItem(new ItemAirshipV3LapisLazuliMagenta());
		item_airship_v3_lapislazuli_orange = registerItem(new ItemAirshipV3LapisLazuliOrange());
		item_airship_v3_lapislazuli_pink = registerItem(new ItemAirshipV3LapisLazuliPink());
		item_airship_v3_lapislazuli_purple = registerItem(new ItemAirshipV3LapisLazuliPurple());
		item_airship_v3_lapislazuli_red = registerItem(new ItemAirshipV3LapisLazuliRed());
		item_airship_v3_lapislazuli_white = registerItem(new ItemAirshipV3LapisLazuliWhite());
		item_airship_v3_lapislazuli_yellow = registerItem(new ItemAirshipV3LapisLazuliYellow());
		item_airship_v3_lapislazuli_admin = registerItem(new ItemAirshipV3LapisLazuliAdmin());
		
		item_airship_v3_obsidian_normal = registerItem(new ItemAirshipV3ObsidianNormal());
		item_airship_v3_obsidian_black = registerItem(new ItemAirshipV3ObsidianBlack());
		item_airship_v3_obsidian_blue = registerItem(new ItemAirshipV3ObsidianBlue());
		item_airship_v3_obsidian_brown = registerItem(new ItemAirshipV3ObsidianBrown());
		item_airship_v3_obsidian_cyan = registerItem(new ItemAirshipV3ObsidianCyan());
		item_airship_v3_obsidian_gray = registerItem(new ItemAirshipV3ObsidianGray());
		item_airship_v3_obsidian_green = registerItem(new ItemAirshipV3ObsidianGreen());
		item_airship_v3_obsidian_lightblue = registerItem(new ItemAirshipV3ObsidianLightBlue());
		item_airship_v3_obsidian_lightgray = registerItem(new ItemAirshipV3ObsidianLightGray());
		item_airship_v3_obsidian_lime = registerItem(new ItemAirshipV3ObsidianLime());
		item_airship_v3_obsidian_magenta = registerItem(new ItemAirshipV3ObsidianMagenta());
		item_airship_v3_obsidian_orange = registerItem(new ItemAirshipV3ObsidianOrange());
		item_airship_v3_obsidian_pink = registerItem(new ItemAirshipV3ObsidianPink());
		item_airship_v3_obsidian_purple = registerItem(new ItemAirshipV3ObsidianPurple());
		item_airship_v3_obsidian_red = registerItem(new ItemAirshipV3ObsidianRed());
		item_airship_v3_obsidian_white = registerItem(new ItemAirshipV3ObsidianWhite());
		item_airship_v3_obsidian_yellow = registerItem(new ItemAirshipV3ObsidianYellow());
		item_airship_v3_obsidian_admin = registerItem(new ItemAirshipV3ObsidianAdmin());
		
		item_airship_v3_diamond_normal = registerItem(new ItemAirshipV3DiamondNormal());
		item_airship_v3_diamond_black = registerItem(new ItemAirshipV3DiamondBlack());
		item_airship_v3_diamond_blue = registerItem(new ItemAirshipV3DiamondBlue());
		item_airship_v3_diamond_brown = registerItem(new ItemAirshipV3DiamondBrown());
		item_airship_v3_diamond_cyan = registerItem(new ItemAirshipV3DiamondCyan());
		item_airship_v3_diamond_gray = registerItem(new ItemAirshipV3DiamondGray());
		item_airship_v3_diamond_green = registerItem(new ItemAirshipV3DiamondGreen());
		item_airship_v3_diamond_lightblue = registerItem(new ItemAirshipV3DiamondLightBlue());
		item_airship_v3_diamond_lightgray = registerItem(new ItemAirshipV3DiamondLightGray());
		item_airship_v3_diamond_lime = registerItem(new ItemAirshipV3DiamondLime());
		item_airship_v3_diamond_magenta = registerItem(new ItemAirshipV3DiamondMagenta());
		item_airship_v3_diamond_orange = registerItem(new ItemAirshipV3DiamondOrange());
		item_airship_v3_diamond_pink = registerItem(new ItemAirshipV3DiamondPink());
		item_airship_v3_diamond_purple = registerItem(new ItemAirshipV3DiamondPurple());
		item_airship_v3_diamond_red = registerItem(new ItemAirshipV3DiamondRed());
		item_airship_v3_diamond_white = registerItem(new ItemAirshipV3DiamondWhite());
		item_airship_v3_diamond_yellow = registerItem(new ItemAirshipV3DiamondYellow());
		item_airship_v3_diamond_admin = registerItem(new ItemAirshipV3DiamondAdmin());
		
		item_airship_v3_emerald_normal = registerItem(new ItemAirshipV3EmeraldNormal());
		item_airship_v3_emerald_black = registerItem(new ItemAirshipV3EmeraldBlack());
		item_airship_v3_emerald_blue = registerItem(new ItemAirshipV3EmeraldBlue());
		item_airship_v3_emerald_brown = registerItem(new ItemAirshipV3EmeraldBrown());
		item_airship_v3_emerald_cyan = registerItem(new ItemAirshipV3EmeraldCyan());
		item_airship_v3_emerald_gray = registerItem(new ItemAirshipV3EmeraldGray());
		item_airship_v3_emerald_green = registerItem(new ItemAirshipV3EmeraldGreen());
		item_airship_v3_emerald_lightblue = registerItem(new ItemAirshipV3EmeraldLightBlue());
		item_airship_v3_emerald_lightgray = registerItem(new ItemAirshipV3EmeraldLightGray());
		item_airship_v3_emerald_lime = registerItem(new ItemAirshipV3EmeraldLime());
		item_airship_v3_emerald_magenta = registerItem(new ItemAirshipV3EmeraldMagenta());
		item_airship_v3_emerald_orange = registerItem(new ItemAirshipV3EmeraldOrange());
		item_airship_v3_emerald_pink = registerItem(new ItemAirshipV3EmeraldPink());
		item_airship_v3_emerald_purple = registerItem(new ItemAirshipV3EmeraldPurple());
		item_airship_v3_emerald_red = registerItem(new ItemAirshipV3EmeraldRed());
		item_airship_v3_emerald_white = registerItem(new ItemAirshipV3EmeraldWhite());
		item_airship_v3_emerald_yellow = registerItem(new ItemAirshipV3EmeraldYellow());
		item_airship_v3_emerald_admin = registerItem(new ItemAirshipV3EmeraldAdmin());
		
		//==============================================
		
		//V4
		item_airship_v4_wood0_normal = registerItem(new ItemAirshipV4Wood0Normal());
		item_airship_v4_wood0_black = registerItem(new ItemAirshipV4Wood0Black());
		item_airship_v4_wood0_blue = registerItem(new ItemAirshipV4Wood0Blue());
		item_airship_v4_wood0_brown = registerItem(new ItemAirshipV4Wood0Brown());
		item_airship_v4_wood0_cyan = registerItem(new ItemAirshipV4Wood0Cyan());
		item_airship_v4_wood0_gray = registerItem(new ItemAirshipV4Wood0Gray());
		item_airship_v4_wood0_green = registerItem(new ItemAirshipV4Wood0Green());
		item_airship_v4_wood0_lightblue = registerItem(new ItemAirshipV4Wood0LightBlue());
		item_airship_v4_wood0_lightgray = registerItem(new ItemAirshipV4Wood0LightGray());
		item_airship_v4_wood0_lime = registerItem(new ItemAirshipV4Wood0Lime());
		item_airship_v4_wood0_magenta = registerItem(new ItemAirshipV4Wood0Magenta());
		item_airship_v4_wood0_orange = registerItem(new ItemAirshipV4Wood0Orange());
		item_airship_v4_wood0_pink = registerItem(new ItemAirshipV4Wood0Pink());
		item_airship_v4_wood0_purple = registerItem(new ItemAirshipV4Wood0Purple());
		item_airship_v4_wood0_red = registerItem(new ItemAirshipV4Wood0Red());
		item_airship_v4_wood0_white = registerItem(new ItemAirshipV4Wood0White());
		item_airship_v4_wood0_yellow = registerItem(new ItemAirshipV4Wood0Yellow());
		item_airship_v4_wood0_admin = registerItem(new ItemAirshipV4Wood0Admin());
		
		item_airship_v4_iron_normal = registerItem(new ItemAirshipV4IronNormal());
		item_airship_v4_iron_black = registerItem(new ItemAirshipV4IronBlack());
		item_airship_v4_iron_blue = registerItem(new ItemAirshipV4IronBlue());
		item_airship_v4_iron_brown = registerItem(new ItemAirshipV4IronBrown());
		item_airship_v4_iron_cyan = registerItem(new ItemAirshipV4IronCyan());
		item_airship_v4_iron_gray = registerItem(new ItemAirshipV4IronGray());
		item_airship_v4_iron_green = registerItem(new ItemAirshipV4IronGreen());
		item_airship_v4_iron_lightblue = registerItem(new ItemAirshipV4IronLightBlue());
		item_airship_v4_iron_lightgray = registerItem(new ItemAirshipV4IronLightGray());
		item_airship_v4_iron_lime = registerItem(new ItemAirshipV4IronLime());
		item_airship_v4_iron_magenta = registerItem(new ItemAirshipV4IronMagenta());
		item_airship_v4_iron_orange = registerItem(new ItemAirshipV4IronOrange());
		item_airship_v4_iron_pink = registerItem(new ItemAirshipV4IronPink());
		item_airship_v4_iron_purple = registerItem(new ItemAirshipV4IronPurple());
		item_airship_v4_iron_red = registerItem(new ItemAirshipV4IronRed());
		item_airship_v4_iron_white = registerItem(new ItemAirshipV4IronWhite());
		item_airship_v4_iron_yellow = registerItem(new ItemAirshipV4IronYellow());
		item_airship_v4_iron_admin = registerItem(new ItemAirshipV4IronAdmin());
		
		item_airship_v4_redstone_normal = registerItem(new ItemAirshipV4RedstoneNormal());
		item_airship_v4_redstone_black = registerItem(new ItemAirshipV4RedstoneBlack());
		item_airship_v4_redstone_blue = registerItem(new ItemAirshipV4RedstoneBlue());
		item_airship_v4_redstone_brown = registerItem(new ItemAirshipV4RedstoneBrown());
		item_airship_v4_redstone_cyan = registerItem(new ItemAirshipV4RedstoneCyan());
		item_airship_v4_redstone_gray = registerItem(new ItemAirshipV4RedstoneGray());
		item_airship_v4_redstone_green = registerItem(new ItemAirshipV4RedstoneGreen());
		item_airship_v4_redstone_lightblue = registerItem(new ItemAirshipV4RedstoneLightBlue());
		item_airship_v4_redstone_lightgray = registerItem(new ItemAirshipV4RedstoneLightGray());
		item_airship_v4_redstone_lime = registerItem(new ItemAirshipV4RedstoneLime());
		item_airship_v4_redstone_magenta = registerItem(new ItemAirshipV4RedstoneMagenta());
		item_airship_v4_redstone_orange = registerItem(new ItemAirshipV4RedstoneOrange());
		item_airship_v4_redstone_pink = registerItem(new ItemAirshipV4RedstonePink());
		item_airship_v4_redstone_purple = registerItem(new ItemAirshipV4RedstonePurple());
		item_airship_v4_redstone_red = registerItem(new ItemAirshipV4RedstoneRed());
		item_airship_v4_redstone_white = registerItem(new ItemAirshipV4RedstoneWhite());
		item_airship_v4_redstone_yellow = registerItem(new ItemAirshipV4RedstoneYellow());
		item_airship_v4_redstone_admin = registerItem(new ItemAirshipV4RedstoneAdmin());
		
		item_airship_v4_gold_normal = registerItem(new ItemAirshipV4GoldNormal());
		item_airship_v4_gold_black = registerItem(new ItemAirshipV4GoldBlack());
		item_airship_v4_gold_blue = registerItem(new ItemAirshipV4GoldBlue());
		item_airship_v4_gold_brown = registerItem(new ItemAirshipV4GoldBrown());
		item_airship_v4_gold_cyan = registerItem(new ItemAirshipV4GoldCyan());
		item_airship_v4_gold_gray = registerItem(new ItemAirshipV4GoldGray());
		item_airship_v4_gold_green = registerItem(new ItemAirshipV4GoldGreen());
		item_airship_v4_gold_lightblue = registerItem(new ItemAirshipV4GoldLightBlue());
		item_airship_v4_gold_lightgray = registerItem(new ItemAirshipV4GoldLightGray());
		item_airship_v4_gold_lime = registerItem(new ItemAirshipV4GoldLime());
		item_airship_v4_gold_magenta = registerItem(new ItemAirshipV4GoldMagenta());
		item_airship_v4_gold_orange = registerItem(new ItemAirshipV4GoldOrange());
		item_airship_v4_gold_pink = registerItem(new ItemAirshipV4GoldPink());
		item_airship_v4_gold_purple = registerItem(new ItemAirshipV4GoldPurple());
		item_airship_v4_gold_red = registerItem(new ItemAirshipV4GoldRed());
		item_airship_v4_gold_white = registerItem(new ItemAirshipV4GoldWhite());
		item_airship_v4_gold_yellow = registerItem(new ItemAirshipV4GoldYellow());
		item_airship_v4_gold_admin = registerItem(new ItemAirshipV4GoldAdmin());
		
		item_airship_v4_lapislazuli_normal = registerItem(new ItemAirshipV4LapisLazuliNormal());
		item_airship_v4_lapislazuli_black = registerItem(new ItemAirshipV4LapisLazuliBlack());
		item_airship_v4_lapislazuli_blue = registerItem(new ItemAirshipV4LapisLazuliBlue());
		item_airship_v4_lapislazuli_brown = registerItem(new ItemAirshipV4LapisLazuliBrown());
		item_airship_v4_lapislazuli_cyan = registerItem(new ItemAirshipV4LapisLazuliCyan());
		item_airship_v4_lapislazuli_gray = registerItem(new ItemAirshipV4LapisLazuliGray());
		item_airship_v4_lapislazuli_green = registerItem(new ItemAirshipV4LapisLazuliGreen());
		item_airship_v4_lapislazuli_lightblue = registerItem(new ItemAirshipV4LapisLazuliLightBlue());
		item_airship_v4_lapislazuli_lightgray = registerItem(new ItemAirshipV4LapisLazuliLightGray());
		item_airship_v4_lapislazuli_lime = registerItem(new ItemAirshipV4LapisLazuliLime());
		item_airship_v4_lapislazuli_magenta = registerItem(new ItemAirshipV4LapisLazuliMagenta());
		item_airship_v4_lapislazuli_orange = registerItem(new ItemAirshipV4LapisLazuliOrange());
		item_airship_v4_lapislazuli_pink = registerItem(new ItemAirshipV4LapisLazuliPink());
		item_airship_v4_lapislazuli_purple = registerItem(new ItemAirshipV4LapisLazuliPurple());
		item_airship_v4_lapislazuli_red = registerItem(new ItemAirshipV4LapisLazuliRed());
		item_airship_v4_lapislazuli_white = registerItem(new ItemAirshipV4LapisLazuliWhite());
		item_airship_v4_lapislazuli_yellow = registerItem(new ItemAirshipV4LapisLazuliYellow());
		item_airship_v4_lapislazuli_admin = registerItem(new ItemAirshipV4LapisLazuliAdmin());
		
		item_airship_v4_obsidian_normal = registerItem(new ItemAirshipV4ObsidianNormal());
		item_airship_v4_obsidian_black = registerItem(new ItemAirshipV4ObsidianBlack());
		item_airship_v4_obsidian_blue = registerItem(new ItemAirshipV4ObsidianBlue());
		item_airship_v4_obsidian_brown = registerItem(new ItemAirshipV4ObsidianBrown());
		item_airship_v4_obsidian_cyan = registerItem(new ItemAirshipV4ObsidianCyan());
		item_airship_v4_obsidian_gray = registerItem(new ItemAirshipV4ObsidianGray());
		item_airship_v4_obsidian_green = registerItem(new ItemAirshipV4ObsidianGreen());
		item_airship_v4_obsidian_lightblue = registerItem(new ItemAirshipV4ObsidianLightBlue());
		item_airship_v4_obsidian_lightgray = registerItem(new ItemAirshipV4ObsidianLightGray());
		item_airship_v4_obsidian_lime = registerItem(new ItemAirshipV4ObsidianLime());
		item_airship_v4_obsidian_magenta = registerItem(new ItemAirshipV4ObsidianMagenta());
		item_airship_v4_obsidian_orange = registerItem(new ItemAirshipV4ObsidianOrange());
		item_airship_v4_obsidian_pink = registerItem(new ItemAirshipV4ObsidianPink());
		item_airship_v4_obsidian_purple = registerItem(new ItemAirshipV4ObsidianPurple());
		item_airship_v4_obsidian_red = registerItem(new ItemAirshipV4ObsidianRed());
		item_airship_v4_obsidian_white = registerItem(new ItemAirshipV4ObsidianWhite());
		item_airship_v4_obsidian_yellow = registerItem(new ItemAirshipV4ObsidianYellow());
		item_airship_v4_obsidian_admin = registerItem(new ItemAirshipV4ObsidianAdmin());
		
		item_airship_v4_diamond_normal = registerItem(new ItemAirshipV4DiamondNormal());
		item_airship_v4_diamond_black = registerItem(new ItemAirshipV4DiamondBlack());
		item_airship_v4_diamond_blue = registerItem(new ItemAirshipV4DiamondBlue());
		item_airship_v4_diamond_brown = registerItem(new ItemAirshipV4DiamondBrown());
		item_airship_v4_diamond_cyan = registerItem(new ItemAirshipV4DiamondCyan());
		item_airship_v4_diamond_gray = registerItem(new ItemAirshipV4DiamondGray());
		item_airship_v4_diamond_green = registerItem(new ItemAirshipV4DiamondGreen());
		item_airship_v4_diamond_lightblue = registerItem(new ItemAirshipV4DiamondLightBlue());
		item_airship_v4_diamond_lightgray = registerItem(new ItemAirshipV4DiamondLightGray());
		item_airship_v4_diamond_lime = registerItem(new ItemAirshipV4DiamondLime());
		item_airship_v4_diamond_magenta = registerItem(new ItemAirshipV4DiamondMagenta());
		item_airship_v4_diamond_orange = registerItem(new ItemAirshipV4DiamondOrange());
		item_airship_v4_diamond_pink = registerItem(new ItemAirshipV4DiamondPink());
		item_airship_v4_diamond_purple = registerItem(new ItemAirshipV4DiamondPurple());
		item_airship_v4_diamond_red = registerItem(new ItemAirshipV4DiamondRed());
		item_airship_v4_diamond_white = registerItem(new ItemAirshipV4DiamondWhite());
		item_airship_v4_diamond_yellow = registerItem(new ItemAirshipV4DiamondYellow());
		item_airship_v4_diamond_admin = registerItem(new ItemAirshipV4DiamondAdmin());
		
		item_airship_v4_emerald_normal = registerItem(new ItemAirshipV4EmeraldNormal());
		item_airship_v4_emerald_black = registerItem(new ItemAirshipV4EmeraldBlack());
		item_airship_v4_emerald_blue = registerItem(new ItemAirshipV4EmeraldBlue());
		item_airship_v4_emerald_brown = registerItem(new ItemAirshipV4EmeraldBrown());
		item_airship_v4_emerald_cyan = registerItem(new ItemAirshipV4EmeraldCyan());
		item_airship_v4_emerald_gray = registerItem(new ItemAirshipV4EmeraldGray());
		item_airship_v4_emerald_green = registerItem(new ItemAirshipV4EmeraldGreen());
		item_airship_v4_emerald_lightblue = registerItem(new ItemAirshipV4EmeraldLightBlue());
		item_airship_v4_emerald_lightgray = registerItem(new ItemAirshipV4EmeraldLightGray());
		item_airship_v4_emerald_lime = registerItem(new ItemAirshipV4EmeraldLime());
		item_airship_v4_emerald_magenta = registerItem(new ItemAirshipV4EmeraldMagenta());
		item_airship_v4_emerald_orange = registerItem(new ItemAirshipV4EmeraldOrange());
		item_airship_v4_emerald_pink = registerItem(new ItemAirshipV4EmeraldPink());
		item_airship_v4_emerald_purple = registerItem(new ItemAirshipV4EmeraldPurple());
		item_airship_v4_emerald_red = registerItem(new ItemAirshipV4EmeraldRed());
		item_airship_v4_emerald_white = registerItem(new ItemAirshipV4EmeraldWhite());
		item_airship_v4_emerald_yellow = registerItem(new ItemAirshipV4EmeraldYellow());
		item_airship_v4_emerald_admin = registerItem(new ItemAirshipV4EmeraldAdmin());
		*/
		//==============================================
		
		//item_airship_v1 = registerItem(new ItemV1Normal("item_airship_v1_", EntityAirshipBaseVC.Type.RED.ordinal()));
		
		
		
		item_airship_v1_black = registerItem(new ItemAirshipV1Black());
		item_airship_v1_blue = registerItem(new ItemAirshipV1Blue());
		item_airship_v1_brown = registerItem(new ItemAirshipV1Brown());
		item_airship_v1_cyan = registerItem(new ItemAirshipV1Cyan());
		item_airship_v1_gray = registerItem(new ItemAirshipV1Gray());
		item_airship_v1_green = registerItem(new ItemAirshipV1Green());
		item_airship_v1_lightblue = registerItem(new ItemAirshipV1LightBlue());
		item_airship_v1_lightgray = registerItem(new ItemAirshipV1LightGray());
		item_airship_v1_lime = registerItem(new ItemAirshipV1Lime());
		item_airship_v1_magenta = registerItem(new ItemAirshipV1Magenta());
		item_airship_v1_orange = registerItem(new ItemAirshipV1Orange());
		item_airship_v1_pink = registerItem(new ItemAirshipV1Pink());
		item_airship_v1_purple = registerItem(new ItemAirshipV1Purple());
		item_airship_v1_red = registerItem(new ItemAirshipV1Red());
		item_airship_v1_white = registerItem(new ItemAirshipV1White());
		item_airship_v1_yellow = registerItem(new ItemAirshipV1Yellow());
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
		
		achievement_airship_portal = registerItem(new ItemAchievementPortal());
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
