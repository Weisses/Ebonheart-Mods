package com.viesis.viescraft.configs;

import java.io.File;

import com.viesis.viescraft.api.util.LogHelper;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

public class ViesCraftConfig {
	
	public static Configuration config;
	public static final String CATEGORY_VC = "ViesCraft Config";
	
	public static boolean v1AirshipEnabled;
	public static boolean v2AirshipEnabled;
	public static boolean v3AirshipEnabled;
	public static boolean v4AirshipEnabled;
	
	//public static int v1FuelBurnTime;
	public static int v1AirshipSpeed;
	
	//public static int v2FuelBurnTime;
	public static int v2AirshipSpeed;
	
	//public static int v3FuelBurnTime;
	public static int v3AirshipSpeed;
	
	//public static int v4FuelBurnTime;
	public static int v4AirshipSpeed;
	
	public static boolean vanillaFuel;
	public static int viesolineBurnTime;
	
	public static String v1AirshipName;
	public static String v2AirshipName;
	public static String v3AirshipName;
	public static String v4AirshipName;
	
	public static boolean recipeMythic;
	
	public static final boolean V1AIRSHIPENABLED_DEFAULT = true;
	public static final String V1AIRSHIPENABLED_NAME = "Enable V1 Viesdenburg Airships?";
	public static final String V1AIRSHIPENABLED_COMMENT = "Should Viesdenburg airships be globally enabled?";
	
	public static final boolean V2AIRSHIPENABLED_DEFAULT = true;
	public static final String V2AIRSHIPENABLED_NAME = "Enable V2 Viesigible Airships?";
	public static final String V2AIRSHIPENABLED_COMMENT = "Should Viesigible airships be globally enabled?";
	
	public static final boolean V3AIRSHIPENABLED_DEFAULT = true;
	public static final String V3AIRSHIPENABLED_NAME = "Enable V3 Viesepelin Airships?";
	public static final String V3AIRSHIPENABLED_COMMENT = "Should Viesepelin airships be globally enabled?";
	
	public static final boolean V4AIRSHIPENABLED_DEFAULT = true;
	public static final String V4AIRSHIPENABLED_NAME = "Enable V4 Viesakron Airships?";
	public static final String V4AIRSHIPENABLED_COMMENT = "Should Viesakron airships be globally enabled?";
	
	public static final int V1AIRSHIPSPEED_DEFAULT = 100;
	public static final String V1AIRSHIPSPEED_NAME = "Airship Speed - Viesdenburg";
	public static final String V1AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
	public static final int V2AIRSHIPSPEED_DEFAULT = 100;
	public static final String V2AIRSHIPSPEED_NAME = "Airship Speed - Viesigible";
	public static final String V2AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
	public static final int V3AIRSHIPSPEED_DEFAULT = 100;
	public static final String V3AIRSHIPSPEED_NAME = "Airship Speed - Viesepelin";
	public static final String V3AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
	public static final int V4AIRSHIPSPEED_DEFAULT = 100;
	public static final String V4AIRSHIPSPEED_NAME = "Airship Speed - Viesakron";
	public static final String V4AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
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
	
	public static final boolean VANILLAFUEL_DEFAULT = true;
	public static final String VANILLAFUEL_NAME = "Enable using vanilla fuel?";
	public static final String VANILLAFUEL_COMMENT = "Should airships be able to use vanilla fuel?";
	
	public static final int VIESOLINEBURNTIME_DEFAULT = 90;
	public static final String VIESOLINEBURNTIME_NAME = "Viesoline Burn Time?";
	public static final String VIESOLINEBURNTIME_COMMENT = "How long does Viesoline burn for in seconds? ";

