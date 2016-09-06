package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.MessageGuiOpenV1;
import com.viesis.viescraft.network.server.MessageGuiOpenV2;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel (Reference.MOD_ID);
		
		//Registering the messages
		INSTANCE.registerMessage(MessageGuiOpenV1.class, MessageGuiOpenV1.class, 0, Side.SERVER);
		INSTANCE.registerMessage(MessageConfig.class, MessageConfig.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiOpenV2.class, MessageGuiOpenV2.class, 2, Side.SERVER);
		
	}
	
	public static void sendToServer(IMessage message)
	{
		INSTANCE.sendToServer(message);
	}
	
	public static void sendToClient(IMessage message, EntityPlayerMP player)
	{
		INSTANCE.sendTo(message, player);
	}
}
