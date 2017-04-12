package com.viesis.viescraft.network;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.MessageGuiColorizerBalloon;
import com.viesis.viescraft.network.server.airship.MessageGuiDefault;
import com.viesis.viescraft.network.server.airship.MessageGuiModule;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventoryLarge;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventorySmall;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage1;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage4;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage1;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage4;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void preInit()
	{
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel (Reference.MOD_ID);
		
		//Registering the messages
		INSTANCE.registerMessage(MessageConfig.class, MessageConfig.class, 0, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiDefault.class, MessageGuiDefault.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiModule.class, MessageGuiModule.class, 5, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiModuleInventorySmall.class, MessageGuiModuleInventorySmall.class, 9, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiModuleInventoryLarge.class, MessageGuiModuleInventoryLarge.class, 13, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiColorizerBalloon.class, MessageGuiColorizerBalloon.class, 61, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiAppearancePage1.class, MessageGuiAppearancePage1.class, 17, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearancePage2.class, MessageGuiAppearancePage2.class, 18, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearancePage3.class, MessageGuiAppearancePage3.class, 19, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearancePage4.class, MessageGuiAppearancePage4.class, 20, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiAppearanceHelperPage1.class, MessageGuiAppearanceHelperPage1.class, 21, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearanceHelperPage2.class, MessageGuiAppearanceHelperPage2.class, 22, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearanceHelperPage3.class, MessageGuiAppearanceHelperPage3.class, 23, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiAppearanceHelperPage4.class, MessageGuiAppearanceHelperPage4.class, 24, Side.SERVER);
		
		INSTANCE.registerMessage(MessageGuiModuleJukebox.class, MessageGuiModuleJukebox.class, 25, Side.SERVER);
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
