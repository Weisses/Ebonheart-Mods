package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiModule extends MessageBase<MessageGuiModule> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiModule message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiModule message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_MODULE, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
