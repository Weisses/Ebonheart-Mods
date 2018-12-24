package com.vies.viesmachines.network.client;

import com.vies.viesmachines.configs.VMConfiguration;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageConfig extends MessageBase<MessageConfig> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		//ViesCraftConfig.v1AirshipSpeed = buf.readInt();
		//ViesCraftConfig.v2AirshipSpeed = buf.readInt();
		//ViesCraftConfig.v3AirshipSpeed = buf.readInt();
		//ViesCraftConfig.v4AirshipSpeed = buf.readInt();
		//ViesCraftConfig.v5AirshipSpeed = buf.readInt();
		//ViesCraftConfig.v6AirshipSpeed = buf.readInt();

		VMConfiguration.machineHardmode = buf.readBoolean();
		
		VMConfiguration.machinePelletsBurnTime = buf.readInt();
		VMConfiguration.vanillaFuel = buf.readBoolean();
		VMConfiguration.outsideModFuel = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		//buf.writeInt(ViesCraftConfig.v1AirshipSpeed);
		//buf.writeInt(ViesCraftConfig.v2AirshipSpeed);
		//buf.writeInt(ViesCraftConfig.v3AirshipSpeed);
		//buf.writeInt(ViesCraftConfig.v4AirshipSpeed);
		//buf.writeInt(ViesCraftConfig.v5AirshipSpeed);
		//buf.writeInt(ViesCraftConfig.v6AirshipSpeed);

		buf.writeBoolean(VMConfiguration.machineHardmode);
		
		buf.writeInt(VMConfiguration.machinePelletsBurnTime);
		buf.writeBoolean(VMConfiguration.vanillaFuel);
		buf.writeBoolean(VMConfiguration.outsideModFuel);
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
