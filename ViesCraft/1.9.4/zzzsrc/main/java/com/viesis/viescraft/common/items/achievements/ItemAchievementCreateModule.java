package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementCreateModule extends Item {
	
	public ItemAchievementCreateModule() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_create_module");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
