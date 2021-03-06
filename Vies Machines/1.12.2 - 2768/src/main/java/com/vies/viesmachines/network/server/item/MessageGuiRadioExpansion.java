package com.vies.viesmachines.network.server.item;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.network.GuiHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiRadioExpansion extends MessageBase<MessageGuiRadioExpansion> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiRadioExpansion message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiRadioExpansion message, EntityPlayer player) 
	{
		player.openGui(ViesMachines.instance, GuiHandler.GUI_TOOL_RADIO_EXPANSION, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