	public static final boolean RECIPEMYTHIC_DEFAULT = false;
	public static final String RECIPEMYTHIC_NAME = "Enable Mythic Airship Frame Recipe?";
	public static final String RECIPEMYTHIC_COMMENT = "Should Mythic Airship Frame be craftable?";
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
		LogHelper.info("Good news everyone! The config has been loaded!");
	}
	
	public static void syncConfig()
	{
		//Main settings
		final String category1 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.LIGHT_PURPLE + "Global";
		config.addCustomCategoryComment(category1, "Global Airship settings.");
		
		v1AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V1AIRSHIPENABLED_NAME, category1, V1AIRSHIPENABLED_DEFAULT, V1AIRSHIPENABLED_COMMENT);
		v2AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V2AIRSHIPENABLED_NAME, category1, V2AIRSHIPENABLED_DEFAULT, V2AIRSHIPENABLED_COMMENT);
		v3AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V3AIRSHIPENABLED_NAME, category1, V3AIRSHIPENABLED_DEFAULT, V3AIRSHIPENABLED_COMMENT);
		v4AirshipEnabled = config.getBoolean(TextFormatting.WHITE + V4AIRSHIPENABLED_NAME, category1, V4AIRSHIPENABLED_DEFAULT, V4AIRSHIPENABLED_COMMENT);
		
		
		//General settings
		final String category2 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General";
		config.addCustomCategoryComment(category2, "General airship options.");
		
		//v1FuelBurnTime = config.getInt(TextFormatting.WHITE + V1FUELBURNTIME_NAME, category1, V1FUELBURNTIME_DEFAULT, 1, 600, V1FUELBURNTIME_COMMENT);
		v1AirshipSpeed = config.getInt(TextFormatting.WHITE + V1AIRSHIPSPEED_NAME, category2, V1AIRSHIPSPEED_DEFAULT, 100, 400, V1AIRSHIPSPEED_COMMENT);
		
		//v2FuelBurnTime = config.getInt(TextFormatting.WHITE + V2FUELBURNTIME_NAME, category1, V2FUELBURNTIME_DEFAULT, 1, 600, V2FUELBURNTIME_COMMENT);
		v2AirshipSpeed = config.getInt(TextFormatting.WHITE + V2AIRSHIPSPEED_NAME, category2, V2AIRSHIPSPEED_DEFAULT, 100, 400, V2AIRSHIPSPEED_COMMENT);
		
		//v3FuelBurnTime = config.getInt(TextFormatting.WHITE + V3FUELBURNTIME_NAME, category1, V3FUELBURNTIME_DEFAULT, 1, 600, V3FUELBURNTIME_COMMENT);
		v3AirshipSpeed = config.getInt(TextFormatting.WHITE + V3AIRSHIPSPEED_NAME, category2, V3AIRSHIPSPEED_DEFAULT, 100, 400, V3AIRSHIPSPEED_COMMENT);
		
		//v4FuelBurnTime = config.getInt(TextFormatting.WHITE + V4FUELBURNTIME_NAME, category1, V4FUELBURNTIME_DEFAULT, 1, 600, V4FUELBURNTIME_COMMENT);
		v4AirshipSpeed = config.getInt(TextFormatting.WHITE + V4AIRSHIPSPEED_NAME, category2, V4AIRSHIPSPEED_DEFAULT, 100, 400, V4AIRSHIPSPEED_COMMENT);
		
		v1AirshipName = config.getString(TextFormatting.WHITE + V1AIRSHIPNAME_NAME, category2, V1AIRSHIPNAME_DEFAULT, V1AIRSHIPNAME_COMMENT);
		v2AirshipName = config.getString(TextFormatting.WHITE + V2AIRSHIPNAME_NAME, category2, V2AIRSHIPNAME_DEFAULT, V2AIRSHIPNAME_COMMENT);
		v3AirshipName = config.getString(TextFormatting.WHITE + V3AIRSHIPNAME_NAME, category2, V3AIRSHIPNAME_DEFAULT, V3AIRSHIPNAME_COMMENT);
		v4AirshipName = config.getString(TextFormatting.WHITE + V4AIRSHIPNAME_NAME, category2, V4AIRSHIPNAME_DEFAULT, V4AIRSHIPNAME_COMMENT);
		
		recipeMythic = config.getBoolean(TextFormatting.WHITE + RECIPEMYTHIC_NAME, category2, RECIPEMYTHIC_DEFAULT, RECIPEMYTHIC_COMMENT);
		
		
		//Fuel settings
		final String category3 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Fuel";
		config.addCustomCategoryComment(category3, "Airship fuel options.");
		
		vanillaFuel = config.getBoolean(TextFormatting.WHITE + VANILLAFUEL_NAME, category3, VANILLAFUEL_DEFAULT, VANILLAFUEL_COMMENT);
		viesolineBurnTime = config.getInt(TextFormatting.WHITE + VIESOLINEBURNTIME_NAME, category3, VIESOLINEBURNTIME_DEFAULT, 1, 500, VIESOLINEBURNTIME_COMMENT);
		
		
		//Save the config
		config.save();
	}
}
