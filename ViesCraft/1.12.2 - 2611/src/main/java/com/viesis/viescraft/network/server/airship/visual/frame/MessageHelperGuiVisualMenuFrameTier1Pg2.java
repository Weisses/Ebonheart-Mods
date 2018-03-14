package com.viesis.viescraft.network.server.airship.visual.frame;

import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier1Pg2;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuFrameTier1Pg2 extends MessageBase<MessageHelperGuiVisualMenuFrameTier1Pg2> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuFrameTier1Pg2.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuFrameTier1Pg2 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuFrameTier1Pg2 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
	}
}
