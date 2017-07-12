package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.api.VGBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VGTabBlocksRegular extends CreativeTabs {
	
	public VGTabBlocksRegular(String label) 
	{
		super(label);
		this.setBackgroundImageName("vg.png");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(VGBlocks.gemstone_basic_block_v1), 1, 0);
	}
}
