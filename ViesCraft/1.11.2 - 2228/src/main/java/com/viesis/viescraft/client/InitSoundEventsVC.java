package com.viesis.viescraft.client;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.SoundsVC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitSoundEventsVC extends SoundsVC {
    
	//Register the {@link SoundEvent}s.
	public static void registerSounds() 
	{
		trigun = registerSound("record.trigun");
		bramble = registerSound("record.bramble");
		storms = registerSound("record.storms");
		cowboy = registerSound("record.cowboy");
		bay = registerSound("record.bay");
	}
	
	private static SoundEvent registerSound(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
