package com.viesis.viescraft.configs;

import java.io.File;

import com.viesis.viescraft.api.util.LogHelper;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

public class ViesCraftConfig {
	
	public static boolean worldRestart;
	public static boolean mcRestart;
	
	public static Configuration config;
	public static final String CATEGORY_VC = "ViesCraft Config";
	
	//public static boolean v1AirshipEnabled;
	//public static boolean v2AirshipEnabled;
	//public static boolean v3AirshipEnabled;
	
	//public static boolean v4AirshipEnabled;
	//public static boolean v5AirshipEnabled;
	//public static boolean v6AirshipEnabled;
	
	public static int v1AirshipSpeed;
	public static int v2AirshipSpeed;
	public static int v3AirshipSpeed;
	
	public static int v4AirshipSpeed;
	public static int v5AirshipSpeed;
	public static int v6AirshipSpeed;
	
	public static boolean vanillaFuel;
	public static boolean outsideModFuel;
	public static int viesolineBurnTime;
	
	public static String v1AirshipName;
	public static String v2AirshipName;
	public static String v3AirshipName;
	
	public static String v4AirshipName;
	public static String v5AirshipName;
	public static String v6AirshipName;
	
	public static boolean recipeDismounterPlayer;
	//public static boolean recipeMythic;
	public static boolean engineSounds;
	
	public static int HUDX;
	public static int HUDY;
	public static int HUDScale;
	
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
	public static final boolean V5AIRSHIPENABLED_DEFAULT = true;
	public static final String V5AIRSHIPENABLED_NAME = "Enable V5 Viesindus Airships?";
	public static final String V5AIRSHIPENABLED_COMMENT = "Should Viesindus airships be globally enabled?";
	public static final boolean V6AIRSHIPENABLED_DEFAULT = true;
	public static final String V6AIRSHIPENABLED_NAME = "Enable V6 Viesamune Airships?";
	public static final String V6AIRSHIPENABLED_COMMENT = "Should Viesamune airships be globally enabled?";
	
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
	public static final int V5AIRSHIPSPEED_DEFAULT = 100;
	public static final String V5AIRSHIPSPEED_NAME = "Airship Speed - Viesindus";
	public static final String V5AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	public static final int V6AIRSHIPSPEED_DEFAULT = 100;
	public static final String V6AIRSHIPSPEED_NAME = "Airship Speed - Viesamune";
	public static final String V6AIRSHIPSPEED_COMMENT = "How fast do airships move based on walkspeed %? ";
	
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
	public static final String V5AIRSHIPNAME_DEFAULT = "Viesindus";
	public static final String V5AIRSHIPNAME_NAME = "Airship Name - Viesindus";
	public static final String V5AIRSHIPNAME_COMMENT = "Change the name of Viesindus Airships?";
	public static final String V6AIRSHIPNAME_DEFAULT = "Viesamune";
	public static final String V6AIRSHIPNAME_NAME = "Airship Name - Viesamune";
	public static final String V6AIRSHIPNAME_COMMENT = "Change the name of Viesamune Airships?";
	
	public static final boolean VANILLAFUEL_DEFAULT = true;
	public static final String VANILLAFUEL_NAME = "Enable using vanilla fuel?";
	public static final String VANILLAFUEL_COMMENT = "Should airships be able to use vanilla fuel?";
	
	public static final boolean OUTSIDEMODFUEL_DEFAULT = true;
	public static final String OUTSIDEMODFUEL_NAME = "Enable using other mod's fuel?";
	public static final String OUTSIDEMODFUEL_COMMENT = "Should airships be able to use other mod's fuel?";
	
	public static final int VIESOLINEBURNTIME_DEFAULT = 90;
	public static final String VIESOLINEBURNTIME_NAME = "Viesoline Burn Time?";
	public static final String VIESOLINEBURNTIME_COMMENT = "How long does Viesoline burn for in seconds? ";

	public static final boolean RECIPEDISMOUNTERPLAYER_DEFAULT = true;
	public static final String RECIPEDISMOUNTERPLAYER_NAME = "Enable Player Dismounter Recipe?";
	public static final String RECIPEDISMOUNTERPLAYER_COMMENT = "Should Player Dismounter be craftable?";

	public static final boolean ENGINESOUND_DEFAULT = true;
	public static final String ENGINESOUND_NAME = "Enable airship engine sounds?";
	public static final String ENGINESOUND_COMMENT = "Should airships have engine sounds when powered?";
	
