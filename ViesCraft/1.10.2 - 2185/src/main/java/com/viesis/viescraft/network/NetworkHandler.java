package com.viesis.viescraft.network;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.MessageGuiColorizerBalloon;
import com.viesis.viescraft.network.server.airship.MessageGuiDefault;
import com.viesis.viescraft.network.server.airship.MessageGuiModule;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventoryLarge;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventorySmall;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusicArea;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage1;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage4;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage5;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage1;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage4;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage5;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg1;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg2;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg3;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg4;
import com.viesis.viescraft.network.server.song.MessageGuiSongHelperPage1;
import com.viesis.viescraft.network.server.song.MessageGuiSongHelperPage2;
import com.viesis.viescraft.network.server.song.MessageGuiSongHelperPage3;
import com.viesis.viescraft.network.server.song.MessageGuiSongHelperPage4;

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
		INSTANCE =  NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		
		register(MessageConfig.class, MessageConfig.class, Side.SERVER);
		register(MessageGuiDefault.class, MessageGuiDefault.class, Side.SERVER);
		register(MessageGuiModule.class, MessageGuiModule.class, Side.SERVER);
		register(MessageGuiModuleInventorySmall.class, MessageGuiModuleInventorySmall.class, Side.SERVER);
		register(MessageGuiModuleInventoryLarge.class, MessageGuiModuleInventoryLarge.class, Side.SERVER);
		register(MessageGuiModuleJukebox.class, MessageGuiModuleJukebox.class, Side.SERVER);
		
		register(MessageGuiColorizerBalloon.class, MessageGuiColorizerBalloon.class, Side.SERVER);
		
		register(MessageGuiAppearancePage1.class, MessageGuiAppearancePage1.class, Side.SERVER);
		register(MessageGuiAppearancePage2.class, MessageGuiAppearancePage2.class, Side.SERVER);
		register(MessageGuiAppearancePage3.class, MessageGuiAppearancePage3.class, Side.SERVER);
		register(MessageGuiAppearancePage4.class, MessageGuiAppearancePage4.class, Side.SERVER);
		register(MessageGuiAppearancePage5.class, MessageGuiAppearancePage5.class, Side.SERVER);
		
		register(MessageGuiAppearanceHelperPage1.class, MessageGuiAppearanceHelperPage1.class, Side.SERVER);
		register(MessageGuiAppearanceHelperPage2.class, MessageGuiAppearanceHelperPage2.class, Side.SERVER);
		register(MessageGuiAppearanceHelperPage3.class, MessageGuiAppearanceHelperPage3.class, Side.SERVER);
		register(MessageGuiAppearanceHelperPage4.class, MessageGuiAppearanceHelperPage4.class, Side.SERVER);
		register(MessageGuiAppearanceHelperPage5.class, MessageGuiAppearanceHelperPage5.class, Side.SERVER);
		
		register(MessageGuiPlayMusic.class, MessageGuiPlayMusic.class, Side.SERVER);
		register(MessageGuiPlayMusicArea.class, MessageGuiPlayMusicArea.class, Side.CLIENT);
		
		register(MessageGuiMusicPg1.class, MessageGuiMusicPg1.class, Side.SERVER);
		register(MessageGuiMusicPg2.class, MessageGuiMusicPg2.class, Side.SERVER);
		register(MessageGuiMusicPg3.class, MessageGuiMusicPg3.class, Side.SERVER);
		register(MessageGuiMusicPg4.class, MessageGuiMusicPg4.class, Side.SERVER);

		register(MessageGuiSongHelperPage1.class, MessageGuiSongHelperPage1.class, Side.SERVER);
		register(MessageGuiSongHelperPage2.class, MessageGuiSongHelperPage2.class, Side.SERVER);
		register(MessageGuiSongHelperPage3.class, MessageGuiSongHelperPage3.class, Side.SERVER);
		register(MessageGuiSongHelperPage4.class, MessageGuiSongHelperPage4.class, Side.SERVER);
		
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
