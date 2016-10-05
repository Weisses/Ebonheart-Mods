package com.viesis.viescraft.network.server.v3;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageGuiV3ModuleInventoryLarge extends MessageBase<MessageGuiV3ModuleInventoryLarge> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiV3ModuleInventoryLarge message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV3ModuleInventoryLarge message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_V3_MODULE_INVENTORY_LARGE, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
