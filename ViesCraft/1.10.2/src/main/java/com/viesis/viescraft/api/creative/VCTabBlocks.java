package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.viesis.viescraft.api.BlocksVC;

public class VCTabBlocks extends CreativeTabs {
	
	public VCTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(BlocksVC.airship_workbench);
	}
}
