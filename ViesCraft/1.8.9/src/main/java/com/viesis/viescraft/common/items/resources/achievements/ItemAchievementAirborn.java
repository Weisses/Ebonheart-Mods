package com.viesis.viescraft.common.items.resources.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementAirborn extends Item {
	
	public ItemAchievementAirborn() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_airborn");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
}
