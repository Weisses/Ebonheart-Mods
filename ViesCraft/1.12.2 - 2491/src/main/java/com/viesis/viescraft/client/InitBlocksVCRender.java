package com.viesis.viescraft.client;

import com.viesis.viescraft.api.BlocksVC;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitBlocksVCRender extends BlocksVC {
	
	public static void registerBlockRender()
	{
		registerRender(airship_workbench);
		//registerRender(battery_charger);
	}
	
	public static void registerBlockRenderTEMP()
	{
		
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	public static void registerRender(Block block, int meta, String file) 
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}
