package com.viesis.viescraft.client;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.SoundsVC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitSoundEventsVC extends SoundsVC {
    
	//Register the {@link SoundEvent}s.
	public static void registerSounds() 
	{
		bramble = registerSound("record.bramble");
		castle = registerSound("record.castle");
		jungle = registerSound("record.jungle");
		dire = registerSound("record.dire");
		storms = registerSound("record.storms");
		timescar = registerSound("record.timescar");
		engineOn = registerSound("sound.engineon");
	}
	
	private static SoundEvent registerSound(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(References.MOD_ID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
