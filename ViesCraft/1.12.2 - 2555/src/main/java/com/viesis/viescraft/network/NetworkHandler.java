package com.viesis.viescraft.network;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusicArea;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeBalloonVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeCoreVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeEngineVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeFrameVC;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloon;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrame;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrameColor;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuBalloonTransparent;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuFrameColor;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuFrameTransparent;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageGuiVisualMenuBalloonTier1Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageGuiVisualMenuBalloonTier2Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageGuiVisualMenuBalloonTier3Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageGuiVisualMenuBalloonTier4Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageGuiVisualMenuBalloonTier5Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageHelperGuiVisualMenuBalloonTier1Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageHelperGuiVisualMenuBalloonTier2Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageHelperGuiVisualMenuBalloonTier3Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageHelperGuiVisualMenuBalloonTier4Pg1;
import com.viesis.viescraft.network.server.airship.visual.balloon.MessageHelperGuiVisualMenuBalloonTier5Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier2Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier3Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier4Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier5Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier2Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier3Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier4Pg1;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier5Pg1;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg1;
import com.viesis.viescraft.network.server.song.MessageHelperGuiMusicPg1;

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
		
		register(MessageConfig.class, MessageConfig.class, Side.SERVER);
		
		register(MessageGuiAirshipMenu.class, MessageGuiAirshipMenu.class, Side.SERVER);
		register(MessageGuiAirshipMenuStorageLesser.class, MessageGuiAirshipMenuStorageLesser.class, Side.SERVER);
		register(MessageGuiAirshipMenuStorageNormal.class, MessageGuiAirshipMenuStorageNormal.class, Side.SERVER);
		register(MessageGuiAirshipMenuStorageGreater.class, MessageGuiAirshipMenuStorageGreater.class, Side.SERVER);
		register(MessageGuiAirshipMenuMusic.class, MessageGuiAirshipMenuMusic.class, Side.SERVER);
		
		register(MessageGuiUpgradeMenu.class, MessageGuiUpgradeMenu.class, Side.SERVER);
		register(MessageGuiVisualMenu.class, MessageGuiVisualMenu.class, Side.SERVER);
		register(MessageGuiModuleMenu.class, MessageGuiModuleMenu.class, Side.SERVER);
		
		register(MessageHelperGuiUpgradeFrameVC.class, MessageHelperGuiUpgradeFrameVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeCoreVC.class, MessageHelperGuiUpgradeCoreVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeEngineVC.class, MessageHelperGuiUpgradeEngineVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeBalloonVC.class, MessageHelperGuiUpgradeBalloonVC.class, Side.SERVER);
		
		register(MessageGuiVisualMenuFrame.class, MessageGuiVisualMenuFrame.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameColor.class, MessageGuiVisualMenuFrameColor.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameColor.class, MessageHelperGuiVisualMenuFrameColor.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTransparent.class, MessageHelperGuiVisualMenuFrameTransparent.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier1Pg1.class, MessageGuiVisualMenuFrameTier1Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier1Pg2.class, MessageGuiVisualMenuFrameTier1Pg2.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier2Pg1.class, MessageGuiVisualMenuFrameTier2Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier3Pg1.class, MessageGuiVisualMenuFrameTier3Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier4Pg1.class, MessageGuiVisualMenuFrameTier4Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuFrameTier5Pg1.class, MessageGuiVisualMenuFrameTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier1Pg1.class, MessageHelperGuiVisualMenuFrameTier1Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier1Pg2.class, MessageHelperGuiVisualMenuFrameTier1Pg2.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier2Pg1.class, MessageHelperGuiVisualMenuFrameTier2Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier3Pg1.class, MessageHelperGuiVisualMenuFrameTier3Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier4Pg1.class, MessageHelperGuiVisualMenuFrameTier4Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuFrameTier5Pg1.class, MessageHelperGuiVisualMenuFrameTier5Pg1.class, Side.SERVER);
		
		register(MessageGuiVisualMenuBalloon.class, MessageGuiVisualMenuBalloon.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonColor.class, MessageGuiVisualMenuBalloonColor.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonColor.class, MessageHelperGuiVisualMenuBalloonColor.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTransparent.class, MessageHelperGuiVisualMenuBalloonTransparent.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonTier1Pg1.class, MessageGuiVisualMenuBalloonTier1Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonTier2Pg1.class, MessageGuiVisualMenuBalloonTier2Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonTier3Pg1.class, MessageGuiVisualMenuBalloonTier3Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonTier4Pg1.class, MessageGuiVisualMenuBalloonTier4Pg1.class, Side.SERVER);
		register(MessageGuiVisualMenuBalloonTier5Pg1.class, MessageGuiVisualMenuBalloonTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTier1Pg1.class, MessageHelperGuiVisualMenuBalloonTier1Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTier2Pg1.class, MessageHelperGuiVisualMenuBalloonTier2Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTier3Pg1.class, MessageHelperGuiVisualMenuBalloonTier3Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTier4Pg1.class, MessageHelperGuiVisualMenuBalloonTier4Pg1.class, Side.SERVER);
		register(MessageHelperGuiVisualMenuBalloonTier5Pg1.class, MessageHelperGuiVisualMenuBalloonTier5Pg1.class, Side.SERVER);
		
		register(MessageHelperGuiModuleLearn.class, MessageHelperGuiModuleLearn.class, Side.SERVER);
		register(MessageHelperGuiModuleToggleSlot1.class, MessageHelperGuiModuleToggleSlot1.class, Side.SERVER);
		
		register(MessageGuiPlayMusic.class, MessageGuiPlayMusic.class, Side.SERVER);
		register(MessageGuiPlayMusicArea.class, MessageGuiPlayMusicArea.class, Side.CLIENT);
		
		register(MessageGuiMusicPg1.class, MessageGuiMusicPg1.class, Side.SERVER);
		register(MessageHelperGuiMusicPg1.class, MessageHelperGuiMusicPg1.class, Side.SERVER);
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
