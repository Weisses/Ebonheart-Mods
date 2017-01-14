package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class VCTabAirshipsV4 extends CreativeTabs {
	
	public VCTabAirshipsV4(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return InitItemsVC.item_airship_v4_wood0;
	}
}
