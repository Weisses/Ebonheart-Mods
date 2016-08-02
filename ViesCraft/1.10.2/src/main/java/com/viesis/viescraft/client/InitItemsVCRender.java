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
		
		registerRender(item_airship_normal);
		registerRender(item_airship_black);
		registerRender(item_airship_blue);
		registerRender(item_airship_brown);
		registerRender(item_airship_cyan);
		registerRender(item_airship_gray);
		registerRender(item_airship_green);
		registerRender(item_airship_lightblue);
		registerRender(item_airship_lightgray);
		registerRender(item_airship_lime);
		registerRender(item_airship_magenta);
		registerRender(item_airship_orange);
		registerRender(item_airship_pink);
		registerRender(item_airship_purple);
		registerRender(item_airship_red);
		registerRender(item_airship_white);
		registerRender(item_airship_yellow);
		
		registerRender(item_paint_black);
		registerRender(item_paint_blue);
		registerRender(item_paint_brown);
		registerRender(item_paint_cyan);
		registerRender(item_paint_gray);
		registerRender(item_paint_green);
		registerRender(item_paint_lightblue);
		registerRender(item_paint_lightgray);
		registerRender(item_paint_lime);
		registerRender(item_paint_magenta);
		registerRender(item_paint_orange);
		registerRender(item_paint_pink);
		registerRender(item_paint_purple);
		registerRender(item_paint_red);
		registerRender(item_paint_white);
		registerRender(item_paint_yellow);
		
		
		
		registerRender(item_airship_base);
		//registerRender(item_airship_v2);
		//registerRender(item_airship_furnace);
		
		
		
		registerRender(item_viesdenburg);
		
		registerRender(achievement_airship_create_engine);
		registerRender(achievement_airship_create_ignition);
		registerRender(achievement_airship_create);
		registerRender(achievement_airship_create_color);
		
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
