package com.viesis.gemstones.client;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.VGSounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(References.MOD_ID)
public class InitSoundEventsVG  extends VGSounds {
    
	public static final SoundEvent ISLAND = createSoundEvent("record.glowing_disc");
	public static final SoundEvent DIRE = createSoundEvent("record.shimmering_disc");
	public static final SoundEvent MARBLE = createSoundEvent("record.laminate_disc");
	public static final SoundEvent STRENGTH = createSoundEvent("record.resilient_disc");
	public static final SoundEvent CASTLE = createSoundEvent("record.dismal_disc");
	public static final SoundEvent TIMESCAR = createSoundEvent("record.ethereal_disc");
	public static final SoundEvent LOSTWOODS = createSoundEvent("record.mirroring_disc");
	
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
					ISLAND,
					DIRE,
					MARBLE,
					STRENGTH,
					CASTLE,
					TIMESCAR,
					LOSTWOODS
			);
		}
	}
}
