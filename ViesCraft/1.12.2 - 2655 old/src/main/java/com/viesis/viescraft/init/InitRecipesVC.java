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
		/**
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_MAIN, 1), new Object[]{" F ", "FBF", " F ", 'B', Items.BOOK, 'F', Items.FEATHER});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksVC.AIRSHIP_WORKBENCH, 1), new Object[]{"C", "#", 'C', Blocks.CRAFTING_TABLE, '#', InitItemsVC.LOGIC_CHIP});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.ITEM_DISMOUNTER_NORMAL, 1), new Object[]{"  F", " S ", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		
		if(ViesCraftConfig.recipeDismounterPlayer)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.ITEM_DISMOUNTER_PLAYER, 1), new Object[]{" FF", " SF", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		}
		
    	//=================================================
        
		//Fuel
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.VIESOLINE_PELLETS, 8), new Object[]{"RCR", "CRC", "RCR", 'R', Items.REDSTONE, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.VIESOLINE_PELLETS, 8), new Object[]{"RCR", "CRC", "RCR", 'R', Items.REDSTONE, 'C', new ItemStack(Items.COAL, 1, 1)});
    	
    	//Parts
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.LOGIC_CHIP), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME), new Object[]{"ILI", "L#L", "ILI", 'I', Items.IRON_INGOT, 'L', InitItemsVC.LOGIC_CHIP, '#', Items.MINECART});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.AIRSHIP_ENGINE), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', InitItemsVC.LOGIC_CHIP});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.AIRSHIP_IGNITION), new Object[]{"IBI", "D#D", "GLG", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'L', InitItemsVC.LOGIC_CHIP, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.MAGMA});
    	
    	//Frame Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), new Object[]{"BBB", "LGL", " I ", 'L', InitItemsVC.LOGIC_CHIP, 'G', Items.GOLD_INGOT, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 1), new Object[]{"FLF", "L#L", "FLF", 'F', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', InitItemsVC.AIRSHIP_BASEFRAME});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 2), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 3), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 4), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 5), new Object[]{"FLF", "I#I", "FLF", 'F', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
    	//Core Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), new Object[]{"LIL", "G#G", " G ", 'L', InitItemsVC.LOGIC_CHIP, 'G', Blocks.GLASS, 'I', Items.IRON_INGOT, '#', Items.GOLD_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 1), new Object[]{"CLC", "L#L", "CLC", 'C', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', InitItemsVC.AIRSHIP_IGNITION});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 2), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 3), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 4), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 5), new Object[]{"CLC", "I#I", "CLC", 'C', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_CORE, 1, 4), 'I', Items.NETHER_STAR});

    	
    	//Engine Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), new Object[]{" IL", " BI", "G  ", 'L', InitItemsVC.LOGIC_CHIP, 'G', Items.GOLD_INGOT, 'B', Items.BLAZE_ROD, 'I', Items.IRON_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 1), new Object[]{"ELE", "L#L", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', InitItemsVC.AIRSHIP_ENGINE});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 2), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 3), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 4), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 5), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
    	//Balloon Upgrades
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), new Object[]{"###", "LGL", "#I#", 'L', InitItemsVC.LOGIC_CHIP, '#', Items.LEATHER, 'G', Items.GOLD_INGOT, 'I', Items.IRON_INGOT});
    	
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 1), new Object[]{"ELE", "L#L", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', InitItemsVC.AIRSHIP_BALLOON});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 2), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 1), 'I', Blocks.GOLD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 3), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 2), 'I', Blocks.DIAMOND_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 4), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 3), 'I', Blocks.EMERALD_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 5), new Object[]{"ELE", "I#I", "ELE", 'E', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 0), 'L', InitItemsVC.LOGIC_CHIP, '#', new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, 4), 'I', Items.NETHER_STAR});
    	
    	
//TEMP  //Airships V1
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V1_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, 29));
    	
    	//Airships V2
    	//Tier 1
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 5));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 6));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 0), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 7));
    	//Tier 2
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 8));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 9));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 10));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 11));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 12));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 13));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 1), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 14));
    	//Tier 3
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 15));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 16));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 17));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 18));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 19));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 2), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 20));
    	//Tier 4
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 21));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 22));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 23));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 24));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 3), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 25));
    	//Tier 5
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 26));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 27));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 28));
    	GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.ITEM_V2_AIRSHIP, 1, 4), new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, 29));
    	
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
    	
    	*/
	}
}
