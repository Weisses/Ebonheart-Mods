package com.ebonheart.EbonArtsMod.testbed;

import java.util.Map;
import java.util.Properties;
import java.io.*;
import java.lang.reflect.Constructor;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.client.model.ModelAirship;




public class mod_airship extends BaseMod {


	public mod_airship() {

		
		// ModLoader.AddName(airShip, "Airship");
		ModLoader.addName(airShip, "Airship");
		// Engine
		ModLoader.addName(engine, "Engine");
		// Balloon
		ModLoader.addName(balloon, "Balloon");
		// Airship w/o Engines
		ModLoader.registerEntityID(EntityAirship.class, "Airship", ModLoader
				.getUniqueEntityId());
				
		GameRegistry.addRecipe(new ItemStack(airShip, 1), new Object[] { 
				"XBX",
				"ECE", 
				"XDX", 
				
				Character.valueOf('X'), Item.silk,
				Character.valueOf('B'), balloon,
				Character.valueOf('C'), Block.chest, 
				Character.valueOf('E'), engine,				
				Character.valueOf('L'), Block.dispenser,
				Character.valueOf('D'), Item.boat,
				Character.valueOf('F'), Block.stoneOvenIdle,
				
		});

		ModLoader.addRecipe(new ItemStack(engine, 1), new Object[] { 
					"###",
					"#X#", 
					"###", 
					Character.valueOf('#'), Item.ingotIron,
					Character.valueOf('X'), Block.pistonBase });

//		ModLoader.AddRecipe(new ItemStack(engine, 1), new Object[] { 
//				"###",
//				"#B#", 
//				"###", 
//			Character.valueOf('#'), Item.ingotIron,
//			Character.valueOf('B'), Block.stoneOvenIdle });
		
		ModLoader.addRecipe(new ItemStack(balloon, 1), new Object[] { 
					"###",
					"# #", 
					"###", 
					Character.valueOf('#'), Item.leather});

		// Read properties file.
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(Minecraft.getMinecraft()
					+ "/airship.properties"));

			KEY_UP = Keyboard.getKeyIndex(properties.getProperty("ascend"));
			KEY_DOWN = Keyboard.getKeyIndex(properties.getProperty("descend"));
			KEY_CHEST = Keyboard.getKeyIndex(properties.getProperty("chest"));
			KEY_FIRE = Keyboard.getKeyIndex(properties.getProperty("fire"));
			String temp = properties.getProperty("boiler");
			if (temp.contains("show"))
				SHOW_BOILER = true;
			else
				SHOW_BOILER = false;

		} catch (IOException e) {
			properties.setProperty("ascend", Keyboard
					.getKeyName(Keyboard.KEY_SPACE));
			properties.setProperty("descend", Keyboard
					.getKeyName(Keyboard.KEY_LSHIFT));
			properties.setProperty("chest", Keyboard
					.getKeyName(Keyboard.KEY_RSHIFT));
			properties.setProperty("fire", Keyboard
					.getKeyName(Keyboard.KEY_LCONTROL));
			properties.setProperty("boiler", "show");

		}

		// Write properties file.
		try {
			properties.store(new FileOutputStream(Minecraft.getMinecraft()
					+ "/airship.properties"), null);
		} catch (IOException e) {

		}
		ModLoader.setInGameHook(this,true,false);

	}

	
	public boolean OnTickInGame(Minecraft game)
    {
		if(ModLoader.isModLoaded("mod_Aether"))
		{
				if((game.currentScreen instanceof GuiInventoryMoreSlots || game.currentScreen instanceof GuiInventory) && game.thePlayer.ridingEntity instanceof EntityAirship && game.thePlayer.ridingEntity != null)
				{
					game.displayGuiScreen(new GuiAirship(game.thePlayer.inventory, (EntityAirship)game.thePlayer.ridingEntity));
				}
		}
		else
		if(game.currentScreen instanceof GuiInventory && game.thePlayer.ridingEntity instanceof EntityAirship && game.thePlayer.ridingEntity !=null)
		{
			game.displayGuiScreen(new GuiAirship(game.thePlayer.inventory, (EntityAirship)game.thePlayer.ridingEntity));
		}
		
		return true;
    }
	
	
	public void AddRenderer(Map map) {
		map.put(EntityAirship.class, new RenderAirship(new ModelAirship(),
				new ModelBalloon(), 3.0f));

	}

	public static int spriteindex;

	public static Item airShip = (new ItemAirship(4242)).setIconIndex(
			ModLoader.addOverride("/gui/items.png", "/gui/airship.png"))
			.setItemName("Airship");
	public static Item engine = (new Item(4243)).setIconIndex(
			ModLoader.addOverride("/gui/items.png", "/gui/engine.png"))
			.setItemName("Engine");
	public static Item balloon = (new Item(4244)).setIconIndex(
			ModLoader.addOverride("/gui/items.png", "/gui/balloon.png"))
			.setItemName("Balloon");

	public static int KEY_UP = Keyboard.KEY_SPACE;
	public static int KEY_DOWN = Keyboard.KEY_LSHIFT;
	public static int KEY_CHEST = Keyboard.KEY_RSHIFT;
	public static int KEY_FIRE = Keyboard.KEY_LCONTROL;
	public static boolean SHOW_BOILER = true;
	public static GuiIngame chat;

	private static World world;
	
	
	public String Version() {
		//
		return "Airships V2.5 for 1.7.3";
	}


	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
