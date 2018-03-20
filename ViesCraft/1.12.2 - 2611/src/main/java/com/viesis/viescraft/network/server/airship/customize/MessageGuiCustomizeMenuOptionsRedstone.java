package com.viesis.viescraft.network.server.airship.customize;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuOptionsRedstone extends MessageBase<MessageGuiCustomizeMenuOptionsRedstone> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuOptionsRedstone message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuOptionsRedstone message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_CUSTOMIZE_MENU_OPTIONS_REDSTONE, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
