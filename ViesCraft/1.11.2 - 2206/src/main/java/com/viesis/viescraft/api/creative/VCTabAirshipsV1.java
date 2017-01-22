package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.init.InitItemsVC;

public class VCTabAirshipsV1 extends CreativeTabs {
	
	public VCTabAirshipsV1(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.item_airship_v1, 1, 0);
	}
}
