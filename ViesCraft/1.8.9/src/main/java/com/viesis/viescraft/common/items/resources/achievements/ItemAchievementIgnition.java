package com.viesis.viescraft.common.items.resources.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementIgnition extends Item {
	
	public ItemAchievementIgnition() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_create_ignition");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
}
