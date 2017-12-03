package com.viesis.viescraft.init;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitRecipesVC {
	
	public static void initShapedRecipe()
	{
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.guidebook_main, 1), new Object[]{" F ", "FBF", " F ", 'B', Items.BOOK, 'F', Items.FEATHER});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksVC.airship_workbench, 1), new Object[]{"C", "#", 'C', Blocks.CRAFTING_TABLE, '#', InitItemsVC.logic_chip});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.dismounter_normal, 1), new Object[]{"  F", " S ", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		
		if(ViesCraftConfig.recipeDismounterPlayer)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.dismounter_player, 1), new Object[]{" FF", " SF", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		}
		
    	//=================================================
        
		//Fuel
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.viesoline_pellets, 8), new Object[]{"RCR", "CRC", "RCR", 'R', Items.REDSTONE, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.viesoline_pellets, 8), new Object[]{"RCR", "CRC", "RCR", 'R', Items.REDSTONE, 'C', new ItemStack(Items.COAL, 1, 1)});
    	
    	//Parts
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.logic_chip), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame), new Object[]{"ILI", "L#L", "ILI", 'I', Items.IRON_INGOT, 'L', InitItemsVC.logic_chip, '#', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_engine), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', InitItemsVC.logic_chip});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_ignition), new Object[]{"IBI", "D#D", "GLG", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'L', InitItemsVC.logic_chip, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.MAGMA});
    	
    	//Frame Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 0), new Object[]{"BBB", "LGL", " I ", 'L', InitItemsVC.logic_chip, 'G', Items.GOLD_INGOT, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 1), new Object[]{"FLF", "L#L", "FLF", 'F', new ItemStack(InitItemsVC.upgrade_frame, 1, 0), 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_frame});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 2), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.upgrade_frame, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_frame, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 3), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.upgrade_frame, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_frame, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 4), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.upgrade_frame, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_frame, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_frame, 1, 5), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.upgrade_frame, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_frame, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
    	//Core Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new Object[]{"LIL", "G#G", " G ", 'L', InitItemsVC.logic_chip, 'G', Blocks.GLASS, 'I', Items.IRON_INGOT, '#', Items.GOLD_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new Object[]{"CLC", "L#L", "CLC", 'C', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_ignition});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 5), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 4), 'I', Items.NETHER_STAR});

    	
    	//Engine Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 0), new Object[]{" IL", " BI", "G  ", 'L', InitItemsVC.logic_chip, 'G', Items.GOLD_INGOT, 'B', Items.BLAZE_ROD, 'I', Items.IRON_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 1), new Object[]{"ELE", "L#L", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_engine});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 2), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 3), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 4), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 5), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
    	//Balloon Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), new Object[]{"###", "LGL", "#I#", 'L', InitItemsVC.logic_chip, '#', Items.LEATHER, 'G', Items.GOLD_INGOT, 'I', Items.IRON_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 1), new Object[]{"ELE", "L#L", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_balloon});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 2), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 3), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 4), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 5), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
    	//Cores
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.core_shard), new Object[]{"CIC", "L#L", "DDD", 'L', InitItemsVC.logic_chip, 'D', Items.DIAMOND, '#', Items.REDSTONE});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', InitItemsVC.logic_chip, 'I', Blocks.IRON_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 0), 'I', Blocks.REDSTONE_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 5), new Object[]{"CIC", "I#I", "CIC", 'C', InitItemsVC.core_shard, '#', new ItemStack(InitItemsVC.upgrade_core, 1, 4), 'I', Items.NETHER_STAR});

    	//Frames
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 0), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_engine, 'I', Blocks.IRON_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 1), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 0), 'I', Blocks.REDSTONE_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 2), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 3), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 4), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_engine, 1, 5), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_engine, 1, 4), 'I', Items.NETHER_STAR});
    	
    	//Balloons
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', InitItemsVC.airship_balloon, 'I', Blocks.IRON_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 1), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 0), 'I', Blocks.REDSTONE_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 2), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 3), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 4), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.upgrade_balloon, 1, 5), new Object[]{"LIL", "I#I", "LIL", 'L', InitItemsVC.logic_chip, '#', new ItemStack(InitItemsVC.upgrade_balloon, 1, 4), 'I', Items.NETHER_STAR});
    	/**
//TEMP  //Airship Frames
    	//Tier 1
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 0));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 1));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 2));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 3));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 4));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 5));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 6));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 0), new ItemStack(InitItemsVC.airship_frame, 1, 7));
    	
    	//Tier 2
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 8));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 9));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 10));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 11));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 12));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 13));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 1), new ItemStack(InitItemsVC.airship_frame, 1, 14));
    	
    	//Tier 3
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 15));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 16));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 17));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 18));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 19));
    	//GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 2), new ItemStack(InitItemsVC.airship_frame, 1, 20));
    	
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new ItemStack(InitItemsVC.airship_frame, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new ItemStack(InitItemsVC.airship_frame, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new ItemStack(InitItemsVC.airship_frame, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new ItemStack(InitItemsVC.airship_frame, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 3), new ItemStack(InitItemsVC.airship_frame, 1, 25));
    	
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new ItemStack(InitItemsVC.airship_frame, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new ItemStack(InitItemsVC.airship_frame, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new ItemStack(InitItemsVC.airship_frame, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.upgrade_core, 1, 4), new ItemStack(InitItemsVC.airship_frame, 1, 29));
    	
    	*/
    	
