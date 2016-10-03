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

public class ItemInventoryModuleLarge extends Item {
	
	public ItemInventoryModuleLarge() 
	{
		ItemHelper.setItemName(this, "module_inventory_large");
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "2Turn an airship into a mobile 12 slot");
		toolTip.add(TextFormatting.DARK_AQUA + "chest.");
		
		//toolTip.add(TextFormatting.DARK_AQUA + "The heart of the airship! Travel to");
		//toolTip.add(TextFormatting.DARK_AQUA + "different chunks in mere minutes!");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
