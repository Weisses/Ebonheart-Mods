package com.viesis.viescraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.configs.ViesCraftConfig;

public class InitRecipesVC {
	
	public static void initShapedRecipe()
	{
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon, 1), new Object[]{"RLR", "L#L", "RLR", 'L', Items.LEATHER, 'R', Items.RABBIT_HIDE, '#', Items.STRING});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_engine, 1), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', Blocks.REDSTONE_BLOCK});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.field_189877_df});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
		
		
		
		//=================================
		
		
		
		//Paints using coal
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_black, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_red, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_green, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_brown, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_blue, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_purple, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_cyan, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lightgray, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_gray, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_pink, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lime, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_yellow, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lightblue, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_magenta, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_orange, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_white, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		
		//Paints using charcoal
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_black, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_red, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_green, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_brown, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_blue, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_purple, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_cyan, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lightgray, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_gray, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_pink, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lime, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_yellow, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_lightblue, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_magenta, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_orange, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_paint_white, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		
		
		
		
		/**
		
		if(!EbonArtsConfiguration.toolRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_pickaxe), new Object[]{"AAA", " S ", " S ", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.necrosis), new Object[]{"B#B", " I ", " N ", 'N', InitItemsEA.necrocite, 'B', InitBlocksEA.necrocite_block, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.consecration), new Object[]{"B#B", " I ", " S ", 'S', InitItemsEA.soularite, 'B', InitBlocksEA.soularite_block, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		}
		else
		{
			
		}
		
		*/
	}
	
	
	
	public static void initShapelessRecipe()
	{
		//Airship colors
		//Recipes that dye the basic airship into any color
		//Note: also returns an empty bucket
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_black), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_red), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_green), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_brown), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_blue), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_purple), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_cyan), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lightgray), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_gray), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_pink), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lime), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_yellow), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lightblue), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_magenta), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_orange), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_white), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship conversion back into normal.
		//Recipes that strip the dye off of airships
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_black));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_red));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_green));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_brown));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_blue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_purple));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_cyan));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lightgray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_gray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_pink));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lime));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_yellow));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lightblue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_magenta));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_orange));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_white));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_normal));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_normal));
		
		
		
	}
	
	public static void initSmeltingRecipe()
	{
		
		
		
	}
}
