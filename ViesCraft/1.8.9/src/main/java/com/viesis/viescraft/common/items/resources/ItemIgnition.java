package com.viesis.viescraft.common.items.resources;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.mojang.realmsclient.gui.ChatFormatting;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemIgnition extends Item {
	
	public ItemIgnition() 
	{
		ItemHelper.setItemName(this, "airship_ignition");
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(ChatFormatting.DARK_AQUA + "The heart of the airship! Travel to");
		toolTip.add(ChatFormatting.DARK_AQUA + "different chunks in mere minutes!");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
