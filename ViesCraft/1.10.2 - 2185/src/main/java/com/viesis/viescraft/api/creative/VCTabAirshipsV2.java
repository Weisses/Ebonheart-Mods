package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.init.InitItemsVC;

public class VCTabAirshipsV2 extends CreativeTabs {
	
	public VCTabAirshipsV2(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.item_airship_v2, 1, 0).getItem();
	}
}
