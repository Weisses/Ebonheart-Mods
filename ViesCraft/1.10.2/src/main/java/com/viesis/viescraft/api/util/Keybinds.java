package com.viesis.viescraft.api.util;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.proxy.ClientProxy;

public class Keybinds {

	public static KeyBinding[] keyBindings;
	
	public static KeyBinding vcForward;
	public static KeyBinding vcBack;
	public static KeyBinding vcLeft;
	public static KeyBinding vcRight;
	public static KeyBinding vcUp;
	public static KeyBinding vcDown;
	
	public static KeyBinding vcInventory;
	
	public static void init() 
	{
	       
		// Define the "ping" binding, with (unlocalized) name "key.ping" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
	       
		//ping = new KeyBinding("key.vc.inventory", Keyboard.KEY_O, "key.categories.viescraft");
	       
		// Define the "pong" binding, with (unlocalized) name "key.pong" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)
	       
		vcForward = new KeyBinding("vc.key.moveForward", Keyboard.KEY_W, "vc.key.viescraft");
		vcBack = new KeyBinding("vc.key.moveBack", Keyboard.KEY_S, "vc.key.viescraft");
		vcLeft = new KeyBinding("vc.key.moveLeft", Keyboard.KEY_A, "vc.key.viescraft");
		vcRight = new KeyBinding("vc.key.moveRight", Keyboard.KEY_D, "vc.key.viescraft");
		vcUp = new KeyBinding("vc.key.moveUp", Keyboard.KEY_SPACE, "vc.key.viescraft");
		vcDown = new KeyBinding("vc.key.moveDown", Keyboard.KEY_X, "vc.key.viescraft");
	    
		vcInventory = new KeyBinding("vc.key.openInventory", Keyboard.KEY_R, "vc.key.viescraft");
	    
		// Register both KeyBindings to the ClientRegistry
	       //ClientRegistry.registerKeyBinding(ping);
	       //ClientRegistry.registerKeyBinding(pong);
		
		ClientRegistry.registerKeyBinding(vcForward);
		ClientRegistry.registerKeyBinding(vcBack);
		ClientRegistry.registerKeyBinding(vcLeft);
		ClientRegistry.registerKeyBinding(vcRight);
		ClientRegistry.registerKeyBinding(vcUp);
		ClientRegistry.registerKeyBinding(vcDown);
		ClientRegistry.registerKeyBinding(vcInventory);
	
	}
	
	/**
	public static void init1()
	{
		// declare an array of key bindings
		keyBindings = new KeyBinding[2]; 
		
		// instantiate the key bindings
		keyBindings[0] = new KeyBinding("key.structure.desc", Keyboard.KEY_P, "key.magicbeans.category");
		keyBindings[1] = new KeyBinding("key.hud.desc", Keyboard.KEY_H, "key.magicbeans.category");
		
		// register all the key bindings
		for (int i = 0; i < keyBindings.length; ++i) 
		{
			ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event)
	{
	    // DEBUG
	    System.out.println("Key Input Event");

	    // make local copy of key binding array
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
	   
	    // check each enumerated key binding type for pressed and take appropriate action
	    if (keyBindings[0].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[0].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[1].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[1].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	}

	*/
	
}
