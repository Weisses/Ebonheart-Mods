package com.viesis.viescraft.network.server.airship.customize.frame.sub;

import com.viesis.viescraft.client.gui.airship.customize.frame.sub.GuiCustomizeMenuFrameTier5Pg1;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTier5Pg1 extends MessageBase<MessageHelperGuiCustomizeMenuFrameTier5Pg1> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuFrameTier5Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTier5Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTier5Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinTexture = message.metaFrame;
	}
}
