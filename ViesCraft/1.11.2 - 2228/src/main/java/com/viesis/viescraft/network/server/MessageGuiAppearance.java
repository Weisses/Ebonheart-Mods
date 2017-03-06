package com.viesis.viescraft.network.server;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1Appearance;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiAppearance extends MessageBase<MessageGuiAppearance> {
	
	private int metaFrame;
	private boolean metaFrameActive;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		metaFrameActive = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiEntityAirshipV1Appearance.metaInfo);
		buf.writeBoolean(GuiEntityAirshipV1Appearance.metaActiveInfo);
	}
	
	@Override
	public void handleClientSide(MessageGuiAppearance message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiAppearance message, EntityPlayer player) 
	{
		EntityAirshipV1Core airship = (EntityAirshipV1Core) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
		airship.frameVisualActive = message.metaFrameActive;
	}
}
