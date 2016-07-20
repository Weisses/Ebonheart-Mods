package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.items.resources.ItemAirship;
import com.viesis.viescraft.common.items.resources.ItemBalloon;
import com.viesis.viescraft.common.items.resources.ItemEngine;
import com.viesis.viescraft.common.items.resources.ItemIgnition;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementAirborn;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementCreate;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementEngine;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementIgnition;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementLava;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementWater;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		registerItem(airship_balloon = new ItemBalloon());
		registerItem(airship_engine = new ItemEngine());
		registerItem(airship_ignition = new ItemIgnition());
		
		registerItem(item_airship_base = new ItemAirship());
		//item_airship_furnace = new ItemAirshipFurnace());
		
		
		//item_viesdenburg = new ItemViesdenburg());
		
		registerItem(achievement_airship_create_engine = new ItemAchievementEngine());
		registerItem(achievement_airship_create_ignition = new ItemAchievementIgnition());
		registerItem(achievement_airship_create = new ItemAchievementCreate());
		
		registerItem(achievement_airship_airborn = new ItemAchievementAirborn());
		registerItem(achievement_airship_water = new ItemAchievementWater());
		registerItem(achievement_airship_lava = new ItemAchievementLava());
		
		//test = new ItemAirship());
		
	}
	
	public static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getRegistryName());
	}
	
	//private static <V extends Item> V registerItem(V item) 
	//{
	//	GameRegistry.register(item);
	//	items.add(item);
		
	//	return item;
	//}
}
