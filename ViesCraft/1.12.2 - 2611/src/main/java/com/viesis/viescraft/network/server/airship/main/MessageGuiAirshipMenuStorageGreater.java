package com.viesis.viescraft.network.server.airship.main;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiAirshipMenuStorageGreater extends MessageBase<MessageGuiAirshipMenuStorageGreater> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiAirshipMenuStorageGreater message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiAirshipMenuStorageGreater message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_AIRSHIP_MENU_STORAGE_GREATER, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
