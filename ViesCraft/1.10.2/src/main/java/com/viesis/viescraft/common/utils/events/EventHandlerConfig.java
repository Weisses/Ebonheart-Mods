package com.viesis.viescraft.common.utils.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.client.MessageConfig;

public class EventHandlerConfig {
	
	public EventHandlerConfig()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event)
	{
		if(!event.player.worldObj.isRemote)
		{
			NetworkHandler.sendToClient(new MessageConfig(), (EntityPlayerMP)event.player);
			
			//NetworkHandler.sendToClient(new MessageTest(), (EntityPlayerMP)event.player);
			
			//LogHelper.info("Sent config to '" + event.player.getDisplayName() + ".'");
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogoutEvent(PlayerLoggedOutEvent event)
	{
		
	}
}
