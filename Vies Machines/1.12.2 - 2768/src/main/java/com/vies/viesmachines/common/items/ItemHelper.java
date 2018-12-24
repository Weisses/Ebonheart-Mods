package com.vies.viesmachines.common.items;

import net.minecraft.item.Item;

public class ItemHelper extends Item {
	
	public ItemHelper(String itemNameIn) 
	{
		this.setItemName(this, itemNameIn);
	}
	
	public static void setItemName(Item itemIn, String itemNameIn) 
	{
		itemIn.setRegistryName(itemNameIn);
		itemIn.setUnlocalizedName(itemIn.getRegistryName().toString());
	}
}
