package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.v1.MessageGuiV1Default;
import com.viesis.viescraft.network.server.v1.MessageGuiV1Module;
import com.viesis.viescraft.network.server.v1.MessageGuiV1ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v1.MessageGuiV1ModuleInventorySmall;
import com.viesis.viescraft.network.server.v2.MessageGuiV2Default;
import com.viesis.viescraft.network.server.v2.MessageGuiV2Module;
import com.viesis.viescraft.network.server.v2.MessageGuiV2ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v2.MessageGuiV2ModuleInventorySmall;
import com.viesis.viescraft.network.server.v3.MessageGuiV3Default;
import com.viesis.viescraft.network.server.v3.MessageGuiV3Module;
import com.viesis.viescraft.network.server.v3.MessageGuiV3ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v3.MessageGuiV3ModuleInventorySmall;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel (Reference.MOD_ID);
		
		//Registering the messages
		INSTANCE.registerMessage(MessageConfig.class, MessageConfig.class, 0, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1Default.class, MessageGuiV1Default.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV2Default.class, MessageGuiV2Default.class, 2, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV3Default.class, MessageGuiV3Default.class, 3, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1Module.class, MessageGuiV1Module.class, 4, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV2Module.class, MessageGuiV2Module.class, 5, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV3Module.class, MessageGuiV3Module.class, 6, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1ModuleInventorySmall.class, MessageGuiV1ModuleInventorySmall.class, 7, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV2ModuleInventorySmall.class, MessageGuiV2ModuleInventorySmall.class, 8, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV3ModuleInventorySmall.class, MessageGuiV3ModuleInventorySmall.class, 9, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiV1ModuleInventoryLarge.class, MessageGuiV1ModuleInventoryLarge.class, 10, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV2ModuleInventoryLarge.class, MessageGuiV2ModuleInventoryLarge.class, 11, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiV3ModuleInventoryLarge.class, MessageGuiV3ModuleInventoryLarge.class, 12, Side.SERVER);
		
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
