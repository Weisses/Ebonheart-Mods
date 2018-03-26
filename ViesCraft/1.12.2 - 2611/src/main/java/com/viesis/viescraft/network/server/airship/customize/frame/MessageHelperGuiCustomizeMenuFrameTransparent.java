package com.viesis.viescraft.network.server.airship.customize.frame;

import com.viesis.viescraft.client.gui.airship.customize.frame.GuiCustomizeMenuFrameMain;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTransparent extends MessageBase<MessageHelperGuiCustomizeMenuFrameTransparent> {
	
	private boolean metaFrameTransparent;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrameTransparent = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiCustomizeMenuFrameMain.frameTransparentInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTransparent message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinTransparent = message.metaFrameTransparent;
	}
}
