package com.viesis.viescraft.common.utils.events;

import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.client.MessageConfig;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class EventHandlerConfig {
	
	public EventHandlerConfig()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event)
	{
		if(!event.player.world.isRemote)
		{
			NetworkHandler.sendToClient(new MessageConfig(), (EntityPlayerMP)event.player);
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogoutEvent(PlayerLoggedOutEvent event)
	{
		
	}
}
