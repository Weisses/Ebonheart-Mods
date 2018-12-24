package com.vies.viesmachines.api.creative;

import com.vies.viesmachines.api.ItemsVM;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsTab extends CreativeTabs {
	
	public ItemsTab(String label) 
	{
		super(label);
		this.setBackgroundImageName("viescraft.png");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemsVM.ITEM_MACHINE_FLYING_AIRSHIP, 1);
	}
}
