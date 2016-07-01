package com.viesis.viescraft.common.items.resources.achievements;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAchievementAirborn extends Item {
	
	public ItemAchievementAirborn() 
	{
		ItemHelper.setItemName(this, "achievements/achievement_airship_airborn");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
}
