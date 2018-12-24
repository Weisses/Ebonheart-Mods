package com.vies.viesmachines.client;

import java.util.HashSet;
import java.util.Set;

import com.vies.viesmachines.api.BlocksVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.init.InitBlocksVM;

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

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = References.MOD_ID)
public final class InitBlocksVMRender extends BlocksVM {
	
	public static final InitBlocksVMRender INSTANCE = new InitBlocksVMRender();
	
	/** The {@link Item}s that have had models registered so far. */
	private final Set<Item> itemsRegistered = new HashSet<>();
	
	
	
	/** Register this mod's {@link Fluid}, {@link Block} and {@link Item} models. */
	@SubscribeEvent
	public static void registerAllModels(final ModelRegistryEvent event) 
	{
		INSTANCE.registerBlockModels();
		INSTANCE.registerItemModels();
	}
	
	/** Register this mod's {@link Block} models. */
	private void registerBlockModels() 
	{
		InitBlocksVM.RegistrationHandler.ITEM_BLOCKS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
	}
	
	/** Register this mod's {@link Item} models. */
	private void registerItemModels() 
	{
		InitBlocksVM.RegistrationHandler.ITEM_BLOCKS.stream().filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
	}

	//--------------------------------------------------
	
	/** Register a single model for an {@link Block}. */
	public void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		itemsRegistered.add(item);
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}

	//--------------------------------------------------
	
	/** Register a single model for an {@link Item}. */
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
		// Ensure the custom model is loaded and prevent the default model from being loaded:
		ModelBakery.registerItemVariants(item, fullModelLocation); 
		registerItemModel(item, MeshDefinitionFix.create(stack -> fullModelLocation));
	}
	
	interface MeshDefinitionFix extends ItemMeshDefinition 
	{
		ModelResourceLocation getLocation(final ItemStack stack);

		// Helper method to easily create lambda instances of this class:
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
