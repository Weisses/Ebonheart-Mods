package com.viesis.viescraft.common.items.achievements;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.items.ItemHelper;

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