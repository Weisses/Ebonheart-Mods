package com.viesis.viescraft.network.server.v1.appearance;

import com.viesis.viescraft.client.gui.v1.GuiEntityAirshipV1AppearancePage2;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiV1AppearanceHelperPage2 extends MessageBase<MessageGuiV1AppearanceHelperPage2> {
	
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
		buf.writeInt(GuiEntityAirshipV1AppearancePage2.metaInfo);
		buf.writeBoolean(GuiEntityAirshipV1AppearancePage2.metaActiveInfo);
	}
	
	@Override
	public void handleClientSide(MessageGuiV1AppearanceHelperPage2 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV1AppearanceHelperPage2 message, EntityPlayer player) 
	{
		EntityAirshipV1Core airship = (EntityAirshipV1Core) player.getRidingEntity();
		airship.metaFrameVisual = message.metaFrame;
		airship.frameVisualActive = message.metaFrameActive;
	}
}
