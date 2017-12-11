package com.viesis.viescraft.api.creative;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VCTabAirshipsV4 extends CreativeTabs {
	
	public VCTabAirshipsV4(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(InitItemsVC.ITEM_AIRSHIP_V4, 1, 21);
	}
}
