package com.viesis.viescraft.network.server.appearance;

import com.viesis.viescraft.client.gui.airship.frames.GuiAirshipAppearancePg5;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiAppearanceHelperPage5 extends MessageBase<MessageGuiAppearanceHelperPage5> {
	
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
		buf.writeInt(GuiAirshipAppearancePg5.metaInfo);
		buf.writeBoolean(GuiAirshipAppearancePg5.metaActiveInfo);
	}
	
	@Override
	public void handleClientSide(MessageGuiAppearanceHelperPage5 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiAppearanceHelperPage5 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
		airship.frameVisualActive = message.metaFrameActive;
	}
}
