package com.ebonheart.EbonArtsMod.configs;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.init.InitRecipesEA;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EbonArtsConfiguration 
{
/**
	public static int draconiumValueVein;
	public static int veliousValueVein;
	public static int arcaniteValueVein;
	public static int katcheenValueVein;
	public static int necrociteValueVein;
	public static int soulariteValueVein;
	public static int ebonheartValueVein;
*/
	public static int draconiumValueChunk;
	public static int veliousValueChunk;
	public static int arcaniteValueChunk;
	public static int katcheenValueChunk;
	public static int necrociteValueChunk;
	public static int soulariteValueChunk;
	public static int ebonheartValueChunk;
	public static int necrociteEndValueChunk;
	public static int soulariteEndValueChunk;
	public static int ebonheartEndValueChunk;
	
	public static boolean armorWeaponDifficult;
	public static boolean horseRecipe;
	public static boolean vanillaRecipe;
	public static boolean toolRecipe;
	public static boolean weaponRecipe;
	public static boolean armorRecipe;
	public static boolean armorParticle;
	public static boolean musicRecipe;
	public static boolean plantParticle;
	public static boolean decraftRecipe1;
	public static boolean storageRecipe;
	//public static boolean decraftRecipe2;
	/**
	public static final int DRACONIUMVALUEVEIN_DEFAULT = 8;
	public static final String DRACONIUMVALUEVEIN_NAME = "Max vein size for Draconium Ore.";
	
	public static final int VELIOUSVALUEVEIN_DEFAULT = 6;
	public static final String VELIOUSVALUEVEIN_NAME = "Max vein size for Velious Ore.";
	
	public static final int ARCANITEVALUEVEIN_DEFAULT = 5;
	public static final String ARCANITEVALUEVEIN_NAME = "Max vein size for Arcanite Ore.";
	
	public static final int KATCHEENVALUEVEIN_DEFAULT = 4;
	public static final String KATCHEENVALUEVEIN_NAME = "Max vein size for Katcheen Ore.";
	
	public static final int NECROCITEVALUEVEIN_DEFAULT = 3;
	public static final String NECROCITEVALUEVEIN_NAME = "Max vein size for Necrocite Ore.";
	
	public static final int SOULARITEVALUEVEIN_DEFAULT = 3;
	public static final String SOULARITEVALUEVEIN_NAME = "Max vein size for Soularite Ore.";
	
	public static final int EBONHEARTVALUEVEIN_DEFAULT = 3;
	public static final String EBONHEARTVALUEVEIN_NAME = "Max vein size for Ebonheart Ore.";
	*/
	
	
	public static final int DRACONIUMVALUECHUNK_DEFAULT = 16;
	public static final String DRACONIUMVALUECHUNK_NAME = "01) Draconium Ore density?";
	public static final String DRACONIUMVALUECHUNK_COMMENT = "Draconium Ore veins per chunk.";
	
	public static final int VELIOUSVALUECHUNK_DEFAULT = 8;
	public static final String VELIOUSVALUECHUNK_NAME = "02) Velious Ore density?";
	public static final String VELIOUSVALUECHUNK_COMMENT = "Velious Ore veins per chunk.";
	
	public static final int ARCANITEVALUECHUNK_DEFAULT = 6;
	public static final String ARCANITEVALUECHUNK_NAME = "03) Arcanite Ore density?";
	public static final String ARCANITEVALUECHUNK_COMMENT = "Arcanite Ore veins per chunk.";
	
	public static final int KATCHEENVALUECHUNK_DEFAULT = 3;
	public static final String KATCHEENVALUECHUNK_NAME = "04) Katcheen Ore density?";
	public static final String KATCHEENVALUECHUNK_COMMENT = "Katcheen Ore veins per chunk.";
	
	public static final int NECROCITEVALUECHUNK_DEFAULT = 32;
	public static final String NECROCITEVALUECHUNK_NAME = "05) Nether Necrocite Ore density?";
	public static final String NECROCITEVALUECHUNK_COMMENT = "Necrocite Ore veins per chunk.";
	
	public static final int SOULARITEVALUECHUNK_DEFAULT = 32;
	public static final String SOULARITEVALUECHUNK_NAME = "06) Nether Soularite Ore density?";
	public static final String SOULARITEVALUECHUNK_COMMENT = "Soularite Ore veins per chunk.";
	
	public static final int EBONHEARTVALUECHUNK_DEFAULT = 32;
	public static final String EBONHEARTVALUECHUNK_NAME = "07) Nether Ebonheart Ore density?";
	public static final String EBONHEARTVALUECHUNK_COMMENT = "Ebonheart Ore veins per chunk.";
	
	public static final int NECROCITEENDVALUECHUNK_DEFAULT = 32;
	public static final String NECROCITEENDVALUECHUNK_NAME = "08) End Necrocite Ore density?";
	public static final String NECROCITEENDVALUECHUNK_COMMENT = "Necrocite End Ore veins per chunk.";
	
	public static final int SOULARITEENDVALUECHUNK_DEFAULT = 32;
	public static final String SOULARITEENDVALUECHUNK_NAME = "09) End Soularite Ore density?";
	public static final String SOULARITEENDVALUECHUNK_COMMENT = "Soularite End Ore veins per chunk.";
	
	public static final int EBONHEARTENDVALUECHUNK_DEFAULT = 32;
	public static final String EBONHEARTENDVALUECHUNK_NAME = "10) End Ebonheart Ore density?";
	public static final String EBONHEARTENDVALUECHUNK_COMMENT = "Ebonheart End Ore veins per chunk.";
	
	
	public static final boolean ARMORWEAPONDIFFICULT_DEFAULT = false;
	public static final String ARMORWEAPONDIFFICULT_NAME = "Disable dense gem use for Weapons/Armor?";
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
	public static final boolean STORAGERECIPE_DEFAULT = false;
	public static final String STORAGERECIPE_NAME = "Disable Storage Mod Items?";
	
	//public static final boolean DECRAFTRECIPE2_DEFAULT = false;
	//public static final String DECRAFTRECIPE2_NAME = "Disable decrafting Vanilla Items?";
	
	public static void syncConfig()
	{
		
		MinecraftForge.EVENT_BUS.register(EbonArtsMod.instance);
		
		//FMLCommonHandler.instance().bus().register(EbonArtsMod.instance);
		
		//actual config
		final String RECIPES = EbonArtsMod.config.CATEGORY_GENERAL + EbonArtsMod.config.CATEGORY_SPLITTER + TextFormatting.GREEN + "Recipes";
		final String PARTICLES = EbonArtsMod.config.CATEGORY_GENERAL + EbonArtsMod.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Particles";
		final String WORLDGEN = EbonArtsMod.config.CATEGORY_GENERAL + EbonArtsMod.config.CATEGORY_SPLITTER + TextFormatting.YELLOW + "World Gen";
		
		EbonArtsMod.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item and block recipes.");
		armorWeaponDifficult = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + ARMORWEAPONDIFFICULT_NAME, ARMORWEAPONDIFFICULT_DEFAULT).getBoolean(ARMORWEAPONDIFFICULT_DEFAULT);
		
		//weaponRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
		//armorRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + ARMORRECIPE_NAME, ARMORRECIPE_DEFAULT).getBoolean(ARMORRECIPE_DEFAULT);
		//toolRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + TOOLRECIPE_NAME, TOOLRECIPE_DEFAULT).getBoolean(TOOLRECIPE_DEFAULT);
		decraftRecipe1 = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + DECRAFTRECIPE1_NAME, DECRAFTRECIPE1_DEFAULT).getBoolean(DECRAFTRECIPE1_DEFAULT);
		
		vanillaRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + VANILLARECIPE_NAME, VANILLARECIPE_DEFAULT).getBoolean(VANILLARECIPE_DEFAULT);
		horseRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + HORSERECIPE_NAME, HORSERECIPE_DEFAULT).getBoolean(HORSERECIPE_DEFAULT);
		musicRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + MUSICRECIPE_NAME, MUSICRECIPE_DEFAULT).getBoolean(MUSICRECIPE_DEFAULT);
		
		storageRecipe = EbonArtsMod.config.get(RECIPES, TextFormatting.GREEN + STORAGERECIPE_NAME, STORAGERECIPE_DEFAULT).getBoolean(STORAGERECIPE_DEFAULT);
		
		//decraftRecipe2 = EbonArtsMod.config.get(RECIPES, DECRAFTRECIPE2_NAME, DECRAFTRECIPE2_DEFAULT).getBoolean(DECRAFTRECIPE2_DEFAULT);
		
		
		EbonArtsMod.config.addCustomCategoryComment(PARTICLES, "Enable or disable mod armor animations.");
		armorParticle = EbonArtsMod.config.get(PARTICLES, TextFormatting.AQUA + ARMORANIMATION_NAME, ARMORANIMATION_DEFAULT).getBoolean(ARMORANIMATION_DEFAULT);
		plantParticle = EbonArtsMod.config.get(PARTICLES, TextFormatting.AQUA + PLANTANIMATION_NAME, PLANTANIMATION_DEFAULT).getBoolean(PLANTANIMATION_DEFAULT);
		
		
		EbonArtsMod.config.addCustomCategoryComment(WORLDGEN, "Adjust resource world generation weight.");
		
		//draconiumValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + DRACONIUMVALUEVEIN_NAME, DRACONIUMVALUEVEIN_DEFAULT).getInt(DRACONIUMVALUEVEIN_DEFAULT);
		////draconiumValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + DRACONIUMVALUECHUNK_NAME, DRACONIUMVALUECHUNK_DEFAULT).getInt(DRACONIUMVALUECHUNK_DEFAULT);
		
		//veliousValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + VELIOUSVALUEVEIN_NAME, VELIOUSVALUEVEIN_DEFAULT).getInt(VELIOUSVALUEVEIN_DEFAULT);
		////veliousValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + VELIOUSVALUECHUNK_NAME, VELIOUSVALUECHUNK_DEFAULT).getInt(VELIOUSVALUECHUNK_DEFAULT);
		
		//arcaniteValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + ARCANITEVALUEVEIN_NAME, ARCANITEVALUEVEIN_DEFAULT).getInt(ARCANITEVALUEVEIN_DEFAULT);
		////arcaniteValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + ARCANITEVALUECHUNK_NAME, ARCANITEVALUECHUNK_DEFAULT).getInt(ARCANITEVALUECHUNK_DEFAULT);
		
		//katcheenValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + KATCHEENVALUEVEIN_NAME, KATCHEENVALUEVEIN_DEFAULT).getInt(KATCHEENVALUEVEIN_DEFAULT);
		////katcheenValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + KATCHEENVALUECHUNK_NAME, KATCHEENVALUECHUNK_DEFAULT).getInt(KATCHEENVALUECHUNK_DEFAULT);
		
		//necrociteValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + NECROCITEVALUEVEIN_NAME, NECROCITEVALUEVEIN_DEFAULT).getInt(NECROCITEVALUEVEIN_DEFAULT);
		////necrociteValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + NECROCITEVALUECHUNK_NAME, NECROCITEVALUECHUNK_DEFAULT).getInt(NECROCITEVALUECHUNK_DEFAULT);
		
		//soulariteValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + SOULARITEVALUEVEIN_NAME, SOULARITEVALUEVEIN_DEFAULT).getInt(SOULARITEVALUEVEIN_DEFAULT);
		////soulariteValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + SOULARITEVALUECHUNK_NAME, SOULARITEVALUECHUNK_DEFAULT).getInt(SOULARITEVALUECHUNK_DEFAULT);
		
		//ebonheartValueVein = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + EBONHEARTVALUEVEIN_NAME, EBONHEARTVALUEVEIN_DEFAULT).getInt(EBONHEARTVALUEVEIN_DEFAULT);
		////ebonheartValueChunk = EbonArtsMod.config.get(WORLDGEN, TextFormatting.YELLOW + EBONHEARTVALUECHUNK_NAME, EBONHEARTVALUECHUNK_DEFAULT).getInt(EBONHEARTVALUECHUNK_DEFAULT);

		draconiumValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + DRACONIUMVALUECHUNK_NAME, WORLDGEN, DRACONIUMVALUECHUNK_DEFAULT, 1, 64, DRACONIUMVALUECHUNK_COMMENT);
		veliousValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + VELIOUSVALUECHUNK_NAME, WORLDGEN, VELIOUSVALUECHUNK_DEFAULT, 1, 64, VELIOUSVALUECHUNK_COMMENT);
		arcaniteValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + ARCANITEVALUECHUNK_NAME, WORLDGEN, ARCANITEVALUECHUNK_DEFAULT, 1, 64, ARCANITEVALUECHUNK_COMMENT);
		katcheenValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + KATCHEENVALUECHUNK_NAME, WORLDGEN, KATCHEENVALUECHUNK_DEFAULT, 1, 64, KATCHEENVALUECHUNK_COMMENT);
		necrociteValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + NECROCITEVALUECHUNK_NAME, WORLDGEN, NECROCITEVALUECHUNK_DEFAULT, 1, 64, NECROCITEVALUECHUNK_COMMENT);
		soulariteValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + SOULARITEVALUECHUNK_NAME, WORLDGEN, SOULARITEVALUECHUNK_DEFAULT, 1, 64, SOULARITEVALUECHUNK_COMMENT);
		ebonheartValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + EBONHEARTVALUECHUNK_NAME, WORLDGEN, EBONHEARTVALUECHUNK_DEFAULT, 1, 64, EBONHEARTVALUECHUNK_COMMENT);
		necrociteEndValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + NECROCITEENDVALUECHUNK_NAME, WORLDGEN, NECROCITEENDVALUECHUNK_DEFAULT, 1, 64, NECROCITEENDVALUECHUNK_COMMENT);
		soulariteEndValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + SOULARITEENDVALUECHUNK_NAME, WORLDGEN, SOULARITEENDVALUECHUNK_DEFAULT, 1, 64, SOULARITEENDVALUECHUNK_COMMENT);
		ebonheartEndValueChunk = EbonArtsMod.config.getInt(TextFormatting.YELLOW + EBONHEARTENDVALUECHUNK_NAME, WORLDGEN, EBONHEARTENDVALUECHUNK_DEFAULT, 1, 64, EBONHEARTENDVALUECHUNK_COMMENT);
		
		
		//saves the config
		if(EbonArtsMod.config.hasChanged())
		{
			EbonArtsMod.config.save();
		}
	}
}
