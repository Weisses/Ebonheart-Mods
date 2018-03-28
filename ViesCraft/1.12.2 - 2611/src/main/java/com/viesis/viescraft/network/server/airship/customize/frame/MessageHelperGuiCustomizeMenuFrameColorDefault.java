package com.viesis.viescraft.network.server.airship.customize.frame;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameColorDefault extends MessageBase<MessageHelperGuiCustomizeMenuFrameColorDefault> {
	
	private int metaFrameRed;
	private int metaFrameGreen;
	private int metaFrameBlue;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrameRed = buf.readInt();
		metaFrameGreen = buf.readInt();
		metaFrameBlue = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.textRedNumber);
		buf.writeInt(GuiContainerVC.textGreenNumber);
		buf.writeInt(GuiContainerVC.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameColorDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameColorDefault message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.frameSkinColorRed = message.metaFrameRed;
		airship.frameSkinColorGreen = message.metaFrameGreen;
		airship.frameSkinColorBlue = message.metaFrameBlue;
	}
}
