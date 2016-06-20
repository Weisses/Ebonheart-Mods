package com.viesis.viescraft.common.items;

import com.viesis.viescraft.ViesCraft;

import net.minecraft.item.Item;

public class ItemHelper extends Item {

	public ItemHelper(String itemName) 
	{
		setItemName(this, itemName);
		
	}

	//Set the registry name of {@code block} to {@code blockName} 
	//and the unlocalised name to the full registry name.
	public static void setItemName(Item item, String itemName) 
	{
		item.setRegistryName(itemName);
		item.setUnlocalizedName(item.getRegistryName().toString());
		item.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
}
