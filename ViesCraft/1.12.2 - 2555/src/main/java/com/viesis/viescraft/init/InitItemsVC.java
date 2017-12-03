package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitItemsVC extends ItemsVC {
	
	public static void registerItemTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<>();
		
		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			final Item[] items = {
					GUIDEBOOK_MAIN,
					
					ITEM_DISMOUNTER_NORMAL,
					ITEM_DISMOUNTER_PLAYER,
					
					VIESOLINE_PELLETS,
					
					LOGIC_CHIP,
					
					AIRSHIP_FRAME,
					AIRSHIP_IGNITION,
					AIRSHIP_ENGINE,
					AIRSHIP_BALLOON,
					
					UPGRADE_FRAME,
					UPGRADE_CORE,
					UPGRADE_ENGINE,
					UPGRADE_BALLOON,
					
					MODULE_TYPE,
					MODULE_CREATIVE,
					
					ITEM_V1_AIRSHIP,
					ITEM_CREATIVE_V1_AIRSHIP,
					ITEM_V2_AIRSHIP,
					ITEM_CREATIVE_V2_AIRSHIP,
					ITEM_V3_AIRSHIP,
					ITEM_CREATIVE_V3_AIRSHIP,
					ITEM_V4_AIRSHIP,
					ITEM_CREATIVE_V4_AIRSHIP,
					//ITEM_V5_AIRSHIP,
					//ITEM_CREATIVE_V5_AIRSHIP,
					//ITEM_V6_AIRSHIP,
					//ITEM_CREATIVE_V6_AIRSHIP,
					
					ACHIEVEMENT_AIRSHIP,
					ITEM_ENTITY_AIRSHIP,
					
					
					
					//================================
					
					
					
					ITEM_DISMOUNTER,//
					AIRSHIP_BASEFRAME,//
					AIRSHIP_BALLOON_PATTERN,//
					AIRSHIP_MODULE,//
					ITEM_BALLOON_COLORIZER,//
					ITEM_AIRSHIP_V1,//
					ITEM_AIRSHIP_V2,//
					ITEM_AIRSHIP_V3,//
					ITEM_AIRSHIP_V4,//
					
					//ITEM_POUCH_MODULE,
					//ITEM_POUCH_ALL
					
					GUIDEBOOK_CONTROL,//
					GUIDEBOOK_PAINT,//
					GUIDEBOOK_SOCKET//
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) 
			{
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
