package com.vies.viesmachines.api.util;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.References;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
	
	public static KeyBinding[] keyBindings;
	
	public static KeyBinding moveForward;
	public static KeyBinding moveBack;
	public static KeyBinding moveLeft;
	public static KeyBinding moveRight;
	public static KeyBinding moveUp;
	public static KeyBinding moveDown;
	public static KeyBinding openGuiMenu;
	public static KeyBinding shootProjectile;
	public static KeyBinding toggleAbility;
	
	public static void init() 
	{
		moveForward = new KeyBinding(References.MOD_ID + ".key.moveforward", Keyboard.KEY_W, References.MOD_ID + ".movement.keys");
		moveBack = new KeyBinding(References.MOD_ID + ".key.moveback", Keyboard.KEY_S, References.MOD_ID + ".movement.keys");
		moveLeft = new KeyBinding(References.MOD_ID + ".key.moveleft", Keyboard.KEY_A, References.MOD_ID + ".movement.keys");
		moveRight = new KeyBinding(References.MOD_ID + ".key.moveright", Keyboard.KEY_D, References.MOD_ID + ".movement.keys");
		moveUp = new KeyBinding(References.MOD_ID + ".key.moveup", Keyboard.KEY_SPACE, References.MOD_ID + ".movement.keys");
		moveDown = new KeyBinding(References.MOD_ID + ".key.movedown", Keyboard.KEY_X, References.MOD_ID + ".movement.keys");
		openGuiMenu = new KeyBinding(References.MOD_ID + ".key.openguimenu", Keyboard.KEY_R, References.MOD_ID + ".gameplay.keys");
		shootProjectile = new KeyBinding(References.MOD_ID + ".key.shootprojectile", Keyboard.KEY_Z, References.MOD_ID + ".gameplay.keys");
		toggleAbility = new KeyBinding(References.MOD_ID + ".key.toggleability", Keyboard.KEY_C, References.MOD_ID + ".gameplay.keys");
		
		//Register KeyBingings
		ClientRegistry.registerKeyBinding(moveForward);
		ClientRegistry.registerKeyBinding(moveBack);
		ClientRegistry.registerKeyBinding(moveLeft);
		ClientRegistry.registerKeyBinding(moveRight);
		ClientRegistry.registerKeyBinding(moveUp);
		ClientRegistry.registerKeyBinding(moveDown);
		ClientRegistry.registerKeyBinding(openGuiMenu);
		ClientRegistry.registerKeyBinding(shootProjectile);
		ClientRegistry.registerKeyBinding(toggleAbility);
	}
}
