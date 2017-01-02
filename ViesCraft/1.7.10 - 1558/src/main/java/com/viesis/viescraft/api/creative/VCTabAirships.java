package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.viesis.viescraft.init.InitItemsVC;

public class VCTabAirships extends CreativeTabs {
	
	public VCTabAirships(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return InitItemsVC.achievement_airship_airborn;
	}
}
