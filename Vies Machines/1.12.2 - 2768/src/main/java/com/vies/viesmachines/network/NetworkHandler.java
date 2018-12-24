package com.vies.viesmachines.network;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.network.client.MessageConfig;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger01Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger02Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger04Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger05Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger11Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger12Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger13Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger21Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger22Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger23Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger31Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger32Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger33Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger41Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger42Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger43Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger51Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger52Client;
import com.vies.viesmachines.network.client.machine.eventtrigger.MessageHelperEventTrigger53Client;
import com.vies.viesmachines.network.client.tileentity.MessageGuiExtractorSyncClientOn;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientGem;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientOn;
import com.vies.viesmachines.network.server.item.MessageGuiRadioExpansion;
import com.vies.viesmachines.network.server.item.MessageHelperItemToolRadioExpansion;
import com.vies.viesmachines.network.server.machine.MessageFlyingThunderStrike;
import com.vies.viesmachines.network.server.machine.MessageMachineFlyingBombStandard;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger01Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger02Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger04Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger05Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger11Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger12Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger13Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger21Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger22Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger23Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger31Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger32Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger33Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger41Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger42Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger43Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger51Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger52Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger53Server;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageGuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageHelperGuiMachineMenuCustomizeActiveModelApply;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.MessageGuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayBlockItemPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySymbolPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItem;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayClear;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayHead;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbol;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayCreative;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayCreative;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayCreative;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageHelperGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageGuiMachineMenuCustomizePrimarySkinColor;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageGuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageGuiMachineMenuCustomizeSecondarySkinColor;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainArmed;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainAutorun;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainCompress;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainCompressClientAll;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainPowered;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameColor;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameUndo;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageGuiMachineMenuSelectProjectile;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletConsume;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletElectrical;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletExplosive;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletNormal;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageGuiMachineMenuSelectMusic;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMainRecordDefault;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicPlay;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicPlayArea;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicRandom;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicStop;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicStopArea;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete1;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete2;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete3;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete4;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete5;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete6;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete7;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect1;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect2;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect3;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect4;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect5;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect6;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect7;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuStats;
import com.vies.viesmachines.network.server.tileentity.MessageGuiExtractorSyncServerOn;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerGem;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerOn;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryColorSelected;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryTextureSelected;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryTransparentEnabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryColorSelected;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryTextureSelected;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryTransparentEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageAutorunDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageAutorunEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageMachineBroken;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageNameColor;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessagePoweredOnDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessagePoweredOnEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemError;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemOutOfAmmo;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionAlreadyKnown;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply1;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply2;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply3;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply4;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply5;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply6;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply7;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionFull;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionNoRecord;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAlreadyKnown;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier1;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier2;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier3;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeBroken;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeRequiredTier1;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeRequiredTier2;

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
		
		//----------//----------//----------//----------//----------//
		
		register(MessageGuiMachineMenuMain.class, MessageGuiMachineMenuMain.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainCompress.class, MessageHelperGuiMachineMenuMainCompress.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainCompressClientAll.class, MessageHelperGuiMachineMenuMainCompressClientAll.class, Side.CLIENT);
		register(MessageHelperGuiMachineMenuMainPowered.class, MessageHelperGuiMachineMenuMainPowered.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainAutorun.class, MessageHelperGuiMachineMenuMainAutorun.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuMainArmed.class, MessageHelperGuiMachineMenuMainArmed.class, Side.SERVER);
		
		register(MessageGuiMachineMenuSelectMusic.class, MessageGuiMachineMenuSelectMusic.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect1.class, MessageHelperGuiMachineMainRecordSelect1.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect2.class, MessageHelperGuiMachineMainRecordSelect2.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect3.class, MessageHelperGuiMachineMainRecordSelect3.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect4.class, MessageHelperGuiMachineMainRecordSelect4.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect5.class, MessageHelperGuiMachineMainRecordSelect5.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect6.class, MessageHelperGuiMachineMainRecordSelect6.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordSelect7.class, MessageHelperGuiMachineMainRecordSelect7.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete1.class, MessageHelperGuiMachineMainRecordDelete1.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete2.class, MessageHelperGuiMachineMainRecordDelete2.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete3.class, MessageHelperGuiMachineMainRecordDelete3.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete4.class, MessageHelperGuiMachineMainRecordDelete4.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete5.class, MessageHelperGuiMachineMainRecordDelete5.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete6.class, MessageHelperGuiMachineMainRecordDelete6.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDelete7.class, MessageHelperGuiMachineMainRecordDelete7.class, Side.SERVER);
		register(MessageHelperGuiMachineMainRecordDefault.class, MessageHelperGuiMachineMainRecordDefault.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMusicPlay.class, MessageHelperGuiMachineMusicPlay.class, Side.SERVER);
		register(MessageHelperGuiMachineMusicPlayArea.class, MessageHelperGuiMachineMusicPlayArea.class, Side.CLIENT);
		register(MessageHelperGuiMachineMusicStop.class, MessageHelperGuiMachineMusicStop.class, Side.SERVER);
		register(MessageHelperGuiMachineMusicStopArea.class, MessageHelperGuiMachineMusicStopArea.class, Side.CLIENT);
		register(MessageHelperGuiMachineMusicRandom.class, MessageHelperGuiMachineMusicRandom.class, Side.SERVER);
		
		register(MessageGuiMachineMenuChangeName.class, MessageGuiMachineMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuChangeName.class, MessageHelperGuiMachineMenuChangeName.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuChangeNameUndo.class, MessageHelperGuiMachineMenuChangeNameUndo.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuChangeNameColor.class, MessageHelperGuiMachineMenuChangeNameColor.class, Side.SERVER);
		
		register(MessageGuiMachineMenuSelectProjectile.class, MessageGuiMachineMenuSelectProjectile.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletConsume.class, MessageHelperGuiMachineMenuSelectProjectileBulletConsume.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletNormal.class, MessageHelperGuiMachineMenuSelectProjectileBulletNormal.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletElectrical.class, MessageHelperGuiMachineMenuSelectProjectileBulletElectrical.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuSelectProjectileBulletExplosive.class, MessageHelperGuiMachineMenuSelectProjectileBulletExplosive.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(MessageGuiMachineMenuStats.class, MessageGuiMachineMenuStats.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(MessageGuiMachineMenuCustomize.class, MessageGuiMachineMenuCustomize.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeActiveModels.class, MessageGuiMachineMenuCustomizeActiveModels.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, MessageHelperGuiMachineMenuCustomizeActiveModelApply.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplayBanner.class, MessageGuiMachineMenuCustomizeDisplayBanner.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayClear.class, MessageHelperGuiCustomizeMenuEngineDisplayClear.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbol.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayCreative.class, MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayCreative.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday.class, MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplayBlockItemPg1.class, MessageGuiMachineMenuCustomizeDisplayBlockItemPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, MessageHelperGuiCustomizeMenuEngineDisplayBlockItem.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplayHeadPg1.class, MessageGuiMachineMenuCustomizeDisplayHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplayHead.class, MessageHelperGuiCustomizeMenuEngineDisplayHead.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1.class, MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1.class, Side.SERVER);
		register(MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizePrimarySkinTexture.class, MessageGuiMachineMenuCustomizePrimarySkinTexture.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinTexture.class, MessageHelperGuiMachineMenuCustomizePrimarySkinTexture.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayCreative.class, MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayCreative.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizePrimarySkinColor.class, MessageGuiMachineMenuCustomizePrimarySkinColor.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply.class, MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault.class, MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuCustomizePrimaryTransparent.class, MessageHelperGuiMachineMenuCustomizePrimaryTransparent.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizePrimaryDefault.class, MessageHelperGuiMachineMenuCustomizePrimaryDefault.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeSecondarySkinTexture.class, MessageGuiMachineMenuCustomizeSecondarySkinTexture.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, Side.SERVER);
		register(MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayCreative.class, MessageGuiMachineMenuCustomizeSecondarySkinTextureHolidayCreative.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday.class, Side.SERVER);
		
		register(MessageGuiMachineMenuCustomizeSecondarySkinColor.class, MessageGuiMachineMenuCustomizeSecondarySkinColor.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault.class, MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault.class, Side.SERVER);
		
		register(MessageHelperGuiMachineMenuCustomizeSecondaryTransparent.class, MessageHelperGuiMachineMenuCustomizeSecondaryTransparent.class, Side.SERVER);
		register(MessageHelperGuiMachineMenuCustomizeSecondaryDefault.class, MessageHelperGuiMachineMenuCustomizeSecondaryDefault.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(MessageFlyingThunderStrike.class, MessageFlyingThunderStrike.class, Side.SERVER);
		register(MessageMachineFlyingBombStandard.class, MessageMachineFlyingBombStandard.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		
		register(MessageGuiExtractorSyncClientOn.class, MessageGuiExtractorSyncClientOn.class, Side.CLIENT);
		register(MessageGuiExtractorSyncServerOn.class, MessageGuiExtractorSyncServerOn.class, Side.SERVER);
		
		register(MessageGuiKitFabricatorSyncClientOn.class, MessageGuiKitFabricatorSyncClientOn.class, Side.CLIENT);
		register(MessageGuiKitFabricatorSyncServerOn.class, MessageGuiKitFabricatorSyncServerOn.class, Side.SERVER);
		register(MessageGuiKitFabricatorSyncClientGem.class, MessageGuiKitFabricatorSyncClientGem.class, Side.CLIENT);
		register(MessageGuiKitFabricatorSyncServerGem.class, MessageGuiKitFabricatorSyncServerGem.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(MessageGuiRadioExpansion.class, MessageGuiRadioExpansion.class, Side.SERVER);
		register(MessageHelperItemToolRadioExpansion.class, MessageHelperItemToolRadioExpansion.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(PlayerMessageMachineBroken.class, PlayerMessageMachineBroken.class, Side.SERVER);
		register(PlayerMessagePoweredOnEnabled.class, PlayerMessagePoweredOnEnabled.class, Side.SERVER);
		register(PlayerMessagePoweredOnDisabled.class, PlayerMessagePoweredOnDisabled.class, Side.SERVER);
		register(PlayerMessageWeaponSystemError.class, PlayerMessageWeaponSystemError.class, Side.SERVER);
		register(PlayerMessageWeaponSystemEnabled.class, PlayerMessageWeaponSystemEnabled.class, Side.SERVER);
		register(PlayerMessageWeaponSystemDisabled.class, PlayerMessageWeaponSystemDisabled.class, Side.SERVER);
		register(PlayerMessageWeaponSystemOutOfAmmo.class, PlayerMessageWeaponSystemOutOfAmmo.class, Side.SERVER);
		register(PlayerMessageAutorunEnabled.class, PlayerMessageAutorunEnabled.class, Side.SERVER);
		register(PlayerMessageAutorunDisabled.class, PlayerMessageAutorunDisabled.class, Side.SERVER);
		register(PlayerMessageNameColor.class, PlayerMessageNameColor.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryTextureSelected.class, PlayerMessageVisualPrimaryTextureSelected.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryColorSelected.class, PlayerMessageVisualPrimaryColorSelected.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryTransparentDisabled.class, PlayerMessageVisualPrimaryTransparentDisabled.class, Side.SERVER);
		register(PlayerMessageVisualPrimaryTransparentEnabled.class, PlayerMessageVisualPrimaryTransparentEnabled.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryTextureSelected.class, PlayerMessageVisualSecondaryTextureSelected.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryColorSelected.class, PlayerMessageVisualSecondaryColorSelected.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryTransparentDisabled.class, PlayerMessageVisualSecondaryTransparentDisabled.class, Side.SERVER);
		register(PlayerMessageVisualSecondaryTransparentEnabled.class, PlayerMessageVisualSecondaryTransparentEnabled.class, Side.SERVER);
		
		register(PlayerMessageToolRadioExpansionAlreadyKnown.class, PlayerMessageToolRadioExpansionAlreadyKnown.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionFull.class, PlayerMessageToolRadioExpansionFull.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionNoRecord.class, PlayerMessageToolRadioExpansionNoRecord.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply1.class, PlayerMessageToolRadioExpansionApply1.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply2.class, PlayerMessageToolRadioExpansionApply2.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply3.class, PlayerMessageToolRadioExpansionApply3.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply4.class, PlayerMessageToolRadioExpansionApply4.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply5.class, PlayerMessageToolRadioExpansionApply5.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply6.class, PlayerMessageToolRadioExpansionApply6.class, Side.SERVER);
		register(PlayerMessageToolRadioExpansionApply7.class, PlayerMessageToolRadioExpansionApply7.class, Side.SERVER);
		
		register(PlayerMessageUpgradeAlreadyKnown.class, PlayerMessageUpgradeAlreadyKnown.class, Side.SERVER);
		register(PlayerMessageUpgradeBroken.class, PlayerMessageUpgradeBroken.class, Side.SERVER);
		register(PlayerMessageUpgradeAppliedTier1.class, PlayerMessageUpgradeAppliedTier1.class, Side.SERVER);
		register(PlayerMessageUpgradeAppliedTier2.class, PlayerMessageUpgradeAppliedTier2.class, Side.SERVER);
		register(PlayerMessageUpgradeAppliedTier3.class, PlayerMessageUpgradeAppliedTier3.class, Side.SERVER);
		register(PlayerMessageUpgradeRequiredTier1.class, PlayerMessageUpgradeRequiredTier1.class, Side.SERVER);
		register(PlayerMessageUpgradeRequiredTier2.class, PlayerMessageUpgradeRequiredTier2.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		register(MessageHelperEventTrigger01Client.class, MessageHelperEventTrigger01Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger02Client.class, MessageHelperEventTrigger02Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger04Client.class, MessageHelperEventTrigger04Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger05Client.class, MessageHelperEventTrigger05Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger11Client.class, MessageHelperEventTrigger11Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger12Client.class, MessageHelperEventTrigger12Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger13Client.class, MessageHelperEventTrigger13Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger21Client.class, MessageHelperEventTrigger21Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger22Client.class, MessageHelperEventTrigger22Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger23Client.class, MessageHelperEventTrigger23Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger31Client.class, MessageHelperEventTrigger31Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger32Client.class, MessageHelperEventTrigger32Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger33Client.class, MessageHelperEventTrigger33Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger41Client.class, MessageHelperEventTrigger41Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger42Client.class, MessageHelperEventTrigger42Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger43Client.class, MessageHelperEventTrigger43Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger51Client.class, MessageHelperEventTrigger51Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger52Client.class, MessageHelperEventTrigger52Client.class, Side.CLIENT);
		register(MessageHelperEventTrigger53Client.class, MessageHelperEventTrigger53Client.class, Side.CLIENT);
		
		register(MessageHelperEventTrigger01Server.class, MessageHelperEventTrigger01Server.class, Side.SERVER);
		register(MessageHelperEventTrigger02Server.class, MessageHelperEventTrigger02Server.class, Side.SERVER);
		register(MessageHelperEventTrigger04Server.class, MessageHelperEventTrigger04Server.class, Side.SERVER);
		register(MessageHelperEventTrigger05Server.class, MessageHelperEventTrigger05Server.class, Side.SERVER);
		register(MessageHelperEventTrigger11Server.class, MessageHelperEventTrigger11Server.class, Side.SERVER);
		register(MessageHelperEventTrigger12Server.class, MessageHelperEventTrigger12Server.class, Side.SERVER);
		register(MessageHelperEventTrigger13Server.class, MessageHelperEventTrigger13Server.class, Side.SERVER);
		register(MessageHelperEventTrigger21Server.class, MessageHelperEventTrigger21Server.class, Side.SERVER);
		register(MessageHelperEventTrigger22Server.class, MessageHelperEventTrigger22Server.class, Side.SERVER);
		register(MessageHelperEventTrigger23Server.class, MessageHelperEventTrigger23Server.class, Side.SERVER);
		register(MessageHelperEventTrigger31Server.class, MessageHelperEventTrigger31Server.class, Side.SERVER);
		register(MessageHelperEventTrigger32Server.class, MessageHelperEventTrigger32Server.class, Side.SERVER);
		register(MessageHelperEventTrigger33Server.class, MessageHelperEventTrigger33Server.class, Side.SERVER);
		register(MessageHelperEventTrigger41Server.class, MessageHelperEventTrigger41Server.class, Side.SERVER);
		register(MessageHelperEventTrigger42Server.class, MessageHelperEventTrigger42Server.class, Side.SERVER);
		register(MessageHelperEventTrigger43Server.class, MessageHelperEventTrigger43Server.class, Side.SERVER);
		register(MessageHelperEventTrigger51Server.class, MessageHelperEventTrigger51Server.class, Side.SERVER);
		register(MessageHelperEventTrigger52Server.class, MessageHelperEventTrigger52Server.class, Side.SERVER);
		register(MessageHelperEventTrigger53Server.class, MessageHelperEventTrigger53Server.class, Side.SERVER);
		
		//----------//----------//----------//----------//----------//
		
		
		
		//register(.class, .class, Side.SERVER);
		
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
