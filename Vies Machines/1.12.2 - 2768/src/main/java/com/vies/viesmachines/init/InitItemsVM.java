package com.vies.viesmachines.init;

import java.util.HashSet;
import java.util.Set;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitItemsVM extends ItemsVM {
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Item> ITEMS = new HashSet<>();
		
		/** Register this mod's {@link Item}s. */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			final Item[] items = 
			{
					XEGONITE,
					XEGONITE_WATER,
					XEGONITE_LAVA,
					
					XEGONITE_ENDER,
					CIRCUIT_LOGIC,
					CIRCUIT_ADAPTIVE,
					
					KIT_BLANK,
					KIT_UPGRADE_MAX,
					KIT_MACHINE_MAX,
					
					//--------------------------------------------------
					
					MACHINE_PELLETS,
					MACHINE_FRAME,
					MACHINE_ENGINE,
					
					MACHINE_COMPONENT_GROUND,
					MACHINE_COMPONENT_WATER,
					MACHINE_COMPONENT_FLYING,
					
					KIT_AMMO_4,
					KIT_AMMO_16,
					KIT_AMMO_64,
					
					//--------------------------------------------------
					
					KIT_HEALTH_2,
					KIT_HEALTH_8,
					KIT_HEALTH_MAX,
					
					KIT_ENERGY_25,
					KIT_ENERGY_100,
					KIT_ENERGY_MAX,
					
					KIT_DURABILITY_50,
					KIT_DURABILITY_200,
					KIT_DURABILITY_MAX,
					
					//--------------------------------------------------
					
					ITEM_MACHINE_GROUND_HOVERCRAFT,
					ITEM_MACHINE_GROUND_2,
					ITEM_MACHINE_GROUND_3,
					
					ITEM_MACHINE_WATER_SUBMARINE,
					ITEM_MACHINE_WATER_2,
					ITEM_MACHINE_WATER_3,
					
					ITEM_MACHINE_FLYING_AIRSHIP,
					ITEM_MACHINE_FLYING_HELICOPTER,
					ITEM_MACHINE_FLYING_3,
					
					//--------------------------------------------------
					
					UPGRADE_FRAME_TIER1,
					UPGRADE_FRAME_TIER2,
					UPGRADE_FRAME_TIER3,
					
					UPGRADE_ENGINE_TIER1,
					UPGRADE_ENGINE_TIER2,
					UPGRADE_ENGINE_TIER3,
					
					UPGRADE_COMPONENT_TIER1,
					UPGRADE_COMPONENT_TIER2,
					UPGRADE_COMPONENT_TIER3,
					
					//--------------------------------------------------
					
					TOOL_DISMOUNTER,
					TOOL_RADIO_EXPANSION,
					
					//--------------------------------------------------
					
					
					
					//--------------------------------------------------
					//--------------------------------------------------
					//--------------------------------------------------
					
					// General:
					SYMBOL_LOGOFORGE,
					SYMBOL_COINSTACK,
					SYMBOL_SCROLL,
					SYMBOL_WRENCH,
					SYMBOL_KEY,
					SYMBOL_PADLOCK,
					SYMBOL_BELL,
					SYMBOL_ANCHOR,
					SYMBOL_BARREL,
					SYMBOL_GEARS,
					
					// Holiday:
					// Christmas:
					SYMBOL_CHRISTMAS_TREE,
					SYMBOL_CHRISTMAS_WREATH,
					SYMBOL_CHRISTMAS_ORNAMENT,
					SYMBOL_CHRISTMAS_STOCKING,
					SYMBOL_CHRISTMAS_NIGHTSKY,
					SYMBOL_CHRISTMAS_GRINCH,
					SYMBOL_CHRISTMAS_MAX,
					SYMBOL_CHRISTMAS_FROSTY,
					SYMBOL_CHRISTMAS_PEANUTS,
					SYMBOL_CHRISTMAS_POKEMON,
					
					//--------------------------------------------------
					//--------------------------------------------------
					//--------------------------------------------------
					
					PARTICLE_BULLET_NORMAL,
					PARTICLE_BULLET_ELECTRICAL,
					PARTICLE_BULLET_EXPLOSIVE,
					
					PARTICLE_STATIC_CHARGE,
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
