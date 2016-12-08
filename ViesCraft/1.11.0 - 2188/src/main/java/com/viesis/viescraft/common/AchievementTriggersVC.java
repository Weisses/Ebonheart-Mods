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
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_v1_normal
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_normal
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_normal) 
		{
			event.player.addStat(airship_create);
		}
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_v1_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v1_yellow
		
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2_yellow
		
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3_yellow) 
		{
			event.player.addStat(airship_create_color);
		}
		
		if(event.crafting.getItem() == InitItemsVC.module_inventory_small
		|| event.crafting.getItem() == InitItemsVC.module_inventory_large
		|| event.crafting.getItem() == InitItemsVC.module_speed_increase_minor
		|| event.crafting.getItem() == InitItemsVC.module_fuel_infinite) 
		{
			event.player.addStat(airship_create_module);
		}
		//if(event.crafting.getItem() == InitItemsEA.obsidian_shards) 
		//{
		//	event.player.addStat(nether_bound);//.triggerAchievement(InitAchievementsEA.nether_bound);
		//}
		
	}
	
	//Smelt an item achievement
	//@SubscribeEvent
	//public void onSmelt(PlayerEvent.ItemSmeltedEvent event) {
	//	if(event.smelting.getItem() == EbonArtsItems.purified_mystic_dust) {

	//		event.player.triggerAchievement(EbonArtsAchievements.smeltMysticDust);
		
	//	}
	//}
}
