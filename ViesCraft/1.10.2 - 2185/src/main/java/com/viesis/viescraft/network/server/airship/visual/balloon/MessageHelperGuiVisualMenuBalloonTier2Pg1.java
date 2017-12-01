package com.viesis.viescraft.network.server.airship.visual.balloon;

import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier2Pg1;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuBalloonTier2Pg1 extends MessageBase<MessageHelperGuiVisualMenuBalloonTier2Pg1> {
	
	private int metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuBalloonTier2Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuBalloonTier2Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuBalloonTier2Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaBalloonVisual = message.metaBalloon;
	}
}
