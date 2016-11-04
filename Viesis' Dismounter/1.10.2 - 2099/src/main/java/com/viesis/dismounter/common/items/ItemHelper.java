package com.viesis.dismounter.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHelper extends Item {
	
	public ItemHelper(String itemName) 
	{
		setItemName(this, itemName);
	}
	
	public static void setItemName(Item item, String itemName) 
	{
		item.setRegistryName(itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
		item.setCreativeTab(CreativeTabs.TRANSPORTATION);
	}
}
