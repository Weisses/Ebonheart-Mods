package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementEngine extends Item {
	
	public ItemAchievementEngine() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_create_engine");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
