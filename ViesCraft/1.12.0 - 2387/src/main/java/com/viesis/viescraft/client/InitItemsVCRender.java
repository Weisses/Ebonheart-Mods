package com.viesis.viescraft.client;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
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
		registerRender(InitItemsVC.GUIDEBOOK_CONTROL);
		registerRender(InitItemsVC.GUIDEBOOK_PAINT);
		registerRender(InitItemsVC.GUIDEBOOK_SOCKET);
		
		InitItemsVC.RegistrationHandler.ITEMS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerRender);
		//==============================================
		
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(AIRSHIP_FRAME, meta.getMetadata());
		}
		
		for (EntityAirshipBaseVC.Balloon meta : EntityAirshipBaseVC.Balloon.values()) 
		{
			registerRenderBalloon(AIRSHIP_BALLOON_PATTERN, meta.getMetadata());
		}
		
		for (EntityAirshipBaseVC.Module meta : EntityAirshipBaseVC.Module.values()) 
		{
			registerRenderModule(AIRSHIP_MODULE, meta.getMetadata());
		}
		
		//V1
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V1, meta.getMetadata());
		}
		
		//==============================================
		
		//V2
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V2, meta.getMetadata());
		}
		
		//==============================================
		
		//V3
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V3, meta.getMetadata());
		}
		
		//==============================================
		
		//V4
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(ITEM_AIRSHIP_V4, meta.getMetadata());
		}
		
		//==============================================
		
		for (ItemAchievement.Achievement meta : ItemAchievement.Achievement.values()) 
		{
			registerRenderAchievement(ACHIEVEMENT_AIRSHIP, meta.getMetadata());
		}
		
		registerRender(ITEM_ENTITY_AIRSHIP);
		
		//ModItems.RegistrationHandler.ITEMS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
/**		
		
		registerRender(viesoline_pellets);
		//registerRender(airship_battery);
		
		registerRender(airship_balloon);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(airship_dismounter);
		
		registerRender(item_balloon_colorizer);
		
		for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
			registerRenderFrame(airship_frame, meta.getMetadata());
		}
		
		for (EntityAirshipBaseVC.Balloon meta : EntityAirshipBaseVC.Balloon.values()) 
		{
			registerRenderBalloon(airship_balloon_pattern, meta.getMetadata());
		}
		
		for (EntityAirshipBaseVC.Module meta : EntityAirshipBaseVC.Module.values()) 
		{
			registerRenderModule(airship_module, meta.getMetadata());
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
		
		registerRender(item_entity_airship);*/
	}
	
	/**
	 * Register a single model for an {@link Item}.
	 * <p>
	 * Uses the registry name as the domain/path and {@code "inventory"} as the variant.
	 *
	 * @param item The Item
	 */
	//private void registerItemModel(final Item item) {
	//	registerRender(item, item.getRegistryName().toString());
	//}
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
	
	private void registerRenderFrame(Item item, int meta)
	{
		String itemName = item.getRegistryName() + "_" + EntityAirshipBaseVC.FrameCore.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		
		itemsRegistered.add(item);
		//ModelLoader.setCustomModelResourceLocation(item, metadata, modelResourceLocation);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderBalloon(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.Balloon.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderModule(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + EntityAirshipBaseVC.Module.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	private void registerRenderAchievement(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + ItemAchievement.Achievement.byId(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}
