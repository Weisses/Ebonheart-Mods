package com.viesis.viescraft.network.server.v1.appearance;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1AppearancePage4;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiV1AppearanceHelperPage4 extends MessageBase<MessageGuiV1AppearanceHelperPage4> {
	
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
		buf.writeInt(GuiEntityAirshipV1AppearancePage4.metaInfo);
		buf.writeBoolean(GuiEntityAirshipV1AppearancePage4.metaActiveInfo);
	}
	
	@Override
	public void handleClientSide(MessageGuiV1AppearanceHelperPage4 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV1AppearanceHelperPage4 message, EntityPlayer player) 
	{
		EntityAirshipV1Core airship = (EntityAirshipV1Core) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
		airship.frameVisualActive = message.metaFrameActive;
	}
}
