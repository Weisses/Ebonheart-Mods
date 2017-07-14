package com.viesis.viescraft.api;

import java.util.Random;

import net.minecraft.util.ResourceLocation;

public class Reference {
	
	public static final String MOD_ID = "vc";
	public static final String MOD_ID_COLON = MOD_ID + ":";
	public static final String MOD_NAME = "ViesCraft";
	public static final String MOD_VERSION = "5.0.6";
	public static final String CONFIG_GUI = "com.viesis.viescraft.api.gui.VCGuiFactory";
	public static final String CLIENT_PROXY_CLASS = "com.viesis.viescraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.viesis.viescraft.proxy.ServerProxy";
	
	public static Random random = new Random();
	
	/**
	 * Used in Rendering Airship textures.
	 */
	public static final ResourceLocation[] ENTITY_BALLOON_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_plain.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_plain_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_plain_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_checker.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_checker_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_checker_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_polkadot.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_polkadot_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_polkadot_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_zigzag.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_zigzag_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_zigzag_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_creeper.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_creeper_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_creeper_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_water.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_water_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_water_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_lava.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_lava_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_lava_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_ender.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_ender_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_ender_phantom.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_tools.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_tools_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_tools_phantom.png")
	};
	
	/**
	 * Used in Rendering Airship textures.
	 */
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
	};
}
