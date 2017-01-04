package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
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
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Diamond;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Emerald;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Gold;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Iron;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1LapisLazuli;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Obsidian;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Redstone;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1Wood0;
import com.viesis.viescraft.common.items.airshipitems.v1.old.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Diamond;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Emerald;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Gold;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Iron;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2LapisLazuli;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Obsidian;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Redstone;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2Wood0;
import com.viesis.viescraft.common.items.airshipitems.v2.old.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Diamond;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Emerald;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Gold;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Iron;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3LapisLazuli;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Obsidian;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Redstone;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3Wood0;
import com.viesis.viescraft.common.items.airshipitems.v3.old.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Diamond;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Emerald;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Gold;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Iron;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4LapisLazuli;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Obsidian;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Redstone;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4Wood0;
import com.viesis.viescraft.common.items.airshipitems.v4.old.ItemAirshipV4;
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
import com.viesis.viescraft.common.items.parts.ItemFrameObsidian;
import com.viesis.viescraft.common.items.parts.ItemFrameRedstone;
import com.viesis.viescraft.common.items.parts.ItemFrameWood0;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemPaint;
import com.viesis.viescraft.common.items.parts.ItemPaintRemover;
import com.viesis.viescraft.common.items.parts.ItemViesoline;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		guidebook_main = registerItem(new ItemGuidebookMain());
		guidebook_controls = registerItem(new ItemGuidebookControls());
		guidebook_paint = registerItem(new ItemGuidebookPaint());
		guidebook_socket = registerItem(new ItemGuidebookSocket());
		
		viesoline_pellets = registerItem(new ItemViesoline());
		
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		airship_dismounter = registerItem(new ItemAirshipDismounter());
		
		item_paint_remover = registerItem(new ItemPaintRemover());
		item_paint_black = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.BLACK));
		item_paint_blue = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.BLUE));
		item_paint_brown = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.BROWN));
		item_paint_cyan = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.CYAN));
		item_paint_gray = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.GRAY));
		item_paint_green = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.GREEN));
		item_paint_lightblue = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.LIGHTBLUE));
		item_paint_lightgray = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.LIGHTGRAY));
		item_paint_lime = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.LIME));
		item_paint_magenta = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.MAGENTA));
		item_paint_orange = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.ORANGE));
		item_paint_pink = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.PINK));
		item_paint_purple = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.PURPLE));
		item_paint_red = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.RED));
		item_paint_white = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.WHITE));
		item_paint_yellow = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.YELLOW));
		item_paint_rainbow = registerItem(new ItemPaint(EntityAirshipBaseVC.Color.RAINBOW));
		
		airship_frame_wood0 = registerItem(new ItemFrameWood0());
		airship_frame_iron = registerItem(new ItemFrameIron());
		airship_frame_redstone = registerItem(new ItemFrameRedstone());
		airship_frame_gold = registerItem(new ItemFrameGold());
		airship_frame_lapislazuli = registerItem(new ItemFrameLapisLazuli());
		airship_frame_obsidian = registerItem(new ItemFrameObsidian());
		airship_frame_diamond = registerItem(new ItemFrameDiamond());
		airship_frame_emerald = registerItem(new ItemFrameEmerald());
		
		module_chip = registerItem(new ItemModuleChip());
		
		module_inventory_small = registerItem(new ItemInventoryModuleSmall());
		module_inventory_large = registerItem(new ItemInventoryModuleLarge());
		module_speed_increase_minor = registerItem(new ItemSpeedModuleMinor());
		module_speed_increase_major = registerItem(new ItemSpeedModuleMajor());
		module_fuel_infinite = registerItem(new ItemFuelModuleInfinite());
		
		//module_stealth = registerItem(new ItemModuleStealth());
		//module_dash = registerItem(new ItemModuleDash());
		
		//==============================================
		
		item_airship_v1_wood0 = registerItem(new ItemAirshipV1Wood0("v1/wood0/item_airship_v1"));
		item_airship_v1_iron = registerItem(new ItemAirshipV1Iron("v1/iron/item_airship_v1"));
		item_airship_v1_redstone = registerItem(new ItemAirshipV1Redstone("v1/redstone/item_airship_v1"));
		item_airship_v1_gold = registerItem(new ItemAirshipV1Gold("v1/gold/item_airship_v1"));
		item_airship_v1_lapislazuli = registerItem(new ItemAirshipV1LapisLazuli("v1/lapislazuli/item_airship_v1"));
		item_airship_v1_obsidian = registerItem(new ItemAirshipV1Obsidian("v1/obsidian/item_airship_v1"));
		item_airship_v1_diamond = registerItem(new ItemAirshipV1Diamond("v1/diamond/item_airship_v1"));
		item_airship_v1_emerald = registerItem(new ItemAirshipV1Emerald("v1/emerald/item_airship_v1"));
		
		item_airship_v2_wood0 = registerItem(new ItemAirshipV2Wood0("v2/wood0/item_airship_v2"));
		item_airship_v2_iron = registerItem(new ItemAirshipV2Iron("v2/iron/item_airship_v2"));
		item_airship_v2_redstone = registerItem(new ItemAirshipV2Redstone("v2/redstone/item_airship_v2"));
		item_airship_v2_gold = registerItem(new ItemAirshipV2Gold("v2/gold/item_airship_v2"));
		item_airship_v2_lapislazuli = registerItem(new ItemAirshipV2LapisLazuli("v2/lapislazuli/item_airship_v2"));
		item_airship_v2_obsidian = registerItem(new ItemAirshipV2Obsidian("v2/obsidian/item_airship_v2"));
		item_airship_v2_diamond = registerItem(new ItemAirshipV2Diamond("v2/diamond/item_airship_v2"));
		item_airship_v2_emerald = registerItem(new ItemAirshipV2Emerald("v2/emerald/item_airship_v2"));
		
		item_airship_v3_wood0 = registerItem(new ItemAirshipV3Wood0("v3/wood0/item_airship_v3"));
		item_airship_v3_iron = registerItem(new ItemAirshipV3Iron("v3/iron/item_airship_v3"));
		item_airship_v3_redstone = registerItem(new ItemAirshipV3Redstone("v3/redstone/item_airship_v3"));
		item_airship_v3_gold = registerItem(new ItemAirshipV3Gold("v3/gold/item_airship_v3"));
		item_airship_v3_lapislazuli = registerItem(new ItemAirshipV3LapisLazuli("v3/lapislazuli/item_airship_v3"));
		item_airship_v3_obsidian = registerItem(new ItemAirshipV3Obsidian("v3/obsidian/item_airship_v3"));
		item_airship_v3_diamond = registerItem(new ItemAirshipV3Diamond("v3/diamond/item_airship_v3"));
		item_airship_v3_emerald = registerItem(new ItemAirshipV3Emerald("v3/emerald/item_airship_v3"));
		
		item_airship_v4_wood0 = registerItem(new ItemAirshipV4Wood0("v4/wood0/item_airship_v4"));
		item_airship_v4_iron = registerItem(new ItemAirshipV4Iron("v4/iron/item_airship_v4"));
		item_airship_v4_redstone = registerItem(new ItemAirshipV4Redstone("v4/redstone/item_airship_v4"));
		item_airship_v4_gold = registerItem(new ItemAirshipV4Gold("v4/gold/item_airship_v4"));
		item_airship_v4_lapislazuli = registerItem(new ItemAirshipV4LapisLazuli("v4/lapislazuli/item_airship_v4"));
		item_airship_v4_obsidian = registerItem(new ItemAirshipV4Obsidian("v4/obsidian/item_airship_v4"));
		item_airship_v4_diamond = registerItem(new ItemAirshipV4Diamond("v4/diamond/item_airship_v4"));
		item_airship_v4_emerald = registerItem(new ItemAirshipV4Emerald("v4/emerald/item_airship_v4"));
		
		
		//========================
		//    To be deleted
		//========================
		
		//V1
		item_airship_v1_wood0_normal = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_normal", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_wood0_black = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_black", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_wood0_blue = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_blue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_wood0_brown = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_brown", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_wood0_cyan = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_wood0_gray = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_gray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_wood0_green = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_green", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_wood0_lightblue = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_wood0_lightgray = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_wood0_lime = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_lime", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_wood0_magenta = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_wood0_orange = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_orange", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_wood0_pink = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_pink", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_wood0_purple = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_purple", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_wood0_red = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_red", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_wood0_white = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_white", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_wood0_yellow = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_wood0_rainbow = registerItem(new ItemAirshipV1("v1/wood0/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_iron_normal = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_normal", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_iron_black = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_black", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_iron_blue = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_blue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_iron_brown = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_brown", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_iron_cyan = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_iron_gray = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_gray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_iron_green = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_green", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_iron_lightblue = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_iron_lightgray = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_iron_lime = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_lime", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_iron_magenta = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_iron_orange = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_orange", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_iron_pink = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_pink", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_iron_purple = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_purple", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_iron_red = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_red", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_iron_white = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_white", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_iron_yellow = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_iron_rainbow = registerItem(new ItemAirshipV1("v1/iron/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_redstone_normal = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_normal", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_redstone_black = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_black", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_redstone_blue = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_blue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_redstone_brown = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_brown", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_redstone_cyan = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_redstone_gray = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_gray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_redstone_green = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_green", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_redstone_lightblue = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_redstone_lightgray = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_redstone_lime = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_lime", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_redstone_magenta = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_redstone_orange = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_orange", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_redstone_pink = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_pink", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_redstone_purple = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_purple", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_redstone_red = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_red", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_redstone_white = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_white", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_redstone_yellow = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_redstone_rainbow = registerItem(new ItemAirshipV1("v1/redstone/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_gold_normal = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_normal", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_gold_black = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_black", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_gold_blue = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_blue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_gold_brown = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_brown", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_gold_cyan = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_gold_gray = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_gray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_gold_green = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_green", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_gold_lightblue = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_gold_lightgray = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_gold_lime = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_lime", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_gold_magenta = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_gold_orange = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_orange", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_gold_pink = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_pink", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_gold_purple = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_purple", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_gold_red = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_red", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_gold_white = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_white", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_gold_yellow = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_gold_rainbow = registerItem(new ItemAirshipV1("v1/gold/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_lapislazuli_normal = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_normal", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_lapislazuli_black = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_black", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_lapislazuli_blue = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_blue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_lapislazuli_brown = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_brown", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_lapislazuli_cyan = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_lapislazuli_gray = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_gray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_lapislazuli_green = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_green", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_lapislazuli_lightblue = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_lapislazuli_lightgray = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_lapislazuli_lime = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_lime", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_lapislazuli_magenta = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_lapislazuli_orange = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_orange", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_lapislazuli_pink = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_pink", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_lapislazuli_purple = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_purple", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_lapislazuli_red = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_red", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_lapislazuli_white = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_white", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_lapislazuli_yellow = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_lapislazuli_rainbow = registerItem(new ItemAirshipV1("v1/lapislazuli/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_obsidian_normal = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_normal", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_obsidian_black = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_black", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_obsidian_blue = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_blue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_obsidian_brown = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_brown", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_obsidian_cyan = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_obsidian_gray = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_gray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_obsidian_green = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_green", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_obsidian_lightblue = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_obsidian_lightgray = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_obsidian_lime = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_lime", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_obsidian_magenta = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_obsidian_orange = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_orange", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_obsidian_pink = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_pink", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_obsidian_purple = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_purple", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_obsidian_red = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_red", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_obsidian_white = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_white", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_obsidian_yellow = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_obsidian_rainbow = registerItem(new ItemAirshipV1("v1/obsidian/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_diamond_normal = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_normal", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_diamond_black = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_black", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_diamond_blue = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_blue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_diamond_brown = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_brown", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_diamond_cyan = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_diamond_gray = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_gray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_diamond_green = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_green", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_diamond_lightblue = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_diamond_lightgray = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_diamond_lime = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_lime", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_diamond_magenta = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_diamond_orange = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_orange", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_diamond_pink = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_pink", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_diamond_purple = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_purple", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_diamond_red = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_red", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_diamond_white = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_white", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_diamond_yellow = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_diamond_rainbow = registerItem(new ItemAirshipV1("v1/diamond/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v1_emerald_normal = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_normal", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v1_emerald_black = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_black", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v1_emerald_blue = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_blue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v1_emerald_brown = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_brown", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v1_emerald_cyan = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_cyan", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v1_emerald_gray = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_gray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v1_emerald_green = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_green", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v1_emerald_lightblue = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_lightblue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v1_emerald_lightgray = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_lightgray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v1_emerald_lime = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_lime", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v1_emerald_magenta = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_magenta", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v1_emerald_orange = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_orange", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v1_emerald_pink = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_pink", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v1_emerald_purple = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_purple", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v1_emerald_red = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_red", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v1_emerald_white = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_white", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v1_emerald_yellow = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_yellow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v1_emerald_rainbow = registerItem(new ItemAirshipV1("v1/emerald/item_airship_v1_rainbow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		//==============================================
		
		//V2
		item_airship_v2_wood0_normal = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_normal", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_wood0_black = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_black", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_wood0_blue = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_blue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_wood0_brown = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_brown", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_wood0_cyan = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_wood0_gray = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_gray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_wood0_green = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_green", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_wood0_lightblue = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_wood0_lightgray = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_wood0_lime = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_lime", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_wood0_magenta = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_wood0_orange = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_orange", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_wood0_pink = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_pink", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_wood0_purple = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_purple", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_wood0_red = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_red", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_wood0_white = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_white", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_wood0_yellow = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_wood0_rainbow = registerItem(new ItemAirshipV2("v2/wood0/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_iron_normal = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_normal", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_iron_black = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_black", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_iron_blue = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_blue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_iron_brown = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_brown", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_iron_cyan = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_iron_gray = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_gray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_iron_green = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_green", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_iron_lightblue = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_iron_lightgray = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_iron_lime = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_lime", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_iron_magenta = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_iron_orange = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_orange", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_iron_pink = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_pink", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_iron_purple = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_purple", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_iron_red = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_red", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_iron_white = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_white", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_iron_yellow = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_iron_rainbow = registerItem(new ItemAirshipV2("v2/iron/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_redstone_normal = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_normal", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_redstone_black = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_black", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_redstone_blue = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_blue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_redstone_brown = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_brown", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_redstone_cyan = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_redstone_gray = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_gray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_redstone_green = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_green", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_redstone_lightblue = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_redstone_lightgray = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_redstone_lime = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_lime", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_redstone_magenta = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_redstone_orange = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_orange", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_redstone_pink = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_pink", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_redstone_purple = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_purple", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_redstone_red = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_red", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_redstone_white = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_white", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_redstone_yellow = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_redstone_rainbow = registerItem(new ItemAirshipV2("v2/redstone/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_gold_normal = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_normal", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_gold_black = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_black", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_gold_blue = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_blue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_gold_brown = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_brown", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_gold_cyan = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_gold_gray = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_gray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_gold_green = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_green", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_gold_lightblue = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_gold_lightgray = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_gold_lime = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_lime", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_gold_magenta = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_gold_orange = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_orange", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_gold_pink = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_pink", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_gold_purple = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_purple", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_gold_red = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_red", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_gold_white = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_white", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_gold_yellow = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_gold_rainbow = registerItem(new ItemAirshipV2("v2/gold/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_lapislazuli_normal = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_normal", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_lapislazuli_black = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_black", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_lapislazuli_blue = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_blue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_lapislazuli_brown = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_brown", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_lapislazuli_cyan = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_lapislazuli_gray = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_gray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_lapislazuli_green = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_green", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_lapislazuli_lightblue = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_lapislazuli_lightgray = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_lapislazuli_lime = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_lime", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_lapislazuli_magenta = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_lapislazuli_orange = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_orange", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_lapislazuli_pink = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_pink", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_lapislazuli_purple = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_purple", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_lapislazuli_red = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_red", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_lapislazuli_white = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_white", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_lapislazuli_yellow = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_lapislazuli_rainbow = registerItem(new ItemAirshipV2("v2/lapislazuli/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_obsidian_normal = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_normal", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_obsidian_black = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_black", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_obsidian_blue = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_blue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_obsidian_brown = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_brown", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_obsidian_cyan = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_obsidian_gray = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_gray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_obsidian_green = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_green", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_obsidian_lightblue = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_obsidian_lightgray = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_obsidian_lime = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_lime", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_obsidian_magenta = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_obsidian_orange = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_orange", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_obsidian_pink = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_pink", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_obsidian_purple = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_purple", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_obsidian_red = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_red", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_obsidian_white = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_white", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_obsidian_yellow = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_obsidian_rainbow = registerItem(new ItemAirshipV2("v2/obsidian/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_diamond_normal = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_normal", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_diamond_black = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_black", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_diamond_blue = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_blue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_diamond_brown = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_brown", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_diamond_cyan = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_diamond_gray = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_gray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_diamond_green = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_green", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_diamond_lightblue = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_diamond_lightgray = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_diamond_lime = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_lime", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_diamond_magenta = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_diamond_orange = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_orange", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_diamond_pink = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_pink", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_diamond_purple = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_purple", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_diamond_red = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_red", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_diamond_white = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_white", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_diamond_yellow = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_diamond_rainbow = registerItem(new ItemAirshipV2("v2/diamond/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v2_emerald_normal = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_normal", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v2_emerald_black = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_black", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v2_emerald_blue = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_blue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v2_emerald_brown = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_brown", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v2_emerald_cyan = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_cyan", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v2_emerald_gray = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_gray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v2_emerald_green = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_green", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v2_emerald_lightblue = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_lightblue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v2_emerald_lightgray = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_lightgray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v2_emerald_lime = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_lime", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v2_emerald_magenta = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_magenta", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v2_emerald_orange = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_orange", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v2_emerald_pink = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_pink", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v2_emerald_purple = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_purple", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v2_emerald_red = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_red", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v2_emerald_white = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_white", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v2_emerald_yellow = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_yellow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v2_emerald_rainbow = registerItem(new ItemAirshipV2("v2/emerald/item_airship_v2_rainbow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		//==============================================
		
		//V3
		item_airship_v3_wood0_normal = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_normal", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_wood0_black = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_black", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_wood0_blue = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_blue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_wood0_brown = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_brown", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_wood0_cyan = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_wood0_gray = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_gray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_wood0_green = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_green", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_wood0_lightblue = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_wood0_lightgray = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_wood0_lime = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_lime", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_wood0_magenta = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_wood0_orange = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_orange", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_wood0_pink = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_pink", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_wood0_purple = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_purple", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_wood0_red = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_red", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_wood0_white = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_white", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_wood0_yellow = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_wood0_rainbow = registerItem(new ItemAirshipV3("v3/wood0/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_iron_normal = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_normal", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_iron_black = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_black", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_iron_blue = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_blue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_iron_brown = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_brown", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_iron_cyan = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_iron_gray = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_gray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_iron_green = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_green", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_iron_lightblue = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_iron_lightgray = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_iron_lime = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_lime", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_iron_magenta = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_iron_orange = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_orange", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_iron_pink = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_pink", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_iron_purple = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_purple", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_iron_red = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_red", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_iron_white = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_white", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_iron_yellow = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_iron_rainbow = registerItem(new ItemAirshipV3("v3/iron/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_redstone_normal = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_normal", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_redstone_black = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_black", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_redstone_blue = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_blue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_redstone_brown = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_brown", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_redstone_cyan = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_redstone_gray = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_gray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_redstone_green = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_green", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_redstone_lightblue = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_redstone_lightgray = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_redstone_lime = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_lime", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_redstone_magenta = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_redstone_orange = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_orange", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_redstone_pink = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_pink", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_redstone_purple = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_purple", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_redstone_red = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_red", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_redstone_white = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_white", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_redstone_yellow = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_redstone_rainbow = registerItem(new ItemAirshipV3("v3/redstone/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_gold_normal = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_normal", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_gold_black = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_black", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_gold_blue = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_blue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_gold_brown = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_brown", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_gold_cyan = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_gold_gray = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_gray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_gold_green = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_green", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_gold_lightblue = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_gold_lightgray = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_gold_lime = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_lime", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_gold_magenta = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_gold_orange = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_orange", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_gold_pink = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_pink", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_gold_purple = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_purple", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_gold_red = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_red", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_gold_white = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_white", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_gold_yellow = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_gold_rainbow = registerItem(new ItemAirshipV3("v3/gold/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_lapislazuli_normal = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_normal", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_lapislazuli_black = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_black", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_lapislazuli_blue = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_blue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_lapislazuli_brown = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_brown", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_lapislazuli_cyan = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_lapislazuli_gray = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_gray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_lapislazuli_green = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_green", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_lapislazuli_lightblue = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_lapislazuli_lightgray = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_lapislazuli_lime = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_lime", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_lapislazuli_magenta = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_lapislazuli_orange = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_orange", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_lapislazuli_pink = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_pink", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_lapislazuli_purple = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_purple", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_lapislazuli_red = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_red", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_lapislazuli_white = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_white", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_lapislazuli_yellow = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_lapislazuli_rainbow = registerItem(new ItemAirshipV3("v3/lapislazuli/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_obsidian_normal = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_normal", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_obsidian_black = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_black", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_obsidian_blue = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_blue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_obsidian_brown = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_brown", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_obsidian_cyan = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_obsidian_gray = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_gray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_obsidian_green = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_green", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_obsidian_lightblue = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_obsidian_lightgray = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_obsidian_lime = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_lime", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_obsidian_magenta = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_obsidian_orange = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_orange", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_obsidian_pink = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_pink", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_obsidian_purple = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_purple", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_obsidian_red = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_red", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_obsidian_white = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_white", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_obsidian_yellow = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_obsidian_rainbow = registerItem(new ItemAirshipV3("v3/obsidian/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_diamond_normal = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_normal", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_diamond_black = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_black", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_diamond_blue = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_blue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_diamond_brown = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_brown", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_diamond_cyan = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_diamond_gray = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_gray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_diamond_green = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_green", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_diamond_lightblue = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_diamond_lightgray = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_diamond_lime = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_lime", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_diamond_magenta = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_diamond_orange = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_orange", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_diamond_pink = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_pink", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_diamond_purple = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_purple", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_diamond_red = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_red", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_diamond_white = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_white", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_diamond_yellow = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_diamond_rainbow = registerItem(new ItemAirshipV3("v3/diamond/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v3_emerald_normal = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_normal", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v3_emerald_black = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_black", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v3_emerald_blue = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_blue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v3_emerald_brown = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_brown", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v3_emerald_cyan = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_cyan", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v3_emerald_gray = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_gray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v3_emerald_green = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_green", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v3_emerald_lightblue = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_lightblue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v3_emerald_lightgray = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_lightgray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v3_emerald_lime = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_lime", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v3_emerald_magenta = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_magenta", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v3_emerald_orange = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_orange", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v3_emerald_pink = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_pink", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v3_emerald_purple = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_purple", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v3_emerald_red = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_red", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v3_emerald_white = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_white", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v3_emerald_yellow = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_yellow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v3_emerald_rainbow = registerItem(new ItemAirshipV3("v3/emerald/item_airship_v3_rainbow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		//==============================================
		
		//V4
		item_airship_v4_wood0_normal = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_normal", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_wood0_black = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_black", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_wood0_blue = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_blue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_wood0_brown = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_brown", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_wood0_cyan = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_wood0_gray = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_gray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_wood0_green = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_green", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_wood0_lightblue = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_wood0_lightgray = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_wood0_lime = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_lime", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_wood0_magenta = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_wood0_orange = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_orange", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_wood0_pink = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_pink", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_wood0_purple = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_purple", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_wood0_red = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_red", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_wood0_white = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_white", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_wood0_yellow = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_wood0_rainbow = registerItem(new ItemAirshipV4("v4/wood0/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.WOOD0.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_iron_normal = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_normal", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_iron_black = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_black", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_iron_blue = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_blue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_iron_brown = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_brown", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_iron_cyan = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_iron_gray = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_gray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_iron_green = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_green", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_iron_lightblue = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_iron_lightgray = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_iron_lime = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_lime", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_iron_magenta = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_iron_orange = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_orange", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_iron_pink = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_pink", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_iron_purple = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_purple", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_iron_red = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_red", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_iron_white = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_white", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_iron_yellow = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_iron_rainbow = registerItem(new ItemAirshipV4("v4/iron/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.IRON.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_redstone_normal = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_normal", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_redstone_black = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_black", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_redstone_blue = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_blue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_redstone_brown = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_brown", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_redstone_cyan = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_redstone_gray = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_gray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_redstone_green = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_green", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_redstone_lightblue = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_redstone_lightgray = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_redstone_lime = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_lime", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_redstone_magenta = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_redstone_orange = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_orange", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_redstone_pink = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_pink", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_redstone_purple = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_purple", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_redstone_red = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_red", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_redstone_white = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_white", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_redstone_yellow = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_redstone_rainbow = registerItem(new ItemAirshipV4("v4/redstone/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.REDSTONE.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_gold_normal = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_normal", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_gold_black = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_black", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_gold_blue = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_blue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_gold_brown = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_brown", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_gold_cyan = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_gold_gray = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_gray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_gold_green = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_green", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_gold_lightblue = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_gold_lightgray = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_gold_lime = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_lime", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_gold_magenta = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_gold_orange = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_orange", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_gold_pink = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_pink", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_gold_purple = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_purple", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_gold_red = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_red", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_gold_white = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_white", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_gold_yellow = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_gold_rainbow = registerItem(new ItemAirshipV4("v4/gold/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.GOLD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_lapislazuli_normal = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_normal", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_lapislazuli_black = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_black", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_lapislazuli_blue = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_blue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_lapislazuli_brown = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_brown", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_lapislazuli_cyan = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_lapislazuli_gray = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_gray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_lapislazuli_green = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_green", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_lapislazuli_lightblue = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_lapislazuli_lightgray = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_lapislazuli_lime = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_lime", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_lapislazuli_magenta = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_lapislazuli_orange = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_orange", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_lapislazuli_pink = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_pink", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_lapislazuli_purple = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_purple", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_lapislazuli_red = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_red", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_lapislazuli_white = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_white", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_lapislazuli_yellow = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_lapislazuli_rainbow = registerItem(new ItemAirshipV4("v4/lapislazuli/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.LAPISLAZULI.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_obsidian_normal = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_normal", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_obsidian_black = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_black", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_obsidian_blue = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_blue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_obsidian_brown = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_brown", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_obsidian_cyan = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_obsidian_gray = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_gray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_obsidian_green = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_green", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_obsidian_lightblue = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_obsidian_lightgray = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_obsidian_lime = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_lime", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_obsidian_magenta = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_obsidian_orange = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_orange", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_obsidian_pink = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_pink", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_obsidian_purple = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_purple", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_obsidian_red = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_red", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_obsidian_white = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_white", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_obsidian_yellow = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_obsidian_rainbow = registerItem(new ItemAirshipV4("v4/obsidian/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.OBSIDIAN.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_diamond_normal = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_normal", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_diamond_black = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_black", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_diamond_blue = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_blue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_diamond_brown = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_brown", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_diamond_cyan = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_diamond_gray = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_gray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_diamond_green = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_green", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_diamond_lightblue = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_diamond_lightgray = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_diamond_lime = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_lime", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_diamond_magenta = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_diamond_orange = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_orange", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_diamond_pink = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_pink", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_diamond_purple = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_purple", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_diamond_red = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_red", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_diamond_white = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_white", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_diamond_yellow = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_diamond_rainbow = registerItem(new ItemAirshipV4("v4/diamond/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.DIAMOND.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		item_airship_v4_emerald_normal = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_normal", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.NORMAL.ordinal()));
		item_airship_v4_emerald_black = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_black", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLACK.ordinal()));
		item_airship_v4_emerald_blue = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_blue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BLUE.ordinal()));
		item_airship_v4_emerald_brown = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_brown", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.BROWN.ordinal()));
		item_airship_v4_emerald_cyan = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_cyan", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.CYAN.ordinal()));
		item_airship_v4_emerald_gray = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_gray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GRAY.ordinal()));
		item_airship_v4_emerald_green = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_green", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.GREEN.ordinal()));
		item_airship_v4_emerald_lightblue = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_lightblue", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTBLUE.ordinal()));
		item_airship_v4_emerald_lightgray = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_lightgray", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIGHTGRAY.ordinal()));
		item_airship_v4_emerald_lime = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_lime", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.LIME.ordinal()));
		item_airship_v4_emerald_magenta = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_magenta", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.MAGENTA.ordinal()));
		item_airship_v4_emerald_orange = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_orange", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.ORANGE.ordinal()));
		item_airship_v4_emerald_pink = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_pink", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PINK.ordinal()));
		item_airship_v4_emerald_purple = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_purple", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.PURPLE.ordinal()));
		item_airship_v4_emerald_red = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_red", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RED.ordinal()));
		item_airship_v4_emerald_white = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_white", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.WHITE.ordinal()));
		item_airship_v4_emerald_yellow = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_yellow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.YELLOW.ordinal()));
		item_airship_v4_emerald_rainbow = registerItem(new ItemAirshipV4("v4/emerald/item_airship_v4_rainbow", EntityAirshipBaseVC.Frame.EMERALD.ordinal(), EntityAirshipBaseVC.Color.RAINBOW.ordinal()));
		
		//==============================================
		
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
	
	public static ItemAirshipV1Wood0 itemVariants;
	
	private static void registerItemMeta() 
	{
		
		//item_airship_v1_wood0 = (ItemAirshipV1Wood0)(new ItemAirshipV1Wood0().setUnlocalizedName("v1/item_airship_v1"));
		//item_airship_v1_wood0.setRegistryName("v1/item_airship_v1");
	    //GameRegistry.register(item_airship_v1_wood0);
		
		//itemVariants = (ItemAirshipV1Wood0)(new ItemAirshipV1Wood0().setUnlocalizedName("mbe11_item_variants_unlocalised_name"));
	    //itemVariants.setRegistryName("mbe11_item_variants_registry_name");
	    //GameRegistry.register(itemVariants);
	}
}
