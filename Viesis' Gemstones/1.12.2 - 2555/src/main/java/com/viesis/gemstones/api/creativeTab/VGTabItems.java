package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VGTabItems extends CreativeTabs {

	public VGTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("vg.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 5);
	}
}
