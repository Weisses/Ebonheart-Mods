package com.viesis.gemstones.configs;

import java.io.File;

import com.viesis.gemstones.api.util.LogHelper;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.Configuration;

public class ViesisGemstonesConfig {
	
	public static Configuration config;
	public static final String CATEGORY_VG = "Viesis' Gemstones Config";
	
	public static int gemInfusedOre_Overworld_ValueVein;
	public static int gemInfusedOre_Nether_ValueVein;
	public static int gemInfusedOre_End_ValueVein;
	
	public static int gemInfusedOre_Overworld_ValueChunk;
	public static int gemInfusedOre_Nether_ValueChunk;
	public static int gemInfusedOre_End_ValueChunk;
	
	public static final int GEMINFUSED_OVERWORLD_VALUEVEIN_DEFAULT = 6;
	public static final String GEMINFUSED_OVERWORLD_VALUEVEIN_NAME = "Max vein size for Overworld Gem-Infused Ore.";
	public static final String GEMINFUSED_OVERWORLD_VALUEVEIN_COMMENT = "Gem-Infused Ore blocks per vein (Overworld).";
	
	public static final int GEMINFUSED_NETHER_VALUEVEIN_DEFAULT = 6;
	public static final String GEMINFUSED_NETHER_VALUEVEIN_NAME = "Max vein size for Nether Gem-Infused Ore.";
	public static final String GEMINFUSED_NETHER_VALUEVEIN_COMMENT = "Gem-Infused Ore blocks per vein (Overworld).";
	
	public static final int GEMINFUSED_END_VALUEVEIN_DEFAULT = 4;
	public static final String GEMINFUSED_END_VALUEVEIN_NAME = "Max vein size for End Gem-Infused Ore.";
	public static final String GEMINFUSED_END_VALUEVEIN_COMMENT = "Gem-Infused Ore blocks per vein (Overworld).";
	
	public static final int GEMINFUSED_OVERWORLD_VALUECHUNK_DEFAULT = 16;
	public static final String GEMINFUSED_OVERWORLD_VALUECHUNK_NAME = "01) Overworld Gem-Infused Ore density?";
	public static final String GEMINFUSED_OVERWORLD_VALUECHUNK_COMMENT = "Gem-Infused Ore veins per chunk (Overworld).";
	
	public static final int GEMINFUSED_NETHER_VALUECHUNK_DEFAULT = 24;
	public static final String GEMINFUSED_NETHER_VALUECHUNK_NAME = "02) Nether Gem-Infused Ore density?";
	public static final String GEMINFUSED_NETHER_VALUECHUNK_COMMENT = "Gem-Infused Ore veins per chunk (Nether).";
	
	public static final int GEMINFUSED_END_VALUECHUNK_DEFAULT = 6;
	public static final String GEMINFUSED_END_VALUECHUNK_NAME = "03) End Gem-Infused Ore density?";
	public static final String GEMINFUSED_END_VALUECHUNK_COMMENT = "Gem-Infused Ore veins per chunk (End).";
	
	public static void init(File file)
	{
		config = new Configuration(file);
		syncConfig();
		LogHelper.info("The config has been loaded!");
	}
	
	public static void syncConfig()
	{
		//Main settings
		final String category1 = CATEGORY_VG + config.CATEGORY_SPLITTER + TextFormatting.LIGHT_PURPLE + "Global";
		config.addCustomCategoryComment(category1, "Global settings.");
		
		gemInfusedOre_Overworld_ValueVein = config.getInt(TextFormatting.WHITE + GEMINFUSED_OVERWORLD_VALUEVEIN_NAME, category1, GEMINFUSED_OVERWORLD_VALUEVEIN_DEFAULT, 0, 32, GEMINFUSED_OVERWORLD_VALUEVEIN_COMMENT);
		gemInfusedOre_Nether_ValueVein = config.getInt(TextFormatting.WHITE + GEMINFUSED_NETHER_VALUEVEIN_NAME, category1, GEMINFUSED_NETHER_VALUEVEIN_DEFAULT, 0, 32, GEMINFUSED_NETHER_VALUEVEIN_COMMENT);
		gemInfusedOre_End_ValueVein = config.getInt(TextFormatting.WHITE + GEMINFUSED_END_VALUEVEIN_NAME, category1, GEMINFUSED_END_VALUEVEIN_DEFAULT, 0, 32, GEMINFUSED_END_VALUEVEIN_COMMENT);

		gemInfusedOre_Overworld_ValueChunk = config.getInt(TextFormatting.WHITE + GEMINFUSED_OVERWORLD_VALUECHUNK_NAME, category1, GEMINFUSED_OVERWORLD_VALUECHUNK_DEFAULT, 0, 32, GEMINFUSED_OVERWORLD_VALUECHUNK_COMMENT);
		gemInfusedOre_Nether_ValueChunk = config.getInt(TextFormatting.WHITE + GEMINFUSED_NETHER_VALUECHUNK_NAME, category1, GEMINFUSED_NETHER_VALUECHUNK_DEFAULT, 0, 32, GEMINFUSED_NETHER_VALUECHUNK_COMMENT);
		gemInfusedOre_End_ValueChunk = config.getInt(TextFormatting.WHITE + GEMINFUSED_END_VALUECHUNK_NAME, category1, GEMINFUSED_END_VALUECHUNK_DEFAULT, 0, 32, GEMINFUSED_END_VALUECHUNK_COMMENT);
		
		//General settings
		final String category2 = CATEGORY_VG + config.CATEGORY_SPLITTER + TextFormatting.GREEN + "General";
		config.addCustomCategoryComment(category2, "General options.");
		
		
		
		//saves the config
		config.save();
	}
}
