package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.items.resources.ItemBalloon;
import com.viesis.viescraft.common.items.resources.ItemEngine;
import com.viesis.viescraft.common.items.resources.ItemIgnition;
import com.viesis.viescraft.common.items.resources.ItemViesdenburg;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		item_viesdenburg = registerItem(new ItemViesdenburg());
		
		
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
