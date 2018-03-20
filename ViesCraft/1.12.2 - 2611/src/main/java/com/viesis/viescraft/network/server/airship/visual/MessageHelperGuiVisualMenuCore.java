package com.viesis.viescraft.network.server.airship.visual;

import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonColor;
import com.viesis.viescraft.client.gui.airship.visual.core.GuiVisualMenuCore;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuCore extends MessageBase<MessageHelperGuiVisualMenuCore> {
	
	private int metaCore;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaCore = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuCore.metaCore);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuCore message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuCore message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.coreModelVisualFrame = message.metaCore;
	}
}
