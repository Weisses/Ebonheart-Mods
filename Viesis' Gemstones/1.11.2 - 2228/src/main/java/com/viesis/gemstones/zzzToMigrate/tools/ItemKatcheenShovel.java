package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.tools;

import com.ebonheart.EbonArtsMod.EbonArts;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemKatcheenShovel extends ItemSpade {
	
	public ItemKatcheenShovel(ToolMaterial material) 
	{
		super(material);
		ItemHelper.setItemName(this, "tool/katcheen_shovel");
	}
	
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return InitItemsVG.katcheen == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
}
