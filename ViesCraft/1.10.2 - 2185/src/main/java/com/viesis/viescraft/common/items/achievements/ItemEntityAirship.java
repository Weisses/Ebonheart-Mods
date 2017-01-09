package com.viesis.viescraft.common.items.achievements;

import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEntityAirship extends Item {
	
	public ItemEntityAirship() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_portal");
		
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return ("Icon - Portal");
    }
}