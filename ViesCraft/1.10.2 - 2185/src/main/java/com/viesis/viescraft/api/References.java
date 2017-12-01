package com.viesis.viescraft.api;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class References {
	
	public static final String MOD_ID = "vc";
	public static final String MOD_ID_COLON = MOD_ID + ":";
	public static final String MOD_NAME = "ViesCraft";
	public static final String MOD_VERSION = "5.1.10";
	public static final String CONFIG_GUI = "com.viesis.viescraft.api.gui.VCGuiFactory";
	public static final String CLIENT_PROXY_CLASS = "com.viesis.viescraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.viesis.viescraft.proxy.ServerProxy";
	
	public static Random random = new Random();
	
	public static final String META_AIRSHIP_SLOTS_TAG = "Slots";
	
	public static final String META_TIER_FRAME_TAG = "TierFrame";
	public static final String META_TIER_CORE_TAG = "TierCore";
	public static final String META_TIER_ENGINE_TAG = "TierEngine";
	public static final String META_TIER_BALLOON_TAG = "TierBalloon";
	
	public static final String META_FRAME_VISUAL_TAG = "FrameVisual";
	public static final String META_FRAME_VISUAL_TRANSPARENT_TAG = "FrameVisualTransparent";
	public static final String META_FRAME_VISUAL_COLOR_TAG = "FrameVisualColor";
	public static final String META_FRAME_VISUAL_COLOR_RED_TAG = "FrameVisualColorRed";
	public static final String META_FRAME_VISUAL_COLOR_GREEN_TAG = "FrameVisualColorGreen";
	public static final String META_FRAME_VISUAL_COLOR_BLUE_TAG = "FrameVisualColorBlue";
	
	public static final String META_BALLOON_VISUAL_TAG = "BalloonVisual";
	public static final String META_BALLOON_VISUAL_TRANSPARENT_TAG = "BalloonVisualTransparent";
	public static final String META_BALLOON_VISUAL_COLOR_TAG = "BalloonVisualColor";
	public static final String META_BALLOON_VISUAL_COLOR_RED_TAG = "BalloonVisualColorRed";
	public static final String META_BALLOON_VISUAL_COLOR_GREEN_TAG = "BalloonVisualColorGreen";
	public static final String META_BALLOON_VISUAL_COLOR_BLUE_TAG = "BalloonVisualColorBlue";
	
	public static final String META_AIRSHIP_BURNTIME_TAG = "BurnTime";
	public static final String META_AIRSHIP_BURNTIME_TOTAL_TAG = "BurnTimeTotal";
	public static final String META_ITEM_FUELSTACK_TAG = "FuelStackTime";
	public static final String META_ITEM_FUELSTACK_SIZE_TAG = "FuelStackTimeSize";
	
	public static final String META_MODULE_VARIANT_SLOT1_TAG = "ModuleVariantSlot1";
	public static final String META_JUKEBOX_SELECTED_SONG_TAG = "JukeboxSelectedSong";
	
	public static final String META_LEARNED_MODULE_ALTITUDE_TAG = "LearnedModuleAltitude";
	public static final String META_SELECTED_MODULE_ALTITUDE_TAG = "SelectedModuleAltitude";
	public static final String META_LEARNED_MODULE_SPEED_TAG = "LearnedModuleSpeed";
	public static final String META_SELECTED_MODULE_SPEED_TAG = "SelectedModuleSpeed";
	public static final String META_LEARNED_MODULE_STORAGE_TAG = "LearnedModuleStorage";
	public static final String META_SELECTED_MODULE_STORAGE_TAG = "SelectedModuleStorage";
	public static final String META_LEARNED_MODULE_FUEL_TAG = "LearnedModuleFuel";
	public static final String META_SELECTED_MODULE_FUEL_TAG = "SelectedModuleFuel";
	public static final String META_LEARNED_MODULE_MUSIC_TAG = "LearnedModuleMusic";
	public static final String META_SELECTED_MODULE_MUSIC_TAG = "SelectedModuleMusic";
	public static final String META_LEARNED_MODULE_CRUISE_TAG = "LearnedModuleCruise";
	public static final String META_SELECTED_MODULE_CRUISE_TAG = "SelectedModuleCruise";
	public static final String META_LEARNED_MODULE_WATER_TAG = "LearnedModuleWater";
	public static final String META_SELECTED_MODULE_WATER_TAG = "SelectedModuleWater";
	public static final String META_LEARNED_MODULE_FUELINFINITE_TAG = "LearnedModuleFuelInfinite";
	public static final String META_SELECTED_MODULE_FUELINFINITE_TAG = "SelectedModuleFuelInfinite";
	
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
