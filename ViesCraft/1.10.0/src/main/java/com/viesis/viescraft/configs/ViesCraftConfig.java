package com.viesis.viescraft.configs;

import java.io.File;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

import com.viesis.viescraft.api.util.LogHelper;

public class ViesCraftConfig {
	
	public static Configuration config;
	public static final String CATEGORY_VC = "ViesCraft Config";
	
	public static int v1FuelBurnTime;
	public static int v1AirshipSpeed;
	
	public static int v2FuelBurnTime;
	public static int v2AirshipSpeed;
	
	public static int v3FuelBurnTime;
	public static int v3AirshipSpeed;
	
	public static int v4FuelBurnTime;
	public static int v4AirshipSpeed;
	
	public static boolean modelTurnAngle;
	
	public static String v1AirshipName;
	public static String v2AirshipName;
	public static String v3AirshipName;
	public static String v4AirshipName;
	
	public static final int V1FUELBURNTIME_DEFAULT = 60;
	public static final String V1FUELBURNTIME_NAME = "Fuel Burn Time - Viesdenburg";
	public static final String V1FUELBURNTIME_COMMENT = "How long does each piece of fuel last in seconds?";
	
	public static final int V1AIRSHIPSPEED_DEFAULT = 100;
	public static final String V1AIRSHIPSPEED_NAME = "Airship Speed - Viesdenburg";
	public static final String V1AIRSHIPSPEED_COMMENT = "How fast do airships move based on %? ";
	
	public static final int V2FUELBURNTIME_DEFAULT = 60;
	public static final String V2FUELBURNTIME_NAME = "Fuel Burn Time - Viesigible";
	public static final String V2FUELBURNTIME_COMMENT = "How long does each piece of fuel last in seconds?";
	
	public static final int V2AIRSHIPSPEED_DEFAULT = 100;
	public static final String V2AIRSHIPSPEED_NAME = "Airship Speed - Viesigible";
	public static final String V2AIRSHIPSPEED_COMMENT = "How fast do airships move based on %? ";
	
	public static final int V3FUELBURNTIME_DEFAULT = 60;
	public static final String V3FUELBURNTIME_NAME = "Fuel Burn Time - Viesepelin";
	public static final String V3FUELBURNTIME_COMMENT = "How long does each piece of fuel last in seconds?";
	
	public static final int V3AIRSHIPSPEED_DEFAULT = 100;
	public static final String V3AIRSHIPSPEED_NAME = "Airship Speed - Viesepelin";
	public static final String V3AIRSHIPSPEED_COMMENT = "How fast do airships move based on %? ";
	
	public static final int V4FUELBURNTIME_DEFAULT = 60;
	public static final String V4FUELBURNTIME_NAME = "Fuel Burn Time - Viesakron";
	public static final String V4FUELBURNTIME_COMMENT = "How long does each piece of fuel last in seconds?";
	
	public static final int V4AIRSHIPSPEED_DEFAULT = 100;
	public static final String V4AIRSHIPSPEED_NAME = "Airship Speed - Viesakron";
	public static final String V4AIRSHIPSPEED_COMMENT = "How fast do airships move based on %? ";
	
	public static final boolean MODELTURNANGLE_DEFAULT = true;
	public static final String MODELTURNANGLE_NAME = "Enable Airship Turning Tilt?";
	public static final String MODELTURNANGLE_COMMENT = "Should the airship tilt while players turn?";
	
	public static final String V1AIRSHIPNAME_DEFAULT = "Viesdenburg";
	public static final String V1AIRSHIPNAME_NAME = "Airship Name - Viesdenburg";
	public static final String V1AIRSHIPNAME_COMMENT = "Change the name of Viesdenburg Airships?";
	
	public static final String V2AIRSHIPNAME_DEFAULT = "Viesigible";
	public static final String V2AIRSHIPNAME_NAME = "Airship Name - Viesigible";
	public static final String V2AIRSHIPNAME_COMMENT = "Change the name of Viesigible Airships?";
	
