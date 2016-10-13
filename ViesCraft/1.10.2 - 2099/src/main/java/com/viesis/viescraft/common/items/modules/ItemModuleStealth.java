package com.viesis.viescraft.common.items.modules;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.items.ItemHelper;

public class ItemModuleStealth extends Item {
	
	public ItemModuleStealth() 
	{
		ItemHelper.setItemName(this, "module_stealth");
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(" ");
		toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
		toolTip.add(TextFormatting.GREEN + "Pro - Fly without fuel.");
		toolTip.add(TextFormatting.RED + "Con - Speed reduced to 50%");
		toolTip.add(" ");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
