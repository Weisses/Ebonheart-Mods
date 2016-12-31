package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Diamond;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Emerald;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Gold;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Iron;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1LapisLazuli;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Obsidian;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Redstone;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Wood0;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Black;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Green;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Red;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1White;
import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Diamond;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Emerald;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Gold;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Iron;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2LapisLazuli;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Obsidian;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Redstone;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Wood0;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Black;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Green;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Red;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2White;
import com.viesis.viescraft.common.entity.airshipcolors.v2.old.EntityAirshipV2Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Diamond;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Emerald;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Gold;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Iron;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3LapisLazuli;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Obsidian;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Redstone;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityV3Wood0;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Black;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Green;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Red;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3White;
import com.viesis.viescraft.common.entity.airshipcolors.v3.old.EntityAirshipV3Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Diamond;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Emerald;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Gold;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Iron;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4LapisLazuli;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Obsidian;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Redstone;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityV4Wood0;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Black;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Green;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Red;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4White;
import com.viesis.viescraft.common.entity.airshipcolors.v4.old.EntityAirshipV4Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Diamond;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Emerald;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Gold;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Iron;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1LapisLazuli;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Obsidian;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Redstone;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemV1Wood0;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Diamond;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Emerald;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Gold;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Iron;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2LapisLazuli;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Obsidian;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Redstone;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemV2Wood0;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Diamond;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Emerald;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Gold;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Iron;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3LapisLazuli;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Obsidian;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Redstone;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemV3Wood0;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Diamond;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Emerald;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Gold;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Iron;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4LapisLazuli;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Obsidian;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Redstone;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Wood0;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		
		register("item_airship_v1_wood0", EntityItemV1Wood0.class, "item.airship.v1.wood0", 64, 20, true);
		register("item_airship_v1_iron", EntityItemV1Iron.class, "item.airship.v1.iron", 64, 20, true);
		register("item_airship_v1_redstone", EntityItemV1Redstone.class, "item.airship.v1.redstone", 64, 20, true);
		register("item_airship_v1_gold", EntityItemV1Gold.class, "item.airship.v1.gold", 64, 20, true);
		register("item_airship_v1_lapislazuli", EntityItemV1LapisLazuli.class, "item.airship.v1.lapislazuli", 64, 20, true);
		register("item_airship_v1_obsidian", EntityItemV1Obsidian.class, "item.airship.v1.obsidian", 64, 20, true);
		register("item_airship_v1_diamond", EntityItemV1Diamond.class, "item.airship.v1.diamond", 64, 20, true);
		register("item_airship_v1_emerald", EntityItemV1Emerald.class, "item.airship.v1.emerald", 64, 20, true);
		
		register("item_airship_v2_wood0", EntityItemV2Wood0.class, "item.airship.v2.wood0", 64, 20, true);
		register("item_airship_v2_iron", EntityItemV2Iron.class, "item.airship.v2.iron", 64, 20, true);
		register("item_airship_v2_redstone", EntityItemV2Redstone.class, "item.airship.v2.redstone", 64, 20, true);
		register("item_airship_v2_gold", EntityItemV2Gold.class, "item.airship.v2.gold", 64, 20, true);
		register("item_airship_v2_lapislazuli", EntityItemV2LapisLazuli.class, "item.airship.v2.lapislazuli", 64, 20, true);
		register("item_airship_v2_obsidian", EntityItemV2Obsidian.class, "item.airship.v2.obsidian", 64, 20, true);
		register("item_airship_v2_diamond", EntityItemV2Diamond.class, "item.airship.v2.diamond", 64, 20, true);
		register("item_airship_v2_emerald", EntityItemV2Emerald.class, "item.airship.v2.emerald", 64, 20, true);
		
		register("item_airship_v3_wood0", EntityItemV3Wood0.class, "item.airship.v3.wood0", 64, 20, true);
		register("item_airship_v3_iron", EntityItemV3Iron.class, "item.airship.v3.iron", 64, 20, true);
		register("item_airship_v3_redstone", EntityItemV3Redstone.class, "item.airship.v3.redstone", 64, 20, true);
		register("item_airship_v3_gold", EntityItemV3Gold.class, "item.airship.v3.gold", 64, 20, true);
		register("item_airship_v3_lapislazuli", EntityItemV3LapisLazuli.class, "item.airship.v3.lapislazuli", 64, 20, true);
		register("item_airship_v3_obsidian", EntityItemV3Obsidian.class, "item.airship.v3.obsidian", 64, 20, true);
		register("item_airship_v3_diamond", EntityItemV3Diamond.class, "item.airship.v3.diamond", 64, 20, true);
		register("item_airship_v3_emerald", EntityItemV3Emerald.class, "item.airship.v3.emerald", 64, 20, true);
		
		register("item_airship_v4_wood0", EntityItemV4Wood0.class, "item.airship.v4.wood0", 64, 20, true);
		register("item_airship_v4_iron", EntityItemV4Iron.class, "item.airship.v4.iron", 64, 20, true);
		register("item_airship_v4_redstone", EntityItemV4Redstone.class, "item.airship.v4.redstone", 64, 20, true);
		register("item_airship_v4_gold", EntityItemV4Gold.class, "item.airship.v4.gold", 64, 20, true);
		register("item_airship_v4_lapislazuli", EntityItemV4LapisLazuli.class, "item.airship.v4.lapislazuli", 64, 20, true);
		register("item_airship_v4_obsidian", EntityItemV4Obsidian.class, "item.airship.v4.obsidian", 64, 20, true);
		register("item_airship_v4_diamond", EntityItemV4Diamond.class, "item.airship.v4.diamond", 64, 20, true);
		register("item_airship_v4_emerald", EntityItemV4Emerald.class, "item.airship.v4.emerald", 64, 20, true);
		
		//===========================================
		
		register("airship_v1_wood0", EntityV1Wood0.class, "airship.v1.wood0", 64, 1, true);
		register("airship_v1_iron", EntityV1Iron.class, "airship.v1.iron", 64, 1, true);
		register("airship_v1_redstone", EntityV1Redstone.class, "airship.v1.redstone", 64, 1, true);
		register("airship_v1_gold", EntityV1Gold.class, "airship.v1.gold", 64, 1, true);
		register("airship_v1_lapislazuli", EntityV1LapisLazuli.class, "airship.v1.lapislazuli", 64, 1, true);
		register("airship_v1_obsidian", EntityV1Obsidian.class, "airship.v1.obsidian", 64, 1, true);
		register("airship_v1_diamond", EntityV1Diamond.class, "airship.v1.diamond", 64, 1, true);
		register("airship_v1_emerald", EntityV1Emerald.class, "airship.v1.emerald", 64, 1, true);
		
		register("airship_v2_wood0", EntityV2Wood0.class, "airship.v2.wood0", 64, 2, true);
		register("airship_v2_iron", EntityV2Iron.class, "airship.v2.iron", 64, 2, true);
		register("airship_v2_redstone", EntityV2Redstone.class, "airship.v2.redstone", 64, 2, true);
		register("airship_v2_gold", EntityV2Gold.class, "airship.v2.gold", 64, 2, true);
		register("airship_v2_lapislazuli", EntityV2LapisLazuli.class, "airship.v2.lapislazuli", 64, 2, true);
		register("airship_v2_obsidian", EntityV2Obsidian.class, "airship.v2.obsidian", 64, 2, true);
		register("airship_v2_diamond", EntityV2Diamond.class, "airship.v2.diamond", 64, 2, true);
		register("airship_v2_emerald", EntityV2Emerald.class, "airship.v2.emerald", 64, 2, true);
		
		register("airship_v3_wood0", EntityV3Wood0.class, "airship.v3.wood0", 64, 3, true);
		register("airship_v3_iron", EntityV3Iron.class, "airship.v3.iron", 64, 3, true);
		register("airship_v3_redstone", EntityV3Redstone.class, "airship.v3.redstone", 64, 3, true);
		register("airship_v3_gold", EntityV3Gold.class, "airship.v3.gold", 64, 3, true);
		register("airship_v3_lapislazuli", EntityV3LapisLazuli.class, "airship.v3.lapislazuli", 64, 3, true);
		register("airship_v3_obsidian", EntityV3Obsidian.class, "airship.v3.obsidian", 64, 3, true);
		register("airship_v3_diamond", EntityV3Diamond.class, "airship.v3.diamond", 64, 3, true);
		register("airship_v3_emerald", EntityV3Emerald.class, "airship.v3.emerald", 64, 3, true);
		
		register("airship_v4_wood0", EntityV4Wood0.class, "airship.v4.wood0", 64, 4, true);
		register("airship_v4_iron", EntityV4Iron.class, "airship.v4.iron", 64, 4, true);
		register("airship_v4_redstone", EntityV4Redstone.class, "airship.v4.redstone", 64, 4, true);
		register("airship_v4_gold", EntityV4Gold.class, "airship.v4.gold", 64, 4, true);
		register("airship_v4_lapislazuli", EntityV4LapisLazuli.class, "airship.v4.lapislazuli", 64, 4, true);
		register("airship_v4_obsidian", EntityV4Obsidian.class, "airship.v4.obsidian", 64, 4, true);
		register("airship_v4_diamond", EntityV4Diamond.class, "airship.v4.diamond", 64, 4, true);
		register("airship_v4_emerald", EntityV4Emerald.class, "airship.v4.emerald", 64, 4, true);
		
		//===========================================
		
		register("airship_v1_normal", EntityAirshipV1Normal.class, "airship.v1.normal", 64, 1, true);
		register("airship_v1_black", EntityAirshipV1Black.class, "airship.v1.black", 64, 1, true);
		register("airship_v1_blue", EntityAirshipV1Blue.class, "airship.v1.blue", 64, 1, true);
		register("airship_v1_brown", EntityAirshipV1Brown.class, "airship.v1.brown", 64, 1, true);
		register("airship_v1_cyan", EntityAirshipV1Cyan.class, "airship.v1.cyan", 64, 1, true);
		register("airship_v1_gray", EntityAirshipV1Gray.class, "airship.v1.gray", 64, 1, true);
		register("airship_v1_green", EntityAirshipV1Green.class, "airship.v1.green", 64, 1, true);
		register("airship_v1_lightblue", EntityAirshipV1LightBlue.class, "airship.v1.lightblue", 64, 1, true);
		register("airship_v1_lightgray", EntityAirshipV1LightGray.class, "airship.v1.lightgray", 64, 1, true);
		register("airship_v1_lime", EntityAirshipV1Lime.class, "airship.v1.lime", 64, 1, true);
		register("airship_v1_magenta", EntityAirshipV1Magenta.class, "airship.v1.magenta", 64, 1, true);
		register("airship_v1_orange", EntityAirshipV1Orange.class, "airship.v1.orange", 64, 1, true);
		register("airship_v1_pink", EntityAirshipV1Pink.class, "airship.v1.pink", 64, 1, true);
		register("airship_v1_purple", EntityAirshipV1Purple.class, "airship.v1.purple", 64, 1, true);
		register("airship_v1_red", EntityAirshipV1Red.class, "airship.v1.red", 64, 1, true);
		register("airship_v1_white", EntityAirshipV1White.class, "airship.v1.white", 64, 1, true);
		register("airship_v1_yellow", EntityAirshipV1Yellow.class, "airship.v1.yellow", 64, 1, true);
		register("airship_v1_admin", EntityAirshipV1Admin.class, "airship.v1.admin", 64, 1, true);
		
		register("airship_v2_normal", EntityAirshipV2Normal.class, "airship.v2.normal", 64, 1, true);
		register("airship_v2_black", EntityAirshipV2Black.class, "airship.v2.black", 64, 1, true);
		register("airship_v2_blue", EntityAirshipV2Blue.class, "airship.v2.blue", 64, 1, true);
		register("airship_v2_brown", EntityAirshipV2Brown.class, "airship.v2.brown", 64, 1, true);
		register("airship_v2_cyan", EntityAirshipV2Cyan.class, "airship.v2.cyan", 64, 1, true);
		register("airship_v2_gray", EntityAirshipV2Gray.class, "airship.v2.gray", 64, 1, true);
		register("airship_v2_green", EntityAirshipV2Green.class, "airship.v2.green", 64, 1, true);
		register("airship_v2_lightblue", EntityAirshipV2LightBlue.class, "airship.v2.lightblue", 64, 1, true);
		register("airship_v2_lightgray", EntityAirshipV2LightGray.class, "airship.v2.lightgray", 64, 1, true);
		register("airship_v2_lime", EntityAirshipV2Lime.class, "airship.v2.lime", 64, 1, true);
		register("airship_v2_magenta", EntityAirshipV2Magenta.class, "airship.v2.magenta", 64, 1, true);
		register("airship_v2_orange", EntityAirshipV2Orange.class, "airship.v2.orange", 64, 1, true);
		register("airship_v2_pink", EntityAirshipV2Pink.class, "airship.v2.pink", 64, 1, true);
		register("airship_v2_purple", EntityAirshipV2Purple.class, "airship.v2.purple", 64, 1, true);
		register("airship_v2_red", EntityAirshipV2Red.class, "airship.v2.red", 64, 1, true);
		register("airship_v2_white", EntityAirshipV2White.class, "airship.v2.white", 64, 1, true);
		register("airship_v2_yellow", EntityAirshipV2Yellow.class, "airship.v2.yellow", 64, 1, true);
		register("airship_v2_admin", EntityAirshipV2Admin.class, "airship.v2.admin", 64, 1, true);
		
		register("airship_v3_normal", EntityAirshipV3Normal.class, "airship.v3.normal", 64, 1, true);
		register("airship_v3_black", EntityAirshipV3Black.class, "airship.v3.black", 64, 1, true);
		register("airship_v3_blue", EntityAirshipV3Blue.class, "airship.v3.blue", 64, 1, true);
		register("airship_v3_brown", EntityAirshipV3Brown.class, "airship.v3.brown", 64, 1, true);
		register("airship_v3_cyan", EntityAirshipV3Cyan.class, "airship.v3.cyan", 64, 1, true);
		register("airship_v3_gray", EntityAirshipV3Gray.class, "airship.v3.gray", 64, 1, true);
		register("airship_v3_green", EntityAirshipV3Green.class, "airship.v3.green", 64, 1, true);
		register("airship_v3_lightblue", EntityAirshipV3LightBlue.class, "airship.v3.lightblue", 64, 1, true);
		register("airship_v3_lightgray", EntityAirshipV3LightGray.class, "airship.v3.lightgray", 64, 1, true);
		register("airship_v3_lime", EntityAirshipV3Lime.class, "airship.v3.lime", 64, 1, true);
		register("airship_v3_magenta", EntityAirshipV3Magenta.class, "airship.v3.magenta", 64, 1, true);
		register("airship_v3_orange", EntityAirshipV3Orange.class, "airship.v3.orange", 64, 1, true);
		register("airship_v3_pink", EntityAirshipV3Pink.class, "airship.v3.pink", 64, 1, true);
		register("airship_v3_purple", EntityAirshipV3Purple.class, "airship.v3.purple", 64, 1, true);
		register("airship_v3_red", EntityAirshipV3Red.class, "airship.v3.red", 64, 1, true);
		register("airship_v3_white", EntityAirshipV3White.class, "airship.v3.white", 64, 1, true);
		register("airship_v3_yellow", EntityAirshipV3Yellow.class, "airship.v3.yellow", 64, 1, true);
		register("airship_v3_admin", EntityAirshipV3Admin.class, "airship.v3.admin", 64, 1, true);
		
		register("airship_v4_normal", EntityAirshipV4Normal.class, "airship.v4.normal", 64, 1, true);
		register("airship_v4_black", EntityAirshipV4Black.class, "airship.v4.black", 64, 1, true);
		register("airship_v4_blue", EntityAirshipV4Blue.class, "airship.v4.blue", 64, 1, true);
		register("airship_v4_brown", EntityAirshipV4Brown.class, "airship.v4.brown", 64, 1, true);
		register("airship_v4_cyan", EntityAirshipV4Cyan.class, "airship.v4.cyan", 64, 1, true);
		register("airship_v4_gray", EntityAirshipV4Gray.class, "airship.v4.gray", 64, 1, true);
		register("airship_v4_green", EntityAirshipV4Green.class, "airship.v4.green", 64, 1, true);
		register("airship_v4_lightblue", EntityAirshipV4LightBlue.class, "airship.v4.lightblue", 64, 1, true);
		register("airship_v4_lightgray", EntityAirshipV4LightGray.class, "airship.v4.lightgray", 64, 1, true);
		register("airship_v4_lime", EntityAirshipV4Lime.class, "airship.v4.lime", 64, 1, true);
		register("airship_v4_magenta", EntityAirshipV4Magenta.class, "airship.v4.magenta", 64, 1, true);
		register("airship_v4_orange", EntityAirshipV4Orange.class, "airship.v4.orange", 64, 1, true);
		register("airship_v4_pink", EntityAirshipV4Pink.class, "airship.v4.pink", 64, 1, true);
		register("airship_v4_purple", EntityAirshipV4Purple.class, "airship.v4.purple", 64, 1, true);
		register("airship_v4_red", EntityAirshipV4Red.class, "airship.v4.red", 64, 1, true);
		register("airship_v4_white", EntityAirshipV4White.class, "airship.v4.white", 64, 1, true);
		register("airship_v4_yellow", EntityAirshipV4Yellow.class, "airship.v4.yellow", 64, 1, true);
		register("airship_v4_admin", EntityAirshipV4Admin.class, "airship.v4.admin", 64, 1, true);
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("vc:" + name), entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
