package com.viesis.viescraft.common.utils;

//import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.SoundsVC;

public class SoundEventsEA extends SoundsVC {
    
    	
    	/**
    	
    	//Register the {@link SoundEvent}s.
    	public static void registerSounds() 
    	{
    		
    		island = registerSound("record.glowing_disc");
    		dire = registerSound("record.shimmering_disc");
    		marble = registerSound("record.laminate_disc");
    		strength = registerSound("record.resilient_disc");
    		castle = registerSound("record.dismal_disc");
    		timescar = registerSound("record.ethereal_disc");
    		lostwoods = registerSound("record.mirroring_disc");
    		
    	}

    	private static SoundEvent registerSound(String soundName) {
    		final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
    		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
    	}
    	*/
}
