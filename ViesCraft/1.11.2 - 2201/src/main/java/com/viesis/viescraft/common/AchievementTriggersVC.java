package com.viesis.viescraft.common;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitItemsVC;

public class AchievementTriggersVC extends InitAchievementsVC {
	
	/**
	 * Pickup an item for an achievement
	 * @param event
	 */
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemPickupEvent event) 
	{
		
		//if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.draconium_dust)))
		//{
		//	event.player.addStat(mine_draconium_ore);//.triggerAchievement(InitAchievementsEA.mine_draconium_ore);
		//}
		
	}
	
	/**
	 * Craft an item for an achievement
	 * @param event
	 */
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event) 
	{
		if(event.crafting.getItem() == InitItemsVC.airship_engine) 
		{
			event.player.addStat(airship_create_engine);
		}
		
		if(event.crafting.getItem() == InitItemsVC.airship_ignition) 
		{
			event.player.addStat(airship_create_ignition);
		}
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_normal
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_normal
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_normal
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_normal) 
		{
			event.player.addStat(airship_create);
		}
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_wood0_yellow
		
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_wood0_yellow
		
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_wood0_yellow
		
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4_wood0_yellow) 
		{
			event.player.addStat(airship_create_color);
		}
		
		if(event.crafting.getItem() == InitItemsVC.module_inventory_small
		|| event.crafting.getItem() == InitItemsVC.module_inventory_large
		|| event.crafting.getItem() == InitItemsVC.module_speed_increase_minor
		|| event.crafting.getItem() == InitItemsVC.module_speed_increase_major
		|| event.crafting.getItem() == InitItemsVC.module_fuel_infinite) 
		{
			event.player.addStat(airship_create_module);
		}
	}
	
	//Smelt an item achievement
	//@SubscribeEvent
	//public void onSmelt(PlayerEvent.ItemSmeltedEvent event) {
	//	if(event.smelting.getItem() == EbonArtsItems.purified_mystic_dust) {

	//		event.player.triggerAchievement(EbonArtsAchievements.smeltMysticDust);
		
	//	}
	//}
}
