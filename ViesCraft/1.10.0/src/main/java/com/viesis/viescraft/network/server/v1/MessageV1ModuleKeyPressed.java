package com.viesis.viescraft.network.server.v1;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageV1ModuleKeyPressed extends MessageBase<MessageV1ModuleKeyPressed> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		//EntityAirshipV1Core.moduleKeyPressed = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageV1ModuleKeyPressed message, EntityPlayer player) 
	{
		//EntityAirshipV1Core.moduleKeyPressed = true;
	}
	
	@Override
	public void handleServerSide(MessageV1ModuleKeyPressed message, EntityPlayer player) 
	{
		
		EntityAirshipV1Core.moduleKeyPressed = true;
		//player.openGui(ViesCraft.instance, GuiHandler.GUI_V1_DEFAULT, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
