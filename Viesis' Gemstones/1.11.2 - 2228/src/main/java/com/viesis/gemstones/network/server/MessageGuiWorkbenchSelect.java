package com.viesis.gemstones.network.server;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.util.LogHelper;
import com.viesis.gemstones.network.GuiHandler;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiWorkbenchSelect extends MessageBase<MessageGuiWorkbenchSelect> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSelect message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSelect message, EntityPlayer player) 
	{
		LogHelper.info("here2");
		player.openGui(ViesisGemstones.instance, GuiHandler.GUI_GEMSTONE_WORKBENCH_SELECT, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
