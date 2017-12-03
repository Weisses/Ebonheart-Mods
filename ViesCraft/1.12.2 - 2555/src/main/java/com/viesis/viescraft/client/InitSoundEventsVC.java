package com.viesis.viescraft.client;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.SoundsVC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class InitSoundEventsVC extends SoundsVC {
    
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
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		@SubscribeEvent
		public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) 
		{
			event.getRegistry().registerAll(
					BRAMBLE,
					CASTLE,
					JUNGLE,
					DIRE,
					STORMS,
					TIMESCAR,
					ENGINEON
			);
		}
	}
}

	/**
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
*/