package com.viesis.viescraft.network.server.airship.customize.frame;

import com.viesis.viescraft.client.gui.airship.main.GuiCustomizeMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuFrameColorUndo extends MessageBase<MessageGuiCustomizeMenuFrameColorUndo> {
	
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuFrameColorUndo message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuFrameColorUndo message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.frameSkinColorRed = 255;
		airship.frameSkinColorGreen = 255;
		airship.frameSkinColorBlue = 255;
	}
}
