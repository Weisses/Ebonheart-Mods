package com.viesis.viescraft.client;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
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
		
		
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrameOLD(AIRSHIP_BASEFRAME, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipBalloon meta : EnumsVC.AirshipBalloon.values()) 
		{
			registerRenderBalloonOLD(AIRSHIP_BALLOON_PATTERN, meta.getMetadata());
		}
		
		for (EnumsVC.AirshipModule meta : EnumsVC.AirshipModule.values()) 
		{
			registerRenderModuleOLD(AIRSHIP_MODULE, meta.getMetadata());
		}
		
		//V1
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrameOLD(ITEM_AIRSHIP_V1, meta.getMetadata());
		}
		
		//==============================================
		
		//V2
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrameOLD(ITEM_AIRSHIP_V2, meta.getMetadata());
		}
		
		//==============================================
		
		//V3
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrameOLD(ITEM_AIRSHIP_V3, meta.getMetadata());
		}
		
		//==============================================
		
		//V4
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrameOLD(ITEM_AIRSHIP_V4, meta.getMetadata());
		}
		
		//==============================================
		
		//==============================================
		
		
		//==============
		
		registerRender(InitItemsVC.GUIDEBOOK_CONTROL);
		registerRender(InitItemsVC.GUIDEBOOK_PAINT);
		registerRender(InitItemsVC.GUIDEBOOK_SOCKET);
		
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
	
	
	//==================================================
	
	
	
	private void registerRenderFrameOLD(Item item, int meta)
	{
		String itemName = item.getRegistryName() + "_" + EntityAirshipBaseVC.FrameCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderBalloonOLD(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipBalloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderModuleOLD(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EnumsVC.AirshipModule.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
}

/**
public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerItemRender()
	{
		//registerRender(airship_battery);
		
		registerRender(GUIDEBOOK_MAIN);
		
		registerRender(ITEM_DISMOUNTER_NORMAL);
		registerRender(ITEM_DISMOUNTER_PLAYER);
		
		registerRender(VIESOLINE_PELLETS);
		
		registerRender(LOGIC_CHIP);
		
		registerRender(AIRSHIP_BALLOON);
		registerRender(AIRSHIP_FRAME);
		registerRender(AIRSHIP_ENGINE);
		registerRender(AIRSHIP_IGNITION);
		
		for (EnumsVC.ModuleType meta : EnumsVC.ModuleType.values()) 
		{
			registerRenderModuleType(MODULE_TYPE, meta.getMetadata());
		}
		
		registerRender(MODULE_CREATIVE);
		
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
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			//registerRenderTier(item_v5_airship, meta.getMetadata());
		}
		//V6
		for (EnumsVC.AirshipTierCore meta : EnumsVC.AirshipTierCore.values()) 
		{
			//registerRenderTier(item_v6_airship, meta.getMetadata());
		}
		
		registerRender(ITEM_CREATIVE_V1_AIRSHIP);
		registerRender(ITEM_CREATIVE_V2_AIRSHIP);
		registerRender(ITEM_CREATIVE_V3_AIRSHIP);
		registerRender(ITEM_CREATIVE_V4_AIRSHIP);
		//registerRender(item_creative_v5_airship);
		//registerRender(item_creative_v6_airship);
		
		//==============================================
		
		for (EnumsVC.Achievement meta : EnumsVC.Achievement.values()) 
		{
			registerRenderAchievement(ACHIEVEMENT_AIRSHIP, meta.getMetadata());
		}
		
		registerRender(ITEM_ENTITY_AIRSHIP);
		
		//registerRender(item_pouch_module);
		//registerRender(item_pouch_all);
		
		
		//REMOVE ME NEXT UPDATE
		registerRender(GUIDEBOOK_PAINT);
		registerRender(GUIDEBOOK_SOCKET);
		registerRender(GUIDEBOOK_CONTROL);
		registerRender(ITEM_BALLOON_COLORIZER);
		registerRender(ITEM_DISMOUNTER);
		
		//TODO REMOVE NEXT UPDATE
		for (EnumsVC.AirshipModule meta : EnumsVC.AirshipModule.values()) 
		{
			registerRenderModule(AIRSHIP_MODULE, meta.getMetadata());
		}
		for (EnumsVC.AirshipTierFrame meta : EnumsVC.AirshipTierFrame.values()) 
		{
			registerRenderFrame(AIRSHIP_BASEFRAME, meta.getMetadata());
		}
		for (EnumsVC.AirshipBalloon meta : EnumsVC.AirshipBalloon.values()) 
		{
			registerRenderTierBalloonOLD(AIRSHIP_BALLOON_PATTERN, meta.getMetadata());
		}

		//OLD
		//V1
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V1, meta.getMetadata());
		}
		//V2
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V2, meta.getMetadata());
		}
		//V3
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V3, meta.getMetadata());
		}
		//V4
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V4, meta.getMetadata());
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
		
		
}*/
