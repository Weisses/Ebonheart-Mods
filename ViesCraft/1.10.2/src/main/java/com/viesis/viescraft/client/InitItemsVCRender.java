package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.viesis.viescraft.api.ItemsVC;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerRenders()
	{
		registerRender(guidebook_main);
		registerRender(guidebook_controls);
		registerRender(guidebook_paint);
		registerRender(guidebook_socket);
		
		registerRender(airship_balloon);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(module_inventory_small);
		registerRender(module_inventory_large);
		registerRender(module_speed_increase_minor);
		//registerRender(module_fuel_efficiency);
		registerRender(module_fuel_infinite);
		
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
		registerRender(item_airship_v1_admin);
		
		registerRender(item_airship_v2_normal);
		registerRender(item_airship_v2_black);
		registerRender(item_airship_v2_blue);
		registerRender(item_airship_v2_brown);
		registerRender(item_airship_v2_cyan);
		registerRender(item_airship_v2_gray);
		registerRender(item_airship_v2_green);
		registerRender(item_airship_v2_lightblue);
		registerRender(item_airship_v2_lightgray);
		registerRender(item_airship_v2_lime);
		registerRender(item_airship_v2_magenta);
		registerRender(item_airship_v2_orange);
		registerRender(item_airship_v2_pink);
		registerRender(item_airship_v2_purple);
		registerRender(item_airship_v2_red);
		registerRender(item_airship_v2_white);
		registerRender(item_airship_v2_yellow);
		registerRender(item_airship_v2_admin);
		
		registerRender(item_airship_v3_normal);
		registerRender(item_airship_v3_black);
		registerRender(item_airship_v3_blue);
		registerRender(item_airship_v3_brown);
		registerRender(item_airship_v3_cyan);
		registerRender(item_airship_v3_gray);
		registerRender(item_airship_v3_green);
		registerRender(item_airship_v3_lightblue);
		registerRender(item_airship_v3_lightgray);
		registerRender(item_airship_v3_lime);
		registerRender(item_airship_v3_magenta);
		registerRender(item_airship_v3_orange);
		registerRender(item_airship_v3_pink);
		registerRender(item_airship_v3_purple);
		registerRender(item_airship_v3_red);
		registerRender(item_airship_v3_white);
		registerRender(item_airship_v3_yellow);
		registerRender(item_airship_v3_admin);
		
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
		
		registerRender(achievement_airship_create_engine);
		registerRender(achievement_airship_create_ignition);
		registerRender(achievement_airship_create);
		registerRender(achievement_airship_create_color);
		registerRender(achievement_airship_create_module);
		
		registerRender(achievement_airship_airborn);
		registerRender(achievement_airship_water);
		registerRender(achievement_airship_lava);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}
