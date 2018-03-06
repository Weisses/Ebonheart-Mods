package com.viesis.viescraft.network.client;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageConfig extends MessageBase<MessageConfig> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		ViesCraftConfig.v1AirshipSpeed = buf.readInt();
		ViesCraftConfig.v2AirshipSpeed = buf.readInt();
		ViesCraftConfig.v3AirshipSpeed = buf.readInt();
		ViesCraftConfig.v4AirshipSpeed = buf.readInt();
		ViesCraftConfig.v5AirshipSpeed = buf.readInt();
		ViesCraftConfig.v6AirshipSpeed = buf.readInt();
		
		ViesCraftConfig.viesolineBurnTime = buf.readInt();
		ViesCraftConfig.vanillaFuel = buf.readBoolean();
		ViesCraftConfig.outsideModFuel = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(ViesCraftConfig.v1AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v2AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v3AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v4AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v5AirshipSpeed);
		buf.writeInt(ViesCraftConfig.v6AirshipSpeed);
		
		buf.writeInt(ViesCraftConfig.viesolineBurnTime);
		buf.writeBoolean(ViesCraftConfig.vanillaFuel);
		buf.writeBoolean(ViesCraftConfig.outsideModFuel);
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
