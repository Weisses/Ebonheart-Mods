package com.ebonheart.EbonArtsMod.api.creativeTab;

import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EbonArtsTabItems extends CreativeTabs {

	public EbonArtsTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsEA.gemstone_item_basic_v1, 1, 5);
	}
}
