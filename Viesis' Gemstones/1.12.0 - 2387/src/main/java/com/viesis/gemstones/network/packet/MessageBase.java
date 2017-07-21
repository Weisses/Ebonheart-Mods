package com.viesis.gemstones.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {
	
	@Override
	public REQ onMessage(REQ message, MessageContext ctx)
	{
		if(ctx.side == Side.SERVER)
		{
			final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
			final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
			
			playerWorldServer.addScheduledTask(new Runnable() 
		    {
		    	public void run() 
		    	{
		    		handleServerSide(message, sendingPlayer);
		    	}
		    });
		}
		else
		{
			final Minecraft playerWorldClient = Minecraft.getMinecraft();
		    
			playerWorldClient.addScheduledTask(new Runnable() 
		    {
		    	public void run() 
		    	{
		    		handleClientSide(message, null);
		    	}
		    });
		}
		
		return null;
	}
	
	public abstract void handleClientSide(REQ message, EntityPlayer player );
	
	public abstract void handleServerSide(REQ message, EntityPlayer player );
	
}
