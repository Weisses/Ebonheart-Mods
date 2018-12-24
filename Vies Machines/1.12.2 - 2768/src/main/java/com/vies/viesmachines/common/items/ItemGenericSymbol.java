package com.vies.viesmachines.common.items;

import net.minecraft.item.Item;

public class ItemGenericSymbol extends Item {
	
	public ItemGenericSymbol(String unlocalizedNameIn) 
	{
		ItemHelper.setItemName(this, unlocalizedNameIn);
		
		this.setMaxStackSize(1);
	}
}
