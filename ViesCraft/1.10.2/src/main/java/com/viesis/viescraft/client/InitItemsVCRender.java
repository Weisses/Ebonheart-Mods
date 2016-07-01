package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.viesis.viescraft.api.ItemsVC;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerRenders()
	{
		
		registerRender(airship_balloon);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(item_airship_base);
		
		
		
		
		registerRender(item_viesdenburg);
		
		registerRender(achievement_airship_create);
		registerRender(achievement_airship_airborn);
		registerRender(achievement_airship_water);
		registerRender(achievement_airship_lava);
		
		//registerRender(test);
		
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}
