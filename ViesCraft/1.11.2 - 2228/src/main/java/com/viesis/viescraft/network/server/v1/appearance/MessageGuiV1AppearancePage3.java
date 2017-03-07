package com.viesis.viescraft.network.server.v1.appearance;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiV1AppearancePage3 extends MessageBase<MessageGuiV1AppearancePage3> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiV1AppearancePage3 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV1AppearancePage3 message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_V1_APPEARANCE_PAGE3, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
