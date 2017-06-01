package com.ebonheart.EbonArtsMod.common.utils;

import com.ebonheart.EbonArtsMod.api.Reference;
import com.ebonheart.EbonArtsMod.api.SoundsEA;

import net.minecraft.client.audio.SoundManager;
import net.minecraft.init.Bootstrap;
//import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SoundEventsEA extends SoundsEA {
    
    	
    	
    	
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
    	
}
