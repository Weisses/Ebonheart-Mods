package com.viesis.viescraft.common.items.decrafting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

public class DeCraftingManagerVC {
	
    /** The static instance of this class */
    private static final DeCraftingManagerVC INSTANCE = new DeCraftingManagerVC();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    
    /**
     * Returns the static instance of this class
     */
    public static DeCraftingManagerVC getInstance()
    {
        /** The static instance of this class */
        return INSTANCE;
    }
    
    public DeCraftingManagerVC()
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
    	this.addRecipe(new ItemStack(InitItemsVC.airship_balloon, 1), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_engine, 1), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', Blocks.REDSTONE_BLOCK});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.MAGMA});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_wood0, 1), new Object[]{"###", "#M#", "###", '#', Blocks.PLANKS, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_iron, 1), new Object[]{"###", "#M#", "###", '#', Items.IRON_INGOT, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_redstone, 1), new Object[]{"###", "#M#", "###", '#', Items.REDSTONE, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_gold, 1), new Object[]{"###", "#M#", "###", '#', Items.GOLD_INGOT, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_lapislazuli, 1), new Object[]{"###", "#M#", "###", '#', new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_diamond, 1), new Object[]{"###", "#M#", "###", '#', Items.DIAMOND, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame_emerald, 1), new Object[]{"###", "#M#", "###", '#', Items.EMERALD, 'M', Items.MINECART});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_wood0});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_iron});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_redstone});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_gold});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_lapislazuli});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_diamond});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', InitItemsVC.airship_frame_emerald});
    	
    	
    	//this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal, 1), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_normal, 1), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_normal, 1), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_normal, 1), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', Items.MINECART});
    	
    	//Airship modules
    	this.addRecipe(new ItemStack(InitItemsVC.module_chip, 1), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_small, 1), new Object[]{"CNC", "D#D", "CNC", 'C', InitItemsVC.module_chip, 'N', Items.GOLD_NUGGET, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_large, 1), new Object[]{"C#C", "D#D", "CEC", 'C', InitItemsVC.module_chip, 'E', Items.EMERALD, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_speed_increase_minor, 1), new Object[]{"CGC", "FDF", "CGC", 'C', InitItemsVC.module_chip, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	this.addRecipe(new ItemStack(InitItemsVC.module_speed_increase_major, 1), new Object[]{"CDC", "FEF", "CDC", 'C', InitItemsVC.module_chip, 'E', Items.EMERALD, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	this.addRecipe(new ItemStack(InitItemsVC.module_fuel_infinite, 1), new Object[]{"CBC", "Q#Q", "CBC", 'C', InitItemsVC.module_chip, 'B', Items.BLAZE_ROD, 'Q', Items.QUARTZ, '#', Items.NETHER_STAR});
    	
    	//=================================================
		
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
		
		//Airship v1 Oak colors
		//Recipes that dye the basic Oak airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_black), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_red), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_green), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_brown), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_blue), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_purple), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_cyan), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_lightgray), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_gray), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_pink), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_lime), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_yellow), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_lightblue), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_magenta), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_orange), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_white), new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Oak conversion back into normal.
		//Recipes that strip the dye off of Oak airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0_normal), new ItemStack(InitItemsVC.item_airship_v1_wood0_white));
		
		//Airship v1 Iron colors
		//Recipes that dye the basic Iron airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_black), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_red), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_green), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_brown), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_blue), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_purple), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_cyan), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_lightgray), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_gray), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_pink), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_lime), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_yellow), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_lightblue), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_magenta), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_orange), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_white), new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Iron conversion back into normal.
		//Recipes that strip the dye off of Iron airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron_normal), new ItemStack(InitItemsVC.item_airship_v1_iron_white));
		
		//Airship v1 Redstone colors
		//Recipes that dye the basic Redstone airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_black), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_red), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_green), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_brown), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_blue), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_purple), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_cyan), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_lightgray), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_gray), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_pink), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_lime), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_yellow), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_lightblue), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_magenta), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_orange), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_white), new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Redstone conversion back into normal.
		//Recipes that strip the dye off of Redstone airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone_normal), new ItemStack(InitItemsVC.item_airship_v1_redstone_white));
		
		//Airship v1 Gold colors
		//Recipes that dye the basic Gold airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_black), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_red), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_green), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_brown), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_blue), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_purple), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_cyan), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_lightgray), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_gray), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_pink), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_lime), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_yellow), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_lightblue), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_magenta), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_orange), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_white), new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Gold conversion back into normal.
		//Recipes that strip the dye off of Gold airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold_normal), new ItemStack(InitItemsVC.item_airship_v1_gold_white));
		
		//Airship v1 Lapis Lazuli colors
		//Recipes that dye the basic Lapis Lazuli airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_black), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_red), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_green), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_brown), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_blue), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_purple), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_cyan), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lightgray), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_gray), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_pink), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lime), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_yellow), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lightblue), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_magenta), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_orange), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_white), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Lapis Lazuli conversion back into normal.
		//Recipes that strip the dye off of Lapis Lazuli airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_normal), new ItemStack(InitItemsVC.item_airship_v1_lapislazuli_white));
		
		//Airship v1 Diamond colors
		//Recipes that dye the basic Diamond airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_black), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_red), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_green), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_brown), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_blue), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_purple), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_cyan), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_lightgray), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_gray), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_pink), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_lime), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_yellow), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_lightblue), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_magenta), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_orange), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_white), new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Diamond conversion back into normal.
		//Recipes that strip the dye off of Diamond airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond_normal), new ItemStack(InitItemsVC.item_airship_v1_diamond_white));
		
		//Airship v1 Emerald colors
		//Recipes that dye the basic Emerald airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_black), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_red), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_green), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_brown), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_blue), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_purple), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_cyan), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_lightgray), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_gray), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_pink), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_lime), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_yellow), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_lightblue), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_magenta), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_orange), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_white), new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 Emerald conversion back into normal.
		//Recipes that strip the dye off of Emerald airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald_normal), new ItemStack(InitItemsVC.item_airship_v1_emerald_white));
		
		
		
		
		
		
		
		
		/**
		//Airship v1 colors
		//Recipes that dye the basic airship into any color
		//Note: Also returns an empty bucket
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_black), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_black.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_red), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_red.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_green), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_green.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_brown), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_brown.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_blue), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_blue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_purple), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_purple.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_cyan), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_cyan.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lightgray), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_lightgray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_gray), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_gray.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_pink), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_pink.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lime), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_lime.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_yellow), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_yellow.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_lightblue), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_lightblue.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_magenta), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_magenta.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_orange), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_orange.setContainerItem(Items.BUCKET)));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_white), new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_paint_white.setContainerItem(Items.BUCKET)));
		
		//Airship v1 conversion back into normal.
		//Recipes that strip the dye off of airships
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_black));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_red));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_green));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_brown));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_blue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_purple));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_cyan));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_lightgray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_gray));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_pink));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_lime));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_yellow));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_lightblue));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_magenta));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_orange));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.item_airship_v1_normal), new ItemStack(InitItemsVC.item_airship_v1_white));
		*/
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
            ItemStack itemstack = ItemStack.field_190927_a;

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
                aitemstack[l] = ItemStack.field_190927_a;
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
    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getCraftingResult(craftMatrix);
            }
        }

        return ItemStack.field_190927_a;
    }

    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getRemainingItems(craftMatrix);
            }
        }

        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>func_191197_a(craftMatrix.getSizeInventory(), ItemStack.field_190927_a);

        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            nonnulllist.set(i, craftMatrix.getStackInSlot(i));
        }

        return nonnulllist;
    }

    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }
}
