package com.viesis.viescraft.network.server.airship.customize.core;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuCoreMain extends MessageBase<MessageGuiCustomizeMenuCoreMain> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuCoreMain message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuCoreMain message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_APPEARANCE_MENU_CORE_MAIN, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
