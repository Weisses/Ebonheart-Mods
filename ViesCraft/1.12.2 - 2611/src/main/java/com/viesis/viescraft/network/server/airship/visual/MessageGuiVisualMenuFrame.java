package com.viesis.viescraft.network.server.airship.visual;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiVisualMenuFrame extends MessageBase<MessageGuiVisualMenuFrame> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiVisualMenuFrame message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiVisualMenuFrame message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_APPEARANCE_MENU_FRAME, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
