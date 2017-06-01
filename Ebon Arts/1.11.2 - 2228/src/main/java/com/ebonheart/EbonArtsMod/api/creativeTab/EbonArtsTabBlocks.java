package com.ebonheart.EbonArtsMod.api.creativeTab;

import com.ebonheart.EbonArtsMod.api.BlocksEA;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EbonArtsTabBlocks extends CreativeTabs {

	public EbonArtsTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(Item.getItemFromBlock(BlocksEA.gemstone_block_basic_v1), 1, 5);
	}
}
