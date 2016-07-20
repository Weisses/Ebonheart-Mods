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

public class ItemEngine extends Item {
	
	public ItemEngine() 
	{
		ItemHelper.setItemName(this, "airship_engine");
		this.setMaxStackSize(16);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(ChatFormatting.DARK_AQUA + "A Steampunk Engine that is said to");
		toolTip.add(ChatFormatting.DARK_AQUA + "deliver 200% fuel efficiency!");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
