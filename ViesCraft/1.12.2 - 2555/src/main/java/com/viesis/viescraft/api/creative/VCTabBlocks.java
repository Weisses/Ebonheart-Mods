package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.init.InitBlocksVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VCTabBlocks extends CreativeTabs {
	
	public VCTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(InitBlocksVC.AIRSHIP_WORKBENCH));
	}
}