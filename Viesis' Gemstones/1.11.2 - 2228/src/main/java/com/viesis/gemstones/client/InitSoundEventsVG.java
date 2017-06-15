package com.viesis.gemstones.client;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.VGSounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitSoundEventsVG  extends VGSounds {
    
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
		
		///trigun = registerSound("record.trigun");
		///bramble = registerSound("record.bramble");
		///storms = registerSound("record.storms");
		///cowboy = registerSound("record.cowboy");
		///bay = registerSound("record.bay");
		///engineOn = registerSound("sound.engineon");
	}
	
	private static SoundEvent registerSound(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(References.MOD_ID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