	public static final String V3AIRSHIPNAME_DEFAULT = "Viesepelin";
	public static final String V3AIRSHIPNAME_NAME = "Airship Name - Viesepelin";
	public static final String V3AIRSHIPNAME_COMMENT = "Change the name of Viespelin Airships?";
	
	public static final String V4AIRSHIPNAME_DEFAULT = "Viesakron";
	public static final String V4AIRSHIPNAME_NAME = "Airship Name - Viesakron";
	public static final String V4AIRSHIPNAME_COMMENT = "Change the name of Viesakron Airships?";
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
		LogHelper.info("Good news everyone! The config has been loaded!");
	}
	
	public static void syncConfig()
	{
		//General settings
		final String category1 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General";
		config.addCustomCategoryComment(category1, "General airship options.");
		
		v1FuelBurnTime = config.getInt(TextFormatting.WHITE + V1FUELBURNTIME_NAME, category1, V1FUELBURNTIME_DEFAULT, 1, 600, V1FUELBURNTIME_COMMENT);
		v1AirshipSpeed = config.getInt(TextFormatting.WHITE + V1AIRSHIPSPEED_NAME, category1, V1AIRSHIPSPEED_DEFAULT, 100, 400, V1AIRSHIPSPEED_COMMENT);
		
		v2FuelBurnTime = config.getInt(TextFormatting.WHITE + V2FUELBURNTIME_NAME, category1, V2FUELBURNTIME_DEFAULT, 1, 600, V2FUELBURNTIME_COMMENT);
		v2AirshipSpeed = config.getInt(TextFormatting.WHITE + V2AIRSHIPSPEED_NAME, category1, V2AIRSHIPSPEED_DEFAULT, 100, 400, V2AIRSHIPSPEED_COMMENT);
		
		v3FuelBurnTime = config.getInt(TextFormatting.WHITE + V3FUELBURNTIME_NAME, category1, V3FUELBURNTIME_DEFAULT, 1, 600, V3FUELBURNTIME_COMMENT);
		v3AirshipSpeed = config.getInt(TextFormatting.WHITE + V3AIRSHIPSPEED_NAME, category1, V3AIRSHIPSPEED_DEFAULT, 100, 400, V3AIRSHIPSPEED_COMMENT);
		
		v4FuelBurnTime = config.getInt(TextFormatting.WHITE + V4FUELBURNTIME_NAME, category1, V4FUELBURNTIME_DEFAULT, 1, 600, V4FUELBURNTIME_COMMENT);
		v4AirshipSpeed = config.getInt(TextFormatting.WHITE + V4AIRSHIPSPEED_NAME, category1, V4AIRSHIPSPEED_DEFAULT, 100, 400, V4AIRSHIPSPEED_COMMENT);
		
		v1AirshipName = config.getString(TextFormatting.WHITE + V1AIRSHIPNAME_NAME, category1, V1AIRSHIPNAME_DEFAULT, V1AIRSHIPNAME_COMMENT);
		v2AirshipName = config.getString(TextFormatting.WHITE + V2AIRSHIPNAME_NAME, category1, V2AIRSHIPNAME_DEFAULT, V2AIRSHIPNAME_COMMENT);
		v3AirshipName = config.getString(TextFormatting.WHITE + V3AIRSHIPNAME_NAME, category1, V3AIRSHIPNAME_DEFAULT, V3AIRSHIPNAME_COMMENT);
		v4AirshipName = config.getString(TextFormatting.WHITE + V4AIRSHIPNAME_NAME, category1, V4AIRSHIPNAME_DEFAULT, V4AIRSHIPNAME_COMMENT);
		
		//Animation settings
		final String category2 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
		config.addCustomCategoryComment(category2, "Client Side airship animations.");
		modelTurnAngle = config.getBoolean(TextFormatting.WHITE + MODELTURNANGLE_NAME, category2, MODELTURNANGLE_DEFAULT, MODELTURNANGLE_COMMENT);
		
		//Save the config
		config.save();
	}
}
