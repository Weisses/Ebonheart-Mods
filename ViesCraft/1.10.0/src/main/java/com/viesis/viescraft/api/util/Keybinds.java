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
	
	public static KeyBinding ping;
	public static KeyBinding pong;
	
	public static void init1() {
	       // Define the "ping" binding, with (unlocalized) name "key.ping" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
	       ping = new KeyBinding("key.ping", Keyboard.KEY_O, "key.categories.mymod");
	       // Define the "pong" binding, with (unlocalized) name "key.pong" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)
	       pong = new KeyBinding("key.pong", Keyboard.KEY_P, "key.categories.mymod");
	    // Register both KeyBindings to the ClientRegistry
	       ClientRegistry.registerKeyBinding(ping);
	       ClientRegistry.registerKeyBinding(pong);
	   }
	
	public static void init()
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
	        System.out.println("Key binding ="+keyBindings[0].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[1].isPressed()) 
	    {
	        // DEBUG
	        System.out.println("Key binding ="+keyBindings[1].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	}

	
	
}
