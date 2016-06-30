package com.viesis.viescraft.api.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.stats.StatisticsManager;

public class AchieveGui extends GuiAchievements {
	
	public AchieveGui(GuiScreen parentScreenIn, StatisticsManager statFileWriterIn) 
	{
		super(parentScreenIn, statFileWriterIn);
	}
}
