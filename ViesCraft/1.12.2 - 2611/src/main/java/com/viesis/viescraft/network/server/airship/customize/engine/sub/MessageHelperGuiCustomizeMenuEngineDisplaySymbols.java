package com.viesis.viescraft.network.server.airship.customize.engine.sub;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplaySymbols extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplaySymbols> {
	
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
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbols message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbols message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& message.metaDisplayID != 0
		&& message.metaDisplayID != airship.engineDisplayIDVisual)
		{
			airship.engineDisplayIDVisual = message.metaDisplayID;
			airship.storedRedstone = airship.storedRedstone - CostsVC.ENGINE_DISPLAY_SYMBOL_COST;
		}
		
		if(message.metaDisplayID == 0)
		{
			airship.engineDisplayIDVisual = message.metaDisplayID;
		}
	}
}
