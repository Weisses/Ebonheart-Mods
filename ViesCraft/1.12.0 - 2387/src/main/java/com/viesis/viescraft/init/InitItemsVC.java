package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.items.ItemAirshipDismounter;
import com.viesis.viescraft.common.items.ItemGuidebookControl;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.ItemGuidebookPaint;
import com.viesis.viescraft.common.items.ItemGuidebookSocket;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.achievements.ItemEntityAirship;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4;
import com.viesis.viescraft.common.items.parts.ItemBalloon;
import com.viesis.viescraft.common.items.parts.ItemBalloonPattern;
import com.viesis.viescraft.common.items.parts.ItemColorizerBalloon;
import com.viesis.viescraft.common.items.parts.ItemEngine;
import com.viesis.viescraft.common.items.parts.ItemFrame;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemModule;
import com.viesis.viescraft.common.items.parts.ItemViesoline;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class InitItemsVC extends ItemsVC {
	
	public static void registerItemTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
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
					GUIDEBOOK_MAIN,//
					GUIDEBOOK_CONTROL,//
					GUIDEBOOK_PAINT,//
					GUIDEBOOK_SOCKET,//
					VIESOLINE_PELLETS,//
					AIRSHIP_BALLOON,//
					AIRSHIP_ENGINE,//
					AIRSHIP_IGNITION,//
					ITEM_DISMOUNTER,//
					AIRSHIP_FRAME,//
					AIRSHIP_BALLOON_PATTERN,//
					AIRSHIP_MODULE,//
					ITEM_BALLOON_COLORIZER,//
					ITEM_AIRSHIP_V1,//
					ITEM_AIRSHIP_V2,//
					ITEM_AIRSHIP_V3,//
					ITEM_AIRSHIP_V4,//
					ACHIEVEMENT_AIRSHIP,//
					ITEM_ENTITY_AIRSHIP//
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
