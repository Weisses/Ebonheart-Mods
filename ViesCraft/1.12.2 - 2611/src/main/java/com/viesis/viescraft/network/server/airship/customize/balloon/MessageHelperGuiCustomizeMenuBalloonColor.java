package com.viesis.viescraft.network.server.airship.customize.balloon;

import com.viesis.viescraft.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonColor extends MessageBase<MessageHelperGuiCustomizeMenuBalloonColor> {
	
	private int metaBalloonRed;
	private int metaBalloonGreen;
	private int metaBalloonBlue;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloonRed = buf.readInt();
		metaBalloonGreen = buf.readInt();
		metaBalloonBlue = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuBalloonColor.textRedNumber);
		buf.writeInt(GuiCustomizeMenuBalloonColor.textGreenNumber);
		buf.writeInt(GuiCustomizeMenuBalloonColor.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonColor message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.balloonPatternColorRed = message.metaBalloonRed;
		airship.balloonPatternColorGreen = message.metaBalloonGreen;
		airship.balloonPatternColorBlue = message.metaBalloonBlue;
	}
}
