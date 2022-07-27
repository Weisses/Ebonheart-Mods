package com.viesis.viescraft.client;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.SoundsVC;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = References.MOD_ID)
public class InitSoundEventsVC extends SoundsVC {
	
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
