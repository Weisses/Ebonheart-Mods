package com.viesis.viescraft.configs;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.client.InitEntityVCRender;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ViesCraftConfig 
{
	public static boolean toolRecipe;
	public static boolean modelAnimation;
	
	public static final boolean TOOLRECIPE_DEFAULT = false;
	public static final String TOOLRECIPE_NAME = "Coming soon.";
	public static final boolean MODELANIMATION_DEFAULT = true;
	public static final String MODELANIMATION_NAME = "Enable Airship Animation?";
	
	public static void syncConfig()
	{
		
		MinecraftForge.EVENT_BUS.register(ViesCraft.instance);
		
		//actual config
		//final String RECIPES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.GREEN + "Recipes";
		final String PARTICLES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
		
		//ViesCraft.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item recipes.");
		//weaponRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
		//armorRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + ARMORRECIPE_NAME, ARMORRECIPE_DEFAULT).getBoolean(ARMORRECIPE_DEFAULT);
		//toolRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + TOOLRECIPE_NAME, TOOLRECIPE_DEFAULT).getBoolean(TOOLRECIPE_DEFAULT);
		//decraftRecipe1 = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + DECRAFTRECIPE1_NAME, DECRAFTRECIPE1_DEFAULT).getBoolean(DECRAFTRECIPE1_DEFAULT);
		
		//vanillaRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + VANILLARECIPE_NAME, VANILLARECIPE_DEFAULT).getBoolean(VANILLARECIPE_DEFAULT);
		//horseRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + HORSERECIPE_NAME, HORSERECIPE_DEFAULT).getBoolean(HORSERECIPE_DEFAULT);
		//musicRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + MUSICRECIPE_NAME, MUSICRECIPE_DEFAULT).getBoolean(MUSICRECIPE_DEFAULT);
		
		
		//decraftRecipe2 = ViesCraft.config.get(RECIPES, DECRAFTRECIPE2_NAME, DECRAFTRECIPE2_DEFAULT).getBoolean(DECRAFTRECIPE2_DEFAULT);
		
		
		ViesCraft.config.addCustomCategoryComment(PARTICLES, "Enable or disable airship animation.");
		modelAnimation = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELANIMATION_NAME, MODELANIMATION_DEFAULT).getBoolean(MODELANIMATION_DEFAULT);
		//plantParticle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + PLANTANIMATION_NAME, PLANTANIMATION_DEFAULT).getBoolean(PLANTANIMATION_DEFAULT);
		
		
	}
}
