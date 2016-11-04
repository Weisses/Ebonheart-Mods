package com.viesis.dismounter.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.dismounter.api.ItemsVD;
import com.viesis.dismounter.common.items.ItemDismounter;

public class InitItemsVD extends ItemsVD {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		item_dismounter = registerItem(new ItemDismounter());
		
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
