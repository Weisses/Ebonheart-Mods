package com.viesis.viescraft.common.items.crafting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

public class CraftingManagerVC {
	
    /** The static instance of this class */
    private static final CraftingManagerVC INSTANCE = new CraftingManagerVC();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    
    /**
     * Returns the static instance of this class
     */
    public static CraftingManagerVC getInstance()
    {
        /** The static instance of this class */
        return INSTANCE;
    }
    
    public CraftingManagerVC()
    {
    	
    	this.addRecipe(new ItemStack(InitItemsVC.guidebook_main, 1), new Object[]{" F ", "FBF", " F ", 'B', Items.BOOK, 'F', Items.FEATHER});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_controls), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.FEATHER));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_paint), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.DYE, 1, 0));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_socket), new ItemStack(InitItemsVC.guidebook_main), new ItemStack(Items.REDSTONE));
		
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_controls));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_paint));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.guidebook_main), new ItemStack(InitItemsVC.guidebook_socket));
		
		this.addRecipe(new ItemStack(InitBlocksVC.airship_workbench, 1), new Object[]{"ICI", "GFG", "#L#", 'C', Blocks.CRAFTING_TABLE, 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'F', Items.FIRE_CHARGE, '#', Blocks.IRON_BLOCK, 'L', Blocks.LAPIS_BLOCK});
		
		this.addRecipe(new ItemStack(InitItemsVC.airship_dismounter, 1), new Object[]{"  F", " S ", "L  ", 'L', Items.LEATHER, 'S', Items.STICK, 'F', Items.FEATHER});
		
    	//=================================================
        
    	//Airship parts
    	this.addRecipe(new ItemStack(InitItemsVC.airship_balloon, 1), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, 'R', '#', Items.STRING});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_engine, 1), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', Blocks.REDSTONE_BLOCK});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.field_189877_df});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal, 1), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal, 1), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal, 1), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	
    	//Airship modules
    	this.addRecipe(new ItemStack(InitItemsVC.module_chip, 1), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_small, 1), new Object[]{"CNC", "D#D", "CNC", 'C', InitItemsVC.module_chip, 'N', Items.GOLD_NUGGET, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_large, 1), new Object[]{"C#C", "D#D", "CEC", 'C', InitItemsVC.module_chip, 'E', Items.EMERALD, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_speed_increase_minor, 1), new Object[]{"CGC", "FDF", "CGC", 'C', InitItemsVC.module_chip, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	this.addRecipe(new ItemStack(InitItemsVC.module_fuel_infinite, 1), new Object[]{"CBC", "Q#Q", "CBC", 'C', InitItemsVC.module_chip, 'B', Items.BLAZE_ROD, 'Q', Items.QUARTZ, '#', Items.NETHER_STAR});
    	
		//Paints using coal
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_black, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_red, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_green, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_brown, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_blue, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_purple, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_cyan, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lightgray, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_gray, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_pink, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lime, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_yellow, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lightblue, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_magenta, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_orange, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_white, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		
		//Paints using charcoal
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_black, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_red, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_green, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_brown, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_blue, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_purple, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_cyan, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lightgray, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_gray, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_pink, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lime, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_yellow, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_lightblue, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_magenta, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_orange, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint_white, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		
    	//=================================================
		
		//Airship v1 colors
		//Recipes that dye the basic airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_black), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_red), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_green), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_brown), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_blue), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_purple), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_cyan), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lightgray), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_gray), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_pink), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lime), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_yellow), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_lightblue), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_magenta), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_orange), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_white), new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 conversion back into normal.
		//Recipes that strip the dye off of airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_normal), new ItemStack(InitItemsVC.item_airship_white));
		
    	//=================================================
		
		//Airship v2 colors
		//Recipes that dye the basic airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_black), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_red), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_green), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_brown), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_blue), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_purple), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_cyan), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_lightgray), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_gray), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_pink), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_lime), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_yellow), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_lightblue), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_magenta), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_orange), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_white), new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v2 conversion back into normal.
		//Recipes that strip the dye off of airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal), new ItemStack(InitItemsVC.item_airship_v2_white));
		
		//================================================
		
		//Airship v3 colors
		//Recipes that dye the basic airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_black), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_red), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_green), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_brown), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_blue), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_purple), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_cyan), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_lightgray), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_gray), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_pink), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_lime), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_yellow), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_lightblue), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_magenta), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_orange), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_white), new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v3 conversion back into normal.
		//Recipes that strip the dye off of airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal), new ItemStack(InitItemsVC.item_airship_v3_white));
		
		//================================================
		
		//Airship v4 colors
		//Recipes that dye the basic airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_black), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_red), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_green), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_brown), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_blue), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_purple), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_cyan), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_lightgray), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_gray), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_pink), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_lime), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_yellow), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_lightblue), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_magenta), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_orange), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_white), new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v4 conversion back into normal.
		//Recipes that strip the dye off of airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal), new ItemStack(InitItemsVC.item_airship_v4_white));
		
        Collections.sort(this.recipes, new Comparator<IRecipe>()
        {
            public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_)
            {
                return p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes ? 1 : (p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes ? -1 : (p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize() ? -1 : (p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize() ? 1 : 0)));
            }
        });
    }
    
    /**
     * Adds a shaped recipe to the games recipe list.
     */
    public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        
        if (recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);
            
            for (String s2 : astring)
            {
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        else
        {
            while (recipeComponents[i] instanceof String)
            {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        
        Map<Character, ItemStack> map;
        
        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2)
        {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = null;
            
            if (recipeComponents[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if (recipeComponents[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if (recipeComponents[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)recipeComponents[i + 1];
            }
            
            map.put(character, itemstack);
        }
        
        ItemStack[] aitemstack = new ItemStack[j * k];
        
        for (int l = 0; l < j * k; ++l)
        {
            char c0 = s.charAt(l);
            
            if (map.containsKey(Character.valueOf(c0)))
            {
                aitemstack[l] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[l] = null;
            }
        }
        
        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
    
    /**
     * Adds a shapeless crafting recipe to the the game.
     */
    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents)
    {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();
        
        for (Object object : recipeComponents)
        {
            if (object instanceof ItemStack)
            {
                list.add(((ItemStack)object).copy());
            }
            else if (object instanceof Item)
            {
                list.add(new ItemStack((Item)object));
            }
            else
            {
                if (!(object instanceof Block))
                {
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }
                
                list.add(new ItemStack((Block)object));
            }
        }
        
        this.recipes.add(new ShapelessRecipes(stack, list));
    }
    
    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    public void addRecipe(IRecipe recipe)
    {
        this.recipes.add(recipe);
    }
    
    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    @Nullable
    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getCraftingResult(craftMatrix);
            }
        }
        
        return null;
    }
    
    public ItemStack[] getRemainingItems(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getRemainingItems(craftMatrix);
            }
        }
        
        ItemStack[] aitemstack = new ItemStack[craftMatrix.getSizeInventory()];
        
        for (int i = 0; i < aitemstack.length; ++i)
        {
            aitemstack[i] = craftMatrix.getStackInSlot(i);
        }
        
        return aitemstack;
    }
    
    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }
}
