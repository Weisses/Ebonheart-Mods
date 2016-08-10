package com.viesis.viescraft.configs;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

import com.viesis.viescraft.ViesCraft;

public class ViesCraftConfig {
	
	public static boolean toolRecipe;
	public static boolean modelAnimation;
	public static boolean modelTurnAngle;
	
	public static final boolean TOOLRECIPE_DEFAULT = false;
	public static final String TOOLRECIPE_NAME = "Coming soon.";
	public static final boolean MODELANIMATION_DEFAULT = true;
	public static final String MODELANIMATION_NAME = "Enable Airship Animation?";
	public static final boolean MODELTURNANGLE_DEFAULT = true;
	public static final String MODELTURNANGLE_NAME = "Enable Airship Turning Tilt?";
	
	public static void syncConfig()
	{
		MinecraftForge.EVENT_BUS.register(ViesCraft.instance);
		
		//actual config
		final String PARTICLES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
		//ViesCraft.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item recipes.");
		//weaponRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
		
		ViesCraft.config.addCustomCategoryComment(PARTICLES, "Enable or disable airship animation.");
		modelAnimation = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELANIMATION_NAME, MODELANIMATION_DEFAULT).getBoolean(MODELANIMATION_DEFAULT);
		modelTurnAngle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELTURNANGLE_NAME, MODELTURNANGLE_DEFAULT).getBoolean(MODELTURNANGLE_DEFAULT);
	}
}
