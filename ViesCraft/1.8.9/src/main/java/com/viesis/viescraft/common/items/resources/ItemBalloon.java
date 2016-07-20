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

public class ItemBalloon extends Item {
	
	public ItemBalloon() 
	{
		ItemHelper.setItemName(this, "airship_balloon");
		this.setMaxStackSize(64);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(ChatFormatting.GOLD + "Leather that has been processed");
		toolTip.add(ChatFormatting.GOLD + "to create a durable balloon.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}
