package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.init.InitItemsVC;

public class VCTabBlocks extends CreativeTabs {
	
	public VCTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.achievement_airship_create_ignition);
	}
}
