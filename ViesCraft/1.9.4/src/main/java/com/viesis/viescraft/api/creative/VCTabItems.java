package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.viesis.viescraft.init.InitItemsEA;

public class VCTabItems extends CreativeTabs {

	public VCTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}

	@Override
	public Item getTabIconItem() 
	{
		return InitItemsEA.viesdenburg;
	}
}
