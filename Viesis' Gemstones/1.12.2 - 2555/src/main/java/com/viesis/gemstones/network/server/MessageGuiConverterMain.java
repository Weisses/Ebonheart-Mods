package com.viesis.gemstones.network.server;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.network.GuiHandler;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiConverterMain extends MessageBase<MessageGuiConverterMain> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiConverterMain message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiConverterMain message, EntityPlayer player) 
	{
		player.openGui(ViesisGemstones.instance, GuiHandler.GUI_GEMSTONE_CONVERTER_MAIN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
