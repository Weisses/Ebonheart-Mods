package com.viesis.viescraft.common.items.achievements;

import net.minecraft.item.Item;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementPortal extends Item {
	
	public ItemAchievementPortal() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_portal");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
}
