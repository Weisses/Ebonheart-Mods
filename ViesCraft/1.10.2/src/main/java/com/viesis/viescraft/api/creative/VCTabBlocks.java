package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.api.BlocksVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VCTabBlocks extends CreativeTabs {

	public VCTabBlocks(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		//return null;
		return Item.getItemFromBlock(BlocksVC.airship_workbench);
	}
}
