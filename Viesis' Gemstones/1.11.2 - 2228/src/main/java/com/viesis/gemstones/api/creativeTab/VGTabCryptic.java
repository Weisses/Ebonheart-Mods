package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.api.VGBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VGTabCryptic extends CreativeTabs {

	public VGTabCryptic(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(VGBlocks.gemstone_block_basic_v1));
	}
}
