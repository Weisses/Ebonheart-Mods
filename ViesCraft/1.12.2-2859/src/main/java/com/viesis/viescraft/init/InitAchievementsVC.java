package com.viesis.viescraft.init;

import com.viesis.viescraft.api.AdvancementVC;

public class InitAchievementsVC extends AdvancementVC {
	/**
	public static final AchievementPage achievementPageEA = new AchievementPage(Reference.MOD_NAME);
	
    public static void init()
    {
        AchievementPage.registerAchievementPage(achievementPageEA);
        
        addAchievements();
    }
    
    private static void addAchievements()
    {
    	airship_create_engine = addAchievement(AIRSHIP_CREATE_ENGINE, "airship_create_engine", -1, -2, new ItemStack(InitItemsVC.achievement_airship, 1, 0), (Achievement)null);
    	airship_create_ignition = addAchievement(AIRSHIP_CREATE_IGNITION, "airship_create_ignition", 1, -2, new ItemStack(InitItemsVC.achievement_airship, 1, 1), (Achievement)airship_create_engine);
    	airship_create = addAchievement(AIRSHIP_CREATE, "airship_create", 3, -2, new ItemStack(InitItemsVC.achievement_airship, 1, 2), (Achievement)airship_create_ignition);
    	airship_create_color = addAchievement(AIRSHIP_CREATE_COLOR, "airship_create_color", 1, 0, new ItemStack(InitItemsVC.achievement_airship, 1, 3), null).setSpecial();
    	airship_create_module = addAchievement(AIRSHIP_CREATE_MODULE, "airship_create_module", 1, -4, new ItemStack(InitItemsVC.achievement_airship, 1, 4), (Achievement)null);
    	
    	airship_airborn = addAchievement(AIRSHIP_AIRBORN, "airship_airborn", 1, 2, new ItemStack(InitItemsVC.achievement_airship, 1, 5), (Achievement)null);
    	airship_water = addAchievement(AIRSHIP_WATER, "airship_water", -1, 3, new ItemStack(InitItemsVC.achievement_airship, 1, 6), (Achievement)airship_airborn).setSpecial();
    	airship_lava = addAchievement(AIRSHIP_LAVA, "airship_lava", 3, 3, new ItemStack(InitItemsVC.achievement_airship, 1, 7), (Achievement)airship_airborn).setSpecial();
    }
    
    private static Achievement addAchievement(String unlocalizedName, String identifier, int column, int row, ItemStack iconStack, Achievement parent)
    {
        Achievement achievement = new Achievement(unlocalizedName, Reference.MOD_ID + ":" + identifier, column, row, iconStack, parent);
        achievement.registerStat();
        achievementPageEA.getAchievements().add(achievement);
        return achievement;
    }*/
}
