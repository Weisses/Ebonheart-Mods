package com.viesis.viescraft.network.server.airship.customize;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenu extends MessageBase<MessageGuiCustomizeMenu> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenu message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenu message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_CUSTOMIZE_MENU, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
