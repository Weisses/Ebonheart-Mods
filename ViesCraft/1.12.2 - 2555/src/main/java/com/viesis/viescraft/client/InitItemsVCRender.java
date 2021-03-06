package com.viesis.viescraft.client;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = References.MOD_ID)
public final class InitItemsVCRender extends ItemsVC {
	
	public static final InitItemsVCRender INSTANCE = new InitItemsVCRender();
	
	/**
	 * Register this mod's {@link Fluid}, {@link Block} and {@link Item} models.
	 *
	 * @param event The event
	 */
	@SubscribeEvent
	public static void registerAllModels(final ModelRegistryEvent event) 
	{
		INSTANCE.registerItemRender();
	}

	/**
	 * The {@link Item}s that have had models registered so far.
	 */
	private final Set<Item> itemsRegistered = new HashSet<>();
	
	private void registerItemRender()
	{
		registerRender(InitItemsVC.GUIDEBOOK_MAIN);
		
		InitItemsVC.RegistrationHandler.ITEMS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerRender);
		
		//=====================================================================
		
		for (EnumsVC.ModuleType meta : EnumsVC.ModuleType.values()) 
		{
			registerRenderModuleType(MODULE_TYPE, meta.getMetadata());
		}
		
		//registerRender(MODULE_CREATIVE);
		
		for (EnumsVC.AirshipTierFrame meta : EnumsVC.AirshipTierFrame.values()) 
		{
			registerRenderTierFrame(UPGRADE_FRAME, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierCore(UPGRADE_CORE, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierEngine meta : EnumsVC.AirshipTierEngine.values()) 
		{
			registerRenderTierEngine(UPGRADE_ENGINE, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipTierBalloon meta : EnumsVC.AirshipTierBalloon.values()) 
		{
			registerRenderTierBalloon(UPGRADE_BALLOON, meta.getMetadata());
		}
		
		//==============================================
		
		//V1
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(ITEM_V1_AIRSHIP, meta.getMetadata());
		}
		//V2
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(ITEM_V2_AIRSHIP, meta.getMetadata());
		}
		//V3
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(ITEM_V3_AIRSHIP, meta.getMetadata());
		}
		
		//V4
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			registerRenderTierAirship(ITEM_V4_AIRSHIP, meta.getMetadata());
		}
		//V5
		//for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		//{
			//registerRenderTier(item_v5_airship, meta.getMetadata());
		//}
		//V6
		//for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		//{
			//registerRenderTier(item_v6_airship, meta.getMetadata());
		//}
		
		registerRender(ITEM_CREATIVE_V1_AIRSHIP);
		registerRender(ITEM_CREATIVE_V2_AIRSHIP);
		registerRender(ITEM_CREATIVE_V3_AIRSHIP);
		registerRender(ITEM_CREATIVE_V4_AIRSHIP);
		
		//=====================================================================
		
		for (EnumsVC.Achievement meta : EnumsVC.Achievement.values()) 
		{
			registerRenderAchievement(ACHIEVEMENT_AIRSHIP, meta.getMetadata());
		}
		
		registerRender(ITEM_ENTITY_AIRSHIP);
		
		//=====================================================================
		
	}
	
	private static void registerItemRenderTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	private void registerRender(Item item)
	{
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	
	
	
	
	
	
	private void registerRenderTierAirship(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierFrame.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderTierFrame(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierFrame.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderTierCore(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderTierEngine(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierEngine.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderTierBalloon(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipTierBalloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderModuleType(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.ModuleType.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderAchievement(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.Achievement.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}
