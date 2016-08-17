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
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_normal) 
		{
			event.player.addStat(airship_create);
		}
		
		if(event.crafting.getItem() == InitItemsVC.item_airship_black
		|| event.crafting.getItem() == InitItemsVC.item_airship_blue
		|| event.crafting.getItem() == InitItemsVC.item_airship_brown
		|| event.crafting.getItem() == InitItemsVC.item_airship_cyan
		|| event.crafting.getItem() == InitItemsVC.item_airship_gray
		|| event.crafting.getItem() == InitItemsVC.item_airship_green
		|| event.crafting.getItem() == InitItemsVC.item_airship_lightblue
		|| event.crafting.getItem() == InitItemsVC.item_airship_lightgray
		|| event.crafting.getItem() == InitItemsVC.item_airship_lime
		|| event.crafting.getItem() == InitItemsVC.item_airship_magenta
		|| event.crafting.getItem() == InitItemsVC.item_airship_orange
		|| event.crafting.getItem() == InitItemsVC.item_airship_pink
		|| event.crafting.getItem() == InitItemsVC.item_airship_purple
		|| event.crafting.getItem() == InitItemsVC.item_airship_red
		|| event.crafting.getItem() == InitItemsVC.item_airship_white
		|| event.crafting.getItem() == InitItemsVC.item_airship_yellow) 
		{
			event.player.addStat(airship_create_color);
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
