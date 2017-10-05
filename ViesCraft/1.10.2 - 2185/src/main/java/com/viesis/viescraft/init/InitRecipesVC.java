package com.viesis.viescraft.init;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitRecipesVC {
	
	public static void initShapedRecipe()
	{
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.guidebook_main, 1), new Object[]{" F ", "FBF", " F ", 'B', Items.BOOK, 'F', Items.FEATHER});
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_controls), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.FEATHER));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_paint), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.DYE, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_socket), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.REDSTONE));
		
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_controls));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_paint));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_socket));
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksVC.airship_workbench, 1), new Object[]{"ICI", "GFG", "#L#", 'C', Blocks.CRAFTING_TABLE, 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'F', Items.FIRE_CHARGE, '#', Blocks.IRON_BLOCK, 'L', Blocks.LAPIS_BLOCK});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_dismounter, 1), new Object[]{"  F", " S ", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		
    	//=================================================
        
		//Fuel
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.viesoline_pellets), new ItemStack(Items.COAL), new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsVC.viesoline_pellets), new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.REDSTONE));
		
    	//Airship parts
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_balloon, 1), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_engine, 1), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', Blocks.REDSTONE_BLOCK});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.MAGMA});
    	
    	//Airship Frames
    	//Tier 1
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 0), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 0), 'M', Items.MINECART});
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
    	
    	if(ViesCraftConfig.recipeMythic)
    	{
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 26), new Object[]{"###", "#M#", "###", '#', Items.END_CRYSTAL, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 25)});
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 27), new Object[]{"###", "#M#", "###", '#', Items.WATER_BUCKET, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 28), new Object[]{"###", "#M#", "###", '#', Items.LAVA_BUCKET, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 29), new Object[]{"###", "#M#", "###", '#', Items.ENDER_EYE, 'M', new ItemStack(InitItemsVC.airship_frame, 1, 26)});
    	}
    	
    	//=================================================
    	
    	//Airships
    	for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_v1, 1, meta.getMetadata()), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, meta.getMetadata())});
    		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_v2, 1, meta.getMetadata()), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, meta.getMetadata())});
        	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_v3, 1, meta.getMetadata()), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, meta.getMetadata())});
        	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_airship_v4, 1, meta.getMetadata()), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, meta.getMetadata())});
		}
    	
    	//=================================================
    	
    	//Airship modules
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 0), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 1), new Object[]{"CGC", "FDF", "CGC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 2), new Object[]{"CDC", "FEF", "CDC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'E', Items.EMERALD, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 3), new Object[]{"CNC", "D#D", "CNC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'N', Items.GOLD_NUGGET, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 4), new Object[]{"C#C", "D#D", "CEC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'E', Items.EMERALD, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 5), new Object[]{"CBC", "Q#Q", "CBC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'B', Items.BLAZE_ROD, 'Q', Items.QUARTZ, '#', Items.NETHER_STAR});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 6), new Object[]{"CBC", "Q#Q", "CBC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'B', Items.GLASS_BOTTLE, 'Q', Items.QUARTZ, '#', Items.GHAST_TEAR});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 7), new Object[]{"CGC", "F#F", "CGC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'G', Items.GLOWSTONE_DUST, 'F', Items.FEATHER, '#', Items.DIAMOND});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 8), new Object[]{"CPC", "D#D", "CPC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'P', Items.ENDER_PEARL, 'D', Items.DIAMOND, '#', Items.BLAZE_ROD});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 9), new Object[]{"CPC", "E#E", "CPC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'P', Items.ENDER_PEARL, 'E', Items.EMERALD, '#', Items.BLAZE_ROD});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 10), new Object[]{"CPC", "Q#Q", "CPC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'P', Items.ENDER_PEARL, 'Q', Items.QUARTZ, '#', Blocks.JUKEBOX});
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.airship_module, 1, 11), new Object[]{"CQC", "N#N", "CQC", 'C', new ItemStack(InitItemsVC.airship_module, 1, 0), 'N', Items.GOLD_NUGGET, 'Q', Items.QUARTZ, '#', Items.CLOCK});
    	
    	//=================================================
		
		//Colorizer using coal or charcoal
    	GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_balloon_colorizer), new Object[]{"I#I", "#M#", "I#I", '#', new ItemStack(Items.COAL, 1, 0), 'I', Items.IRON_INGOT, 'M', new ItemStack(InitItemsVC.airship_module, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsVC.item_balloon_colorizer), new Object[]{"I#I", "#M#", "I#I", '#', new ItemStack(Items.COAL, 1, 1), 'I', Items.IRON_INGOT, 'M', new ItemStack(InitItemsVC.airship_module, 1, 0)});
    	
    	//=================================================
		
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
		
	}
}
