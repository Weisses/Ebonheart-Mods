package com.viesis.viescraft.common.items.crafting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

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
        
		//Fuel
		this.addShapelessRecipe(new ItemStack(InitItemsVC.viesoline_pellets), new ItemStack(Items.COAL), new ItemStack(Items.REDSTONE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.viesoline_pellets), new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.REDSTONE));
		
    	//Airship parts
    	this.addRecipe(new ItemStack(InitItemsVC.airship_balloon, 1), new Object[]{"LLL", "L#L", "LLL", 'L', Items.LEATHER, '#', Items.STRING});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_engine, 1), new Object[]{"IBI", "P#P", "IBI", 'P', Blocks.PISTON, 'I', Items.IRON_INGOT, 'B', Blocks.IRON_BARS, '#', Blocks.REDSTONE_BLOCK});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_ignition, 1), new Object[]{"IBI", "D#D", "IGI", 'I', Items.IRON_INGOT, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'B', Blocks.IRON_BARS, '#', Blocks.MAGMA});
    	
    	//Airship Frames
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 0), new Object[]{"###", "#M#", "###", '#', Blocks.PLANKS, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 1), new Object[]{"###", "#M#", "###", '#', Items.IRON_INGOT, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 2), new Object[]{"###", "#M#", "###", '#', Blocks.REDSTONE_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 3), new Object[]{"###", "#M#", "###", '#', Items.GOLD_INGOT, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 4), new Object[]{"###", "#M#", "###", '#', Blocks.LAPIS_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 5), new Object[]{"###", "#M#", "###", '#', Blocks.OBSIDIAN, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 6), new Object[]{"###", "#M#", "###", '#', Items.DIAMOND, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 7), new Object[]{"###", "#M#", "###", '#', Items.EMERALD, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 8), new Object[]{"###", "#M#", "###", '#', Blocks.NETHER_BRICK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.airship_frame, 1, 9), new Object[]{"###", "#M#", "###", '#', Blocks.PURPUR_BLOCK, 'M', Items.MINECART});
    	
    	//=================================================
    	
    	//Airships
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_wood0, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 0)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_iron, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 1)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_redstone, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 2)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_gold, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 3)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 4)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_obsidian, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 5)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_diamond, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 6)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_emerald, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 7)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_netherbrick, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 8)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v1_purpur, 1, 0), new Object[]{"LBL", "E#E", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 9)});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_wood0, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 0)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_iron, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 1)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_redstone, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 2)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_gold, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 3)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_lapislazuli, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 4)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_obsidian, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 5)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_diamond, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 6)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_emerald, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 7)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_netherbrick, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 8)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v2_purpur, 1, 0), new Object[]{"BLB", "L#L", "EIE", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 9)});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_wood0, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 0)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_iron, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 1)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_redstone, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 2)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_gold, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 3)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_lapislazuli, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 4)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_obsidian, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 5)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_diamond, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 6)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_emerald, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 7)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_netherbrick, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 8)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v3_purpur, 1, 0), new Object[]{"ELE", "B#B", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 9)});
    	
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_wood0, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 0)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_iron, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 1)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_redstone, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 2)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_gold, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 3)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_lapislazuli, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 4)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_obsidian, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 5)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_diamond, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 6)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_emerald, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 7)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_netherbrick, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 8)});
    	this.addRecipe(new ItemStack(InitItemsVC.item_airship_v4_purpur, 1, 0), new Object[]{"EBE", "L#L", "LIL", 'B', InitItemsVC.airship_balloon, 'E', InitItemsVC.airship_engine, 'I', InitItemsVC.airship_ignition, 'L', Items.LEAD, '#', new ItemStack(InitItemsVC.airship_frame, 1, 9)});
    	
    	//=================================================
    	
    	//Airship modules
    	this.addRecipe(new ItemStack(InitItemsVC.module_chip, 1), new Object[]{"CRC", "GGG", 'C', Blocks.COBBLESTONE, 'R', Items.REDSTONE, 'G', Items.GOLD_NUGGET});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_small, 1), new Object[]{"CNC", "D#D", "CNC", 'C', InitItemsVC.module_chip, 'N', Items.GOLD_NUGGET, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_inventory_large, 1), new Object[]{"C#C", "D#D", "CEC", 'C', InitItemsVC.module_chip, 'E', Items.EMERALD, 'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.module_speed_increase_minor, 1), new Object[]{"CGC", "FDF", "CGC", 'C', InitItemsVC.module_chip, 'G', Items.GOLD_INGOT, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	this.addRecipe(new ItemStack(InitItemsVC.module_speed_increase_major, 1), new Object[]{"CDC", "FEF", "CDC", 'C', InitItemsVC.module_chip, 'E', Items.EMERALD, 'D', Items.DIAMOND, 'F', Items.FIRE_CHARGE});
    	this.addRecipe(new ItemStack(InitItemsVC.module_fuel_infinite, 1), new Object[]{"CBC", "Q#Q", "CBC", 'C', InitItemsVC.module_chip, 'B', Items.BLAZE_ROD, 'Q', Items.QUARTZ, '#', Items.NETHER_STAR});
    	
    	//=================================================
		
		//Paints using coal
    	this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 0), new Object[]{"###", "###", "#B#", '#', Items.COAL, 'B', Items.BUCKET});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 1), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 14), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 6), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 3), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 2), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 13), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 4), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 8), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 5), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 12), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 9), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 16), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 7), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 10), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 11), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 15), new Object[]{"DDD", "D#D", "DBD", '#', Items.COAL, 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 17), new Object[]{"RWR", "W#W", "RBR", '#', Items.COAL, 'B', Items.BUCKET, 'W', new ItemStack(Items.DYE, 1, 15), 'R', Items.REDSTONE});
		
		//Paints using charcoal
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 0), new Object[]{"###", "###", "#B#", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 1), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 0)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 14), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 1)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 6), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 2)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 3), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 3)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 2), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 4)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 13), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 5)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 4), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 6)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 8), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 7)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 5), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 8)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 12), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 9)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 9), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 10)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 16), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 11)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 7), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 12)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 10), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 13)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 11), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 14)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 15), new Object[]{"DDD", "D#D", "DBD", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'D', new ItemStack(Items.DYE, 1, 15)});
		this.addRecipe(new ItemStack(InitItemsVC.item_paint, 1, 17), new Object[]{"RWR", "W#W", "RBR", '#', new ItemStack(Items.COAL, 1, 1), 'B', Items.BUCKET, 'W', new ItemStack(Items.DYE, 1, 15), 'R', Items.REDSTONE});
		
    	//=================================================

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
