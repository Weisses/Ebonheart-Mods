package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.blocks.BlockAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitBlocksVC extends BlocksVC {
	
	public static void registerBlockTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Block> BLOCKS = new HashSet<>();
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) 
		{
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					AIRSHIP_WORKBENCH
			};
			
			registry.registerAll(blocks);

			//registerSlabGroup(registry, Slabs.STAINED_CLAY_SLABS.high);
			//registerSlabGroup(registry, Slabs.STAINED_CLAY_SLABS.low);
		}

		/**
		 * Register the {@link Block}s of a {@link BlockSlabTestMod3.SlabGroup}.
		 *
		 * @param registry  The registry
		 * @param slabGroup The slab group
		 */
		//private static void registerSlabGroup(IForgeRegistry<Block> registry, BlockSlabTestMod3.SlabGroup<?, ?, ?> slabGroup) {
		//	registry.register(slabGroup.singleSlab);
		//	registry.register(slabGroup.doubleSlab);
		//}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
		{
			final ItemBlock[] items = {
					new ItemBlock(AIRSHIP_WORKBENCH)
				/**	new ItemBlock(WATER_GRASS),
					new ItemBlock(LARGE_COLLISION_TEST),
					new ItemBlock(RIGHT_CLICK_TEST),
					new ItemBlock(CLIENT_PLAYER_RIGHT_CLICK),
					new ItemBlock(ROTATABLE_LAMP),
					new ItemBlock(ITEM_COLLISION_TEST),
					new ItemFluidTank(FLUID_TANK),
					new ItemBlock(ITEM_DEBUGGER),
					new ItemBlock(END_PORTAL_FRAME_FULL),
					new ItemCloth(COLORED_ROTATABLE),
					new ItemCloth(COLORED_MULTI_ROTATABLE),
					new ItemBlock(POTION_EFFECT),
					new ItemMultiTexture(VARIANTS, VARIANTS, VARIANTS::getName),
					new ItemBlock(CLIENT_PLAYER_ROTATION),
					new ItemBlock(PIG_SPAWNER_REFILLER),
					new ItemBlock(MIRROR_PLANE),
					new ItemBlock(VANILLA_MODEL_TEST),
					new ItemBlock(FULLBRIGHT),
					new ItemBlock(NORMAL_BRIGHTNESS),
					new ItemBlock(MAX_HEALTH_SETTER),
					new ItemBlock(MAX_HEALTH_GETTER),
					new ItemBlock(SMALL_COLLISION_TEST),
					new ItemBlock(CHEST),
					new ItemBlock(HIDDEN),
					new ItemBlock(BASIC_PIPE),
					new ItemBlock(FLUID_PIPE),
					new ItemBlock(SURVIVAL_COMMAND_BLOCK),
					new ItemBlock(REPEATING_SURVIVAL_COMMAND_BLOCK),
					new ItemBlock(CHAIN_SURVIVAL_COMMAND_BLOCK),
					new ItemMultiTexture(SAPLING, SAPLING, BlockSaplingTestMod3::getName),
					Slabs.STAINED_CLAY_SLABS.low.item,
					Slabs.STAINED_CLAY_SLABS.high.item,*/
			};

			final IForgeRegistry<Item> registry = event.getRegistry();
			
			for (final ItemBlock item : items) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}

			registerTileEntities();
			//for (final ItemBlock item : items) {
			//	registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
			//	ITEM_BLOCKS.add(item);
			//}//
		}
	}

	public static void registerTileEntities() 
	{
		registerTileEntity(TileEntityAirshipWorkbench.class, "container_airship_workbench");
		//registerTileEntity(TileEntityFluidTank.class, "fluid_tank", "FluidTank");
		//registerTileEntity(TileEntityColoredRotatable.class, "colored_rotatable", "ColoredRotatable");
		//registerTileEntity(TileEntityColoredMultiRotatable.class, "colored_multi_rotatable", "ColoredMultiRotatable");
		//registerTileEntity(TileEntityPotionEffect.class, "potion_effect", "PotionEffect");
		//registerTileEntity(TileEntityModChest.class, "mod_chest", "ModChest");
		//registerTileEntity(TileEntityHidden.class, "hidden");
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) 
	{
		GameRegistry.registerTileEntity(tileEntityClass, References.MOD_ID_COLON	+ name);
	}

	//private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name, String legacyName) 
	//{
	//	GameRegistry.registerTileEntityWithAlternatives(tileEntityClass, Reference.MOD_ID_COLON//Constants.RESOURCE_PREFIX 
	//			+ name, Reference.MOD_ID_COLON//Constants.RESOURCE_PREFIX 
	//			+ legacyName);
	//}
	
}
