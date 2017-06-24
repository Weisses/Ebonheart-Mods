package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class VGTabItems extends CreativeTabs {

	public VGTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("vg.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVG.gemstone_item_basic_v1, 1, 5);
	}
}
