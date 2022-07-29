package com.viesis.viescraft.api;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundsVC {
	
	public static final SoundEvent BRAMBLE = createSoundEvent("record.bramble");
	public static final SoundEvent CASTLE = createSoundEvent("record.castle");
	public static final SoundEvent JUNGLE = createSoundEvent("record.jungle");
	public static final SoundEvent DIRE = createSoundEvent("record.dire");
	public static final SoundEvent STORMS = createSoundEvent("record.storms");
	public static final SoundEvent TIMESCAR = createSoundEvent("record.timescar");
	public static final SoundEvent ENGINEON = createSoundEvent("sound.engineon");
	
	private static SoundEvent createSoundEvent(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(References.MOD_ID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
	//================================
}
