package com.viesis.viescraft.common;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitItemsVC;



public class AchievementTriggersVC extends InitAchievementsVC {

	//Pickup an item achievement
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemPickupEvent event) 
	{
		
		//if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.draconium_dust)))
		//{
		//	event.player.addStat(mine_draconium_ore);//.triggerAchievement(InitAchievementsEA.mine_draconium_ore);
		//}
		
	}
	
	
	//Craft an item achievement
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event) 
	{
		if(event.crafting.getItem() == InitItemsVC.item_viesdenburg) 
		{
			event.player.addStat(airship_create);//.triggerAchievement(InitAchievementsEA.nether_bound);
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
