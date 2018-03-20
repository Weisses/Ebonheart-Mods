package com.viesis.viescraft.network.server.airship.visual;

import com.viesis.viescraft.client.gui.airship.main.GuiCustomizeMenu;
import com.viesis.viescraft.client.gui.airship.visual.frame.GuiVisualMenuFrameColor;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuFrameColor extends MessageBase<MessageHelperGuiVisualMenuFrameColor> {
	
	private int metaFrameRed;
	private int metaFrameGreen;
	private int metaFrameBlue;
	private boolean metaFrameColor;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrameRed = buf.readInt();
		metaFrameGreen = buf.readInt();
		metaFrameBlue = buf.readInt();
		metaFrameColor = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiVisualMenuFrameColor.textRedNumber);
		buf.writeInt(GuiVisualMenuFrameColor.textGreenNumber);
		buf.writeInt(GuiVisualMenuFrameColor.textBlueNumber);
		buf.writeBoolean(GuiVisualMenuFrameColor.isColored);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuFrameColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuFrameColor message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinColorRed = message.metaFrameRed;
		airship.frameSkinColorGreen = message.metaFrameGreen;
		airship.frameSkinColorBlue = message.metaFrameBlue;
		
		airship.frameSkinVisualColor = message.metaFrameColor;
	}
}
