package com.viesis.viescraft.network.server.airship.customize.balloon;

import com.viesis.viescraft.client.gui.airship.main.GuiCustomizeMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuBalloonColorUndo extends MessageBase<MessageGuiCustomizeMenuBalloonColorUndo> {
	
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuBalloonColorUndo message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuBalloonColorUndo message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.frameSkinColorRed = 200;
		airship.frameSkinColorGreen = 180;
		airship.frameSkinColorBlue = 140;
	}
}
