package com.vies.viesmachines.configs;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Loghelper;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class VMConfiguration {
	
	public static final String CATEGORY_VM = "Vies Machines Configuration";
	
	public static Configuration config;
	
	//--------------------------------------------------
	
	// General options:
	public static boolean machineHardmode;
	public static boolean toolDismounterPlayer;
	
	// Fuel options:
	public static boolean vanillaFuel;
	public static boolean outsideModFuel;
	public static int machinePelletsBurnTime;
	
	// Client only options:
	public static boolean engineSounds;
	public static boolean renderNameplates;
	
	//--------------------------------------------------
	
	// General options:
	public static final boolean MACHINEHARDMODE_DEFAULT = false;
	public static final String MACHINEHARDMODE_NAME = "Enable machine Hardmode?";
	public static final String MACHINEHARDMODE_COMMENT = "If enabled, broken machines CANNOT be converted to items.";
	
	public static final boolean TOOLDISMOUNTERPLAYER_DEFAULT = false;
	public static final String TOOLDISMOUNTERPLAYER_NAME = "Enable Dismounter to affect players?";
	public static final String TOOLDISMOUNTERPLAYER_COMMENT = "If enabled, the Dismounter Tool will also affect players riding any entity.";
	
	// Fuel options:
	public static final boolean VANILLAFUEL_DEFAULT = true;
	public static final String VANILLAFUEL_NAME = "Enable using vanilla fuel?";
	public static final String VANILLAFUEL_COMMENT = "If enabled, machines will be able to use vanilla fuel to run.";
	
	public static final boolean OUTSIDEMODFUEL_DEFAULT = true;
	public static final String OUTSIDEMODFUEL_NAME = "Enable using other mod's fuel?";
	public static final String OUTSIDEMODFUEL_COMMENT = "If enabled, machines will be able to use other mod's fuel to run.";
	
	public static final int MACHINEPELLETSBURNTIME_DEFAULT = 60;
	public static final String MACHINEPELLETSBURNTIME_NAME = "Machine Pellets burn time?";
	public static final String MACHINEPELLETSBURNTIME_COMMENT = "How long do the Machine Pellets burn for in seconds?";
	
	// Client only options:
	public static final boolean ENGINESOUND_DEFAULT = true;
	public static final String ENGINESOUND_NAME = "Enable machine engine on sounds?";
	public static final String ENGINESOUND_COMMENT = "If enabled, machines will have engine sounds when powered on.";
	
	public static final boolean RENDERNAMEPLATES_DEFAULT = true;
	public static final String RENDERNAMEPLATES_NAME = "Enable machine overhead nameplates?";
	public static final String RENDERNAMEPLATES_COMMENT = "If enabled, machines will display their overhead nameplates when looked at.";
	
	
	
	public static void load(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		reloadConfig();
		
		Loghelper.info("Good news everyone! The config has been loaded!");
	}
	
	public static void reloadConfig()
	{
		// General options:
		final String category1 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General";
		config.addCustomCategoryComment(category1, "General options.");
		
		machineHardmode = config.getBoolean(TextFormatting.WHITE + MACHINEHARDMODE_NAME, category1, MACHINEHARDMODE_DEFAULT, MACHINEHARDMODE_COMMENT);
		toolDismounterPlayer = config.getBoolean(TextFormatting.WHITE + TOOLDISMOUNTERPLAYER_NAME, category1, TOOLDISMOUNTERPLAYER_DEFAULT, TOOLDISMOUNTERPLAYER_COMMENT);
		
		// Fuel options:
		final String category2 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.GOLD + "Fuel";
		config.addCustomCategoryComment(category2, "Fuel options.");
		
		vanillaFuel = config.getBoolean(TextFormatting.WHITE + VANILLAFUEL_NAME, category2, VANILLAFUEL_DEFAULT, VANILLAFUEL_COMMENT);
		outsideModFuel = config.getBoolean(TextFormatting.WHITE + OUTSIDEMODFUEL_NAME, category2, OUTSIDEMODFUEL_DEFAULT, OUTSIDEMODFUEL_COMMENT);
		machinePelletsBurnTime = config.getInt(TextFormatting.WHITE + MACHINEPELLETSBURNTIME_NAME, category2, MACHINEPELLETSBURNTIME_DEFAULT, 1, 500, MACHINEPELLETSBURNTIME_COMMENT);
		
		// Client only options:
		final String category3 = CATEGORY_VM + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Client only";
		config.addCustomCategoryComment(category3, "Client only options.");

		engineSounds = config.getBoolean(TextFormatting.WHITE + ENGINESOUND_NAME, category3, ENGINESOUND_DEFAULT, ENGINESOUND_COMMENT);
		renderNameplates = config.getBoolean(TextFormatting.WHITE + RENDERNAMEPLATES_NAME, category3, RENDERNAMEPLATES_DEFAULT, RENDERNAMEPLATES_COMMENT);
		
		// Saves the config:
		if (config.hasChanged()) 
		{
			config.save();
		}
	}
	
	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) 
	{
		if (event.getModID().equals(References.MOD_ID)) 
		{
			reloadConfig();
		}
	}
}
