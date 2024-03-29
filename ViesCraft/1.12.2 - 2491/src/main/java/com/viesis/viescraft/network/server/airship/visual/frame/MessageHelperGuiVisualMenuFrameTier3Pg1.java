package com.viesis.viescraft.network.server.airship.visual.frame;

import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameTier3Pg1;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuFrameTier3Pg1 extends MessageBase<MessageHelperGuiVisualMenuFrameTier3Pg1> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuFrameTier3Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuFrameTier3Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuFrameTier3Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
	}
}
