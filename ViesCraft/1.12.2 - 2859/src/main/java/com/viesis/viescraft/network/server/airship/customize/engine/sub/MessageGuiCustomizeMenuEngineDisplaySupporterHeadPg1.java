package com.viesis.viescraft.network.server.airship.customize.engine.sub;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1 extends MessageBase<MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1 message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_APPEARANCE_MENU_ENGINE_SUPPORTER_HEADS, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
