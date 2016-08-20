package com.viesis.viescraft.configs;

import java.io.File;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.MessageGuiOpen;

public class ViesCraftConfig {
	
	public static Configuration config;
	public static final String CATEGORY_VC = "ViesCraft Config";
	
	public static int fuelBurnTime;
	public static int airshipSpeed;
	public static boolean modelTurnAngle;
	
	public static final int FUELBURNTIME_DEFAULT = 60;
	public static final String FUELBURNTIME_NAME = "Fuel Burn Time";
	public static final String FUELBURNTIME_COMMENT = "How long does each piece of fuel last in seconds?";
	
	public static final int AIRSHIPSPEED_DEFAULT = 100;
	public static final String AIRSHIPSPEED_NAME = "Airship Speed";
	public static final String AIRSHIPSPEED_COMMENT = "How fast do airships move based on %? ";
	
	public static final boolean MODELTURNANGLE_DEFAULT = true;
	public static final String MODELTURNANGLE_NAME = "Enable Airship Turning Tilt?";
	public static final String MODELTURNANGLE_COMMENT = "Should the airship tilt while players turn?";
	
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
		fuelBurnTime = config.getInt(TextFormatting.WHITE + FUELBURNTIME_NAME, category1, FUELBURNTIME_DEFAULT, 1, 600, FUELBURNTIME_COMMENT);
		airshipSpeed = config.getInt(TextFormatting.WHITE + AIRSHIPSPEED_NAME, category1, AIRSHIPSPEED_DEFAULT, 1, 400, AIRSHIPSPEED_COMMENT);
		
		
		
		//Animation settings
		final String category2 = CATEGORY_VC + config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
		config.addCustomCategoryComment(category2, "Client Side airship animations.");
		modelTurnAngle = config.getBoolean(TextFormatting.WHITE + MODELTURNANGLE_NAME, category2, MODELTURNANGLE_DEFAULT, MODELTURNANGLE_COMMENT);
		
		//Save the config
		config.save();
	}
}
