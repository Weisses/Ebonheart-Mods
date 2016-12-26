package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.viesis.viescraft.api.ItemsVC;

public final class InitItemsVCRender extends ItemsVC {
	
	public static void registerRenders()
	{
		registerRender(guidebook_main);
		registerRender(guidebook_controls);
		registerRender(guidebook_paint);
		registerRender(guidebook_socket);
		
		registerRender(airship_balloon);
		registerRender(airship_engine);
		registerRender(airship_ignition);
		
		registerRender(airship_frame_wood0);
		registerRender(airship_frame_iron);
		registerRender(airship_frame_redstone);
		registerRender(airship_frame_gold);
		registerRender(airship_frame_lapislazuli);
		registerRender(airship_frame_diamond);
		registerRender(airship_frame_emerald);
		
		registerRender(airship_dismounter);
		
		registerRender(module_chip);
		registerRender(module_inventory_small);
		registerRender(module_inventory_large);
		registerRender(module_speed_increase_minor);
		registerRender(module_speed_increase_major);
		registerRender(module_fuel_infinite);
		
		
		
		
		//registerRender(item_airship_v1);
		
		
		
		//==============================================
		
		//V1
		registerRender(item_airship_v1_wood0_normal);
		registerRender(item_airship_v1_wood0_black);
		registerRender(item_airship_v1_wood0_blue);
		registerRender(item_airship_v1_wood0_brown);
		registerRender(item_airship_v1_wood0_cyan);
		registerRender(item_airship_v1_wood0_gray);
		registerRender(item_airship_v1_wood0_green);
		registerRender(item_airship_v1_wood0_lightblue);
		registerRender(item_airship_v1_wood0_lightgray);
		registerRender(item_airship_v1_wood0_lime);
		registerRender(item_airship_v1_wood0_magenta);
		registerRender(item_airship_v1_wood0_orange);
		registerRender(item_airship_v1_wood0_pink);
		registerRender(item_airship_v1_wood0_purple);
		registerRender(item_airship_v1_wood0_red);
		registerRender(item_airship_v1_wood0_white);
		registerRender(item_airship_v1_wood0_yellow);
		registerRender(item_airship_v1_wood0_admin);
		/**
		registerRender(item_airship_v1_iron_normal);
		registerRender(item_airship_v1_iron_black);
		registerRender(item_airship_v1_iron_blue);
		registerRender(item_airship_v1_iron_brown);
		registerRender(item_airship_v1_iron_cyan);
		registerRender(item_airship_v1_iron_gray);
		registerRender(item_airship_v1_iron_green);
		registerRender(item_airship_v1_iron_lightblue);
		registerRender(item_airship_v1_iron_lightgray);
		registerRender(item_airship_v1_iron_lime);
		registerRender(item_airship_v1_iron_magenta);
		registerRender(item_airship_v1_iron_orange);
		registerRender(item_airship_v1_iron_pink);
		registerRender(item_airship_v1_iron_purple);
		registerRender(item_airship_v1_iron_red);
		registerRender(item_airship_v1_iron_white);
		registerRender(item_airship_v1_iron_yellow);
		registerRender(item_airship_v1_iron_admin);
		
		registerRender(item_airship_v1_redstone_normal);
		registerRender(item_airship_v1_redstone_black);
		registerRender(item_airship_v1_redstone_blue);
		registerRender(item_airship_v1_redstone_brown);
		registerRender(item_airship_v1_redstone_cyan);
		registerRender(item_airship_v1_redstone_gray);
		registerRender(item_airship_v1_redstone_green);
		registerRender(item_airship_v1_redstone_lightblue);
		registerRender(item_airship_v1_redstone_lightgray);
		registerRender(item_airship_v1_redstone_lime);
		registerRender(item_airship_v1_redstone_magenta);
		registerRender(item_airship_v1_redstone_orange);
		registerRender(item_airship_v1_redstone_pink);
		registerRender(item_airship_v1_redstone_purple);
		registerRender(item_airship_v1_redstone_red);
		registerRender(item_airship_v1_redstone_white);
		registerRender(item_airship_v1_redstone_yellow);
		registerRender(item_airship_v1_redstone_admin);
		
		registerRender(item_airship_v1_gold_normal);
		registerRender(item_airship_v1_gold_black);
		registerRender(item_airship_v1_gold_blue);
		registerRender(item_airship_v1_gold_brown);
		registerRender(item_airship_v1_gold_cyan);
		registerRender(item_airship_v1_gold_gray);
		registerRender(item_airship_v1_gold_green);
		registerRender(item_airship_v1_gold_lightblue);
		registerRender(item_airship_v1_gold_lightgray);
		registerRender(item_airship_v1_gold_lime);
		registerRender(item_airship_v1_gold_magenta);
		registerRender(item_airship_v1_gold_orange);
		registerRender(item_airship_v1_gold_pink);
		registerRender(item_airship_v1_gold_purple);
		registerRender(item_airship_v1_gold_red);
		registerRender(item_airship_v1_gold_white);
		registerRender(item_airship_v1_gold_yellow);
		registerRender(item_airship_v1_gold_admin);
		
		registerRender(item_airship_v1_lapislazuli_normal);
		registerRender(item_airship_v1_lapislazuli_black);
		registerRender(item_airship_v1_lapislazuli_blue);
		registerRender(item_airship_v1_lapislazuli_brown);
		registerRender(item_airship_v1_lapislazuli_cyan);
		registerRender(item_airship_v1_lapislazuli_gray);
		registerRender(item_airship_v1_lapislazuli_green);
		registerRender(item_airship_v1_lapislazuli_lightblue);
		registerRender(item_airship_v1_lapislazuli_lightgray);
		registerRender(item_airship_v1_lapislazuli_lime);
		registerRender(item_airship_v1_lapislazuli_magenta);
		registerRender(item_airship_v1_lapislazuli_orange);
		registerRender(item_airship_v1_lapislazuli_pink);
		registerRender(item_airship_v1_lapislazuli_purple);
		registerRender(item_airship_v1_lapislazuli_red);
		registerRender(item_airship_v1_lapislazuli_white);
		registerRender(item_airship_v1_lapislazuli_yellow);
		registerRender(item_airship_v1_lapislazuli_admin);
		
		registerRender(item_airship_v1_obsidian_normal);
		registerRender(item_airship_v1_obsidian_black);
		registerRender(item_airship_v1_obsidian_blue);
		registerRender(item_airship_v1_obsidian_brown);
		registerRender(item_airship_v1_obsidian_cyan);
		registerRender(item_airship_v1_obsidian_gray);
		registerRender(item_airship_v1_obsidian_green);
		registerRender(item_airship_v1_obsidian_lightblue);
		registerRender(item_airship_v1_obsidian_lightgray);
		registerRender(item_airship_v1_obsidian_lime);
		registerRender(item_airship_v1_obsidian_magenta);
		registerRender(item_airship_v1_obsidian_orange);
		registerRender(item_airship_v1_obsidian_pink);
		registerRender(item_airship_v1_obsidian_purple);
		registerRender(item_airship_v1_obsidian_red);
		registerRender(item_airship_v1_obsidian_white);
		registerRender(item_airship_v1_obsidian_yellow);
		registerRender(item_airship_v1_obsidian_admin);
		
		registerRender(item_airship_v1_diamond_normal);
		registerRender(item_airship_v1_diamond_black);
		registerRender(item_airship_v1_diamond_blue);
		registerRender(item_airship_v1_diamond_brown);
		registerRender(item_airship_v1_diamond_cyan);
		registerRender(item_airship_v1_diamond_gray);
		registerRender(item_airship_v1_diamond_green);
		registerRender(item_airship_v1_diamond_lightblue);
		registerRender(item_airship_v1_diamond_lightgray);
		registerRender(item_airship_v1_diamond_lime);
		registerRender(item_airship_v1_diamond_magenta);
		registerRender(item_airship_v1_diamond_orange);
		registerRender(item_airship_v1_diamond_pink);
		registerRender(item_airship_v1_diamond_purple);
		registerRender(item_airship_v1_diamond_red);
		registerRender(item_airship_v1_diamond_white);
		registerRender(item_airship_v1_diamond_yellow);
		registerRender(item_airship_v1_diamond_admin);
		
		registerRender(item_airship_v1_emerald_normal);
		registerRender(item_airship_v1_emerald_black);
		registerRender(item_airship_v1_emerald_blue);
		registerRender(item_airship_v1_emerald_brown);
		registerRender(item_airship_v1_emerald_cyan);
		registerRender(item_airship_v1_emerald_gray);
		registerRender(item_airship_v1_emerald_green);
		registerRender(item_airship_v1_emerald_lightblue);
		registerRender(item_airship_v1_emerald_lightgray);
		registerRender(item_airship_v1_emerald_lime);
		registerRender(item_airship_v1_emerald_magenta);
		registerRender(item_airship_v1_emerald_orange);
		registerRender(item_airship_v1_emerald_pink);
		registerRender(item_airship_v1_emerald_purple);
		registerRender(item_airship_v1_emerald_red);
		registerRender(item_airship_v1_emerald_white);
		registerRender(item_airship_v1_emerald_yellow);
		registerRender(item_airship_v1_emerald_admin);
		
		//==============================================
		
		//V1
		registerRender(item_airship_v2_wood0_normal);
		registerRender(item_airship_v2_wood0_black);
		registerRender(item_airship_v2_wood0_blue);
		registerRender(item_airship_v2_wood0_brown);
		registerRender(item_airship_v2_wood0_cyan);
		registerRender(item_airship_v2_wood0_gray);
		registerRender(item_airship_v2_wood0_green);
		registerRender(item_airship_v2_wood0_lightblue);
		registerRender(item_airship_v2_wood0_lightgray);
		registerRender(item_airship_v2_wood0_lime);
		registerRender(item_airship_v2_wood0_magenta);
		registerRender(item_airship_v2_wood0_orange);
		registerRender(item_airship_v2_wood0_pink);
		registerRender(item_airship_v2_wood0_purple);
		registerRender(item_airship_v2_wood0_red);
		registerRender(item_airship_v2_wood0_white);
		registerRender(item_airship_v2_wood0_yellow);
		registerRender(item_airship_v2_wood0_admin);
		
		registerRender(item_airship_v2_iron_normal);
		registerRender(item_airship_v2_iron_black);
		registerRender(item_airship_v2_iron_blue);
		registerRender(item_airship_v2_iron_brown);
		registerRender(item_airship_v2_iron_cyan);
		registerRender(item_airship_v2_iron_gray);
		registerRender(item_airship_v2_iron_green);
		registerRender(item_airship_v2_iron_lightblue);
		registerRender(item_airship_v2_iron_lightgray);
		registerRender(item_airship_v2_iron_lime);
		registerRender(item_airship_v2_iron_magenta);
		registerRender(item_airship_v2_iron_orange);
		registerRender(item_airship_v2_iron_pink);
		registerRender(item_airship_v2_iron_purple);
		registerRender(item_airship_v2_iron_red);
		registerRender(item_airship_v2_iron_white);
		registerRender(item_airship_v2_iron_yellow);
		registerRender(item_airship_v2_iron_admin);
		
		registerRender(item_airship_v2_redstone_normal);
		registerRender(item_airship_v2_redstone_black);
		registerRender(item_airship_v2_redstone_blue);
		registerRender(item_airship_v2_redstone_brown);
		registerRender(item_airship_v2_redstone_cyan);
		registerRender(item_airship_v2_redstone_gray);
		registerRender(item_airship_v2_redstone_green);
		registerRender(item_airship_v2_redstone_lightblue);
		registerRender(item_airship_v2_redstone_lightgray);
		registerRender(item_airship_v2_redstone_lime);
		registerRender(item_airship_v2_redstone_magenta);
		registerRender(item_airship_v2_redstone_orange);
		registerRender(item_airship_v2_redstone_pink);
		registerRender(item_airship_v2_redstone_purple);
		registerRender(item_airship_v2_redstone_red);
		registerRender(item_airship_v2_redstone_white);
		registerRender(item_airship_v2_redstone_yellow);
		registerRender(item_airship_v2_redstone_admin);
		
		registerRender(item_airship_v2_gold_normal);
		registerRender(item_airship_v2_gold_black);
		registerRender(item_airship_v2_gold_blue);
		registerRender(item_airship_v2_gold_brown);
		registerRender(item_airship_v2_gold_cyan);
		registerRender(item_airship_v2_gold_gray);
		registerRender(item_airship_v2_gold_green);
		registerRender(item_airship_v2_gold_lightblue);
		registerRender(item_airship_v2_gold_lightgray);
		registerRender(item_airship_v2_gold_lime);
		registerRender(item_airship_v2_gold_magenta);
		registerRender(item_airship_v2_gold_orange);
		registerRender(item_airship_v2_gold_pink);
		registerRender(item_airship_v2_gold_purple);
		registerRender(item_airship_v2_gold_red);
		registerRender(item_airship_v2_gold_white);
		registerRender(item_airship_v2_gold_yellow);
		registerRender(item_airship_v2_gold_admin);
		
		registerRender(item_airship_v2_lapislazuli_normal);
		registerRender(item_airship_v2_lapislazuli_black);
		registerRender(item_airship_v2_lapislazuli_blue);
		registerRender(item_airship_v2_lapislazuli_brown);
		registerRender(item_airship_v2_lapislazuli_cyan);
		registerRender(item_airship_v2_lapislazuli_gray);
		registerRender(item_airship_v2_lapislazuli_green);
		registerRender(item_airship_v2_lapislazuli_lightblue);
		registerRender(item_airship_v2_lapislazuli_lightgray);
		registerRender(item_airship_v2_lapislazuli_lime);
		registerRender(item_airship_v2_lapislazuli_magenta);
		registerRender(item_airship_v2_lapislazuli_orange);
		registerRender(item_airship_v2_lapislazuli_pink);
		registerRender(item_airship_v2_lapislazuli_purple);
		registerRender(item_airship_v2_lapislazuli_red);
		registerRender(item_airship_v2_lapislazuli_white);
		registerRender(item_airship_v2_lapislazuli_yellow);
		registerRender(item_airship_v2_lapislazuli_admin);
		
		registerRender(item_airship_v2_obsidian_normal);
		registerRender(item_airship_v2_obsidian_black);
		registerRender(item_airship_v2_obsidian_blue);
		registerRender(item_airship_v2_obsidian_brown);
		registerRender(item_airship_v2_obsidian_cyan);
		registerRender(item_airship_v2_obsidian_gray);
		registerRender(item_airship_v2_obsidian_green);
		registerRender(item_airship_v2_obsidian_lightblue);
		registerRender(item_airship_v2_obsidian_lightgray);
		registerRender(item_airship_v2_obsidian_lime);
		registerRender(item_airship_v2_obsidian_magenta);
		registerRender(item_airship_v2_obsidian_orange);
		registerRender(item_airship_v2_obsidian_pink);
		registerRender(item_airship_v2_obsidian_purple);
		registerRender(item_airship_v2_obsidian_red);
		registerRender(item_airship_v2_obsidian_white);
		registerRender(item_airship_v2_obsidian_yellow);
		registerRender(item_airship_v2_obsidian_admin);
		
		registerRender(item_airship_v2_diamond_normal);
		registerRender(item_airship_v2_diamond_black);
		registerRender(item_airship_v2_diamond_blue);
		registerRender(item_airship_v2_diamond_brown);
		registerRender(item_airship_v2_diamond_cyan);
		registerRender(item_airship_v2_diamond_gray);
		registerRender(item_airship_v2_diamond_green);
		registerRender(item_airship_v2_diamond_lightblue);
		registerRender(item_airship_v2_diamond_lightgray);
		registerRender(item_airship_v2_diamond_lime);
		registerRender(item_airship_v2_diamond_magenta);
		registerRender(item_airship_v2_diamond_orange);
		registerRender(item_airship_v2_diamond_pink);
		registerRender(item_airship_v2_diamond_purple);
		registerRender(item_airship_v2_diamond_red);
		registerRender(item_airship_v2_diamond_white);
		registerRender(item_airship_v2_diamond_yellow);
		registerRender(item_airship_v2_diamond_admin);
		
		registerRender(item_airship_v2_emerald_normal);
		registerRender(item_airship_v2_emerald_black);
		registerRender(item_airship_v2_emerald_blue);
		registerRender(item_airship_v2_emerald_brown);
		registerRender(item_airship_v2_emerald_cyan);
		registerRender(item_airship_v2_emerald_gray);
		registerRender(item_airship_v2_emerald_green);
		registerRender(item_airship_v2_emerald_lightblue);
		registerRender(item_airship_v2_emerald_lightgray);
		registerRender(item_airship_v2_emerald_lime);
		registerRender(item_airship_v2_emerald_magenta);
		registerRender(item_airship_v2_emerald_orange);
		registerRender(item_airship_v2_emerald_pink);
		registerRender(item_airship_v2_emerald_purple);
		registerRender(item_airship_v2_emerald_red);
		registerRender(item_airship_v2_emerald_white);
		registerRender(item_airship_v2_emerald_yellow);
		registerRender(item_airship_v2_emerald_admin);
		
		//==============================================
		
		//V1
		registerRender(item_airship_v3_wood0_normal);
		registerRender(item_airship_v3_wood0_black);
		registerRender(item_airship_v3_wood0_blue);
		registerRender(item_airship_v3_wood0_brown);
		registerRender(item_airship_v3_wood0_cyan);
		registerRender(item_airship_v3_wood0_gray);
		registerRender(item_airship_v3_wood0_green);
		registerRender(item_airship_v3_wood0_lightblue);
		registerRender(item_airship_v3_wood0_lightgray);
		registerRender(item_airship_v3_wood0_lime);
		registerRender(item_airship_v3_wood0_magenta);
		registerRender(item_airship_v3_wood0_orange);
		registerRender(item_airship_v3_wood0_pink);
		registerRender(item_airship_v3_wood0_purple);
		registerRender(item_airship_v3_wood0_red);
		registerRender(item_airship_v3_wood0_white);
		registerRender(item_airship_v3_wood0_yellow);
		registerRender(item_airship_v3_wood0_admin);
		
		registerRender(item_airship_v3_iron_normal);
		registerRender(item_airship_v3_iron_black);
		registerRender(item_airship_v3_iron_blue);
		registerRender(item_airship_v3_iron_brown);
		registerRender(item_airship_v3_iron_cyan);
		registerRender(item_airship_v3_iron_gray);
		registerRender(item_airship_v3_iron_green);
		registerRender(item_airship_v3_iron_lightblue);
		registerRender(item_airship_v3_iron_lightgray);
		registerRender(item_airship_v3_iron_lime);
		registerRender(item_airship_v3_iron_magenta);
		registerRender(item_airship_v3_iron_orange);
		registerRender(item_airship_v3_iron_pink);
		registerRender(item_airship_v3_iron_purple);
		registerRender(item_airship_v3_iron_red);
		registerRender(item_airship_v3_iron_white);
		registerRender(item_airship_v3_iron_yellow);
		registerRender(item_airship_v3_iron_admin);
		
		registerRender(item_airship_v3_redstone_normal);
		registerRender(item_airship_v3_redstone_black);
		registerRender(item_airship_v3_redstone_blue);
		registerRender(item_airship_v3_redstone_brown);
		registerRender(item_airship_v3_redstone_cyan);
		registerRender(item_airship_v3_redstone_gray);
		registerRender(item_airship_v3_redstone_green);
		registerRender(item_airship_v3_redstone_lightblue);
		registerRender(item_airship_v3_redstone_lightgray);
		registerRender(item_airship_v3_redstone_lime);
		registerRender(item_airship_v3_redstone_magenta);
		registerRender(item_airship_v3_redstone_orange);
		registerRender(item_airship_v3_redstone_pink);
		registerRender(item_airship_v3_redstone_purple);
		registerRender(item_airship_v3_redstone_red);
		registerRender(item_airship_v3_redstone_white);
		registerRender(item_airship_v3_redstone_yellow);
		registerRender(item_airship_v3_redstone_admin);
		
		registerRender(item_airship_v3_gold_normal);
		registerRender(item_airship_v3_gold_black);
		registerRender(item_airship_v3_gold_blue);
		registerRender(item_airship_v3_gold_brown);
		registerRender(item_airship_v3_gold_cyan);
		registerRender(item_airship_v3_gold_gray);
		registerRender(item_airship_v3_gold_green);
		registerRender(item_airship_v3_gold_lightblue);
		registerRender(item_airship_v3_gold_lightgray);
		registerRender(item_airship_v3_gold_lime);
		registerRender(item_airship_v3_gold_magenta);
		registerRender(item_airship_v3_gold_orange);
		registerRender(item_airship_v3_gold_pink);
		registerRender(item_airship_v3_gold_purple);
		registerRender(item_airship_v3_gold_red);
		registerRender(item_airship_v3_gold_white);
		registerRender(item_airship_v3_gold_yellow);
		registerRender(item_airship_v3_gold_admin);
		
		registerRender(item_airship_v3_lapislazuli_normal);
		registerRender(item_airship_v3_lapislazuli_black);
		registerRender(item_airship_v3_lapislazuli_blue);
		registerRender(item_airship_v3_lapislazuli_brown);
		registerRender(item_airship_v3_lapislazuli_cyan);
		registerRender(item_airship_v3_lapislazuli_gray);
		registerRender(item_airship_v3_lapislazuli_green);
		registerRender(item_airship_v3_lapislazuli_lightblue);
		registerRender(item_airship_v3_lapislazuli_lightgray);
		registerRender(item_airship_v3_lapislazuli_lime);
		registerRender(item_airship_v3_lapislazuli_magenta);
		registerRender(item_airship_v3_lapislazuli_orange);
		registerRender(item_airship_v3_lapislazuli_pink);
		registerRender(item_airship_v3_lapislazuli_purple);
		registerRender(item_airship_v3_lapislazuli_red);
		registerRender(item_airship_v3_lapislazuli_white);
		registerRender(item_airship_v3_lapislazuli_yellow);
		registerRender(item_airship_v3_lapislazuli_admin);
		
		registerRender(item_airship_v3_obsidian_normal);
		registerRender(item_airship_v3_obsidian_black);
		registerRender(item_airship_v3_obsidian_blue);
		registerRender(item_airship_v3_obsidian_brown);
		registerRender(item_airship_v3_obsidian_cyan);
		registerRender(item_airship_v3_obsidian_gray);
		registerRender(item_airship_v3_obsidian_green);
		registerRender(item_airship_v3_obsidian_lightblue);
		registerRender(item_airship_v3_obsidian_lightgray);
		registerRender(item_airship_v3_obsidian_lime);
		registerRender(item_airship_v3_obsidian_magenta);
		registerRender(item_airship_v3_obsidian_orange);
		registerRender(item_airship_v3_obsidian_pink);
		registerRender(item_airship_v3_obsidian_purple);
		registerRender(item_airship_v3_obsidian_red);
		registerRender(item_airship_v3_obsidian_white);
		registerRender(item_airship_v3_obsidian_yellow);
		registerRender(item_airship_v3_obsidian_admin);
		
		registerRender(item_airship_v3_diamond_normal);
		registerRender(item_airship_v3_diamond_black);
		registerRender(item_airship_v3_diamond_blue);
		registerRender(item_airship_v3_diamond_brown);
		registerRender(item_airship_v3_diamond_cyan);
		registerRender(item_airship_v3_diamond_gray);
		registerRender(item_airship_v3_diamond_green);
		registerRender(item_airship_v3_diamond_lightblue);
		registerRender(item_airship_v3_diamond_lightgray);
		registerRender(item_airship_v3_diamond_lime);
		registerRender(item_airship_v3_diamond_magenta);
		registerRender(item_airship_v3_diamond_orange);
		registerRender(item_airship_v3_diamond_pink);
		registerRender(item_airship_v3_diamond_purple);
		registerRender(item_airship_v3_diamond_red);
		registerRender(item_airship_v3_diamond_white);
		registerRender(item_airship_v3_diamond_yellow);
		registerRender(item_airship_v3_diamond_admin);
		
		registerRender(item_airship_v3_emerald_normal);
		registerRender(item_airship_v3_emerald_black);
		registerRender(item_airship_v3_emerald_blue);
		registerRender(item_airship_v3_emerald_brown);
		registerRender(item_airship_v3_emerald_cyan);
		registerRender(item_airship_v3_emerald_gray);
		registerRender(item_airship_v3_emerald_green);
		registerRender(item_airship_v3_emerald_lightblue);
		registerRender(item_airship_v3_emerald_lightgray);
		registerRender(item_airship_v3_emerald_lime);
		registerRender(item_airship_v3_emerald_magenta);
		registerRender(item_airship_v3_emerald_orange);
		registerRender(item_airship_v3_emerald_pink);
		registerRender(item_airship_v3_emerald_purple);
		registerRender(item_airship_v3_emerald_red);
		registerRender(item_airship_v3_emerald_white);
		registerRender(item_airship_v3_emerald_yellow);
		registerRender(item_airship_v3_emerald_admin);
		
		//==============================================
		
		//V1
		registerRender(item_airship_v4_wood0_normal);
		registerRender(item_airship_v4_wood0_black);
		registerRender(item_airship_v4_wood0_blue);
		registerRender(item_airship_v4_wood0_brown);
		registerRender(item_airship_v4_wood0_cyan);
		registerRender(item_airship_v4_wood0_gray);
		registerRender(item_airship_v4_wood0_green);
		registerRender(item_airship_v4_wood0_lightblue);
		registerRender(item_airship_v4_wood0_lightgray);
		registerRender(item_airship_v4_wood0_lime);
		registerRender(item_airship_v4_wood0_magenta);
		registerRender(item_airship_v4_wood0_orange);
		registerRender(item_airship_v4_wood0_pink);
		registerRender(item_airship_v4_wood0_purple);
		registerRender(item_airship_v4_wood0_red);
		registerRender(item_airship_v4_wood0_white);
		registerRender(item_airship_v4_wood0_yellow);
		registerRender(item_airship_v4_wood0_admin);
		
		registerRender(item_airship_v4_iron_normal);
		registerRender(item_airship_v4_iron_black);
		registerRender(item_airship_v4_iron_blue);
		registerRender(item_airship_v4_iron_brown);
		registerRender(item_airship_v4_iron_cyan);
		registerRender(item_airship_v4_iron_gray);
		registerRender(item_airship_v4_iron_green);
		registerRender(item_airship_v4_iron_lightblue);
		registerRender(item_airship_v4_iron_lightgray);
		registerRender(item_airship_v4_iron_lime);
		registerRender(item_airship_v4_iron_magenta);
		registerRender(item_airship_v4_iron_orange);
		registerRender(item_airship_v4_iron_pink);
		registerRender(item_airship_v4_iron_purple);
		registerRender(item_airship_v4_iron_red);
		registerRender(item_airship_v4_iron_white);
		registerRender(item_airship_v4_iron_yellow);
		registerRender(item_airship_v4_iron_admin);
		
		registerRender(item_airship_v4_redstone_normal);
		registerRender(item_airship_v4_redstone_black);
		registerRender(item_airship_v4_redstone_blue);
		registerRender(item_airship_v4_redstone_brown);
		registerRender(item_airship_v4_redstone_cyan);
		registerRender(item_airship_v4_redstone_gray);
		registerRender(item_airship_v4_redstone_green);
		registerRender(item_airship_v4_redstone_lightblue);
		registerRender(item_airship_v4_redstone_lightgray);
		registerRender(item_airship_v4_redstone_lime);
		registerRender(item_airship_v4_redstone_magenta);
		registerRender(item_airship_v4_redstone_orange);
		registerRender(item_airship_v4_redstone_pink);
		registerRender(item_airship_v4_redstone_purple);
		registerRender(item_airship_v4_redstone_red);
		registerRender(item_airship_v4_redstone_white);
		registerRender(item_airship_v4_redstone_yellow);
		registerRender(item_airship_v4_redstone_admin);
		
		registerRender(item_airship_v4_gold_normal);
		registerRender(item_airship_v4_gold_black);
		registerRender(item_airship_v4_gold_blue);
		registerRender(item_airship_v4_gold_brown);
		registerRender(item_airship_v4_gold_cyan);
		registerRender(item_airship_v4_gold_gray);
		registerRender(item_airship_v4_gold_green);
		registerRender(item_airship_v4_gold_lightblue);
		registerRender(item_airship_v4_gold_lightgray);
		registerRender(item_airship_v4_gold_lime);
		registerRender(item_airship_v4_gold_magenta);
		registerRender(item_airship_v4_gold_orange);
		registerRender(item_airship_v4_gold_pink);
		registerRender(item_airship_v4_gold_purple);
		registerRender(item_airship_v4_gold_red);
		registerRender(item_airship_v4_gold_white);
		registerRender(item_airship_v4_gold_yellow);
		registerRender(item_airship_v4_gold_admin);
		
		registerRender(item_airship_v4_lapislazuli_normal);
		registerRender(item_airship_v4_lapislazuli_black);
		registerRender(item_airship_v4_lapislazuli_blue);
		registerRender(item_airship_v4_lapislazuli_brown);
		registerRender(item_airship_v4_lapislazuli_cyan);
		registerRender(item_airship_v4_lapislazuli_gray);
		registerRender(item_airship_v4_lapislazuli_green);
		registerRender(item_airship_v4_lapislazuli_lightblue);
		registerRender(item_airship_v4_lapislazuli_lightgray);
		registerRender(item_airship_v4_lapislazuli_lime);
		registerRender(item_airship_v4_lapislazuli_magenta);
		registerRender(item_airship_v4_lapislazuli_orange);
		registerRender(item_airship_v4_lapislazuli_pink);
		registerRender(item_airship_v4_lapislazuli_purple);
		registerRender(item_airship_v4_lapislazuli_red);
		registerRender(item_airship_v4_lapislazuli_white);
		registerRender(item_airship_v4_lapislazuli_yellow);
		registerRender(item_airship_v4_lapislazuli_admin);
		
		registerRender(item_airship_v4_obsidian_normal);
		registerRender(item_airship_v4_obsidian_black);
		registerRender(item_airship_v4_obsidian_blue);
		registerRender(item_airship_v4_obsidian_brown);
		registerRender(item_airship_v4_obsidian_cyan);
		registerRender(item_airship_v4_obsidian_gray);
		registerRender(item_airship_v4_obsidian_green);
		registerRender(item_airship_v4_obsidian_lightblue);
		registerRender(item_airship_v4_obsidian_lightgray);
		registerRender(item_airship_v4_obsidian_lime);
		registerRender(item_airship_v4_obsidian_magenta);
		registerRender(item_airship_v4_obsidian_orange);
		registerRender(item_airship_v4_obsidian_pink);
		registerRender(item_airship_v4_obsidian_purple);
		registerRender(item_airship_v4_obsidian_red);
		registerRender(item_airship_v4_obsidian_white);
		registerRender(item_airship_v4_obsidian_yellow);
		registerRender(item_airship_v4_obsidian_admin);
		
		registerRender(item_airship_v4_diamond_normal);
		registerRender(item_airship_v4_diamond_black);
		registerRender(item_airship_v4_diamond_blue);
		registerRender(item_airship_v4_diamond_brown);
		registerRender(item_airship_v4_diamond_cyan);
		registerRender(item_airship_v4_diamond_gray);
		registerRender(item_airship_v4_diamond_green);
		registerRender(item_airship_v4_diamond_lightblue);
		registerRender(item_airship_v4_diamond_lightgray);
		registerRender(item_airship_v4_diamond_lime);
		registerRender(item_airship_v4_diamond_magenta);
		registerRender(item_airship_v4_diamond_orange);
		registerRender(item_airship_v4_diamond_pink);
		registerRender(item_airship_v4_diamond_purple);
		registerRender(item_airship_v4_diamond_red);
		registerRender(item_airship_v4_diamond_white);
		registerRender(item_airship_v4_diamond_yellow);
		registerRender(item_airship_v4_diamond_admin);
		
		registerRender(item_airship_v4_emerald_normal);
		registerRender(item_airship_v4_emerald_black);
		registerRender(item_airship_v4_emerald_blue);
		registerRender(item_airship_v4_emerald_brown);
		registerRender(item_airship_v4_emerald_cyan);
		registerRender(item_airship_v4_emerald_gray);
		registerRender(item_airship_v4_emerald_green);
		registerRender(item_airship_v4_emerald_lightblue);
		registerRender(item_airship_v4_emerald_lightgray);
		registerRender(item_airship_v4_emerald_lime);
		registerRender(item_airship_v4_emerald_magenta);
		registerRender(item_airship_v4_emerald_orange);
		registerRender(item_airship_v4_emerald_pink);
		registerRender(item_airship_v4_emerald_purple);
		registerRender(item_airship_v4_emerald_red);
		registerRender(item_airship_v4_emerald_white);
		registerRender(item_airship_v4_emerald_yellow);
		registerRender(item_airship_v4_emerald_admin);
		*/
		//==============================================
		
		//registerRender(item_airship_v1_normal);
		registerRender(item_airship_v1_black);
		registerRender(item_airship_v1_blue);
		registerRender(item_airship_v1_brown);
		registerRender(item_airship_v1_cyan);
		registerRender(item_airship_v1_gray);
		registerRender(item_airship_v1_green);
		registerRender(item_airship_v1_lightblue);
		registerRender(item_airship_v1_lightgray);
		registerRender(item_airship_v1_lime);
		registerRender(item_airship_v1_magenta);
		registerRender(item_airship_v1_orange);
		registerRender(item_airship_v1_pink);
		registerRender(item_airship_v1_purple);
		registerRender(item_airship_v1_red);
		registerRender(item_airship_v1_white);
		registerRender(item_airship_v1_yellow);
		registerRender(item_airship_v1_admin);
		
		registerRender(item_airship_v2_normal);
		registerRender(item_airship_v2_black);
		registerRender(item_airship_v2_blue);
		registerRender(item_airship_v2_brown);
		registerRender(item_airship_v2_cyan);
		registerRender(item_airship_v2_gray);
		registerRender(item_airship_v2_green);
		registerRender(item_airship_v2_lightblue);
		registerRender(item_airship_v2_lightgray);
		registerRender(item_airship_v2_lime);
		registerRender(item_airship_v2_magenta);
		registerRender(item_airship_v2_orange);
		registerRender(item_airship_v2_pink);
		registerRender(item_airship_v2_purple);
		registerRender(item_airship_v2_red);
		registerRender(item_airship_v2_white);
		registerRender(item_airship_v2_yellow);
		registerRender(item_airship_v2_admin);
		
		registerRender(item_airship_v3_normal);
		registerRender(item_airship_v3_black);
		registerRender(item_airship_v3_blue);
		registerRender(item_airship_v3_brown);
		registerRender(item_airship_v3_cyan);
		registerRender(item_airship_v3_gray);
		registerRender(item_airship_v3_green);
		registerRender(item_airship_v3_lightblue);
		registerRender(item_airship_v3_lightgray);
		registerRender(item_airship_v3_lime);
		registerRender(item_airship_v3_magenta);
		registerRender(item_airship_v3_orange);
		registerRender(item_airship_v3_pink);
		registerRender(item_airship_v3_purple);
		registerRender(item_airship_v3_red);
		registerRender(item_airship_v3_white);
		registerRender(item_airship_v3_yellow);
		registerRender(item_airship_v3_admin);
		
		registerRender(item_airship_v4_normal);
		registerRender(item_airship_v4_black);
		registerRender(item_airship_v4_blue);
		registerRender(item_airship_v4_brown);
		registerRender(item_airship_v4_cyan);
		registerRender(item_airship_v4_gray);
		registerRender(item_airship_v4_green);
		registerRender(item_airship_v4_lightblue);
		registerRender(item_airship_v4_lightgray);
		registerRender(item_airship_v4_lime);
		registerRender(item_airship_v4_magenta);
		registerRender(item_airship_v4_orange);
		registerRender(item_airship_v4_pink);
		registerRender(item_airship_v4_purple);
		registerRender(item_airship_v4_red);
		registerRender(item_airship_v4_white);
		registerRender(item_airship_v4_yellow);
		registerRender(item_airship_v4_admin);
		
		//==============================================
		
		registerRender(item_paint_black);
		registerRender(item_paint_blue);
		registerRender(item_paint_brown);
		registerRender(item_paint_cyan);
		registerRender(item_paint_gray);
		registerRender(item_paint_green);
		registerRender(item_paint_lightblue);
		registerRender(item_paint_lightgray);
		registerRender(item_paint_lime);
		registerRender(item_paint_magenta);
		registerRender(item_paint_orange);
		registerRender(item_paint_pink);
		registerRender(item_paint_purple);
		registerRender(item_paint_red);
		registerRender(item_paint_white);
		registerRender(item_paint_yellow);
		
		registerRender(achievement_airship_create_engine);
		registerRender(achievement_airship_create_ignition);
		registerRender(achievement_airship_create);
		registerRender(achievement_airship_create_color);
		registerRender(achievement_airship_create_module);
		
		registerRender(achievement_airship_airborn);
		registerRender(achievement_airship_water);
		registerRender(achievement_airship_lava);
		
		registerRender(achievement_airship_portal);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}
