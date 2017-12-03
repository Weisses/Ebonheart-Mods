package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiModuleInventorySmall extends MessageBase<MessageGuiModuleInventorySmall> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiModuleInventorySmall message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiModuleInventorySmall message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_MODULE_INVENTORY_SMALL, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}