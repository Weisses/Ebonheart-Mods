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
    	airship_create = addAchievement(AIRSHIP_CREATE, "airship_create", 1, 0, new ItemStack(InitItemsVC.item_viesdenburg), (Achievement)null).setSpecial();
    	airship_water = addAchievement(AIRSHIP_WATER, "airship_water", 3, 0, new ItemStack(InitItemsVC.item_viesdenburg), (Achievement)null);
    	
    	
    }
    
    
    private static Achievement addAchievement(String unlocalizedName, String identifier, int column, int row, ItemStack iconStack, Achievement parent)
    {
        Achievement achievement = new Achievement(unlocalizedName, Reference.MOD_ID + ":" + identifier, column, row, iconStack, parent);
        achievement.registerStat();
        achievementPageEA.getAchievements().add(achievement);
        return achievement;
    }
}
