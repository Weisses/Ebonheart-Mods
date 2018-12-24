package com.vies.viesmachines.client;

import com.vies.viesmachines.api.SoundsVM;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

//@Mod.EventBusSubscriber(value = Side.CLIENT, modid = References.MOD_ID)
public class InitSoundEventsVM extends SoundsVM {
	
	@SubscribeEvent
	public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) 
	{
		IForgeRegistry<SoundEvent> registry = event.getRegistry();
		
		event.getRegistry().registerAll(
				BRAMBLE,
				CASTLE,
				JUNGLE,
				DIRE,
				STORMS,
				TIMESCAR,
				ENGINEON,
				UPGRADE,
				HEAL
		);
	}
}
