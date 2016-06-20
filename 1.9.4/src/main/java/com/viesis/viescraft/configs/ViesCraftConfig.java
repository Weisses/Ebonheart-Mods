package com.viesis.viescraft.configs;

import com.viesis.viescraft.ViesCraft;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

public class ViesCraftConfig 
{

	public static boolean horseRecipe;
	public static boolean vanillaRecipe;
	public static boolean toolRecipe;
	public static boolean weaponRecipe;
	public static boolean armorRecipe;
	public static boolean armorParticle;
	public static boolean musicRecipe;
	public static boolean plantParticle;
	public static boolean decraftRecipe1;
	//public static boolean decraftRecipe2;
	public static final boolean HORSERECIPE_DEFAULT = false;
	public static final String HORSERECIPE_NAME = "Disable crafting Horse Armor/Saddles?";
	public static final boolean VANILLARECIPE_DEFAULT = false;
	public static final String VANILLARECIPE_NAME = "Disable crafting special vanilla items?";
	public static final boolean TOOLRECIPE_DEFAULT = false;
	public static final String TOOLRECIPE_NAME = "Disable crafting Mod Tools?";
	public static final boolean WEAPONRECIPE_DEFAULT = false;
	public static final String WEAPONRECIPE_NAME = "Disable crafting Mod Weapons?";
	public static final boolean ARMORRECIPE_DEFAULT = false;
	public static final String ARMORRECIPE_NAME = "Disable crafting Mod Armor?";
	public static final boolean ARMORANIMATION_DEFAULT = false;
	public static final String ARMORANIMATION_NAME = "Disable Mod Armor Particles?";
	public static final boolean MUSICRECIPE_DEFAULT = false;
	public static final String MUSICRECIPE_NAME = "Disable crafting Music Discs?";
	public static final boolean PLANTANIMATION_DEFAULT = false;
	public static final String PLANTANIMATION_NAME = "Disable Mod Crop Particles?";
	public static final boolean DECRAFTRECIPE1_DEFAULT = false;
	public static final String DECRAFTRECIPE1_NAME = "Disable decrafting Mod Items?";
	
	//public static final boolean DECRAFTRECIPE2_DEFAULT = false;
	//public static final String DECRAFTRECIPE2_NAME = "Disable decrafting Vanilla Items?";
	
	public static void syncConfig()
	{
		
		MinecraftForge.EVENT_BUS.register(ViesCraft.instance);
		
		//FMLCommonHandler.instance().bus().register(ViesCraft.instance);
		
		//actual config
		final String RECIPES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.GREEN + "Recipes";
		final String PARTICLES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Particles";
		
		ViesCraft.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item and block recipes.");
		weaponRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
		armorRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + ARMORRECIPE_NAME, ARMORRECIPE_DEFAULT).getBoolean(ARMORRECIPE_DEFAULT);
		toolRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + TOOLRECIPE_NAME, TOOLRECIPE_DEFAULT).getBoolean(TOOLRECIPE_DEFAULT);
		decraftRecipe1 = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + DECRAFTRECIPE1_NAME, DECRAFTRECIPE1_DEFAULT).getBoolean(DECRAFTRECIPE1_DEFAULT);
		
		vanillaRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + VANILLARECIPE_NAME, VANILLARECIPE_DEFAULT).getBoolean(VANILLARECIPE_DEFAULT);
		horseRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + HORSERECIPE_NAME, HORSERECIPE_DEFAULT).getBoolean(HORSERECIPE_DEFAULT);
		musicRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + MUSICRECIPE_NAME, MUSICRECIPE_DEFAULT).getBoolean(MUSICRECIPE_DEFAULT);
		
		
		//decraftRecipe2 = ViesCraft.config.get(RECIPES, DECRAFTRECIPE2_NAME, DECRAFTRECIPE2_DEFAULT).getBoolean(DECRAFTRECIPE2_DEFAULT);
		
		
		ViesCraft.config.addCustomCategoryComment(PARTICLES, "Enable or disable mod armor animations.");
		armorParticle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + ARMORANIMATION_NAME, ARMORANIMATION_DEFAULT).getBoolean(ARMORANIMATION_DEFAULT);
		plantParticle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + PLANTANIMATION_NAME, PLANTANIMATION_DEFAULT).getBoolean(PLANTANIMATION_DEFAULT);
		
		//saves the config
		if(ViesCraft.config.hasChanged())
		{
			ViesCraft.config.save();
		}
	}
}
