package com.vies.viesmachines.init;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.vies.viesmachines.api.BlocksVM;
import com.vies.viesmachines.api.References;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitBlocksVM extends BlocksVM {
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Block> BLOCKS = new HashSet<>();
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();
		
		/** Register this mod's {@link Block}s. */
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) 
		{
			final IForgeRegistry<Block> registry = event.getRegistry();
			
			final Block[] blocks = 
			{
				XEGONITE_BASIC,
				XEGONITE_STAIRS,
				XEGONITE_FENCE,
				XEGONITE_GATE,
				XEGONITE_WALL,
				XEGONITE_TORCH,
				XEGONITE_LADDER,
				XEGONITE_PILLAR,
				XEGONITE_CHISELED,
				
				WATER_BASIC,
				WATER_STAIRS,
				WATER_FENCE,
				WATER_GATE,
				WATER_WALL,
				WATER_TORCH,
				WATER_LADDER,
				WATER_PILLAR,
				WATER_CHISELED,
				
				LAVA_BASIC,
				LAVA_STAIRS,
				LAVA_FENCE,
				LAVA_GATE,
				LAVA_WALL,
				LAVA_TORCH,
				LAVA_LADDER,
				LAVA_PILLAR,
				LAVA_CHISELED,
				
				ENDER_BASIC,
				ENDER_STAIRS,
				ENDER_FENCE,
				ENDER_GATE,
				ENDER_WALL,
				ENDER_TORCH,
				ENDER_LADDER,
				ENDER_PILLAR,
				ENDER_CHISELED,
				
				//XEGONITE_BRICK,
				//XEGONITE_CHISELED,
				//XEGONITE_BARS,
				//XEGONITE_ROAD,
				//XEGONITE_TRAPDOOR,
				//XEGONITE_DOOR,
				//XEGONITE_GLASS,
				//XEGONITE_GLASS_PANE,
				//XEGONITE_CRAFTING_TABLE,
			};
			
			final Block[] appliances = 
			{
				EXTRACTOR,
				KIT_FABRICATOR,
				MACHINE_TRANSMOGRIFIER,
				MACHINE_BEACON,
				
				//AIRSHIP_WORKBENCH
				//MACHINE_CHARGE_STATION,
			};
			
			final Block[] decorations = 
			{
				ITEM_DISPLAY,
			};
			
			//--------------------------------------------------
			
			registry.registerAll(blocks);
			
			registry.registerAll(appliances);
			
			registry.registerAll(decorations);
		}
		
		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
		{
			final IForgeRegistry<Item> registry = event.getRegistry();
			
			final ItemBlock[] items = 
			{
				new ItemBlock(XEGONITE_BASIC),
				new ItemBlock(XEGONITE_STAIRS),
				new ItemBlock(XEGONITE_FENCE),
				new ItemBlock(XEGONITE_GATE),
				new ItemBlock(XEGONITE_WALL),
				new ItemBlock(XEGONITE_TORCH),
				new ItemBlock(XEGONITE_LADDER),
				new ItemBlock(XEGONITE_PILLAR),
				new ItemBlock(XEGONITE_CHISELED),
				
				new ItemBlock(WATER_BASIC),
				new ItemBlock(WATER_STAIRS),
				new ItemBlock(WATER_FENCE),
				new ItemBlock(WATER_GATE),
				new ItemBlock(WATER_WALL),
				new ItemBlock(WATER_TORCH),
				new ItemBlock(WATER_LADDER),
				new ItemBlock(WATER_PILLAR),
				new ItemBlock(WATER_CHISELED),
				
				new ItemBlock(LAVA_BASIC),
				new ItemBlock(LAVA_STAIRS),
				new ItemBlock(LAVA_FENCE),
				new ItemBlock(LAVA_GATE),
				new ItemBlock(LAVA_WALL),
				new ItemBlock(LAVA_TORCH),
				new ItemBlock(LAVA_LADDER),
				new ItemBlock(LAVA_PILLAR),
				new ItemBlock(LAVA_CHISELED),
				
				new ItemBlock(ENDER_BASIC),
				new ItemBlock(ENDER_STAIRS),
				new ItemBlock(ENDER_FENCE),
				new ItemBlock(ENDER_GATE),
				new ItemBlock(ENDER_WALL),
				new ItemBlock(ENDER_TORCH),
				new ItemBlock(ENDER_LADDER),
				new ItemBlock(ENDER_PILLAR),
				new ItemBlock(ENDER_CHISELED),
				
				//new ItemBlock(XEGONITE_BRICK),
				//new ItemBlock(XEGONITE_CHISELED),
				//new ItemBlock(XEGONITE_BARS),
				//new ItemBlock(XEGONITE_ROAD),
				//new ItemBlock(XEGONITE_TRAPDOOR),
				//new ItemBlock(XEGONITE_DOOR),
				//new ItemBlock(XEGONITE_GLASS),
				//new ItemBlock(XEGONITE_GLASS_PANE),
				//new ItemBlock(XEGONITE_CRAFTING_TABLE),
			};
			
			final ItemBlock[] appliances = 
			{
				new ItemBlock(EXTRACTOR),
				new ItemBlock(KIT_FABRICATOR),
				new ItemBlock(MACHINE_TRANSMOGRIFIER),
				new ItemBlock(MACHINE_BEACON),
				
				//new ItemBlock(AIRSHIP_WORKBENCH),
				//new ItemBlock(MACHINE_CHARGE_STATION),
			};
			
			final ItemBlock[] decorations = 
			{
				new ItemBlock(ITEM_DISPLAY),
			};
			
			//--------------------------------------------------
			
			for (final ItemBlock item : items) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			
			for (final ItemBlock item : appliances) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
			
			for (final ItemBlock item : decorations) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
		}
	}
}
