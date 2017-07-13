package com.viesis.viescraft.client;

import java.util.HashSet;
import java.util.Set;

import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.init.InitBlocksVC;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MOD_ID)
public final class InitBlocksVCRender extends BlocksVC {
	
	public static final InitBlocksVCRender INSTANCE = new InitBlocksVCRender();
	
	/**
	 * Register this mod's {@link Fluid}, {@link Block} and {@link Item} models.
	 *
	 * @param event The event
	 */
	@SubscribeEvent
	public static void registerAllModels(final ModelRegistryEvent event) 
	{
		INSTANCE.registerBlockModels();
		INSTANCE.registerItemModels();
	}
	
	/**
	 * The {@link Item}s that have had models registered so far.
	 */
	private final Set<Item> itemsRegistered = new HashSet<>();
	
	/**
	 * Register this mod's {@link Block} models.
	 */
	private void registerBlockModels() 
	{
		InitBlocksVC.RegistrationHandler.ITEM_BLOCKS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
	}
	
	
	/**
	 * Register this mod's {@link Item} models.
	 */
	private void registerItemModels() 
	{
		InitBlocksVC.RegistrationHandler.ITEM_BLOCKS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
	}

	/**
	 * Register a single model for an {@link Item}.
	 * <p>
	 * Uses the registry name as the domain/path and {@code "inventory"} as the variant.
	 *
	 * @param item The Item
	 */
	private void registerItemModel(final Item item) 
	{
		registerItemModel(item, item.getRegistryName().toString());
	}
	
	private void registerItemModel(final Item item, final String modelLocation) 
	{
		final ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
		registerItemModel(item, fullModelLocation);
	}
	
	private void registerItemModel(final Item item, final ModelResourceLocation fullModelLocation) 
	{
		ModelBakery.registerItemVariants(item, fullModelLocation); // Ensure the custom model is loaded and prevent the default model from being loaded
		registerItemModel(item, MeshDefinitionFix.create(stack -> fullModelLocation));
	}
	
	public void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	public void registerRender(Block block, int meta, String file) 
	{
		Item item = Item.getItemFromBlock(block);
		itemsRegistered.add(item);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	interface MeshDefinitionFix extends ItemMeshDefinition 
	{
		ModelResourceLocation getLocation(final ItemStack stack);

		// Helper method to easily create lambda instances of this class
		static ItemMeshDefinition create(final MeshDefinitionFix lambda) 
		{
			return lambda;
		}

		@Override
		default ModelResourceLocation getModelLocation(final ItemStack stack) 
		{
			return getLocation(stack);
		}
	}
	
	private void registerItemModel(final Item item, final ItemMeshDefinition meshDefinition) 
	{
		itemsRegistered.add(item);
		ModelLoader.setCustomMeshDefinition(item, meshDefinition);
	}
}
