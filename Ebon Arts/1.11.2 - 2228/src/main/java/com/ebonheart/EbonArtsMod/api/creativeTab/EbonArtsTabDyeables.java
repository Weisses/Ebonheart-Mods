package com.ebonheart.EbonArtsMod.api.creativeTab;

import com.ebonheart.EbonArtsMod.api.BlocksEA;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EbonArtsTabDyeables extends CreativeTabs {

	public EbonArtsTabDyeables(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(BlocksEA.gemstone_block_basic_v1));
	}
}
