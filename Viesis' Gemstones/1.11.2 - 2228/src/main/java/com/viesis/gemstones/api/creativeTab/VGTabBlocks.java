package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.api.VGBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VGTabBlocks extends CreativeTabs {
	
	public VGTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(VGBlocks.gemstone_block_basic_v1), 1, 5);
	}
}
