package com.viesis.viescraft.network.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageGuiOpen extends MessageBase<MessageGuiOpen> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiOpen message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiOpen message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_AIRSHIP_INVENTORY, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}