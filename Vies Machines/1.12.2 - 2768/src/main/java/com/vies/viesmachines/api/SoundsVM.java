package com.vies.viesmachines.api;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsVM {
	
	public static SoundEvent BRAMBLE;
	public static SoundEvent CASTLE;
	public static SoundEvent JUNGLE;
	public static SoundEvent DIRE;
	public static SoundEvent STORMS;
	public static SoundEvent TIMESCAR;
	public static SoundEvent ENGINEON;
	public static SoundEvent UPGRADE;
	public static SoundEvent HEAL;
	
	public static void registerSounds()
	{
		BRAMBLE = registerSound("record.bramble");
		CASTLE = registerSound("record.castle");
		JUNGLE = registerSound("record.jungle");
		DIRE = registerSound("record.dire");
		STORMS = registerSound("record.storms");
		TIMESCAR = registerSound("record.timescar");
		ENGINEON = registerSound("sound.engineon");
		UPGRADE = registerSound("sound.upgrade");
		HEAL = registerSound("sound.heal");
	}
	
	/** Registers all custom sounds. */
	private static SoundEvent registerSound(String name) 
	{
	    ResourceLocation location = new ResourceLocation(References.MOD_ID, name);
	    SoundEvent event = new SoundEvent(location);
	    event.setRegistryName(name);
	    ForgeRegistries.SOUND_EVENTS.register(event);
	    
	    return event;
	}
}
