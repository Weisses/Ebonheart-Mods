package com.viesis.viescraft.api;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class References {
	
	public static final String MOD_ID = "vc";
	public static final String MOD_ID_COLON = MOD_ID + ":";
	public static final String MOD_NAME = "ViesCraft";
	public static final String MOD_VERSION = "5.9.12";
	public static final String CONFIG_GUI = "com.viesis.viescraft.api.gui.VCGuiFactory";
	public static final String CLIENT_PROXY_CLASS = "com.viesis.viescraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.viesis.viescraft.proxy.ServerProxy";
	
	public static Random random = new Random();
	
	public static final String CUSTOM_NAME_TAG = "CustomName";
	
	public static final String AIRSHIP_SLOTS_TAG = "Slots";
	
	public static final String MAIN_TIER_CORE_TAG = "TierCore";
	public static final String MAIN_TIER_FRAME_TAG = "TierFrame";
	public static final String MAIN_TIER_ENGINE_TAG = "TierEngine";
	public static final String MAIN_TIER_BALLOON_TAG = "TierBalloon";
	
	public static final String CORE_MODEL_VISUAL_FRAME_TAG = "CoreModelVisualFrame";
	public static final String CORE_MODEL_VISUAL_ENGINE_TAG = "CoreModelVisualEngine";
	public static final String CORE_MODEL_VISUAL_BALLOON_TAG = "CoreModelVisualBalloon";
	
	public static final String FRAME_SKIN_TEXTURE_TAG = "FrameSkinTexture";
	public static final String FRAME_SKIN_TRANSPARENT_TAG = "FrameSkinTransparent";
	public static final String FRAME_SKIN_COLOR_TAG = "FrameSkinColor";
	public static final String FRAME_SKIN_COLOR_RED_TAG = "FrameSkinColorRed";
	public static final String FRAME_SKIN_COLOR_GREEN_TAG = "FrameSkinColorGreen";
	public static final String FRAME_SKIN_COLOR_BLUE_TAG = "FrameSkinColorBlue";
	
	public static final String ENGINE_PARTICLE_VISUAL_TAG = "EngineParticleVisual";
	public static final String ENGINE_DISPLAY_TYPE_VISUAL_TAG = "EngineDisplayTypeVisual";
	public static final String ENGINE_DISPLAY_ITEMSTACK_VISUAL_TAG = "EngineDisplayItemstackVisual";
	public static final String ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_TAG = "EngineDisplayItemstackMetaVisual";
	public static final String ENGINE_DISPLAY_HEAD_VISUAL_TAG = "EngineDisplayHeadVisual";
	public static final String ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_TAG = "EngineDisplaySupporterHeadVisual";
	public static final String ENGINE_DISPLAY_HOLIDAY_VISUAL_TAG = "EngineDisplayHolidayVisual";
	
	public static final String BALLOON_PATTERN_TEXTURE_TAG = "BalloonPatternTexture";
	public static final String BALLOON_PATTERN_TRANSPARENT_TAG = "BalloonPatternTransparent";
	public static final String BALLOON_PATTERN_COLOR_TAG = "BalloonPatternColor";
	public static final String BALLOON_PATTERN_COLOR_RED_TAG = "BalloonPatternColorRed";
	public static final String BALLOON_PATTERN_COLOR_GREEN_TAG = "BalloonPatternColorGreen";
	public static final String BALLOON_PATTERN_COLOR_BLUE_TAG = "BalloonPatternColorBlue";
	
	public static final String STORED_FUEL_TAG = "StoredFuel";
	public static final String STORED_FUEL_TOTAL_TAG = "StoredFuelTotal";
	public static final String FUEL_ITEMSTACK_TAG = "FuelItemStack";
	public static final String FUEL_ITEMSTACK_SIZE_TAG = "FuelItemStackSize";
	public static final String STORED_REDSTONE_TAG = "StoredRedstone";
	public static final String STORED_REDSTONE_TOTAL_TAG = "StoredRestoneTotal";
	
	public static final String MODULE_ACTIVE_SLOT1_TAG = "ModuleActiveSlot1";
	public static final String JUKEBOX_SELECTED_SONG_TAG = "JukeboxSelectedSong";
	public static final String BOMB_ARMED_TAG = "BombArmed";
	public static final String BOMB_TYPE_1_TAG = "BombType1";
	public static final String BOMB_TYPE_2_TAG = "BombType2";
	public static final String BOMB_TYPE_3_TAG = "BombType3";
	public static final String BOMB_TYPE_ACTIVE_TAG = "BombTypeActive";
	
	public static final String LEARNED_MODULE_ALTITUDE_TAG = "LearnedModuleAltitude";
	public static final String SELECTED_MODULE_ALTITUDE_TAG = "SelectedModuleAltitude";
	public static final String LEARNED_MODULE_SPEED_TAG = "LearnedModuleSpeed";
	public static final String SELECTED_MODULE_SPEED_TAG = "SelectedModuleSpeed";
	public static final String LEARNED_MODULE_STORAGE_TAG = "LearnedModuleStorage";
	public static final String SELECTED_MODULE_STORAGE_TAG = "SelectedModuleStorage";
	public static final String LEARNED_MODULE_FUEL_TAG = "LearnedModuleFuel";
	public static final String SELECTED_MODULE_FUEL_TAG = "SelectedModuleFuel";
	public static final String LEARNED_MODULE_MUSIC_TAG = "LearnedModuleMusic";
	public static final String SELECTED_MODULE_MUSIC_TAG = "SelectedModuleMusic";
	public static final String LEARNED_MODULE_CRUISE_TAG = "LearnedModuleCruise";
	public static final String SELECTED_MODULE_CRUISE_TAG = "SelectedModuleCruise";
	public static final String LEARNED_MODULE_WATER_TAG = "LearnedModuleWater";
	public static final String SELECTED_MODULE_WATER_TAG = "SelectedModuleWater";
	public static final String LEARNED_MODULE_FUELINFINITE_TAG = "LearnedModuleFuelInfinite";
	public static final String SELECTED_MODULE_FUELINFINITE_TAG = "SelectedModuleFuelInfinite";
	public static final String LEARNED_MODULE_BOMB_TAG = "LearnedModuleBomb";
	public static final String SELECTED_MODULE_BOMB_TAG = "SelectedModuleBomb";
	
	public static net.minecraft.util.text.translation.I18n Old_I18n;
	
	/**
	 * Check if January 1st is within 3 days before and 3 days after.
	 */
	public static boolean isDateAroundNewYears(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 29 || calendarIn.get(2) + 1 == 1 && calendarIn.get(5) <= 4;
    }
	
	/**
	 * Check if February 14th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundValentinesDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 2 && calendarIn.get(5) >= 4 || calendarIn.get(2) + 1 == 2 && calendarIn.get(5) <= 17;
    }
	
	/**
	 * Check if April 7th is within 8 days before and 7 days after.
	 */
	public static boolean isDateAroundEaster(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 3 && calendarIn.get(5) >= 29 || calendarIn.get(2) + 1 == 4 && calendarIn.get(5) <= 14;
    }
	
	/**
	 * Check if July 4th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundIndependenceDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 5 && calendarIn.get(5) >= 27 || calendarIn.get(2) + 1 == 6 && calendarIn.get(5) <= 7;
    }
	
	/**
	 * Check if October 31st is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundHalloween(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 10 && calendarIn.get(5) >= 20 || calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 3;
    }
	
	/**
	 * Check if November 28th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundThanksgiving(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 11 && calendarIn.get(5) >= 18 || calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 30;
    }
	
	/**
	 * Check if December 25th is within 10 days before and 3 days after.
	 */
	public static boolean isDateAroundChristmas(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 15 || calendarIn.get(2) + 1 == 12 && calendarIn.get(5) <= 28;
    }
	
	/**
	 * Sets the correct Main Toolitp color
	 */
	@SideOnly(Side.CLIENT)
	public static TextFormatting mainColorTooltip(ItemStack stackIn)
	{
		TextFormatting stringColorMain = TextFormatting.WHITE;
		
		if(stackIn.getMetadata() == 0)
		{
			stringColorMain = TextFormatting.WHITE;
		}
		if(stackIn.getMetadata() == 1)
		{
			stringColorMain = TextFormatting.WHITE;
		}
		if(stackIn.getMetadata() == 2)
		{
			stringColorMain = TextFormatting.YELLOW;
		}
		if(stackIn.getMetadata() == 3)
		{
			stringColorMain = TextFormatting.AQUA;
		}
		if(stackIn.getMetadata() == 4)
		{
			stringColorMain = TextFormatting.LIGHT_PURPLE;
		}
		if(stackIn.getMetadata() == 5)
		{
			stringColorMain = TextFormatting.RED;
		}
		
		return stringColorMain;
	}
	
	/**
	 * Sets the correct Text Toolitp color
	 */
	@SideOnly(Side.CLIENT)
	public static TextFormatting textColorTooltip(ItemStack stackIn)
	{
		TextFormatting stringColorText = TextFormatting.GRAY;
		
		if(stackIn.getMetadata() == 0)
		{
			stringColorText = TextFormatting.GRAY;
		}
		if(stackIn.getMetadata() == 1)
		{
			stringColorText = TextFormatting.GRAY;
		}
		if(stackIn.getMetadata() == 2)
		{
			stringColorText = TextFormatting.GOLD;
		}
		if(stackIn.getMetadata() == 3)
		{
			stringColorText = TextFormatting.DARK_AQUA;
		}
		if(stackIn.getMetadata() == 4)
		{
			stringColorText = TextFormatting.DARK_PURPLE;
		}
		if(stackIn.getMetadata() == 5)
		{
			stringColorText = TextFormatting.DARK_RED;
		}
		
		return stringColorText;
	}
	
	/**
	 * A simple wrapper for the new Localization format.
	 * This is Client side only!
	 */
	@SideOnly(Side.CLIENT)
	public static String localNameVC(String stringIn)
	{
		return I18n.format(stringIn, new Object[0]);
	}
	
	
	//=========================================
	
	
	/**
	 * Used in Rendering Airship textures.
	 *
	public static final ResourceLocation[] ENTITY_SCREEN_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/no_module.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_minor.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_major.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_small.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_large.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_fuel_infinite.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_water_landing.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_max_altitude.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_minor_efficiency.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_major_efficiency.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_jukebox.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_cruise_control.png")
	};*/
}
