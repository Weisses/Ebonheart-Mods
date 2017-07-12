package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VCTabAirships extends CreativeTabs {
	
	public VCTabAirships(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 0);
	}
}
