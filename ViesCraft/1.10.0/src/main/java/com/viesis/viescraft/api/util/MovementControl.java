package com.viesis.viescraft.api.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

public class MovementControl {
	
	public static int KEY_UP = Keyboard.KEY_SPACE;
	public static int KEY_DOWN = Keyboard.KEY_LSHIFT;
	public static int KEY_CHEST = Keyboard.KEY_RSHIFT;
	public static int KEY_FIRE = Keyboard.KEY_LCONTROL;
	
	public static void initMovement()
	{
	
	Properties properties = new Properties();
	try {
		properties.load(new FileInputStream(Minecraft.getMinecraft()
				+ "/airship.properties"));

		KEY_UP = Keyboard.getKeyIndex(properties.getProperty("ascend"));
		KEY_DOWN = Keyboard.getKeyIndex(properties.getProperty("descend"));
		KEY_CHEST = Keyboard.getKeyIndex(properties.getProperty("chest"));
		KEY_FIRE = Keyboard.getKeyIndex(properties.getProperty("fire"));
		String temp = properties.getProperty("boiler");
		//if (temp.contains("show"))
		//	SHOW_BOILER = true;
		//else
		//	SHOW_BOILER = false;

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
	}
}
