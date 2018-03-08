package com.viesis.viescraft.api.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.init.InitItemsVC;

public class VCTabItems extends CreativeTabs {
	
	public VCTabItems(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.GUIDEBOOK_MAIN);
	}
}
