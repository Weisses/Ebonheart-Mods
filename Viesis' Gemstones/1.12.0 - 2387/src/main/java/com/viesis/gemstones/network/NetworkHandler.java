package com.viesis.gemstones.network;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.network.client.MessageGuiConverterSyncClientGem;
import com.viesis.gemstones.network.client.MessageGuiConverterSyncClientOn;
import com.viesis.gemstones.network.client.MessageGuiWorkbenchSyncClientGem;
import com.viesis.gemstones.network.client.MessageGuiWorkbenchSyncClientOn;
import com.viesis.gemstones.network.server.MessageGuiConverterMain;
import com.viesis.gemstones.network.server.MessageGuiConverterSyncServerGem;
import com.viesis.gemstones.network.server.MessageGuiConverterSyncServerOn;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchMain;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchSyncServerGem;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchSyncServerOn;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	private static int entityID = 1;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel(References.MOD_ID);
		
		register(MessageGuiWorkbenchMain.class, MessageGuiWorkbenchMain.class, Side.SERVER);
		register(MessageGuiWorkbenchSyncServerGem.class, MessageGuiWorkbenchSyncServerGem.class, Side.SERVER);
		register(MessageGuiWorkbenchSyncServerOn.class, MessageGuiWorkbenchSyncServerOn.class, Side.SERVER);
		
		register(MessageGuiWorkbenchSyncClientGem.class, MessageGuiWorkbenchSyncClientGem.class, Side.CLIENT);
		register(MessageGuiWorkbenchSyncClientOn.class, MessageGuiWorkbenchSyncClientOn.class, Side.CLIENT);
		
		register(MessageGuiConverterMain.class, MessageGuiConverterMain.class, Side.SERVER);
		register(MessageGuiConverterSyncServerGem.class, MessageGuiConverterSyncServerGem.class, Side.SERVER);
		register(MessageGuiConverterSyncServerOn.class, MessageGuiConverterSyncServerOn.class, Side.SERVER);
		
		register(MessageGuiConverterSyncClientGem.class, MessageGuiConverterSyncClientGem.class, Side.CLIENT);
		register(MessageGuiConverterSyncClientOn.class, MessageGuiConverterSyncClientOn.class, Side.CLIENT);
	}
	
	public static <REQ extends IMessage, REPLY extends IMessage> void register(Class<? extends IMessageHandler<REQ, REPLY>> message1, Class<REQ> message2, Side side)
	{
		INSTANCE.registerMessage(message1, message2, entityID++, side);
	}
	
	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}
	
	public static void sendToClient(IMessage message, EntityPlayerMP player)
	{
		INSTANCE.sendTo(message, player);
	}
	
	public static void sendToAllAround(IMessage message, TargetPoint point)
	{
		INSTANCE.sendToAllAround(message, point);
	}
	
	public static void sendToAll(IMessage message)
	{
		INSTANCE.sendToAll(message);
	}
	
	public static void sendToDimension(IMessage message, int dimensionId)
	{
		INSTANCE.sendToDimension(message, dimensionId);
	}
}
