package com.viesis.gemstones.common.items.zzzTEMP.resources;

import java.util.List;

import com.viesis.gemstones.common.items.ItemHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCryptic extends Item {
	
	public ItemCryptic(String unlocalizedName) 
	{
		ItemHelper.setItemName(this, unlocalizedName);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA +  "Red flames imbue this gemstone.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
}
