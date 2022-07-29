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
					
					DISMOUNTER_NORMAL,
					DISMOUNTER_PLAYER,
					
					VIESOLINE_PELLETS,
					
					LOGIC_CHIP,
					
					AIRSHIP_IGNITION,
					AIRSHIP_FRAME,
					AIRSHIP_ENGINE,
					AIRSHIP_BALLOON,
					
					UPGRADE_CORE,
					UPGRADE_FRAME,
					UPGRADE_ENGINE,
					UPGRADE_BALLOON,
					
					BOMB,
					
					MODULE_TYPE,
					MODULE_CREATIVE,
					
					ITEM_AIRSHIP,
					ITEM_AIRSHIP_CREATIVE,
					
					ACHIEVEMENT_AIRSHIP,
					ITEM_ENTITY_AIRSHIP,
					
					ITEM_DISPLAY_SYMBOL
					//================================
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