	public static final int HUDX_DEFAULT = 0;
	public static final String HUDX_NAME = "Set the X position of the HUD.";
	public static final String HUDX_COMMENT = "0 puts it back in the original position.";
	public static final int HUDY_DEFAULT = 0;
	public static final String HUDY_NAME = "Set the Y position of the HUD.";
	public static final String HUDY_COMMENT = "0 puts it back in the original position.";
	public static final int HUDSCALE_DEFAULT = 100;
	public static final String HUDSCALE_NAME = "Set the Scale of the HUD.";
	public static final String HUDSCALE_COMMENT = "100 puts it back in the original scale.";
	
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
		LogHelper.info("Good news everyone! The config has been loaded!");
	}
	
	public static void syncConfig()
	{
		//Main settings
		final String category1 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.LIGHT_PURPLE + "Global Settings";
		config.addCustomCategoryComment(category1, "Global settings.");
		
		recipeDismounterPlayer = config.getBoolean(TextFormatting.WHITE + RECIPEDISMOUNTERPLAYER_NAME, category1, RECIPEDISMOUNTERPLAYER_DEFAULT, RECIPEDISMOUNTERPLAYER_COMMENT);
		
		//General settings
		final String category2 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General Settings";
		config.addCustomCategoryComment(category2, "General airship options.");
		
		v1AirshipSpeed = config.getInt(TextFormatting.WHITE + V1AIRSHIPSPEED_NAME, category2, V1AIRSHIPSPEED_DEFAULT, 100, 400, V1AIRSHIPSPEED_COMMENT);
		v2AirshipSpeed = config.getInt(TextFormatting.WHITE + V2AIRSHIPSPEED_NAME, category2, V2AIRSHIPSPEED_DEFAULT, 100, 400, V2AIRSHIPSPEED_COMMENT);
		v3AirshipSpeed = config.getInt(TextFormatting.WHITE + V3AIRSHIPSPEED_NAME, category2, V3AIRSHIPSPEED_DEFAULT, 100, 400, V3AIRSHIPSPEED_COMMENT);
		
		v4AirshipSpeed = config.getInt(TextFormatting.WHITE + V4AIRSHIPSPEED_NAME, category2, V4AIRSHIPSPEED_DEFAULT, 100, 400, V4AIRSHIPSPEED_COMMENT);
		///////v5AirshipSpeed = config.getInt(TextFormatting.WHITE + V5AIRSHIPSPEED_NAME, category2, V5AIRSHIPSPEED_DEFAULT, 100, 400, V5AIRSHIPSPEED_COMMENT);
		///////v6AirshipSpeed = config.getInt(TextFormatting.WHITE + V6AIRSHIPSPEED_NAME, category2, V6AIRSHIPSPEED_DEFAULT, 100, 400, V6AIRSHIPSPEED_COMMENT);
		
		//Fuel settings
		final String category3 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Fuel Settings";
		config.addCustomCategoryComment(category3, "Airship fuel options.");
		
		vanillaFuel = config.getBoolean(TextFormatting.WHITE + VANILLAFUEL_NAME, category3, VANILLAFUEL_DEFAULT, VANILLAFUEL_COMMENT);
		outsideModFuel = config.getBoolean(TextFormatting.WHITE + OUTSIDEMODFUEL_NAME, category3, OUTSIDEMODFUEL_DEFAULT, OUTSIDEMODFUEL_COMMENT);
		
		viesolineBurnTime = config.getInt(TextFormatting.WHITE + VIESOLINEBURNTIME_NAME, category3, VIESOLINEBURNTIME_DEFAULT, 20, 500, VIESOLINEBURNTIME_COMMENT);
		
		//Client settings
		final String category4 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.GOLD + "Client Side Settings";
		config.addCustomCategoryComment(category4, "Client side airship options.");

		v1AirshipName = config.getString(TextFormatting.WHITE + V1AIRSHIPNAME_NAME, category4, V1AIRSHIPNAME_DEFAULT, V1AIRSHIPNAME_COMMENT);
		v2AirshipName = config.getString(TextFormatting.WHITE + V2AIRSHIPNAME_NAME, category4, V2AIRSHIPNAME_DEFAULT, V2AIRSHIPNAME_COMMENT);
		v3AirshipName = config.getString(TextFormatting.WHITE + V3AIRSHIPNAME_NAME, category4, V3AIRSHIPNAME_DEFAULT, V3AIRSHIPNAME_COMMENT);
		
		v4AirshipName = config.getString(TextFormatting.WHITE + V4AIRSHIPNAME_NAME, category4, V4AIRSHIPNAME_DEFAULT, V4AIRSHIPNAME_COMMENT);
		///////v5AirshipName = config.getString(TextFormatting.WHITE + V5AIRSHIPNAME_NAME, category4, V5AIRSHIPNAME_DEFAULT, V5AIRSHIPNAME_COMMENT);
		///////v6AirshipName = config.getString(TextFormatting.WHITE + V6AIRSHIPNAME_NAME, category4, V6AIRSHIPNAME_DEFAULT, V6AIRSHIPNAME_COMMENT);
		
		engineSounds = config.getBoolean(TextFormatting.WHITE + ENGINESOUND_NAME, category4, ENGINESOUND_DEFAULT, ENGINESOUND_COMMENT);
		
		//HUD settings
		final String category5 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.GOLD + "HUD Settings";
		config.addCustomCategoryComment(category5, "HUD airship options.");
		
		HUDX = config.getInt(TextFormatting.WHITE + HUDX_NAME, category5, HUDX_DEFAULT, -200, 200, HUDX_COMMENT);
		HUDY = config.getInt(TextFormatting.WHITE + HUDY_NAME, category5, HUDY_DEFAULT, -200, 200, HUDY_COMMENT);
		HUDScale = config.getInt(TextFormatting.WHITE + HUDSCALE_NAME, category5, HUDSCALE_DEFAULT, 25, 150, HUDSCALE_COMMENT);
		
		//Save the config
		config.save();
	}
}