//TEMP  //Airships V1
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v1, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v1, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v1, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v1, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v1, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v1, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v1, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v1, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v1, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v1, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v1, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v1, 1, 29));
    	
    	//Airships V2
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v2, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v2, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v2, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v2, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v2, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v2, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v2, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v2, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v2, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v2, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v2, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v2, 1, 29));
    	
    	//Airships V3
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v3, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v3, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v3, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v3, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v3, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v3, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v3, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v3, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v3, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v3, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v3, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v3, 1, 29));
    	
    	//Airships V4
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new ItemStack(InitItemsVC.item_airship_v4, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 1), new ItemStack(InitItemsVC.item_airship_v4, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 2), new ItemStack(InitItemsVC.item_airship_v4, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v4, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v4, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v4, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v4, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 3), new ItemStack(InitItemsVC.item_airship_v4, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v4, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v4, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v4, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 4), new ItemStack(InitItemsVC.item_airship_v4, 1, 29));
    	
    	
    	/**GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 0), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 0), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 1), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 1), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 2), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 2), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 3), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 3), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 4), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 4), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 5), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 5), 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 6), new Object[]{"###", "#M#", "###", '#', Blocks.SANDSTONE, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 7), new Object[]{"###", "#M#", "###", '#', Blocks.BRICK_BLOCK, 'M', Items.MINECART});
    	//Tier 2
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 8), new Object[]{"###", "#M#", "###", '#', Blocks.BONE_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 9), new Object[]{"###", "#M#", "###", '#', Blocks.IRON_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 10), new Object[]{"###", "#M#", "###", '#', Blocks.REDSTONE_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 11), new Object[]{"###", "#M#", "###", '#', Blocks.GOLD_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 12), new Object[]{"###", "#M#", "###", '#', Blocks.LAPIS_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 13), new Object[]{"###", "#M#", "###", '#', Blocks.SLIME_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 14), new Object[]{"###", "#M#", "###", '#', Blocks.MYCELIUM, 'M', Items.MINECART});
    	//Tier 3
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 15), new Object[]{"###", "#M#", "###", '#', Blocks.NETHER_BRICK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 16), new Object[]{"###", "#M#", "###", '#', Blocks.SOUL_SAND, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 17), new Object[]{"###", "#M#", "###", '#', Blocks.QUARTZ_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 18), new Object[]{"###", "#M#", "###", '#', Blocks.ICE, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 19), new Object[]{"###", "#M#", "###", '#', Blocks.GLOWSTONE, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 20), new Object[]{"###", "#M#", "###", '#', Blocks.OBSIDIAN, 'M', Items.MINECART});
    	//Tier 4
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 21), new Object[]{"###", "#M#", "###", '#', Blocks.DIAMOND_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 22), new Object[]{"###", "#M#", "###", '#', Blocks.EMERALD_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 23), new Object[]{"###", "#M#", "###", '#', Blocks.PRISMARINE, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 24), new Object[]{"###", "#M#", "###", '#', Blocks.PURPUR_BLOCK, 'M', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 25), new Object[]{"###", "#M#", "###", '#', Items.NETHER_STAR, 'M', Items.MINECART});
    	*/
    	
    	
    	//if(ViesCraftConfig.recipeMythic)
    	//{
    		//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 26), new Object[]{"###", "#M#", "###", '#', Items.END_CRYSTAL, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 25)});
    		//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 27), new Object[]{"###", "#M#", "###", '#', Items.WATER_BUCKET, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    		//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 28), new Object[]{"###", "#M#", "###", '#', Items.LAVA_BUCKET, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    		//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 29), new Object[]{"###", "#M#", "###", '#', Items.ENDER_EYE, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    	//}
    	
    	//=================================================
    	
    	//Airships
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_v1_airship, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_v2_airship, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_v3_airship, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_v4_airship, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame});
    	
    	//=================================================
    	
    	//Module Types
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), new Object[]{"LLL", "LEL", "LLL", 'L', InitItemsVC.logic_chip, 'E', Items.EMERALD});
    	
    	//Altitude
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()),  new Object[]{
    			"GFG", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'F', Items.FEATHER, 'G', Items.GLOWSTONE_DUST, '#', Blocks.REDSTONE_TORCH});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())});
    	
    	//Speed
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.SPEED_LESSER.getMetadata()),  new Object[]{
    			"GFG", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'F', Items.FLINT, 'G', Items.GUNPOWDER, '#', Items.FIRE_CHARGE});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.SPEED_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.SPEED_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.SPEED_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())});
    	
    	//Storage
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()),  new Object[]{
    			"TRT", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'T', Blocks.TRIPWIRE_HOOK, 'R', Items.REDSTONE, '#', Blocks.CHEST});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())});
    	
    	//Fuel
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.FUEL_LESSER.getMetadata()),  new Object[]{
    			"BSB", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'S', Blocks.STONE_PRESSURE_PLATE, 'B', Items.BLAZE_POWDER, '#', Items.FIRE_CHARGE});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.FUEL_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.FUEL_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())});
    	
    	//Music
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()),  new Object[]{
    			"RNR", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'N', Blocks.NOTEBLOCK, 'R', Items.REDSTONE, '#', Blocks.JUKEBOX});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.MUSIC_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.MUSIC_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata())});
    	
    	//Cruise
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()),  new Object[]{
    			"LGL", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'L', Blocks.LEVER, 'G', Items.GLOWSTONE_DUST, '#', Items.CLOCK});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.CRUISE_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())});
    	
    	//Water
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.WATER_LESSER.getMetadata()),  new Object[]{
    			"SFS", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'F', Items.COMPASS, 'S', Items.SLIME_BALL, '#', Items.BOAT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.WATER_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.WATER_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.WATER_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.WATER_NORMAL.getMetadata())});
    	
    	//Infinite Fuel
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()),  new Object[]{
    			"EBE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'B', Items.BLAZE_ROD, 'E', Items.ENDER_PEARL, '#', Items.GHAST_TEAR});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()),  new Object[]{
    			"DDD", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'D', Items.DIAMOND, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata()),  new Object[]{
    			"EEE", "Q#Q", "MPM", 
    			'M', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.BASE.getMetadata()), 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 
    			'Q', Items.QUARTZ, 'E', Items.EMERALD, '#', new ItemStack(InitItemsVC.module_type, 1, EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())});
    	
    	
    	
    	//=================================================
		
		//Colorizer using coal or charcoal
    	//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_balloon_colorizer), new Object[]{"I#I", "#M#", "I#I", '#', new ItemStack(Items.COAL, 1, 0), 'I', Items.IRON_INGOT, 'M', new ItemStack(InitItemsVC.airship_module, 1, 0)});
		//GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_balloon_colorizer), new Object[]{"I#I", "#M#", "I#I", '#', new ItemStack(Items.COAL, 1, 1), 'I', Items.IRON_INGOT, 'M', new ItemStack(InitItemsVC.airship_module, 1, 0)});
    	
    	//=================================================
		/**
		//Balloon Patterns
		//Plain
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 0), new Object[]{"LLL", "LLL", "L#L", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 1), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 0), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 2), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 1), new ItemStack(Items.NETHER_WART));
		//Checker
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 3), new Object[]{"ILI", "LIL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 4), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 3), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 5), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 4), new ItemStack(Items.NETHER_WART));
		//Polka Dot
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 6), new Object[]{"ILI", "LLL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 7), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 6), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 8), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 7), new ItemStack(Items.NETHER_WART));
		//Zigzag
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 9), new Object[]{"ILL", "LIL", "L#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 10), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 9), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 11), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 10), new ItemStack(Items.NETHER_WART));
		//Creeper
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 12), new Object[]{"IGI", "LGL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0), 'G', new ItemStack(Items.GUNPOWDER)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 13), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 12), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 14), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 13), new ItemStack(Items.NETHER_WART));
		//Water
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 15), new Object[]{"ILI", "LBL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0), 'B', new ItemStack(Items.WATER_BUCKET)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 16), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 15), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 17), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 16), new ItemStack(Items.NETHER_WART));
		//Lava
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 18), new Object[]{"ILI", "LBL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0), 'B', new ItemStack(Items.LAVA_BUCKET)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 19), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 18), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 20), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 19), new ItemStack(Items.NETHER_WART));
		//Ender
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 21), new Object[]{"ILI", "LEL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0), 'E', new ItemStack(Items.ENDER_PEARL)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 22), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 21), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 23), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 22), new ItemStack(Items.NETHER_WART));
		//Tools
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 24), new Object[]{"ILI", "LTL", "I#I", '#', new ItemStack(InitItemsVC.airship_module, 1, 0), 'L', Items.LEATHER, 'I', new ItemStack(Items.DYE, 1, 0), 'T', new ItemStack(Items.DIAMOND)});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 25), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 24), new ItemStack(Items.ENDER_EYE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 26), new ItemStack(InitItemsVC.airship_balloon_pattern, 1, 25), new ItemStack(Items.NETHER_WART));
		*/
	}
}
