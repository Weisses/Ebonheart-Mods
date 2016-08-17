package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementWater extends Item {
	
	public ItemAchievementWater() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_water");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
