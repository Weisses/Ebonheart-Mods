package com.vies.viesmachines.api;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class References {
	
	public static final String MOD_ID = "viesmachines";
	public static final String MOD_NAME = "Vies Machines";
	public static final String MOD_VERSION_NUMBER = "1.0.0";
	public static final String MOD_VERSION_MC = "1.12.2";
	public static final String VERSION = MOD_VERSION_NUMBER + " - MC " + MOD_VERSION_MC;
	//public static final String website = "http://lycanitesmobs.com";
	//public static final String websiteAPI = "http://api.lycanitesmobs.com";
	//public static final String websitePatreon = "https://www.patreon.com/lycanite";
	public static final String ACCEPTED_MINECRAFT_VERSIONS = "[1.12,1.13]";
	public static final String CONFIG_GUI = "com.vies.viesmachines.api.config.VMGuiFactory";
	public static final String CLIENT_PROXY_CLASS = "com.vies.viesmachines.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.vies.viesmachines.proxy.ServerProxy";
	
	//--------------------------------------------------
	
	// Various variable string constant names:
	public static final String CUSTOM_NAME_TAG = "CustomName";
	public static final String MACHINE_SLOTS_TAG = "Slots";
	public static final String POWERED_ON_TAG = "PoweredOn";
	public static final String TYPE_TAG = "Type";
	public static final String FORWARD_SPEED_TAG = "ForwardSpeed";
	public static final String TURN_SPEED_TAG = "TurnSpeed";
	public static final String HEALTH_TAG = "Health";
	public static final String ENERGY_TAG = "Energy";
	public static final String DURABILITY_TAG = "Durability";
	public static final String DURABILITY_PERCENT_TAG = "DurabilityPercent";
	public static final String BROKEN_TAG = "Broken";
	public static final String AUTORUN_TAG = "Autorun";
	public static final String ARMED_TAG = "Armed";
	public static final String AMMO_AMOUNT_TAG = "AmmoAmount";
	public static final String AMMO_TYPE_TAG = "AmmoType";
	public static final String LEARNED_RECORD_SLOT_1_TAG = "LearnedRecordSlot1";
	public static final String LEARNED_RECORD_SLOT_2_TAG = "LearnedRecordSlot2";
	public static final String LEARNED_RECORD_SLOT_3_TAG = "LearnedRecordSlot3";
	public static final String LEARNED_RECORD_SLOT_4_TAG = "LearnedRecordSlot4";
	public static final String LEARNED_RECORD_SLOT_5_TAG = "LearnedRecordSlot5";
	public static final String LEARNED_RECORD_SLOT_6_TAG = "LearnedRecordSlot6";
	public static final String LEARNED_RECORD_SLOT_7_TAG = "LearnedRecordSlot7";
	public static final String SELECTED_SONG_TAG = "SelectedSong";
	public static final String FUEL_TAG = "Fuel";
	public static final String FUEL_TOTAL_TAG = "FuelTotal";
	public static final String ITEMSTACK_FUEL_ITEM_TAG = "ItemstackFuelItem";
	public static final String ITEMSTACK_FUEL_SIZE_TAG = "ItemstackFuelSize";
	public static final String STORED_MICRO_ENERGY_TAG = "StoredMicroEnergy";
	public static final String ENERGY_INCREASE_TAG = "EnergyIncrease";
	public static final String STORED_MICRO_DURABILITY_TAG = "StoredMicroDurability";
	public static final String DURABILITY_DECREASE_TAG = "DurabilityDecrease";
	public static final String TIER_FRAME_TAG = "TierFrame";
	public static final String TIER_ENGINE_TAG = "TierEngine";
	public static final String TIER_COMPONENT_TAG = "TierComponent";
	public static final String MACHINE_ENHANCEMENT_1_TAG = "MachineEnhancement1";
	public static final String PRIMED_FOR_LIGHTNING_STRIKE_TAG = "PrimedForLightningStrike";
	public static final String MACHINE_ISSUE_TAG = "MachineIssue";
	public static final String EVENT_TRIGGER_TAG = "EventTrigger";
	
	public static final String VISUAL_MODEL_FRAME_TAG = "VisualModelFrame";
	public static final String VISUAL_MODEL_ENGINE_TAG = "VisualModelEngine";
	public static final String VISUAL_MODEL_COMPONENT_TAG = "VisualModelComponent";
	public static final String VISUAL_FRAME_TEXTURE_TAG = "VisualFrameTexture";
	public static final String VISUAL_FRAME_TRANSPARENT_TAG = "VisualFrameTransparent";
	public static final String VISUAL_FRAME_COLOR_TAG = "VisualFrameColor";
	public static final String VISUAL_FRAME_COLOR_RED_TAG = "VisualFrameColorRed";
	public static final String VISUAL_FRAME_COLOR_GREEN_TAG = "VisualFrameColorGreen";
	public static final String VISUAL_FRAME_COLOR_BLUE_TAG = "VisualFrameColorBlue";
	public static final String VISUAL_ENGINE_PARTICLE_TAG = "VisualEngineParticle";
	public static final String VISUAL_ENGINE_DISPLAY_TYPE_TAG = "VisualEngineDisplayType";
	public static final String VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG = "VisualEngineDisplayItemstack";
	public static final String VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG = "VisualEngineDisplayItemstackMeta";
	public static final String VISUAL_ENGINE_DISPLAY_HEAD_TAG = "VisualEngineDisplayHead";
	public static final String VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG = "VisualEngineDisplaySupporterHead";
	public static final String VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG = "VisualEngineDisplayHoliday";
	public static final String VISUAL_COMPONENT_TEXTURE_TAG = "VisualComponentTexture";
	public static final String VISUAL_COMPONENT_TRANSPARENT_TAG = "VisualComponentTransparent";
	public static final String VISUAL_COMPONENT_COLOR_TAG = "VisualComponentColor";
	public static final String VISUAL_COMPONENT_COLOR_RED_TAG = "VisualComponentColorRed";
	public static final String VISUAL_COMPONENT_COLOR_GREEN_TAG = "VisualComponentColorGreen";
	public static final String VISUAL_COMPONENT_COLOR_BLUE_TAG = "VisualComponentColorBlue";
	public static final String VISUAL_NAME_COLOR_TAG = "VisualNameColor";
	
	public static final String TOOL_RECORD_TO_ADD_TAG = "RecordToAdd";
	
	//--------------------------------------------------
	
    /** Used for the font renderer. */
    public static FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
    
	/** Easy hook into the random method. */
	public static Random random = new Random();
	
	/** A simple wrapper for the new Localization format. This is Client side only! */
	@SideOnly(Side.CLIENT)
	public static String localNameVC(String stringIn)
	{
		return I18n.format(stringIn, new Object[0]);
	}
	
	/** Name localization method that works on both client and server. */
	public static net.minecraft.util.text.translation.I18n Old_I18n;
	
	//--------------------------------------------------
    
    // Resource location for heads:
  	public static final ResourceLocation STEVE_TEXTURES = new ResourceLocation("textures/entity/steve.png");
    public static final ResourceLocation ALEX_TEXTURES = new ResourceLocation("textures/entity/alex.png");
    public static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");
    public static final ResourceLocation PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");
    public static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");
    public static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");
    public static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
    public static final ResourceLocation WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    public static final ResourceLocation DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    public static final ResourceLocation HEROBRINE_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/herobrine.png");
    
    public static final ResourceLocation SUPPORTER_VIES_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/vies.png");
    public static final ResourceLocation SUPPORTER_SOULFORGE7_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/soulforge7.png");
    public static final ResourceLocation SUPPORTER_NEMANOR_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/nemanor.png");
    public static final ResourceLocation SUPPORTER_VELOURVAULTSUIT_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/velourvaultsuit.png");
	
	//--------------------------------------------------
    
	/** Check if January 1st is within 3 days before and 3 days after. */
	public static boolean isDateAroundNewYears(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 29 
		&& calendarIn.get(2) + 1 == 1 && calendarIn.get(5) <= 4;
    }
	/** December 29th. */
	public static String startDateNewYears()
    {
        return "12/29";
    }
	/** January 4th. */
	public static String endDateNewYears()
    {
        return "1/4";
    }
	
	/** Check if February 14th is within 10 days before and 3 days after. */
	public static boolean isDateAroundValentinesDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 2 && calendarIn.get(5) >= 4 
		&& calendarIn.get(2) + 1 == 2 && calendarIn.get(5) <= 17;
    }
	/** February 4th. */
	public static String startDateValentinesDay()
    {
        return "2/4";
    }
	/** February 17th. */
	public static String endDateValentinesDay()
    {
        return "2/17";
    }
	
	/** Check if April 7th is within 8 days before and 7 days after. */
	public static boolean isDateAroundEaster(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 3 && calendarIn.get(5) >= 29 
		&& calendarIn.get(2) + 1 == 4 && calendarIn.get(5) <= 14;
    }
	/** March 29th. */
	public static String startDateEaster()
    {
        return "3/29";
    }
	/** April 14th. */
	public static String endDateEaster()
    {
        return "4/14";
    }
	
	/** Check if July 4th is within 10 days before and 3 days after. */
	public static boolean isDateAroundIndependenceDay(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 6 && calendarIn.get(5) >= 27 
		&& calendarIn.get(2) + 1 == 7 && calendarIn.get(5) <= 7;
    }
	/** June 27th. */
	public static String startDateIndependenceDay()
    {
        return "6/27";
    }
	/** July 7th. */
	public static String endDateIndependenceDay()
    {
        return "7/7";
    }
	
	/** Check if October 31st is within 10 days before and 3 days after. */
	public static boolean isDateAroundHalloween(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 10 && calendarIn.get(5) >= 20 
        && calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 3;
    }
	/** October 20th. */
	public static String startDateHalloween()
    {
        return "10/20";
    }
	/** November 3rd. */
	public static String endDateHalloween()
    {
        return "11/3";
    }
	
	/** Check if November 28th is within 10 days before and 3 days after. */
	public static boolean isDateAroundThanksgiving(Calendar calendarIn)
    {
        return calendarIn.get(2) + 1 == 11 && calendarIn.get(5) >= 18 
        && calendarIn.get(2) + 1 == 11 && calendarIn.get(5) <= 30;
    }
	/** November 18th. */
	public static String startDateThanksgiving()
    {
        return "11/18";
    }
	/** November 30th. */
	public static String endDateThanksgiving()
    {
        return "11/30";
    }
	
	/** Check if December 25th is within 10 days before and 3 days after. */
	public static boolean isDateAroundChristmas(Calendar calendarIn)
    {
		return calendarIn.get(2) + 1 == 12 && calendarIn.get(5) >= 15//TODO Change back to 15! 
        && calendarIn.get(2) + 1 == 12 && calendarIn.get(5) <= 28;
    }
	/** December 15th. */
	public static String startDateChristmas()
    {
		return "12/15";
    }
	/** December 28th. */
	public static String endDateChristmas()
    {
		return "12/28";
    }
	
	//==================================================
	
	/* Used to make arrays.
	public static final ItemStack[] ITEM_DISPLAY_SYMBOL = new ItemStack[] 
	{
		new ItemStack(ItemsVM.SYMBOL_LOGOVIESMACHINES),
		new ItemStack(ItemsVM.SYMBOL_LOGOFORGE)
	};
	*/
}
