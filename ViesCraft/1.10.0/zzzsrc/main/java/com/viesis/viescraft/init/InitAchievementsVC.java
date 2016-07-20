package com.viesis.viescraft.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.viesis.viescraft.api.AchievementsVC;
import com.viesis.viescraft.api.Reference;

public class InitAchievementsVC extends AchievementsVC {
	
	public static final AchievementPage achievementPageEA = new AchievementPage(Reference.MOD_NAME);
	
    public static void init()
    {
        AchievementPage.registerAchievementPage(achievementPageEA);
        
        addAchievements();
    }
    
    private static void addAchievements()
    {
    	airship_create = addAchievement(AIRSHIP_CREATE, "airship_create", 1, 0, new ItemStack(InitItemsVC.achievement_airship_create), (Achievement)null);
    	airship_airborn = addAchievement(AIRSHIP_AIRBORN, "airship_airborn", 1, 2, new ItemStack(InitItemsVC.achievement_airship_airborn), (Achievement)airship_create);
    	airship_water = addAchievement(AIRSHIP_WATER, "airship_water", -1, 3, new ItemStack(InitItemsVC.achievement_airship_water), (Achievement)airship_airborn).setSpecial();
    	airship_lava = addAchievement(AIRSHIP_LAVA, "airship_lava", 3, 3, new ItemStack(InitItemsVC.achievement_airship_lava), (Achievement)airship_airborn).setSpecial();
    	
    }
    
    
    private static Achievement addAchievement(String unlocalizedName, String identifier, int column, int row, ItemStack iconStack, Achievement parent)
    {
        Achievement achievement = new Achievement(unlocalizedName, Reference.MOD_ID + ":" + identifier, column, row, iconStack, parent);
        achievement.registerStat();
        achievementPageEA.getAchievements().add(achievement);
        return achievement;
    }
}
