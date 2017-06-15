package com.ebonheart.EbonArtsMod.common.utils.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ebonheart.EbonArtsMod.init.InitItemsEA;

public class EbonArtsTabItems extends CreativeTabs {

	public EbonArtsTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	public Item getTabIconItem() 
	{
		return InitItemsEA.necrocite;
	}
}
