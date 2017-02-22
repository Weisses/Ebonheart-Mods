package com.viesis.viescraft.api;

import java.util.Random;

import net.minecraft.util.ResourceLocation;

public class Reference {
	
	public static final String MOD_ID = "vc";
	public static final String MOD_ID_COLON = MOD_ID + ":";
	public static final String MOD_NAME = "ViesCraft";
	public static final String MOD_VERSION = "4.13.0";
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
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_checker.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_checker_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_polkadot.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_polkadot_colorized.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_zigzag.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/patterns/airship_pattern_zigzag_colorized.png")
	};
	
	/**
	 * Used in Rendering Airship textures.
	 */
	public static final ResourceLocation[] ENTITY_FRAME_TEXTURE = new ResourceLocation[] 
	{
		//Common
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood0.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood1.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood2.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood3.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood4.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood5.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_sandstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_brick.png"),
		
		//Uncommon
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_bone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_iron.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_redstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_gold.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_lapislazuli.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_slime.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_mycelium.png"),
		
		//Rare
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_netherbrick.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_soulsand.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_quartz.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_ice.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_glowstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_obsidian.png"),
		
		//Epic
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_diamond.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_emerald.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_prismarine.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_purpur.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_netherstar.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_mythic.png")
	};
	
	/**
	 * Used in Rendering Airship textures.
	 */
	public static final ResourceLocation[] ENTITY_SCREEN_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/no_module.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_small.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_large.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_minor.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_major.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_fuel_infinite.png")
	};
	
}
