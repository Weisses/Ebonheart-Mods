package com.viesis.viescraft.network.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageConfig extends MessageBase<MessageConfig> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		ViesCraftConfig.fuelBurnTime = buf.readInt();
		ViesCraftConfig.airshipSpeed = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(ViesCraftConfig.fuelBurnTime);
		buf.writeInt(ViesCraftConfig.airshipSpeed);
	}
	
	@Override
	public void handleClientSide(MessageConfig message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageConfig message, EntityPlayer player) 
	{
		
	}
}
