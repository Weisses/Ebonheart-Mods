package com.viesis.viescraft.api;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class UncraftRecipesVC {
	
	public static final ItemStack[] AIRSHIPV1BASE = new ItemStack[] 
	{
		new ItemStack(Items.LEAD),
		
		new ItemStack(Items.LEAD),
		new ItemStack(InitItemsVC.airship_balloon),
		new ItemStack(Items.LEAD),
		
		new ItemStack(InitItemsVC.airship_engine),
		new ItemStack(InitItemsVC.airship_frame_wood0),
		new ItemStack(InitItemsVC.airship_engine),
		
		new ItemStack(Items.LEAD),
		new ItemStack(InitItemsVC.airship_ignition),
		new ItemStack(Items.LEAD)
	};
	
	
}
