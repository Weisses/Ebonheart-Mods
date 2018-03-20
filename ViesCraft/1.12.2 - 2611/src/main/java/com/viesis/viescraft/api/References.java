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
	public static final String MOD_VERSION = "6.0.0";
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
	
	public static final String FRAME_SKIN_VISUAL_TAG = "FrameSkinVisual";
	public static final String FRAME_SKIN_VISUAL_TRANSPARENT_TAG = "FrameSkinVisualTransparent";
	public static final String FRAME_SKIN_VISUAL_COLOR_TAG = "FrameSkinVisualColor";
	public static final String FRAME_SKIN_VISUAL_COLOR_RED_TAG = "FrameSkinVisualColorRed";
	public static final String FRAME_SKIN_VISUAL_COLOR_GREEN_TAG = "FrameSkinVisualColorGreen";
	public static final String FRAME_SKIN_VISUAL_COLOR_BLUE_TAG = "FrameSkinVisualColorBlue";
	
	public static final String ENGINE_PARTICLE_VISUAL_TAG = "EngineParticleVisual";
	public static final String ENGINE_DISPLAY_TYPE_VISUAL_TAG = "EngineDisplayTypeVisual";
	public static final String ENGINE_DISPLAY_ID_VISUAL_TAG = "EngineDisplayIDVisual";
	
	public static final String BALLOON_PATTERN_VISUAL_TAG = "BalloonPatternVisual";
	public static final String BALLOON_PATTERN_VISUAL_TRANSPARENT_TAG = "BalloonPatternVisualTransparent";
	public static final String BALLOON_PATTERN_VISUAL_COLOR_TAG = "BalloonPatternVisualColor";
	public static final String BALLOON_PATTERN_VISUAL_COLOR_RED_TAG = "BalloonPatternVisualColorRed";
	public static final String BALLOON_PATTERN_VISUAL_COLOR_GREEN_TAG = "BalloonPatternVisualColorGreen";
	public static final String BALLOON_PATTERN_VISUAL_COLOR_BLUE_TAG = "BalloonPatternVisualColorBlue";
	
	public static final String STORED_FUEL_TAG = "StoredFuel";
	public static final String STORED_FUEL_TOTAL_TAG = "StoredFuelTotal";
	public static final String FUEL_ITEMSTACK_TAG = "FuelItemStack";
	public static final String FUEL_ITEMSTACK_SIZE_TAG = "FuelItemStackSize";
	public static final String STORED_REDSTONE_TAG = "StoredRedstone";
	public static final String STORED_REDSTONE_TOTAL_TAG = "StoredRestoneTotal";
	
	public static final String MODULE_ACTIVE_SLOT1_TAG = "ModuleActiveSlot1";
	public static final String JUKEBOX_SELECTED_SONG_TAG = "JukeboxSelectedSong";
	
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
	 * Check if October 31st is within 20 days before and 3 days after.
	 */
	public boolean isDateAroundHalloween(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 10 && calendarIn.get(5) >= 20 || calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 3;
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
