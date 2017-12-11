package com.viesis.viescraft.common;

import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.item.ItemStack;
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
/**	@SubscribeEvent
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
		
		if(event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 1).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 2).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 3).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 4).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 5).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 6).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 7).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 8).getItem()
		|| event.crafting.getItem() == new ItemStack(InitItemsVC.airship_module, 1, 9).getItem()) 
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
	 * */
}
