package com.viesis.viescraft.network.server.v1;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiV1Default extends MessageBase<MessageGuiV1Default> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiV1Default message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV1Default message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_V1_DEFAULT, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
