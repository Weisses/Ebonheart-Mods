package com.viesis.viescraft.common;

import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

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
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_v1
		|| event.crafting.getItem() == InitItemsVC.item_airship_v2
		|| event.crafting.getItem() == InitItemsVC.item_airship_v3
		|| event.crafting.getItem() == InitItemsVC.item_airship_v4) 
		{
			event.player.addStat(airship_create);
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
