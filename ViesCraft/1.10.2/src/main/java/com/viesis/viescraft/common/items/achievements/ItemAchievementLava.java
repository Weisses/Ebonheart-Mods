package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementLava extends Item {
	
	public ItemAchievementLava() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_lava");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
