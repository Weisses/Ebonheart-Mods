package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementCreateColor extends Item {
	
	public ItemAchievementCreateColor() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_create_color");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
