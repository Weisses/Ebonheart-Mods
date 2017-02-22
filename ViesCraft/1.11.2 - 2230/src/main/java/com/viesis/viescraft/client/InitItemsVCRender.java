package com.viesis.viescraft.client;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerItemRender()
	{
		registerRender(guidebook_main);
		registerRender(guidebook_controls);
		registerRender(guidebook_paint);
		registerRender(guidebook_socket);
		
		registerRender(viesoline_pellets);
		//registerRender(airship_battery);
		
		registerRender(airship_balloon);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(airship_dismounter);
		
		registerRender(module_chip);
		registerRender(module_inventory_small);
		registerRender(module_inventory_large);
		registerRender(module_speed_increase_minor);
		registerRender(module_speed_increase_major);
		registerRender(module_fuel_infinite);
		
		registerRender(item_balloon_colorizer);
		
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(airship_frame, meta.getMetadata());
		}
		
		for (EntityAirshipBaseVC.Balloon meta : EntityAirshipBaseVC.Balloon.values()) 
		{
			registerRenderBalloon(airship_balloon_pattern, meta.getMetadata());
		}
		
		//==============================================
		
		//V1
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v1, meta.getMetadata());
		}
		
		//==============================================
		
		//V2
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v2, meta.getMetadata());
		}
		
		//==============================================
		
		//V3
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v3, meta.getMetadata());
		}
		
		//==============================================
		
		//V4
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v4, meta.getMetadata());
		}
		
		//==============================================
		
		for (ItemAchievement.Achievement meta : ItemAchievement.Achievement.values()) 
		{
			registerRenderAchievement(achievement_airship, meta.getMetadata());
		}
		
		registerRender(item_entity_airship);
	}
	
	public static void registerItemRenderTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	public static void registerRenderFrame(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.FrameCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderBalloon(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.Balloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderAchievement(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + ItemAchievement.Achievement.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}
