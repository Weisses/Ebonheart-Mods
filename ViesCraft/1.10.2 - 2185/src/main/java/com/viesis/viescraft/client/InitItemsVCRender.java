package com.viesis.viescraft.client;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerItemRender()
	{
		//registerRender(airship_battery);
		
		registerRender(guidebook_main);
		
		registerRender(dismounter_normal);
		registerRender(dismounter_player);
		
		registerRender(viesoline_pellets);
		
		registerRender(logic_chip);
		
		registerRender(airship_balloon);
		registerRender(airship_frame);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(module_creative);
		
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierCore(upgrade_core, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierFrame meta : EnumsVC.AirshipTierFrame.values()) 
		{
			registerRenderTierFrame(upgrade_frame, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierEngine meta : EnumsVC.AirshipTierEngine.values()) 
		{
			registerRenderTierEngine(upgrade_engine, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierBalloon meta : EnumsVC.AirshipTierBalloon.values()) 
		{
			registerRenderTierBalloon(upgrade_balloon, meta.getMetadata());
		}
		
		for (EnumsVC.ModuleType meta : EnumsVC.ModuleType.values()) 
		{
			registerRenderModuleType(module_type, meta.getMetadata());
		}
		
		//==============================================
		
		//V1
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(item_v1_airship, meta.getMetadata());
		}
		//V2
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(item_v2_airship, meta.getMetadata());
		}
		//V3
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(item_v3_airship, meta.getMetadata());
		}
		
		//V4
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(item_v4_airship, meta.getMetadata());
		}
		//V5
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			//registerRenderTier(item_v5_airship, meta.getMetadata());
		}
		//V6
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			//registerRenderTier(item_v6_airship, meta.getMetadata());
		}
		
		registerRender(item_creative_v1_airship);
		registerRender(item_creative_v2_airship);
		registerRender(item_creative_v3_airship);
		registerRender(item_creative_v4_airship);
		//registerRender(item_creative_v5_airship);
		//registerRender(item_creative_v6_airship);
		
		//==============================================
		
		for (EnumsVC.Achievement meta : EnumsVC.Achievement.values()) 
		{
			registerRenderAchievement(achievement_airship, meta.getMetadata());
		}
		
		registerRender(item_entity_airship);
		
		//registerRender(item_pouch_module);
		//registerRender(item_pouch_all);
		
		
		//REMOVE ME NEXT UPDATE
		registerRender(guidebook_paint);
		registerRender(guidebook_socket);
		registerRender(guidebook_controls);
		registerRender(item_balloon_colorizer);
		registerRender(airship_dismounter);
		
		//TODO REMOVE NEXT UPDATE
		for (EnumsVC.AirshipModule meta : EnumsVC.AirshipModule.values()) 
		{
			registerRenderModule(airship_module, meta.getMetadata());
		}
		for (EnumsVC.AirshipTierFrame meta : EnumsVC.AirshipTierFrame.values()) 
		{
			registerRenderFrame(airship_baseframe, meta.getMetadata());
		}
		for (EnumsVC.AirshipBalloon meta : EnumsVC.AirshipBalloon.values()) 
		{
			registerRenderTierBalloonOLD(airship_balloon_pattern, meta.getMetadata());
		}

		//OLD
		//V1
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v1, meta.getMetadata());
		}
		//V2
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v2, meta.getMetadata());
		}
		//V3
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v3, meta.getMetadata());
		}
		//V4
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(item_airship_v4, meta.getMetadata());
		}
		
		//==============================================
		
		
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
	
	
	
	
	public static void registerRenderTierAirship(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierFrame.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderTierFrame(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierFrame.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderTierCore(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderTierEngine(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierEngine.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderTierBalloon(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierBalloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderModuleType(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.ModuleType.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderAchievement(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.Achievement.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	
	
	//TODO to be removed next update
		public static void registerRenderFrame(Item item, int meta)
		{
			String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.FrameCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
		}

		public static void registerRenderModule(Item item, int meta)
		{
			String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipModule.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
		}	
		
		public static void registerRenderTierBalloonOLD(Item item, int meta)
		{
			String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipBalloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
			
			ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
		}
		
		
}
