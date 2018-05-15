package com.viesis.viescraft.network.server.airship.customize.engine.sub;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayBlockItem extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayBlockItem> {
	
	private int metaDisplayItemstack;
	private int metaDisplayItemstackMeta;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayItemstack = buf.readInt();
		metaDisplayItemstackMeta = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.itemstackInfo);
		buf.writeInt(GuiContainerVC.itemstackMetaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.engineDisplayTypeVisual = 0;
		airship.engineDisplayItemstackVisual = 0;
		airship.engineDisplayItemstackMetaVisual = 0;
		airship.engineDisplayHeadVisual = 0;
		airship.engineDisplaySupporterHeadVisual = 0;
		airship.engineDisplayHolidayVisual = 0;
		
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		//&& message.metaDisplayItemstack != 0
		//&& message.metaDisplayItemstack != airship.engineDisplayItemstackVisual
		//&& message.metaDisplayItemstackMeta != airship.engineDisplayItemstackMetaVisual
				)
		{
			airship.engineDisplayTypeVisual = 1;
			airship.engineDisplayItemstackVisual = message.metaDisplayItemstack;
			airship.engineDisplayItemstackMetaVisual = message.metaDisplayItemstackMeta;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
	}
}
