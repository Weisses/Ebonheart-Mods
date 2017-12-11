package com.viesis.gemstones.api.creativeTab;

import com.viesis.gemstones.api.VGBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VGTabGeneral extends CreativeTabs {
	
	public VGTabGeneral(String label) 
	{
		super(label);
		this.setBackgroundImageName("vg.png");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(VGBlocks.GEMSTONE_WORKBENCH));
	}
}
