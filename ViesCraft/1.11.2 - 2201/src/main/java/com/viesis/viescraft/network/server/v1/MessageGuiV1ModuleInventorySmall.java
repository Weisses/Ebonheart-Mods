package com.viesis.viescraft.network.server.v1;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageGuiV1ModuleInventorySmall extends MessageBase<MessageGuiV1ModuleInventorySmall> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiV1ModuleInventorySmall message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiV1ModuleInventorySmall message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_V1_MODULE_INVENTORY_SMALL, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
