package com.viesis.viescraft.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.configs.ViesCraftConfig;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerItemRender()
	{
		registerRender(guidebook_main);
		registerRender(guidebook_controls);
		registerRender(guidebook_paint);
		registerRender(guidebook_socket);
		
		registerRender(viesoline_pellets);
		
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
		
		for (EntityAirshipBaseVC.Frame meta : EntityAirshipBaseVC.Frame.values()) 
		{
			registerRenderFrame(airship_frame, meta.getMetadata());
		}
		
		//==============================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			for (EntityAirshipBaseVC.Color meta : EntityAirshipBaseVC.Color.values()) 
			{
				registerRenderColor(item_airship_v1_wood0, meta.getMetadata());
				registerRenderColor(item_airship_v1_iron, meta.getMetadata());
				registerRenderColor(item_airship_v1_redstone, meta.getMetadata());
				registerRenderColor(item_airship_v1_gold, meta.getMetadata());
				registerRenderColor(item_airship_v1_lapislazuli, meta.getMetadata());
				registerRenderColor(item_airship_v1_obsidian, meta.getMetadata());
				registerRenderColor(item_airship_v1_diamond, meta.getMetadata());
				registerRenderColor(item_airship_v1_emerald, meta.getMetadata());
				registerRenderColor(item_airship_v1_netherbrick, meta.getMetadata());
				registerRenderColor(item_airship_v1_purpur, meta.getMetadata());
			}
		}
		
		//==============================================
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			for (EntityAirshipBaseVC.Color meta : EntityAirshipBaseVC.Color.values()) 
			{
				registerRenderColor(item_airship_v2_wood0, meta.getMetadata());
				registerRenderColor(item_airship_v2_iron, meta.getMetadata());
				registerRenderColor(item_airship_v2_redstone, meta.getMetadata());
				registerRenderColor(item_airship_v2_gold, meta.getMetadata());
				registerRenderColor(item_airship_v2_lapislazuli, meta.getMetadata());
				registerRenderColor(item_airship_v2_obsidian, meta.getMetadata());
				registerRenderColor(item_airship_v2_diamond, meta.getMetadata());
				registerRenderColor(item_airship_v2_emerald, meta.getMetadata());
				registerRenderColor(item_airship_v2_netherbrick, meta.getMetadata());
				registerRenderColor(item_airship_v2_purpur, meta.getMetadata());
			}
		}
				
		//==============================================
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			for (EntityAirshipBaseVC.Color meta : EntityAirshipBaseVC.Color.values()) 
			{
				registerRenderColor(item_airship_v3_wood0, meta.getMetadata());
				registerRenderColor(item_airship_v3_iron, meta.getMetadata());
				registerRenderColor(item_airship_v3_redstone, meta.getMetadata());
				registerRenderColor(item_airship_v3_gold, meta.getMetadata());
				registerRenderColor(item_airship_v3_lapislazuli, meta.getMetadata());
				registerRenderColor(item_airship_v3_obsidian, meta.getMetadata());
				registerRenderColor(item_airship_v3_diamond, meta.getMetadata());
				registerRenderColor(item_airship_v3_emerald, meta.getMetadata());
				registerRenderColor(item_airship_v3_netherbrick, meta.getMetadata());
				registerRenderColor(item_airship_v3_purpur, meta.getMetadata());
			}
		}
				
		//==============================================
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			for (EntityAirshipBaseVC.Color meta : EntityAirshipBaseVC.Color.values()) 
			{
				registerRenderColor(item_airship_v4_wood0, meta.getMetadata());
				registerRenderColor(item_airship_v4_iron, meta.getMetadata());
				registerRenderColor(item_airship_v4_redstone, meta.getMetadata());
				registerRenderColor(item_airship_v4_gold, meta.getMetadata());
				registerRenderColor(item_airship_v4_lapislazuli, meta.getMetadata());
				registerRenderColor(item_airship_v4_obsidian, meta.getMetadata());
				registerRenderColor(item_airship_v4_diamond, meta.getMetadata());
				registerRenderColor(item_airship_v4_emerald, meta.getMetadata());
				registerRenderColor(item_airship_v4_netherbrick, meta.getMetadata());
				registerRenderColor(item_airship_v4_purpur, meta.getMetadata());
			}
		}
				
		//==============================================
		
		for (EntityAirshipBaseVC.Color meta : EntityAirshipBaseVC.Color.values()) 
		{
			registerRenderColor(item_paint, meta.getMetadata());
		}
		
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
	
	public static void registerRenderColor(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.Color.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderFrame(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.Frame.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderAchievement(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + ItemAchievement.Achievement.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}
