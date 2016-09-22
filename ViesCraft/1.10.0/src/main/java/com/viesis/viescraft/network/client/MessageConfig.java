package com.viesis.viescraft.network.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageConfig extends MessageBase<MessageConfig> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		ViesCraftConfig.v1FuelBurnTime = buf.readInt();
		ViesCraftConfig.v1AirshipSpeed = buf.readInt();
		
		ViesCraftConfig.v2FuelBurnTime = buf.readInt();
		ViesCraftConfig.v2AirshipSpeed = buf.readInt();
		
		ViesCraftConfig.v3FuelBurnTime = buf.readInt();
		ViesCraftConfig.v3AirshipSpeed = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(ViesCraftConfig.v1FuelBurnTime);
		buf.writeInt(ViesCraftConfig.v1AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v2FuelBurnTime);
		buf.writeInt(ViesCraftConfig.v2AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v3FuelBurnTime);
		buf.writeInt(ViesCraftConfig.v3AirshipSpeed);
		
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
