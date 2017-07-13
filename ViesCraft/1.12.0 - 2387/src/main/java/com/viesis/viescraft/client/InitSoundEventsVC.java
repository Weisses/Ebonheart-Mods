package com.viesis.viescraft.client;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.SoundsVC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Reference.MOD_ID)
public class InitSoundEventsVC extends SoundsVC {
	
	public static final SoundEvent TRIGUN = createSoundEvent("record.trigun");
	public static final SoundEvent BRAMBLE = createSoundEvent("record.bramble");
	public static final SoundEvent STORMS = createSoundEvent("record.storms");
	public static final SoundEvent COWBOY = createSoundEvent("record.cowboy");
	public static final SoundEvent BAY = createSoundEvent("record.bay");
	public static final SoundEvent ENGINEON = createSoundEvent("sound.engineon");
	
	private static SoundEvent createSoundEvent(String soundName) 
	{
		final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler 
	{
		@SubscribeEvent
		public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) 
		{
			event.getRegistry().registerAll(
					TRIGUN,
					BRAMBLE,
					STORMS,
					COWBOY,
					BAY,
					ENGINEON
			);
		}
	}
}
