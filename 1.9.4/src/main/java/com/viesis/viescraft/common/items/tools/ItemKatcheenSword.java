package com.viesis.viescraft.common.items.tools;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitItemsEA;

public class ItemKatcheenSword extends ItemSword {
	
	public ItemKatcheenSword(ToolMaterial material) 
	{
		super(material);
		ItemHelper.setItemName(this, "tool/katcheen_sword");
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return InitItemsEA.katcheen == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.RARE;
    }
	
}
