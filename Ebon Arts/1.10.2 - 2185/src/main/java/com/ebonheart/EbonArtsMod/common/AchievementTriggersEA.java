package com.ebonheart.EbonArtsMod.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import com.ebonheart.EbonArtsMod.api.AchievementsEA;
import com.ebonheart.EbonArtsMod.init.InitBlocksEA;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;
import com.ebonheart.EbonArtsMod.init.InitAchievementsEA;

public class AchievementTriggersEA extends InitAchievementsEA {

	//Pickup an item achievement
	@SubscribeEvent
	public void onPickup(PlayerEvent.ItemPickupEvent event) 
	{
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.draconium_dust)))
		{
			event.player.addStat(mine_draconium_ore);//.triggerAchievement(InitAchievementsEA.mine_draconium_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.velious)))
		{
			event.player.addStat(mine_velious_ore);//.triggerAchievement(InitAchievementsEA.mine_velious_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.arcanite)))
		{
			event.player.addStat(mine_arcanite_ore);//.triggerAchievement(InitAchievementsEA.mine_arcanite_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.katcheen)))
		{
			event.player.addStat(mine_katcheen_ore);//.triggerAchievement(InitAchievementsEA.mine_katcheen_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.necrocite)))
		{
			event.player.addStat(mine_necrocite_ore);//.triggerAchievement(InitAchievementsEA.mine_necrocite_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.soularite)))
		{
			event.player.addStat(mine_soularite_ore);//.triggerAchievement(InitAchievementsEA.mine_soularite_ore);
		}
		
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(InitItemsEA.ebonheart)))
		{
			event.player.addStat(ebonheart);//.triggerAchievement(InitAchievementsEA.ebonheart);
		}
	}
	
	//Craft an item achievement
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event) 
	{
		if(event.crafting.getItem() == InitItemsEA.obsidian_shards) 
		{
			event.player.addStat(nether_bound);//.triggerAchievement(InitAchievementsEA.nether_bound);
		}
		
		if(event.crafting.getItem() == InitItemsEA.glowstone_shards) 
		{
			event.player.addStat(nether_doomed);//.triggerAchievement(InitAchievementsEA.nether_bound);
		}
		
		if(event.crafting.getItem() == InitItemsEA.glowing_disc) 
		{
			event.player.addStat(glowing_disc);//.triggerAchievement(InitAchievementsEA.glowing_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.shimmering_disc) 
		{
			event.player.addStat(shimmering_disc);//.triggerAchievement(InitAchievementsEA.shimmering_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.laminate_disc) 
		{
			event.player.addStat(laminate_disc);//.triggerAchievement(InitAchievementsEA.laminate_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.resilient_disc) 
		{
			event.player.addStat(resilient_disc);//.triggerAchievement(InitAchievementsEA.resilient_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.dismal_disc) 
		{
			event.player.addStat(dismal_disc);//.triggerAchievement(InitAchievementsEA.dismal_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.ethereal_disc) 
		{
			event.player.addStat(ethereal_disc);//.triggerAchievement(InitAchievementsEA.ethereal_disc);
		}
		
		if(event.crafting.getItem() == InitItemsEA.empowered_blade) 
		{
			event.player.addStat(empowered_blade);//.triggerAchievement(InitAchievementsEA.empowered_blade);
		}
		
		if(event.crafting.getItem() == InitItemsEA.deception) 
		{
			event.player.addStat(deception);//.triggerAchievement(InitAchievementsEA.deception);
		}
		
		if(event.crafting.getItem() == InitItemsEA.frostbite) 
		{
			event.player.addStat(frostbite);//.triggerAchievement(InitAchievementsEA.frostbite);
		}
		
		if(event.crafting.getItem() == InitItemsEA.massacre) 
		{
			event.player.addStat(massacre);//.triggerAchievement(InitAchievementsEA.massacre);
		}
		
		if(event.crafting.getItem() == InitItemsEA.blazefury) 
		{
			event.player.addStat(blazefury);//.triggerAchievement(InitAchievementsEA.blazefury);
		}
		
		if(event.crafting.getItem() == InitItemsEA.despair) 
		{
			event.player.addStat(despair);//.triggerAchievement(InitAchievementsEA.despair);
		}
		
		if(event.crafting.getItem() == InitItemsEA.souleater) 
		{
			event.player.addStat(souleater);//.triggerAchievement(InitAchievementsEA.souleater);
		}
		
		if(event.crafting.getItem() == InitItemsEA.enchanted_ebonheart) 
		{
			event.player.addStat(enchanted_ebonheart);//.triggerAchievement(InitAchievementsEA.enchanted_ebonheart);
		}
		
		if(event.crafting.getItem() == InitItemsEA.burnished_helmet
		|| event.crafting.getItem() == InitItemsEA.burnished_chestplate
		|| event.crafting.getItem() == InitItemsEA.burnished_leggings
		|| event.crafting.getItem() == InitItemsEA.burnished_boots) 
		{
			event.player.addStat(burnished_armor);
		}
		
		if(event.crafting.getItem() == InitItemsEA.scalemail_helmet
		|| event.crafting.getItem() == InitItemsEA.scalemail_chestplate
		|| event.crafting.getItem() == InitItemsEA.scalemail_leggings
		|| event.crafting.getItem() == InitItemsEA.scalemail_boots) 
		{
			event.player.addStat(scalemail_armor);
		}
		
		if(event.crafting.getItem() == InitItemsEA.vengeance_helmet
		|| event.crafting.getItem() == InitItemsEA.vengeance_chestplate
		|| event.crafting.getItem() == InitItemsEA.vengeance_leggings
		|| event.crafting.getItem() == InitItemsEA.vengeance_boots) 
		{
			event.player.addStat(vengeance_armor);
		}
		
		if(event.crafting.getItem() == InitItemsEA.celestial_helmet
		|| event.crafting.getItem() == InitItemsEA.celestial_chestplate
		|| event.crafting.getItem() == InitItemsEA.celestial_leggings
		|| event.crafting.getItem() == InitItemsEA.celestial_boots) 
		{
			event.player.addStat(celestial_armor);
		}
		
		if(event.crafting.getItem() == InitItemsEA.necrosis) 
		{
			event.player.addStat(necrosis);
		}
		
		if(event.crafting.getItem() == InitItemsEA.consecration) 
		{
			event.player.addStat(consecration);
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
