package com.viesis.viescraft.network;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.network.client.MessageConfig;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusicArea;
import com.viesis.viescraft.network.server.airship.MessageGuiRandomMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiStopMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiStopMusicArea;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeBalloonVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeCoreVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeEngineVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeFrameVC;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenuOptionsRedstone;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuOptionsRedstone;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuUndo;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonColorUndo;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonMain;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColorDefault;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonTransparent;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier1Pg2;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier2Pg1;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier3Pg1;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier4Pg1;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageGuiCustomizeMenuBalloonTier5Pg1;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageHelperGuiCustomizeMenuBalloonTier;
import com.viesis.viescraft.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayBlocksPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySymbolsPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbols;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColor;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColorUndo;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColor;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColorDefault;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameTransparent;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier2Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier3Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier4Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier5Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageHelperGuiCustomizeMenuFrameTier;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiCustomizeMenuCore;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiCustomizeMenuCore;
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
		
		register(MessageGuiMainMenu.class, MessageGuiMainMenu.class, Side.SERVER);
		register(MessageGuiMainMenuStorageLesser.class, MessageGuiMainMenuStorageLesser.class, Side.SERVER);
		register(MessageGuiMainMenuStorageNormal.class, MessageGuiMainMenuStorageNormal.class, Side.SERVER);
		register(MessageGuiMainMenuStorageGreater.class, MessageGuiMainMenuStorageGreater.class, Side.SERVER);
		register(MessageGuiMainMenuMusic.class, MessageGuiMainMenuMusic.class, Side.SERVER);
		
		register(MessageGuiUpgradeMenu.class, MessageGuiUpgradeMenu.class, Side.SERVER);
		register(MessageGuiCustomizeMenu.class, MessageGuiCustomizeMenu.class, Side.SERVER);
		register(MessageGuiModuleMenu.class, MessageGuiModuleMenu.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuChangeName.class, MessageGuiCustomizeMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuChangeName.class, MessageHelperGuiCustomizeMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuUndo.class, MessageHelperGuiCustomizeMenuUndo.class, Side.SERVER);
		register(MessageGuiCustomizeMenuOptionsRedstone.class, MessageGuiCustomizeMenuOptionsRedstone.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuOptionsRedstone.class, MessageHelperGuiCustomizeMenuOptionsRedstone.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuFrameMain.class, MessageGuiCustomizeMenuFrameMain.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameTransparent.class, MessageHelperGuiCustomizeMenuFrameTransparent.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameColor.class, MessageGuiCustomizeMenuFrameColor.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameColorUndo.class, MessageGuiCustomizeMenuFrameColorUndo.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameColor.class, MessageHelperGuiCustomizeMenuFrameColor.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameColorDefault.class, MessageHelperGuiCustomizeMenuFrameColorDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuFrameTier1Pg1.class, MessageGuiCustomizeMenuFrameTier1Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier1Pg2.class, MessageGuiCustomizeMenuFrameTier1Pg2.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier2Pg1.class, MessageGuiCustomizeMenuFrameTier2Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier3Pg1.class, MessageGuiCustomizeMenuFrameTier3Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier4Pg1.class, MessageGuiCustomizeMenuFrameTier4Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuFrameTier5Pg1.class, MessageGuiCustomizeMenuFrameTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuFrameTier.class, MessageHelperGuiCustomizeMenuFrameTier.class, Side.SERVER);
		
		
		
		register(MessageGuiCustomizeMenuEngineMain.class, MessageGuiCustomizeMenuEngineMain.class, Side.SERVER);
		register(MessageGuiCustomizeMenuEngineDisplaySymbolsPg1.class, MessageGuiCustomizeMenuEngineDisplaySymbolsPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbols.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbols.class, Side.SERVER);
		register(MessageGuiCustomizeMenuEngineDisplayBlocksPg1.class, MessageGuiCustomizeMenuEngineDisplayBlocksPg1.class, Side.SERVER);
		
		
		
		register(MessageGuiCustomizeMenuBalloonMain.class, MessageGuiCustomizeMenuBalloonMain.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonTransparent.class, MessageHelperGuiCustomizeMenuBalloonTransparent.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonColor.class, MessageGuiCustomizeMenuBalloonColor.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonColorUndo.class, MessageGuiCustomizeMenuBalloonColorUndo.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonColor.class, MessageHelperGuiCustomizeMenuBalloonColor.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonColorDefault.class, MessageHelperGuiCustomizeMenuBalloonColorDefault.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuBalloonTier1Pg1.class, MessageGuiCustomizeMenuBalloonTier1Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier1Pg2.class, MessageGuiCustomizeMenuBalloonTier1Pg2.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier2Pg1.class, MessageGuiCustomizeMenuBalloonTier2Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier3Pg1.class, MessageGuiCustomizeMenuBalloonTier3Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier4Pg1.class, MessageGuiCustomizeMenuBalloonTier4Pg1.class, Side.SERVER);
		register(MessageGuiCustomizeMenuBalloonTier5Pg1.class, MessageGuiCustomizeMenuBalloonTier5Pg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuBalloonTier.class, MessageHelperGuiCustomizeMenuBalloonTier.class, Side.SERVER);
		
		
		
		
		
		register(MessageHelperGuiUpgradeFrameVC.class, MessageHelperGuiUpgradeFrameVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeCoreVC.class, MessageHelperGuiUpgradeCoreVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeEngineVC.class, MessageHelperGuiUpgradeEngineVC.class, Side.SERVER);
		register(MessageHelperGuiUpgradeBalloonVC.class, MessageHelperGuiUpgradeBalloonVC.class, Side.SERVER);
		
		register(MessageGuiCustomizeMenuCore.class, MessageGuiCustomizeMenuCore.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuCore.class, MessageHelperGuiCustomizeMenuCore.class, Side.SERVER);
		
		
		
		
		
		
		
		
		
		register(MessageHelperGuiModuleLearn.class, MessageHelperGuiModuleLearn.class, Side.SERVER);
		register(MessageHelperGuiModuleToggleSlot1.class, MessageHelperGuiModuleToggleSlot1.class, Side.SERVER);
		
		register(MessageGuiPlayMusic.class, MessageGuiPlayMusic.class, Side.SERVER);
		register(MessageGuiPlayMusicArea.class, MessageGuiPlayMusicArea.class, Side.CLIENT);
		register(MessageGuiRandomMusic.class, MessageGuiRandomMusic.class, Side.SERVER);
		register(MessageGuiStopMusic.class, MessageGuiStopMusic.class, Side.SERVER);
		register(MessageGuiStopMusicArea.class, MessageGuiStopMusicArea.class, Side.CLIENT);
		
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
