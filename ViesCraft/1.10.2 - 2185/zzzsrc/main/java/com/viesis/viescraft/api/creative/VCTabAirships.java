package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VCTabAirships extends CreativeTabs {
	
	public VCTabAirships(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.item_airship_v1, 1, 0).getItem();
	}
}
