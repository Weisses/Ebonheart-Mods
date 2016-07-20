package com.viesis.viescraft.common.items.resources.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementCreate extends Item {
	
	public ItemAchievementCreate() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_create");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
}
