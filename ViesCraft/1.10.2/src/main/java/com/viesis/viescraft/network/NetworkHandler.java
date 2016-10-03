package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.MessageGuiOpenV2;
import com.viesis.viescraft.network.server.MessageGuiOpenV3;
import com.viesis.viescraft.network.server.MessageGuiV1Default;
import com.viesis.viescraft.network.server.MessageGuiV1Module;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventoryLarge;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventorySmall;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel (Reference.MOD_ID);
		
		//Registering the messages
		INSTANCE.registerMessage(MessageConfig.class, MessageConfig.class, 0, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1Default.class, MessageGuiV1Default.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiOpenV2.class, MessageGuiOpenV2.class, 2, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiOpenV3.class, MessageGuiOpenV3.class, 3, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1Module.class, MessageGuiV1Module.class, 4, Side.SERVER);
		
		
		INSTANCE.registerMessage(MessageGuiV1ModuleInventorySmall.class, MessageGuiV1ModuleInventorySmall.class, 7, Side.SERVER);
		
		
		INSTANCE.registerMessage(MessageGuiV1ModuleInventoryLarge.class, MessageGuiV1ModuleInventoryLarge.class, 10, Side.SERVER);
		
		
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
