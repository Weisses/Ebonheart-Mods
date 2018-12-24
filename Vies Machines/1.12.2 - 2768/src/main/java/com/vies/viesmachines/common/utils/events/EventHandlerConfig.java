package com.vies.viesmachines.common.utils.events;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import com.vies.viesmachines.api.BlocksVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.client.MessageConfig;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

public class EventHandlerConfig {
	
	public EventHandlerConfig()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event)
	{
		if(!event.player.world.isRemote)
		{
			NetworkHandler.sendToClient(new MessageConfig(), (EntityPlayerMP)event.player);
			
			ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
			ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());
			ArrayList<IRecipe> recipesVM = Lists.newArrayList();
			
			recipesVM.clear();
			
			for (IRecipe r : recipes)
            {
				ItemStack output = r.getRecipeOutput();
				
	            if (output.getItem() == ItemsVM.XEGONITE_WATER
				|| output.getItem() == ItemsVM.XEGONITE_LAVA
				|| output.getItem() == ItemsVM.XEGONITE_ENDER
				|| output.getItem() == ItemsVM.CIRCUIT_LOGIC
				|| output.getItem() == ItemsVM.CIRCUIT_ADAPTIVE
				|| output.getItem() == ItemsVM.KIT_BLANK
				|| output.getItem() == ItemsVM.MACHINE_PELLETS
	            || output.getItem() == ItemsVM.MACHINE_FRAME
				|| output.getItem() == ItemsVM.MACHINE_ENGINE
				|| output.getItem() == ItemsVM.MACHINE_COMPONENT_GROUND
				|| output.getItem() == ItemsVM.MACHINE_COMPONENT_WATER
				|| output.getItem() == ItemsVM.MACHINE_COMPONENT_FLYING
				|| output.getItem() == ItemsVM.ITEM_MACHINE_GROUND_HOVERCRAFT
				|| output.getItem() == ItemsVM.ITEM_MACHINE_WATER_SUBMARINE
				|| output.getItem() == ItemsVM.ITEM_MACHINE_FLYING_AIRSHIP
				|| output.getItem() == ItemsVM.UPGRADE_FRAME_TIER1
				|| output.getItem() == ItemsVM.UPGRADE_FRAME_TIER2
				|| output.getItem() == ItemsVM.UPGRADE_FRAME_TIER3
				|| output.getItem() == ItemsVM.UPGRADE_ENGINE_TIER1
				|| output.getItem() == ItemsVM.UPGRADE_ENGINE_TIER2
				|| output.getItem() == ItemsVM.UPGRADE_ENGINE_TIER3
				|| output.getItem() == ItemsVM.UPGRADE_COMPONENT_TIER1
				|| output.getItem() == ItemsVM.UPGRADE_COMPONENT_TIER2
				|| output.getItem() == ItemsVM.UPGRADE_COMPONENT_TIER3
				|| output.getItem() == ItemsVM.TOOL_DISMOUNTER
        		|| output.getItem() == ItemsVM.TOOL_RADIO_EXPANSION
				
        		
        		
	            || output.getItem() == Item.getItemFromBlock(BlocksVM.EXTRACTOR)
	            || output.getItem() == Item.getItemFromBlock(BlocksVM.KIT_FABRICATOR)
	            || output.getItem() == Item.getItemFromBlock(BlocksVM.MACHINE_TRANSMOGRIFIER)
        		|| output.getItem() == Item.getItemFromBlock(BlocksVM.MACHINE_BEACON)
        		
				|| output.getItem() == Item.getItemFromBlock(BlocksVM.ITEM_DISPLAY)
        		
				
				
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_BASIC)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_STAIRS)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_FENCE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_GATE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_WALL)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_TORCH)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_LADDER)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_PILLAR)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.XEGONITE_CHISELED)
                
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_BASIC)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_STAIRS)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_FENCE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_GATE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_WALL)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_TORCH)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_LADDER)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_PILLAR)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.WATER_CHISELED)
                
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_BASIC)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_STAIRS)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_FENCE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_GATE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_WALL)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_TORCH)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_LADDER)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_PILLAR)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.LAVA_CHISELED)
                
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_BASIC)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_STAIRS)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_FENCE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_GATE)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_WALL)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_TORCH)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_LADDER)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_PILLAR)
                || output.getItem() == Item.getItemFromBlock(BlocksVM.ENDER_CHISELED)
                
                
                
        		)
	            {
	            	recipesVM.add(r);
	            }
            }
			
			event.player.unlockRecipes(recipesVM);
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogoutEvent(PlayerLoggedOutEvent event)
	{
		
	}
}
