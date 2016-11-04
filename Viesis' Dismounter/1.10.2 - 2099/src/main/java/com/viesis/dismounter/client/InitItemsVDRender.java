package com.viesis.dismounter.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.viesis.dismounter.api.ItemsVD;

public final class InitItemsVDRender extends ItemsVD {
	
	public static void registerRenders()
	{
		registerRender(item_dismounter);
		
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}
