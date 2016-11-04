package com.viesis.dismounter.api.util;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import org.lwjgl.input.Keyboard;

public class Keybinds {
	
	public static KeyBinding[] keyBindings;
	
	public static KeyBinding vcForward;
	public static KeyBinding vcBack;
	public static KeyBinding vcLeft;
	public static KeyBinding vcRight;
	public static KeyBinding vcUp;
	public static KeyBinding vcDown;
	public static KeyBinding vcInventory;
	///public static KeyBinding vcModule;
	
	public static void init() 
	{
		vcForward = new KeyBinding("vc.key.moveForward", Keyboard.KEY_W, "vc.key.viescraft");
		vcBack = new KeyBinding("vc.key.moveBack", Keyboard.KEY_S, "vc.key.viescraft");
		vcLeft = new KeyBinding("vc.key.moveLeft", Keyboard.KEY_A, "vc.key.viescraft");
		vcRight = new KeyBinding("vc.key.moveRight", Keyboard.KEY_D, "vc.key.viescraft");
		vcUp = new KeyBinding("vc.key.moveUp", Keyboard.KEY_SPACE, "vc.key.viescraft");
		vcDown = new KeyBinding("vc.key.moveDown", Keyboard.KEY_X, "vc.key.viescraft");
		vcInventory = new KeyBinding("vc.key.openInventory", Keyboard.KEY_R, "vc.key.viescraft");
		///vcModule = new KeyBinding("vc.key.useModule", Keyboard.KEY_C, "vc.key.viescraft");
	    
		//Register KeyBingings
		ClientRegistry.registerKeyBinding(vcForward);
		ClientRegistry.registerKeyBinding(vcBack);
		ClientRegistry.registerKeyBinding(vcLeft);
		ClientRegistry.registerKeyBinding(vcRight);
		ClientRegistry.registerKeyBinding(vcUp);
		ClientRegistry.registerKeyBinding(vcDown);
		ClientRegistry.registerKeyBinding(vcInventory);
		///ClientRegistry.registerKeyBinding(vcModule);
	}
}
