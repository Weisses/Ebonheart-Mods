package com.viesis.viescraft.network.server.airship.customize.engine.sub;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplaySymbol extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplaySymbol> {
	
	private int metaDisplayID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayID = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbol message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbol message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.engineDisplayTypeVisual = 0;
		airship.engineDisplayItemstackVisual = 0;
		airship.engineDisplayItemstackMetaVisual = 0;
		airship.engineDisplayHeadVisual = 0;
		airship.engineDisplaySupporterHeadVisual = 0;
		airship.engineDisplayHolidayVisual = 0;
		
		/**
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& message.metaDisplayID != 0
		&& message.metaDisplayID != airship.engineDisplayIDVisual)
		{
			airship.engineDisplayTypeVisual = 1;
			airship.engineDisplayIDVisual = message.metaDisplayID;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
		
		if(message.metaDisplayID == 0)
		{
			airship.engineDisplayTypeVisual = 0;
			airship.engineDisplayIDVisual = 0;
		}
		*/
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& message.metaDisplayID != 0
		&& message.metaDisplayID != airship.engineDisplayTypeVisual)
		{
			airship.engineDisplayTypeVisual = message.metaDisplayID;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
		
		if(message.metaDisplayID == 0)
		{
			airship.engineDisplayTypeVisual = 0;
		}
	}
}
