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
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Items.LAVA_BUCKET});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_base, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
		
		
		
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
		
		
		
	}
	
	public static void initSmeltingRecipe()
	{
		
		
		
	}
}
