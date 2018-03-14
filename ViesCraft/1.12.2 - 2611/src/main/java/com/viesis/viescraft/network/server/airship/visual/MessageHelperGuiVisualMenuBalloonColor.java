package com.viesis.viescraft.network.server.airship.visual;

import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonColor;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuBalloonColor extends MessageBase<MessageHelperGuiVisualMenuBalloonColor> {
	
	private int metaBalloonRed;
	private int metaBalloonGreen;
	private int metaBalloonBlue;
	private boolean metaBalloonColor;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloonRed = buf.readInt();
		metaBalloonGreen = buf.readInt();
		metaBalloonBlue = buf.readInt();
		metaBalloonColor = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuBalloonColor.textRedNumber);
		buf.writeInt(GuiVisualMenuBalloonColor.textGreenNumber);
		buf.writeInt(GuiVisualMenuBalloonColor.textBlueNumber);
		buf.writeBoolean(GuiVisualMenuBalloonColor.isColored);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuBalloonColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuBalloonColor message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaBalloonColorRed = message.metaBalloonRed;
		airship.metaBalloonColorGreen = message.metaBalloonGreen;
		airship.metaBalloonColorBlue = message.metaBalloonBlue;
		
		airship.metaBalloonVisualColor = message.metaBalloonColor;
	}
}
