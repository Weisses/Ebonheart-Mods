package com.ebonheart.EbonArtsMod.common.world;

import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraftforge.common.ChestGenHooks;

public class WorldChestHooks extends InitItemsEA {

	/**
	public static void init()
	{
		//Common
		ChestHookEACommon(draconium_dust);
		ChestHookEACommon(velious);
		ChestHookEACommon(arcanite);
		ChestHookEACommon(dragon_fruit);
		
		//Uncommon
		ChestHookEAUncommon(obsidian_shards);
		ChestHookEAUncommon(glowstone_shards);
		
		//RareA
		ChestHookEARareA(katcheen);
		ChestHookEARareA(necrocite);
		ChestHookEARareA(soularite);
		ChestHookEARareA(ebonheart);
		
		//RareB
		ChestHookEARareB(arcanite_pickaxe);
		ChestHookEARareB(arcanite_axe);
		ChestHookEARareB(arcanite_shovel);
		ChestHookEARareB(arcanite_hoe);
		ChestHookEARareB(arcanite_sword);
		
		//ChestHookEARareB(arcanite_helmet);
		//ChestHookEARareB(arcanite_chestplate);
		//ChestHookEARareB(arcanite_leggings);
		//ChestHookEARareB(arcanite_boots);
		
		//EpicA
		ChestHookEAEpicA(katcheen_pickaxe);
		ChestHookEAEpicA(katcheen_axe);
		ChestHookEAEpicA(katcheen_shovel);
		ChestHookEAEpicA(katcheen_hoe);
		ChestHookEAEpicA(katcheen_sword);
		
		//ChestHookEAEpicA(katcheen_helmet);
		//ChestHookEAEpicA(katcheen_chestplate);
		//ChestHookEAEpicA(katcheen_leggings);
		//ChestHookEAEpicA(katcheen_boots);
		
		ChestHookEAEpicA(glowing_disc);
		ChestHookEAEpicA(shimmering_disc);
		ChestHookEAEpicA(laminate_disc);
		ChestHookEAEpicA(resilient_disc);
		ChestHookEAEpicA(dismal_disc);
		ChestHookEAEpicA(ethereal_disc);
		
		//EpicB
		ChestHookEAEpicB(frostbite);
		ChestHookEAEpicB(massacre);
		ChestHookEAEpicB(blazefury);
		ChestHookEAEpicB(despair);
		ChestHookEAEpicB(souleater);
		
	}
	
	public static void ChestHookEACommon(Item item)
	{
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 3, 40));
		
		
	}
	
	public static void ChestHookEAUncommon(Item item)
	{
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 25));
		
		
	}
	
	public static void ChestHookEARareA(Item item)
	{
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 2, 10));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 10));
		
		
	}
	
	public static void ChestHookEARareB(Item item)
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 8));
	}
	
	public static void ChestHookEAEpicA(Item item)
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 3));
	}
	
	public static void ChestHookEAEpicB(Item item)
	{
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		//ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		//ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		//ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		//ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
		//ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(item), 1, 1, 1));
	}
	
	**/
}
